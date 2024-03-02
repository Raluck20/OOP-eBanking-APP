package org.poo.cb;

public class ListUserCommand implements Command {
	public void execute() {
		DB db = DB.getInstance();

		for (User u : db.getUsers()) {
			if (u.getEmail().equals(db.getArgumente().get(0))) {
				StringBuilder sb = new StringBuilder();
				sb.append("{\"email\":\"");
				sb.append(u.getEmail());
				sb.append("\",\"firstname\":\"");
				sb.append(u.getNume());
				sb.append("\",\"lastname\":\"");
				sb.append(u.getPrenume());
				sb.append("\",\"address\":\"");
				sb.append(u.getAdresa());
				sb.append("\",\"friends\":[");
				for (int i = 0; i < u.getListaPrieteni().size(); i++) {
					sb.append("\"");
					sb.append(u.getListaPrieteni().get(i));
					sb.append("\"");
					if (i != u.getListaPrieteni().size() - 1) {
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
