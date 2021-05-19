package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import models.UsuarioLogin;
import services.UsuarioServices;
import util.ResponseUtil;
import util.EnviarEmailUtil;
import util.RandomStringUtil;

/**
 * Servlet implementation class UsuarioLoginServlet
 */
public class UsuarioLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioServices services = new UsuarioServices();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UsuarioLogin> logins = new ArrayList<>();
		String emailUsuario = request.getParameter("emailUsuario");
		String senhaUsuario = request.getParameter("senhaUsuario");
		logins = services.getLoginUsuarios(emailUsuario, senhaUsuario);
		
		String loginJSON = "{ \"success\": \"false\" }";
		if(!logins.isEmpty()) {
			
			loginJSON = "{ \"success\": \"true\" }";
		}
		
		System.out.println("\n\n\n"+loginJSON+"\n\n\n");
		new ResponseUtil().outputResponse(response, loginJSON, 200);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		Gson gson = new Gson();
		
		UsuarioLogin dadosLogin = (UsuarioLogin) gson.fromJson(reqBody, UsuarioLogin.class);
		dadosLogin.setSenhaUsuario(new RandomStringUtil().generate(18));
		boolean success = services.saveLogin(dadosLogin);
		
		if(success)
			new EnviarEmailUtil().enviarEmailCadastro(dadosLogin);
		
		new ResponseUtil().outputResponse(response, "{ \"success\": "+ success +" }", success?201:400);
	}

}
