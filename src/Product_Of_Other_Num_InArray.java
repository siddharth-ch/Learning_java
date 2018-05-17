import java.util.Arrays;

public class Product_Of_Other_Num_InArray{
	
	public static void main(String[] args) {
		//input = [2,1,3,4]
		//output=[12,24,8,6]
		
		int [] a = {2,1,3,4};
		int [] out = new int[a.length];
		int temp = 1,temp2=1;
		int [] fr = new int[a.length];
		int re [] = new int[a.length];
		re[0]=1;
		fr[a.length-1]= 1;
		for(int i=0;i<a.length;i++){
			//System.out.println(a[i]);
			temp=1;
			for(int j=a.length-1;j>i;j--){
				temp=temp*a[j];
			}
			fr[i] = temp;
			if(i!=0){
			temp2=temp2*a[i-1];
			re[i]=temp2;
			System.out.println(i+" "+temp2+" ");
			}
			
		}
		for(int x=0;x<a.length;x++){
			out [x]=re[x]*fr[x];
		}
		System.out.println(Arrays.toString(out));
	}
}