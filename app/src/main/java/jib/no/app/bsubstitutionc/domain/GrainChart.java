package jib.no.app.bsubstitutionc.domain;

import java.util.ArrayList;
import java.util.HashMap;

public class GrainChart {
    private String [] prod00 = { "2-Row Pale","Pale Ale","-","Ashburne","Bonlander","Vienna,Munich 10","Dextrine","Victory,Crystal 10",
            "Crystal 20","Crystal 30","Crystal 40","Crystal 60","Crystal 80","Crystal 90",
            "Crystal 120","-","Special Roast","Extra Special","-","Chocolate","Black Patent","Roasted Barley",
            "-","Wheat","-","-","-","Rye Malt","-","-","-","-" };
    private String [] prod01 = { "Pilsen","Pale Ale","Stout Malt","Mild Ale","Munich","-","Munich","-","Amber",
            "Caramalt","-","-","Light Crystal","Medium Crystal","Dark Crystal","Dark Crystal",
            "-","-","-","-","-","Chocolate","Black Malt","Roasted Barley","-","-","-","-","-","-","-","-","-","-" };
    private String [] prod02 = { "Lager","Pale Ale","-","Mild Ale","-","-","-","-","-","Carapils","-","-","-","-",
            "-","-","Dark Crystal","-","-","-","-","Chocolate","Black Patent","Roasted Barley",
            "-","-","-","-","-","-","-","-","-","-" };
    private String [] prod03 = { "Lager","Pale Ale","-","Mild Ale","-","-","-","-","-","Carapils","-","-","-","-",
            "-","-","Dark Crystal","-","-","-","-","Chocolate","Black Patent","Roasted Barley",
            "-","-","-","-","-","-","-","-","-","-" };
    private String [] prod04 = { "Pilsner,Premium Pilsner","Pale Ale","-","Vienna","Munich I","Vienna","Munich II",
            "CaraPils","Melanoidin","CaraHell/(CaraBelge)","CaraRed","CaraMunich I,CaraAmber",
            "CaraMunich II","CaraMunich III","-","-","CaraAroma,Special W","CaraAroma","-","-",
            "Carafa (Special) I","Carafa (Special) II","Carafa (Special) III","Roasted Barley",
            "Chocolate Wheat","Wheat","Dark Wheat","Carawheat","Roasted Rye","Rye Malt","Caramel Rye Malt",
            "-","Acidulated Malt","Smoked Malt" };
    private String [] prod05 = { "-","Pale Ale","-","-","-","Vienna","-","-","-","Light Carastan","-","Carastan","Carastan",
            "-","Crystal Malt","-","Dark Crystal","Dark Crystal","Brown Malt","-","-","Chocolate","Black Malt",
            "Roasted Barley","-","-","-","-","-","-","-","-","-","-" };
    private String [] prod06 = { "Pilsen","-","-","Vienna","Munich","Vienna","Munich","-","-","Light Caramel","-","-",
            "Medium Caramel","Dark Caramel","-","-","-","-","-","-","-","-","Roasted Malt","-","-",
            "Wheat","-","-","-","-","-","-","Acid Malt","-" };
    private String [] prod07 = { "2Pilsen","Pale Ale","-","-","Munich","-","Munich","-","Biscuit,Aromatic","Carapils",
            "CaraVienne","-","-","Caramunich","Dark Caramunich","-","Special B","-","-","-","-",
            "Chocolate","Black Malt","Black Barley","Roasted Wheat","Wheat","-","-","-","-","-",
            "-","-","-" };
    private String [] prod08 = { "Pilsen","Pale Ale","-","Sp.Aromatic","Munich","Vienna","Dark Munich","-","Kiln Amber",
            "Caramel Pilsen","Caramel Vienna","Caramel Amber","Caramel Munich 40","Caramel Munich 60",
            "Caramel Munich 80","-","Caramel Munich 120","-","Kiln Amber","Kiln Coffee","-","Chocolate",
            "Kiln Black","-","Roasted Wheat","Wheat","Dark Wheat","Caramel Wheat","Roasted Rye","-",
            "-","-","-","-" };
    private String [] producer = {"Briess","Pauls","Muntons","Fawcett","Weyerman","Baird","Weissheimer","DWC","MFB"};
    private HashMap<String, GrainProduser> grain = new HashMap<String, GrainProduser>();
    private GrainProduser GP;

    public GrainChart() {
        for(int x = 0; x < producer.length; x++) {
            GP = new GrainProduser();
            for(int y = 0; y < prod00.length; y++) {
                if(x == 0) {
                    GP.setGrain(y, prod00[y]);
                } else if(x == 1) {
                    GP.setGrain(y, prod01[y]);
                } else if(x == 2) {
                    GP.setGrain(y, prod02[y]);
                } else if(x == 3) {
                    GP.setGrain(y, prod03[y]);
                } else if(x == 4) {
                    GP.setGrain(y, prod04[y]);
                } else if(x == 5) {
                    GP.setGrain(y, prod05[y]);
                } else if(x == 6) {
                    GP.setGrain(y, prod06[y]);
                } else if(x == 7) {
                    GP.setGrain(y, prod07[y]);
                } else {
                    GP.setGrain(y, prod08[y]);
                }
            }
            grain.put(producer[x], GP);
        }
    }

    public String[] getProdusers() {
        return  producer;
    }

    public ArrayList<String> getPerProduser(String prodkey) {
        ArrayList<String> temp = new ArrayList<String>();
        GrainProduser gp = grain.get(prodkey);
        for(int x = 0; x < gp.size(); x++) {
            if(gp.isValid(x)) {
                String post = gp.getGrain(x);
                String[] base = post.split(",");
                if(base.length > 1) {
                    for(int y = 0; y < base.length; y++) {
                        temp.add(base[y]);
                    }
                } else {
                    temp.add(post);
                }
            }
        }
        return temp;
    }

    public ArrayList<String> getSubstitutes(String prodkey, String grainkey) {
        ArrayList<String> temp = new ArrayList<String>();
        int index = grain.get(prodkey).getGrainIndex(grainkey);
        if(index == -1) {
            return null;
        }
        for(int x = 0; x < producer.length; x++) {
            String post = grain.get(producer[x]).getGrain(index);
            if(post.charAt(0) != '-') {
                String[] base = post.split(",");
                String prod = String.format("(%s)", producer[x]);
                String sjekk = String.format("%-20s", prod);
                if (base.length > 1) {
                    for (int y = 0; y < base.length; y++) {
                        if(!prodkey.contentEquals(prod) && !grainkey.contentEquals(base[y])) {
                            temp.add(String.format("%s %s", sjekk, base[y]));
                        }
                    }
                } else {
                    if(!prodkey.contentEquals(prod) && !grainkey.contentEquals(post)) {
                        temp.add(String.format("%s %s", sjekk, post));
                    }
                }
            }
        }
        return temp;
    }
}
