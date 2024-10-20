class Solution {
    private boolean parse_and(String exp){
        boolean result = true;
        for(int i=0;i<exp.length();i++){
            if(exp.charAt(i) == '&'){
                String substring = getSubstring(i+1,exp);
                result &= parse_and(substring);
            }
            else if(exp.charAt(i) == '|'){
                String substring = getSubstring(i+1,exp);
                result &= parse_or(substring);
            }
            else if(exp.charAt(i) == '!'){
                String substring = getSubstring(i+1,exp);
                result &= parseBoolExpr(substring) ? false : true;
            }
        }
        for(char i: exp.toCharArray()){
            if(i == 'f'){
                result = false;
                break;
            }
        }
        return result;
    }
    private boolean parse_or(String exp){
        boolean result = false;
        for(int i=0;i<exp.length();i++){
            if(exp.charAt(i) == '&'){
                String substring = getSubstring(i+1,exp);
                result |= parse_and(substring);
            }
            else if(exp.charAt(i) == '|'){
                String substring = getSubstring(i+1,exp);
                result |= parse_or(substring);
            }
            else if(exp.charAt(i) == '!'){
                String substring = getSubstring(i+1,exp);
                result |= parseBoolExpr(substring) ? false : true;
            }
        }
        for(char i: exp.toCharArray()){
            if(i == 't'){
                result = true;
                break;
            }
        }
        return result;
    }
    private String getSubstring(int idx , String exp){
        int count = 0;
        for(int i=idx ;i<exp.length();i++){
            if(exp.charAt(i) == '(') count++;
            else if(exp.charAt(i) == ')') count--;
            if(count == 0) return exp.substring(idx+1,i);
        }
        return exp.substring(idx);
    }
    public boolean parseBoolExpr(String exp) {
        boolean result = true,is_parsed = false;
        for(int i=0;i<exp.length();i++){
            if(exp.charAt(i) == '&'){
                is_parsed = true;
                String substring = getSubstring(i+1,exp);
                result = parse_and(substring);
                break;
            }
            else if(exp.charAt(i) == '|'){
                is_parsed = true;
                String substring = getSubstring(i+1,exp);
                result = parse_or(substring);
                break;
            }
            else if(exp.charAt(i) == '!'){
                is_parsed = true;
                String substring = getSubstring(i+1,exp);
                result = parseBoolExpr(substring) ? false : true;
                break;
            }
        }
        if(!is_parsed){
            for(char i : exp.toCharArray()){
                if(i == 't') return true;
                else if(i == 'f') return false;
            }
        }

        return result;
    }
}
