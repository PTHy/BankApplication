import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("---------------------------------");
			System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
			System.out.println("---------------------------------");
			System.out.println("선택>");

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
		System.out.println("프로그램 종료");
	}

	// 계좌 생성
	private static void createAccount() {
		int balance;
		String ano, owner;
		System.out.println("-----------");
		System.out.println("계좌생성");
		System.out.println("-----------");
		System.out.print("계좌 번호: ");
		ano = sc.next();
		System.out.print("계좌주: ");
		owner = sc.next();
		System.out.print("초기입급금액: ");
		balance = sc.nextInt();
		Account newAc = new Account(ano, owner, balance);

		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				accountArray[i] = newAc;
				return;
			}
		}
		System.out.println("계좌가 생성되었습니다.");
	}

	// 계좌 목록
	private static void accountList() {
		System.out.println("-----------");
		System.out.println("계좌목록");
		System.out.println("-----------");

		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] != null) {
				System.out.println(accountArray[i].getAno() + " " + accountArray[i].getOwner() + " "
						+ accountArray[i].getBalance());
			}
		}
	}

	// 예금하기
	private static void deposit() {
		String ano;
		int balance;
		Account ac;
		System.out.println("-----------");
		System.out.println("예금");
		System.out.println("-----------");

		System.out.print("계좌 번호: ");
		ano = sc.next();
		System.out.println("예금액 : ");
		balance = sc.nextInt();
		
		ac = findAccount(ano);
		
		if (ac != null) {
			balance += ac.getBalance();
			ac.setBalance(balance);
			System.out.println("입금이 성공되었습니다.");
			return;
		} else {
			System.out.println("계좌를 찾을 수 없습니다.");
		}
	}

	// 출금하기
	private static void withdraw() {
		String ano;
		int balance;
		Account ac;
		System.out.println("-----------");
		System.out.println("출금");
		System.out.println("-----------");
		System.out.print("계좌 번호: ");
		ano = sc.next();
		System.out.println("출금액 : ");
		balance = sc.nextInt();

		
		ac = findAccount(ano);
		
		if (ac != null) {
			balance = ac.getBalance() - balance;
			ac.setBalance(balance);
			System.out.println("출금이 성공되었습니다.");
			return;
		} else {
			System.out.println("계좌를 찾을 수 없습니다.");
		}
	}

	// Account배열에서 ano와 동일한 Account 객체 찾기
	private static Account findAccount(String ano) {
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i].getAno().equals(ano)) {
				return accountArray[i];
			}
		}
		return null;
	}
}
