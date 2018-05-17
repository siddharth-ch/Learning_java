import java.util.Scanner;

public class DeleteIt {
	public static void main(String t[]) {
		Scanner sc = new Scanner(System.in);
		String[] str = new String[3];
		for (int i = 0; i < 3; i++) {
			str[i] = sc.nextLine();
		}
		int i = Integer.parseInt(str[1]);
		int j = Integer.parseInt(str[2]);
		String[] sg = str[0].split(" ");
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[sg.length];
		for (int m = 0; m < sg.length; m++) {
			arr[m] = Integer.parseInt(sg[m]);
		}
		int arr2[] = new int[arr.length];
		int x = 0;
		for (int k = 0; k < arr.length; k++) {

			if (x == i) {
				x = 0;
				int l = 1, k2 = 0;
				for (k2 = k; l < j; k2++) {
					l++;
				}
				k = k2;
			} else {
				sb.append(arr[k] + " ");
				x++;
			}

		}
		System.out.println(sb.toString());
	}
}
