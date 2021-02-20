import java.util.Arrays;

public class Schedule {
    public int leastInterval(char[] tasks, int n) {
        int[] bucket = new int[26];
        for (int i = 0; i < tasks.length; i++){ // index代表字母，元素代表每个任务的数量
            ++bucket[tasks[i]-'A'];
        }
        Arrays.sort(bucket);
        int maxTime = bucket[25]; // 如果任务种类大于冷却时间，两个任务直接不需要冷却
        int left = 0;
        for (int i = 25; i >= 0; --i){
            if (bucket[i] == maxTime){// 花费时间最多的任务会被剩下
                left++;
            }else{
                break;
            }
        }

        return Math.max(tasks.length, (maxTime-1)*(n+1) + left);
    }
}
