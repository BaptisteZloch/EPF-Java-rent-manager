package com.epf.rentmanager.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.persistence.ConnectionManager;

public class ClientDao {

	private static ClientDao instance = null;

	private ClientDao() {
	}

	public static ClientDao getInstance() {
		if (instance == null) {
			instance = new ClientDao();
		}
		return instance;
	}

	private static final String CREATE_CLIENT_QUERY = "INSERT INTO Client(nom, prenom, email, naissance) VALUES(?, ?, ?, ?);";
	private static final String DELETE_CLIENT_QUERY = "DELETE FROM Client WHERE id=?;";
	private static final String FIND_CLIENT_QUERY = "SELECT nom, prenom, email, naissance FROM Client WHERE id=?;";
	private static final String FIND_CLIENTS_QUERY = "SELECT id, nom, prenom, email, naissance FROM Client;";

	public long create(Client client) throws DaoException {

		long key = 0;
		try (Statement stmt = ConnectionManager.getConnection().prepareStatement(CREATE_CLIENT_QUERY,
				Statement.RETURN_GENERATED_KEYS)) {
			((PreparedStatement) stmt).setString(1, client.getNom());
			((PreparedStatement) stmt).setString(2, client.getPrenom());
			((PreparedStatement) stmt).setString(3, client.getEmail());
			((PreparedStatement) stmt).setDate(4, Date.valueOf(client.getNaissance()));
			key = ((PreparedStatement) stmt).executeUpdate();
			return key;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return key;
	}

	public long delete(Client client) throws DaoException {
		long key = 0;
		try (Statement stmt = ConnectionManager.getConnection().prepareStatement(DELETE_CLIENT_QUERY,
				Statement.RETURN_GENERATED_KEYS)) {
			((PreparedStatement) stmt).setInt(1, client.getId());
			key = ((PreparedStatement) stmt).executeUpdate();
			return key;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return key;
	}

	public Optional<Client> findById(long id) throws DaoException {
		Client client;
		try (Statement stmt = ConnectionManager.getConnection().createStatement()) {
			((PreparedStatement) stmt).setLong(1, id);
			ResultSet rs = ((PreparedStatement) stmt).executeQuery(FIND_CLIENT_QUERY);
			while (rs.next()) {
				client = new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"),
						rs.getDate("naissance").toLocalDate());
				System.out.println(client);
				return Optional.ofNullable(client);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Client> findAll() throws DaoException {
		ArrayList<Client> clientResultList = new ArrayList<Client>();
		try (Statement stmt = ConnectionManager.getConnection().createStatement()) {
			ResultSet rs = ((PreparedStatement) stmt).executeQuery(FIND_CLIENTS_QUERY);
			// Stores properties of a ResultSet object, including column count
			while (rs.next()) {
					Client client = new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),
							rs.getString("email"), rs.getDate("naissance").toLocalDate());
					clientResultList.add(client);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientResultList;
	}

}
