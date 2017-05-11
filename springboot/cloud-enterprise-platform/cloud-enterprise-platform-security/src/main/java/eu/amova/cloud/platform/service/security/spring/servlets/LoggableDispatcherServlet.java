package eu.amova.cloud.platform.service.security.spring.servlets;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author: vuru
 * Date: 11.05.2017
 * Time: 15:07
 */
public class LoggableDispatcherServlet extends DispatcherServlet {

    private class LogMessage{

        private int httpStatus;
        private String responsePayload;
        private String javaMethod;
        private String clientIp;
        private String path;
        private String method;

        public void setHttpStatus(int httpStatus) {
            this.httpStatus = httpStatus;
        }


        public void setResponse(String responsePayload) {
            this.responsePayload = responsePayload;
        }

        public void setJavaMethod(String javaMethod) {
            this.javaMethod = javaMethod;
        }

        public void setClientIp(String clientIp) {
            this.clientIp = clientIp;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public void setHttpMethod(String method) {
            this.method = method;
        }

        @Override
        public String toString() {
            return "{" +
                    "httpStatus=" + httpStatus +
                    ", responsePayload='" + responsePayload + '\'' +
                    ", javaMethod='" + javaMethod + '\'' +
                    ", clientIp='" + clientIp + '\'' +
                    ", path='" + path + '\'' +
                    ", method='" + method + '\'' +
                    '}';
        }
    }
    private final Log logger = LogFactory.getLog(getClass());

    @Override
    protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (!(request instanceof ContentCachingRequestWrapper)) {
            request = new ContentCachingRequestWrapper(request);
        }
        if (!(response instanceof ContentCachingResponseWrapper)) {
            response = new ContentCachingResponseWrapper(response);
        }
        HandlerExecutionChain handler = getHandler(request);

        try {
            super.doDispatch(request, response);
        } finally {
            log(request, response, handler);
            updateResponse(response);
        }
    }

    private void log(HttpServletRequest requestToCache, HttpServletResponse responseToCache, HandlerExecutionChain handler) {
        LogMessage log = new LogMessage();
        log.setHttpStatus(responseToCache.getStatus());
        log.setHttpMethod(requestToCache.getMethod());
        log.setPath(requestToCache.getRequestURI());
        log.setClientIp(requestToCache.getRemoteAddr());
        log.setJavaMethod(handler.toString());
        log.setResponse(getResponsePayload(responseToCache));
        logger.debug(log);
    }

    private String getResponsePayload(HttpServletResponse response) {
        ContentCachingResponseWrapper wrapper = WebUtils.getNativeResponse(response, ContentCachingResponseWrapper.class);
        if (wrapper != null) {

            byte[] buf = wrapper.getContentAsByteArray();
            if (buf.length > 0) {
                int length = Math.min(buf.length, 5120);
                try {
                    return new String(buf, 0, length, wrapper.getCharacterEncoding());
                }
                catch (UnsupportedEncodingException ex) {
                    // NOOP
                }
            }
        }
        return "[unknown]";
    }

    private void updateResponse(HttpServletResponse response) throws IOException {
        ContentCachingResponseWrapper responseWrapper =
                WebUtils.getNativeResponse(response, ContentCachingResponseWrapper.class);
        responseWrapper.copyBodyToResponse();
    }

}