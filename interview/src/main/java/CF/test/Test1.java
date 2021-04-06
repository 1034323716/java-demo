package CF.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Test1 {

    public static void main(String[] args) {
        List<Node> list = new ArrayList<>();
        list.add(new Node(1, 0, "AA"));
        list.add(new Node(2, 1, "BB"));
        list.add(new Node(3, 1, "CC"));
        list.add(new Node(4, 3, "DD"));
        list.add(new Node(5, 3, "EE"));
        list.add(new Node(6, 2, "FF"));
        list.add(new Node(7, 2, "GG"));
        list.add(new Node(8, 4, "HH"));
        list.add(new Node(9, 5, "II"));
        new Test1().print(list);
    }

    static class Node{
        int id;
        int parentId;
        String name;

        public Node(int id, int parentId, String name) {
            this.id = id;
            this.parentId = parentId;
            this.name = name;
        }
    }

    /**
     * 按树形打印出来
     * 没有根的叶子暂不打印
     *
     * @param list
     */
    private void print(List<Node> list) {
        if (Objects.nonNull(list) && list.size() > 0) {
            List<Node> headers = findNode(list, 0);
            for (Node header : headers) {
                printNode(header);
                List<Node> treeNodes = findNode(list, header.id);
                printTree(list, treeNodes);
            }
        }
    }

    /**
     *
     * 递归处理叶子list
     * @param list
     * @param treeNodes
     */
    private void printTree(List<Node> list, List<Node> treeNodes) {
        for (Node treeNode : treeNodes) {
            printNode(treeNode);
            List<Node> nodes = findNode(list, treeNode.id);
            if (Objects.nonNull(nodes) && nodes.size() > 0) {
                printTree(list, nodes);
            }
        }
    }

    /**
     * 打印单个节点
     *
     * @param node
     */
    private void printNode(Node node) {
        for (int i = 0; i < node.parentId; i++) {
            System.out.print(" ");
        }
        System.out.println(node.name);


    }

    /**
     * 根据parentId查找对应的叶子list
     *
     * @param list
     * @param parentId
     * @return
     */
    private List<Node> findNode(List<Node> list, int parentId) {
        List<Node> headerList = new ArrayList<>();
        for (Node node : list) {
            if (node.parentId == parentId) {
                headerList.add(node);
            }
        }
        return headerList;
    }
}
