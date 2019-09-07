package web.servlet;

import domain.Blog;
import service.BlogService;
import service.impl.BlogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findBlogServlet")
public class FindBlogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取id
        String id = req.getParameter("id");
        //2.调用service查询
        BlogService service = new BlogServiceImpl();
        Blog blog = service.findBlogById(id);
        //3.将user存入request
        req.setAttribute("blog",blog);
        //4.转发到update.jsp中
        req.getRequestDispatcher("/update.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
