package D4;
import java.util.Arrays;
import java.util.Scanner;

public class 대규의팬덤활동 {
	public static final int MOD = 1000000000;
	public static long[][][] dp;
	
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int tcNum = in.nextInt();
		for (int tc = 1; tc <= tcNum; tc++) {
		    int n = in.nextInt();
		    dp = new long[n + 1][10][1 << 11];
		    long r = 0;
		    for (int i = 0; i < n + 1; i++) {
		        for (int j = 0; j < 10; j++)
		            Arrays.fill(dp[i][j], -1);
		    }
		
		    for (int idx = 1; idx < 10; idx++) {
		        r = (r + recursive(n, idx, 0)) % MOD;
		    }
		    System.out.println("#" + tc + " " + r);
		}
	}
	
	public static long recursive(int position, int idx, int state) {
		if (idx < 0 || idx > 9)
		    return 0;
		if (position == 1) {
		    if ((state | (1 << idx)) == ((1 << 10) - 1))
		        return 1;
		    else
		        return 0;
		}
		if (dp[position][idx][state] != -1)
		    return dp[position][idx][state];
		state |= (1 << idx);
		dp[position][idx][state] = (recursive(position - 1, idx + 1, state)
				+ recursive(position - 1, idx - 1, state)) % MOD;
		return dp[position][idx][state];
	}
}