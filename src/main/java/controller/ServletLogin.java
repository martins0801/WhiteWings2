package controller;

import model.Utente.Utente;
import model.Utente.UtenteDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletLogin", value = "/ServletLogin")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nUtente= request.getParameter("nUtente");
        String password= request.getParameter("psw");
        System.out.println(nUtente +" "+ password);
        UtenteDAO utenteDAO = new UtenteDAO();
        Utente utente= utenteDAO.selectUtenteByNomeUtentePassword(nUtente,password);
        String address=null;
        if(utente.getUsername()!= null && utente.getPsword()!= null){
            System.out.println("sono qui");

            System.out.println(utente.toString());
                System.out.println("sono qui 2");
                if(utente.isIfAdmin()) {
                    System.out.println("sono qui 3");

                    address = "/views/homeAmministratore.jsp";
                }
                else{

                        address="/views/UtenteLoggato.jsp";

                }

        }
        else address="../../webapp/index.jsp";

        HttpSession session = request.getSession(true);
        session.setAttribute("user", utente);
        RequestDispatcher requestDispatcher= request.getRequestDispatcher(address);
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }
    }
