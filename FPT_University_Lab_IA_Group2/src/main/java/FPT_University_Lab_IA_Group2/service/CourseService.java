/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FPT_University_Lab_IA_Group2.service;

import FPT_University_Lab_IA_Group2.dao.CourseDAO;
import FPT_University_Lab_IA_Group2.model.Course;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chuoiz
 */
@Service
@Transactional
public class CourseService {

    @Autowired
    private CourseDAO courseDAO;

    public List<Course> listCourseByCurriculum(String curriculumId) {
        return courseDAO.listCourseByCurriculum(curriculumId);
    }
}
