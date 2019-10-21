class Solution {
    public int lengthOfLongestSubstring(String s) {
     //look at whole string and check if there's any repititions, check the index of where those repitions are and keep track of them
        ArrayList<String> arr = new ArrayList<>(s);
        Set<HashSet> h = new HashSet<>(s);
        //keeps track of total number of repeated letters
        int repeated = len(arr) - h.size();

        //makes a HashMap for each unique letter keeping track of the indices they apppear
        Map<HashMap> m = new HashMap<>();
        //iterates through the unique strings
        for(int i = 0; i < arr.length; i++) {
            m.putifAbsent(arr.get(i), new ArrayList<Integer>());
            m.put(arr.get(i).getKey().add(i));
        }

        //a: [0, 3]
        //b:[1, 4, 6, 7]
        //c: [2, 5]
        //find the largest interval that doesn't contain another interval for the other letters
        //iterate through keys
        for(myKey key: m.keySet()) {
            //create an empty array for the max indices
            int[] maxIndices = {0,0};
            //iterate through the intervals in the current key
            for(int k = 0; k < m.get(myKey).length()-1; k++) {
                int[] interval ={m.get(myKey).get(k), m.get(myKey).get(k+1)};
                int difference = interval[1] - interval[0];
                int maxDifference = maxIndices[1] - maxIndices[0];
                if(difference > maxDifference) {
                   for(otherKey key: m.keySet()) {
                        if(otherKey != myKey) {
                            for(int k = 0; k < m.get(otherKey).length()-1; k++) {
                                int[] a ={m.get(otherKey).get(k), m.get(otherKey).get(k+1)};
                                int difference2 = a[1] - a[0];
                                if(!(interval[1] > a[1] && interval[0] < a[0])) {
                                    maxIndices[0] = interval[0];
                                    maxIndices[1] = interval[1];


                                }


            }
        }

    }

        }
                //iterating through the other keys to check if their intervals do not overlap


        }




        return maxIndices;


    }
}
}
