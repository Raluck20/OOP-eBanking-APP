package org.poo.cb;

public class BuyStocksCommand implements Command {
	public void execute() {
		DB db = DB.getInstance();
		User user = null;

		for (User u : db.getUsers()) {
			if (u.getEmail().equals(db.getArgumente().get(0))) {
				user = u;
				break;
			}
		}

		double stockValue = 0;

		for (int i = 0; i < db.getStockValues().size(); i++) {
			if (db.getStockValues().get(i).split(",")[0].equals(db.getArgumente().get(1))) {
				int lungime = db.getStockValues().get(i).split(",").length;
				stockValue = Double.parseDouble(db.getStockValues().get(i).split(",")[lungime - 1]);
			}
		}

		for (Cont c : user.getListaConturi()) {
			if (c.getTipValuta().equals("USD")) {
				if (c.getSuma() < Double.parseDouble(db.getArgumente().get(2)) * stockValue) {
					throw new RuntimeException("Insufficient amount in account for buying stock");
				} else {
					c.setSuma(c.getSuma() - Double.parseDouble(db.getArgumente().get(2)) * stockValue);
				}
			}
		}

		Actiuni actiune = new Actiuni(db.getArgumente().get(1), Integer.parseInt(db.getArgumente().get(2)));
		user.getListaActiuni().add(actiune);
	}
}
