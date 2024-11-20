package Main;

import Main.NodoArbol;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.layout.HierarchicalLayout;
import org.graphstream.ui.view.Viewer;

public class ArbolGraphStream {
    private Graph graph;

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
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.CLOSE_VIEWER);
        viewer.enableAutoLayout(new HierarchicalLayout());
    }
}




