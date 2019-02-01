package firstcup.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.PushBuilder;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter("/*")
public class StaticResourceFilter extends HttpFilter {

    private static final Logger logger = Logger.getLogger(StaticResourceFilter.class.getName());


    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        PushBuilder pushBuilder = ((HttpServletRequest) req).newPushBuilder();
        pushBuilder.path("css/style.css").push();
        logger.info("PUSH BUILDER: " + pushBuilder.getPath());
        super.doFilter(req, res, chain);
    }
}
