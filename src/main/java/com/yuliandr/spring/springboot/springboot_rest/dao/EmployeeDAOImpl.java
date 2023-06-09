package com.yuliandr.spring.springboot.springboot_rest.dao;

import com.yuliandr.spring.springboot.springboot_rest.entity.Employee;

import jakarta.persistence.*;
//import org.hibernate.Session;
//import org.hibernate.query.Query;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList();
//        Session session = entityManager.unwrap(Session.class);
////        List<Employee> allEmployees = session.createQuery("from Employee",Employee.class).getResultList();
//        Query<Employee> query = session.createQuery("from Employee", Employee.class);
//        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
       Employee newEmp = entityManager.merge(employee);
       employee.setId(newEmp.getId());
//        Session session = entityManager.unwrap(Session.class);
////        if (employee.getId()==0){
////        session.save(employee);
////    }else {
//            session.saveOrUpdate(employee);
////        }
    }

    @Override
    public Employee getEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        return session.get(Employee.class,id);
        return entityManager.find(Employee.class,id);
    }

    @Override
    public void deleteEmployee(int id) {
        Query query = entityManager.createQuery("delete from Employee where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
//        Session session = entityManager.unwrap(Session.class);
//        Query query= session.createQuery("delete from Employee where id =:employeeId");
//        query.setParameter("employeeId",id);
//        query.executeUpdate();
    }
}
