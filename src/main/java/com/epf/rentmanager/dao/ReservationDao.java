package com.epf.rentmanager.dao;

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

public class ReservationDao {

	private static ReservationDao instance = null;

	private ReservationDao() {
	}

	public static ReservationDao getInstance() {
		if (instance == null) {
			instance = new ReservationDao();
		}
		return instance;
	}

	private static final String CREATE_RESERVATION_QUERY = "INSERT INTO Reservation(client_id, vehicle_id, debut, fin) VALUES(?, ?, ?, ?);";
	private static final String DELETE_RESERVATION_QUERY = "DELETE FROM Reservation WHERE id=?;";
	private static final String FIND_RESERVATIONS_BY_CLIENT_QUERY = "SELECT id, vehicle_id, debut, fin FROM Reservation WHERE client_id=?;";
	private static final String FIND_RESERVATIONS_BY_VEHICLE_QUERY = "SELECT id, client_id, debut, fin FROM Reservation WHERE vehicle_id=?;";
	private static final String FIND_RESERVATIONS_QUERY = "SELECT id, client_id, vehicle_id, debut, fin FROM Reservation;";

	public long create(Reservation reservation) throws DaoException {
		try (Statement stmt = ConnectionManager.getConnection().prepareStatement(CREATE_RESERVATION_QUERY,
				Statement.RETURN_GENERATED_KEYS)) {
			((PreparedStatement) stmt).setInt(1, reservation.getClient_id());
			((PreparedStatement) stmt).setInt(2, reservation.getVehicule_id());
			((PreparedStatement) stmt).setDate(3, Date.valueOf(reservation.getDebut()));
			((PreparedStatement) stmt).setDate(4, Date.valueOf(reservation.getFin()));
			long key = ((PreparedStatement) stmt).executeUpdate();
			return key;
		} catch (SQLException e) {
			throw new DaoException();
		}
	
	}

	public long delete(Reservation reservation) throws DaoException {
		try (Statement stmt = ConnectionManager.getConnection().prepareStatement(DELETE_RESERVATION_QUERY,
				Statement.RETURN_GENERATED_KEYS)) {
			((PreparedStatement) stmt).setInt(1, reservation.getId());
			long key = ((PreparedStatement) stmt).executeUpdate();
			return key;
		} catch (SQLException e) {
			throw new DaoException();
		}
	}

	public Optional<Reservation> findResaByClientId(long clientId) throws DaoException {
		try (Statement stmt = ConnectionManager.getConnection().createStatement()) {
			((PreparedStatement) stmt).setLong(1, clientId);
			ResultSet rs = ((PreparedStatement) stmt).executeQuery(FIND_RESERVATIONS_BY_CLIENT_QUERY);
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
		try (Statement stmt = ConnectionManager.getConnection().createStatement()) {
			((PreparedStatement) stmt).setLong(1, vehicleId);
			ResultSet rs = ((PreparedStatement) stmt).executeQuery(FIND_RESERVATIONS_BY_VEHICLE_QUERY);
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

	public Optional<ArrayList<Reservation>> findAll() throws DaoException {
		try (Statement stmt = ConnectionManager.getConnection().createStatement()) {
			ResultSet rs = ((PreparedStatement) stmt).executeQuery(FIND_RESERVATIONS_QUERY);
			ArrayList<Reservation> resaResultList = new ArrayList<Reservation>();
			while (rs.next()) {
				Reservation resa = new Reservation(rs.getInt("id"), rs.getInt("client_id"), rs.getInt("vehicule_id"),
						rs.getDate("debut").toLocalDate(), rs.getDate("fin").toLocalDate());
				resaResultList.add(resa);
			}
			return Optional.of(resaResultList);
		} catch (SQLException e) {
			throw new DaoException();
		}
	}
}