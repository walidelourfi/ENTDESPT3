package org.entdes.todolist;

import java.util.ArrayList;
import java.util.List;

public class GestorTasques {
    private List<Tasca> llista = new ArrayList<>();

    public void afegirTasca(String descripcio) {
        Tasca tasca = new Tasca(descripcio);
        llista.add(tasca);
    }

    public void eliminarTasca(String descripcio) {
        llista.removeIf(tasca -> tasca.getDescripcio().equals(descripcio));
    }

    public void marcarCompletada(String descripcio) {
        for (Tasca tasca : llista) {
            if (tasca.getDescripcio().equals(descripcio)) {
                tasca.setCompletada(true);
                break;
            }
        }
    }

    public List<Tasca> llistarTasques() {
        return llista;
    }

    public List<Tasca> filtrarTascaPerDescripcio(String descripcio) {
            
            List<Tasca> llistaFiltrada = new ArrayList<>();
            for (Tasca tasca : this.llista) {
                if (tasca.getDescripcio().equals(descripcio)) {
                llistaFiltrada.add(tasca);
            }
        }

        return llistaFiltrada;
    }
}