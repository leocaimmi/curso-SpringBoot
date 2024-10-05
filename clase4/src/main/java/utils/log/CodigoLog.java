package utils.log;

public enum CodigoLog {
    CREAR_USUARIO("CREAR_USUARIO","Usuario creado con exito"),
    ACTUALIZAR_USUARIO("ACTUALIZAR_USUARIO","Usuario actualizado con exito"),
    ELIMINAR_USUARIO("ELIMINAR_USUARIO","Usuario elimnado con exito");

    private final String codigo;
    private final String descripcion;

    CodigoLog(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
