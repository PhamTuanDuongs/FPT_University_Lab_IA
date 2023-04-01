/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FPT_University_Lab_IA_Group2.dao;

import FPT_University_Lab_IA_Group2.model.Course;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chuoiz
 */
@Repository(value = "courseDAO")
@Transactional(rollbackFor = Exception.class)
public class CourseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Course> listCourseByCurriculum(String curriculumId) {

        Session session = sessionFactory.getCurrentSession();

        String hql = "SELECT c\n"
                + "FROM Course c\n"
                + "JOIN c.curriculums cur\n"
                + "WHERE cur.curriculumId = :cuid";

        Query q = session.createQuery(hql, Course.class);

        q.setParameter("cuid", curriculumId);

        List<Course> coures = q.getResultList();
        return coures;
    }

    public List<Course> listCourseBySemesterAndStudentId(String semesterId, String studentId) {
        Session session = sessionFactory.getCurrentSession();

        String hql = "SELECT c\n "
                + "FROM Course c\n"
                + "JOIN c.curriculums cc\n"
                + "JOIN cc.students s\n"
                + "JOIN c.gradeCategorys gc\n"
                + "JOIN gc.grades gr\n"
                + "JOIN gr.semester ses\n"
                + "WHERE s.studentId = 'HE171578' AND ses.semesterId = 'SP2023'\n"
                + "group by c.courseId, c.courseName";

        Query q = session.createQuery(hql, Course.class);

//        q.setParameter("cuid", curriculumId);

        List<Course> coures = q.getResultList();
        return coures;
    }

}
