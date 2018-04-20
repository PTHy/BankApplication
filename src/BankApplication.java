import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("---------------------------------");
			System.out.println("1.���»���|2.���¸��|3.����|4.���|5.����");
			System.out.println("---------------------------------");
			System.out.println("����>");

			int selectNo = sc.nextInt();

			if (selectNo == 1) {
				createAccount();
			} else if (selectNo == 2) {
				accountList();
			} else if (selectNo == 3) {
				deposit();
			} else if (selectNo == 4) {
				withdraw();
			} else if (selectNo == 5) {
				run = false;
			}
		}
		System.out.println("���α׷� ����");
	}

	// ���� ����
	private static void createAccount() {
		int balance;
		String ano, owner;
		System.out.println("-----------");
		System.out.println("���»���");
		System.out.println("-----------");
		System.out.print("���� ��ȣ: ");
		ano = sc.next();
		System.out.print("������: ");
		owner = sc.next();
		System.out.print("�ʱ��Աޱݾ�: ");
		balance = sc.nextInt();
		Account newAc = new Account(ano, owner, balance);

		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				accountArray[i] = newAc;
				return;
			}
		}
		System.out.println("���°� �����Ǿ����ϴ�.");
	}

	// ���� ���
	private static void accountList() {
		System.out.println("-----------");
		System.out.println("���¸��");
		System.out.println("-----------");

		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] != null) {
				System.out.println(accountArray[i].getAno() + " " + accountArray[i].getOwner() + " "
						+ accountArray[i].getBalance());
			}
		}
	}

	// �����ϱ�
	private static void deposit() {
		String ano;
		int balance;
		Account ac;
		System.out.println("-----------");
		System.out.println("����");
		System.out.println("-----------");

		System.out.print("���� ��ȣ: ");
		ano = sc.next();
		System.out.println("���ݾ� : ");
		balance = sc.nextInt();
		
		ac = findAccount(ano);
		
		if (ac != null) {
			balance += ac.getBalance();
			ac.setBalance(balance);
			System.out.println("�Ա��� �����Ǿ����ϴ�.");
			return;
		} else {
			System.out.println("���¸� ã�� �� �����ϴ�.");
		}
	}

	// ����ϱ�
	private static void withdraw() {
		String ano;
		int balance;
		Account ac;
		System.out.println("-----------");
		System.out.println("���");
		System.out.println("-----------");
		System.out.print("���� ��ȣ: ");
		ano = sc.next();
		System.out.println("��ݾ� : ");
		balance = sc.nextInt();

		
		ac = findAccount(ano);
		
		if (ac != null) {
			balance = ac.getBalance() - balance;
			ac.setBalance(balance);
			System.out.println("����� �����Ǿ����ϴ�.");
			return;
		} else {
			System.out.println("���¸� ã�� �� �����ϴ�.");
		}
	}

	// Account�迭���� ano�� ������ Account ��ü ã��
	private static Account findAccount(String ano) {
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i].getAno().equals(ano)) {
				return accountArray[i];
			}
		}
		return null;
	}
}
