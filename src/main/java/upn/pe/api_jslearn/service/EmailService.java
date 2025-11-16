package upn.pe.api_jslearn.service;

import com.resend.Resend;
import com.resend.services.emails.model.CreateEmailOptions;
import com.resend.services.emails.model.CreateEmailResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final Resend resend;

    @Value("${resend.from}")
    private String from;

    @Value("${app.base-url}")
    private String baseUrl;

    public EmailService(@Value("${resend.api.key}") String apiKey) {
        this.resend = new Resend(apiKey);
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

        CreateEmailOptions request = CreateEmailOptions.builder()
                .from(from)
                .to(to)
                .subject(subject)
                .html(html)
                .build();

        try {
            CreateEmailResponse response = resend.emails().send(request);
            System.out.println("Correo enviado, id = " + response.getId());
        } catch (Exception e) {
            System.err.println("Error enviando correo de verificación: " + e.getMessage());
        }
    }

}
