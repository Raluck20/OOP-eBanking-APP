package org.poo.cb;

public class AddFriendCommand implements Command {
	public void execute() {
		DB db = DB.getInstance();
		User user = null;
		User userPrieten = null;

		for (User u : db.getUsers()) {
			if (u.getEmail().equals(db.getArgumente().get(0))) {
				user = u;
				break;
			}
		}

		for (User u : db.getUsers()) {
			if (u.getEmail().equals(db.getArgumente().get(1))) {
				userPrieten = u;
				break;
			}
		}

		if (user == null) {
			throw new RuntimeException("User with " + db.getArgumente().get(0) + " doesn't exist");
		}

		if (userPrieten == null) {
			throw new RuntimeException("User with " + db.getArgumente().get(1) + " doesn't exist");
		}

		if (user.getListaPrieteni().contains(userPrieten.getEmail())) {
			throw new RuntimeException("User with " + db.getArgumente().get(1) + " is already a friend");
		}

		user.getListaPrieteni().add(userPrieten.getEmail());
		userPrieten.getListaPrieteni().add(user.getEmail());
	}
}
