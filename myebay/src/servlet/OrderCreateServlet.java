package servlet;
 
import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDao;
import dao.OrderItemDAO;
import domain.Order;
import domain.OrderItem;
import domain.User;
 
public class OrderCreateServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        User u = (User) request.getSession().getAttribute("user");
        if(null==u){
            response.sendRedirect("/login.jsp");
            return;
        }
         
        Order o = new Order();
        o.setUser(u);
 
        new OrderDao().insert(o);
 
        List<OrderItem> ois = (List<OrderItem>) request.getSession().getAttribute("ois");
        for (OrderItem oi : ois) {
            oi.setOrder(o);
            new OrderItemDAO().insert(oi);
        }
         
        ois.clear();
         
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println("订单创建成功");
 
    }
}
