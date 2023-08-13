<?php
// Sign Up Process
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['signup'])) {
    // Retrieve user inputs
    $name = $_POST['name'];
    $email = $_POST['email'];
    $password = $_POST['password'];

    // Check if the email already exists in the database
    $sql_check_email = "SELECT * FROM users WHERE email = '$email'";
    $result_check_email = $conn->query($sql_check_email);

    if ($result_check_email->num_rows > 0) {
        // If the email is already registered, show an error message
        echo "Email already exists. Please log in or use a different email.";
    } else {
        // If the email is not already registered, insert the user data into the database
        // Hash the password for security (you can use PHP's password_hash() function)
        $hashed_password = password_hash($password, PASSWORD_DEFAULT);

        $sql_insert_user = "INSERT INTO users (name, email, password) VALUES ('$name', '$email', '$hashed_password')";

        if ($conn->query($sql_insert_user) === TRUE) {
            // Set the success message for sign-up
            $success_message = "Signup Successful!";
        } else {
            // If there was an error during the insert, show an error message
            echo "Error: " . $sql_insert_user . "<br>" . $conn->error;
        }
    }
}
