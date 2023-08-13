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

// Sign Up Form
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['signup'])) {
    // Retrieve user inputs
    $name = $_POST['name'];
    $email = $_POST['email'];
    $password = $_POST['password'];

    // Validate user inputs (optional)

    // Validate email format
    if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
        // If the email format is incorrect, show an alert message
        echo "<script>alert('Invalid email format. Please provide a valid email address.');</script>";
    } else {
        // Check if the email already exists in the database
        $sql_check_email = "SELECT * FROM users WHERE email = '$email'";
        $result_check_email = $conn->query($sql_check_email);

        if ($result_check_email->num_rows > 0) {
            // If the email is already registered, show an alert message
            echo "<script>alert('Email already exists. Please log in or use a different email.');</script>";
        } else {
            // If the email is not already registered and has a valid format, insert the user data into the database
            // Hash the password for security (you can use PHP's password_hash() function)
            $hashed_password = password_hash($password, PASSWORD_DEFAULT);

            $sql_insert_user = "INSERT INTO users (name, email, password) VALUES ('$name', '$email', '$hashed_password')";

            if ($conn->query($sql_insert_user) === TRUE) {
                // Display a success message using JavaScript alert after successful sign-up
                echo "<F>alert('Sign-up successful! You can now log in.');</script>";
            } else {
                // If there was an error inserting the user data, show an alert message
                echo "<script>alert('Error: " . $sql_insert_user . "\\n" . $conn->error . "');</script>";
            }
        }
    }
}







// Close the database connection
$conn->close();





// Initialize the login status variable
$login_status = '';

// Login Process
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['login'])) {
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

    // Check if the required keys exist in the $_POST array
    if (isset($_POST['login_email']) && isset($_POST['login_password'])) {
        // Retrieve user inputs for login form
        $login_email = $_POST['login_email'];
        $login_password = $_POST['login_password'];

        // Validate user inputs for login form (optional)

        // Perform the login check (compare with the stored credentials in the database)
        // Assuming you have a table called "users" with columns "email" and "password"
        $sql_check_login = "SELECT * FROM users WHERE email = '$login_email'";
        $result_check_login = $conn->query($sql_check_login);

        if ($result_check_login->num_rows > 0) {
            $row = $result_check_login->fetch_assoc();
            // Verify the hashed password
            if (password_verify($login_password, $row['password'])) {
                // If login successful, set the login status to success
                $login_status = "Login Successful!";
            } else {
                // If the password is incorrect, set the login status to failure
                $login_status = "Incorrect password. Please try again.";
            }
        } else {
            // If the email is not found in the database, set the login status to failure
            $login_status = "Email not found. Please sign up or try a different email.";
        }
    } else {
        // If the required keys are not found in $_POST, set an appropriate login status
        $login_status = "Please enter both email and password to log in.";
    }

    // Close the database connection
    $conn->close();
}

?>
<!doctype html>
<!--[if gt IE 8]><!--> <html class="no-js" lang="en"> <!--<![endif]-->
    <head>
        
        <meta charset="utf-8">
        <title>Contact us page</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="favicon.ico">

        <!--Google Fonts link-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">


        <link href="https://fonts.googleapis.com/css?family=Crimson+Text:400,400i,600,600i,700,700i" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700,700i" rel="stylesheet">


        <link rel="stylesheet" href="assets/css/slick.css">
        <link rel="stylesheet" href="assets/css/slick-theme.css">
        <link rel="stylesheet" href="assets/css/animate.css">
        <link rel="stylesheet" href="assets/css/fonticons.css">
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/bootstrap.css">
        <link rel="stylesheet" href="assets/css/magnific-popup.css">
        <link rel="stylesheet" href="assets/css/bootsnav.css">


        <!--For Plugins external css-->
        <!--<link rel="stylesheet" href="assets/css/plugins.css" />-->

        <!--Theme custom css -->
        <link rel="stylesheet" href="assets/css/style.css">
        <!--<link rel="stylesheet" href="assets/css/colors/maron.css">-->

        <!--Theme Responsive css-->
        <link rel="stylesheet" href="assets/css/responsive.css" />

        <script src="assets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    </head>

    <body data-spy="scroll" data-target=".navbar-collapse">

        <!-- Preloader -->

        <div id="loading">
            <div id="loading-center">
                <div id="loading-center-absolute">
                    <div class="object"></div>
                    <div class="object"></div>
                    <div class="object"></div>
                    <div class="object"></div>
                    <div class="object"></div>
                    <div class="object"></div>
                    <div class="object"></div>
                    <div class="object"></div>
                    <div class="object"></div>
                    <div class="object"></div>
                </div>
            </div>
        </div>

        <!--End off Preloader -->


        <div class="culmn">
            <!--Home page style-->


            <nav class="navbar navbar-default navbar-fixed white no-background bootsnav text-uppercase">
                <!-- Start Top Search -->
                <div class="top-search">
                    <div class="container">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-search"></i></span>
                            <input type="text" class="form-control" placeholder="Search">
                            <span class="input-group-addon close-search"><i class="fa fa-times"></i></span>
                        </div>
                    </div>
                </div>
                <!-- End Top Search -->

                <div class="container">    
                    <!-- Start Atribute Navigation -->
                    <div class="attr-nav">
                        <ul>
                            <li class="search"><a href="#"><i class="fa fa-search"></i></a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" >
                                    <i class="fa fa-shopping-bag"></i>
                                    <span class="badge">3</span>
                                </a>
                                <ul class="dropdown-menu cart-list">
                                    <li>
                                        <a href="#" class="photo"><img src="assets/images/thumb01.jpg" class="cart-thumb" alt="" /></a>
                                        <h6><a href="#">Delica omtantur </a></h6>
                                        <p class="m-top-10">2x - <span class="price">$99.99</span></p>
                                    </li>
                                    <li>
                                        <a href="#" class="photo"><img src="assets/images/thumb01.jpg" class="cart-thumb" alt="" /></a>
                                        <h6><a href="#">Delica omtantur </a></h6>
                                        <p class="m-top-10">2x - <span class="price">$99.99</span></p>
                                    </li>
                                    <li>
                                        <a href="#" class="photo"><img src="assets/images/thumb01.jpg" class="cart-thumb" alt="" /></a>
                                        <h6><a href="#">Delica omtantur </a></h6>
                                        <p class="m-top-10">2x - <span class="price">$99.99</span></p>
                                    </li>
                                    <!---- More List ---->
                                    <li class="total">
                                        <span class="pull-right"><strong>Total</strong>: $0.00</span>
                                        <a href="#" class="btn btn-cart">Cart</a>
                                    </li>
                                </ul>
                            </li>

                        </ul>
                    </div>        
                    <!-- End Atribute Navigation -->

                    <!-- Start Header Navigation -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-menu">
                            <i class="fa fa-bars"></i>
                        </button>
                        <a class="navbar-brand" href="index.php">

                            <img src="assets/images/logo.png" class="logo logo-display" alt="">
                            <img src="assets/images/logo-black.png" class="logo logo-scrolled" alt="">

                        </a>
                    </div>
                    <!-- End Header Navigation -->

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="navbar-menu">
                        <ul class="nav navbar-nav navbar-right" data-in="fadeInDown" data-out="fadeOutUp">
                            <li><a href="index.php">home</a></li> 
							<li><a href="aboutus.php">about</a></li> 							                   
                            <li><a href="product.php">products</a></li> 							
                            <li><a href="blog.php">blog</a></li>                                    
                            <li><a href="contactus.php">contact</a></li>    
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div>  


            </nav>


            <!--Home Sections-->

            <section id="hello" class="contact-banner bg-mega">
                <div class="overlay"></div>
                <div class="container">
                    <div class="row">
                        <div class="main_home text-center">
                            <div class="contact_text">
                                <h1 class="text-white text-uppercase">Contact Us</h1>
                                <ol class="breadcrumb">
                                    <li><a href="#">Home</a></li>
                                    <li class="active"><a href="#">Contact Us</a></li>
                                </ol>
                            </div>
                        </div>
                    </div><!--End off row-->
                </div><!--End off container -->
            </section> <!--End off Home Sections-->


            <!--Call To Action Section-->

            <section id="action" class="action roomy-100">
                <div class="container">
                    <div class="row">
                        <div class="main_action text-center">
                            <div class="col-md-4">
                                <div class="action_item">
                                    <i class="fa fa-map-marker"></i>
                                    <h4 class="text-uppercase m-top-20">Address</h4>
                                    <p>7th floor - Palace Building - 221B Walk of Fame - <br /> London - UK</p>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="action_item">
                                    <i class="fa fa-headphones"></i>
                                    <h4 class="text-uppercase m-top-20">phone</h4>
                                    <p>(+84) - 123 - 456 - 789 <br /> (+84) - 321 - 654 - 987</p>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="action_item">
                                    <i class="fa fa-envelope-o"></i>
                                    <h4 class="text-uppercase m-top-20">Email</h4>
                                    <p>Pouseidon-support@pouseidon.lnk <br />
                                        info@pouseidon.lnk</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                
                            <section id="action" class="action roomy-100">
                <div class="container">
                    <div class="row">
                        <div class="main_action text-center">
                            <div class="col-md-4">
                                <div class="action_item">
                                    <h4 class="text-uppercase m-top-20">Sign Up</h4>
 <!-- Sign Up Form  -->
<form class="" action="" method="post"">
    <div class="form-group">
        <label>Name</label>
        <input id="name" name="name" type="text" class="form-control" required="">
    </div>
    <div class="form-group">
        <label>Email</label>
        <input id="email" name="email" type="text" class="form-control" required="">
    </div>
    <div class="form-group">
        <label>Password</label>
        <input id="password" name="password" type="password" class="form-control" required="">
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-default" name="signup">SIGN UP</button>
    </div>
</form>
       
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="action_item">
                                    <h4 class="text-uppercase m-top-20">Login</h4>
<!-- Login Form -->
<form class="" method="post">
    <div class="form-group">
        <label>Email</label>
        <input id="login_email" name="login_email" type="email" class="form-control" required="">
    </div>
    <div class="form-group">
        <label>Password</label>
        <input id="login_password" name="login_password" type="password" class="form-control" required="">
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-default" name="login">LOGIN</button>
    </div>
</form>

<!-- Display login status alert using JavaScript alerts -->
<?php if (!empty($login_status)): ?>
    <script>alert('<?php echo $login_status; ?>');</script>
<?php endif; ?>


                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>


            <!-- map section-->
            <div id="map" class="map">
                <div class="ourmap"></div>
            </div><!-- End off Map section-->
                    </div><!--End off row -->
                </div><!--End off container -->
            </section><!--End off Contact Section-->


            <!--Company section-->

            <section id="company" class="company bg-light">
                <div class="container">
                    <div class="row">
                        <div class="main_company roomy-100 text-center">
                            <h3 class="text-uppercase">pouseidon.</h3>
                            <p>7th floor - Palace Building - 221b Walk of Fame - London- United Kingdom</p>
                            <p>(+84). 123. 456. 789  -  info@poiseidon.lnk</p>
                        </div>
                    </div>
                </div>
            </section>


            <!-- scroll up-->
            <div class="scrollup">
                <a href="#"><i class="fa fa-chevron-up"></i></a>
            </div><!-- End off scroll up -->


            <footer id="footer" class="footer bg-mega">
                <div class="container">
                    <div class="row">
                        <div class="main_footer p-top-40 p-bottom-30">
                            <div class="col-md-6 text-left sm-text-center">
                                <p class="wow fadeInRight" data-wow-duration="1s">
                                    Made with 
                                    <i class="fa fa-heart"></i>
                                    by Marvyn, Azhar, Kumar & Hakim
                                </p>
                            </div>
                            <div class="col-md-6 text-right sm-text-center sm-m-top-20">
                                <ul class="list-inline">
                                    <li><a href="">Facebook</a></li>
                                    <li><a href="">Twitter</a></li>
                                    <li><a href="">Instagram</a></li>
                                    <li><a href="">Pinterest</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </footer>




        </div>

        <!-- JS includes -->

        <script src="assets/js/vendor/jquery-1.11.2.min.js"></script>
        <script src="assets/js/vendor/bootstrap.min.js"></script>

        <script src="assets/js/isotope.min.js"></script>
        <script src="assets/js/jquery.magnific-popup.js"></script>
        <script src="assets/js/jquery.easing.1.3.js"></script>
        <script src="assets/js/slick.min.js"></script>
        <script src="assets/js/jquery.collapse.js"></script>
        <script src="assets/js/bootsnav.js"></script>


        <!-- paradise slider js -->

        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDgJpCPtb0pNhWxJjVo-c3074USAdY1VTI&libraries=places"></script>
        <script src="assets/js/gmaps.min.js"></script>
        <script>
            
            var targetLat = 1.3083;
            var targetLng = 103.7773;

            // Get user's current location (browser's geolocation)
            navigator.geolocation.getCurrentPosition(function(position) {
                var userLat = position.coords.latitude;
                var userLng = position.coords.longitude;

                // Initialize the map
                var map = new GMaps({
                    el: '.ourmap',
                    lat: targetLat,
                    lng: targetLng,
                    scrollwheel: false,
                    zoom: 15,
                    zoomControl: true,
                    panControl: false,
                    streetViewControl: false,
                    mapTypeControl: false,
                    overviewMapControl: false,
                    clickable: false,
                    styles: [{'stylers': [{'hue': 'gray'}, {saturation: -100}, {gamma: 0.80}]}]
                });

                // Add a marker for the targeted location (Singapore Polytechnic)
                map.addMarker({
                    lat: targetLat,
                    lng: targetLng,
                    title: 'Singapore Polytechnic',
                    infoWindow: {
                        content: '<p>Singapore Polytechnic</p>'
                    }
                });

                // Add a marker for the user's current location
                map.addMarker({
                    lat: userLat,
                    lng: userLng,
                    title: 'You are here',
                    infoWindow: {
                        content: '<p>We are here</p>'
                    }
                });

                

            });
        </script>

       




        <script src="assets/js/plugins.js"></script>
        <script src="assets/js/main.js"></script>
    </body>
</html>
