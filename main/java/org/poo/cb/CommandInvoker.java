package org.poo.cb;

public class CommandInvoker {
	public static void execute(String numeComanda) {
		try {
			if (numeComanda.equals("CREATE USER")) {
				CreateUserCommand createUserCommand = new CreateUserCommand();
				createUserCommand.execute();
			}

			if (numeComanda.equals("ADD FRIEND")) {
				AddFriendCommand addFriendCommand = new AddFriendCommand();
				addFriendCommand.execute();
			}

			if (numeComanda.equals("ADD ACCOUNT")) {
				AddAccountCommand addAccountCommand = new AddAccountCommand();
				addAccountCommand.execute();
			}

			if (numeComanda.equals("ADD MONEY")) {
				AddMoneyCommand addMoneyCommand = new AddMoneyCommand();
				addMoneyCommand.execute();
			}

			if (numeComanda.equals("EXCHANGE MONEY")) {
				ExchangeMoneyCommand exchangeMoneyCommand = new ExchangeMoneyCommand();
				exchangeMoneyCommand.execute();
			}

			if (numeComanda.equals("TRANSFER MONEY")) {
				TransferMoneyCommand transferMoneyCommand = new TransferMoneyCommand();
				transferMoneyCommand.execute();
			}

			if (numeComanda.equals("BUY STOCKS")) {
				BuyStocksCommand buyStocksCommand = new BuyStocksCommand();
				buyStocksCommand.execute();
			}

			if (numeComanda.equals("RECOMMEND STOCKS")) {
				RecommendStocksCommand recommendStocksCommand = new RecommendStocksCommand();
				recommendStocksCommand.execute();
			}

			if (numeComanda.equals("LIST USER")) {
				ListUserCommand listUserCommand = new ListUserCommand();
				listUserCommand.execute();
			}

			if (numeComanda.equals("LIST PORTFOLIO")) {
				ListPortfolioCommand listPortfolioCommand = new ListPortfolioCommand();
				listPortfolioCommand.execute();
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
}
