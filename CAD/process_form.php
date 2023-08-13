<?php
// Replace the following variables with your actual database credentials
$host = "localhost";
$username = "root";
$password = "";
$dbname = "project"; // The name of your database is "project"

// Establish a database connection
$conn = new mysqli($host, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Retrieve form data
$name = $_POST['name'];
$email = $_POST['email'];
$message = $_POST['message'];

// Validate email format
if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
    // If the email format is incorrect, show an alert message
    echo "<script>alert('Invalid email format. Please provide a valid email address.'); window.history.back();</script>";
} else {
    // Insert data into the "contacts" table in the "project" database
    $sql = "INSERT INTO contacts (name, email, message) VALUES ('$name', '$email', '$message')";

    if ($conn->query($sql) === TRUE) {
        // Data inserted successfully
        // You can redirect the user to a thank you page or display a success message here
        echo "<script>alert('Thank you for your message!'); window.location.href = 'index.php';</script>";
    } else {
        // Error occurred while inserting data
        // You can show an error message here
        echo "<script>alert('Error: " . $sql . "\\n" . $conn->error . "'); window.history.back();</script>";
    }
}

// Close the database connection
$conn->close();
?>
