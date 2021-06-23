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
import services.EmpresaServices;
import util.ResponseUtil;

/**
 * Servlet implementation class VagasDaEmpresaServlet
 */
public class VagasDaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmpresaServices services = new EmpresaServices();   
	
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
		HttpSession ses = request.getSession();
		int userLogged = (int) ses.getAttribute("userLogin");
		
		EmpresaInfos dadosDaEmpresaLogada = services.getEmpresa(userLogged);
		vagasList = services.getVagas(dadosDaEmpresaLogada);
		
		Gson gson = new Gson();
		String vagasJSON = gson.toJson(vagasList);
		
		new ResponseUtil().outputResponse(response, vagasJSON, 200);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
