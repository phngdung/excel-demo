package demo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo.entity.Boy;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Json {

    Logger logger = Logger.getLogger(this.getClass().getName());

    List<Boy> boyList = BoyUtils.makeData(10);

    public void writeJson(String pathname, List<Boy> boyList) throws IOException {
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < boyList.size(); i++) {
            JSONObject boyDetails = new JSONObject();
            Boy boy = boyList.get(i);
            boyDetails.put("id", boy.getId());
            boyDetails.put("name", boy.getName());
            boyDetails.put("age", boy.getAge());
            boyDetails.put("city", boy.getCity());
            boyDetails.put("height", boy.getHeight());
            boyDetails.put("weight", boy.getWeight());
            boyDetails.put("hobbit", boy.getHobbit());
            boyDetails.put("hairColor", boy.getHairColor());
            boyDetails.put("skill", boy.getSkill());
            jsonArray.add(boyDetails);
        }

        File existFile = new File(pathname);
        FileWriter file = new FileWriter(pathname);

        //Write new JSON file
        if (existFile.exists()) {
            file.write(jsonArray.toJSONString());
            file.flush();
        }
        //Append JSON file exists
        else {
            BufferedWriter bw = new BufferedWriter(file);
            bw.write(jsonArray.toJSONString());
            bw.newLine();
            bw.close();
        }

    }

    public void objectToJson(String pathname, Boy boy) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(pathname);
        for (int i = 0; i < boyList.size(); i++) {
            objectMapper.writeValue(file, boy);
        }
    }

    public Boy parseObject(JSONObject jsonObject) {

        Boy boy = new Boy();
        String json = jsonObject.toString();
        ObjectMapper mapper = new ObjectMapper();
        try {
            boy = mapper.readValue(json, Boy.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return boy;
    }

    public List<Boy> parseFile(String pathname) {
        List<Boy> list = new ArrayList<>();
        JSONParser parser = new JSONParser();
        JSONArray arr;
        {
            try {
                arr = (JSONArray) parser.parse(new FileReader(pathname));
                for (Object obj : arr) {
                    JSONObject person = (JSONObject) obj;
                    list.add(parseObject(person));
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
        return list;
    }


}
