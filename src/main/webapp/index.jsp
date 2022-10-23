<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<!DOCTYPE html>
<html>
<head>
    <title>Task3</title>
</head>
<body>
<style>
    body {
        background-color: cadetblue;
    }

    h1 {
        text-align: center;
        color: darkred;

    }

    form {
        font-size: 150%;
    }

    input {
        background-color: darkgray;
        color: darkred;
        font-size: 90%;
    }


    #numbers {
        text-align: center;
        color: darkred;

    }

    #txtNumber {
        text-align: center;
        color: darkred;


    }

</style>
<h1>Hello it's a good time sum up some number </h1>
<br>
<form action='msg'>


    <div id="txtNumber">
        Enter first number <input name='text1' type='text'>
        Enter second number <input name='text2' type='text'>
    </div>
    <br>
    <div id="numbers">
        <input type='submit' formmethod="get" value='Sum with GET'>
        <input type='submit' formmethod="post" value='Sum with POST'>
    </div>

</form>

</body>
</html>