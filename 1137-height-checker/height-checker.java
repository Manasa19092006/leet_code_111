class Solution {
    public int heightChecker(int[] heights) {
        int count =0;
        ArrayList<Integer> expected = new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            expected.add(heights[i]);
        }
        Collections.sort(expected);
            for(int i=0;i<heights.length;i++){
                if(expected.get(i)!=heights[i]){
                    count++;
                }
            }
        return count;
    }
}