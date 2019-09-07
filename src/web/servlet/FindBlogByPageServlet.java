package web.servlet;

import domain.Blog;
import domain.PageBean;
import service.BlogService;
import service.impl.BlogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findBlogByPageServlet")
public class FindBlogByPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //1.获取参数
        String currentPage = req.getParameter("currentPage");//当前页码
        String rows = req.getParameter("rows"); //每页显示条数

        //点击到第一页时不能继续点击的bug
        if(currentPage == null || "".equals(currentPage)){
            currentPage="1";
        }
        if (rows == null || "".equals(rows)){
            rows = "8";
        }

        //2.调用service查询
        BlogService service = new BlogServiceImpl();
        PageBean<Blog> pb = service.findBlogByPage(currentPage,rows);

        System.out.println(pb);

        //3.将pageBean存入request
        req.setAttribute("pb",pb);
        //4.转发到index.jsp
        req.getRequestDispatcher("/in.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
