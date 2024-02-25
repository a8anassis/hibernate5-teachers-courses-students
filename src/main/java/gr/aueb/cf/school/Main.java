package gr.aueb.cf.school;

import gr.aueb.cf.school.model.Course;
import gr.aueb.cf.school.model.Student;
import gr.aueb.cf.school.model.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("schoolPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

//        Teacher androutsos = new Teacher();
//        androutsos.setFirstname("Athan.");
//        androutsos.setLastname("Androutsos");
//
//        Teacher kapetis = new Teacher();
//        kapetis.setFirstname("Makis");
//        kapetis.setLastname("Kapetis");
//
//        Course sql = new Course();
//        sql.setTitle("SQL");
//        sql.setDescription("SQL Course");
//
//        Course java = new Course();
//        java.setTitle("Java");
//        java.setDescription("Java Course");
//
//        kapetis.addCourse(sql);
//        androutsos.addCourse(java);
//
//        Student alice = new Student();
//        alice.setFirstname("Alice");
//        alice.setLastname("Wonder");
//        alice.addCourse(java);
//
//        em.persist(androutsos);
//        em.persist(kapetis);
//        em.persist(sql);
//        em.persist(java);
//        em.persist(alice);


//        Student alice = em.find(Student.class, 1L);
//        Course java = em.find(Course.class, 2L);
//        Course sql = em.find(Course.class, 1L);
//        alice.deleteCourse(java);
//
//        alice.addCourse(sql);


        List<Object[]> teacherList = em.createQuery("SELECT t, c FROM Teacher t JOIN t.courses c", Object[].class)
                //.setParameter("lastname", "Androutsos")
                .getResultList();

        em.getTransaction().commit();
        //teacherList.forEach(System.out::println);
        for (Object[] row : teacherList) {
            System.out.println(row[0]);
            System.out.println(row[1].toString());
        }


        em.close();
        emf.close();
    }
}
