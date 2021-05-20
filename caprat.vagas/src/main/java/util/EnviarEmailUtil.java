package util;

import mail.SendMail;
import models.UsuarioLogin;

public class EnviarEmailUtil {
	
	public void enviarEmailRecuperacao(UsuarioLogin dadosUsuario) {
		String htmlEmail = "<!DOCTYPE html>\r\n" + 
				"<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\r\n" + 
				"  <head>\r\n" + 
				"    <meta http-equiv=\"Content-Type\" content=\"text/html charset=UTF-8\">\r\n" + 
				" <!-- utf-8 works for most cases -->\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width\">\r\n" + 
				" <!-- Forcing initial-scale shouldn't be necessary -->\r\n" + 
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
				" <!-- Use the latest (edge) version of IE rendering engine -->\r\n" + 
				"    <meta name=\"x-apple-disable-message-reformatting\">\r\n" + 
				" <!-- Disable auto-scale in iOS 10 Mail entirely -->\r\n" + 
				"    <title>Welcome to CapRat</title>\r\n" + 
				" <!-- The title tag shows in email notifications, like Android 4.4. -->\r\n" + 
				"\r\n" + 
				"    <!-- Web Font / @font-face : BEGIN -->\r\n" + 
				"\r\n" + 
				"    <!--[if !mso]>\r\n" + 
				"<!-- -->\r\n" + 
				"    <link href=\"https://fonts.googleapis.com/css?family=Oswald&display=swap\" rel=\"stylesheet\">\r\n" + 
				"\r\n" + 
				"    <!--<![endif]-->\r\n" + 
				"    <style>\r\n" + 
				"      html,\r\n" + 
				"      body {\r\n" + 
				"        margin: 0 auto !important;\r\n" + 
				"        padding: 0 !important;\r\n" + 
				"        height: 100% !important;\r\n" + 
				"        width: 100% !important;\r\n" + 
				"      }\r\n" + 
				"      * {\r\n" + 
				"        -ms-text-size-adjust: 100%;\r\n" + 
				"        -webkit-text-size-adjust: 100%;\r\n" + 
				"      }\r\n" + 
				"      .logo{\r\n" + 
				"        position:relative;\r\n" + 
				"        font-size: 1.5rem;\r\n" + 
				"        color:#FEFFF7;\r\n" + 
				"        text-decoration: none;\r\n" + 
				"        font-weight: 400;\r\n" + 
				"        font-family: 'Arial';\r\n" + 
				"        }\r\n" + 
				"      .logo span{\r\n" + 
				"            font-weight: 600;\r\n" + 
				"        }"+
				"      div[style*=\"margin: 16px 0\"] {\r\n" + 
				"        margin: 0 !important;\r\n" + 
				"      }\r\n" + 
				"      table,\r\n" + 
				"      td {\r\n" + 
				"        mso-table-lspace: 0pt !important;\r\n" + 
				"        mso-table-rspace: 0pt !important;\r\n" + 
				"      }\r\n" + 
				"      table {\r\n" + 
				"        border-spacing: 0 !important;\r\n" + 
				"        border-collapse: collapse !important;\r\n" + 
				"        table-layout: fixed !important;\r\n" + 
				"        margin: 0 auto !important;\r\n" + 
				"      }\r\n" + 
				"      table table table {\r\n" + 
				"        table-layout: auto;\r\n" + 
				"      }\r\n" + 
				"      img {\r\n" + 
				"        -ms-interpolation-mode: bicubic;\r\n" + 
				"      }\r\n" + 
				"      a {\r\n" + 
				"        text-decoration: none;\r\n" + 
				"      }\r\n" + 
				"      *[x-apple-data-detectors],\r\n" + 
				"      .unstyle-auto-detected-links *,\r\n" + 
				"      .aBn {\r\n" + 
				"        border-bottom: 0 !important;\r\n" + 
				"        cursor: default !important;\r\n" + 
				"        color: inherit !important;\r\n" + 
				"        text-decoration: none !important;\r\n" + 
				"        font-size: inherit !important;\r\n" + 
				"        font-family: inherit !important;\r\n" + 
				"        font-weight: inherit !important;\r\n" + 
				"        line-height: inherit !important;\r\n" + 
				"      }\r\n" + 
				"      .a6S {\r\n" + 
				"        display: none !important;\r\n" + 
				"        opacity: 0.01 !important;\r\n" + 
				"      }\r\n" + 
				"      img.g-img+div {\r\n" + 
				"        display: none !important;\r\n" + 
				"      }\r\n" + 
				"      @media only screen and (min-device-width: 320px) and (max-device-width: 374px) {\r\n" + 
				"        u~div .email-container {\r\n" + 
				"          min-width: 320px !important;\r\n" + 
				"        }\r\n" + 
				"      }\r\n" + 
				"      @media only screen and (min-device-width: 375px) and (max-device-width: 413px) {\r\n" + 
				"        u~div .email-container {\r\n" + 
				"          min-width: 375px !important;\r\n" + 
				"        }\r\n" + 
				"      }\r\n" + 
				"      @media only screen and (min-device-width: 414px) {\r\n" + 
				"        u~div .email-container {\r\n" + 
				"          min-width: 414px !important;\r\n" + 
				"        }\r\n" + 
				"      }\r\n" + 
				"      @media screen and (max-width: 480px) {\r\n" + 
				"        .fluid {\r\n" + 
				"          width: 100% !important;\r\n" + 
				"          max-width: 100% !important;\r\n" + 
				"          height: auto !important;\r\n" + 
				"          margin-left: auto !important;\r\n" + 
				"          margin-right: auto !important;\r\n" + 
				"        }\r\n" + 
				"        .mobile-button {\r\n" + 
				"          width: 90% !important;\r\n" + 
				"          max-width: 90% !important;\r\n" + 
				"          height: auto !important;\r\n" + 
				"          margin-left: auto !important;\r\n" + 
				"          margin-right: auto !important;\r\n" + 
				"        }\r\n" + 
				"        .mobile-text {\r\n" + 
				"          font-size: 48px !important;\r\n" + 
				"        }\r\n" + 
				"        .stack-column,\r\n" + 
				"        .stack-column-center {\r\n" + 
				"          display: block !important;\r\n" + 
				"          width: 100% !important;\r\n" + 
				"          max-width: 100% !important;\r\n" + 
				"          direction: ltr !important;\r\n" + 
				"        }\r\n" + 
				"        .stack-column-center {\r\n" + 
				"          text-align: center !important;\r\n" + 
				"        }\r\n" + 
				"        .center-on-narrow {\r\n" + 
				"          text-align: center !important;\r\n" + 
				"          display: block !important;\r\n" + 
				"          margin-left: auto !important;\r\n" + 
				"          margin-right: auto !important;\r\n" + 
				"          float: none !important;\r\n" + 
				"        }\r\n" + 
				"        table.center-on-narrow {\r\n" + 
				"          display: inline-block !important;\r\n" + 
				"        }\r\n" + 
				"        .hide-mobile {\r\n" + 
				"          display: none;\r\n" + 
				"        }\r\n" + 
				"      }\r\n" + 
				"    </style>\r\n" + 
				"\r\n" + 
				"    <!-- CSS Reset : END -->\r\n" + 
				"\r\n" + 
				"    <!-- fontfixing -->\r\n" + 
				"\r\n" + 
				"    <!-- Web Font / @font-face : BEGIN -->\r\n" + 
				"\r\n" + 
				"    <!--[if mso]>\r\n" + 
				"<style type=”text/css”>\r\n" + 
				".fallback-font {\r\n" + 
				"font-family: Verdana, Arial, sans-serif;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"\r\n" + 
				"<!-- Reset list spacing because Outlook ignores much of our inline CSS. -->\r\n" + 
				"\r\n" + 
				"    <!--[if mso]>\r\n" + 
				"<style type=\"text/css\">\r\n" + 
				"ul,\r\n" + 
				"ol {\r\n" + 
				"margin: 0 !important;\r\n" + 
				"}\r\n" + 
				"li {\r\n" + 
				"margin-left: 30px !important;\r\n" + 
				"}\r\n" + 
				"li.list-item-first {\r\n" + 
				"margin-top: 0 !important;\r\n" + 
				"}\r\n" + 
				"li.list-item-last {\r\n" + 
				"margin-bottom: 10px !important;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"<![endif]-->\r\n" + 
				"\r\n" + 
				"    <!-- Progressive Enhancements : BEGIN -->\r\n" + 
				"    <style>\r\n" + 
				"      .btn-a. btn-td {\r\n" + 
				"        transition: all 100ms ease-in;\r\n" + 
				"      }\r\n" + 
				"      .btn-a:hover {\r\n" + 
				"        color: #ffffff !important;\r\n" + 
				"        background-color: #01807e !important;\r\n" + 
				"      }\r\n" + 
				"      .btn-b:hover {\r\n" + 
				"        color: #253746 !important;\r\n" + 
				"        background-color: #ffffff !important;\r\n" + 
				"        border: 2px solid #253746 !important;\r\n" + 
				"      }\r\n" + 
				"    </style>\r\n" + 
				"\r\n" + 
				"    <!-- Progressive Enhancements : END -->\r\n" + 
				"\r\n" + 
				"    <!-- What it does: Makes background images in 72ppi Outlook render at correct size. -->\r\n" + 
				"\r\n" + 
				"    <!--[if gte mso 9]>\r\n" + 
				"<xml>\r\n" + 
				"<o:OfficeDocumentSettings>\r\n" + 
				"<o:AllowPNG/>\r\n" + 
				"<o:PixelsPerInch>96</o:PixelsPerInch>\r\n" + 
				"</o:OfficeDocumentSettings>\r\n" + 
				"</xml>\r\n" + 
				"<![endif]-->\r\n" + 
				"  </head>\r\n" + 
				"  <body width=\"100%\" style=\"margin: 0; padding: 0 !important; mso-line-height-rule: exactly; background-color: #ffffff;\">\r\n" + 
				"    <center style=\"width: 100%; background-color: #ffffff;\">\r\n" + 
				"\r\n" + 
				"      <!--[if mso | IE]>\r\n" + 
				"<table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"background-color: #363636;\">\r\n" + 
				"<tr>\r\n" + 
				"<td>\r\n" + 
				"<![endif]-->\r\n" + 
				"\r\n" + 
				"      <!-- Visually Hidden Preheader Text : BEGIN -->\r\n" + 
				"      <div style=\"display: none; font-size: 1px; line-height: 1px; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden; mso-hide: all; font-family: sans-serif; color: #ffffff;\">\r\n" + 
				"        Prepare-se para se tornar mais um rato de boné!\r\n" + 
				"      </div>\r\n" + 
				"\r\n" + 
				"      <!-- Visually Hidden Preheader Text : END -->\r\n" + 
				"      <div style=\"max-width: 600px; margin: 0 auto;\" class=\"email-container\">\r\n" + 
				"\r\n" + 
				"        <!--[if mso]>\r\n" + 
				"<table align=\"center\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"600\">\r\n" + 
				"<tr>\r\n" + 
				"<td>\r\n" + 
				"<![endif]-->\r\n" + 
				"\r\n" + 
				"        <!-- Email Body : BEGIN -->\r\n" + 
				"\r\n" + 
				"        <!-- view online: BEGIN -->\r\n" + 
				"        <table align=\"center\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"margin: 0 auto;\">\r\n" + 
				"          <tbody>\r\n" + 
				"            <tr>\r\n" + 
				"              <td align=\"center\" style=\"font-family: Arial, sans-serif; font-size: 11px; color: #363636; text-align:center; line-height: 2; text-align: center; padding: 10px;\">Caso esteja enfrentando problemas para visualizar este e-mail, <a href=\"#\" target=\"_blank\" style=\"text-decoration:underline; color:#363636;\">clique aqui para ver online.</a>\r\n" + 
				"              </td>\r\n" + 
				"            </tr>\r\n" + 
				"          </tbody>\r\n" + 
				"        </table>\r\n" + 
				"\r\n" + 
				"        <!-- View Online: END-->\r\n" + 
				"\r\n" + 
				"        <!-- Logo Bar : BEGIN -->\r\n" + 
				"		 <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"background-color: #363636; margin: 0 auto; max-width: 600px; padding: 10px;\">\r\n" + 
				"          <tbody>\r\n" + 
				"            <tr>\r\n" + 
				"              <td align=\"center\" width=\"100%\"valign=\"middle\" style=\" text-align: center; width: 100%; padding: 15px;\"><font class=\"logo\">CAP<span>RAT</span></font>\r\n" + 
				"              </td>\r\n" + 
				"            </tr>\r\n" + 
				"          </tbody>\r\n" + 
				"        </table>"+
				"\r\n" + 
				"        <!-- Reverse Logo Bar : END -->\r\n" + 
				"\r\n" + 
				"        <!-- 1 Column : BEGIN -->\r\n" + 
				"        <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"background-color: #363636; margin: 0 auto; text-align: center;\">\r\n" + 
				"          <tbody>\r\n" + 
				"            <tr>\r\n" + 
				"              <td width=\"600\" align=\"center\" style=\"width:100%; padding: 0;\">\r\n" + 
				"                <img src=\"https://assets.adin.com.br/clientes/arezzo/emkt/ZZMall/Teste/images/banner.gif\" class=\"fluid g-img\" width=\"600\" height=\"auto\" alt=\". / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / .\" border=\"0\" style=\"width: 100%; max-width: 600px; height: auto; background: #363636; font-family: Arial Narrow, sans-serif; letter-spacing: 1px; font-weight: bold; font-size: 32px; line-height: 1.6; text-transform: uppercase; text-align: center !important; margin: 0 auto; padding: 0; color:#ffffff; line-height: 1.2;\">\r\n" + 
				"              </td>\r\n" + 
				"            </tr>\r\n" + 
				"          </tbody>\r\n" + 
				"        </table>\r\n" + 
				"        <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"background-color: #363636; margin: 0 auto; text-align: center;\">\r\n" + 
				"          <tbody>\r\n" + 
				"            <tr>\r\n" + 
				"              <td style=\"background-color: #363636; padding: 0 40px;\">\r\n" + 
				"                <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"width: 100%; max-width: 600px;\">\r\n" + 
				"                  <tbody>\r\n" + 
				"                    <tr>\r\n" + 
				"                      <td style=\"padding: 20px 10px; text-align: left; line-height: 1.1; mso-line-height-rule:exactly;\" class=\"\">\r\n" + 
				"\r\n" + 
				"                        <!--[if mso]>\r\n" + 
				"<h1 style=\"margin:0; font-family: Arial Narrow, Verdana, Gill Sans, sans-serif; font-size: 64px; line-height: 1.1; color: #ffffff; font-weight: bold; mso-line-height-rule:exactly; padding: 0; \">\r\n" + 
				"Let's get to know each other<span color=\"#00a4b5\" style=\"color: #00a4b5; font-family: Arial Narrow, Arial; padding: 0; line-height: 0; display: inline;\">.\r\n" + 
				"</span></h1>\r\n" + 
				"<![endif]-->\r\n" + 
				"\r\n" + 
				"                        <!--[if !mso]>\r\n" + 
				"<!-->\r\n" + 
				"                        <h1 style=\"margin:0; font-family: Arial, Helvetica, sans-serifsans-serif; font-size: 54px; line-height: 1; color: #ffffff; font-weight: normal; mso-line-height-rule:exactly; mso-font-alt: 'Verdana', 'Arial'; padding: 0; \" class=\"\">Senha alterada <br>com sucesso<span color=\"#00a4b5\" style=\"color: #BAD1CE; font-family: Arial Narrow, Arial; padding: 0; line-height: 0; display: inline;\">\r\n" + 
				"</span></h1>\r\n" + 
				"\r\n" + 
				"                        <!--<![endif]-->\r\n" + 
				"                      </td>\r\n" + 
				"                    </tr>\r\n" + 
				"                  </tbody>\r\n" + 
				"                </table>\r\n" + 
				"                <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"width: 100%; max-width: 600px;\">\r\n" + 
				"                  <tbody>\r\n" + 
				"                    <tr>\r\n" + 
				"                      <td style=\"padding: 20px 10px; text-align: left; font-family: Arial, Calibri, Verdana, Helvetica, sans-serif; font-size: 20px; color: #ffffff; line-height: 28px; mso-line-height-rule:exactly;\" class=\"\">\r\n" + 
				"                        <p style=\"margin:0; font-family: Arial, Calibri, Verdana, Helvetica, sans-serif; font-size: 20px; color: #ffffff; line-height: 150%; line=height:24px; mso-line-height-rule:exactly;\" class=\"\">Olá <span style=\"color: #BAD1CE;\">" + dadosUsuario.getApelidoUsuario() + ",</span> <br><br>Você requisitou uma recuperação de senha e nós te ouvimos!<br><br>\r\n" + 
				"                          Segue abaixo a nova senha que você deverá usar para entrar em nosso sistema:\r\n" + 
				"                          <br>Senha: <span style=\"color: #BAD1CE;\"> " + dadosUsuario.getSenhaUsuario() + " </span><br><br>\r\n" + 
				"                          Caso não tenha requisitado esta alteração de senha, entre em nosso sistema e a altere para algo de sua preferência o mais rápido possível!\r\n" + 
				"                        </p>\r\n" + 
				"                      </td>\r\n" + 
				"                    </tr>\r\n" + 
				"                  </tbody>\r\n" + 
				"                </table>\r\n" + 
				"              </td>\r\n" + 
				"            </tr>\r\n" + 
				"            <tr>\r\n" + 
				"              <td height=\"40\" style=\"font-size: 0px; line-height: 0px; background-color: #363636;\" class=\"\">&nbsp;\r\n" + 
				"                \r\n" + 
				"              </td>\r\n" + 
				"            </tr>\r\n" + 
				"            <tr>\r\n" + 
				"              <td align=\"center\" style=\"background-color: #363636; padding: 0 40px; text-align: center;\">\r\n" + 
				"\r\n" + 
				"                <!-- button: begin -->\r\n" + 
				"                <table class=\"mobile-button\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" align=\"center\" style=\"width: 100%; max-width: 600px; background-color: #363636;\">\r\n" + 
				"                  <tbody>\r\n" + 
				"                    <tr>\r\n" + 
				"                      <td bgcolor=\"#363636\" class=\"mobile-button\" align=\"center\">\r\n" + 
				"                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"text-align: center;\">\r\n" + 
				"                          <tbody>\r\n" + 
				"                            <tr>\r\n" + 
				"                              <td align=\"center\" bgcolor=\"white\" width=\"300\" style=\"border-radius: 4px;\"><a href=\"http://localhost:8080/pages/login/login.jsp\" style=\"font-size: 18px; font-family:Arial, Calibri, Geneva, sans-serif; color: #363636; text-decoration: none !important; text-transform: uppercase; font-weight: normal; padding: 18px; border: 2px solid white; display: inline-block;\">FINALIZAR CADASTRO</a></td>\r\n" + 
				"                            </tr>\r\n" + 
				"                          </tbody>\r\n" + 
				"                        </table>\r\n" + 
				"                      </td>\r\n" + 
				"                    </tr>\r\n" + 
				"                  </tbody>\r\n" + 
				"                </table>\r\n" + 
				"\r\n" + 
				"                <!-- button: end -->\r\n" + 
				"              </td>\r\n" + 
				"            </tr>\r\n" + 
				"            <tr>\r\n" + 
				"              <td>\r\n" + 
				"\r\n" + 
				"                <!-- Clear Spacer : BEGIN -->\r\n" + 
				"                <table aria-hidden=\"true\" align=\"center\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"margin: 0 auto; \">\r\n" + 
				"                  <tbody>\r\n" + 
				"                    <tr>\r\n" + 
				"                      <td height=\"100\" style=\"font-size: 0px; line-height: 0px; background-color: #363636;\">&nbsp;\r\n" + 
				"                        \r\n" + 
				"                      </td>\r\n" + 
				"                    </tr>\r\n" + 
				"                  </tbody>\r\n" + 
				"                </table>\r\n" + 
				"\r\n" + 
				"                <!-- Clear Spacer : END -->\r\n" + 
				"              </td>\r\n" + 
				"            </tr>\r\n" + 
				"          </tbody>\r\n" + 
				"        </table>\r\n" + 
				"\r\n" + 
				"        <!-- 1 Column : END -->\r\n" + 
				"\r\n" + 
				"        <!-- Email Footer : BEGIN -->\r\n" + 
				"        <div style=\"max-width: 600px; margin: 0 auto;\" class=\"email-container\">\r\n" + 
				"\r\n" + 
				"          <!--[if mso]>\r\n" + 
				"<table align=\"center\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"600\" bgcolor=\"#00a4b5\">\r\n" + 
				"<tr>\r\n" + 
				"<td>\r\n" + 
				"<![endif]-->\r\n" + 
				"          <table bgcolor=\"#242424\" align=\"center\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"margin: 0 auto; text-align: center; padding: 10px 20px;\">\r\n" + 
				"            <tbody>\r\n" + 
				"              <tr>\r\n" + 
				"                <td height=\"40\">&nbsp;</td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td width=\"80%\" align=\"center\">\r\n" + 
				"                  <p style=\"margin:0; mso-line-height-rule:exactly; font-family: Georgia, serif; font-size: 16px; color: #ffffff; text-align:center;line-height: 1.6; letter-spacing: 1px; font-style: italic;text-align: center;font-weight: normal;\">Empoderando pessoas para mudar o&nbsp;mundo&nbsp;<sup style=\"font-weight: normal;font-size: 12px;\"></sup></p>\r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td style=\"padding: 20px 10px;\">\r\n" + 
				"\r\n" + 
				"                  <!-- social : begin -->\r\n" + 
				"                  <table align=\"center\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"75%\" style=\"margin: 0 auto; \">\r\n" + 
				"                    <tbody>\r\n" + 
				"                      <tr>\r\n" + 
				"\r\n" + 
				"                        <!-- Linkedin -->\r\n" + 
				"                        <td style=\"text-align:center;\">\r\n" + 
				"                          <a href=\"#\" target=\"blank\"><img src=\"https://assets.adin.com.br/clientes/arezzo/emkt/ZZMall/Teste/images/linkedin.png\" width=\"40\" style=\"font-family: Calibri, Helvetica, Arial, sans-serif; font-size: 10px; color: #ffffff; text-transform: uppercase; display: inline-block; width:40px; \" height=\"auto\" alt=\"LinkedIn\" border=\"0\"></a>\r\n" + 
				"                        </td>\r\n" + 
				"\r\n" + 
				"                        <!-- Twitter -->\r\n" + 
				"                        <td style=\" text-align:center; \">\r\n" + 
				"                          <a href=\"#\" target=\"blank\"><img src=\"https://assets.adin.com.br/clientes/arezzo/emkt/ZZMall/Teste/images/instagram.png\" width=\"40\" style=\"font-family: Calibri, Helvetica, Arial, sans-serif; font-size: 10px; color: #ffffff; text-transform: uppercase; display: inline-block; width:40px;\" alt=\"Twitter\" border=\"0\"></a>\r\n" + 
				"                        </td>\r\n" + 
				"\r\n" + 
				"                        <!-- Instagram -->\r\n" + 
				"                        <td style=\" text-align:center; \">\r\n" + 
				"                          <a href=\"#\" target=\"blank\"><img src=\"https://assets.adin.com.br/clientes/arezzo/emkt/ZZMall/Teste/images/twitter.png\" width=\"40\" style=\"font-family: Calibri, Helvetica, Arial, sans-serif; font-size: 10px; color: #ffffff; text-transform: uppercase; display: inline-block; width:40px;\" alt=\"Instagram\" border=\"0\"></a>\r\n" + 
				"                        </td>\r\n" + 
				"\r\n" + 
				"                        <!-- Facebook Icon -->\r\n" + 
				"                        <td style=\" text-align:center; \">\r\n" + 
				"                          <a href=\"#\" target=\"blank\"><img src=\"https://assets.adin.com.br/clientes/arezzo/emkt/ZZMall/Teste/images/facebook.png\" width=\"40\" style=\"font-family: Calibri, Helvetica, Arial, sans-serif; font-size: 10px; color: #ffffff; text-transform: uppercase; display: inline-block; width:40px;\" alt=\"Facebook\" border=\"0\"></a>\r\n" + 
				"                        </td>\r\n" + 
				"                      </tr>\r\n" + 
				"                    </tbody>\r\n" + 
				"                  </table>\r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td height=\"10\">&nbsp;\r\n" + 
				"                  \r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td align=\"center\">\r\n" + 
				"                  <p align=\"center\" style=\"font-family: Franklin Gothic, Calibri, Arial , sans-serif; font-size: 14px; color: #ffffff; text-align:center; line-height: 1.4;\">© Copyright 2021 CAPRAT. Todos os direitos reservados.</p>\r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td height=\"20\">&nbsp;\r\n" + 
				"                  \r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td align=\"center\">\r\n" + 
				"                  <p class=\"fluid center-on-narrow\" style=\"font-family: Franklin Gothic, Calibri, Arial, sans-serif; font-size: 14px; color: #ffffff; line-height: 1.6; font-weight: normal; margin: 0; text-align: center;\">\r\n" + 
				"                    Esta é uma mensagem de <span style=\"display:inline-block;\">CapRat.</span> <br>\r\n" + 
				"                  	Para garantir o recebimento das nossas novidades, <br>adicione <a href=\"mailto:reply@capratvagas.com.br\" style=\"color:#BAD1CE;\">reply@capratvagas.com.br</a> aos seus contatos.\r\n" + 
				"                    <br>\r\n" + 
				"                    <br>\r\n" + 
				"                    <a data-targettype=\"sysaction\" href=\"#\" style=\"color:#ffffff;  padding: 5px;\" title=\"unsubscribe\">Descadastre-se</a> |\r\n" + 
				"                    <a href=\"#\" style=\"color:#ffffff;  padding: 5px;\">Saiba Mais</a> <br>\r\n" + 
				"                    <a href=\"#\" style=\"color:#ffffff; padding: 5px;\">Política de Privacidade</a> &nbsp;|\r\n" + 
				"                    <a href=\"#\" style=\"color:#ffffff; padding: 5px;\">Política de Cookies</a>\r\n" + 
				"                    <br>\r\n" + 
				"                  </p>\r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td height=\"20\">&nbsp;\r\n" + 
				"                  \r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td>\r\n" + 
				"                  <p style=\"font-family: Franklin Gothic, Calibri, Arial , sans-serif; font-size: 14px; color: #ffffff; line-height: 1.6; text-align: center; \">\r\n" + 
				"                    Equipe CAPRAT.<br>\r\n" + 
				"                    Av. Salgado Filho, 3501<br>\r\n" + 
				"                   Guarulhos, São Paulo, Brasil<br>\r\n" + 
				"                    +55 (11) 2565 - 8450\r\n" + 
				"                  </p>\r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td height=\"40\">&nbsp;\r\n" + 
				"                  \r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"            </tbody>\r\n" + 
				"          </table>\r\n" + 
				"\r\n" + 
				"          <!--[if mso | IE]>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"</table>\r\n" + 
				"<![endif]-->\r\n" + 
				"        </div>\r\n" + 
				"      </div>\r\n" + 
				"    </center>\r\n" + 
				"    <img src='https://s2082.t.en25.com/e/FooterImages/FooterImage1?elq=5e8794d175cc400cbed06f5b4aaf2175&siteid=2082' alt=\"\" border=0 width=1px height=1px>\r\n" + 
				"  <script data-cfasync=\"false\" src=\"/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js\"></script></body>\r\n" + 
				"</html>";
		
		this.enviarEmail(dadosUsuario.getEmailUsuario(), "Geramos uma nova senha para você!", htmlEmail);
	}
	
	public void enviarEmailCadastroCandidato(UsuarioLogin dadosUsuario) {
		String htmlEmail = 
				"<!DOCTYPE html>\r\n" + 
				"<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\r\n" + 
				"  <head>\r\n" + 
				"    <meta http-equiv=\"Content-Type\" content=\"text/html charset=UTF-8\">\r\n" + 
				" <!-- utf-8 works for most cases -->\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width\">\r\n" + 
				" <!-- Forcing initial-scale shouldn't be necessary -->\r\n" + 
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
				" <!-- Use the latest (edge) version of IE rendering engine -->\r\n" + 
				"    <meta name=\"x-apple-disable-message-reformatting\">\r\n" + 
				" <!-- Disable auto-scale in iOS 10 Mail entirely -->\r\n" + 
				"    <title>Welcome to CapRat</title>\r\n" + 
				" <!-- The title tag shows in email notifications, like Android 4.4. -->\r\n" + 
				"\r\n" + 
				"    <!-- Web Font / @font-face : BEGIN -->\r\n" + 
				"\r\n" + 
				"    <!--[if !mso]>\r\n" + 
				"<!-- -->\r\n" + 
				"    <link href=\"https://fonts.googleapis.com/css?family=Oswald&display=swap\" rel=\"stylesheet\">\r\n" + 
				"\r\n" + 
				"    <!--<![endif]-->\r\n" + 
				"    <style>\r\n" + 
				"      html,\r\n" + 
				"      body {\r\n" + 
				"        margin: 0 auto !important;\r\n" + 
				"        padding: 0 !important;\r\n" + 
				"        height: 100% !important;\r\n" + 
				"        width: 100% !important;\r\n" + 
				"      }\r\n" + 
				"      * {\r\n" + 
				"        -ms-text-size-adjust: 100%;\r\n" + 
				"        -webkit-text-size-adjust: 100%;\r\n" + 
				"      }\r\n" + 
				"      .logo{\r\n" + 
				"        position:relative;\r\n" + 
				"        font-size: 1.5rem;\r\n" + 
				"        color:#FEFFF7;\r\n" + 
				"        text-decoration: none;\r\n" + 
				"        font-weight: 400;\r\n" + 
				"        font-family: 'Arial';\r\n" + 
				"        }\r\n" + 
				"      .logo span{\r\n" + 
				"            font-weight: 600;\r\n" + 
				"        }"+
				"      div[style*=\"margin: 16px 0\"] {\r\n" + 
				"        margin: 0 !important;\r\n" + 
				"      }\r\n" + 
				"      table,\r\n" + 
				"      td {\r\n" + 
				"        mso-table-lspace: 0pt !important;\r\n" + 
				"        mso-table-rspace: 0pt !important;\r\n" + 
				"      }\r\n" + 
				"      table {\r\n" + 
				"        border-spacing: 0 !important;\r\n" + 
				"        border-collapse: collapse !important;\r\n" + 
				"        table-layout: fixed !important;\r\n" + 
				"        margin: 0 auto !important;\r\n" + 
				"      }\r\n" + 
				"      table table table {\r\n" + 
				"        table-layout: auto;\r\n" + 
				"      }\r\n" + 
				"      img {\r\n" + 
				"        -ms-interpolation-mode: bicubic;\r\n" + 
				"      }\r\n" + 
				"      a {\r\n" + 
				"        text-decoration: none;\r\n" + 
				"      }\r\n" + 
				"      *[x-apple-data-detectors],\r\n" + 
				"      .unstyle-auto-detected-links *,\r\n" + 
				"      .aBn {\r\n" + 
				"        border-bottom: 0 !important;\r\n" + 
				"        cursor: default !important;\r\n" + 
				"        color: inherit !important;\r\n" + 
				"        text-decoration: none !important;\r\n" + 
				"        font-size: inherit !important;\r\n" + 
				"        font-family: inherit !important;\r\n" + 
				"        font-weight: inherit !important;\r\n" + 
				"        line-height: inherit !important;\r\n" + 
				"      }\r\n" + 
				"      .a6S {\r\n" + 
				"        display: none !important;\r\n" + 
				"        opacity: 0.01 !important;\r\n" + 
				"      }\r\n" + 
				"      img.g-img+div {\r\n" + 
				"        display: none !important;\r\n" + 
				"      }\r\n" + 
				"      @media only screen and (min-device-width: 320px) and (max-device-width: 374px) {\r\n" + 
				"        u~div .email-container {\r\n" + 
				"          min-width: 320px !important;\r\n" + 
				"        }\r\n" + 
				"      }\r\n" + 
				"      @media only screen and (min-device-width: 375px) and (max-device-width: 413px) {\r\n" + 
				"        u~div .email-container {\r\n" + 
				"          min-width: 375px !important;\r\n" + 
				"        }\r\n" + 
				"      }\r\n" + 
				"      @media only screen and (min-device-width: 414px) {\r\n" + 
				"        u~div .email-container {\r\n" + 
				"          min-width: 414px !important;\r\n" + 
				"        }\r\n" + 
				"      }\r\n" + 
				"      @media screen and (max-width: 480px) {\r\n" + 
				"        .fluid {\r\n" + 
				"          width: 100% !important;\r\n" + 
				"          max-width: 100% !important;\r\n" + 
				"          height: auto !important;\r\n" + 
				"          margin-left: auto !important;\r\n" + 
				"          margin-right: auto !important;\r\n" + 
				"        }\r\n" + 
				"        .mobile-button {\r\n" + 
				"          width: 90% !important;\r\n" + 
				"          max-width: 90% !important;\r\n" + 
				"          height: auto !important;\r\n" + 
				"          margin-left: auto !important;\r\n" + 
				"          margin-right: auto !important;\r\n" + 
				"        }\r\n" + 
				"        .mobile-text {\r\n" + 
				"          font-size: 48px !important;\r\n" + 
				"        }\r\n" + 
				"        .stack-column,\r\n" + 
				"        .stack-column-center {\r\n" + 
				"          display: block !important;\r\n" + 
				"          width: 100% !important;\r\n" + 
				"          max-width: 100% !important;\r\n" + 
				"          direction: ltr !important;\r\n" + 
				"        }\r\n" + 
				"        .stack-column-center {\r\n" + 
				"          text-align: center !important;\r\n" + 
				"        }\r\n" + 
				"        .center-on-narrow {\r\n" + 
				"          text-align: center !important;\r\n" + 
				"          display: block !important;\r\n" + 
				"          margin-left: auto !important;\r\n" + 
				"          margin-right: auto !important;\r\n" + 
				"          float: none !important;\r\n" + 
				"        }\r\n" + 
				"        table.center-on-narrow {\r\n" + 
				"          display: inline-block !important;\r\n" + 
				"        }\r\n" + 
				"        .hide-mobile {\r\n" + 
				"          display: none;\r\n" + 
				"        }\r\n" + 
				"      }\r\n" + 
				"    </style>\r\n" + 
				"\r\n" + 
				"    <!-- CSS Reset : END -->\r\n" + 
				"\r\n" + 
				"    <!-- fontfixing -->\r\n" + 
				"\r\n" + 
				"    <!-- Web Font / @font-face : BEGIN -->\r\n" + 
				"\r\n" + 
				"    <!--[if mso]>\r\n" + 
				"<style type=”text/css”>\r\n" + 
				".fallback-font {\r\n" + 
				"font-family: Verdana, Arial, sans-serif;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"\r\n" + 
				"<!-- Reset list spacing because Outlook ignores much of our inline CSS. -->\r\n" + 
				"\r\n" + 
				"    <!--[if mso]>\r\n" + 
				"<style type=\"text/css\">\r\n" + 
				"ul,\r\n" + 
				"ol {\r\n" + 
				"margin: 0 !important;\r\n" + 
				"}\r\n" + 
				"li {\r\n" + 
				"margin-left: 30px !important;\r\n" + 
				"}\r\n" + 
				"li.list-item-first {\r\n" + 
				"margin-top: 0 !important;\r\n" + 
				"}\r\n" + 
				"li.list-item-last {\r\n" + 
				"margin-bottom: 10px !important;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"<![endif]-->\r\n" + 
				"\r\n" + 
				"    <!-- Progressive Enhancements : BEGIN -->\r\n" + 
				"    <style>\r\n" + 
				"      .btn-a. btn-td {\r\n" + 
				"        transition: all 100ms ease-in;\r\n" + 
				"      }\r\n" + 
				"      .btn-a:hover {\r\n" + 
				"        color: #ffffff !important;\r\n" + 
				"        background-color: #01807e !important;\r\n" + 
				"      }\r\n" + 
				"      .btn-b:hover {\r\n" + 
				"        color: #253746 !important;\r\n" + 
				"        background-color: #ffffff !important;\r\n" + 
				"        border: 2px solid #253746 !important;\r\n" + 
				"      }\r\n" + 
				"    </style>\r\n" + 
				"\r\n" + 
				"    <!-- Progressive Enhancements : END -->\r\n" + 
				"\r\n" + 
				"    <!-- What it does: Makes background images in 72ppi Outlook render at correct size. -->\r\n" + 
				"\r\n" + 
				"    <!--[if gte mso 9]>\r\n" + 
				"<xml>\r\n" + 
				"<o:OfficeDocumentSettings>\r\n" + 
				"<o:AllowPNG/>\r\n" + 
				"<o:PixelsPerInch>96</o:PixelsPerInch>\r\n" + 
				"</o:OfficeDocumentSettings>\r\n" + 
				"</xml>\r\n" + 
				"<![endif]-->\r\n" + 
				"  </head>\r\n" + 
				"  <body width=\"100%\" style=\"margin: 0; padding: 0 !important; mso-line-height-rule: exactly; background-color: #ffffff;\">\r\n" + 
				"    <center style=\"width: 100%; background-color: #ffffff;\">\r\n" + 
				"\r\n" + 
				"      <!--[if mso | IE]>\r\n" + 
				"<table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"background-color: #363636;\">\r\n" + 
				"<tr>\r\n" + 
				"<td>\r\n" + 
				"<![endif]-->\r\n" + 
				"\r\n" + 
				"      <!-- Visually Hidden Preheader Text : BEGIN -->\r\n" + 
				"      <div style=\"display: none; font-size: 1px; line-height: 1px; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden; mso-hide: all; font-family: sans-serif; color: #ffffff;\">\r\n" + 
				"        Prepare-se para se tornar mais um rato de boné!\r\n" + 
				"      </div>\r\n" + 
				"\r\n" + 
				"      <!-- Visually Hidden Preheader Text : END -->\r\n" + 
				"      <div style=\"max-width: 600px; margin: 0 auto;\" class=\"email-container\">\r\n" + 
				"\r\n" + 
				"        <!--[if mso]>\r\n" + 
				"<table align=\"center\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"600\">\r\n" + 
				"<tr>\r\n" + 
				"<td>\r\n" + 
				"<![endif]-->\r\n" + 
				"\r\n" + 
				"        <!-- Email Body : BEGIN -->\r\n" + 
				"\r\n" + 
				"        <!-- view online: BEGIN -->\r\n" + 
				"        <table align=\"center\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"margin: 0 auto;\">\r\n" + 
				"          <tbody>\r\n" + 
				"            <tr>\r\n" + 
				"              <td align=\"center\" style=\"font-family: Arial, sans-serif; font-size: 11px; color: #363636; text-align:center; line-height: 2; text-align: center; padding: 10px;\">Caso esteja enfrentando problemas para visualizar este e-mail, <a href=\"#\" target=\"_blank\" style=\"text-decoration:underline; color:#363636;\">clique aqui para ver online.</a>\r\n" + 
				"              </td>\r\n" + 
				"            </tr>\r\n" + 
				"          </tbody>\r\n" + 
				"        </table>\r\n" + 
				"\r\n" + 
				"        <!-- View Online: END-->\r\n" + 
				"\r\n" + 
				"        <!-- Logo Bar : BEGIN -->\r\n" + 
				"		 <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"background-color: #363636; margin: 0 auto; max-width: 600px; padding: 10px;\">\r\n" + 
				"          <tbody>\r\n" + 
				"            <tr>\r\n" + 
				"              <td align=\"center\" width=\"100%\"valign=\"middle\" style=\" text-align: center; width: 100%; padding: 15px;\"><font class=\"logo\">CAP<span>RAT</span></font>\r\n" + 
				"              </td>\r\n" + 
				"            </tr>\r\n" + 
				"          </tbody>\r\n" + 
				"        </table>"+
				"\r\n" + 
				"        <!-- Reverse Logo Bar : END -->\r\n" + 
				"\r\n" + 
				"        <!-- 1 Column : BEGIN -->\r\n" + 
				"        <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"background-color: #363636; margin: 0 auto; text-align: center;\">\r\n" + 
				"          <tbody>\r\n" + 
				"            <tr>\r\n" + 
				"              <td width=\"600\" align=\"center\" style=\"width:100%; padding: 0;\">\r\n" + 
				"                <img src=\"https://assets.adin.com.br/clientes/arezzo/emkt/ZZMall/Teste/images/banner.gif\" class=\"fluid g-img\" width=\"600\" height=\"auto\" alt=\". / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / .\" border=\"0\" style=\"width: 100%; max-width: 600px; height: auto; background: #363636; font-family: Arial Narrow, sans-serif; letter-spacing: 1px; font-weight: bold; font-size: 32px; line-height: 1.6; text-transform: uppercase; text-align: center !important; margin: 0 auto; padding: 0; color:#ffffff; line-height: 1.2;\">\r\n" + 
				"              </td>\r\n" + 
				"            </tr>\r\n" + 
				"          </tbody>\r\n" + 
				"        </table>\r\n" + 
				"        <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"background-color: #363636; margin: 0 auto; text-align: center;\">\r\n" + 
				"          <tbody>\r\n" + 
				"            <tr>\r\n" + 
				"              <td style=\"background-color: #363636; padding: 0 40px;\">\r\n" + 
				"                <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"width: 100%; max-width: 600px;\">\r\n" + 
				"                  <tbody>\r\n" + 
				"                    <tr>\r\n" + 
				"                      <td style=\"padding: 20px 10px; text-align: left; line-height: 1.1; mso-line-height-rule:exactly;\" class=\"\">\r\n" + 
				"\r\n" + 
				"                        <!--[if mso]>\r\n" + 
				"<h1 style=\"margin:0; font-family: Arial Narrow, Verdana, Gill Sans, sans-serif; font-size: 64px; line-height: 1.1; color: #ffffff; font-weight: bold; mso-line-height-rule:exactly; padding: 0; \">\r\n" + 
				"Let's get to know each other<span color=\"#00a4b5\" style=\"color: #00a4b5; font-family: Arial Narrow, Arial; padding: 0; line-height: 0; display: inline;\">.\r\n" + 
				"</span></h1>\r\n" + 
				"<![endif]-->\r\n" + 
				"\r\n" + 
				"                        <!--[if !mso]>\r\n" + 
				"<!-->\r\n" + 
				"                        <h1 style=\"margin:0; font-family: Arial, Helvetica, sans-serifsans-serif; font-size: 54px; line-height: 1; color: #ffffff; font-weight: normal; mso-line-height-rule:exactly; mso-font-alt: 'Verdana', 'Arial'; padding: 0; \" class=\"\">Vamos nos <br>conhecer melhor<span color=\"#00a4b5\" style=\"color: #BAD1CE; font-family: Arial Narrow, Arial; padding: 0; line-height: 0; display: inline;\">?\r\n" + 
				"</span></h1>\r\n" + 
				"\r\n" + 
				"                        <!--<![endif]-->\r\n" + 
				"                      </td>\r\n" + 
				"                    </tr>\r\n" + 
				"                  </tbody>\r\n" + 
				"                </table>\r\n" + 
				"                <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"width: 100%; max-width: 600px;\">\r\n" + 
				"                  <tbody>\r\n" + 
				"                    <tr>\r\n" + 
				"                      <td style=\"padding: 20px 10px; text-align: left; font-family: Arial, Calibri, Verdana, Helvetica, sans-serif; font-size: 20px; color: #ffffff; line-height: 28px; mso-line-height-rule:exactly;\" class=\"\">\r\n" + 
				"                        <p style=\"margin:0; font-family: Arial, Calibri, Verdana, Helvetica, sans-serif; font-size: 20px; color: #ffffff; line-height: 150%; line=height:24px; mso-line-height-rule:exactly;\" class=\"\">Olá <span style=\"color: #BAD1CE;\">" + dadosUsuario.getApelidoUsuario() + ",</span> <br><br>Bem-vindo ao CAPRAT Vagas! Você está prestes embarcar no início do seu futuro, aperte os cintos e bora caçar um trampo!<br><br>\r\n" + 
				"                          Seguem seus dados:\r\n" + 
				"                          <br>E-mail: <span style=\"color: #BAD1CE;\">" + dadosUsuario.getEmailUsuario() + "</span><br>Senha: <span style=\"color: #BAD1CE;\"> " + dadosUsuario.getSenhaUsuario() + " </span><br><br>\r\n" + 
				"                          Entre em nosso site, complete seu cadastro e tenha acesso as melhores vagas para você!\r\n" + 
				"                        </p>\r\n" + 
				"                      </td>\r\n" + 
				"                    </tr>\r\n" + 
				"                  </tbody>\r\n" + 
				"                </table>\r\n" + 
				"              </td>\r\n" + 
				"            </tr>\r\n" + 
				"            <tr>\r\n" + 
				"              <td height=\"40\" style=\"font-size: 0px; line-height: 0px; background-color: #363636;\" class=\"\">&nbsp;\r\n" + 
				"                \r\n" + 
				"              </td>\r\n" + 
				"            </tr>\r\n" + 
				"            <tr>\r\n" + 
				"              <td align=\"center\" style=\"background-color: #363636; padding: 0 40px; text-align: center;\">\r\n" + 
				"\r\n" + 
				"                <!-- button: begin -->\r\n" + 
				"                <table class=\"mobile-button\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" align=\"center\" style=\"width: 100%; max-width: 600px; background-color: #363636;\">\r\n" + 
				"                  <tbody>\r\n" + 
				"                    <tr>\r\n" + 
				"                      <td bgcolor=\"#363636\" class=\"mobile-button\" align=\"center\">\r\n" + 
				"                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"text-align: center;\">\r\n" + 
				"                          <tbody>\r\n" + 
				"                            <tr>\r\n" + 
				"                              <td align=\"center\" bgcolor=\"white\" width=\"300\" style=\"border-radius: 4px;\"><a href=\"http://localhost:8080/pages/login/login.jsp\" style=\"font-size: 18px; font-family:Arial, Calibri, Geneva, sans-serif; color: #363636; text-decoration: none !important; text-transform: uppercase; font-weight: normal; padding: 18px; border: 2px solid white; display: inline-block;\">NAVEGAR PARA A PÁGINA</a></td>\r\n" + 
				"                            </tr>\r\n" + 
				"                          </tbody>\r\n" + 
				"                        </table>\r\n" + 
				"                      </td>\r\n" + 
				"                    </tr>\r\n" + 
				"                  </tbody>\r\n" + 
				"                </table>\r\n" + 
				"\r\n" + 
				"                <!-- button: end -->\r\n" + 
				"              </td>\r\n" + 
				"            </tr>\r\n" + 
				"            <tr>\r\n" + 
				"              <td>\r\n" + 
				"\r\n" + 
				"                <!-- Clear Spacer : BEGIN -->\r\n" + 
				"                <table aria-hidden=\"true\" align=\"center\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"margin: 0 auto; \">\r\n" + 
				"                  <tbody>\r\n" + 
				"                    <tr>\r\n" + 
				"                      <td height=\"100\" style=\"font-size: 0px; line-height: 0px; background-color: #363636;\">&nbsp;\r\n" + 
				"                        \r\n" + 
				"                      </td>\r\n" + 
				"                    </tr>\r\n" + 
				"                  </tbody>\r\n" + 
				"                </table>\r\n" + 
				"\r\n" + 
				"                <!-- Clear Spacer : END -->\r\n" + 
				"              </td>\r\n" + 
				"            </tr>\r\n" + 
				"          </tbody>\r\n" + 
				"        </table>\r\n" + 
				"\r\n" + 
				"        <!-- 1 Column : END -->\r\n" + 
				"\r\n" + 
				"        <!-- Email Footer : BEGIN -->\r\n" + 
				"        <div style=\"max-width: 600px; margin: 0 auto;\" class=\"email-container\">\r\n" + 
				"\r\n" + 
				"          <!--[if mso]>\r\n" + 
				"<table align=\"center\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"600\" bgcolor=\"#00a4b5\">\r\n" + 
				"<tr>\r\n" + 
				"<td>\r\n" + 
				"<![endif]-->\r\n" + 
				"          <table bgcolor=\"#242424\" align=\"center\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"margin: 0 auto; text-align: center; padding: 10px 20px;\">\r\n" + 
				"            <tbody>\r\n" + 
				"              <tr>\r\n" + 
				"                <td height=\"40\">&nbsp;</td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td width=\"80%\" align=\"center\">\r\n" + 
				"                  <p style=\"margin:0; mso-line-height-rule:exactly; font-family: Georgia, serif; font-size: 16px; color: #ffffff; text-align:center;line-height: 1.6; letter-spacing: 1px; font-style: italic;text-align: center;font-weight: normal;\">Empoderando pessoas para mudar o&nbsp;mundo&nbsp;<sup style=\"font-weight: normal;font-size: 12px;\"></sup></p>\r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td style=\"padding: 20px 10px;\">\r\n" + 
				"\r\n" + 
				"                  <!-- social : begin -->\r\n" + 
				"                  <table align=\"center\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"75%\" style=\"margin: 0 auto; \">\r\n" + 
				"                    <tbody>\r\n" + 
				"                      <tr>\r\n" + 
				"\r\n" + 
				"                        <!-- Linkedin -->\r\n" + 
				"                        <td style=\"text-align:center;\">\r\n" + 
				"                          <a href=\"#\" target=\"blank\"><img src=\"https://assets.adin.com.br/clientes/arezzo/emkt/ZZMall/Teste/images/linkedin.png\" width=\"40\" style=\"font-family: Calibri, Helvetica, Arial, sans-serif; font-size: 10px; color: #ffffff; text-transform: uppercase; display: inline-block; width:40px; \" height=\"auto\" alt=\"LinkedIn\" border=\"0\"></a>\r\n" + 
				"                        </td>\r\n" + 
				"\r\n" + 
				"                        <!-- Twitter -->\r\n" + 
				"                        <td style=\" text-align:center; \">\r\n" + 
				"                          <a href=\"#\" target=\"blank\"><img src=\"https://assets.adin.com.br/clientes/arezzo/emkt/ZZMall/Teste/images/instagram.png\" width=\"40\" style=\"font-family: Calibri, Helvetica, Arial, sans-serif; font-size: 10px; color: #ffffff; text-transform: uppercase; display: inline-block; width:40px;\" alt=\"Twitter\" border=\"0\"></a>\r\n" + 
				"                        </td>\r\n" + 
				"\r\n" + 
				"                        <!-- Instagram -->\r\n" + 
				"                        <td style=\" text-align:center; \">\r\n" + 
				"                          <a href=\"#\" target=\"blank\"><img src=\"https://assets.adin.com.br/clientes/arezzo/emkt/ZZMall/Teste/images/twitter.png\" width=\"40\" style=\"font-family: Calibri, Helvetica, Arial, sans-serif; font-size: 10px; color: #ffffff; text-transform: uppercase; display: inline-block; width:40px;\" alt=\"Instagram\" border=\"0\"></a>\r\n" + 
				"                        </td>\r\n" + 
				"\r\n" + 
				"                        <!-- Facebook Icon -->\r\n" + 
				"                        <td style=\" text-align:center; \">\r\n" + 
				"                          <a href=\"#\" target=\"blank\"><img src=\"https://assets.adin.com.br/clientes/arezzo/emkt/ZZMall/Teste/images/facebook.png\" width=\"40\" style=\"font-family: Calibri, Helvetica, Arial, sans-serif; font-size: 10px; color: #ffffff; text-transform: uppercase; display: inline-block; width:40px;\" alt=\"Facebook\" border=\"0\"></a>\r\n" + 
				"                        </td>\r\n" + 
				"                      </tr>\r\n" + 
				"                    </tbody>\r\n" + 
				"                  </table>\r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td height=\"10\">&nbsp;\r\n" + 
				"                  \r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td align=\"center\">\r\n" + 
				"                  <p align=\"center\" style=\"font-family: Franklin Gothic, Calibri, Arial , sans-serif; font-size: 14px; color: #ffffff; text-align:center; line-height: 1.4;\">© Copyright 2021 CAPRAT. Todos os direitos reservados.</p>\r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td height=\"20\">&nbsp;\r\n" + 
				"                  \r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td align=\"center\">\r\n" + 
				"                  <p class=\"fluid center-on-narrow\" style=\"font-family: Franklin Gothic, Calibri, Arial, sans-serif; font-size: 14px; color: #ffffff; line-height: 1.6; font-weight: normal; margin: 0; text-align: center;\">\r\n" + 
				"                    Esta é uma mensagem de <span style=\"display:inline-block;\">CapRat.</span> <br>\r\n" + 
				"                  	Para garantir o recebimento das nossas novidades, <br>adicione <a href=\"mailto:reply@capratvagas.com.br\" style=\"color:#BAD1CE;\">reply@capratvagas.com.br</a> aos seus contatos.\r\n" + 
				"                    <br>\r\n" + 
				"                    <br>\r\n" + 
				"                    <a data-targettype=\"sysaction\" href=\"#\" style=\"color:#ffffff;  padding: 5px;\" title=\"unsubscribe\">Descadastre-se</a> |\r\n" + 
				"                    <a href=\"#\" style=\"color:#ffffff;  padding: 5px;\">Saiba Mais</a> <br>\r\n" + 
				"                    <a href=\"#\" style=\"color:#ffffff; padding: 5px;\">Política de Privacidade</a> &nbsp;|\r\n" + 
				"                    <a href=\"#\" style=\"color:#ffffff; padding: 5px;\">Política de Cookies</a>\r\n" + 
				"                    <br>\r\n" + 
				"                  </p>\r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td height=\"20\">&nbsp;\r\n" + 
				"                  \r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td>\r\n" + 
				"                  <p style=\"font-family: Franklin Gothic, Calibri, Arial , sans-serif; font-size: 14px; color: #ffffff; line-height: 1.6; text-align: center; \">\r\n" + 
				"                    Equipe CAPRAT.<br>\r\n" + 
				"                    Av. Salgado Filho, 3501<br>\r\n" + 
				"                   Guarulhos, São Paulo, Brasil<br>\r\n" + 
				"                    +55 (11) 2565 - 8450\r\n" + 
				"                  </p>\r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td height=\"40\">&nbsp;\r\n" + 
				"                  \r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"            </tbody>\r\n" + 
				"          </table>\r\n" + 
				"\r\n" + 
				"          <!--[if mso | IE]>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"</table>\r\n" + 
				"<![endif]-->\r\n" + 
				"        </div>\r\n" + 
				"      </div>\r\n" + 
				"    </center>\r\n" + 
				"    <img src='https://s2082.t.en25.com/e/FooterImages/FooterImage1?elq=5e8794d175cc400cbed06f5b4aaf2175&siteid=2082' alt=\"\" border=0 width=1px height=1px>\r\n" + 
				"  <script data-cfasync=\"false\" src=\"/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js\"></script></body>\r\n" + 
				"</html>";
		
		this.enviarEmail(dadosUsuario.getEmailUsuario(), "Seja bem vindo à equipe CAPRAT!", htmlEmail);
	}
	
	public void enviarEmailCadastroEmpresa(UsuarioLogin dadosUsuario) {
		String htmlEmail = "<!DOCTYPE html>\r\n" + 
				"<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\r\n" + 
				"  <head>\r\n" + 
				"    <meta http-equiv=\"Content-Type\" content=\"text/html charset=UTF-8\">\r\n" + 
				" <!-- utf-8 works for most cases -->\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width\">\r\n" + 
				" <!-- Forcing initial-scale shouldn't be necessary -->\r\n" + 
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
				" <!-- Use the latest (edge) version of IE rendering engine -->\r\n" + 
				"    <meta name=\"x-apple-disable-message-reformatting\">\r\n" + 
				" <!-- Disable auto-scale in iOS 10 Mail entirely -->\r\n" + 
				"    <title>Welcome to CapRat</title>\r\n" + 
				" <!-- The title tag shows in email notifications, like Android 4.4. -->\r\n" + 
				"\r\n" + 
				"    <!-- Web Font / @font-face : BEGIN -->\r\n" + 
				"\r\n" + 
				"    <!--[if !mso]>\r\n" + 
				"<!-- -->\r\n" + 
				"    <link href=\"https://fonts.googleapis.com/css?family=Oswald&display=swap\" rel=\"stylesheet\">\r\n" + 
				"\r\n" + 
				"    <!--<![endif]-->\r\n" + 
				"    <style>\r\n" + 
				"      html,\r\n" + 
				"      body {\r\n" + 
				"        margin: 0 auto !important;\r\n" + 
				"        padding: 0 !important;\r\n" + 
				"        height: 100% !important;\r\n" + 
				"        width: 100% !important;\r\n" + 
				"      }\r\n" + 
				"      * {\r\n" + 
				"        -ms-text-size-adjust: 100%;\r\n" + 
				"        -webkit-text-size-adjust: 100%;\r\n" + 
				"      }\r\n" + 
				"      .logo{\r\n" + 
				"        position:relative;\r\n" + 
				"        font-size: 1.5rem;\r\n" + 
				"        color:#FEFFF7;\r\n" + 
				"        text-decoration: none;\r\n" + 
				"        font-weight: 400;\r\n" + 
				"        font-family: 'Arial';\r\n" + 
				"        }\r\n" + 
				"      .logo span{\r\n" + 
				"            font-weight: 600;\r\n" + 
				"        }"+
				"      div[style*=\"margin: 16px 0\"] {\r\n" + 
				"        margin: 0 !important;\r\n" + 
				"      }\r\n" + 
				"      table,\r\n" + 
				"      td {\r\n" + 
				"        mso-table-lspace: 0pt !important;\r\n" + 
				"        mso-table-rspace: 0pt !important;\r\n" + 
				"      }\r\n" + 
				"      table {\r\n" + 
				"        border-spacing: 0 !important;\r\n" + 
				"        border-collapse: collapse !important;\r\n" + 
				"        table-layout: fixed !important;\r\n" + 
				"        margin: 0 auto !important;\r\n" + 
				"      }\r\n" + 
				"      table table table {\r\n" + 
				"        table-layout: auto;\r\n" + 
				"      }\r\n" + 
				"      img {\r\n" + 
				"        -ms-interpolation-mode: bicubic;\r\n" + 
				"      }\r\n" + 
				"      a {\r\n" + 
				"        text-decoration: none;\r\n" + 
				"      }\r\n" + 
				"      *[x-apple-data-detectors],\r\n" + 
				"      .unstyle-auto-detected-links *,\r\n" + 
				"      .aBn {\r\n" + 
				"        border-bottom: 0 !important;\r\n" + 
				"        cursor: default !important;\r\n" + 
				"        color: inherit !important;\r\n" + 
				"        text-decoration: none !important;\r\n" + 
				"        font-size: inherit !important;\r\n" + 
				"        font-family: inherit !important;\r\n" + 
				"        font-weight: inherit !important;\r\n" + 
				"        line-height: inherit !important;\r\n" + 
				"      }\r\n" + 
				"      .a6S {\r\n" + 
				"        display: none !important;\r\n" + 
				"        opacity: 0.01 !important;\r\n" + 
				"      }\r\n" + 
				"      img.g-img+div {\r\n" + 
				"        display: none !important;\r\n" + 
				"      }\r\n" + 
				"      @media only screen and (min-device-width: 320px) and (max-device-width: 374px) {\r\n" + 
				"        u~div .email-container {\r\n" + 
				"          min-width: 320px !important;\r\n" + 
				"        }\r\n" + 
				"      }\r\n" + 
				"      @media only screen and (min-device-width: 375px) and (max-device-width: 413px) {\r\n" + 
				"        u~div .email-container {\r\n" + 
				"          min-width: 375px !important;\r\n" + 
				"        }\r\n" + 
				"      }\r\n" + 
				"      @media only screen and (min-device-width: 414px) {\r\n" + 
				"        u~div .email-container {\r\n" + 
				"          min-width: 414px !important;\r\n" + 
				"        }\r\n" + 
				"      }\r\n" + 
				"      @media screen and (max-width: 480px) {\r\n" + 
				"        .fluid {\r\n" + 
				"          width: 100% !important;\r\n" + 
				"          max-width: 100% !important;\r\n" + 
				"          height: auto !important;\r\n" + 
				"          margin-left: auto !important;\r\n" + 
				"          margin-right: auto !important;\r\n" + 
				"        }\r\n" + 
				"        .mobile-button {\r\n" + 
				"          width: 90% !important;\r\n" + 
				"          max-width: 90% !important;\r\n" + 
				"          height: auto !important;\r\n" + 
				"          margin-left: auto !important;\r\n" + 
				"          margin-right: auto !important;\r\n" + 
				"        }\r\n" + 
				"        .mobile-text {\r\n" + 
				"          font-size: 48px !important;\r\n" + 
				"        }\r\n" + 
				"        .stack-column,\r\n" + 
				"        .stack-column-center {\r\n" + 
				"          display: block !important;\r\n" + 
				"          width: 100% !important;\r\n" + 
				"          max-width: 100% !important;\r\n" + 
				"          direction: ltr !important;\r\n" + 
				"        }\r\n" + 
				"        .stack-column-center {\r\n" + 
				"          text-align: center !important;\r\n" + 
				"        }\r\n" + 
				"        .center-on-narrow {\r\n" + 
				"          text-align: center !important;\r\n" + 
				"          display: block !important;\r\n" + 
				"          margin-left: auto !important;\r\n" + 
				"          margin-right: auto !important;\r\n" + 
				"          float: none !important;\r\n" + 
				"        }\r\n" + 
				"        table.center-on-narrow {\r\n" + 
				"          display: inline-block !important;\r\n" + 
				"        }\r\n" + 
				"        .hide-mobile {\r\n" + 
				"          display: none;\r\n" + 
				"        }\r\n" + 
				"      }\r\n" + 
				"    </style>\r\n" + 
				"\r\n" + 
				"    <!-- CSS Reset : END -->\r\n" + 
				"\r\n" + 
				"    <!-- fontfixing -->\r\n" + 
				"\r\n" + 
				"    <!-- Web Font / @font-face : BEGIN -->\r\n" + 
				"\r\n" + 
				"    <!--[if mso]>\r\n" + 
				"<style type=”text/css”>\r\n" + 
				".fallback-font {\r\n" + 
				"font-family: Verdana, Arial, sans-serif;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"\r\n" + 
				"<!-- Reset list spacing because Outlook ignores much of our inline CSS. -->\r\n" + 
				"\r\n" + 
				"    <!--[if mso]>\r\n" + 
				"<style type=\"text/css\">\r\n" + 
				"ul,\r\n" + 
				"ol {\r\n" + 
				"margin: 0 !important;\r\n" + 
				"}\r\n" + 
				"li {\r\n" + 
				"margin-left: 30px !important;\r\n" + 
				"}\r\n" + 
				"li.list-item-first {\r\n" + 
				"margin-top: 0 !important;\r\n" + 
				"}\r\n" + 
				"li.list-item-last {\r\n" + 
				"margin-bottom: 10px !important;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"<![endif]-->\r\n" + 
				"\r\n" + 
				"    <!-- Progressive Enhancements : BEGIN -->\r\n" + 
				"    <style>\r\n" + 
				"      .btn-a. btn-td {\r\n" + 
				"        transition: all 100ms ease-in;\r\n" + 
				"      }\r\n" + 
				"      .btn-a:hover {\r\n" + 
				"        color: #ffffff !important;\r\n" + 
				"        background-color: #01807e !important;\r\n" + 
				"      }\r\n" + 
				"      .btn-b:hover {\r\n" + 
				"        color: #253746 !important;\r\n" + 
				"        background-color: #ffffff !important;\r\n" + 
				"        border: 2px solid #253746 !important;\r\n" + 
				"      }\r\n" + 
				"    </style>\r\n" + 
				"\r\n" + 
				"    <!-- Progressive Enhancements : END -->\r\n" + 
				"\r\n" + 
				"    <!-- What it does: Makes background images in 72ppi Outlook render at correct size. -->\r\n" + 
				"\r\n" + 
				"    <!--[if gte mso 9]>\r\n" + 
				"<xml>\r\n" + 
				"<o:OfficeDocumentSettings>\r\n" + 
				"<o:AllowPNG/>\r\n" + 
				"<o:PixelsPerInch>96</o:PixelsPerInch>\r\n" + 
				"</o:OfficeDocumentSettings>\r\n" + 
				"</xml>\r\n" + 
				"<![endif]-->\r\n" + 
				"  </head>\r\n" + 
				"  <body width=\"100%\" style=\"margin: 0; padding: 0 !important; mso-line-height-rule: exactly; background-color: #ffffff;\">\r\n" + 
				"    <center style=\"width: 100%; background-color: #ffffff;\">\r\n" + 
				"\r\n" + 
				"      <!--[if mso | IE]>\r\n" + 
				"<table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"background-color: #363636;\">\r\n" + 
				"<tr>\r\n" + 
				"<td>\r\n" + 
				"<![endif]-->\r\n" + 
				"\r\n" + 
				"      <!-- Visually Hidden Preheader Text : BEGIN -->\r\n" + 
				"      <div style=\"display: none; font-size: 1px; line-height: 1px; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden; mso-hide: all; font-family: sans-serif; color: #ffffff;\">\r\n" + 
				"        Prepare-se para se tornar mais um rato de boné!\r\n" + 
				"      </div>\r\n" + 
				"\r\n" + 
				"      <!-- Visually Hidden Preheader Text : END -->\r\n" + 
				"      <div style=\"max-width: 600px; margin: 0 auto;\" class=\"email-container\">\r\n" + 
				"\r\n" + 
				"        <!--[if mso]>\r\n" + 
				"<table align=\"center\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"600\">\r\n" + 
				"<tr>\r\n" + 
				"<td>\r\n" + 
				"<![endif]-->\r\n" + 
				"\r\n" + 
				"        <!-- Email Body : BEGIN -->\r\n" + 
				"\r\n" + 
				"        <!-- view online: BEGIN -->\r\n" + 
				"        <table align=\"center\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"margin: 0 auto;\">\r\n" + 
				"          <tbody>\r\n" + 
				"            <tr>\r\n" + 
				"              <td align=\"center\" style=\"font-family: Arial, sans-serif; font-size: 11px; color: #363636; text-align:center; line-height: 2; text-align: center; padding: 10px;\">Caso esteja enfrentando problemas para visualizar este e-mail, <a href=\"#\" target=\"_blank\" style=\"text-decoration:underline; color:#363636;\">clique aqui para ver online.</a>\r\n" + 
				"              </td>\r\n" + 
				"            </tr>\r\n" + 
				"          </tbody>\r\n" + 
				"        </table>\r\n" + 
				"\r\n" + 
				"        <!-- View Online: END-->\r\n" + 
				"\r\n" + 
				"        <!-- Logo Bar : BEGIN -->\r\n" + 
				"		 <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"background-color: #363636; margin: 0 auto; max-width: 600px; padding: 10px;\">\r\n" + 
				"          <tbody>\r\n" + 
				"            <tr>\r\n" + 
				"              <td align=\"center\" width=\"100%\"valign=\"middle\" style=\" text-align: center; width: 100%; padding: 15px;\"><font class=\"logo\">CAP<span>RAT</span></font>\r\n" + 
				"              </td>\r\n" + 
				"            </tr>\r\n" + 
				"          </tbody>\r\n" + 
				"        </table>"+
				"\r\n" + 
				"        <!-- Reverse Logo Bar : END -->\r\n" + 
				"\r\n" + 
				"        <!-- 1 Column : BEGIN -->\r\n" + 
				"        <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"background-color: #363636; margin: 0 auto; text-align: center;\">\r\n" + 
				"          <tbody>\r\n" + 
				"            <tr>\r\n" + 
				"              <td width=\"600\" align=\"center\" style=\"width:100%; padding: 0;\">\r\n" + 
				"                <img src=\"https://assets.adin.com.br/clientes/arezzo/emkt/ZZMall/Teste/images/banner.gif\" class=\"fluid g-img\" width=\"600\" height=\"auto\" alt=\". / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / . / .\" border=\"0\" style=\"width: 100%; max-width: 600px; height: auto; background: #363636; font-family: Arial Narrow, sans-serif; letter-spacing: 1px; font-weight: bold; font-size: 32px; line-height: 1.6; text-transform: uppercase; text-align: center !important; margin: 0 auto; padding: 0; color:#ffffff; line-height: 1.2;\">\r\n" + 
				"              </td>\r\n" + 
				"            </tr>\r\n" + 
				"          </tbody>\r\n" + 
				"        </table>\r\n" + 
				"        <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"background-color: #363636; margin: 0 auto; text-align: center;\">\r\n" + 
				"          <tbody>\r\n" + 
				"            <tr>\r\n" + 
				"              <td style=\"background-color: #363636; padding: 0 40px;\">\r\n" + 
				"                <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"width: 100%; max-width: 600px;\">\r\n" + 
				"                  <tbody>\r\n" + 
				"                    <tr>\r\n" + 
				"                      <td style=\"padding: 20px 10px; text-align: left; line-height: 1.1; mso-line-height-rule:exactly;\" class=\"\">\r\n" + 
				"\r\n" + 
				"                        <!--[if mso]>\r\n" + 
				"<h1 style=\"margin:0; font-family: Arial Narrow, Verdana, Gill Sans, sans-serif; font-size: 64px; line-height: 1.1; color: #ffffff; font-weight: bold; mso-line-height-rule:exactly; padding: 0; \">\r\n" + 
				"Let's get to know each other<span color=\"#00a4b5\" style=\"color: #00a4b5; font-family: Arial Narrow, Arial; padding: 0; line-height: 0; display: inline;\">.\r\n" + 
				"</span></h1>\r\n" + 
				"<![endif]-->\r\n" + 
				"\r\n" + 
				"                        <!--[if !mso]>\r\n" + 
				"<!-->\r\n" + 
				"                        <h1 style=\"margin:0; font-family: Arial, Helvetica, sans-serifsans-serif; font-size: 54px; line-height: 1; color: #ffffff; font-weight: normal; mso-line-height-rule:exactly; mso-font-alt: 'Verdana', 'Arial'; padding: 0; \" class=\"\">Vamos nos <br>conhecer melhor<span color=\"#00a4b5\" style=\"color: #BAD1CE; font-family: Arial Narrow, Arial; padding: 0; line-height: 0; display: inline;\">?\r\n" + 
				"</span></h1>\r\n" + 
				"\r\n" + 
				"                        <!--<![endif]-->\r\n" + 
				"                      </td>\r\n" + 
				"                    </tr>\r\n" + 
				"                  </tbody>\r\n" + 
				"                </table>\r\n" + 
				"                <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"width: 100%; max-width: 600px;\">\r\n" + 
				"                  <tbody>\r\n" + 
				"                    <tr>\r\n" + 
				"                      <td style=\"padding: 20px 10px; text-align: left; font-family: Arial, Calibri, Verdana, Helvetica, sans-serif; font-size: 20px; color: #ffffff; line-height: 28px; mso-line-height-rule:exactly;\" class=\"\">\r\n" + 
				"                        <p style=\"margin:0; font-family: Arial, Calibri, Verdana, Helvetica, sans-serif; font-size: 20px; color: #ffffff; line-height: 150%; line=height:24px; mso-line-height-rule:exactly;\" class=\"\">Olá <span style=\"color: #BAD1CE;\">" + dadosUsuario.getApelidoUsuario() + ",</span> <br><br>Bem-vindo ao CAPRAT Vagas! Sua empresa está prestes a decolar! Ganhe mais visibilidade para as suas vagas de emprego disponíveis e encontre os melhores funcionários possíveis!<br><br>\r\n" + 
				"                          Seguem seus dados:\r\n" + 
				"                          <br>E-mail: <span style=\"color: #BAD1CE;\">" + dadosUsuario.getEmailUsuario() + "</span><br>Senha: <span style=\"color: #BAD1CE;\"> " + dadosUsuario.getSenhaUsuario() + " </span><br><br>\r\n" + 
				"                          Entre em nosso site, complete seu cadastro e disponibilize suas vagas para nossos usuários!\r\n" + 
				"                        </p>\r\n" + 
				"                      </td>\r\n" + 
				"                    </tr>\r\n" + 
				"                  </tbody>\r\n" + 
				"                </table>\r\n" + 
				"              </td>\r\n" + 
				"            </tr>\r\n" + 
				"            <tr>\r\n" + 
				"              <td height=\"40\" style=\"font-size: 0px; line-height: 0px; background-color: #363636;\" class=\"\">&nbsp;\r\n" + 
				"                \r\n" + 
				"              </td>\r\n" + 
				"            </tr>\r\n" + 
				"            <tr>\r\n" + 
				"              <td align=\"center\" style=\"background-color: #363636; padding: 0 40px; text-align: center;\">\r\n" + 
				"\r\n" + 
				"                <!-- button: begin -->\r\n" + 
				"                <table class=\"mobile-button\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" align=\"center\" style=\"width: 100%; max-width: 600px; background-color: #363636;\">\r\n" + 
				"                  <tbody>\r\n" + 
				"                    <tr>\r\n" + 
				"                      <td bgcolor=\"#363636\" class=\"mobile-button\" align=\"center\">\r\n" + 
				"                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"text-align: center;\">\r\n" + 
				"                          <tbody>\r\n" + 
				"                            <tr>\r\n" + 
				"                              <td align=\"center\" bgcolor=\"white\" width=\"300\" style=\"border-radius: 4px;\"><a href=\"http://localhost:8080/pages/login/login.jsp\" style=\"font-size: 18px; font-family:Arial, Calibri, Geneva, sans-serif; color: #363636; text-decoration: none !important; text-transform: uppercase; font-weight: normal; padding: 18px; border: 2px solid white; display: inline-block;\">FINALIZAR CADASTRO</a></td>\r\n" + 
				"                            </tr>\r\n" + 
				"                          </tbody>\r\n" + 
				"                        </table>\r\n" + 
				"                      </td>\r\n" + 
				"                    </tr>\r\n" + 
				"                  </tbody>\r\n" + 
				"                </table>\r\n" + 
				"\r\n" + 
				"                <!-- button: end -->\r\n" + 
				"              </td>\r\n" + 
				"            </tr>\r\n" + 
				"            <tr>\r\n" + 
				"              <td>\r\n" + 
				"\r\n" + 
				"                <!-- Clear Spacer : BEGIN -->\r\n" + 
				"                <table aria-hidden=\"true\" align=\"center\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"margin: 0 auto; \">\r\n" + 
				"                  <tbody>\r\n" + 
				"                    <tr>\r\n" + 
				"                      <td height=\"100\" style=\"font-size: 0px; line-height: 0px; background-color: #363636;\">&nbsp;\r\n" + 
				"                        \r\n" + 
				"                      </td>\r\n" + 
				"                    </tr>\r\n" + 
				"                  </tbody>\r\n" + 
				"                </table>\r\n" + 
				"\r\n" + 
				"                <!-- Clear Spacer : END -->\r\n" + 
				"              </td>\r\n" + 
				"            </tr>\r\n" + 
				"          </tbody>\r\n" + 
				"        </table>\r\n" + 
				"\r\n" + 
				"        <!-- 1 Column : END -->\r\n" + 
				"\r\n" + 
				"        <!-- Email Footer : BEGIN -->\r\n" + 
				"        <div style=\"max-width: 600px; margin: 0 auto;\" class=\"email-container\">\r\n" + 
				"\r\n" + 
				"          <!--[if mso]>\r\n" + 
				"<table align=\"center\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"600\" bgcolor=\"#00a4b5\">\r\n" + 
				"<tr>\r\n" + 
				"<td>\r\n" + 
				"<![endif]-->\r\n" + 
				"          <table bgcolor=\"#242424\" align=\"center\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"margin: 0 auto; text-align: center; padding: 10px 20px;\">\r\n" + 
				"            <tbody>\r\n" + 
				"              <tr>\r\n" + 
				"                <td height=\"40\">&nbsp;</td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td width=\"80%\" align=\"center\">\r\n" + 
				"                  <p style=\"margin:0; mso-line-height-rule:exactly; font-family: Georgia, serif; font-size: 16px; color: #ffffff; text-align:center;line-height: 1.6; letter-spacing: 1px; font-style: italic;text-align: center;font-weight: normal;\">Empoderando pessoas para mudar o&nbsp;mundo&nbsp;<sup style=\"font-weight: normal;font-size: 12px;\"></sup></p>\r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td style=\"padding: 20px 10px;\">\r\n" + 
				"\r\n" + 
				"                  <!-- social : begin -->\r\n" + 
				"                  <table align=\"center\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"75%\" style=\"margin: 0 auto; \">\r\n" + 
				"                    <tbody>\r\n" + 
				"                      <tr>\r\n" + 
				"\r\n" + 
				"                        <!-- Linkedin -->\r\n" + 
				"                        <td style=\"text-align:center;\">\r\n" + 
				"                          <a href=\"#\" target=\"blank\"><img src=\"https://assets.adin.com.br/clientes/arezzo/emkt/ZZMall/Teste/images/linkedin.png\" width=\"40\" style=\"font-family: Calibri, Helvetica, Arial, sans-serif; font-size: 10px; color: #ffffff; text-transform: uppercase; display: inline-block; width:40px; \" height=\"auto\" alt=\"LinkedIn\" border=\"0\"></a>\r\n" + 
				"                        </td>\r\n" + 
				"\r\n" + 
				"                        <!-- Twitter -->\r\n" + 
				"                        <td style=\" text-align:center; \">\r\n" + 
				"                          <a href=\"#\" target=\"blank\"><img src=\"https://assets.adin.com.br/clientes/arezzo/emkt/ZZMall/Teste/images/instagram.png\" width=\"40\" style=\"font-family: Calibri, Helvetica, Arial, sans-serif; font-size: 10px; color: #ffffff; text-transform: uppercase; display: inline-block; width:40px;\" alt=\"Twitter\" border=\"0\"></a>\r\n" + 
				"                        </td>\r\n" + 
				"\r\n" + 
				"                        <!-- Instagram -->\r\n" + 
				"                        <td style=\" text-align:center; \">\r\n" + 
				"                          <a href=\"#\" target=\"blank\"><img src=\"https://assets.adin.com.br/clientes/arezzo/emkt/ZZMall/Teste/images/twitter.png\" width=\"40\" style=\"font-family: Calibri, Helvetica, Arial, sans-serif; font-size: 10px; color: #ffffff; text-transform: uppercase; display: inline-block; width:40px;\" alt=\"Instagram\" border=\"0\"></a>\r\n" + 
				"                        </td>\r\n" + 
				"\r\n" + 
				"                        <!-- Facebook Icon -->\r\n" + 
				"                        <td style=\" text-align:center; \">\r\n" + 
				"                          <a href=\"#\" target=\"blank\"><img src=\"https://assets.adin.com.br/clientes/arezzo/emkt/ZZMall/Teste/images/facebook.png\" width=\"40\" style=\"font-family: Calibri, Helvetica, Arial, sans-serif; font-size: 10px; color: #ffffff; text-transform: uppercase; display: inline-block; width:40px;\" alt=\"Facebook\" border=\"0\"></a>\r\n" + 
				"                        </td>\r\n" + 
				"                      </tr>\r\n" + 
				"                    </tbody>\r\n" + 
				"                  </table>\r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td height=\"10\">&nbsp;\r\n" + 
				"                  \r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td align=\"center\">\r\n" + 
				"                  <p align=\"center\" style=\"font-family: Franklin Gothic, Calibri, Arial , sans-serif; font-size: 14px; color: #ffffff; text-align:center; line-height: 1.4;\">© Copyright 2021 CAPRAT. Todos os direitos reservados.</p>\r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td height=\"20\">&nbsp;\r\n" + 
				"                  \r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td align=\"center\">\r\n" + 
				"                  <p class=\"fluid center-on-narrow\" style=\"font-family: Franklin Gothic, Calibri, Arial, sans-serif; font-size: 14px; color: #ffffff; line-height: 1.6; font-weight: normal; margin: 0; text-align: center;\">\r\n" + 
				"                    Esta é uma mensagem de <span style=\"display:inline-block;\">CapRat.</span> <br>\r\n" + 
				"                  	Para garantir o recebimento das nossas novidades, <br>adicione <a href=\"mailto:reply@capratvagas.com.br\" style=\"color:#BAD1CE;\">reply@capratvagas.com.br</a> aos seus contatos.\r\n" + 
				"                    <br>\r\n" + 
				"                    <br>\r\n" + 
				"                    <a data-targettype=\"sysaction\" href=\"#\" style=\"color:#ffffff;  padding: 5px;\" title=\"unsubscribe\">Descadastre-se</a> |\r\n" + 
				"                    <a href=\"#\" style=\"color:#ffffff;  padding: 5px;\">Saiba Mais</a> <br>\r\n" + 
				"                    <a href=\"#\" style=\"color:#ffffff; padding: 5px;\">Política de Privacidade</a> &nbsp;|\r\n" + 
				"                    <a href=\"#\" style=\"color:#ffffff; padding: 5px;\">Política de Cookies</a>\r\n" + 
				"                    <br>\r\n" + 
				"                  </p>\r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td height=\"20\">&nbsp;\r\n" + 
				"                  \r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td>\r\n" + 
				"                  <p style=\"font-family: Franklin Gothic, Calibri, Arial , sans-serif; font-size: 14px; color: #ffffff; line-height: 1.6; text-align: center; \">\r\n" + 
				"                    Equipe CAPRAT.<br>\r\n" + 
				"                    Av. Salgado Filho, 3501<br>\r\n" + 
				"                   Guarulhos, São Paulo, Brasil<br>\r\n" + 
				"                    +55 (11) 2565 - 8450\r\n" + 
				"                  </p>\r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"              <tr>\r\n" + 
				"                <td height=\"40\">&nbsp;\r\n" + 
				"                  \r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"            </tbody>\r\n" + 
				"          </table>\r\n" + 
				"\r\n" + 
				"          <!--[if mso | IE]>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"</table>\r\n" + 
				"<![endif]-->\r\n" + 
				"        </div>\r\n" + 
				"      </div>\r\n" + 
				"    </center>\r\n" + 
				"    <img src='https://s2082.t.en25.com/e/FooterImages/FooterImage1?elq=5e8794d175cc400cbed06f5b4aaf2175&siteid=2082' alt=\"\" border=0 width=1px height=1px>\r\n" + 
				"  <script data-cfasync=\"false\" src=\"/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js\"></script></body>\r\n" + 
				"</html>";
		
		this.enviarEmail(dadosUsuario.getEmailUsuario(), "Seja bem vindo à equipe CAPRAT!", htmlEmail);
	}
	
	private void enviarEmail(String emailPara, String emailAssunto, String htmlEmail) {
		
		String smtpHost 	= "smtp.gmail.com"; 
		String smtpPort 	= "587"; 
		String username 	= "capratofficial@gmail.com";
		String password 	= "PWH0j*N^LL&Uoxu";
		String auth     	= "tls";  
		SendMail sendMail 	=  new SendMail( smtpHost,  smtpPort,  username,  password,  auth  );
		
		String mailFrom 	= "capratofficial@gmail.com"; 
	 	String mailTo 		= emailPara; 
	 	String mailSubject 	= emailAssunto; 
	 	String mailBody 	= htmlEmail; 
		sendMail.send( mailFrom, mailTo, mailSubject, mailBody );
	}
}
