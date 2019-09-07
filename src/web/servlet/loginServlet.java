package web.servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        //2.获取数据
        Map<String,String[]> map = req.getParameterMap();
        //3.封装对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4.调用Service查询
        UserService service = new UserServiceImpl();
        User loginUser = service.login(user);
        System.out.println(loginUser);
        //5.判断是否成功
                if ((loginUser.getSpe() == 1) && (loginUser.getId() != null)) {
                session.setAttribute("loginUser", loginUser);
                session.setAttribute("spe",loginUser.getSpe());
                req.getRequestDispatcher("/findBlogByPageServlet").forward(req, resp);
            } else if(loginUser.getSpe()==0 && (loginUser.getId() != null)){
                session.setAttribute("loginUser", loginUser);
                session.setAttribute("spe",loginUser.getSpe());
                req.getRequestDispatcher("/findBlogByPageServlet").forward(req,resp);
            }
          else{
            req.setAttribute("reUser",loginUser);
            req.getRequestDispatcher("/relogin.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
