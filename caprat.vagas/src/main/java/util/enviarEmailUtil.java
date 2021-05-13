package util;

import mail.SendMail;
import models.UsuarioLogin;

public class enviarEmailUtil {
	public void enviarEmailCadastro(UsuarioLogin dadosLogin) {
		String htmlEmail = "<h1> Vlw por se cadastrar na moral </h1>"
				+ "<h2> Seriao, tamo junto "+ dadosLogin.getEmailUsuario() +" </h2>";
		
		this.enviarEmail(dadosLogin.getEmailUsuario(), htmlEmail);
	}
	
	private void enviarEmail(String emailPara, String htmlEmail) {
		
		String smtpHost 	= "smtp.gmail.com"; 
		String smtpPort 	= "587"; 
		String username 	= "capratofficial@gmail.com";
		String password 	= "PWH0j*N^LL&Uoxu";
		String auth     	= "tls";  
		SendMail sendMail 	=  new SendMail( smtpHost,  smtpPort,  username,  password,  auth  );
		
		String mailFrom 	= "capratofficial@gmail.com"; 
	 	String mailTo 		= emailPara; 
	 	String mailSubject 	= "Criação de conta bem sucessedida!"; 
	 	String mailBody 	= htmlEmail; 
		sendMail.send( mailFrom, mailTo, mailSubject, mailBody );
	}
}
