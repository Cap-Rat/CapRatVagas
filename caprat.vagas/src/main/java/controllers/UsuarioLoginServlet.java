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
		logins = services.getLoginUsuarios();
		
		Gson gson = new Gson();
		String curriculosJSON = gson.toJson(logins);
		
		new ResponseUtil().outputResponse(response, curriculosJSON, 200);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		Gson gson = new Gson();
		
		UsuarioLogin curriculo = (UsuarioLogin) gson.fromJson(reqBody, UsuarioLogin.class);
		boolean success = services.saveLogin(curriculo);
		
		new ResponseUtil().outputResponse(response, "{ \"success\": "+ success +" }", success?201:400);
	}

}
