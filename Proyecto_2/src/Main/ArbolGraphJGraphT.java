package Main;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import javax.swing.*;
import java.awt.*;

public class ArbolGraphJGraphT {
    private Graph<String, DefaultEdge> graph;
    private HashTable personasHash;

    public ArbolGraphJGraphT(Arbol arbol, ListaSimple<Persona> listaPersonas) {
        this.graph = new SimpleGraph<>(DefaultEdge.class);
        this.personasHash = new HashTable();
        this.personasHash.CargarHashTable(listaPersonas);
        construirGrafo(arbol.getRaiz());
        mostrar();
    }

    private void construirGrafo(NodoArbol nodo) {
        if (nodo != null) {
            agregarNodo(nodo);

            String nodoPadreId = nodo.getPersona().getNombre() + "-" + nodo.getPersona().getNumeral();

            for (NodoArbol hijo : nodo.obtenerHijos()) {
                if (hijo != null) {
                    agregarNodo(hijo);
                    String nodoHijoId = hijo.getPersona().getNombre() + "-" + hijo.getPersona().getNumeral();

                    if (graph.containsVertex(nodoPadreId) && graph.containsVertex(nodoHijoId)) {
                        graph.addEdge(nodoPadreId, nodoHijoId);
                    }
                    construirGrafo(hijo);
                }
            }
        }
    }

    private void agregarNodo(NodoArbol nodo) {
        String nodeId = nodo.getPersona().getNombre() + "-" + nodo.getPersona().getNumeral();
        if (!graph.containsVertex(nodeId)) {
            graph.addVertex(nodeId);
        }
    }

    private void mostrar() {
        mxGraph mxGraph = new mxGraph();
        Object parent = mxGraph.getDefaultParent();

        mxGraph.getModel().beginUpdate();
        try {
            ListaSimple<Object> cells = new ListaSimple<>();
            for (String vertex : graph.vertexSet()) {
                Object cell = mxGraph.insertVertex(parent, vertex, vertex, 0, 0, 100, 50, "shape=ellipse;perimeter=ellipsePerimeter;fillColor=lightblue;strokeColor=blue;fontColor=black;fontSize=16;fontStyle=1;verticalAlign=middle;horizontalAlign=center;");
                cells.insertarAlFinal(cell);
            }
            for (DefaultEdge edge : graph.edgeSet()) {
                String source = graph.getEdgeSource(edge);
                String target = graph.getEdgeTarget(edge);

                Object sourceCell = null;
                Object targetCell = null;

                Nodo<Object> aux = cells.getpFirst();
                while (aux != null) {
                    if (mxGraph.getLabel(aux.getValor()).equals(source)) {
                        sourceCell = aux.getValor();
                    }
                    if (mxGraph.getLabel(aux.getValor()).equals(target)) {
                        targetCell = aux.getValor();
                    }
                    aux = aux.getSiguiente();
                }

                if (sourceCell != null && targetCell != null) {
                    mxGraph.insertEdge(parent, null, "", sourceCell, targetCell, "strokeColor=gray;strokeWidth=2;");
                }
            }
        } finally {
            mxGraph.getModel().endUpdate();
        }

        mxHierarchicalLayout layout = new mxHierarchicalLayout(mxGraph);
        layout.setIntraCellSpacing(50);  
        layout.setInterRankCellSpacing(100); 
        layout.execute(mxGraph.getDefaultParent());

        JFrame frame = new JFrame("Arbol Genealógico");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); 

        mxGraphComponent graphComponent = new mxGraphComponent(mxGraph);
        graphComponent.setBackground(Color.WHITE); 
        frame.add(graphComponent);
        frame.setVisible(true);

        graphComponent.getGraphControl().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                Object cell = graphComponent.getCellAt(e.getX(), e.getY());
                if (cell != null) {
                    String id = mxGraph.getLabel(cell);
                    mostrarInformacionNodo(id);
                }
            }
        });
    }

    private void mostrarInformacionNodo(String id) {
        String[] parts = id.split("-");
        if (parts.length == 2) {
            String nombre = parts[0];
            String numeral = parts[1];
            int indice = personasHash.getIndice(personasHash.returnAsciiCode(nombre));
            ListaSimple<Persona> listaPersonas = personasHash.getArregloHash()[indice];
            Persona persona = listaPersonas.BuscarNombreIndividualNumeral(nombre, numeral, false);

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

                info.append("Padres:\n");
                Nodo<String> padreNodo = persona.getPadres().getpFirst();
                while (padreNodo != null) {
                    String padre = padreNodo.getValor();
                    info.append("\t").append(padre).append("\n");
                    padreNodo = padreNodo.getSiguiente();
                }

                info.append("Hijos:\n");
                Nodo<String> hijoNodo = persona.getHijos().getpFirst();
                while (hijoNodo != null) {
                    String hijo = hijoNodo.getValor();
                    info.append("\t").append(hijo).append("\n");
                    hijoNodo = hijoNodo.getSiguiente();
                }

                JOptionPane.showMessageDialog(null, info.toString(), "Información de " + persona.getNombre(), JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró información asociada al nodo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
