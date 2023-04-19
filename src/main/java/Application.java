import service.CityDAO;
import service.CityDAOImpl;
import tableClass.City;
import tableClass.Employee;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        CityDAO cityDAO = new CityDAOImpl();

// Добавление нового города в таблицу "city";
        City city = new City("Новосибирск");
        List<Employee> employeeList = List.of(new Employee("Тамара", "Орлова", "жен.", 37),
                new Employee("Алексей", "Поздняк", "муж.", 19));

        cityDAO.addToTableCity(city, employeeList);

// Обновление данных в таблице "city" по id;
        cityDAO.updateCity(13, new City("Радде"));

// Изменение сотрудника одного из городов по id города;
        Employee employee = new Employee("Екатерина", "Свиридова", "жен.", 25);
        cityDAO.updateEmployeeLiveInCity(13, 33, employee);

// Получение всего списка из таблицы "city";
        cityDAO.getAllCity();

// Получение списка городов с их жителями по "id";
        cityDAO.findCityWithId(11);

// Удаление города из таблицы "city";
        cityDAO.delOneCity(13);
    }
}
