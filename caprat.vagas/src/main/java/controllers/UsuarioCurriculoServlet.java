package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import models.UsuarioCurriculo;
import services.UsuarioServices;
import util.ResponseUtil;

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
		
		new ResponseUtil().outputResponse(response, curriculosJSON, 200);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		Gson gson = new Gson();
		
		UsuarioCurriculo curriculo = (UsuarioCurriculo) gson.fromJson(reqBody, UsuarioCurriculo.class);
		boolean success = services.saveCurriculo(curriculo);
		
		new ResponseUtil().outputResponse(response, "{ \"success\": "+ success +" }", success?201:400);
	}

}
