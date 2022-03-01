package com.epf.rentmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.persistence.ConnectionManager;

import org.springframework.stereotype.Repository;

@Repository
public class VehicleDao {

	//private static VehicleDao instance = null;

	private VehicleDao() {
	}

	/*public static VehicleDao getInstance() {
		if (instance == null) {
			instance = new VehicleDao();
		}
		return instance;
	}*/

	private static final String CREATE_VEHICLE_QUERY = "INSERT INTO Vehicle(constructeur, modele, nb_places, client_id) VALUES(?, ?,?,?);";
	private static final String DELETE_VEHICLE_QUERY = "DELETE FROM Vehicle WHERE id=?;";
	private static final String FIND_VEHICLE_QUERY = "SELECT id, constructeur, modele, nb_places FROM Vehicle WHERE id=?;";
	private static final String FIND_VEHICLES_QUERY = "SELECT id, constructeur, modele, nb_places FROM Vehicle;";
	private static final String FIND_VEHICLES_COUNT_QUERY = "SELECT COUNT(id) AS count FROM Vehicle";
	

	public long create(Vehicle vehicle) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement(CREATE_VEHICLE_QUERY,
					Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, vehicle.getConstructeur());
			stmt.setString(2, vehicle.getModele());
			stmt.setInt(3, vehicle.getNb_place());
			stmt.setInt(4, vehicle.getClient_id());
			long key = ((PreparedStatement) stmt).executeUpdate();
			conn.close();
			return key;
		} catch (SQLException e) {
			throw new DaoException();
		}
	}

	public long delete(Vehicle vehicle) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement(DELETE_VEHICLE_QUERY,
					Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, vehicle.getId());
			long key = ((PreparedStatement) stmt).executeUpdate();
			return key;
		} catch (SQLException e) {
			throw new DaoException();
		}
	}

	public Optional<Vehicle> findById(long id) throws DaoException {
		try  {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement(FIND_VEHICLE_QUERY);
			stmt.setLong(1, id);
			ResultSet rs = ((PreparedStatement) stmt).executeQuery();
			while (rs.next()) {
				Vehicle vehicule = new Vehicle(rs.getInt("id"), rs.getString("constructeur"), rs.getString("modele"),
						rs.getByte("nb_places"));
				System.out.println(vehicule);
				conn.close();
				return Optional.of(vehicule);
			}
			
		} catch (SQLException e) {
			throw new DaoException();
		}
		return Optional.empty();
	}

	public ArrayList<Vehicle> findAll() throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement(FIND_VEHICLES_QUERY);
			ResultSet rs = ((PreparedStatement) stmt).executeQuery();
			ArrayList<Vehicle> vehiculeResultList = new ArrayList<Vehicle>();
			while (rs.next()) {
				Vehicle vehicle = new Vehicle(rs.getInt("id"), rs.getString("constructeur"), rs.getString("modele"),
						rs.getByte("nb_places"));
				vehiculeResultList.add(vehicle);
			}
			conn.close();
			return vehiculeResultList;
		} catch (SQLException e) {
			throw new DaoException();
		}
	}

	public int findCountVehicule() throws DaoException {
		try  {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement(FIND_VEHICLES_COUNT_QUERY);
			ResultSet rs = ((PreparedStatement) stmt).executeQuery();
			rs.next();
			int count = rs.getInt("count");
			return count;
		} catch (SQLException e) {
			throw new DaoException();
		}
	}
}