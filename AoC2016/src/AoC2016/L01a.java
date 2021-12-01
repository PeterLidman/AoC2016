package AoC2016;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class L01a {
	private static String directions;

	public static void run(String ext) {
		try {
			directions = Files.readString(Paths.get("./src/AoC2016/L01input" + ext + ".txt"));
		} catch (IOException e) {
			System.out.println("Fel vid import: " + e);
		}
		// directions = "R5, L5, R5, R3";
		enum orientation {
			n, w, s, e;
		}
		orientation co = orientation.n;
		int north = 0, west = 0;
		for (String a : directions.split(", ")) {
			if (a.charAt(0) == 'R') {
				switch (co) {
				case e:
					co = orientation.n;
					break;
				case n:
					co = orientation.w;
					break;
				case s:
					co = orientation.e;
					break;
				case w:
					co = orientation.s;
					break;
				default:
					break;
				}
//				System.out.println("r");
			} else {
				switch (co) {
				case e:
					co = orientation.s;
					break;
				case n:
					co = orientation.e;
					break;
				case s:
					co = orientation.w;
					break;
				case w:
					co = orientation.n;
					break;
				default:
					break;
				}
//				System.out.println("l");
			}
			Integer v = Integer.valueOf(a.substring(1));
//			System.out.println(a + " pekar " + co + " value " + v);
			switch (co) {
			case e:
				west -= v;
				break;
			case n:
				north += v;
				break;
			case s:
				north -= v;
				break;
			case w:
				west += v;
				break;
			default:
				break;
			}
		}
		System.out.println("Manhattanavstånd " + (Math.abs(north) + Math.abs(west)));
	}

}
