package demo.controller;

import demo.entity.Boy;
import demo.utils.BoyUtils;
import demo.utils.Excel;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {

        {
            Scanner sc = new Scanner(System.in);

            boolean exit = false;

            Excel excel = new Excel();

            do {
                System.out.println("1.Create Excel file");
                System.out.println("2.Read Excel file");
                System.out.println("3.Create Json File");
                System.out.println("4.Write from json to excel file");
                System.out.println("5.exit");
                System.out.println("choose one!");
                Scanner sd = new Scanner(System.in);
                System.out.println("enter your choice");
                int num = sd.nextInt();
                switch (num) {
                    case 1:
                        System.out.println("1.Create Excel file");
                        System.out.println("\n");

                        List<Boy> listBoy = BoyUtils.makeData();
                        String[] titles = excel.getTittles("D:/Demo/test.xlsx");
                        excel.writeData(titles, listBoy);

                        break;

                    case 2:
                        System.out.println("2.Read Excel file");
                        System.out.println("\n");

                        excel.readData("D:/Demo/JavaBooks.xlsx");

                        break;

                    case 3:
                        System.out.println("3.Create Json File");
                        System.out.println("\n");

//                        Json.writeJson();
                        break;

                    case 4:
                        System.out.println("4.Write from json to excel file");
                        System.out.println("//TODO");
                        System.out.println("\n");

//                        Json test = new Json();
//                        List<Boy> boyList = test.parseFile();
//                        for (int i = 0; i < boyList.size(); i++) {
//                            Boy boy = boyList.get(i);
//                            System.out.printf("%s %s", boy.getId(), boy.getName() + "\n");
//                        }

                        break;

                    case 5:
                        exit = true;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + num);
                }
            } while (!exit);


        }
    }
}
