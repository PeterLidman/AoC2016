package AoC2016;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class L01b {
	private static String directions;

	public static void run(String ext) {
		try {
			directions = Files.readString(Paths.get("./src/AoC2016/L01input" + ext + ".txt"));
		} catch (IOException e) {
			System.out.println("Fel vid import: " + e);
		}
		// directions = "R5, L5, R5, R3";
		//directions = "R8, R4, R4, R8";
		enum orientation {
			n, w, s, e;
		}

		HashMap<String, Boolean> myFriend = new HashMap<>();

		orientation co = orientation.n;
		int north = 0, west = 0;
		String pos = "N0W0";
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
				for (int b = west-1; b > west - v; b--) {
					pos="N" + north + "W" + b;
					if(null != myFriend.put(pos, true)) {
						System.out.println("Manhattanavstånd " + (Math.abs(north) + Math.abs(b)));
						System.exit(0);
					}
				}
				west -= v;
				break;
			case n:
				for (int b = north+1; b < north + v; b++) {
					pos="N" + b + "W" + west;
					if(null != myFriend.put(pos, true)) {
						System.out.println("Manhattanavstånd " + (Math.abs(b) + Math.abs(west)));
						System.exit(0);
					}
				}
				north += v;
				break;
			case s:
				for (int b = north-1; b > north - v; b--) {
					pos="N" + b + "W" + west;
					if(null != myFriend.put(pos, true)) {
						System.out.println("Manhattanavstånd " + (Math.abs(b) + Math.abs(west)));
						System.exit(0);
					}
				}
				north -= v;
				break;
			case w:
				for (int b = west+1; b < west + v; b++) {
					pos="N" + north + "W" + b;
					if(null != myFriend.put(pos, true)) {
						System.out.println("Manhattanavstånd " + (Math.abs(north) + Math.abs(b)));
						System.exit(0);
					}
				}
				west += v;
				break;
			default:
				break;
			}
		}	
	}

}
