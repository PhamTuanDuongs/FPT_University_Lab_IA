/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FPT_University_Lab_IA_Group2.service;

import FPT_University_Lab_IA_Group2.dao.GradeCategoryDAO;
import FPT_University_Lab_IA_Group2.model.GradeCategory;
import FPT_University_Lab_IA_Group2.model.Group;
import FPT_University_Lab_IA_Group2.model.Student;
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
public class GradeCategoryService {

    @Autowired
    private GradeCategoryDAO gradeCategoryDAO;

    public List<GradeCategory> listGradeCategory(String studentId, String semesterId, String courseId) {

        return gradeCategoryDAO.listGradeCategory(studentId, semesterId, courseId);
    }

}
