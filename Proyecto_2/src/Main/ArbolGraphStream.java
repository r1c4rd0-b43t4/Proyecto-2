package Main;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerPipe;
import org.graphstream.ui.layout.HierarchicalLayout;
import javax.swing.*;

public class ArbolGraphStream implements Runnable {
    private Graph graph;
    private boolean loop = true;

    public ArbolGraphStream(Arbol arbol) {
        System.setProperty("org.graphstream.ui", "swing");
        this.graph = new SingleGraph("Arbol Genealógico");
        construirGrafo(arbol.getRaiz());
    }

    private void construirGrafo(NodoArbol nodo) {
        if (nodo != null) {
            agregarNodo(nodo);
            for (NodoArbol hijo : nodo.obtenerHijos()) {
                if (hijo != null) { // Verificación de null
                    graph.addEdge(nodo.getPersona().getNombre() + "-" + hijo.getPersona().getNombre(), nodo.getPersona().getNombre(), hijo.getPersona().getNombre());
                    construirGrafo(hijo);
                }
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
        graph.setAttribute("ui.stylesheet", "node { fill-color: blue; size: 20px; }");
        graph.setAttribute("ui.antialias");
        Viewer viewer = graph.display();
        viewer.enableAutoLayout(new HierarchicalLayout());

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
            public void mouseOver(String id) {
                // No action needed on mouse over
            }

            @Override
            public void mouseLeft(String id) {
                // No action needed on mouse left
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

}
