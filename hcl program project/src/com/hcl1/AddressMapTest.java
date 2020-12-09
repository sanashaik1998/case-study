package com.hcl1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressMapTest {

	public static void add(Map<String, Map<String, List<AddressMap>>> stateMap, AddressMap ad) {
		String state = ad.getState();
		String city = ad.getCity();
		List<AddressMap> li = new ArrayList<>();
		li.add(ad);

		Map<String, List<AddressMap>> cityMap = new HashMap<String, List<AddressMap>>();
		cityMap.put(city, li);

		if (stateMap.containsKey(state)) {

			if (stateMap.get(state).containsKey(city)) {
				stateMap.get(state).get(city).add(ad);
			} else
				stateMap.get(state).put(city, li);
		} else
			stateMap.put(state, cityMap);

	}

	private static void search(Map<String, Map<String, List<AddressMap>>> stateMap, String state, String city) {
		if (stateMap.containsKey(state)) {
			// for(AddressMap e:stateMap.get(state).get(city))
			// System.out.println(e);
			// Map<String, List<AddressMap>> cityMap = stateMap.get(state);
			// System.out.println(cityMap.keySet());
			if (stateMap.get(state).containsKey(city)) {
				for (AddressMap m : stateMap.get(state).get(city)) {
					System.out.println(m);
				}
			} else {
				System.out.println("Searched City not found");
			}
		} else {
			System.out.println("Searched State not found");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Map<String, Map<String, List<AddressMap>>> map = new HashMap<>();
		System.out.println("Enter the number of address");
		int noOfAddress = in.nextInt();
		in.nextLine();
		for (int i = 1; i <= noOfAddress; i++) {
			System.out.println("Enter the address" + i + " details");
			String[] s = in.nextLine().split(",");
			String add1 = s[0];
			String add2 = s[1];
			String city = s[2];
			String state = s[3];
			Integer pinCode = Integer.parseInt(s[4]);
			// List<AddressMap> li = new ArrayList<AddressMap>();
			// li.add();

			// Map<String, List<AddressMap>> cityMap = new
			// HashMap<String,List<AddressMap>>();

			// cityMap.put(city, li);
			add(map, new AddressMap(add1, add2, city, state, pinCode));
		}
		System.out.println("Enter the state to be searched");
		String searchState = in.nextLine();
		System.out.println("Enter the city to be searched");
		String searchCity = in.nextLine();
		// System.out.println("++++"+searchCity);
		System.out.printf("%-15s %-15s %-15s %-15s %s\n", "Line1", "Line2", "City", "State", "Pincode");

		search(map, searchState, searchCity);

		/*
		 * for (String state : map.keySet()) { Map<String, List<AddressMap>> m1 =
		 * map.get(state);
		 * 
		 * for (String city : m1.keySet()) { List<AddressMap> l = m1.get(city); for
		 * (AddressMap s : l) System.out.println(s); } }
		 */

		in.close();
	}
}

