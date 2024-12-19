@param String env
@param int cartCount
@param gg.jte.Content content


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Happy Tummy - Food to remember</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">
    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap"
          rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <%--<link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">--%>
    <%--<link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">--%>


    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
    <%--<script src="https://unpkg.com/htmx.org@1.9.10"></script>--%>
    <script src="js/htmx.min.js"></script>
    <link rel="icon" type="image/x-icon" href="img/favicon.ico">
</head>

<body>

<!-- Navbar start -->
@template.header(env = env, cartCount = cartCount)
<!-- Navbar End -->

<!-- Main Content Start-->
<%--@template.home-content(items = items)--%>
    ${content}
<!-- Main Content End-->

<!-- Footer Start -->
@template.footer()
<!-- Footer End -->

</body>

</html>