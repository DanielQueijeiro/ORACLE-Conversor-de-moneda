package Busqueda;

import java.util.ArrayList;
import java.util.List;

public class Historial {
    private final List<Conversion> historial;

    public Historial(){
        this.historial = new ArrayList<>();
    }

    public void agregarConversion(Conversion conversion){
        this.historial.add(conversion);
    }

    public List<Conversion> getHistorial(){
        return this.historial;
    }
}
