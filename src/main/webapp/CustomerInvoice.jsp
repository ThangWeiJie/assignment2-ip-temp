<%@ page import="Model.Customer" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.OrderItem" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<!--
    Name: Thang Wei Jie
    Matric Number: A23CS0280
-->

<head>
    <meta charset="ISO-8859-1">
    <title>Cust Invoice</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        .container-fluid .info {
            margin-bottom: 1rem;
        }

        .container-fluid .info .value {
            margin-bottom: 1rem;
            color: red;
        }

        .container-fluid .info p {
            margin-bottom: 0;
        }
    </style>
</head>

<body>
<div class="container-fluid">
    <h3>MyCafe</h3>
    <h5>Invoice</h5>

    <div class="info">
        <% Customer thisCustomer = (Customer) session.getAttribute("customer"); %>
        <p>Customer Name: </p>
        <span class="value"><%= thisCustomer.getFullName()%></span>
    </div>

    <div class="info">
        <p>Amount Paid: </p>
        <span class="value"><%= String.format("$%.2f", (double)session.getAttribute("toPay")) %></span>
    </div>

    <div class="info">
        <p>Payment Method: </p>
        <span class="value"><%= session.getAttribute("paymentMethod") %></span>
    </div>

    <div class="info">
        <p>Shipping Address: </p>
        <span class="value"><%= thisCustomer.getShippingAddress() %></span>
    </div>
</div>
</body>

</html>