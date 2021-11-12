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

            Excel excel = new Excel();
            String[] titles= new String[0];

            try {
                titles = excel.getTittles("boy_management.xlsx");
            } catch (Exception e) {
                e.printStackTrace();
            }

            BoyUtils boyUtils =new BoyUtils();
            List<Boy> data= boyUtils.makeData();

            try {
                excel.writeData(titles,data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
