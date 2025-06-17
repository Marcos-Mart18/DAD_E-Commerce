package pe.edu.upeu.microservice_notification.infrastructure.mail;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import pe.edu.upeu.microservice_notification.domain.model.Notification;
import pe.edu.upeu.microservice_notification.infrastructure.resolver.ChannelResolver;

import java.io.IOException;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmailSenderAdapter {

    private final JavaMailSender mailSender;

    public void send(Notification notification) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("falconsanchezabel97@gmail.com"); // Puedes hacerlo configurable si quieres
            message.setTo(notification.getRecipient());
            message.setSubject(notification.getSubject());
            message.setText(notification.getMessage());

            mailSender.send(message);
            log.info("✅ Email enviado a {}", notification.getRecipient());

        } catch (Exception e) {
            log.error("❌ Error al enviar email: {}", e.getMessage());
            throw new RuntimeException("Error al enviar email", e);
        }
    }
}
