package org.poo.cb;

public class ExchangeMoneyCommand implements Command {
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
				if (c.getSuma() < Double.parseDouble(db.getArgumente().get(3))) {
					throw new RuntimeException("Insufficient amount in account " + db.getArgumente().get(1) + " for exchange");
				}
			}
		}

		double exchangeRate = 0;
		int i;

		for (i = 0; i < db.getExchangeRates().get(0).split(",").length; i++) {
			if (db.getExchangeRates().get(0).split(",")[i].equals(db.getArgumente().get(1))) {
				break;
			}
		}

		for (int j = 1; j < db.getExchangeRates().size(); j++) {
			if (db.getExchangeRates().get(j).split(",")[0].equals(db.getArgumente().get(2))) {
				exchangeRate = Double.parseDouble(db.getExchangeRates().get(j).split(",")[i]);
				break;
			}
		}

		for (Cont c : user.getListaConturi()) {
			if (c.getTipValuta().equals(db.getArgumente().get(1))) {
				if (c.getSuma() / 2 < Double.parseDouble(db.getArgumente().get(3)) * exchangeRate) {
					double comision = Double.parseDouble(db.getArgumente().get(3)) * exchangeRate * 0.01;
					c.setSuma(c.getSuma() - Double.parseDouble(db.getArgumente().get(3)) * exchangeRate - comision);
				} else {
					c.setSuma(c.getSuma() - Double.parseDouble(db.getArgumente().get(3)) * exchangeRate);
				}
			}
			if (c.getTipValuta().equals(db.getArgumente().get(2))) {
				c.setSuma(c.getSuma() + Double.parseDouble(db.getArgumente().get(3)));
			}
		}
	}
}
