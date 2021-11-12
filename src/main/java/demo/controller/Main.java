package demo.controller;

import demo.entity.Boy;
import demo.utils.BoyUtils;
import demo.utils.Excel;
import demo.utils.Json;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {

        {

            Scanner sc = new Scanner(System.in);
            Excel excel = new Excel();
            String[] titles = new String[0];
            Json json = new Json();

            /// write excel
            BoyUtils boyUtils = new BoyUtils();
            List<Boy> data = boyUtils.makeData(10);
            try {
                excel.writeData("boy_management.xlsx", "JavaBooks.xlsx", data);
                logger.info("Write excel success");
            } catch (Exception e) {
                e.printStackTrace();
            }

            // read excel
            excel.readData("boy_management.xlsx");

            //write json
            json.writeJson("boy.json", data);

            //read json to excel
            List<Boy> parsedList = json.parseFile("boy.json");

            System.out.print("\nParsing file.. \n");
            System.out.print("Write excel... \n");
            try {
                excel.writeData("boy_management.xlsx", "JavaBooks.xlsx", parsedList);
            } catch (Exception e) {
                e.printStackTrace();
            }
//            excel.readData("boy_management.xlsx");
            //Format style
        }
    }
}
