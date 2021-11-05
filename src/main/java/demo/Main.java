package demo;

import java.io.IOException;
import java.util.List;

public class Main {


        public static void main(String[] args) throws IOException {
            Excel excel= new Excel();

//        Boy tmp= new Boy();
//
//        List<Boy> listBoy= tmp.getBoys();
//
//            String[] titles= excel.getTittles("D:/Demo/test.xlsx");
//           System.out.print(Arrays.toString(titles));
//            excel.writeData(titles,listBoy);
//
//            excel.readData("D:/Demo/JavaBooks.xlsx");

            Json test= new Json();
            List<Boy> boyList= test.parseFile();
            for (int i = 0; i < boyList.size(); i++) {
                Boy boy= boyList.get(i);
                System.out.printf("%s %s", boy.getId(), boy.getName()+"\n");
            }
        }
}
