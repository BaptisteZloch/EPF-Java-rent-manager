package com.epf.rentmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.persistence.ConnectionManager;

public class VehicleDao {

	private static VehicleDao instance = null;

	private VehicleDao() {
	}

	public static VehicleDao getInstance() {
		if (instance == null) {
			instance = new VehicleDao();
		}
		return instance;
	}

	private static final String CREATE_VEHICLE_QUERY = "INSERT INTO Vehicle(constructeur, nb_places) VALUES(?, ?);";
	private static final String DELETE_VEHICLE_QUERY = "DELETE FROM Vehicle WHERE id=?;";
	private static final String FIND_VEHICLE_QUERY = "SELECT id, constructeur, nb_places FROM Vehicle WHERE id=?;";
	private static final String FIND_VEHICLES_QUERY = "SELECT id, constructeur, nb_places FROM Vehicle;";

	public long create(Vehicle vehicle) throws DaoException {
		try (Statement stmt = ConnectionManager.getConnection().prepareStatement(CREATE_VEHICLE_QUERY,
				Statement.RETURN_GENERATED_KEYS)) {
			((PreparedStatement) stmt).setString(1, vehicle.getConstructeur());
			((PreparedStatement) stmt).setString(2, vehicle.getModele());
			((PreparedStatement) stmt).setInt(3, vehicle.getNb_place());
			long key = ((PreparedStatement) stmt).executeUpdate();
			return key;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public long delete(Vehicle vehicle) throws DaoException {
		try (Statement stmt = ConnectionManager.getConnection().prepareStatement(DELETE_VEHICLE_QUERY,
				Statement.RETURN_GENERATED_KEYS)) {
			((PreparedStatement) stmt).setInt(1, vehicle.getId());
			long key = ((PreparedStatement) stmt).executeUpdate();
			return key;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Optional<Vehicle> findById(long id) throws DaoException {
		try (Statement stmt = ConnectionManager.getConnection().createStatement()) {
			((PreparedStatement) stmt).setLong(1, id);
			ResultSet rs = ((PreparedStatement) stmt).executeQuery(FIND_VEHICLE_QUERY);
			while (rs.next()) {
				Vehicle vehicule = new Vehicle(rs.getInt("id"), rs.getString("constructeur"), rs.getString("modele"),
						rs.getByte("nb_place"));
				System.out.println(vehicule);
				return Optional.of(vehicule);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	public Optional<ArrayList<Vehicle>> findAll() throws DaoException {
		try (Statement stmt = ConnectionManager.getConnection().createStatement()) {
			ResultSet rs = ((PreparedStatement) stmt).executeQuery(FIND_VEHICLES_QUERY);
			ArrayList<Vehicle> vehiculeResultList = new ArrayList<Vehicle>();
			while (rs.next()) {
				Vehicle vehicle = new Vehicle(rs.getInt("id"), rs.getString("constructeur"), rs.getString("modele"),
						rs.getByte("nb_place"));
				vehiculeResultList.add(vehicle);
			}
			return Optional.of(vehiculeResultList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
}