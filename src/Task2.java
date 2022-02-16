import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public  static void main(String[] args){

        String line = "";
        List<String > dList = new ArrayList<>();
        List<String > qList = new ArrayList<>();
        List<String > aList = new ArrayList<>();

        int k = 3;
        int l = 100;
        List<Scheme> vdList = new ArrayList<>();
        List<Scheme> vqList = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("universities.txt"));
            do {
                line = br.readLine();
                dList.add(line);
            }while (br.ready());
        br.close();

             br = new BufferedReader(new FileReader("queries.txt"));
            do {
                line = br.readLine();
                qList.add(line);
            }while (br.ready());
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //TODO
        //привести все к нижнему регистру - в словаре и в базе

        //вектора
        for(String d :dList){
            vdList.add(new Scheme(d, k, l));
        }

        for(String q :qList){
            vqList.add(new Scheme(q, k, l));
        }


        double t = 1;
        boolean isT = false;

        for (int i = 0; i < vqList.size(); i++) {
            isT = false;
            t = 1;
            while (!isT) {
                t = t - 0.01;
                for (int j = 0; j < vdList.size(); j++) {
                    if (vqList.get(i).similarTo(vdList.get(j)) > t) {
                        aList.add(dList.get(j));
                        isT = true;
                        break;
                    }
                }
            }

        }

        //вывод
        try {
            FileWriter writer = new FileWriter("answer.txt", true);
            for(String a : aList){
                writer.write(a+"\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(aList.get(0));

    }
}
