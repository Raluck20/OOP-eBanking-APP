package org.poo.cb;

import java.util.ArrayList;

public class RecommendStocksCommand implements Command {
	public void execute() {
		DB db = DB.getInstance();
		ArrayList<String> actiuniRecomandate = new ArrayList<String>();

		for (int i = 1; i < db.getStockValues().size(); i++) {
			int lungime = db.getStockValues().get(i).split(",").length;

			double sma5 = 0;
			for (int j = lungime - 1; j >= lungime - 5; j--) {
				sma5 += Double.parseDouble(db.getStockValues().get(i).split(",")[j]);
			}
			sma5 /= 5;

			double sma10 = 0;
			for (int j = lungime - 1; j >= lungime - 10; j--) {
				sma10 += Double.parseDouble(db.getStockValues().get(i).split(",")[j]);
			}
			sma10 /= 10;

			if (sma5 > sma10) {
				actiuniRecomandate.add(db.getStockValues().get(i).split(",")[0]);
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append("{\"stockstobuy\": [");
		for (int i = 0; i < actiuniRecomandate.size(); i++) {
			sb.append("\"" + actiuniRecomandate.get(i) + "\"");
			if (i != actiuniRecomandate.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append("]}");
		System.out.println(sb);
	}
}
