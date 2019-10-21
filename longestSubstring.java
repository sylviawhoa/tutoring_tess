class Solution {
    public int lengthOfLongestSubstring(String s) {
     //look at whole string and check if there's any repititions, check the index of where those repitions are and keep track of them
        // convert string to arraylist
        List<String> arr = new ArrayList<String>(Arrays.asList(s.split("")));
        Set<String> h = new HashSet<>(arr);
        //keeps track of total number of repeated letters
        int repeated = arr.size() - h.size();
        //makes a HashMap for each unique letter keeping track of the indices they apppear
        Map<String, ArrayList<Integer>> m = new HashMap<String, ArrayList<Integer>>(); // empty hashmap
        //iterates through the unique strings
        for(int i = 0; i < arr.size(); i++) {
            String letter = arr.get(i);
            m.putIfAbsent(letter, new ArrayList<Integer>());
            ArrayList<Integer> list = m.get(letter);
            list.add(i);
            m.put(letter, list);
        }
        //a: [0, 3]
        //b:[1, 4, 6, 7]
        //c: [2, 5]
        //find the largest interval that doesn't contain another interval for the other letters
        //iterate through keys
        int maxDifference = 1;
        for(String key: m.keySet()) {
            //create an empty array for the max indices
            int[] maxIndices = {0,0};
            //iterate through the intervals in the current key
            for(int j = 0; j < m.get(key).size()-1; j++) {
                int[] interval = {m.get(key).get(j), m.get(key).get(j+1)};
                int difference = interval[1] - interval[0];
                maxDifference = maxIndices[1] - maxIndices[0];
                if(difference > maxDifference) {
                    //iterating through the other keys to check if their intervals do not overlap
                    for(String otherKey: m.keySet()) {
                        if(otherKey != key) {
                            for(int k = 0; k < m.get(otherKey).size()-1; k++) {
                                int[] a ={m.get(otherKey).get(k), m.get(otherKey).get(k+1)};
                                int difference2 = a[1] - a[0];
                                if(!(interval[1] > a[1] && interval[0] < a[0])) {
                                    maxIndices[0] = interval[0];
                                    maxIndices[1] = interval[1];
                                    maxDifference = maxIndices[1] - maxIndices[0];
                                }
                            }
                        }
                    }
                }
            }
        }
        return maxDifference;
    }

}
