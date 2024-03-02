package org.poo.cb;

public class AddMoneyCommand implements Command {
	public void execute() {
		DB db = DB.getInstance();
		User user = null;

		for (User u : db.getUsers()) {
			if (u.getEmail().equals(db.getArgumente().get(0))) {
				user = u;
				break;
			}
		}

		for (Cont c : user.getListaConturi()) {
			if (c.getTipValuta().equals(db.getArgumente().get(1))) {
				c.setSuma(c.getSuma() + Double.parseDouble(db.getArgumente().get(2)));
				return;
			}
		}
	}
}
