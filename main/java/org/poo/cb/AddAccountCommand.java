package org.poo.cb;

public class AddAccountCommand implements Command {
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
				throw new RuntimeException("Account in currency " + db.getArgumente().get(1) + " already exists for user");
			}
		}

		Cont cont = Cont.createCont(db.getArgumente().get(1), 0);
		user.getListaConturi().add(cont);
	}
}
