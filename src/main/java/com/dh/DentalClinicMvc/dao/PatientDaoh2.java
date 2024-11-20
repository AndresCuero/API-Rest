package com.dh.DentalClinicMvc.dao;


import com.dh.DentalClinicMvc.model.Address;
import com.dh.DentalClinicMvc.model.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.util.concurrent.ExecutionException;


public class PatientDaoh2 implements IDao<Patient> {

    private static final String SQL_INSERT_SERVER = "INSERT INTO PATIENTS " +
            "(NAME,LASTNAME, CARD_IDENTITY,ADMISSION_OF_DATE,ADDRESS_ID, EMAIL) VALUES (?,?,?,?,?,?)";

    private static final  String SQL_SELECT_ID = "SELECT * FROM PATIENTS WHERE ID=?";

    private static final  String SQL_UPDATED = "UPDATE PATIENTS SET NAME=?, LASTNAME=?, CARD_IDENTITY=?, ADMISSION_OF_DATE=?, ADDRESS_ID=?, EMAIL=? "+
                                            "WHERE ID=?";

    private static final String SQL_DELETE ="DELETE FROM PATIENTS WHERE ID=? ";

    private static final String SQL_SELECT_ALL = "SELECT * FROM PATIENTS";

    private static  final String SQL_SELECT_EMIL = "SELECT * FROM PATIENTS WHERE EMAIL=?";

    @Override
    public Patient save(Patient patient) {
        Connection connection = null;
        try{
            AddressDaoh2 addressDaoh2 = new AddressDaoh2();
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT_SERVER, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,patient.getName());
            ps.setString(2, patient.getLastname());
            ps.setInt(3, patient.getCardIdentity() );
            ps.setDate(4, Date.valueOf(patient.getAdmissionOfDate()));
            ps.setInt( 5, patient.getAddress().getId());
            ps.setString(6, patient.getEmail());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()){
                patient.setId(rs.getInt(1));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return patient;
    }

    @Override
    public Patient findBYId(Integer id) {
        Connection connection = null;
        Patient patient = null;

        try{
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ID);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            AddressDaoh2 addressDaoh2 = new AddressDaoh2();
            while (rs.next()){
                Address address = addressDaoh2.findBYId(rs.getInt(6));
                patient = new Patient(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getInt(4),rs.getDate(5).toLocalDate(), address, rs.getString(7));
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
        return patient;
    }

    @Override
    public void update(Patient patient) {
        Connection connection = null;

        try{
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATED);
            ps.setString(1,patient.getName());
            ps.setString(2, patient.getLastname());
            ps.setInt(3,patient.getCardIdentity());
            ps.setDate(4, Date.valueOf(patient.getAdmissionOfDate()));
            ps.setInt(5, patient.getAddress().getId());
            ps.setString(6,patient.getEmail());
            ps.setInt(7, patient.getId());
            ps.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (Exception e) {
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

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Patient> findAll() {
        Connection connection = null;
        List<Patient> listPatient = new ArrayList<>();
        Patient patient = null;

        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ALL);

            ResultSet rs = ps.executeQuery();
            AddressDaoh2 addressDaoh2 = new AddressDaoh2();
            while (rs.next()){
                Address address = addressDaoh2.findBYId(rs.getInt(6));
                patient = new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
                        rs.getDate(5).toLocalDate(), address, rs.getString(7));
                listPatient.add(patient);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return listPatient;
    }

    @Override
    public Patient findByString(String email) {
        Connection connection = null;
        Patient patient = null;

        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_EMIL);
            ps.setString(1,email);

            ResultSet rs = ps.executeQuery();
            AddressDaoh2 addressDaoh2 = new AddressDaoh2();
            while (rs.next()){
                Address address = addressDaoh2.findBYId(rs.getInt(6));
                patient = new Patient(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getInt(4),rs.getDate(5).toLocalDate(), address, rs.getString(7));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return patient;
    }
}
