package service;

import tableClass.Employee;

public interface EmployeeDAO {

    void addToTableEmployee(Employee employee);
    void updateMemberEmmployee(int id, Employee employee);
    void delOneMemberEmployee(int id);
    void getAllEmployee();




}
