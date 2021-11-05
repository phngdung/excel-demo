package demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Json {
    Boy tmp = new Boy();
    List<Boy> boyList = tmp.getBoys();

    Logger logger = Logger.getLogger(this.getClass().getName());

    public void writeJson() throws IOException {
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

        //Write JSON file
        try (FileWriter file = new FileWriter("boy.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(jsonArray.toJSONString());
            file.flush();
        }
    }

    public void objectToJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("boy.json");
        for (int i = 0; i < boyList.size(); i++) {
            Boy boy = new Boy(i, "Dung", i, "" + i, i, 1F, "Music", "Black", "none");
            System.out.print(boy);
            objectMapper.writeValue(file, boy);
        }
    }

    public Boy parseObject(JSONObject jsonObject) {

        Boy boy= new Boy();
        String json = jsonObject.toString();
        ObjectMapper mapper = new ObjectMapper();
        try {
             boy = mapper.readValue(json, Boy.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return boy;
    }

    public List<Boy> parseFile() {
        List<Boy> list= new ArrayList<>();
        JSONParser parser = new JSONParser();
        JSONArray arr;
        {
            try {
                arr = (JSONArray) parser.parse(new FileReader("boy.json"));
                for (Object obj : arr) {
                    JSONObject person = (JSONObject) obj;
                    list.add(parseObject(person));
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
        return  list;
    }


}