import java.util.ArrayList;

/**
 * Created by Ma$ha on 14.02.2017.
 */
public class Graph {
    public final String name;
    private ArrayList<String> vertexList = new ArrayList<String>();

    private ArrayList<ArrayList<Integer>> weightTable = new ArrayList<ArrayList<Integer>>();

    public Graph(String name) {
        this.name = name;
    }

    public void addVertex(String vertexName) {
        if (!vertexList.contains(vertexName)) {
            vertexList.add(vertexName);
            weightTable.add(new ArrayList());
            for (int i = 0; i < vertexList.size(); i++) {
                for (int j = weightTable.get(i).size(); j < vertexList.size(); j++) weightTable.get(i).add(0);
            }
        }
    }

    public void addEdge(String vertexBegin, String vertexEnd, int weight) {
        addVertex(vertexBegin);
        addVertex(vertexEnd);
        int a = vertexList.indexOf(vertexBegin);
        int b = vertexList.indexOf(vertexEnd);
        weightTable.get(a).set(b, weight);
    }

    public void changeVertexName(String vertexName, String newVertexName) {
        vertexList.set(vertexList.indexOf(vertexName), newVertexName);
    }

    public void removeEdge(String vertexBegin, String vertexEnd) {
        if (vertexList.contains(vertexBegin) && vertexList.contains(vertexEnd)) addEdge(vertexBegin, vertexEnd, 0);
    }

    public void removeVertex(String vertexName) {
        int indexToDel = vertexList.indexOf(vertexName);
        for (int i = 0; i < vertexList.size(); i++) weightTable.get(i).remove(indexToDel);
        weightTable.remove(indexToDel);
        vertexList.remove(indexToDel);
    }

    public ArrayList<String> vertexIn(String vertexName) {
        ArrayList<String> vertexIn = new ArrayList();
        int indexVertex = vertexList.indexOf(vertexName);
        for (int i = 0; i < vertexList.size(); i++) {
            int a = weightTable.get(i).get(indexVertex);
            if (a != 0) vertexIn.add(vertexList.get(i));
        }
        return vertexIn;
    }

    public ArrayList<String> vertexOut(String vertexName) {
        ArrayList<String> vertexOut = new ArrayList();
        int indexVertex = vertexList.indexOf(vertexName);
        ArrayList<Integer> a = weightTable.get(indexVertex);
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) != 0) vertexOut.add(vertexList.get(i));
        }
        return vertexOut;
    }

    public ArrayList<String> getAllVertex() {
        return vertexList;
    }

    public ArrayList<String> getTable() {
        ArrayList<String> table = new ArrayList<>();
        for (int i = 0; i < vertexList.size(); i++) {
            table.add(weightTable.get(i).toString());
        }
        return table;
    }
}