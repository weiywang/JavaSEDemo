package HuaWei.Answer3;

import java.util.Map;
import java.util.TreeMap;

public class PlantFactory {
    private static Map<String, Plant> map = new TreeMap<>();

    public static Plant getPlant(String id){
        if(map.containsKey(id)){
            return map.get(id);
        }else{
            Plant p = new Plant(id);
            map.put(id, p);
            return p;
        }
    }


    public static Map<String, Plant> getMap() {
        return map;
    }
}
