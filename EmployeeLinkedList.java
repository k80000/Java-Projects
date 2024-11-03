import java.util.LinkedList;


public class EmployeeLinkedList { // defines EmployeeLinkedList class
    private LinkedList<Employee> employees; // stores list of employee objects

    public EmployeeLinkedList() { // constructor to initialize the EmployeeLinkedList object
        employees = new LinkedList<>(); // initializes the employee list as a new linkedlist
    }
    public void addEmployee(Employee e) { // method to add an employee
        for (Employee emp : employees) { // goes through the employee list
            if (emp.getEmployeeID() == e.getEmployeeID()) { // checks if an employee with the same id exists
                System.out.println("Employee with this ID already exists"); // prints a message informing that the id already exists
                return; // exits the method
            }
        }
        employees.add(e); // adds the new employee to the list
        System.out.println("Employee added successfully"); // prints a message confirming the employee was added
    }
    public void removeEmployee(int id) { // method to remove an employee from the list
        boolean removed = employees.removeIf(emp -> emp.getEmployeeID() == id); // removes the employee with the matching id
        if (removed) { // checks if employee was removed
            System.out.println("Employee removed successfully"); // prints a message confirming that employee was removed
        } else { // if the employee was not found
            System.out.println("Employee not found"); // prints a message informing that the employee was not found
        }
    }
    public void viewAllEmployees() { // method to view all employees
        if (employees.isEmpty()) { // checks if the list is empty
            System.out.println("There are no employees to view"); // prints a message informing there are no employees in the list
        } else { // if there are employees in the list
            for (Employee e : employees) { // iterate through the employee list
                System.out.println(e); // prints the details of each employee
            }
        }
    }
}
