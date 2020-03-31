package vidi.demo.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: leetCode
 * @description: Letter Tile Possibilities
 * You have a set of tiles, where each tile has one letter tiles[i] printed on it.  Return the number of possible non-empty sequences of letters you can make.
 * @author: Vidi
 * @create: 2020-03-23 10:09
 **/
public class SolutionNo1079 {
	public int possibilities = -1;
	public int numTilePossibilities(String tiles) {
		Map<Character, Integer> map = new HashMap<>();
		for (char tile : tiles.toCharArray()) {
			map.put(tile, map.getOrDefault(tile, 0) + 1);
		}
		gen(map.values().toArray(new Integer[map.size()]));
		return possibilities;
	}

	private void gen(Integer[] freq) {
		possibilities += 1;
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] > 0) {
				freq[i] -= 1;
				gen(freq);
				freq[i] += 1;
			}
		}
	}

	public static void main(String[] args) {
		SolutionNo1079 s =new SolutionNo1079();
		System.out.println(s.numTilePossibilities("AAB"));
	}
}
