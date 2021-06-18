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
		String idVaga = request.getParameter("id");
		
		String filtroExperiencia = request.getParameter("experiencia");
		String filtroRegiao = request.getParameter("regiao");
		String filtroFaixaSalarial = request.getParameter("faixa");
		String filtroBusca = request.getParameter("busca");
		
		if(idVaga == null)
			vagas = services.getVagas(filtroExperiencia, filtroRegiao, filtroFaixaSalarial, filtroBusca);
		else
			vagas = services.getVagas(idVaga);
		
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
		int idUsuarioLogado = (int) request.getSession().getAttribute("userLogin");
		
		EmpresaVagas vaga = (EmpresaVagas) gson.fromJson(reqBody, EmpresaVagas.class);
		vaga.setIdEmpresa(services.getEmpresa(idUsuarioLogado).getIdEmpresa());
		
		boolean success = services.saveVaga(vaga);
		
		new ResponseUtil().outputResponse(response, "{ \"success\": \""+ success +"\" }", success?201:400);
	}

}
