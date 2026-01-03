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
    <title>Cust Payment</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>

        .tbl{
            width: 100%;
            color:#f8f9fa;
            font-weight: 600;
            background-color: #505050;
            border: 1px solid #008080;
            margin-top: 1.5em;
            margin-bottom: 1em;
        }

        .col-lg-5 .info {
            margin-bottom: 1rem;
        }

        .col-lg-5 .info .value {
            color: red;
        }

        .col-lg-5 .info p {
            margin-bottom: 0;
        }


        .btn{
            transition: all .5s ease;
            width: 50%;
            border-radius: 30px;
            color:#008080;
            font-weight: 600;
            background-color: #fff;
            border: 1px solid #008080;
            margin-top: 1.5em;
            margin-bottom: 1em;
        }
        .btn:hover, .btn:focus{
            background-color: #008080;
            color:#fff;
        }
    </style>
</head>

<body>
<div class="container-fluid">
    <h3>MyCafe</h3>
    <h5>Payment</h5>

    <form method="post" action="payment">
        <div class="col-lg-5">
            <div class="info">
                <% Customer thisCustomer = (Customer) session.getAttribute("customer"); %>
                <p>Customer Name: </p>
                <span class="value"><%= thisCustomer.getFullName() %></span>
            </div>

            <% ArrayList<OrderItem> orderList = (ArrayList<OrderItem>) session.getAttribute("orders");  %>
            <table class="tbl">
                <tr>
                    <th>Meal Set</th>
                    <th>Drink</th>
                    <th>Quantity</th>
                    <th>Price</th>
                </tr>
                <% for (OrderItem order : orderList) {%>
                <tr>
                    <td><%=order.getMealSet()%></td>
                    <td><%=order.getDrink()%></td>
                    <td><%=order.getQuantity()%></td>
                    <td><%=order.getPrice()%></td>
                </tr>
                <% } %>
            </table>

            <div class="info">
                <p>Total Amount:</p>
                <span class="value"><%= String.format("$%.2f", (double)session.getAttribute("total"))%></span>
            </div>

            <div class="info">
                <p>5% Senior Citizen (Age 55 years old and above) Discount: </p>
                <span class="value"><%= String.format("$%.2f", (double)session.getAttribute("senior")) %></span>
            </div>

            <div class="info">
                <p>10% Gold Membership Discount</p>
                <span class="value"><%= String.format("$%.2f", (double)session.getAttribute("gold")) %></span>
            </div>

            <div class="info">
                <p>Total Discount</p>
                <span class="value"><%= String.format("$%.2f", (double)session.getAttribute("totalDiscount")) %></span>
            </div>

            <div class="info">
                <p>Amount To Pay</p>
                <span class="value"><%= String.format("$%.2f", (double)session.getAttribute("toPay")) %></span>
            </div>

            <div class="form-group>">
                <label for="payment">Payment Method : </label>

                <select required name="payment">
                    <option value="" disabled selected>Select your payment method...</option>
                    <option value="online banking">Online Banking</option>
                    <option value="card">Credit/Debit Card</option>
                    <option value="e-wallet">E-Wallet</option>
                </select>

                <br><br>
            </div>
            <input class="btn" type="submit" value="confirm payment" name="orderBtn" />
        </div>
    </form>
</div>
</body>

</html>