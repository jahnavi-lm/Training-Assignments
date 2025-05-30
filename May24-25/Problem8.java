class Problem8{
    public static Integer hayStack(String hay, String needle){
        int n = needle.length();
        for(int i =0;i<=hay.length()-n;i++){
            if(hay.substring(i,i+n).equals(needle))
            return i;
        }
        return -1;
    }
    public static void main(String[] args){
        String hay = "sadbutsad";
        String needle = "sdd";
        Integer result = hayStack(hay, needle);
        System.out.println(result);
    }

}