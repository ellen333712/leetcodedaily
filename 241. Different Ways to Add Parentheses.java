class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> leftRes = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightRes = diffWaysToCompute(expression.substring(i+1));
                for (Integer left : leftRes) {
                    for (Integer right : rightRes) {
                        if (c == '+') {
                            res.add(left + right);
                        } else if (c == '-') {
                            res.add(left - right);
                        } else {
                            res.add(left * right);
                        }
                    }
                }
            }
        }
        
        if (res.size() == 0) {
            res.add(Integer.parseInt(expression));
        }
        
        return res;
    }
}
