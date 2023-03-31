/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FPT_University_Lab_IA_Group2.model;

import java.util.List;
import javax.persistence.*;


/**
 *
 * @author chuoiz
 */
@Entity
@Table(name = "Feature")
public class Feature {

    @Id
    @Column(name = "featureId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int featureId;

    @Column(name = "featureName")
    private String featureName;

    @Column(name = "url")
    private String url;

    @ManyToMany(targetEntity = Role.class, cascade = {CascadeType.ALL})
    @JoinTable(name = "Role_Feature",
            joinColumns = {
                @JoinColumn(name = "featureId")},
            inverseJoinColumns = {
                @JoinColumn(name = "roleId")})
    private List<Role> roles;

    public int getFeatureId() {
        return featureId;
    }

    public void setFeatureId(int featureId) {
        this.featureId = featureId;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}
