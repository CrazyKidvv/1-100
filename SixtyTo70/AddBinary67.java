package SixtyTo70;

public class AddBinary67 {
	public static void main(String[] args) {
		String a = "11";
		String b = "1";
		System.out.println(addBinary(a,b));
	}
	public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int add = 0;
        while(i >= 0 || j >= 0) {
        	int sum = add;
        //	int qwe = a.charAt(i) - '0'; 字符串第i个字符的十进制值
        //	char aq = a.charAt(i);
        	if(i >= 0) sum = sum + a.charAt(i) - '0';//字符串第i个字符的十进制值 + sum
        	if(j >= 0) sum += b.charAt(j) - '0';
        	sb.append(sum % 2);
        	add = sum / 2;
        	i--;
        	j--;
        }
        if(add == 1) {
        	sb.append(1);
        }
        return sb.reverse().toString();//方法返回的是string类型，stringbuilder不是string类型
    }
}
