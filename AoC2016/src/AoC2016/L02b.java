package AoC2016;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class L02b {
	private static List<String> route;

	public static void run(String ext) {
		try {
			route = Files.readAllLines(Paths.get("./src/AoC2016/L02input" + ext + ".txt")).stream().map(String::valueOf)
					.collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println("Knas med filimport: " + e);
		}
		// 123
		// 456
		// 789
		String s = "5";
		String code = "";
		for (int a = 0; a < route.size(); a++) {
			String r = route.get(a);
			for (int b = 0; b < r.length(); b++) {
				s = getNumber(s, r.substring(b, b + 1));
			}
			code += s;
		}
		System.out.println("Bathroom code: " + code);
	}

	public static String getNumber(String startNumber, String direction) {
		switch (direction) {
		case "R":
			switch (startNumber) {
			case "5":
				return "6";
			case "6":
				return "7";
			case "7":
				return "8";
			case "8":
				return "9";
			case "2":
				return "3";
			case "3":
				return "4";
			case "A":
				return "B";
			case "B":
				return "C";
			default:
				return startNumber;
			}
		case "L":
			switch (startNumber) {
			case "4":
				return "3";
			case "3":
				return "2";
			case "9":
				return "8";
			case "8":
				return "7";
			case "7":
				return "6";
			case "6":
				return "5";
			case "C":
				return "B";
			case "B":
				return "A";
			default:
				return startNumber;
			}
		case "U":
			switch (startNumber) {
			case "A":
				return "6";
			case "6":
				return "2";
			case "D":
				return "B";
			case "B":
				return "7";
			case "7":
				return "3";
			case "3":
				return "1";
			case "C":
				return "8";
			case "8":
				return "4";
			default:
				return startNumber;
			}
		case "D":
			switch (startNumber) {
			case "2":
				return "6";
			case "6":
				return "A";
			case "1":
				return "3";
			case "3":
				return "7";
			case "7":
				return "B";
			case "B":
				return "D";
			case "4":
				return "8";
			case "8":
				return "C";
			default:
				return startNumber;
			}
		}
		return "$";
	}
}
