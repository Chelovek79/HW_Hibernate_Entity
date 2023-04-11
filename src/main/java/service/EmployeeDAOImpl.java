package service;

import tableClass.Employee;
import javax.persistence.*;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void addToTableEmployee(Employee employee) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void updateMemberEmmployee(int id, Employee employee) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery(
                "UPDATE Employee e SET " +
                        "e.firstName = :firstName," +
                        "e.lastName = :lastName," +
                        "e.gender = :gender," +
                        "e.age = :age," +
                        "e.city = :city WHERE e.id = :id");
        query.setParameter("firstName", employee.getFirstName());
        query.setParameter("lastName", employee.getLastName());
        query.setParameter("gender", employee.getGender());
        query.setParameter("age", employee.getAge());
        query.setParameter("city", employee.getCity());
        query.setParameter("id", id);
        query.executeUpdate();
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void delOneMemberEmployee(int id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE FROM Employee e where e.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void getAllEmployee() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT e FROM Employee e ORDER BY e.id");
        entityManager.getTransaction().commit();

        List<Employee> employeeList = query.getResultList();

        entityManager.close();
        entityManagerFactory.close();

        employeeList.stream()
                .forEach(System.out::println);
    }
}
