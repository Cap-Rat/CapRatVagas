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

import models.EmpresaVagas;
import models.UsuarioVagas;
import models.views.EmpresaInfosVagasView;
import services.EmpresaServices;
import services.UsuarioServices;
import util.ResponseUtil;

/**
 * Servlet implementation class UsuarioVagasServlet
 */
public class UsuarioVagasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioServices Uservices = new UsuarioServices();
	private EmpresaServices Eservices = new EmpresaServices();
       
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
		List<UsuarioVagas> vagasDoUsuario = new ArrayList<>();
		List<EmpresaInfosVagasView> dadosDasVagas = new ArrayList<>();
		
		HttpSession ses = request.getSession();
		int userLogged = (int) ses.getAttribute("userLogin");
		
		vagasDoUsuario = Uservices.getVagasDoUsuario(userLogged);
		dadosDasVagas = Eservices.getVagas(vagasDoUsuario);
		
		Gson gson = new Gson();
		String vagasDoUsuarioJSON = gson.toJson(dadosDasVagas);
		
		new ResponseUtil().outputResponse(response, vagasDoUsuarioJSON, 200);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reqBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		Gson gson = new Gson();
		
		UsuarioVagas vagaDoUsuario = (UsuarioVagas) gson.fromJson(reqBody, UsuarioVagas.class);
		boolean success = Uservices.saveUsuarioVagas(vagaDoUsuario);
		
		new ResponseUtil().outputResponse(response, "{ \"success\": "+ success +" }", 201);
	}

}
