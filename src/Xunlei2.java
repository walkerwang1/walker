
import java.util.Scanner;  
  
public class Xunlei2 {  
  
    public static void computeEquation(String equation) {  
        int coefficient = 0;  //系数  
        int constant = 0;   //常数  
        int coefficientSymbol = 1; //系数的符号，=号左边为正  
        int constantSymbol = -1; //常数的符号号，=号左边为负  
        int item = 0;  //方程的数字项  
        int symbol = 1; //系数和常数前的正负号  
        int i = 0;  
        boolean zero = true;  
        char ch;  
        char[] charItem = new char[260];  
  
        for (int index = 0; index < equation.length(); index++) {  
            ch = equation.charAt(index);  
            item = 0;  
  
            //循环取出数字项  
            while (ch >= '0' && '9' >= ch) {  
                item = item * 10 + ch - '0';  
                if (item == 0) zero = false;  
                if (++index < equation.length()) {  
                    ch = equation.charAt(index);  
                } else {  
                    break;  
                }  
            }  
            charItem[i++] = ch;  
            if (i > 1) {  
                //取出系数或者是常数前的正负号  
                symbol = (charItem[i - 2] == '-' ? -1 : 1);  
            }  
            //如果是x，累加x前的系数到coefficient  
            if (ch == 'x') {  
                if (item == 0 && zero) item = 1;  
                coefficient = coefficient + item * coefficientSymbol * symbol;  
            } else {  
                //否则累加常数到constant  
                constant = constant + item * constantSymbol * symbol;  
               //如果当前的字符为=，系数前的符号变成负，常数前的符号变成正  
                if (ch == '=') {  
                    coefficientSymbol = -1;  
                    constantSymbol = 1;  
                }  
            }  
        }  
  
        //输出:系数不为0，输出解;否则系数为0，常数也为0，输出无穷解，否则输出无解  
        if (coefficient != 0) {  
            System.out.println("x=" + (int) Math.floor((float) constant / coefficient));  
        } else {  
            if (constant == 0) {  
                System.out.println("Infinite solutions");  
            } else {  
                System.out.println("No solution");  
            }  
        }  
  
    }  
  
  
    public static void main(String[] args) {  
    	Scanner in = new Scanner(System.in);
    	String line = in.nextLine();
    	computeEquation(line);
    }  
}  
