<!DOCTYPE html>
<html>
<head>
    <title>LogIn</title>
    <script src="https://kit.fontawesome.com/72e0d6ca25.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../css/login.css" type="text/css">


</head>
<body>

<div class="overlay">

    <form action="../Servlet_Login" method="post">

        <div class="con">

            <header class="head-form">
                <h2>Log In</h2>

                <p><b>Inserisci qui il tuo username e la tua password</b></p>
            </header>

            <br>
            <div class="field-set">

                    <span class="input-item">
           <i class="fa fa-user-circle"></i>
         </span>

                <input class="form-input" id="txt-input" type="text" name="userCliente" placeholder="@UserName" required>

                <br>

                <span class="input-item">
        <i class="fa fa-key"></i>
       </span>

                <input class="form-input" type="password"  placeholder="Password" id="pwd"  name="passCliente" required>

                <span>
        <i class="fa fa-eye" aria-hidden="true"  type="button" id="eye"></i>
     </span>


                <br>

                <button class="log-in"> Log In </button>
            </div>


            <div>

                <a href="registrazione.jsp">Sign Up</a>



            </div>

        </div>
    </form>

</div>

</form>
</div>
<script>
    function show() {
        var p = document.getElementById('pwd');
        p.setAttribute('type', 'text');
    }

    function hide() {
        var p = document.getElementById('pwd');
        p.setAttribute('type', 'password');
    }

    var pwShown = 0;

    document.getElementById("eye").addEventListener("click", function () {
        if (pwShown == 0) {
            pwShown = 1;
            show();
        } else {
            pwShown = 0;
            hide();
        }
    }, false);
</script>

</body>
</html>