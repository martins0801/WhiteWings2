<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: Arsenal, sans-serif;
            background: radial-gradient(#ffe4e1, #ffc0cb);
        }

        form {
            background-color: #FFE4E1;
            border: 3px solid #f1f1f1;
            margin: 25px auto;
            width: 270px;

        }

        * {
            box-sizing: border-box;
        }

        /* Add padding to containers */
        .container {
            padding: 3px;
            margin: 0 auto;
            width: 250px;

        }

        /* Full-width input fields */
        input[type=text], input[type=password],input[type=email] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 3px solid #f1f1f1;
            box-sizing: border-box;
        }

        input[type=text]:focus, input[type=password]:focus {
            background-color: #ddd;
            outline: none;
        }

        /* Overwrite default styles of hr */
        /*hr {
          border: 3px solid #f1f1f1;
          margin-bottom: 25px;
        }

        /* Set a style for the submit button */
        .registerbtn {
            background-color: #ABCDEF;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }

        .registerbtn:hover {
            opacity: 1;
        }

        /* Add a blue text color to links */
        a {
            color: dodgerblue;
        }


    </style>
</head>
<body>

<form action="../ServletRegister" method="post">
    <div class="container">
        <h1>Registrati</h1>

        <hr>

        <label for="nome"><b>Nome</b></label>
        <input type="text" placeholder="Enter Nome" name="nome" id="nome" required>

        <label for="email"><b>Email</b></label>
        <input type="email" placeholder="Enter Email" name="email" id="email" required>

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" id="psw" required>

        <label for="username"><b>UserName</b></label>
        <input type="text" placeholder="Enter UserName" name="username" id="username" required>

        <label for="citta"><b>Citta</b></label>
        <input type="text" placeholder="Enter Citta" name="citta" id="citta" required>

        <label for="via"><b>Via</b></label>
        <input type="text" placeholder="Enter Via" name="via" id="via" required>

        <label for="cap"><b>Cap</b></label>
        <input type="text" placeholder="Enter Cap" name="cap" id="cap" required>

        <label for="telefono"><b>Telefono</b></label>
        <input type="text" placeholder="Enter Telefono" name="telefono" id="telefono" required>

        <hr>

        <button type="submit" class="registerbtn">Register</button>
    </div>

    <div class="container signin">
        <p>SEI GIA ISCRITTO? <a href="login.jsp">ENTRA</a>.</p>
    </div>
</form>

</body>
</html>