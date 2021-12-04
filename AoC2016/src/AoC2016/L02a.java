package AoC2016;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class L02a {
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

		int s = 5;
		String code="";
		for (int a = 0; a < route.size(); a++) {
			String r = route.get(a);
			for (int b = 0; b < r.length(); b++) {
				s = getNumber(s, r.substring(b, b+1));
			}
			code+=s;
		}
		System.out.println("Bathroom code: " + code);
	}

	public static int getNumber(int startNumber, String direction) {
		switch (direction) {
		case "R":
			if (startNumber == 3 || startNumber == 6 || startNumber == 9) {
				return startNumber;
			} else {
				return startNumber + 1;
			}
		case "L":
			if (startNumber == 1 || startNumber == 4 || startNumber == 7) {
				return startNumber;
			} else {
				return startNumber - 1;
			}
		case "U":
			if (startNumber == 1 || startNumber == 2 || startNumber == 3) {
				return startNumber;
			} else {
				return startNumber - 3;
			}
		case "D":
			if (startNumber == 7 || startNumber == 8 || startNumber == 9) {
				return startNumber;
			} else {
				return startNumber + 3;
			}
		}
		return 42;
	}

}