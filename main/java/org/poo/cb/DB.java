package org.poo.cb;

import java.util.ArrayList;

public class DB {
	public static DB instance = null;

	private final ArrayList<User> users;
	private final ArrayList<String> commands;
	private final ArrayList<String> stockValues;
	private final ArrayList<String> exchangeRates;
	private final ArrayList<String> argumente;

	private DB() {
		users = new ArrayList<User>();
		commands = new ArrayList<String>();
		stockValues = new ArrayList<String>();
		exchangeRates = new ArrayList<String>();
		argumente = new ArrayList<String>();
	}

	public static DB getInstance() {
		if (instance == null) {
			instance = new DB();
		}

		return instance;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public ArrayList<String> getCommands() {
		return commands;
	}

	public ArrayList<String> getStockValues() {
		return stockValues;
	}

	public ArrayList<String> getExchangeRates() {
		return exchangeRates;
	}

	public ArrayList<String> getArgumente() {
		return argumente;
	}
}
