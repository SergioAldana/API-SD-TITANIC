package co.edu.utadeo.api_sd_titanic.modelEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Entity(name = "pasajero")
public class Pasajero {

    @Id
    private long cedula;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String fechaNac;
    @Column
    private Period edad;

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    /**
     * Nose porque tanto set como get no me estan funcionando como deberia
     */
    public Period getEdad() {
        /*
        System.out.printf("Tu edad es: %s años, %s meses y %s días",
        edad.getYears(), edad.getMonths(), edad.getDays());
        */
        return edad;
    }

    public void setEdad() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(getFechaNac(), formato);
        LocalDate fechaAct = LocalDate.now();

        this.edad = Period.between(fechaNac, fechaAct);
    }
}
