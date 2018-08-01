package website;

import java.util.ArrayList;
import java.util.List;

public class QueenTest {
	public static int c = 1;
	public static void main(String[] args) {
		queen();
	}
	public static void queen() {
		int n = 8;	//N皇后，N的值
		List<Integer> list = new ArrayList<Integer>();
			int p = 1;	//初始时，从第一行的第一位开始测试
			while(p<=n && (list.size()==0 || list.get(0)<=n)) {
				if(isOk(list,p)) {
					list.add(p);
					if(list.size()==n) {	//如果已经得到一个结果，则打印
						print(list);
						do {	//取最后一行的皇后位置，加1，继续测试，如果最后一行已经是在最后一位，则循环查找上一行
							p = list.get(list.size()-1) +1;
							list.remove(list.size()-1);
						}
						while(p>n && list.size()>0);
					}
					else {
						p=1;	//下一行，从第一位开始测试
					}
				}
				else {
					//isOk == false
					if(p==n) {	//如果这一行已经测试到最后一位仍不能放置皇后
						do {	//回溯
							p=list.get(list.size()-1) +1;
							list.remove(list.size()-1);
						}
						while(p>n && list.size()>0);
					}
					else p++;	//还没有到这一行的最后一位，则往后挪一位
				}
			}
			System.out.println("end");
	}
	public static boolean isOk(List<Integer> list, int num) {
		//list作为一纬数组，第一位数字代表第一行的皇后位置，如此放置，不存在两个皇后同行的情况
		if(list.size()==0) return true;
		else {
			int size = list.size();
			for(int i = 0; i<list.size(); i++) {
				if(num==list.get(i).intValue() || //两个皇后同列
						Math.abs(num-list.get(i).intValue()) == Math.abs(i-size)	//两个皇后在在斜线上
						) {
					return false;
				}
			}
			return true;
		}
	}
	public static void print(List<Integer> list) {
		System.out.print("###"+c+":\t");
		for(int i = 0; i<list.size();i++) {
			System.out.print(list.get(i)+"\t");
		}
		System.out.println("");
		c++;
	}
}
