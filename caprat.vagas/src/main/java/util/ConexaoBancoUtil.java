package util;

import database.DBQuery;

public class ConexaoBancoUtil {
	
	public DBQuery iniciarConexao(String nomeTabela, String campos, String chavePrimaria) {
		return new DBQuery(nomeTabela, campos,  chavePrimaria);
	}
	
}
