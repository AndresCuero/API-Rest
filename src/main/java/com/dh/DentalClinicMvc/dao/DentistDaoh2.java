package com.dh.DentalClinicMvc.dao;

import com.dh.DentalClinicMvc.model.Dentist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

 public class DentistDaoh2 implements IDao<Dentist> {


    private static final String SQL_SERVER ="INSERT INTO DENTISTS (REGISTRATION,NAME,LASTNAME) VALUES (?,?,?)";

    private static  final String SQL_SELECT_ID ="SELECT * FROM DENTISTS WHERE ID=?";

    private static final String SQL_UPDATED = "UPDATE DENTISTS SET REGISTRATION=?, NAME=?, LASTNAME=? WHERE ID=? ";

    private static final String SQL_DELETE = "DELETE FROM DENTISTS  WHERE ID=? ";

    private static final String SQL_SELECT_ALL = "SELECT * FROM DENTISTS";

    @Override
    public Dentist save(Dentist dentist) throws Exception {
        Connection connection = null;

        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SERVER, Statement.RETURN_GENERATED_KEYS );
            ps.setInt(1, dentist.getRegistration() );
            ps.setString(2, dentist.getName());
            ps.setString(3, dentist.getLastname());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()){
                dentist.setId(rs.getInt(1));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Dentist findBYId(Integer id) {
        Connection connection = null;
        Dentist dentist = null;
        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ID);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                dentist = new Dentist(rs.getInt(1),rs.getInt(2),rs.getString(3), rs.getString(4));

            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return dentist;
    }

    @Override
    public void update(Dentist dentist) {
      Connection connection = null;

        try {
            connection =DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATED);
            ps.setInt(1, dentist.getRegistration());
            ps.setString(2, dentist.getName());
            ps.setString(3, dentist.getLastname());
            ps.setInt(4, dentist.getId());
            ps.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    @Override
    public void delete(Integer id) {
        Connection connection = null;

        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_DELETE);
            ps.setInt(1,id);
            ps.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<Dentist> findAll() {
        Connection connection = null;
        List<Dentist> listDentist =new  ArrayList<>();
        Dentist dentist = null;
        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ALL);

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                dentist = new Dentist(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4));
                listDentist.add(dentist);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return listDentist;
    }

     @Override
     public Dentist findByString(String email) {
         return null;
     }
 }
