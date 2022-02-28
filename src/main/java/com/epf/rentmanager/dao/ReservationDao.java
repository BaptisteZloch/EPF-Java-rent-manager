package com.epf.rentmanager.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.persistence.ConnectionManager;

import org.springframework.stereotype.Repository;

@Repository
public class ReservationDao {

	/*private static ReservationDao instance = null;

	private ReservationDao() {
	}

	public static ReservationDao getInstance() {
		if (instance == null) {
			instance = new ReservationDao();
		}
		return instance;
	}*/

	private static final String CREATE_RESERVATION_QUERY = "INSERT INTO Reservation(client_id, vehicle_id, debut, fin) VALUES(?, ?, ?, ?);";
	private static final String DELETE_RESERVATION_QUERY = "DELETE FROM Reservation WHERE id=?;";
	private static final String FIND_RESERVATIONS_BY_CLIENT_QUERY = "SELECT id, vehicle_id, debut, fin FROM Reservation WHERE client_id=?;";
	private static final String FIND_RESERVATIONS_BY_VEHICLE_QUERY = "SELECT id, client_id, debut, fin FROM Reservation WHERE vehicle_id=?;";
	private static final String FIND_RESERVATIONS_QUERY = "SELECT id, client_id, vehicle_id, debut, fin FROM Reservation;";

	public long create(Reservation reservation) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement(CREATE_RESERVATION_QUERY,
			Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, reservation.getClient_id());
			stmt.setInt(2, reservation.getVehicule_id());
			stmt.setDate(3, Date.valueOf(reservation.getDebut()));
			stmt.setDate(4, Date.valueOf(reservation.getFin()));
			long key = ((PreparedStatement) stmt).executeUpdate();
			conn.close();
			return key;
		} catch (SQLException e) {
			throw new DaoException();
		}

	}

	public long delete(Reservation reservation) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement(DELETE_RESERVATION_QUERY,
										Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, reservation.getId());
			long key = ((PreparedStatement) stmt).executeUpdate();
			conn.close();
			return key;
		} catch (SQLException e) {
			throw new DaoException();
		}
	}

	public Optional<Reservation> findResaByClientId(long clientId) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement(FIND_RESERVATIONS_BY_CLIENT_QUERY);
			stmt.setLong(1, clientId);
			ResultSet rs = ((PreparedStatement) stmt).executeQuery();
			conn.close();
			while (rs.next()) {
				Reservation resa = new Reservation(rs.getInt("id"), rs.getInt("client_id"), rs.getInt("vehicule_id"),
						rs.getDate("debut").toLocalDate(), rs.getDate("fin").toLocalDate());
				System.out.println(resa);
				return Optional.of(resa);
			}
		} catch (SQLException e) {
			throw new DaoException();
		}
		return Optional.empty();
	}

	public Optional<Reservation> findResaByVehicleId(long vehicleId) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement(FIND_RESERVATIONS_BY_VEHICLE_QUERY);
			stmt.setLong(1, vehicleId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Reservation resa = new Reservation(rs.getInt("id"), rs.getInt("client_id"), rs.getInt("vehicule_id"),
						rs.getDate("debut").toLocalDate(), rs.getDate("fin").toLocalDate());
				System.out.println(resa);
				return Optional.of(resa);
			}
		} catch (SQLException e) {
			throw new DaoException();
		}
		return Optional.empty();
	}

	public ArrayList<Reservation> findAll() throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement(FIND_RESERVATIONS_QUERY);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Reservation> resaResultList = new ArrayList<Reservation>();
			while (rs.next()) {
				Reservation resa = new Reservation(rs.getInt("id"), rs.getInt("client_id"), rs.getInt("vehicule_id"),
						rs.getDate("debut").toLocalDate(), rs.getDate("fin").toLocalDate());
				resaResultList.add(resa);
			}
			conn.close();
			return resaResultList;
		} catch (SQLException e) {
			throw new DaoException();
		}
	}
}