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

import models.UsuarioVagas;
import services.UsuarioServices;
import util.ResponseUtil;

/**
 * Servlet implementation class UsuarioVagasServlet
 */
public class UsuarioVagasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioServices services = new UsuarioServices();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioVagasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<UsuarioVagas> vagasDosUsuarios = new ArrayList<>();
		vagasDosUsuarios = services.getVagasDoUsuario();
		
		Gson gson = new Gson();
		String vagasDosUsuariosJSON = gson.toJson(vagasDosUsuarios);
		
		new ResponseUtil().outputResponse(response, vagasDosUsuariosJSON, 200);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reqBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		Gson gson = new Gson();
		
		UsuarioVagas vagaDoUsuario = (UsuarioVagas) gson.fromJson(reqBody, UsuarioVagas.class);
		boolean success = services.saveUsuarioVagas(vagaDoUsuario);
		
		new ResponseUtil().outputResponse(response, "{ \"success\": "+ success +" }", success?201:400);
	}

}
