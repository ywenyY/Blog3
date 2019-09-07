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

@WebServlet("/findBlogForShowServlet")
public class FindBlogForShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取id
        String id = request.getParameter("id");
        //2.调用service查询
        BlogService service = new BlogServiceImpl();
        Blog blog = service.findBlogById(id);
        //3.将user存入request
        request.setAttribute("blog",blog);
        //4.转发到update.jsp中
        System.out.println("Forshow : saying something -----");
        request.getRequestDispatcher("/showBlog.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
