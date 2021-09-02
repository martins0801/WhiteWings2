package model.Utente;

import model.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtenteDAO {

    public UtenteDAO(){}

    public ArrayList<Utente> selectAllUtenti(){
        ArrayList<Utente> list = new ArrayList<>();
        try(Connection conn= ConPool.getConnection()){
            PreparedStatement ps= conn.prepareStatement("SELECT * FROM 'utente';");
            ResultSet set = ps.executeQuery();
            Utente utenteR = new Utente();
            utenteR.setIfAdmin(set.getBoolean("ifAdmin")); //IfAdmin in parentesi è quello del database (NOME)
            utenteR.setCap(set.getString("Cap"));
            utenteR.setCitta(set.getString("Citta"));
            utenteR.setVia(set.getString("Via"));
            utenteR.setNome(set.getString("Nome"));
            utenteR.setUsername(set.getString("Username"));
            utenteR.setEmail(set.getString("email"));
            utenteR.setPsword(set.getString("Psword"));
            utenteR.setTelefono(set.getString("telefono"));
            list.add(utenteR);

            while(set.next()){
                Utente utente = new Utente();
                utenteR.setIfAdmin(set.getBoolean("ifAdmin")); //IfAdmin in parentesi è quello del database (NOME)
                utente.setCap(set.getString("Cap"));
                utente.setCitta(set.getString("Citta"));
                utente.setVia(set.getString("Via"));
                utente.setNome(set.getString("Nome"));
                utente.setUsername(set.getString("Username"));
                utente.setEmail(set.getString("email"));
                utenteR.setPsword(set.getString("Psword"));
                utente.setTelefono(set.getString("telefono"));
                list.add(utente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Utente selectUtenteByEmail(String email){
        Utente utenteRitorno = new Utente();
        try(Connection conn= ConPool.getConnection()){
            PreparedStatement ps= conn.prepareStatement("SELECT * FROM 'utente' WHERE 'email=?';");
            ps.setString(1, email);
            ResultSet set = ps.executeQuery();
                utenteRitorno.setIfAdmin(set.getBoolean("ifAdmin"));
                utenteRitorno.setCap(set.getString("Cap"));
                utenteRitorno.setCitta(set.getString("Citta"));
                utenteRitorno.setVia(set.getString("Via"));
                utenteRitorno.setNome(set.getString("Nome"));
                utenteRitorno.setUsername(set.getString("Username"));
                utenteRitorno.setEmail(set.getString("email"));
                utenteRitorno.setPsword(set.getString("Psword"));
                utenteRitorno.setTelefono(set.getString("telefono"));
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return utenteRitorno;
    }

    public boolean insertUtente(Utente utente){
        try(Connection conn=ConPool.getConnection()) {
            PreparedStatement ps= conn.prepareStatement("INSERT INTO 'utente ( email, username, psword, ifAdmin, nome, via, cap,citta,telefono)' VALUES '?,?,?,?,?,?,?,?,?';");
            ps.setString(1, utente.getEmail());
            ps.setString(2,utente.getUsername());
            ps.setString(3,utente.getPsword());
            ps.setBoolean(4, utente.isIfAdmin());
            ps.setString(5, utente.getNome());
            ps.setString(6,utente.getVia());
            ps.setString(7,utente.getCap());
            ps.setString(8,utente.getCitta());
            ps.setString(9, utente.getTelefono());

            int ritorno=ps.executeUpdate();
            if (ritorno==2) return false;
            else return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteUtente(String email) {
        try(Connection conn = ConPool.getConnection()){
            PreparedStatement ps = conn.prepareStatement("DELETE FROM 'utente' WHERE 'email=?';");
            ps.setString(1,email);
            int ritorno=ps.executeUpdate();
            if (ritorno==2) return false;
            else return true;
        } catch (SQLException e) {
        e.printStackTrace();
    }
        return false;
    }


    public boolean updateUtente(Utente utente){
        try(Connection conn=ConPool.getConnection()) {
            PreparedStatement ps= conn.prepareStatement("UPDATE from 'utente'VALUES  'username=?, psword=?, nome=?, via=?, cap=?,citta=?,telefono=?' WHERE  'email=?';");

            ps.setString(1,utente.getUsername());
            ps.setString(2,utente.getPsword());
            ps.setString(3, utente.getNome());
            ps.setString(4,utente.getVia());
            ps.setString(5,utente.getCap());
            ps.setString(6,utente.getCitta());
            ps.setString(7, utente.getTelefono());
            ps.setString(8, utente.getEmail());

            int ritorno=ps.executeUpdate();
            if (ritorno==2) return false;
            else return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
