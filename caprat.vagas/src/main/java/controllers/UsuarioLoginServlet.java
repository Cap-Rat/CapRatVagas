package controllers;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    
    //Usuário efetuando login
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioLogin login = null;
		HttpSession ses = request.getSession();
		ses.setAttribute("userLogin", 0);
		String emailUsuario = request.getParameter("emailUsuario");
		String senhaUsuario = request.getParameter("senhaUsuario");
		login = services.getLoginUsuarios(emailUsuario, senhaUsuario);
		
		String loginJSON = "{ \"success\": \"false\" }";
		if(login != null) {
			ses.setAttribute("userLogin", login.getIdUsuario());
			ses.setAttribute("userTipo", login.getTipoUsuario());
			boolean isCadastrado = services.isUsuarioCadastrado(login.getIdUsuario(), login.getTipoUsuario());
			loginJSON = "{ \"success\": \"true\", \"tipo\": \"" + login.getTipoUsuario() + "\", \"isCadastrado\": " + isCadastrado + " }";
		}
		
		new ResponseUtil().outputResponse(response, loginJSON, 200);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	//Criação de um novo usuário
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		Gson gson = new Gson();
		
		UsuarioLogin dadosCadastro = (UsuarioLogin) gson.fromJson(reqBody, UsuarioLogin.class);
		dadosCadastro.setSenhaUsuario(new RandomStringUtil().generate(18));
		boolean success = services.saveLogin(dadosCadastro);
		
		if(success) {
			if(dadosCadastro.getTipoUsuario() == 2)
				new EnviarEmailUtil().enviarEmailCadastroEmpresa(dadosCadastro);
				
			if(dadosCadastro.getTipoUsuario() == 3)
				new EnviarEmailUtil().enviarEmailCadastroCandidato(dadosCadastro);
		}
		
		new ResponseUtil().outputResponse(response, "{ \"success\": \""+ success +"\" }", 200);
	}

}
