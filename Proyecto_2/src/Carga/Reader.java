package Carga;

import Main.Persona;
import Main.ListaSimple;
import java.io.*;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

/**
 * Clase Reader para leer los JSON.
 * 
 */
public class Reader {

    /**
     * Método que guía al usuario para la lectura de un JSON compatible que cumpla con los parámetros del proyecto, devolviendo una ListaSimple de Personas las cuales forman parte de la Casa a ser analizada.
     * @return 
     */
    public ListaSimple Read() {
        StringBuilder texto = new StringBuilder();
        String line;
        File doc_data;
        ListaSimple ListaPersonas = new ListaSimple();  



        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtro_json = new FileNameExtensionFilter(".json", "json");
        fc.setFileFilter(filtro_json);
        fc.setCurrentDirectory(new File("Packages"));
        fc.setDialogTitle("Seleccione el archivo para cargar la Casa deseada");

        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            doc_data = fc.getSelectedFile();
            if (doc_data != null && doc_data.exists()) {
                try (BufferedReader br = new BufferedReader(new FileReader(doc_data))) {
                    while ((line = br.readLine()) != null) {
                        if (!line.isEmpty()) {
                            texto.append(line).append("\n");
                        }
                    }

                    if (!JSONvalido(texto.toString())) {
                        JOptionPane.showMessageDialog(null, "El archivo JSON no cumple con el formato requerido.");
                        return null;
                    }

                    try {

                        Gson gson = new Gson();
                        Map<String, List<Map<String, List<Map<String, Object>>>>> houseMap = gson.fromJson(
                                texto.toString(),
                                new TypeToken<Map<String, List<Map<String, List<Map<String, Object>>>>>>(){}.getType()
                        );

                        houseMap.forEach((house, members) -> {


                            String casa = house;
                            int indice = house.lastIndexOf(" ");
                            String apellido = house.substring(indice);
                            for (Map<String, List<Map<String, Object>>> member : members) {
                                member.forEach((name, details) -> {
                                    String nombre = name;
                                    String numeral = "";
                                    ListaSimple padres = new ListaSimple();
                                    String mote = "";
                                    String titulo = "";
                                    String conyuge = "";
                                    String color_ojos = "";
                                    String color_pelo = "";
                                    ListaSimple hijos = new ListaSimple();
                                    String notas = "";
                                    String destino = "";

                                    for (Map<String, Object> detail : details) {
                                        for (Map.Entry<String, Object> entry : detail.entrySet()) {
                                            switch (entry.getKey()) {
                                                case "Of his name":
                                                    numeral = entry.getValue().toString();
                                                    break;
                                                case "Born to":
                                                    padres.insertarAlFinal(entry.getValue().toString());
                                                    break;
                                                case "Known throughout as":
                                                    mote = entry.getValue().toString();
                                                    break;
                                                case "Held title":
                                                    titulo = entry.getValue().toString();
                                                    break;
                                                case "Wed to":
                                                    conyuge = entry.getValue().toString();
                                                    break;
                                                case "Of eyes":
                                                    color_ojos = entry.getValue().toString();
                                                    break;
                                                case "Of hair":
                                                    color_pelo = entry.getValue().toString();
                                                    break;
                                                case "Father to":
                                                    List<?> hijosList = (List<?>) entry.getValue();
                                                    for (Object hijo : hijosList) {
                                                        hijos.insertarAlFinal(hijo.toString());
                                                    }
                                                    break;
                                                case "Notes":
                                                    notas = entry.getValue().toString();
                                                    break;
                                                case "Fate":
                                                    destino = entry.getValue().toString();
                                                    break;
                                            }
                                        }
                                    }
                                    Persona persona = new Persona(nombre, apellido, numeral, padres, mote, titulo, conyuge, color_ojos, color_pelo, hijos, notas, destino);
                                    ListaPersonas.insertarAlFinal(persona);
                                });
                            }JOptionPane.showMessageDialog(null, "La Casa " + casa + " está siendo cargada.");
                        });
                        
                        return ListaPersonas;
                    } catch (JsonSyntaxException e) {
                        JOptionPane.showMessageDialog(null, "El archivo JSON no es válido: " + e.getMessage());
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error procesando el archivo JSON: " + e.getMessage());
                    }

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error durante la lectura del archivo: " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "El archivo seleccionado no existe.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se seleccionó ningún archivo.");
        }
        return null;
    }
    
    /**
     * Método que verifíca si un JSON es válido para el proyecto, supervisando las keys necesarias. Devuelve true si es compatible.
     * @param jsonString
     * @return 
     */
    private boolean JSONvalido(String jsonString) {
        String[] requiredKeys = {"Of his name", "Born to", "Known throughout as", "Held title", "Of eyes", "Of hair", "Father to"};
        for (String key : requiredKeys) {
            if (!jsonString.contains(key)) {
                return false;
            }
        }
        return true;
    }


}
