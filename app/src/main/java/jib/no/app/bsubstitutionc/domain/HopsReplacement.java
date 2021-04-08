package jib.no.app.bsubstitutionc.domain;

import java.util.ArrayList;

public class HopsReplacement {
    private ArrayList<HopsCountry> hopsname = new ArrayList<HopsCountry>();

    public void setHopsname(String name, String country) {
        hopsname.add(new HopsCountry(name,country));
    }

    public int size() {
        return hopsname.size();
    }

    public String getHopsNames(int ix) {
        return hopsname.get(ix).getName();
    }

    public String getHopsCountry(int ix) {
        return hopsname.get(ix).getCountry();
    }
}
