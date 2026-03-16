import java.util.*;

class Search {

    void bubblesort(int arr[]) {
        int temp;

        for (int i = 0; i < 5; i++) {
            if (arr[i] > arr[i + 1]) {

                temp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = temp;
            
                System.out.println(arr[0]+","+arr[1]+","+arr[2]+","+arr[3]+","+arr[4]);
        
             }
            else {
                //System.out.println(arr[i] + " < " + arr[i + 1]);
            }
        }
        
    }

}

public class Searching_Techniques {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int arr[] = new int[5];

        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }
       System.out.println(arr[0]+","+arr[1]+","+arr[2]+","+arr[3]+","+arr[4]);
        Search obj = new Search();
        obj.bubblesort(arr);
    }
}