package newCRUDapp.controller;

import java.sql.SQLException;
import java.util.Scanner;

import dao.loginDAO;
import dao.productdao;
import model.login;
import model.product;


public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("hi".equals("hi"));
		Scanner sc = new Scanner(System.in);
		int choice,option;
		login l=new login();
		loginDAO ld=new loginDAO();
		product p = new product();
		productdao pdao = new productdao();
		do {
			System.out.print("1. Admin\n2. Agent\n3. Exit\n**************************************************************\nEnter your choice: ");
			choice=sc.nextInt();

			switch(choice)
			{
			case 1: System.out.println("Admin Login");
					System.out.println("UserName:");
					String username=sc.next();
				    System.out.println("password:");
					String password=sc.next();
					l.setUsername(username);
					l.setPassword_deatails(password);
					if(ld.checkCredential(l))
					{	System.out.println("Login Successfull\n\n");
						do {
						System.out.println("1. Add product\n2. Display Product\n3. Logout\n4. update\n5. delete\n*********************************************************\nEnter your choice: ");
						option=sc.nextInt();
						switch(option)
						{
						case 1: System.out.println("Enter Productname: ");
								String product=sc.next();
								System.out.println("Enter ProductId: ");
								int id=sc.nextInt();
								System.out.println("Enter Product minimumsellquality: ");
								int minsellq=sc.nextInt();
								System.out.println("Enter Productprice: ");
								int Price=sc.nextInt();
								System.out.println("Enter Productquantity: ");
								int quantity=sc.nextInt();
								p.setProductname(product);
								p.setProductid(id);
								p.setProductprice(Price);
								p.setMinsellquantity(minsellq);
								p.setProductquantity(option);
								pdao.addproduct(p);
								System.out.println("Product added Successfully");
								break;
						case 2: System.out.println("These are the products");
						pdao.display();
								break;
						case 3: break;
						case 4:
							System.out.println("Enter Productname: ");
							String product2=sc.next();
							System.out.println("Enter ProductId: ");
							int id2=sc.nextInt();
							System.out.println("Enter Product minimumsellquality: ");
							int minsellq2=sc.nextInt();
							System.out.println("Enter Productprice: ");
							int Price2=sc.nextInt();
							System.out.println("Enter Productquantity: ");
							int quantity2=sc.nextInt();
							p.setProductname(product2);
							p.setProductid(id2);
							p.setProductprice(Price2);
							p.setMinsellquantity(minsellq2);
							p.setProductquantity(quantity2);
							pdao.update(p);
							System.out.println("elements updated successfully");
							break;
						case 5:
							System.out.println("deleted element");
							System.out.println("enter the id to delete:");
							int id1 = sc.nextInt();
							p.setProductid(id1);
							pdao.delete(p);
							break;
						}
					}while(option!=3);
					}
					else
						System.out.println("\nInvalid username/password");
					break;
			case 2: System.out.println("Agent Login");
					System.out.println("User Name");
					String username1=sc.next();
					System.out.println("Passwrd");
					String password1=sc.next();
					l.setUsername(username1);
					l.setPassword_deatails(password1);
					if(ld.checkCredential(l))
					{
						int ch;
					do {
						System.out.println("1. Display Product\n2.Logout\n");
						 ch=sc.nextInt();
						switch(ch)
						{
						case 1: System.out.println("These are the products");
						           
								break;
						case 2: break;
						}
					}while(ch!=2);
					}
					else
						System.out.println("Invalid username/Password");
					break;
			case 3:System.exit(0);
			}
		}while(choice!=3);
		sc.close();

	}
}
