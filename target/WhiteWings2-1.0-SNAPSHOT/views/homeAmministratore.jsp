<%@ page import="model.Utente.Utente" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>WHITE WINGS</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        <%@include file="/css/menu.css"%>

    </style>

    <%
        request.getSession().setAttribute("user", null);
        Utente user=(Utente) request.getSession().getAttribute("user");
        request.getSession().setAttribute("user", user);
        String context = request.getContextPath();
        String home=context;

        if(user==null)
            home+="/index.jsp";
        else if(user.isIfAdmin())
            home+="/views/homeAmministratore.jsp";
        else if(!(user.isIfAdmin()))
            home+="/views/UtenteLoggato.jsp";

    %>

    <script src="https://kit.fontawesome.com/aafa5f65fa.js" crossorigin="anonymous"></script>
</head>
<body>


<div class="header" style="background-image:url(/immagini/logo.png)">
    <img src="immagini/Senzanome.png" border="0" class="responsive-image">
</div>
<div class="navbar">
    <a href="#">HOME <i class="fas fa-home"></i></a>
    <a href="#">BISCOTTI <i class="fas fa-cookie"> </i></a>
    <a href="#">TORTE <i class='fas fa-cheese'></i> </a>
    <div class="dropdown">
        <button class="dropbtn">IMPOSTAZIONI
            <i class="fas fa-user-cog"></i>
        </button>
        <div class="dropdown-content">
            <a href="#">MODIFICA DOLCI</a>
            <a href="#">MODIFICA TIPOLOGIA</a>
            <a href="#">MODIFICA CLIENTI</a>
        </div>
    </div>
    <a><div class="search-container">
        <form action="/action_page.php">
            <input type="text" placeholder="Search.." name="search">
            <button type="submit"><i class="fa fa-search"></i></button>
        </form>
    </div></a>
    <a href="#" class="right">LOGOUT <i class="fas fa-sign-in-alt" ></i> </a>

</div>

<div class="row">

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