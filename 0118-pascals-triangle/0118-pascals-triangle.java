class Solution {
    public List<Integer> rowElements(int rowElement){
        List<Integer> result = new ArrayList<>();
        long ans = 1;
        result.add((int)ans);

        for(int i=1;i<=rowElement;i++){
            ans = ans * (rowElement - i+1);
            ans = ans / (i);

            result.add((int)ans);
        }

        return result;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<numRows;i++){
            result.add(rowElements(i));
        }

        return result;
    }
}