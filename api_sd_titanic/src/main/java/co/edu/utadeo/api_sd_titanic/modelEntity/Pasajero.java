package co.edu.utadeo.api_sd_titanic.modelEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "pasajero")
public class Pasajero implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Seran necesarios estos constructores?
     * Permitira entradas con valores nulos?
     */
    public Pasajero() {

    }

    public Pasajero(long id, long pclass, boolean survived, String name, String sex, double age,
                    long sibsp, long parch, long ticket, double fare, String cabin, String embarked,
                    String boat, long body, String home_dest) {
        this.id = id;
        this.pclass = pclass;
        this.survived = survived;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.sibsp = sibsp;
        this.parch = parch;
        this.ticket = ticket;
        this.fare = fare;
        this.cabin = cabin;
        this.embarked = embarked;
        this.boat = boat;
        this.body = body;
        this.home_dest = home_dest;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * 1 al 3
     */
    @Column
    private long pclass;
    /**
     * 1 o 0
     */
    @Column
    private boolean survived;
    @Column
    private String name;
    /**
     * female o male
     */
    @Column
    private String sex;
    @Column
    private double age;
    /**
     * 1 al 8
     */
    @Column
    private long sibsp;
    /**
     * 1 al 9
     */
    @Column
    private long parch;
    @Column
    private long ticket;
    @Column
    private double fare;
    @Column
    private String cabin;
    /**
     * C, Q, S o Nulo
     */
    @Column
    private String embarked;
    @Column
    private String boat;
    @Column
    private long body;
    /**
     * Como aparecerá el nombre en la BD?
     */
    @Column(name = "home.dest")
    private String home_dest;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPclass() {
        return pclass;
    }

    public void setPclass(long pclass) {
        this.pclass = pclass;
    }

    public boolean getSurvived() {
        return survived;
    }

    public void setSurvived(boolean survived) {
        this.survived = survived;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public long getSibsp() {
        return sibsp;
    }

    public void setSibsp(long sibsp) {
        this.sibsp = sibsp;
    }

    public long getParch() {
        return parch;
    }

    public void setParch(long parch) {
        this.parch = parch;
    }

    public long getTicket() {
        return ticket;
    }

    public void setTicket(long ticket) {
        this.ticket = ticket;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public String getEmbarked() {
        return embarked;
    }

    public void setEmbarked(String embarked) {
        this.embarked = embarked;
    }

    public String getBoat() {
        return boat;
    }

    public void setBoat(String boat) {
        this.boat = boat;
    }

    public long getBody() {
        return body;
    }

    public void setBody(long body) {
        this.body = body;
    }

    public String getHome_dest() {
        return home_dest;
    }

    public void setHome_dest(String home_dest) {
        this.home_dest = home_dest;
    }

    /**
     * Este toString sera necesario?
     */
    @Override
    public String toString() {
        return "Pasajero{" +
                "id=" + id +
                ", pclass=" + pclass +
                ", survived=" + survived +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", sibsp=" + sibsp +
                ", parch=" + parch +
                ", ticket=" + ticket +
                ", fare=" + fare +
                ", cabin='" + cabin + '\'' +
                ", embarked='" + embarked + '\'' +
                ", boat='" + boat + '\'' +
                ", body=" + body +
                ", home_dest='" + home_dest + '\'' +
                '}';
    }
}
