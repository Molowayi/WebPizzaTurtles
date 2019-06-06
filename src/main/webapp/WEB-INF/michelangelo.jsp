<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${tortoise.name}</title>
    <style>
        * {
            font-family: "Gill Sans MT"
        }

        h1 {
            color: #008;
        }

        .warning {
            color: #F00;
        }

        body {
            margin: 40px;
        }

        ul.menu {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
        }

        ul.menu li {
            float: left;
        }

        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        /* Change the link color to #111 (black) on hover */
        li a:hover {
            background-color: #111;
        }

        div.image   {
            width: 500px;
            float: left;
        }
        .bold {
            font-weight: bold;
        }
        .center{
            text-align: center;
        }
        .italic {
            font-style: italic;
        }
        .padding50_0_0_0 {padding-top: 50px;}

        table a {text-decoration: none}
    </style>
</head>
<body>
<ul class="menu">
    <li><a href="/">Home page</a></li>
    <li><a href="michelangelo">Michelangelo</a></li>
    <li><a href="donatello">Donatello</a></li>
    <li><a href="leonardo">Leonardo</a></li>
    <li><a href="raphael">Raphael</a></li>
</ul>
<h1>${tortoise.name}</h1>
<table>
    <tr>
        <td><form action="" method="post"><input type="submit" name="pauseOfResume" value="Pause" size="10"></form></td>
        <td> --</td>
        <td><form action="" method="post"><input type="submit" name="pauseOfResume" value="Resume" size="10"></form></td>
    </tr>
</table>
<span class="warning">${pauseMessage}</span>
<span class="warning">${resumeMessage}</span><br><br>
<div class="image">
    <img src="https://images-na.ssl-images-amazon.com/images/I/71PtmPd2ueL._SY355_.jpg" width="300">
</div>
<div class="data  padding50_0_0_0">
    <table>
        <tr>
            <td>Name:</td><td> :  </td>
            <td>${tortoise.name}</td>
        </tr>
        <tr>
            <td>Total pizzas eaten</td><td> :  </td>
            <td>${totalEatenPizzas}</td>
        </tr>
        <tr>
            <td>Labels of eaten pizzas</td><td> :  </td>
            <td>${tortoise.eatenPizzas}</td>
        </tr>
        <tr>
            <td>Pizza toppings</td><td> :  </td>
            <td>${tortoise.pizza.toppings}</td>
        </tr>
    </table>
    <p class="bold warning">!!! You need to refresh pages to see updated figures. And be patient.</p>
    <p>Each pizza produced by the Pizza Assembly Service has a label (count) <br>In the details, you can see the list of labelts pizzas eaten by each tortoise.</p>
    <p>If you push the pause button, the tortoise stops. It will continue from that state when you will push the resume button.</p>
</div>
</body>
</html>
