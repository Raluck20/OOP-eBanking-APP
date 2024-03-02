package org.poo.cb;

public class ListPortfolioCommand implements Command {
	public void execute() {
		DB db = DB.getInstance();

		for (User u : db.getUsers()) {
			if (u.getEmail().equals(db.getArgumente().get(0))) {
				StringBuilder sb = new StringBuilder();
				sb.append("{\"stocks\":[");
				for (int i = 0; i < u.getListaActiuni().size(); i++) {
					sb.append("{\"stockName\":\"");
					sb.append(u.getListaActiuni().get(i).getNumeCompanie());
					sb.append("\",\"amount\":");
					sb.append(u.getListaActiuni().get(i).getNumarActiuni());
					sb.append("}");
					if (i != u.getListaActiuni().size() - 1) {
						sb.append(",");
					}
				}
				sb.append("],\"accounts\":[");
				for (int i = 0; i < u.getListaConturi().size(); i++) {
					sb.append("{\"currencyName\":\"");
					sb.append(u.getListaConturi().get(i).getTipValuta());
					sb.append("\",\"amount\":\"");
					String suma = String.format("%.2f", u.getListaConturi().get(i).getSuma());
					sb.append(suma);
					sb.append("\"}");
					if (i != u.getListaConturi().size() - 1) {
						sb.append(",");
					}
				}
				sb.append("]}");
				System.out.println(sb);
				return;
			}
		}

		throw new RuntimeException("User with " + db.getArgumente().get(0) + " doesn't exist");
	}
}
