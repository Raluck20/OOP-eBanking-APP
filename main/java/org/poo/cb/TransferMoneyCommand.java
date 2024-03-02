package org.poo.cb;

public class TransferMoneyCommand implements Command {
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

		for (Cont c : user.getListaConturi()) {
			if (c.getTipValuta().equals(db.getArgumente().get(2))) {
				if (c.getSuma() < Double.parseDouble(db.getArgumente().get(3))) {
					throw new RuntimeException("Insufficient amount in account " + db.getArgumente().get(2) + " for transfer");
				}
			}
		}

		if (!user.getListaPrieteni().contains(userPrieten.getEmail())) {
			throw new RuntimeException("You are not allowed to transfer money to " + userPrieten.getEmail());
		}

		for (Cont c : user.getListaConturi()) {
			if (c.getTipValuta().equals(db.getArgumente().get(2))) {
				c.setSuma(c.getSuma() - Double.parseDouble(db.getArgumente().get(3)));
			}
		}

		for (Cont c : userPrieten.getListaConturi()) {
			if (c.getTipValuta().equals(db.getArgumente().get(2))) {
				c.setSuma(c.getSuma() + Double.parseDouble(db.getArgumente().get(3)));
			}
		}
	}
}
