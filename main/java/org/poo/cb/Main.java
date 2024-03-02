package org.poo.cb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		if (args == null) {
			System.out.println("Running Main");
			return;
		}

		DB db = DB.getInstance();

		try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/" + args[0]))) {
			String line;
			while ((line = br.readLine()) != null) {
				db.getExchangeRates().add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/" + args[1]))) {
			String line;
			while ((line = br.readLine()) != null) {
				db.getStockValues().add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/" + args[2]))) {
			String line;
			while ((line = br.readLine()) != null) {
				db.getCommands().add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String command : db.getCommands()) {
			String numeComanda = command.split(" ")[0] + " " + command.split(" ")[1];
			db.getArgumente().clear();
			for (int i = 2; i < command.split(" ").length; i++) {
				db.getArgumente().add(command.split(" ")[i]);
			}
			CommandInvoker.execute(numeComanda);
		}

		db.getUsers().clear();
		db.getCommands().clear();
		db.getStockValues().clear();
		db.getExchangeRates().clear();
	}
}