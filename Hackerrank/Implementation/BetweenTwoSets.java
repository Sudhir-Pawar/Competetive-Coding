import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
        List<Integer> fNo=new ArrayList<Integer>();
         for(int i=0;i<a.size();i++){
                 if(checkFactorial(a.get(i),a, b)){
                     if(!fNo.contains(a.get(i))){
                         fNo.add(a.get(i));
                     }
                 }
                 for(int j=1;j<=100;j++){
                     if(checkFactorial(a.get(i)*j,a, b)){
                         if(!fNo.contains(a.get(i)*j)){
                             fNo.add(a.get(i)*j);
                         }
                     }
                 }
         }
         return fNo.size();
       }
    public static boolean checkFactorial(int a,List<Integer> c,List<Integer> b){
         int flag=0;
         for(int i=0;i<c.size();i++){
             if(a%c.get(i)!=0)
                 return false;
         }
         for(int i=0;i<b.size();i++){
             if(b.get(i)%a!=0)
                 return false;
         }
         return true;
     }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
