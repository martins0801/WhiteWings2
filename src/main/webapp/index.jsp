<!DOCTYPE html>
<html lang="en">
<head>
    <title>WHITE WINGS</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        <%@include file="/css/menu.css"%>

    </style>
    <script src="https://kit.fontawesome.com/aafa5f65fa.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="header" style="background-image:url(/immagini/logo.png)">
    <img src="immagini/logoNewDimezzato.png" border="0" class="responsive-image">
</div>
<div class="navbar">
    <a href="#">HOME <i class="fas fa-home"></i></a>
    <a href="#">BISCOTTI <i class="fas fa-cookie"> </i></a>
    <a href="#">TORTE <i class='fas fa-cheese'></i> </a>
    <a><div class="search-container">
        <form action="/action_page.php">
            <input type="text" placeholder="Search.." name="search">
            <button type="submit"><i class="fa fa-search"></i></button>
        </form>
    </div></a>
    <a href="login.jsp" class="right">LOGIN <i class="fas fa-sign-in-alt" ></i> </a>
    <a href="#" class="right" >CARRELLO <i class="fas fa-shopping-cart" ></i></a>
</div>

<div class="row">
    <!--<div class="side">
        <h2>About Me</h2>
        <h5>Photo of me:</h5>
        <div class="fakeimg" style="height:200px;">Image</div>
        <p>Some text about me in culpa qui officia deserunt mollit anim..</p>
        <h3>More Text</h3>
        <p>Lorem ipsum dolor sit ame.</p>
        <div class="fakeimg" style="height:60px;">Image</div><br>
        <div class="fakeimg" style="height:60px;">Image</div><br>
        <div class="fakeimg" style="height:60px;">Image</div>
    </div>
   <!--<div class="main">
        <h2>BENVENUTO</h2>

        <p>Vieni a scoprire i nostri prodotti! </p>
        <p> Artigiani dal 1990!
        </p>
        <br>
        <h2>TITLE HEADING</h2>
        <h5>Title description, Sep 2, 2017</h5>
        <div class="fakeimg" style="height:200px;">Image</div>
        <p>Some text..</p>
        <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
    </div> -->

    <div class="demo coursemeal">

        <!-- BISCOTTI-->
        <div class="coursemeal__div ">

            <picture class="responsive-img">

                <img src="immagini/prodotti/Brutti-ma-buoni.jpg" alt="Biscotti" >
            </picture>

            <div class="coursemeal-info">
                <a href="#" class="coursemeal-info__link">BISCOTTI</a>
            </div>
        </div>

        <!-- DOLCI DELLE FESTE -->
        <div class="coursemeal__div">

            <picture class="responsive-img">

                <img src="immagini/prodotti/colomba.jpg" alt="HOME" >
            </picture>

            <div class="coursemeal-info">
                <a href="#" class="coursemeal-info__link">DOLCI DELLE FESTE</a>
            </div>
        </div>

        <!-- TORTE-->
        <div class="coursemeal__div">

            <picture class="responsive-img">
                <img src="immagini/prodotti/sacher.jpg" alt="TORTE">
            </picture>

            <div class="coursemeal-info">
                <a href="#" class="coursemeal-info__link">TORTE</a>
            </div>
        </div>


    </div>


</div>
<div class="footer">
    <p>SEGUICI SUI NOSTRI PROFILI SOCIAL!</p>

    <div class="footer-social-links">
        <a href="#" title="Facebook" target="_blank"><i class="fa fa-facebook"></i></a>
        <a href="#" title="Twitter" target="_blank"><i class="fa fa-twitter"></i></a>
        <a href="#" title="Instagram" target="_blank"><i class="fab fa-instagram"></i></a>
        <a href="#" title="Whatsapp"target="_blank"><i class="fab fa-whatsapp"></i></a>
    </div>

</div>

</body>
</html>