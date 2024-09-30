package model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "clase que representa al usuario")
public class Usuario {
    @Schema(description = "Identificador único del usuario", example = "1")
    private long id;

    @Schema(description = "Nombre completo del usuario",example = "Leo Prueba")
    @NotNull
    @Size(min =3,max=50,message ="El nombre del usuario debe tener entre 3 y 50 caracteres")
    private String nombre;

    @Schema(description = "Correo electronico del usuario",example = "leo@example.com")
    @Email
    private String email;

    @Schema(description = "Edad del usuario",example = "20")
    @Min(18)
    @Max(99)
    private int edad;
    public Usuario()
    {

    }
    public Usuario(long id, String nombre, String email, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
