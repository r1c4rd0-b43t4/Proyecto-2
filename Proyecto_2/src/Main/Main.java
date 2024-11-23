package Main;

import UI.UI_Inicio;
/**
 * Clase Main.
 * @author rdbae
 */
public class Main {

    /**
     * Método que inicia el proyecto.
     * @param args 
     */
    public static void main(String[] args) {
        UI_Inicio ui = new UI_Inicio();
        ui.setLocationRelativeTo(null);
        ui.setVisible(true);
    }
}
