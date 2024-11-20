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

            String nodoPadreId = nodo.getPersona().getNombre() + "-" + nodo.getPersona().getNumeral();

            for (NodoArbol hijo : nodo.obtenerHijos()) {
                if (hijo != null) {
                    agregarNodo(hijo);
                    String nodoHijoId = hijo.getPersona().getNombre() + "-" + hijo.getPersona().getNumeral();

                    if (graph.getNode(nodoPadreId) != null && graph.getNode(nodoHijoId) != null) {
                        String edgeId = nodoPadreId + "--" + nodoHijoId; // Identificador único para la arista

                        if (graph.getEdge(edgeId) == null) { // Verificar si la arista ya existe
                            graph.addEdge(edgeId, nodoPadreId, nodoHijoId);
                        }
                    }
                    construirGrafo(hijo);
                }
            }
        }
    }

    private void agregarNodo(NodoArbol nodo) {
        String nodeId = nodo.getPersona().getNombre() + "-" + nodo.getPersona().getNumeral();

        if (graph.getNode(nodeId) == null) { 
            System.out.println("Agregando nodo: " + nodeId);
            Node n = graph.addNode(nodeId); 
            n.setAttribute("ui.label", nodo.getPersona().getNombre());
            n.setAttribute("persona", nodo.getPersona()); 
        }
    }

    public void mostrar() {
        graph.setAttribute("ui.stylesheet", "node { fill-color: green; size: 20px; text-alignment: under; text-color: black; }");
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
            if (node != null) {
                Persona persona = (Persona) node.getAttribute("persona");
                if (persona != null) {
                    StringBuilder info = new StringBuilder();
                    info.append("Nombre: ").append(persona.getNombre()).append("\n");
                    info.append("Apellido: ").append(persona.getApellido()).append("\n");
                    info.append("Numeral: ").append(persona.getNumeral()).append("\n");
                    info.append("Mote: ").append(persona.getMote()).append("\n");
                    info.append("Título: ").append(persona.getTitulo()).append("\n");
                    info.append("Cónyuge: ").append(persona.getConyuge()).append("\n");
                    info.append("Color de Ojos: ").append(persona.getColor_ojos()).append("\n");
                    info.append("Color de Pelo: ").append(persona.getColor_pelo()).append("\n");
                    info.append("Destino: ").append(persona.getDestino()).append("\n");
                    info.append("Notas: ").append(persona.getNotas()).append("\n");
                        
                    JOptionPane.showMessageDialog(null,
                            info.toString(),
                            "Información de " + persona.getNombre(),
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "No se encontró información asociada al nodo.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }

            @Override
            public void buttonReleased(String id) {
            }

            @Override
            public void mouseOver(String id) {
            }

            @Override
            public void mouseLeft(String id) {
            }
        });
        fromViewer.addSink(graph);


        new Thread(this).start();
    }

    @Override
    public void run() {
        ViewerPipe fromViewer = graph.display().newViewerPipe();
        while (loop) {
            fromViewer.pump();
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}





