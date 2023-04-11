import service.EmployeeDAO;
import service.EmployeeDAOImpl;
import tableClass.Employee;

public class Application {

    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

// Получение всего списка из таблицы "employee";
        employeeDAO.getAllEmployee();

// Доюавление в таблицу "employee" новой строки;
        employeeDAO.addToTableEmployee(new Employee("Юлия", "Шевченко", "жен.", 18, 3));

// Удаление строки по Id;
        employeeDAO.delOneMemberEmployee(21);

// Изменение данных в строке по Id;
        employeeDAO.updateMemberEmmployee(20, new Employee("Евгения", "Романова", "жен.", 16, 4));

    }
}
