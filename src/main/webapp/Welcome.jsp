<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="Welcome.css">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
</head>
<body>
<h1>Welcome :${session_name} </h1>
<!-- Welcome Section -->
    <div class="welcome-container">
        <!-- Logo and Title -->
        <div class="header">
            <img src="https://th.bing.com/th/id/OIP.o8uhEeq7OXXTPPJpkSyC1QHaHa?pid=ImgDet&w=191&h=191&c=7" alt="Logo" class="logo">
            <h1>Welcome to <span class="brand">InterraIT</span></h1>
            <p>Your journey into innovation begins here!</p>
        </div>
 
        <!-- Animated Buttons -->
        <div class="button-container">
            <a href="Profile" class="button">Show Details</a>
            <a href="aboutUs.jsp" class="button">About Us</a>
            <a href="login.jsp" class="button">Back to login</a>
        </div>
 
        <!-- Extra Creativity: Scroll-down animation -->
        <div class="scroll-indicator">
            <span>Scroll Down</span>
            <div class="arrow"></div>
        </div>
    </div>
 
    <!-- Footer -->
    <footer>
        <p>© 2024 nterraIT. All rights reserved.</p>
    </footer>
</body>
</html>