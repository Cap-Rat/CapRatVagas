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
import models.UsuarioLogin;
import models.views.EmpresaLoginInfosView;
import services.EmpresaServices;
import services.UsuarioServices;
import util.ResponseUtil;

/**
 * Servlet implementation class EmpresaInfosServlet
 */
public class EmpresaInfosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpresaServices servicesE = new EmpresaServices();
	private UsuarioServices servicesU = new UsuarioServices();
       
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
		List<EmpresaLoginInfosView> empresas = new ArrayList<>();
		String idEmpresa = request.getParameter("id");
		
		if(idEmpresa.equals("")) {
			HttpSession ses = request.getSession();
			int userLogged = (int) ses.getAttribute("userLogin");
			
			empresas = servicesE.getEmpresas(userLogged);
		}else {
			empresas = servicesE.getEmpresas(idEmpresa);
		}
		
		Gson gson = new Gson();
		String curriculosJSON = gson.toJson(empresas);
		
		new ResponseUtil().outputResponse(response, curriculosJSON, 200);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String EmpresaDados = request.getParameter("empresa");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		UsuarioLogin loginDados = new UsuarioLogin();
		HttpSession ses = request.getSession();
		int userLogged = (int) ses.getAttribute("userLogin");
		
		Gson gson = new Gson();
		
		EmpresaInfos empresa = (EmpresaInfos) gson.fromJson(EmpresaDados, EmpresaInfos.class);
		boolean success = servicesE.saveEmpresa(empresa);
		
		if(email != null && senha != null) {
			loginDados = servicesU.getLoginUsuarios(userLogged);
			loginDados.setEmailUsuario(email);
			loginDados.setSenhaUsuario(senha);
			success = servicesU.saveLogin(loginDados);
		}
				
		new ResponseUtil().outputResponse(response, "{ \"success\": "+ success +" }", 201);
	}

}
