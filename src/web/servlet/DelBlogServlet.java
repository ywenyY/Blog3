package web.servlet;

import domain.Blog;
import service.BlogService;
import service.UserService;
import service.impl.BlogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delBlogServlet")
public class DelBlogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取id
        String id = req.getParameter("id");
        //2.调用service删除
        BlogService service = new BlogServiceImpl();
        service.deleteBlog(id);
        //3.跳转到查询所有博客界面
        resp.sendRedirect(req.getContextPath()+"/findBlogByPageServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
