import java.util.LinkedList;
import java.util.Scanner;

public class EmployeeManagementSystem { // define the EmployeeManagementSystem class
    private LinkedList<Employee> employees; // import the Scanner class for user input

    public EmployeeManagementSystem() { // constructor to initialize the EmployeeManagementSystem object
        employees = new LinkedList<Employee>(); // iterate through the employee list
    }
    public void addEmployee(Employee e) { // method to add employee to the list
        for (Employee emp : employees) { // iterate through the employee list
            if (emp.getEmployeeID() == e.getEmployeeID()) { // check if an employee already has inputted id
                System.out.println("Employee with this ID already exists"); // prints a message stating that the id already exists
                return; // exits the method
            }
        }
        employees.add(e); // adds the new employee to the list
        System.out.println("Employee added successfully"); // message confirming employee was added
    }
    public void removeEmployee(int id) { // method to remove employee to the list
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
    public static void main(String[] args) { // main method to run the EMS
        EmployeeManagementSystem ems = new EmployeeManagementSystem(); // create an instance of EMS
        Scanner scanner = new Scanner(System.in); // create a scanner object for user input

        while (true) { // infinite loop to keep the program running
            System.out.println("1. Add a New Employee"); // menu option 1
            System.out.println("2. Remove an Employee"); // menu option 2
            System.out.println("3. View All Employees"); // menu option 3
            System.out.println("4. Exit"); // menu option 4
            System.out.print("Enter Your Choice: "); // prompts the user to enter their choice
            int choice = scanner.nextInt(); // read the users choice
            switch (choice) { // switch statement to handle user choice
                case 1: // if the user selects 1
                    System.out.println("Enter employee ID: "); // primpts user to enter id
                    int id = scanner.nextInt(); // read employee id
                    scanner.nextLine(); // consume new line
                    System.out.println("Enter employee name: "); // prompts the user to enter name
                    String name = scanner.nextLine(); // read the name
                    System.out.println("Enter employee salary: "); // prompts user to enter salary
                    double salary = scanner.nextDouble(); // read salary
                    if (salary < 0) { // check if salary is negative
                        System.out.println("Salary cannot be negative. Please try again"); // prints message stating salary cannot be negative
                        break; // exits the switch statement
                    }
                    scanner.nextLine(); // consume new line
                    System.out.println("Enter employee position: "); // prompts user to enter position
                    String position = scanner.nextLine(); // read position
                    Employee e = new Employee(id, name, salary, position); // create new employee object
                    ems.addEmployee(e); // add the employee to the system
                    break; // exit statement
                case 2: // if user chooses 2
                    System.out.println("Enter employee ID to remove: "); // prompts user to enter id they want to delete
                    int removeID = scanner.nextInt(); // read the id
                    ems.removeEmployee(removeID); // removes employee from system
                    break; // exit statement
                case 3: // if user chooses 3
                    ems.viewAllEmployees(); // view all employees in the system
                    break; // exit statement
                case 4: // if user chooses 4
                    System.out.println("Exiting the program"); // prints exit message
                    scanner.close(); // closes scanner
                    return; // exits program
                default: // if user input is invalid
                    System.out.println("Invalid choice. Please try again"); // error message
            }
        }
    }
}