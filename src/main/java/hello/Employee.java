package hello;

public class Employee {

    private String id;
    private String name;

    private Double salary;
    private Double bonus;

    private Integer timeWork;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Integer getTimeWork() {
        return timeWork;
    }

    public void setTimeWork(Integer timeWork) {
        this.timeWork = timeWork;
    }

    public Employee(String id, String name, Double salary, int timeWork, Double bonus) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.timeWork = timeWork;
        this.bonus = bonus;
    }

}
