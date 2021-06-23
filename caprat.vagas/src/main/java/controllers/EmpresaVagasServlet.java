package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import models.EmpresaInfos;
import models.EmpresaVagas;
import models.views.EmpresaInfosVagasView;
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
		EmpresaInfosVagasView vaga = new EmpresaInfosVagasView();
		String idVaga = request.getParameter("id");
		
		String filtroExperiencia = request.getParameter("experiencia");
		String filtroRegiao = request.getParameter("regiao");
		String filtroFaixaSalarial = request.getParameter("faixa");
		String filtroBusca = request.getParameter("busca");
		
		String vagasJSON = "";
		Gson gson = new Gson();
		
		if(idVaga == null) {
			vagas = services.getVagas(filtroExperiencia, filtroRegiao, filtroFaixaSalarial, filtroBusca);
			vagasJSON = gson.toJson(vagas);
		}
		else {
			vaga = services.getVagasInfos(idVaga);
			vagasJSON = gson.toJson(vaga);
		}
		
		new ResponseUtil().outputResponse(response, vagasJSON, 200);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		Gson gson = new Gson();
		HttpSession ses = request.getSession();
		int userLogged = (int) ses.getAttribute("userLogin");
		boolean success = false;
		
		EmpresaVagas vaga = (EmpresaVagas) gson.fromJson(reqBody, EmpresaVagas.class);
		if(vaga.getIdEmpresa() == 0) {
			vaga.setIdEmpresa(services.getEmpresa(userLogged).getIdEmpresa());
			success = services.saveVaga(vaga);
		}
		else {
			int empresaLogadaID = services.getEmpresa(userLogged).getIdEmpresa();
			if(empresaLogadaID == vaga.getIdEmpresa()) {
				success = services.saveVaga(vaga);
			}
		}
		
		new ResponseUtil().outputResponse(response, "{ \"success\": \""+ success +"\" }", 201);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpresaInfos empresaLogada = new EmpresaInfos();
		EmpresaVagas vagaApagada = new EmpresaVagas();
		String reqBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		String idVaga = reqBody.split("=")[1];
		
		HttpSession ses = request.getSession();
		int userLogged = (int) ses.getAttribute("userLogin");
		
		empresaLogada = services.getEmpresa(userLogged);
		vagaApagada = services.getVagas(idVaga);
		
		boolean success = services.deleteVaga(vagaApagada, empresaLogada);
		
		new ResponseUtil().outputResponse(response, "{ \"success\": "+ success +" }", 201);
	}

}
