class Solution {

    public String encode(List<String> strs) {
        if(strs.size() == 0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(String s : strs){
            sb.append("\t");
            sb.append(s);
        }
        sb.append(']');
        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str.length() == 0) return new ArrayList<>();
        String[] split = str.split("\t");
        List<String> ans = new ArrayList<>();
        StringBuffer str1 = new StringBuffer(split[0]);
        StringBuffer str2 = new StringBuffer(split[split.length-1]);
//        ans.add(str1.deleteCharAt(0).toString());
        for(int i = 1; i < split.length - 1; i++){
            ans.add(split[i]);
        }
        ans.add(str2.deleteCharAt(str2.length()-1).toString());
        return ans;
    }
}
