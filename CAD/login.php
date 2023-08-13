<?php
// Replace the following variables with your actual database credentials
$host = "localhost"; // For example, "localhost" or IP address like "127.0.0.1"
$username = "root";
$password = "";
$dbname = "project"; // Replace with your database name

// Establish a database connection
$conn = new mysqli($host, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Retrieve user inputs
    $email = $_POST['email'];
    $password = $_POST['password'];

    // Validate user inputs (optional)

    // Check user credentials against the database
    // Perform a SELECT query to check if the user exists and the password matches
    $sql = "SELECT * FROM users WHERE email = '$email'";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        $user = $result->fetch_assoc();
        // Verify the password using password_verify function (assuming the passwords are hashed)
        if (password_verify($password, $user['password'])) {
            // If the user exists and credentials are correct, set session variables for logged-in user
            // For example, set a session variable to store the user ID or any other relevant data
            // $_SESSION['user_id'] = $user['id'];

            // Redirect the user to a dashboard page or wherever you want them to go after login
            header("Location: index.php");
            exit();
        } else {
            // If credentials are incorrect, show an error message
            echo "Incorrect email or password. Please try again.";
        }
    } else {
        // If user does not exist, show an error message or redirect to the signup page
        echo "User does not exist. Please sign up first.";
    }
}

// Close the database connection
$conn->close();
?>