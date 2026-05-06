class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s2Length = s2.length();
        HashMap<Character , Integer>  inclMap  = new HashMap<>();
        HashMap<Character , Integer>  checkMap  = new HashMap<>();
        
        for(char ch :  s1.toCharArray()) inclMap.put(ch  ,inclMap.getOrDefault(ch , 0)+1);
        int i =0  , j=0;
        char[] arr = s2.toCharArray();

        while(j<s2Length){
            checkMap.put(arr[j] , checkMap.getOrDefault(arr[j] , 0)+1);

            while((j-i+1)>s1.length()){
                checkMap.put(arr[i] , checkMap.getOrDefault(arr[i] , 0)-1);

                if(checkMap.get(arr[i])==0) checkMap.remove(arr[i]);
                i++;
            }
            if((j-i+1)==s1.length()){
                if(inclMap.equals(checkMap)) return true;
            }
            j++;
        }
        return false;

    }
}
