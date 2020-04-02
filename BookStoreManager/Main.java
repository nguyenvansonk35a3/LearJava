package collection;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
	List<Book> list = new ArrayList<Book>();

	private static BookStore bookStore = new BookStore();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int choise;
		try {
			do {
				showMenu();
				choise = scanner.nextInt();
				switch (choise) {
				case 1:
					list();
					break;
				case 2:
					add();
					break;
				case 3:
					edit();
					break;
				case 4:
					find();
					break;
				case 5:
					delete();
					break;
				case 6:
					System.out.println("Exit!");
					System.exit(0);
				default:
					break;
				}
				scanner.nextLine();
			} while (true);
		} catch (InputMismatchException e) {
			System.out.println(e.getLocalizedMessage());
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

	private static void delete() {
		bookStore.delete();
	}

	private static void edit() {
		bookStore.edit();
	}

	private static void find() {
		bookStore.find();
	}

	private static void list() {
		bookStore.list();
	}

	private static void add() {
		bookStore.add();
	}

	private static void showMenu() {
		System.out.println("------------BookStoreManager--------------");
		System.out.println("1.List Book:");
		System.out.println("2.Add Book:");
		System.out.println("3.Edit Book:");
		System.out.println("4.Find Book:");
		System.out.println("5.Delete Book:");
		System.out.println("6.Exit!");
		System.out.println("Choise:");
	}

}
