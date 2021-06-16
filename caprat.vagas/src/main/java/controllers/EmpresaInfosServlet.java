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

import models.EmpresaInfos;
import services.EmpresaServices;
import util.ResponseUtil;

/**
 * Servlet implementation class EmpresaInfosServlet
 */
public class EmpresaInfosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpresaServices services = new EmpresaServices();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpresaInfosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<EmpresaInfos> empresas = new ArrayList<>();
		empresas = services.getEmpresas();
		
		Gson gson = new Gson();
		String curriculosJSON = gson.toJson(empresas);
		
		new ResponseUtil().outputResponse(response, curriculosJSON, 200);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		Gson gson = new Gson();
		
		EmpresaInfos empresa = (EmpresaInfos) gson.fromJson(reqBody, EmpresaInfos.class);
		boolean success = services.saveEmpresa(empresa);
				
		new ResponseUtil().outputResponse(response, "{ \"success\": "+ success +" }", 201);
	}

}
