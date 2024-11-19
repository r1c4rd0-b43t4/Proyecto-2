package Main;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerPipe;
import javax.swing.*;

public class ArbolGraphStream implements Runnable {
    private Graph graph;
    private boolean loop = true;

    public ArbolGraphStream(Arbol arbol) {
        this.graph = new SingleGraph("Arbol Genealógico");
        construirGrafo(arbol.getRaiz());
    }

    private void construirGrafo(NodoArbol nodo) {
        if (nodo != null) {
            agregarNodo(nodo);
            for (NodoArbol hijo : nodo.obtenerHijos()) {
                graph.addEdge(nodo.getPersona().getNombre() + "-" + hijo.getPersona().getNombre(), nodo.getPersona().getNombre(), hijo.getPersona().getNombre());
                construirGrafo(hijo);
            }
        }
    }

    private void agregarNodo(NodoArbol nodo) {
        if (graph.getNode(nodo.getPersona().getNombre()) == null) {
            Node n = graph.addNode(nodo.getPersona().getNombre());
            n.setAttribute("ui.label", nodo.getPersona().toString());
            n.setAttribute("persona", nodo.getPersona()); // Agregar el objeto Persona como atributo
        }
    }

    public void mostrar() {
        Viewer viewer = graph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);

        ViewerPipe fromViewer = viewer.newViewerPipe();
        fromViewer.addViewerListener(new org.graphstream.ui.view.ViewerListener() {
            @Override
            public void viewClosed(String viewName) {
                loop = false;
            }

            @Override
            public void buttonPushed(String id) {
                Node node = graph.getNode(id);
                Persona persona = (Persona) node.getAttribute("persona");
                JOptionPane.showMessageDialog(null, "Información del nodo: " + persona.toString());
            }

            @Override
            public void buttonReleased(String id) {
                // No action needed on button release
            }

            @Override
            public void mouseOver(String string) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseLeft(String string) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        fromViewer.addSink(graph);

        while (loop) {
            fromViewer.pump();
        }
    }

    @Override
    public void run() {
        while (loop) {
            ViewerPipe fromViewer = graph.display().newViewerPipe();
            fromViewer.pump();
        }
    }

    public static void main(String[] args) {
        // Crear lista de personas y construir el árbol
        ListaSimple<Persona> listaPersonas = new ListaSimple<>();
        Persona personaRaiz = new Persona("Raíz", "Apellido", "1", new ListaSimple<>(), "Mote", "Título", "Conyuge", "Azul", "Negro", new ListaSimple<>(), "Notas", "Destino");
        listaPersonas.insertarAlFinal(personaRaiz);

        // Agregar más personas a la lista y establecer sus relaciones
        // Ejemplo:
        // Persona persona1 = new Persona("Hijo 1", "Apellido", "2", new ListaSimple<>(), "Mote", "Título", "Conyuge", "Verde", "Castaño", new ListaSimple<>(), "Notas", "Destino");
        // listaPersonas.insertarAlFinal(persona1);
        // Persona persona2 = new Persona("Hijo 2", "Apellido", "3", new ListaSimple<>(), "Mote", "Título", "Conyuge", "Marrón", "Rubio", new ListaSimple<>(), "Notas", "Destino");
        // listaPersonas.insertarAlFinal(persona2);

        Arbol arbolGenealogico = new Arbol();
        arbolGenealogico.construirArbol(listaPersonas);

        ArbolGraphStream arbolGraphStream = new ArbolGraphStream(arbolGenealogico);
        arbolGraphStream.mostrar();
    }
}
