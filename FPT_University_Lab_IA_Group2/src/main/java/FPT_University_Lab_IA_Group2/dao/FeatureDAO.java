/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FPT_University_Lab_IA_Group2.dao;

import FPT_University_Lab_IA_Group2.model.Feature;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chuoiz
 */
@Repository(value = "featureDAO")
@Transactional(rollbackFor = Exception.class)
public class FeatureDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void persist(final Feature feature) {
        sessionFactory.getCurrentSession().persist(feature);
    }

    public Feature findById(final int id) {
        return sessionFactory.getCurrentSession().find(Feature.class, id);
    }

    public void delete(final Feature feature) {
        sessionFactory.getCurrentSession().remove(feature);
    }

    public List<Feature> findAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM Feature", Feature.class).getResultList();
    }
}
