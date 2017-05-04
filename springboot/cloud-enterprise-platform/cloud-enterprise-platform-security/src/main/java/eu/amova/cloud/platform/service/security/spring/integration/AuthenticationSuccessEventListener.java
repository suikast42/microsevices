package eu.amova.cloud.platform.service.security.spring.integration;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;

/**
 * @author: vuru
 * Date: 04.05.2017
 * Time: 10:43
 */
@Component
public class AuthenticationSuccessEventListener implements ApplicationListener<AbstractAuthenticationEvent> {

    // TODO: 04.05.2017 Track logged in users 
    // TODO: 04.05.2017 Limit the user logins 
    @Autowired
    private Log logger;

    @Override
    public void onApplicationEvent(final AbstractAuthenticationEvent e) {
    //        BadCredentialsException.class ->  AuthenticationFailureBadCredentialsEvent.class
    //        UsernameNotFoundException.class ->  AuthenticationFailureBadCredentialsEvent.class
    //        AccountExpiredException.class ->  AuthenticationFailureExpiredEvent.class
    //        ProviderNotFoundException.class ->  AuthenticationFailureProviderNotFoundEvent.class
    //        DisabledException.class ->  AuthenticationFailureDisabledEvent.class
    //        LockedException.class ->  AuthenticationFailureLockedEvent.class
    //        AuthenticationServiceException.class ->  AuthenticationFailureServiceExceptionEvent.class
    //        CredentialsExpiredException.class ->  AuthenticationFailureCredentialsExpiredEvent.class

        if (e instanceof AuthenticationSuccessEvent) {
            onApplicationEvent((AuthenticationSuccessEvent) e);
        } else if (e instanceof AuthenticationFailureBadCredentialsEvent) {
            onApplicationEvent((AuthenticationFailureBadCredentialsEvent) e);
        } else {
            logger.warn(MessageFormat.format("Unhandled AuthenticationEvent {0} ", eventToString(e)));
        }
//        final WebAuthenticationDetails auth = (WebAuthenticationDetails) e.getAuthentication().getDetails();
//        if (auth != null) {
//            loginAttemptService.loginSucceeded(auth.getRemoteAddress());
//        }
    }

    private void onApplicationEvent(AuthenticationFailureBadCredentialsEvent e) {
        logger.debug(eventToString(e));
    }

    private void onApplicationEvent(AuthenticationSuccessEvent e) {
        logger.debug(eventToString(e));
    }


    private String eventToString(AbstractAuthenticationEvent event) {
        final StringBuilder builder = new StringBuilder();
        builder.append("Authentication event ");
        builder.append(ClassUtils.getShortName(event.getClass()));
        builder.append(": ");
        builder.append(event.getAuthentication().getName());
        builder.append("; details: ");
        builder.append(event.getAuthentication().getDetails());

        if (event instanceof AbstractAuthenticationFailureEvent) {
            builder.append("; exception: ");
            builder.append(((AbstractAuthenticationFailureEvent) event)
                    .getException().getMessage());
        }
        return builder.toString();
    }
}
