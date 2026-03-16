
import java.util.*;
class search{

    void bubblesort(int arrs[]){
        for (int i = 0 ;i < 5; i++)
            if (arrs[i] < arrs[i+1]){
            temp = arrs[i+1]; 
            arrs[i+1] = arrs[i];
            temp = arrs[i];
        System.out.println(arrs[i]+","+arrs[i+1]);    
        } 
            else{
                System.out.println(arrs[i] + ">" + arrs[i+1] );
            }
        }


    }

}

public class Searching_Techniques {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new[5] int;
        int temp;
        for (int i = 0; i < 5; i++) {
        int arr[i] = sc.nextLine();    
        }
        search obj = new search;
        obj.bubblesort(arr[i]);

    }
    
}
