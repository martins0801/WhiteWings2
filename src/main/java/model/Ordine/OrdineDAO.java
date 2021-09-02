package model.Ordine;

import model.ConPool;
import model.OrdineDolci.OrdineDolciDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdineDAO {

    public OrdineDAO(){}

    public boolean insertOrdine(Ordine ordine){
        try (Connection conn = ConPool.getConnection()){
            PreparedStatement ps= conn.prepareStatement("INSERT  into 'ordine ( idOrdine, quantita, email, dataOrdine)' VALUES '?,?,?,?;'");
            ps.setInt(1,ordine.getIdOrdine());
            ps.setInt(2,ordine.getQuantità());
            ps.setString(3,ordine.getEmail());
            ps.setDate(4,ordine.getDataOrdine());
            int ritorno=ps.executeUpdate();
            if (ritorno==2) return false;
            else return true;
        }catch(SQLException e){
            throw  new RuntimeException(e);
        }
    }

    public boolean deleteOrdineById(int id){
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps=conn.prepareStatement("DELETE FROM 'ordine' WHERE 'idOrdine=?';");
            ps.setInt(1,id);
            int ritorno=ps.executeUpdate();
            if(ritorno==2) return false;
            else return true;
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateQuantitaOrdine(int id, int newQuantita){
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps=conn.prepareStatement("UPDATE FROM 'ordine' SET 'quantita=?' WHERE 'idOrdine=?';");
            ps.setInt(1,newQuantita);
            ps.setInt(2,id);
            int ritorno=ps.executeUpdate();
            if(ritorno==2) return false;
            else return true;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Ordine> selectAllOrdini(){
        ArrayList<Ordine> lista= new ArrayList<>();
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps=conn.prepareStatement("SELECT * FROM 'ordine';");
            ResultSet rs = ps.executeQuery();
            Ordine ordinePrimoRecord = new Ordine();
            ordinePrimoRecord.setIdOrdine(rs.getInt("idOrdine"));
            ordinePrimoRecord.setEmail(rs.getString("email"));
            ordinePrimoRecord.setDataOrdine(rs.getDate("dataOrdine"));
            ordinePrimoRecord.setQuantità(rs.getInt("quantita"));
            lista.add(ordinePrimoRecord);
            while(rs.next()) {
                Ordine ordine = new Ordine();
                ordine.setIdOrdine(rs.getInt("idOrdine"));
                ordine.setEmail(rs.getString("email"));
                ordine.setDataOrdine(rs.getDate("dataOrdine"));
                ordine.setQuantità(rs.getInt("quantita"));
                lista.add(ordine);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Ordine selectOrdineById(int id){
        Ordine ordinePrimoRecord = new Ordine();
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps=conn.prepareStatement("SELECT * FROM 'ordine';");
            ResultSet rs = ps.executeQuery();
            ordinePrimoRecord.setIdOrdine(rs.getInt("idOrdine"));
            ordinePrimoRecord.setEmail(rs.getString("email"));
            ordinePrimoRecord.setDataOrdine(rs.getDate("dataOrdine"));
            ordinePrimoRecord.setQuantità(rs.getInt("quantita"));

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return ordinePrimoRecord;
    }
}
