package jib.no.app.bsubstitutionc.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class YeastChart {
    private String [] brands = { "WYeast", "White Labs", "Danstar/Fermentis" };
    private ArrayList<YeastType> yeast = new ArrayList<YeastType>();

    public YeastChart() {
        yeast.add(new YeastType("German Ale Dusseldorf Alt","1007", true, "WLP036", true, null, false,
                "WLP029 will work, but use more hops than using the other two strains."));
        yeast.add(new YeastType("American Wheat","1010", true, "WLP320", true, null, false,
                "WLP029 will work, but use more hops than using the other two strains."));
        yeast.add(new YeastType("London Ale","1028", true, "WLP013", true, "S04", false, null));
        yeast.add(new YeastType("Chico Strain","1056", true, "WLP001", true, "S05", true,
                "Omega OLY-004 and BRY-97 will probably also work."));
        yeast.add(new YeastType("Irish Ale","1084", true, "WLP004", true, "S04", false, null));
        yeast.add(new YeastType("British Ale","1098", true, "WLP007", true, "S04", false, null));
        yeast.add(new YeastType("Whitebread","1099", true, "WLP017", true, "S04", true, null));
        yeast.add(new YeastType("Ringwood","1187", true, "WLP005", true, "S04", false, null));
        yeast.add(new YeastType("American Ale II/California Ale V","1272", true, "WLP051", true, "S04", false, null));
        yeast.add(new YeastType("Thames Valley Ale/Burton Ale","1275", true, "WLP023", true, "S04", false, null));
        yeast.add(new YeastType("London Ale III","1318", true, null, false, null, false,
                "S04 will work as a substitute, but it isn't exact."));
        yeast.add(new YeastType("Northwest Ale","1332", true, null, false, null, false,
                "S05 is close, but will not produce as clear a beer in the same time frame."));
        yeast.add(new YeastType("British Ale","1187", true, null, false, "S04", false,
                "WLP007 is not that close, but it is a reasonable substitution and will work well."));
        yeast.add(new YeastType("Denny's Favorite","1450", true, null, false, "S05", false,
                "Named for the homebrewer Denny Conn, check him out on his blog Experimental Homebrewing."));
        yeast.add(new YeastType("West Yorkshire","1469", true, null, false, "S04", true,
                "WLP002 can be substituted in with good results."));
        yeast.add(new YeastType("Scottish/Edinburgh","1728", true, "WLP028", true, null, false, null));
        yeast.add(new YeastType("London ESB","1968", true, "WLP002", true, null, false, null));
        yeast.add(new YeastType("Kolsch","2565", true, "WLP003", true, null, false, null));
        yeast.add(new YeastType("Belgian Abbey","1214", true, "WLP500", true, null, false, null));
        yeast.add(new YeastType("Belgian Strong","1388", true, "WLP570", true, null, false, null));
        yeast.add(new YeastType("Belgian Abbey II","1762", true, "WLP540", true, null, false, null));
        yeast.add(new YeastType("Bavarian Wheat Blend","3056", true, null, false, "WB-06", true, null));
        yeast.add(new YeastType("Weihenstephan Weizen","3068", true, "WLP300", true, null, false, null));
        yeast.add(new YeastType("German Wheat","3333", true, "WLP380", true, null, false, null));
        yeast.add(new YeastType("Belgian Ardennes","3522", true, "WLP550", true, null, false, null));
        yeast.add(new YeastType("Bavarian Wheat","3638", true, "WLP351", true, null, false, null));
        yeast.add(new YeastType("French Saison","3711", true, "WLP590", true, "Belle Saison", true, null));
        yeast.add(new YeastType("Belgian Saison","3724", true, "WLP566", true, null, false, null));
        yeast.add(new YeastType("Trappist High Gravity","3787", true, "WLP530", true, null, false, null));
        yeast.add(new YeastType("Belgian Wheat","3942", true, null, false, null, false, null));
        yeast.add(new YeastType("Belgian Witbier","3944", true, "WLP400", true, "T58 or WB-06", true, null));
        yeast.add(new YeastType("Budvar Lager","2000", true, "WLP802", false, "S23", false, null));
        yeast.add(new YeastType("Urqell Lager/Pilsner Lager","2001", true, "WLP800", true, "S23", false, null));
        yeast.add(new YeastType("Pilsen Lager/American Lager","2007", true, "WLP840", true, "W34/70", true, null));
        yeast.add(new YeastType("American Lager","2035", true, "WLP840", false, "W34/70", false, null));
        yeast.add(new YeastType("Danish Lager/Copenhagen Lager","2042", true, "WLP850", true, "W34/70", false, null));
        yeast.add(new YeastType("California Lager/San Fran. Lager","2112", true, "WLP810", true, "S23", false, null));
        yeast.add(new YeastType("Bohemian Lager/German Lager","2142", true, "WLP830", true, "W34/70", false, null));
        yeast.add(new YeastType("Bavarian Lager/Oktoberfest Lager","2206", true, "WLP820", true, "W34/70", false, null));
        yeast.add(new YeastType("Czech Pils","2278", true, "WLP802", false, "W34/70", false, null));
        yeast.add(new YeastType("Munich Lager","2308", true, "WLP838", true, "W34/70", false, null));
        yeast.add(new YeastType("Oktoberfest Blend","2633", true, "WLP833", true, "W34/70", false, null));
    }

    public ArrayList<String> getBrands() {
        return new ArrayList<String>(Arrays.asList(brands));
    }

    public ArrayList<String> getTypesPerBrand(String brand) {
        ArrayList<String> temp = new ArrayList<String>();
        int index = getIndex(brand);
        if(index == -1) {
            return null;
        }
        for(int x = 0; x < yeast.size(); x++) {
            YeastType curr = yeast.get(x);
            if(curr.isMatch(index)) {
                temp.add(curr.getType(index));
            }
        }
        return removeDuplicates(temp);
    }

    public String getTypeName(String brand, String type) {
        int index = getIndex(brand);
        if(index == -1) {
            return null;
        }
        for(int x = 0; x < yeast.size(); x++) {
            YeastType curr = yeast.get(x);
            if(curr.isMatch(index) && type.contentEquals(curr.getType(index))) {
                return curr.getName();
            }
        }
        return null;
    }

    public String getTypeComment(String brand, String type) {
        int index = getIndex(brand);
        if(index == -1) {
            return null;
        }
        for(int x = 0; x < yeast.size(); x++) {
            YeastType curr = yeast.get(x);
            if(curr.isMatch(index) && type.contentEquals(curr.getType(index))) {
                return curr.getComment();
            }
        }
        return null;
    }

    public ArrayList<String> getReplacementTypes(String brand, String type) {
        ArrayList<String> temp = new ArrayList<String>();
        int index = getIndex(brand);
        if(index == -1) {
            return null;
        }
        int peker = 0;
        for(int x = 0; x < yeast.size(); x++) {
            YeastType curr = yeast.get(x);
            if(curr.isMatch(index) && type.contentEquals(curr.getType(index))) {
                peker = x;
            }
        }
        YeastType base = yeast.get(peker);
        for(int x = 0; x < 3; x++) {
            if(index != x) {
                if(base.getType(x) != null) {
                    if (base.isMatch(x)) {
                        temp.add(String.format("%s (%s) Not exact match", base.getType(x), brands[x]));
                    } else {
                        temp.add(String.format("%s (%s)", base.getType(x), brands[x]));
                    }
                }
            }
        }
        if(temp.size() == 0) {
            temp.add("No match found!");
        }
        return temp;
    }

    private int getIndex(String brand) {
        for(int x = 0; x < brands.length; x++) {
            if(brand.contentEquals(brands[x])) {
                return x;
            }
        }
        return -1;
    }

    private ArrayList<String> removeDuplicates(ArrayList<String> list) {
        Set<String> set = new LinkedHashSet<>();
        set.addAll(list);
        list.clear();
        list.addAll(set);
        Collections.sort(list);
        return list;
    }
}
