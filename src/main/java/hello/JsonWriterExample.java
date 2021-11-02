package hello;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;


public class JsonWriterExample {

    public static void main(String[] args) throws FileNotFoundException {

        List<Employee> employeeList = createEmployee();

        // Object Builder
        JsonObjectBuilder companyBuilder = Json.createObjectBuilder();

        // Object Builder
        JsonObjectBuilder addressBuilder = Json.createObjectBuilder();

        // Array Builder
        JsonArrayBuilder websitesBuilder = Json.createArrayBuilder();

        for (String website : employeeList.getWebsites()) {
            websitesBuilder.add(website);
        }

        Address address = company.getAddress();
        addressBuilder.add("street", address.getStreet()).add("city", address.getCity() );

        companyBuilder.add("id", company.getId()).add("name", company.getName() );

        companyBuilder.add("websites", websitesBuilder);
        companyBuilder.add("address", addressBuilder);

        JsonObject rootJSONObject = companyBuilder.build();

        System.out.println("Root JsonObject: " + rootJSONObject);

        // Ghi ra file.
        File outFile= new File("D:/demo/company2.txt");
        outFile.getParentFile().mkdirs();

        OutputStream os = new FileOutputStream(outFile);
        JsonWriter jsonWriter = Json.createWriter(os);

        jsonWriter.writeObject(rootJSONObject);
        jsonWriter.close();
    }

    public static List<Employee> createEmployee() {

        List<Employee> list = new ArrayList<Employee>();

        Employee e1 = new Employee("E01", "Tom", 200.0, 1, 1.1);
        Employee e2 = new Employee("E02", "Jerry", 100.2, 2, 2.0);
        Employee e3 = new Employee("E03", "Donald", 150.0, 2, 2.0);
        list.add(e1);
        list.add(e2);
        list.add(e3);
        return list;
    }

}