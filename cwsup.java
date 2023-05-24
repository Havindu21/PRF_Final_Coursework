import java.util.*;
class Example{ 
	public static void sort(int[] a){
		for(int k=a.length-1;k>0;k--){
			for(int i=0;i<a.length-1;i++){
				if(a[i]>a[i+1]){
					int t=a[i];
					a[i]=a[i+1];
					a[i+1]=t;
				}
			}
		}
	}
	public static void main(String args[]){ 
		int[] a={45,12,27,89,61,72,41,40,69,10};
		System.out.println(Arrays.toString(a));//[45,12,27,89,61,72,41,40,69,10]
		sort(a);
		System.out.println(Arrays.toString(a));//[10,12,27,40,41,45,61,69,72,89]
	} 
}
