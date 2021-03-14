package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import metier.Patient;
import metier.Medecin;
import metier.Secretaire;


public class DAOPatient implements IDAO<Patient,Integer>{

	@Override
	public Patient findById(Integer id) {
		Patient patient= null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(chemin,login,password);
			PreparedStatement ps = conn.prepareStatement("Select * from patient where id=?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				String nom=rs.getString("nom");
				String prenom=rs.getString("prenom");

				patient=new Patient(id,nom,prenom);	
			}
			rs.close();
			ps.close();
			conn.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}

		return patient;
	}



	@Override
	public List<Patient> findAll() {
		List<Patient> patients= new ArrayList();
		Patient patient=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(chemin,login,password);
			PreparedStatement ps = conn.prepareStatement("Select * from patient");
			ResultSet rs = ps.executeQuery();


			while(rs.next()) 
			{
				int id=rs.getInt("id");
				String nom=rs.getString("nom");
				String prenom=rs.getString("prenom");

				patient=new Patient(id,nom,prenom);	
				patients.add(patient);
			}


			rs.close();
			ps.close();
			conn.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}

		return patients;
	}



	@Override
	public void insert(Patient patient) {
		try {
			Class.forName("com.mysql.jdbc.Driver");


			Connection conn=DriverManager.getConnection(chemin,login,password);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO patient (id,nom,prenom) VALUES(?,?,?)");
			ps.setInt(1,patient.getId());
			ps.setString(2,patient.getNom());
			ps.setString(3,patient.getPrenom());

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Patient patient) {
		try {
			Class.forName("com.mysql.jdbc.Driver");


			Connection conn=DriverManager.getConnection(chemin,login,password);

			PreparedStatement ps = conn.prepareStatement("UPDATE patient set nom=?,prenom=? where id=?");

			ps.setString(1,patient.getNom());
			ps.setString(2,patient.getPrenom());
			ps.setInt(3,patient.getId());

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Patient patient) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(chemin,login,password);

			PreparedStatement ps = conn.prepareStatement("DELETE FROM patient where id=?");
			ps.setInt(1,patient.getId());

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
