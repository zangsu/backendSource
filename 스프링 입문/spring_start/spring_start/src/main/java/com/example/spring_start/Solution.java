package com.example.spring_start;

import java.util.*;
class Solution {
    public String[] solution(String[] orders, int[] course) {
        //9:11 ~ 
        String[] answer;
        MenuExtractor me = new MenuExtractor();
        HashMap<Integer, HashMap<String, Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap();
        PriorityQueue<String> answerList = new PriorityQueue();
        for(String order : orders){
            me.extractSet(order, map, count);
        }
        
        for(int courseNum : course){
            Integer orderNum = count.get(courseNum);
            if(orderNum == null || orderNum == 1)
                continue;
            HashMap<String, Integer> orderMap = map.get(courseNum);
            Iterator<String> iter = orderMap.keySet().iterator();
            while(iter.hasNext()){
                String menu = iter.next();
                if(orderMap.get(menu) == orderNum)
                    answerList.add(menu);
                    //System.out.println(menu);
            }
        }
        
        answer = new String[answerList.size()];
        for(int i = 0; i<answer.length; i++)
            answer[i] = answerList.poll();
        //printHashMap(map);
        return answer;
    }
    private void printHashMap(HashMap<Integer, HashMap<String, Integer>> map){
         Iterator<Integer> iter = map.keySet().iterator();
        while(iter.hasNext()){
            int length = iter.next();
            HashMap<String, Integer> countMap = map.get(length);
            System.out.println("[length : " + length + "]");
            Iterator<String> countIter = countMap.keySet().iterator();
            while(countIter.hasNext()){
                String key = countIter.next();
                System.out.println(key + " : " + countMap.get(key));
            }
            System.out.println();
        }
    }
}
class MenuExtractor{
    
    public void extractSet(String order, HashMap<Integer, HashMap<String, Integer>> map, 
                           HashMap<Integer, Integer> count){
        String[] token = order.split("");
        Arrays.sort(token);
        Queue<String> q = new LinkedList<>();
        q.add("");
        
        for(String s : token){
            int iterNum = q.size();
            for(int i = 0; i<iterNum; i++){
                String nowString = q.poll();
                String append = nowString + s;
                
                q.add(nowString);
                q.add(append);
                
                if(append.length() == 1)
                    continue;
                HashMap<String, Integer> lengthMap = map.get(append.length());
                if(lengthMap == null){
                    lengthMap = new HashMap<>();
                    map.put(append.length(), lengthMap);
                }
                
                if(lengthMap.containsKey(append))
                    lengthMap.put(append, lengthMap.get(append) + 1);
                else
                    lengthMap.put(append, 1);
                
                int orderNum = lengthMap.get(append);
                if(count.get(append.length()) == null)
                    count.put(append.length(), 1);
                if(count.get(append.length()) < orderNum)
                    count.put(append.length(), orderNum);
            }
        }
    }
}