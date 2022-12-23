import java.util.Scanner;
public class NgheThuatTruuTuong {
    public static boolean Up(int a[][], int i, int j){
        int tmp = a[i][j];
        boolean ok = false;
        i--;
        while(i >= 1){
            if(a[i][j] >= tmp){
                return false;
            }
            i--;
        }
        return true;
    }
    public static boolean Down(int a[][], int i, int j, int n){
        int tmp = a[i][j];
        boolean ok = false;
        i++;
        while(i<= n){
            if(a[i][j] >= tmp){
                return false;
            }
            i++;
        }
        return true;
    }
    public static boolean Left(int a[][], int i, int j){
        int tmp = a[i][j];
        boolean ok = false;
        j--;
        while(j >= 1){
            if(a[i][j] >= tmp){
                return false;
            }
            j--;
        }
        return true;

    }
    public static boolean Right(int a[][], int i, int j, int n){
        int tmp = a[i][j];
        boolean ok = false;
        j+=1;
        while(j <= n){
            if(a[i][j] >= tmp){
                return false;
            }
            j+=1;
        }
        return true;

    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n+10][m+10];
        int cnt = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for(int j = 1; j <= m; j++){
            if(arr[1][j]!=0) {
                cnt+=1;
            }
            if(arr[n][j]!=0){
                cnt+=1;
            }

        }

        if(arr[1][1] != 0){
            cnt--;
        }
        if(arr[1][m]!=0){
            cnt--;
        }
        if(arr[n][1]!=0){
            cnt--;
        }
        if(arr[n][m] != 0){
            cnt--;
        }

        if (n <= 2 || m<=2) {
            System.out.print(n * m);
            return;

        }
        for(int i = 1; i <= n; i++){
            if(arr[i][1]!= 0){
                cnt+=1;
            }
            if(arr[i][m] != 0){
                cnt+=1;
            }
        }



        for(int i = 2; i <= n-1; i++){
            for(int j = 2; j <= m-1; j++){
                if(Up(arr, i, j) || Down(arr, i, j, n) || Left(arr, i, j) || Right(arr, i, j, m)){
                    cnt+=1;

                }

            }
        }



        System.out.println(cnt);
    }
}
