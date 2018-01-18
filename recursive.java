import java.util.*;
import java.util.ArrayList;
import java.util.List;


class InputEntry{
    private int n;
    private int temp;
    private HashMap<Integer, Integer> map;
    Scanner sc=new Scanner(System.in);
    InputEntry(){
        n = sc.nextInt();
        // values = new int[n];
        map = new HashMap<>();
        for(int i=0;i<n;i++){
            temp = sc.nextInt();
            if(map.containsKey(temp)){
                int val = map.get(temp);
                map.put(temp,++val);
            }else
                map.put(temp,1);
        }
    }
    public HashMap<Integer, Integer> problemBreakStepFirst(){
        return map;
    }
}
class RecursiveProgramMainLogicBuilder{
    public int recurciveExecutor(HashMap<Integer,Integer> map,boolean returnCondition){
        System.out.println(map);
        if(returnCondition){
            int total=0;
            for(int key:map.keySet())
                total += map.get(key);
            
            return total;
        }
        HashMap<Integer,Integer> maptemp = new HashMap<>();
        for (int key : map.keySet()) {
            int val = map.get(key);
            if(maptemp.containsKey(val)){
                int valtemp = maptemp.get(val);
                maptemp.put(val,++valtemp);
            }else
                maptemp.put(val,1);
        }
        map.clear();
        Set<Integer> tempSet = new HashSet<Integer>(maptemp.values());
        if(tempSet.size()==maptemp.size())
            return recurciveExecutor(maptemp,true);
        else
            return recurciveExecutor(maptemp,false);
    }
}
public class recursive{
    public static void main(String args[]){
        InputEntry inputEntry = new InputEntry();
        RecursiveProgramMainLogicBuilder recursiveProgramMainLogicBuilder = new RecursiveProgramMainLogicBuilder();
        System.out.println(recursiveProgramMainLogicBuilder.recurciveExecutor(inputEntry.problemBreakStepFirst(),false));
        
    }
}
