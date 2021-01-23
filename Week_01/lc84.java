import java.util.Stack;

public class lc84 {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> block = new Stack<>();
        Stack<Integer> idx = new Stack<>();
        int max = 0;
        block.push(-1);
        idx.push(-1);
        for (int i = 0; i < heights.length;i++){
            if (heights[i] >= block.peek()){
                block.push(heights[i]);
                idx.push(i);
            }else{//找到边界了
                while(heights[i] < block.peek()){//判断；一直比栈顶元素大，否则入栈
                    int h = block.pop();
                    int len;
                    idx.pop();
                    max = Math.max(h*(i-idx.peek()-1),max);
                    System.out.println(max);
                }
                block.push(heights[i]);
                idx.push(i);
                System.out.println(block);
            }
        }
        int l = idx.pop()+1;
        while(idx.peek()!=-1){
            max = Math.max(block.pop()*(l-idx.pop()-1),max);
        }
        max = Math.max(l*block.pop(),max);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new lc84().largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

}
