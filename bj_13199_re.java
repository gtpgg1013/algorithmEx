package algorithmEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_13199_re {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		while (T-- > 0) {
			st = new StringTokenizer(bf.readLine());
			int price = Integer.parseInt(st.nextToken());
			int money = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			int get = Integer.parseInt(st.nextToken());
			int s_cnt = money / price + (money / price * get / target);
			int c_cnt = money / price;
			int c_coupon = c_cnt * get;
				while (c_coupon >= target) {
				int cnt = 0;
				cnt = c_coupon / target;
				c_cnt += cnt;
				cnt *= get;
				cnt += c_coupon % target;
				c_coupon = cnt;
				}
			System.out.println(c_cnt - s_cnt);
		}
	}
}
