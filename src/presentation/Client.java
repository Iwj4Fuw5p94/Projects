package presentation;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dao.DeptDaoImp;
import dao.IDeptDao;
import entity.Department;

public class Client {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		IDeptDao dao = new DeptDaoImp();

		boolean flag = true;

		while (flag) {
			System.out.println("****WELCOME DMS ***");
			System.out.println("1. INSERT");
			System.out.println("2. UPDATE");
			System.out.println("3. DELETE");
			System.out.println("4. SELECT BY ID");
			System.out.println("5. SELECT ALL");
			System.out.println("6. EXIT");
			
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				Department dept = readData();
				int count = dao.insert(dept);
				System.out.println(count + " record inserted successfully");
				break;

			case 4:
//				Department dept1=new Department();
//				System.out.println("enter the dno\n");
//				int value=scanner.nextInt();
//				dao.selectOne(value);
				Client client=new Client();
				client.showDate();
			case 5:
			List<Department> list=dao.selectAll();
			list.stream().forEach(System.out::println);
//			Iterator<Department> l=	list.iterator();
//			while(l.hasNext()) {
//				System.out.println(l.next());
//			}
				
				
			case 6:

				flag = false;

				break;

			default:
				break;
			}

		}

	}

	public static Department readData() {

		System.out.println("Enter DNO");

		int dno = scanner.nextInt();

		scanner.nextLine();

		System.out.println("Enter DNAME");

		String dname = scanner.nextLine();

		System.out.println("Enter LOCATION");

		String location = scanner.nextLine();

		Department dept = new Department(dno, dname, location);

		return dept;
	}
	public static Department showDate() {
		Department dept = new Department();
		int dno=scanner.nextInt();
		dept.setDno(dno);
		DeptDaoImp d=new DeptDaoImp();
		d.selectOne(dno);
		return dept;
		
	}

}
