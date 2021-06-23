package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import models.UsuarioCurriculo;
import models.UsuarioLogin;
import models.views.UsuarioLoginCurriculoView;
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
		List<UsuarioLoginCurriculoView> curriculos = new ArrayList<>();
		String idUsuario= request.getParameter("id");
		int userLogged = 0;
		
		if(idUsuario.equals("")) {
			HttpSession ses = request.getSession();
			userLogged = (int) ses.getAttribute("userLogin");
		}else {
			userLogged = Integer.parseInt(idUsuario);
		}
		
		curriculos = services.getCurriculos(userLogged);
		
		Gson gson = new Gson();
		String curriculosJSON = gson.toJson(curriculos);
		
		new ResponseUtil().outputResponse(response, curriculosJSON, 200);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String curriculoDados = request.getParameter("curriculo");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		UsuarioLogin loginDados = new UsuarioLogin();
		HttpSession ses = request.getSession();
		int userLogged = (int) ses.getAttribute("userLogin");
		
		Gson gson = new Gson();
		
		UsuarioCurriculo curriculo = (UsuarioCurriculo) gson.fromJson(curriculoDados, UsuarioCurriculo.class);
		boolean success = services.saveCurriculo(curriculo);
		
		if(email != null && senha != null) {
			loginDados = services.getLoginUsuarios(userLogged);
			loginDados.setEmailUsuario(email);
			loginDados.setSenhaUsuario(senha);
			success = services.saveLogin(loginDados);
		}
		
		new ResponseUtil().outputResponse(response, "{ \"success\": "+ success +" }", 201);
	}

}
