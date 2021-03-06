package demo.utils;

import demo.entity.Boy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BoyUtils {

    static String[] firstname = new String[]{
            "Đỗ", "Trần", "Bùi", "Chu", "Nguyễn", "Mai", "Lê", "Hoàng", "Lại"
    };
    static String[] lastname = new String[]{
            "Anh", "Bình", "Dương", "Gia", "Hiếu", "Hoàng", "Hưng", "Hữu", "Linh", "Long", "Minh",
            "Nghiên", "Phúc", "Thái", "Tiến", "Trọng", "Tuấn", "Văn", "Đạt"
    };
    static String[] exCity = new String[]{"Hà Nội", "HCM", "An Giang", "Vũng tàu", "Bắc Giang", "Bắc Kạn", "Bạc Liêu",
            "Bến Tre", "Bình Định", "Bình Dương", "Bình Phước", "Bình Thuận", "Cà Mau", "Cần Thơ", "Cao Bằng",
            "Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Bắc Ninh"};
    static String[] hobbit = new String[]{"Game", "Music"};
    static String[] hair = new String[]{"Black", "Grey", "White"};


    public static List<Boy> makeData(int numOfData) {

        List<Boy> listBoy = new ArrayList<>();
        Boy boy;
        Random rand = new Random();
        String name = new String();
        String city = new String();
        for (int i = 1; i <= numOfData; i++) {
            name = firstname[rand.nextInt(firstname.length)];
            name += " " + (lastname[rand.nextInt(lastname.length)]);
            name += " " + (lastname[rand.nextInt(lastname.length)]);
            city = exCity[rand.nextInt(lastname.length)];
            boy = new Boy(i, name, 18 + rand.nextInt(5), city, 160 + rand.nextInt(20), 50F + rand.nextInt(5), hobbit[rand.nextInt(2)], hair[rand.nextInt(3)], "None");
            listBoy.add(boy);
        }
        return listBoy;
    }
}
