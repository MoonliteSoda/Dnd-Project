package dice_roll_func;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class DiceRoll {
	//короче, вводите дайсы в формате xdx ydy: 6d6 10d4 (на всякий случай говорю: разделяем дайсы пробелами
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in); 
		System.out.println("started");
		String[] inp = scn.nextLine().split(" ");
		String[] ou = Roll(inp);
		for (String part: ou) {
			System.out.print(part);
		}
		scn.close();
	}

	public static String[] Roll(String[] inp) {
		Random rnd = new Random();
		String[] out = new String[inp.length];
		int i = 0;
		//чтение и интерпритация входных данных
		for (String dice: inp) {
			String outp1="";
			String outp2="";
			int flag = 0;
				for (int j=0; j<dice.length(); j++) {
					if (dice.charAt(j) != 'd') {
						if (flag==0) {
							outp1+=dice.charAt(j);
						}
						else {
							outp2+=dice.charAt(j);
						}
					}
					else {flag=1;}
				}
			int num = Integer.parseInt(outp1);
			int size = Integer.parseInt(outp2);
			out[i]=Integer.toString(size)+":";
			int [] outnum = new int[num];
			//генерация случайных чисел
			for (int j=0; j<num; j++) {
				outnum[j] = rnd.nextInt(size)+1;
			}
			//упаковка
			Arrays.sort(outnum);
			for (int j: outnum) {
				out[i]+=Integer.toString(j)+',';
			}
			i++;
		}
		return out;
	}
}
