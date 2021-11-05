package demo.entity;

public class Boy {
    private Integer id;
    private String name;
    private Integer age;
    private String city;
    private Integer height;
    private Float weight;
    private String hobbit;
    private String hairColor;
    private String skill;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getHobbit() {
        return hobbit;
    }

    public void setHobbit(String hobbit) {
        this.hobbit = hobbit;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Boy(Integer id, String name, Integer age, String city, Integer height, Float weight, String hobbit, String hairColor, String skill) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
        this.height = height;
        this.weight = weight;
        this.hobbit = hobbit;
        this.hairColor = hairColor;
        this.skill = skill;
    }

    public Boy() {
    };

}
