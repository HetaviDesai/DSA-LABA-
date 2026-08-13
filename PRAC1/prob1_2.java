import java.util.*;
public class prob1_2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n,i,j;
        int count=0;
        int alreadyPrinted=0,foundDuplicate=0;
        n = sc.nextInt();
        int[] arr = new int[n];
        for(i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        for(i=0;i<n;i++){
            for(j=0;j<i;j++){
                if(arr[i]==arr[j]){
                     alreadyPrinted=1;
                     break;
                }  
                }
                if(alreadyPrinted==1){
                    continue;
                }
                for(j=0;j<n;j++){
                    if(arr[i]==arr[j]){
                        count++;
                    }
                }
                if(count>1){
                    System.out.println(arr[i]+" ");
                    foundDuplicate=1;
                }
                if(foundDuplicate==0){
                    System.out.println("No duplicates found");
                }
            }
            sc.close();
        }
    }

