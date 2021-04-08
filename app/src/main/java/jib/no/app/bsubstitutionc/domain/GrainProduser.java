package jib.no.app.bsubstitutionc.domain;

import java.util.ArrayList;
import java.util.HashMap;

public class GrainProduser {
    private HashMap<Integer,String> grain = new HashMap<Integer, String>();

    public void setGrain(int key, String data) {
        grain.put(key, data);
    }

    public boolean isValid(int key) {
        String base = grain.get(key);
        if(base.charAt(0) == '-') return false;
        return true;
    }

    public int size() {
        return grain.size();
    }

    public String getGrain(int key) {
        return grain.get(key);
    }

    public int getGrainIndex(String grainkey) {
        for(int x = 0; x < size(); x++) {
            if(grain.get(x).contains(grainkey)) {
                return x;
            }
        }
        return -1;
    }
}
