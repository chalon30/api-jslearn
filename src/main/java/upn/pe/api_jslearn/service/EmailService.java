package upn.pe.api_jslearn.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Value("${app.base-url}")
    private String baseUrl;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendVerificationEmail(String to, String nombre, String token) {
        String verifyUrl = baseUrl + "/api/auth/confirmar?token=" + token;

        String subject = "Activa tu cuenta en Dev School";

        String html = """
                <h1>Hola %s 👋</h1>
                <p>Gracias por registrarte en <strong>Dev School</strong>.</p>
                <p>Para activar tu cuenta, haz clic en el botón siguiente:</p>
                <p>
                  <a href="%s"
                     style="background:#2563eb;color:white;padding:10px 16px;text-decoration:none;border-radius:6px;">
                     Confirmar cuenta
                  </a>
                </p>
                <p>Si tú no creaste esta cuenta, puedes ignorar este correo.</p>
                """.formatted(nombre, verifyUrl);

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(html, true); // true = enviar como HTML

            mailSender.send(message);

            System.out.println("Correo enviado correctamente a: " + to);

        } catch (Exception e) {
            System.err.println("Error enviando correo: " + e.getMessage());
        }
    }
}
