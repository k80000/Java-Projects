public class Employee { // private fields to store employee details
    private String name; // stores employee name
    private String position; // stores employee position
    private double salary; // stores employee salary
    private int employeeID; // stores employee id

    public Employee(int id, String name, double salary, String position) { // constructor to initialize the employee object with the given details
        this.name = name; // assigns name parameter to name field
        this.position = position; // assigns position parameter to position field
        this.salary = salary; // assigns salary parameter to salary field
        this.employeeID = id; // assigns id parameter to id field
    }
    public String getName() { // getter method to retrieve employee name
        return name; // returns name
    }
    public String getPosition() { // getter method to retrieve employee position
        return position; // returns position
    }
    public double getSalary() { // getter method to retrieve employee salary
        return salary; // returns salary
    }
    public int getEmployeeID() { // getter method to retrieve employee id
        return employeeID; // returns id
    }

    @Override // overrides toString method to print out employee object
    public String toString(){
        return "Employee Name: " + name + " Position: " + position + " Salary: $" + salary + " Employee ID: " + employeeID; // returns employee details
    }
}
