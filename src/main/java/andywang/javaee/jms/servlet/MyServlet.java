package andywang.javaee.jms.servlet;

import andywang.javaee.jms.MyMessageProducer;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class MyServlet extends HttpServlet {

    @EJB
    MyMessageProducer producer;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        producer.sendMessage("Hello JMS using JavaEE...");
        resp.getWriter().write("Published");
    }
}
