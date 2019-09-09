package web.servlet;

import domain.Blog;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.BlogService;
import service.UserService;
import service.impl.BlogServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addBlogServlet")
public class addBlogServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //1.设置编码
        req.setCharacterEncoding("utf-8");
        //2.获取参数
        //req.setAttribute("title","你好————");
        Map<String,String[]> map = req.getParameterMap();
        //map.put("title",new String[]{"你好"});

        map.forEach((k,v) -> {
            System.out.println("k = " + k + ", v " + v[0]);
        });

        //3.封装对象
        Blog blog = new Blog();
        try {
            BeanUtils.populate(blog,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4.调用service保存
        BlogService service = new BlogServiceImpl();
        service.addBlog(blog);

        //跳转到BlogListServlet
        resp.sendRedirect(req.getContextPath()+"/findBlogByPageServlet");
    }
}
