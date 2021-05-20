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

import models.EmpresaVagas;
import services.EmpresaServices;
import util.ResponseUtil;

/**
 * Servlet implementation class EmpresaVagasServlet
 */
public class EmpresaVagasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpresaServices services = new EmpresaServices();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpresaVagasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<EmpresaVagas> vagas = new ArrayList<>();
		String filtroTitulo = request.getParameter("titulo");
		String filtroLocal = request.getParameter("local");
		String filtroExp = request.getParameter("experiencia");
		
		vagas = services.getVagas(filtroTitulo, filtroLocal, filtroExp);
		
		Gson gson = new Gson();
		String vagasJSON = gson.toJson(vagas);
		
		new ResponseUtil().outputResponse(response, vagasJSON, 200);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		Gson gson = new Gson();
		
		EmpresaVagas vaga = (EmpresaVagas) gson.fromJson(reqBody, EmpresaVagas.class);
		boolean success = services.saveVaga(vaga);
		
		new ResponseUtil().outputResponse(response, "{ \"success\": \""+ success +"\" }", success?201:400);
	}

}
