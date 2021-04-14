package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import java.util.List;
import java.util.ArrayList;
import models.UsuarioCurriculo;
import services.UsuarioServices;

/**
 * Servlet implementation class UsuarioCurriculoServlet
 */
public class UsuarioCurriculoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioServices services = new UsuarioServices();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioCurriculoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UsuarioCurriculo> curriculos = new ArrayList<>();
		curriculos = services.getCurriculos();
		
		Gson gson = new Gson();
		String curriculosJSON = gson.toJson(curriculos);
		
		PrintWriter writer = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		writer.write(curriculosJSON);
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
