class ratInMaze {
    // Function to find all possible paths
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        // code here
        ArrayList<String>ans=new ArrayList();
        String s="";
        boolean visited[][]=new boolean[mat.size()][mat.size()]; //using tracking array but not used directly modify matrix
        find( mat,0,0,s,ans,visited);
        return ans;
    }
    void find(ArrayList<ArrayList<Integer>> mat,int i,int j,String direc,ArrayList<String>ans, boolean visited[][]){
        if(i>mat.size()-1||j>mat.size()-1||i<0||j<0||mat.get(i).get(j)==0||mat.get(i).get(j)==-1)return;
        if(i==mat.size()-1&&j==mat.size()-1){
            ans.add(direc);
            return;
        }
mat.get(i).set(j, -1);
        find(mat,i+1,j,direc+'D',ans,visited); //DOWN
        find(mat,i,j-1,direc+'L',ans,visited);//LEFT
        find(mat,i,j+1,direc+'R',ans,visited);//RIGHT
        find(mat,i-1,j,direc+'U',ans,visited);//UP
mat.get(i).set(j, 1);
        
        
    }
}