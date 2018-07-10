package servlet;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import domain.Item;
import domain.Product;
 
 
public class ItemAddServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        int num = Integer.parseInt(request.getParameter("num"));
        int pid = Integer.parseInt(request.getParameter("pid"));
        Product p = new ProductDao().getProductById(pid);
 
        Item i = new Item();
 
        i.setNum(num);
        i.setProduct(p);
 
        List<Item> ois = (List<Item>) request.
        		getSession().getAttribute("ois");
 
        if (null == ois) {
            ois = new ArrayList<Item>();
            request.getSession().setAttribute("ois", ois);
        }
 
        boolean flag = false;
        for (Item item : ois) {
            if (item.getProduct().getId() == i.getProduct().getId()) {
            	item.setNum(item.getNum() + i.getNum());
            	flag = true;
                break;
            }
        }
 
        if (!flag)
            ois.add(i);
 
        response.sendRedirect("/listOrderItem.jsp");
 
    }
}