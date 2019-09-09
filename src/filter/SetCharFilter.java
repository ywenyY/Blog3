package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.util.logging.LogRecord;

public class SetCharFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
            System.out.println("你好，这是一个被初始化的过滤器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
         servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
         servletResponse.setContentType("text/html;charset=utf-8");
         HttpSession hs = ((HttpServletRequest) servletRequest).getSession();
          HttpServletRequest request = (HttpServletRequest)servletRequest;
        if(hs.getServletContext().getRealPath(request.getRequestURI()).contains("loginServlet")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        if(hs.getAttribute("spe") == null) {
            PrintWriter out = servletResponse.getWriter();
            out.write("alert('你还没有登陆噢');");
            ((HttpServletRequest) servletRequest).getRequestDispatcher("login.jsp").forward(servletRequest, servletResponse);
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        } else {
            System.out.println(hs.getAttribute("spe"));
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }


    @Override
    public void destroy() {

    }
}

