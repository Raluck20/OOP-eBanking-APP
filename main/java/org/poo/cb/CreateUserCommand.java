package org.poo.cb;

import java.util.ArrayList;

public class CreateUserCommand implements Command {
	public void execute() {
		DB db = DB.getInstance();
		User user = null;

		for (User u : db.getUsers()) {
			if (u.getEmail().equals(db.getArgumente().get(0))) {
				user = u;
				break;
			}
		}

		if (user != null) {
			throw new RuntimeException("User with " + db.getArgumente().get(0) + " already exists");
		}

		String adresa = "";
		for (int i = 3; i < db.getArgumente().size(); i++) {
			adresa += db.getArgumente().get(i);
			if (i != db.getArgumente().size() - 1) {
				adresa += " ";
			}
		}

		user = new User.UserBuilder(db.getArgumente().get(0))
				.setNume(db.getArgumente().get(1))
				.setPrenume(db.getArgumente().get(2))
				.setAdresa(adresa)
				.setListaPrieteni(new ArrayList<>())
				.setListaConturi(new ArrayList<>())
				.setListaActiuni(new ArrayList<>())
				.build();

		db.getUsers().add(user);
	}
}
