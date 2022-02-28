package com.epf.rentmanager.service;

import java.util.ArrayList;
import java.util.Optional;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epf.rentmanager.dao.ClientDao;

@Service
public class ClientService {

	private ClientDao clientDao;
	// public static ClientService instance;

	@Autowired
	public ClientService(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	/*
	 * public static ClientService getInstance() {
	 * if (instance == null) {
	 * instance = new ClientService();
	 * }
	 * return instance;
	 * }
	 */

	public long delete(Client client) throws ServiceException {
		try {
			return this.clientDao.delete(client);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int count() throws ServiceException {
		try {
			return this.clientDao.findCountClient();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public long create(Client client) throws ServiceException {
		try {
			return this.clientDao.create(client);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Optional<Client> findById(long id) throws ServiceException {
		try {
			return this.clientDao.findById(id);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	public ArrayList<Client> findAll() throws ServiceException {
		try {
			return this.clientDao.findAll();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}
}
