package demo.utils;

import demo.entity.Boy;

import java.util.ArrayList;
import java.util.List;

public class BoyUtils {
    public static List<Boy> makeData() {
        List<Boy> listBoy = new ArrayList<>();
        Boy boy;
        for (int i = 1; i <= 10; i++) {
            boy = new Boy(i, "Dung", i, "Ha Noi" + i, i, 1F, "Music", "Black", "none");
            listBoy.add(boy);
        }
        return listBoy;
    }
}
