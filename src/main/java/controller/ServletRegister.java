package controller;

import model.Utente.Utente;
import model.Utente.UtenteDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletRegister", value = "/ServletRegister")
public class ServletRegister extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String psw = request.getParameter("psw");
        String username = request.getParameter("username");
        String citta = request.getParameter("citta");
        String via = request.getParameter("via");
        String cap = request.getParameter("cap");
        String telefono = request.getParameter("telefono");

        Utente utente= new Utente();
        utente.setNome(nome);
        utente.setEmail(email);
        utente.setPsword(psw);
        utente.setUsername(username);
        utente.setCitta(citta);
        utente.setVia(via);
        utente.setCap(cap);
        utente.setTelefono(telefono);
        utente.setIfAdmin(false);

        UtenteDAO utenteDAO = new UtenteDAO();

        if(utenteDAO.controllaEmail(utente)){
            System.out.println("email già presente in database");
        }else if(utenteDAO.controllaNomeUtente(utente)){
            System.out.println("nome utente già presente in database");
        }else{
            if(utenteDAO.insertUtente(utente)){
                System.out.println("Inserimento effettuato");
            }
            else{
                System.out.println("Inserimento NON effettuato");
            }
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
