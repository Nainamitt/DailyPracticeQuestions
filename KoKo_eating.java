class KoKo_eating {
    public int minEatingSpeed(int[] piles, int h) {
      int start=1;
      int  n=piles.length;
      int end=0;
      for (int pile : piles) {
    if (pile > end) {
        end = pile;
    }
}
      int ans=0;
      while(start<=end){
        int mid=start+(end-start)/2;
        if(caneat(piles,mid,h)){
            ans=mid;
            end=mid-1;
        }
        else start=mid+1;
      }
       return ans;
    }
   
    
   boolean caneat(int arr[],int speed,int time){
    int check=0;
    for(int i=0;i<arr.length;i++){
        if(arr[i]%speed==0){
            check+=arr[i]/speed;
        }
        else{
            check+=(arr[i]/speed)+1;
        }
        if(check>time)return false;
      
    }
      if(check<=time)return true;
      return false;
   
}}