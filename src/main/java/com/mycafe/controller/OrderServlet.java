//package com.mycafe.controller;
//
//import Model.Customer;
//import Model.OrderItem;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//@WebServlet("/order")
//public class OrderServlet extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ArrayList<OrderItem> orders = new ArrayList<>();
//
//        String hashBrownOrder = req.getParameter("hashbrownChkbox");
//        if(hashBrownOrder != null) {
//            String drink1 = req.getParameter("drink1");
//            int quantity1 = Integer.parseInt(req.getParameter("set1Quantity"));
//
//            double drinkPrice = switch (drink1) {
//                case "coffee" -> 10.00;
//                case "milo" -> 13.00;
//                default -> 0;
//            };
//
//            OrderItem hashbrown = new OrderItem("Hashbrowns", drink1, quantity1);
//            hashbrown.setPrice(drinkPrice * quantity1);
//            orders.add(hashbrown);
//        }
//
//        String pancakeOrder = req.getParameter("hotcakesChkbox");
//        if(pancakeOrder != null) {
//            String drink2 = req.getParameter("drink2");
//            int quantity2 = Integer.parseInt(req.getParameter("set2Quantity"));
//
//            int drinkPrice = switch (drink2) {
//                case "coffee" -> 11;
//                case "milo" -> 15;
//                case "lemon tea" -> 12;
//                default -> 0;
//            };
//
//            OrderItem pancakes = new OrderItem("Hot Cakes", drink2, quantity2);
//            pancakes.setPrice(drinkPrice * quantity2);
//            orders.add(pancakes);
//        }
//
//        double total = 0;
//        double seniorDiscount = 0;
//        double goldMemberDiscount = 0;
//        double totalDiscount = 0;
//        double amountToPay = 0;
//
//        for(OrderItem item : orders) {
//            total += item.getPrice();
//        }
//
//        HttpSession session = req.getSession(false);
//        if(session != null) {
//            Customer thisCustomer = (Customer)session.getAttribute("customer");
//            if(thisCustomer.getAge() >= 55) {
//                seniorDiscount = total * 0.05;
//            }
//
//            if(thisCustomer.isHasGoldMembership()) {
//                goldMemberDiscount = total * 0.10;
//            }
//
//            totalDiscount = seniorDiscount + goldMemberDiscount;
//            amountToPay = total - totalDiscount;
//
//            session.setAttribute("orders", orders);
//            session.setAttribute("total", total);
//            session.setAttribute("senior", seniorDiscount);
//            session.setAttribute("gold", goldMemberDiscount);
//            session.setAttribute("totalDiscount", totalDiscount);
//            session.setAttribute("toPay", amountToPay);
//        }
//
//        resp.sendRedirect(req.getContextPath() + "/CustomerPayment.jsp");
//    }
//}
