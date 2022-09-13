
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="registration" method="post">
    <div>
        <label for="first_name">First name</label>
        <input type="text" id="first_name" name="first_name" placeholder="First name">
    </div>
    <div>
        <label for="last_name">Last name</label>
        <input type="text" id="last_name" name="last_name" placeholder="Last name">
    </div>
    <div>
        <label for="email">Email</label>
        <input type="text" id="email" name="email" placeholder="Email">
    </div>
    <div>
        <label for="pass">Password</label>
        <input type="password" id="pass" name="pass" placeholder="Pass">
    </div>
    <div>
        <input type="submit">
    </div>
</form>
</body>
</html>
