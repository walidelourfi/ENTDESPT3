package org.entdes.todolist;


public class Tasca {
    private boolean completada = false;
    private String descripcio;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tasca(String descripcio) {
        this.descripcio = descripcio;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public String getDescripcio() {
        return descripcio;
    }

    @Override
    public String toString() {
        return descripcio + ": " + (completada ? "Completada" : "Pendent");
    }
}