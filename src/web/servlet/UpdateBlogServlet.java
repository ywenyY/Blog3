package web.servlet;

import domain.Blog;
import org.apache.commons.beanutils.BeanUtils;
import service.BlogService;
import service.impl.BlogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateBlogServlet")
public class UpdateBlogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //1.设置编码
        req.setCharacterEncoding("utf-8");
            //2.获取map
        Map<String,String[]> map = req.getParameterMap();
            //3.封装对象
        Blog blog = new Blog();
        try {
            BeanUtils.populate(blog,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4.调用service修改
        System.out.println(blog);
        BlogService service = new BlogServiceImpl();
        service.updateBlog(blog);

        //5.跳转到查询页面
        resp.sendRedirect(req.getContextPath()+"/findBlogByPageServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
