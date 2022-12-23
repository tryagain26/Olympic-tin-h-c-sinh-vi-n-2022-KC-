import java.util.Arrays;
import java.util.Scanner;
public class CuaHangNangLuong {
    public static int findL(int arr[], int x, int n){
        int l = 0, r= n-1;
        while(l < r){
            int m = l + (r-l)/2;
            if(arr[m] >= x){
                r = m;
            }else{
                l = m+1;
            }
        }

        return l;
    }
    public static int findR(int arr[], int x, int n){
        int l= 0, r= n-1;
        while(l < r){
            int m = l + (r-l+1)/2;
            if(arr[m] >x){
                r = m-1;
            }else{
                l = m;
            }
        }

        return l;
    }

   /* public static boolean ok(int n){

        double tmp = Math.log10(n)/Math.log10(2);
        if(tmp  == (int)(tmp)) {
            return true;
        }
        return false;
    }

    public static boolean ok1(int n){
        double tmp = Math.log10(n)/Math.log10(3);
        if(tmp == (int)(tmp) ) {
            return true;
        }
        return false;
    }
    public static boolean ok2(int n){
        double tmp = Math.log10(n)/Math.log10(5);
        if(tmp == (int)(tmp)) {
            return true;
        }
        return false;
    }*/
   public static boolean ok(int n){
       if  (n == 0){
           return false;
       }

       long two = 1073741824;
       return two%(long)n == 0;
   }

    public static boolean ok1(int n){
        if  (n == 0){
            return false;
        }
        long three = 1162261467;
        return three%(long)n == 0;

    }
    public static boolean ok2(int n){
        if  (n == 0){
            return false;
        }
        long five = 1220703125;
        return five%(long)n == 0;

    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n+10];
        int[] pre = new int[n+10];
        for(int i  = 0; i<n ; i++){
            arr[i] = sc.nextInt();
        }
        //int[] tmp = new int[n+10];
        Arrays.sort(arr, 0, n);

        for(int i = 0; i < n; i++){
            if((ok(arr[i]) || ok1(arr[i]) || ok2(arr[i]))){
                pre[i+1] = pre[i] + 1;
            }else{
                pre[i+1] = pre[i];
            }
        }

        while(q-->0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            int s = findL(arr, l, n);
            int e = findR(arr, r, n);

            //System.out.println(s + " " + e);
            System.out.println(pre[e + 1] - pre[s]);


        }





    }
}
