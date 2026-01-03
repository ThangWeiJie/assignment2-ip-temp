//package Controller;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//
//@WebServlet("/payment")
//public class PaymentServlet extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String paymentMethod = switch (req.getParameter("payment")) {
//            case "online banking" -> "Online Banking";
//            case "card" -> "Credit/Debit Card";
//            case "e-wallet" -> "E-Wallet";
//            default -> null;
//        };
//
//        HttpSession session = req.getSession(false);
//        if(session != null) {
//            session.setAttribute("paymentMethod", paymentMethod);
//            resp.sendRedirect(req.getContextPath() + "/CustomerInvoice.jsp");
//        }
//    }
//}
