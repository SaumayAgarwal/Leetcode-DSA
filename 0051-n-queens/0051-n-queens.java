class Solution {

    List<List<String>> ans;
    public void helper(int[] rows, int row){
        if(row==rows.length){
            List<String> l=new ArrayList<>();
            for(int i=0;i<row;i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<row;j++){
                    if(rows[i]==j)sb.append('Q');
                    else sb.append('.');
                }
                l.add(sb.toString());
            }
            ans.add(l);
            return;
        }
        for(int i=0;i<rows.length;i++){
            if(check(rows, row, i)){
                rows[row]=i;
                helper(rows, row+1);
                rows[row]=-1;
            }
        }
    }

    public boolean check(int[] rows, int row, int col){
        for(int i=0;i<row;i++){
            if(rows[i]==col)return false;
        }

        int i=row-1, j=col-1;
        while(i>=0 && j>=0){
            if(rows[i]==j)return false;
            i--;
            j--;
        }

        i=row-1;
        j=col+1;
        while(i>=0 && j<rows.length){
            if(rows[i]==j)return false;
            i--;
            j++;
        }

        return true;
    }
    public List<List<String>> solveNQueens(int n) {
        int[] rows=new int[n];
        Arrays.fill(rows, -1);

        ans=new ArrayList<>();
        helper(rows, 0);

        return ans;
    }
}