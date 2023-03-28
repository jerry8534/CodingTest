import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        Map<String, Double> sti = new HashMap<String, Double>();
        sti.put("A+", 4.5);
        sti.put("A0", 4.0);
        sti.put("B+", 3.5);
        sti.put("B0", 3.0);
        sti.put("C+", 2.5);
        sti.put("C0", 2.0);
        sti.put("D+", 1.5);
        sti.put("D0", 1.0);
        sti.put("F", 0.0);
        double sum1 = 0.0;
        double sum2 = 0.0;
        double avg = 0.0;
        for(int i = 1; i < 20; i++){
            st = new StringTokenizer(br.readLine());
            String sub = st.nextToken();
            double val = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            if(!grade.equals("P")){
                sum1 += val * sti.get("grade");
                sum2 += val;
            }
        }
        avg = sum1/sum2;
        System.out.println(avg);
    }
}