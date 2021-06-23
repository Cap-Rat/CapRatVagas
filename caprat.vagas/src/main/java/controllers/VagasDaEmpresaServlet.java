package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import models.EmpresaInfos;
import models.EmpresaVagas;
import models.views.UsuarioVagasCurriculoView;
import services.EmpresaServices;
import services.UsuarioServices;
import util.ResponseUtil;

/**
 * Servlet implementation class VagasDaEmpresaServlet
 */
public class VagasDaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmpresaServices servicesE = new EmpresaServices();
    private UsuarioServices servicesU = new UsuarioServices();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VagasDaEmpresaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<EmpresaVagas> vagasList = new ArrayList<>();
		List<UsuarioVagasCurriculoView> usuariosCandidatosList = new ArrayList<>();
		HttpSession ses = request.getSession();
		int userLogged = (int) ses.getAttribute("userLogin");
		
		EmpresaInfos dadosDaEmpresaLogada = servicesE.getEmpresa(userLogged);
		vagasList = servicesE.getVagas(dadosDaEmpresaLogada);
		
		if(!vagasList.isEmpty()) {
			for(EmpresaVagas vg : vagasList) {
				usuariosCandidatosList.add(new UsuarioVagasCurriculoView(
						vg.getIdVaga(),
						vg.getIdEmpresa(),
						vg.getTituloVaga(),
						vg.getRequisitosVaga(),
						vg.getDescricaoVaga(),
						vg.getEstadoVaga(),
						vg.getCidadeVaga(),
						vg.getEnderecoVaga(),
						vg.getSalarioVaga(),
						vg.getNivelExpVaga()
				));
			}
			
			for(UsuarioVagasCurriculoView uv : usuariosCandidatosList) {
				uv.setUsuariosData(servicesU.getCandidatos(uv.getIdVaga()));
			}
		}
		
		Gson gson = new Gson();
		String candidatosJSON = gson.toJson(usuariosCandidatosList);
		
		new ResponseUtil().outputResponse(response, candidatosJSON, 200);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
