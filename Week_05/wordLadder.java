import java.util.*;

public class wordLadder{
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> map = new HashSet<>(wordList);
        if (wordList.size() == 0 || !map.contains(endWord)){
            return 0;
        }
        int len = 1;

        Queue<String> wordQueue = new LinkedList<>();
        wordQueue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while(!wordQueue.isEmpty()){
            int size = wordQueue.size();
            // 遍历队列中的单词
            while(--size >= 0){
                String currentWord = wordQueue.poll();
                if (currentWord.equals(endWord)){
                    return len;
                }else{
                    bfs(currentWord, endWord, visited, map, wordQueue);
                }
            }
            len++;
        }
        return 0;
    }

    public void bfs(String currentWord, String endWord, Set<String> visited, Set<String> map, Queue<String> wordQueue){
        char[] charArray = currentWord.toCharArray();
        for (int i = 0; i < charArray.length; ++i){
            char oriCh = charArray[i];
            for (char c = 'a'; c <= 'z'; ++c){
                if (c == charArray[i]){
                    continue;
                }
                charArray[i] = c;
                // 获得到更改了一位后的新单词
                String nextword = String.valueOf(charArray);
                // 如果没遍历过 并且 存在字典中 就加入
                if (!visited.contains(nextword) && map.contains(nextword)){
                    visited.add(nextword);
                    wordQueue.add(nextword);
                }
                if (nextword.equals(endWord)){
                    return;
                }
                // 恢复
                charArray[i] = oriCh;
            }
        }
    }
}