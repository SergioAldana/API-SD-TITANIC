package co.edu.utadeo.api_sd_titanic.modelEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "pasajero")
public class Pasajero implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    /**
     * 1 al 3
     */
    @Column
    private long pclass;
    /**
     * female o male
     */
    @Column
    private String sex;
    @Column
    private Double age;
    /**
     * 1 al 8
     */
    @Column
    private long siblings_spousesAboard;
    /**
     * 1 al 9
     */
    @Column
    private long parents_childrenAboard;
    @Column
    private double fare;
    /**
     * 1 o 0
     */
    @Column
    private long survived;

    /**
     * Seran necesarios estos constructores?
     * Si es necesario, en la clase HelperCSV se traen los parametros del constructor
     * modificado y el Postman me solicita el constructor por defecto
     * Permitira entradas con valores nulos?
     */
    public Pasajero() {

    }

    public Pasajero(String name, long pclass, String sex, Double age,
                    long siblings_spousesAboard, long parents_childrenAboard, double fare, long survived) {
        this.name = name;
        this.pclass = pclass;
        this.sex = sex;
        this.age = age;
        this.siblings_spousesAboard = siblings_spousesAboard;
        this.parents_childrenAboard = parents_childrenAboard;
        this.fare = fare;
        this.survived = survived;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPclass() {
        return pclass;
    }

    public void setPclass(long pclass) {
        this.pclass = pclass;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public long getSiblings_spousesAboard() {
        return siblings_spousesAboard;
    }

    public void setSiblings_spousesAboard(long siblings_spousesAboard) {
        this.siblings_spousesAboard = siblings_spousesAboard;
    }

    public long getParents_childrenAboard() {
        return parents_childrenAboard;
    }

    public void setParents_childrenAboard(long parents_childrenAboard) {
        this.parents_childrenAboard = parents_childrenAboard;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public long getSurvived() {
        return survived;
    }

    public void setSurvived(long survived) {
        this.survived = survived;
    }

    /**
     * Este toString sera necesario?
     * Creo que es para cuando hago el llamado desde el navegador
     */
    @Override
    public String toString() {
        return "Pasajero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pclass=" + pclass +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", siblings_spousesAboard=" + siblings_spousesAboard +
                ", parents_childrenAboard=" + parents_childrenAboard +
                ", fare=" + fare +
                ", survived=" + survived +
                '}';
    }
}
