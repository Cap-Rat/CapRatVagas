package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.UsuarioLogin;
import services.UsuarioServices;
import util.EnviarEmailUtil;
import util.RandomStringUtil;
import util.ResponseUtil;

/**
 * Servlet implementation class PassRecoverServlet
 */
public class PassRecoverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioServices service = new UsuarioServices();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassRecoverServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String emailUsuario = request.getParameter("emailUsuario");
		String apelidoUsuario = request.getParameter("apelidoUsuario");
		
		UsuarioLogin dadosUsuario = service.getUsuarioExistente(emailUsuario, apelidoUsuario);
		
		dadosUsuario.setSenhaUsuario(new RandomStringUtil().generate(18));
		
		boolean success = service.saveLogin(dadosUsuario);	
		
		if(success)
			new EnviarEmailUtil().enviarEmailRecuperacao(dadosUsuario);
		
		new ResponseUtil().outputResponse(response, "{ \"success\": \""+ success +"\" }", 201);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
