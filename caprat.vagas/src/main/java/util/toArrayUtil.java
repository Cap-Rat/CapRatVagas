package util;

import models.EmpresaVagas;
import models.UsuarioCurriculo;
import models.UsuarioLogin;
import models.UsuarioVagas;

public class toArrayUtil {
	
	public String[] toArray(UsuarioCurriculo curriculo) {
		return (
				new String[] {
						""+curriculo.getIdCurriculo(),
						""+curriculo.getIdUsuario(),
						""+curriculo.getNomeUsuario(),
						""+curriculo.getNascimentoUsuario(),
						""+curriculo.getEnderecoUsuario(),
						""+curriculo.getCidadeUsuario(),
						""+curriculo.getEstadoUsuario(),
						""+curriculo.getEstadoCivilUsuario(),
						""+curriculo.getEscolaridadeUsuario(),
						""+curriculo.getDescricaoUsuario(),
						""+curriculo.getContatoUsuario(),
						""+curriculo.getCursosUsuario(),
						""+curriculo.getExpTrabUsuario(),
						""+curriculo.getFaixaSalarialUsuario()
				}
		); 
	}
	
	public String[] toArray(EmpresaVagas vaga) {
		return(
				new String [] {
						""+vaga.getIdVaga(),
						""+vaga.getIdEmpresa(),
						""+vaga.getTituloVaga(),
						""+vaga.getRequisitosVaga(),
						""+vaga.getDescricaoVaga(),
						""+vaga.getEstadoVaga(),
						""+vaga.getCidadeVaga(),
						""+vaga.getEnderecoVaga(),
						""+vaga.getSalarioVaga(),
						""+vaga.getNivelExpVaga()
				}
			);
	}
	
	public String[] toArray(UsuarioLogin dadosLoginUsuario) {
		return (
				new String[] {
					""+dadosLoginUsuario.getIdUsuario(),
					""+dadosLoginUsuario.getEmailUsuario(),
					""+dadosLoginUsuario.getSenhaUsuario(),
					""+dadosLoginUsuario.getTipoUsuario()
				}
 			);
	}
	
	
	public String[] toArray(UsuarioVagas vagasDoUsuario) {
		return (
				new String[] {
					""+vagasDoUsuario.getIdUsuario(),
					""+vagasDoUsuario.getIdVaga()
				}
 			);
	}
}
