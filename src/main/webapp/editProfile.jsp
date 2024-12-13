<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Profile</title>
    <link rel="stylesheet" href="profile.css">
</head>
<body>
    <header>
        <div class="header-container">
            <h1>Edit YOUR Profile</h1>
            
        </div>
    </header>
    <main>
        <div class="profile-container">
            <h2>Edit Your Details</h2>
            <form action="editProfileServlet" method="post">
                <div class="form-group">
                    <label for="uname">Name:</label>
                    <input type="text" id="uname" name="uname" value="<%= session.getAttribute("session_name") %>" required><br>
                </div>
                <div class="form-group">
                    <label for="uemail">Email:</label>
                    <input type="email" id="uemail" name="uemail" value="<%= session.getAttribute("uemail") %> " required>
                </div>
                <div class="form-group">
                    <label for="address">Address:</label>
                    <input type="text" id="address" name="address" value="<%= session.getAttribute("address") %> " required>
                </div>
                
                <div class="form-group">
                    <label for="DOJ">DOJ:</label>
                    <input type="text" id="DOJ" name="DOJ" value="<%= session.getAttribute("DOJ") %> " required>
                </div>
                <div class="form-group">
                    <label for="umobile">Mobile:</label>
                    <input type="text" id="umobile" name="umobile" value="<%= session.getAttribute("umobile") %> " required>
                </div>
                 
                <div class="form-actions">
                    <button type="submit">Save</button>
                    <a href="Profile" class="button">Cancel</a>
                </div>
            </form>
        </div>
    </main>
    <footer>
        <p>© 2024 Your Application. All rights reserved.</p>
    </footer>
</body>
</html>
