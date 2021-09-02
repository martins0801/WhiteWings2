package model.Dolci;


import model.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DolciDAO {

    public DolciDAO(){}

    public Dolci cercaDolceByCodice(int codice){
        Dolci dolce=new Dolci();
        try(Connection conn= ConPool.getConnection()){
            PreparedStatement ps= conn.prepareStatement("SELECT * FROM 'dolci' WHERE  'cod=?'");
            ps.setInt(1,codice);
            ResultSet set= ps.executeQuery();
            dolce.setCodice(set.getInt("Cod"));
            dolce.setDescrizione(set.getString("Descrizione"));
            dolce.setNome(set.getString("Nome"));
            dolce.setPrezzoAlKg(set.getDouble("Prezzokg"));
            dolce.setTempoConservazione(set.getString("Tconservazione"));
            dolce.setTempoCottura(set.getString("Tcottura"));
            dolce.setIdTipologia(set.getInt("idTipologia"));
            dolce.setPeso(set.getDouble("Peso"));

            return dolce;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public ArrayList<Dolci> selectAllDolci(){
        ArrayList<Dolci> lista=new ArrayList<>();
        try(Connection conn= ConPool.getConnection()){
            PreparedStatement ps= conn.prepareStatement("SELECT * FROM 'dolci'");
            ResultSet set= ps.executeQuery();
            Dolci dolcePrimoRecord = new Dolci();
            dolcePrimoRecord.setCodice(set.getInt("Cod"));
            dolcePrimoRecord.setDescrizione(set.getString("Descrizione"));
            dolcePrimoRecord.setNome(set.getString("Nome"));
            dolcePrimoRecord.setPrezzoAlKg(set.getDouble("Prezzokg"));
            dolcePrimoRecord.setTempoConservazione(set.getString("Tconservazione"));
            dolcePrimoRecord.setTempoCottura(set.getString("Tcottura"));
            dolcePrimoRecord.setIdTipologia(set.getInt("idTipologia"));
            dolcePrimoRecord.setPeso(set.getDouble("Peso"));
            lista.add(dolcePrimoRecord);

            while(set.next()) {
                Dolci dolce = new Dolci();
                dolce.setCodice(set.getInt("Cod"));
                dolce.setDescrizione(set.getString("Descrizione"));
                dolce.setNome(set.getString("Nome"));
                dolce.setPrezzoAlKg(set.getDouble("Prezzokg"));
                dolce.setTempoConservazione(set.getString("Tconservazione"));
                dolce.setTempoCottura(set.getString("Tcottura"));
                dolce.setIdTipologia(set.getInt("idTipologia"));
                dolce.setPeso(set.getDouble("Peso"));
                lista.add(dolce);
            }

            return lista;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public boolean insertDolce(Dolci dolce) {
        try (Connection conn = ConPool.getConnection()){
                PreparedStatement ps= conn.prepareStatement("INSERT  into 'dolci ( prezzoAlKg,nome, descrizione,tempoCottura,tempoConservazione, codice,idTipologia,peso)' VALUES '?,?,?,?,?,?,?,?,?;'");
            ps.setDouble(1,dolce.getPrezzoAlKg());
            ps.setString(2,dolce.getNome());
            ps.setString(3,dolce.getDescrizione());
            ps.setString(4, dolce.getTempoCottura());
            ps.setString(5,dolce.getTempoConservazione());
            ps.setInt(6,dolce.getCodice());
            ps.setInt(7,dolce.getIdTipologia());
            ps.setDouble(8,dolce.getPeso());
            int ritorno=ps.executeUpdate();
            if (ritorno==2) return false;
            else return true;
        }catch(SQLException e){
            throw  new RuntimeException(e);

        }
    }

    public boolean updateDolce(Dolci dolce){
        try(Connection conn = ConPool.getConnection()) {
            PreparedStatement ps=conn.prepareStatement("UPDATE FROM 'dolci' SET 'prezzoAlKg=?, descrizione=?, idTipologia=?,peso=?' WHERE 'codice=?';");
            ps.setDouble(1,dolce.getPrezzoAlKg());
            ps.setString(2,dolce.getDescrizione());
            ps.setInt(3,dolce.getIdTipologia());
            ps.setDouble(4,dolce.getPeso());
            ps.setInt(5,dolce.getCodice());
            int ritorno= ps.executeUpdate();
            if(ritorno==2) return false;
            else return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteDolce(int codice){
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps=conn.prepareStatement("DELETE FROM 'dolci' WHERE 'codice=?';");
            ps.setInt(1,codice);
            int ritorno=ps.executeUpdate();
            if(ritorno==2) return false;
            else return true;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public ArrayList<Dolci> cercaDolciPerTipologia(int idTipolgia){
        ArrayList<Dolci> lista=new ArrayList<>();
        try(Connection conn=ConPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM 'dolci' WHERE  'idCategoria=?'");
            ps.setInt(1, idTipolgia);
            ResultSet set = ps.executeQuery();

            Dolci dolcePrimoRecord = new Dolci();
            dolcePrimoRecord.setCodice(set.getInt("Cod"));
            dolcePrimoRecord.setDescrizione(set.getString("Descrizione"));
            dolcePrimoRecord.setNome(set.getString("Nome"));
            dolcePrimoRecord.setPrezzoAlKg(set.getDouble("Prezzokg"));
            dolcePrimoRecord.setTempoConservazione(set.getString("Tconservazione"));
            dolcePrimoRecord.setTempoCottura(set.getString("Tcottura"));
            dolcePrimoRecord.setIdTipologia(set.getInt("idTipologia"));
            dolcePrimoRecord.setPeso(set.getDouble("Peso"));
            lista.add(dolcePrimoRecord);

            while(set.next()){
            Dolci dolce = new Dolci();
            dolce.setCodice(set.getInt("Cod"));
            dolce.setDescrizione(set.getString("Descrizione"));
            dolce.setNome(set.getString("Nome"));
            dolce.setPrezzoAlKg(set.getDouble("Prezzokg"));
            dolce.setTempoConservazione(set.getString("Tconservazione"));
            dolce.setTempoCottura(set.getString("Tcottura"));
            dolce.setIdTipologia(set.getInt("idTipologia"));
            dolce.setPeso(set.getDouble("Peso"));
            lista.add(dolce);
            }

            return lista;
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }




}
