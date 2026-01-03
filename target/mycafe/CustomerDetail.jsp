<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<!--
    Name: Thang Wei Jie
    Matric Number: A23CS0280
-->

<meta charset="ISO-8859-1">
<head>
    <title>Customer Info</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
    .btn{
        transition: all .5s ease;
        width: 30%;
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

        <form method="post" action="customer">
            <div class="col-lg-4">
                <h4>Customer Detail</h4>
                <div class="form-group">
                    <label for="fullname">Fullname : </label><input class="form-control" type="text" name="fullname"
                        placeholder="mandatory. 10 - 30 characters long" minlength="10" maxlength="30" required><br>
                </div>
                <div class="form-group">
                    <label for="Age">Your Age This Year : </label><input class="form-control" type="number" name="age"
                        placeholder="mandatory. range 1 - 100" min="1" max="100" required ><br>
                </div>
                <div class="form-group">
                    <label for="address">Shipping Address : </label><br>
                    <textarea name="address" placeholder="mandatory. 20 - 100 characters" rows="4"
                        cols="53" minlength="20" maxlength="100" required></textarea><br><br>
                </div>

                <div class="form-group>">
                    <label for="membership">Have Gold Membership ? &nbsp;&nbsp;</label>
                        <input name="membership" type="radio" value="yes" />Yes
                        <input name="membership" type="radio" value="no" />No
                    <br><br><br>
                </div>


                <input class="btn " type="submit" value="Proceed">
                <input class="btn " type="reset" value="Reset">

            </div>
        </form>
    </div>
</body>

</html>