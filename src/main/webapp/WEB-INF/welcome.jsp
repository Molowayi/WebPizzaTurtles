<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home page</title>
    <style>
        * {
            font-family: "Gill Sans MT"
        }

        h1 {
            text-align: center;
            color: #008;
        }

        .warning {
            color: #F00;
        }

        body {
            margin: 30px;
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

        div.image {
            width: 500px;
            height: 400px;
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

<h1>Pizza Assembly Service</h1>
<h2>Welcome !</h2>
<p>There are 4 Ninja tortoises : Donatello, Leonardo, Michelangelo and Raphael. They are eating pizza.</p>
<p>Each tortoise has his own webpage where you can :</p>
<ul>
    <li>See details about eaten pizza's.</li>
    <li>Make the tortoise pause and possibly resume whenever you want. There will be a feedback.</li>

</ul>
<P>Donatello's or Leonardo's pages are secured. You must be ADMIN and use password (homer) and username (homer).
</P>
<div class="image"><img src="https://www.baylor.edu/content/imglib/3/0/4/5/304574.png" width="400"></div>
<div class="padding50_0_0_0">
    <table>
        <tr class="bold"><td>Tortoise</td><td></td><td>Number of eaten pizza</td></tr>
        <tr><td><a href="donatello">Donatello</a></td><td> : </td><td class="center">${dona}</td></tr>
        <tr><td><a href="leonardo">Leonardo</a></td><td> : </td><td class="center">${leo}</td></tr>
        <tr><td><a href="michelangelo">Michelangelo</a> </td ><td> : </td><td class="center">${michi}</td></tr>
        <tr><td><a href="raphael">Raphael</a></td><td> : </td><td class="center">${raph}</td></tr>
        <tr><td class="italic">Total eaten pizzas</td><td></td><td class="center italic">${michi + dona + leo + raph}</td></tr>
    </table>
    <p>Use the menu bar or click on the name of the tortoise for details.</p>
    <p class="bold warning">!!! You need to refresh pages to see updated figures. And be patient.</p>
</div>
</body>
</html>