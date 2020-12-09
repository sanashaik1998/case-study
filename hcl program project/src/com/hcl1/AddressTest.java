package com.hcl1;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;
	import java.util.Scanner;

	public class AddressTest {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner in = new Scanner(System.in);
			List<Address> addressList = new ArrayList<>();
			System.out.println("Enter the number of users");
			int noOfUsers = in.nextInt();
			in.nextLine();
			System.out.println("Enter user address in CSV(Username,AddressLine 1,AddressLine 2,PinCode)");
			for (int i = 1; i <= noOfUsers; i++) {
				String s[] = in.nextLine().split(",");
				addressList.add(new Address(s[0], s[1], s[2], Integer.parseInt(s[3])));
			}
			Collections.sort(addressList);
			System.out.println("User Details :");
			for (Address a : addressList)
				System.out.println(a);
			in.close();
		}
	}

