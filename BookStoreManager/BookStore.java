package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookStore implements StoreInterface {

	List<Book> list = new ArrayList<Book>();
	static int tutorial = 0;
	static Scanner sc = new Scanner(System.in);
	static Book book;

	@Override
	public void list() {
		System.out.println("list");
		if (checkEmpty()) {
			System.out.println("Empty! Please add new Book in Store!");
		} else {
			for (Book book : list) {
				System.out.println(book.toString());
			}
		}
	}

	@Override
	public void add() {

		if (!checkFull()) {
			System.out.println("add");
			System.out.print("id: ");
			String id = sc.nextLine();
			System.out.print("name: ");
			String name = sc.nextLine();
			System.out.print("price: ");
			double price = sc.nextDouble();

			book = new Book(id, name, price);
			list.add(book);
			tutorial++;

			System.out.println("Them thanh cong!");
		} else {
			System.out.println("Store da full");
		}
		sc.nextLine();
	}

	@Override
	public void edit() {
		System.out.println("edit");
		System.out.print("id: ");
		String id = sc.nextLine();

		if (checkIdEmpty(id)) {
			int index = this.getIndexEmpty(id);
			System.out.print("name: ");
			String name = sc.nextLine();
			System.out.print("double: ");
			double price = sc.nextDouble();

			list.get(index).setName(name);
			list.get(index).setPrice(price);
			System.out.println("Edit thanh cong!");
		} else {
			System.out.println("Id khong ton tai!");
		}
	}

	@Override
	public void find() {
		System.out.println("find");
		System.out.print("id: ");
		String id = sc.nextLine();
		int index;
		if (checkIdEmpty(id)) {
			index = this.getIndexEmpty(id);
			System.out.println(list.get(index).toString());
		} else {
			System.out.println("Id khong ton tai!");
		}
	}

	@Override
	public void delete() {
		System.out.println("delete");
		System.out.print("id: ");
		String id = sc.nextLine();
		int index;
		if (checkIdEmpty(id)) {
			index = this.getIndexEmpty(id);
			list.remove(index);
			System.out.println("Xoa thanh thong");
		} else {
			System.out.println("Id khong ton tai!");
		}
	}

	@Override
	public boolean checkFull() {
		if (tutorial >= 10) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkEmpty() {
		if (tutorial == 0) {
			return true;
		}
		return false;
	}

	public boolean checkIdEmpty(String id) {
		for (int i = 0; i < tutorial; i++) {
			if (list.get(i).getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	public int getIndexEmpty(String id) {
		for (int i = 0; i < tutorial; i++) {
			if (list.get(i).getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
}
