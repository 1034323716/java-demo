package huawei.test;

import java.util.*;

public class HappenSort {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = "";
        while (input.hasNextLine()) {
            s = input.nextLine();
            System.out.println(new HappenSort().sort(s));
        }
    }

    private String sort(String s) {

        HashMap<String, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            String cStr = String.valueOf(c);
            if (map.containsKey(cStr)) {
                Integer integer = map.get(cStr);
                integer = integer + 1;
                map.put(cStr, integer);
            } else {
                map.put(cStr, 1);
            }
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        LinkedList<Map.Entry<String, Integer>> linkedList = new LinkedList<>(entries);
        Collections.sort(linkedList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return 1;
                } else if (o1.getValue() < o2.getValue()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        StringBuffer stringBuffer = new StringBuffer();
        int size = linkedList.size();
        for (int i = 0; i < size; i++) {
            Map.Entry<String, Integer> entry = linkedList.get(size - 1 - i);
            Integer value = entry.getValue();
            for (Integer j = 0; j < value; j++) {
                stringBuffer.append(entry.getKey());
            }
        }
        return stringBuffer.toString();
    }

}
