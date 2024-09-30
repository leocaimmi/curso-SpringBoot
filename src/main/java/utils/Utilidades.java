package utils;


import org.springframework.stereotype.Component;

@Component
public class Utilidades {
    public String formatearTexto(String texto){
        return texto.trim().toUpperCase();
    }
}
