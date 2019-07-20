package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/2/25 16:53
 * @Descripton :
 * <p>
 * Available Captures for Rook
 * <p>
 * On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns.
 * These are given as characters 'R', '.', 'B', and 'p' respectively. Uppercase characters represent white pieces, and
 * lowercase characters represent black pieces.
 * <p>
 * The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south),
 * then moves in that direction until it chooses to stop, reaches the edge of the board, or captures an opposite colored
 * pawn by moving to the same square it occupies.  Also, rooks cannot move into the same square as other friendly
 * bishops.
 * <p>
 * Return the number of pawns the rook can capture in one move.
 */
public class SolutionNo999 {
	public static Integer maxCommission(int[] level, int[] commission, int[] worker) {
		int i = 0;
		int maxMoney = 0;
		int count = 0;
		while ((i != worker.length) && count != commission.length) {
			int[] max = findMaxCommission(commission);
			count++;
			while (findSuitableWorker(level[max[1]], worker) != -1) {
				i++;
				maxMoney += max[0];
			}
		}
		return maxMoney;
	}

	public static int[] findMaxCommission(int[] commission) {
		int[] max = new int[]{commission[0], 0};
		for (int i = 0; i < commission.length; i++) {
			if (commission[i] > max[0]) {
				max[0] = commission[i];
				max[1] = i;
			}
		}
		commission[max[1]] = -1;
		return max;
	}

	public static int findSuitableWorker(int level, int[] worker) {
		int index = -1;
		for (int i = 0; i < worker.length; i++) {
			if (worker[i] >= level) {
				if (index == -1) {
					index = i;
				} else {
					if (worker[i] >= worker[index]) {
						index = i;
					}
				}
			}
		}
		if (index >= 0) {
			worker[index] = 0;
		}
		return index;
	}
	public int numRookCaptures(char[][] board) {
		int x=0,y=0,count=0;
		for(int i = 0;i<8;i++){
			for(int j = 0;j<8;j++){
				if(board[i][j]=='R'){x=i;y=j;}
			}
		}

		for(int j = y;j<8;j++){
			if(board[x][j] == 'B')break;
			else if(board[x][j]=='p'){ count++; break;}
		}
		for(int j = y;j>-1;j--){
			if(board[x][j] == 'B')break;
			else if(board[x][j]=='p'){ count++; break;}
		}
		for(int j = x;j<8;j++){
			if(board[j][y] == 'B')break;
			else if(board[j][y]=='p'){ count++; break;}
		}
		for(int j = x;j>-1;j--){
			if(board[j][y] == 'B')break;
			else if(board[j][y]=='p'){ count++; break;}
		}
		return count;
	}

	public static void main(String[] args) {

	}
}
