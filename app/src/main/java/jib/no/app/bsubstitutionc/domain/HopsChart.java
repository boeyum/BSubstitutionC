package jib.no.app.bsubstitutionc.domain;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;

public class HopsChart {
    private HashMap<String,HopsReplacement> hops = new HashMap<>();
    private ArrayList<String> nokkel = new ArrayList<String>();
    private String [] type = { "Admiral,GBR","Ahtanum","Amarillo","Aramis,FRA","Bitter Gold","Bramling Cross,GBR","Bravo",
            "Brewer’s Gold","Brewer’s Gold,DEU","Bullion","Cascade","Centennial","Challenger,GBR","Chelan",
            "Chinook","Citra","Cluster","Columbia","Columbus","Comet","Crystal","East Kent Golding,GBR",
            "First Gold,GBR","Fuggle","Fuggle,GBR","Galena","Glacier","Golding","Green Bullet,NZL","Hallertau",
            "Hallertau Mittelfruh,DEU","Helga,AUS","Hersbruker,DEU","Horizon","Liberty","Magnum","Magnum,DEU",
            "Merkur,DEU","Millennium","Motueka,NZL","Mt. Hood","Mt. Rainier","Newport","Northdown,GBR",
            "Northern Brewer","Northern Brewer,DEU","Nugget","Olympic","Opal","Pacific Gem,NZL","Pacifica,NZL",
            "Palisade","Perle","Perle,DEU","Phoenix,GBR","Pilgrim,GBR","Pioneer,GBR","Progress,GBR","Rakau,NZL",
            "Saaz","Saaz,CZE","Santiam","Saphir,DEU","Simcoe","Spalt,DEU","Sterling","Sticklebract,NZL",
            "Strisselpalt,FRA","Styrian Aurora,SVN","Styrian Celeia,SVN","Styrian Bobek,SVN",
            "Styrian Savinjski Golding,SVN","Sylva,AUS","Target,GBR","Taurus,DEU","Tettnang","Tettnang,DEU",
            "Tradition,DEU","Tripleperle","Triskel,FRA","Ultra","Vanguard","Warrior","WGV,GBR","Willamette","Summit","Select,DEU" };
    private int [][] link = {
            {3, 43, 73, 11, 0, 0, 0, 0},
            {1, 10, 0, 0, 0, 0, 0, 0},
            {3, 10, 11, 63, 0, 0, 0, 0},
            {4, 11, 14, 29, 75, 0, 0, 0},
            {2, 25, 46, 0, 0, 0, 0, 0},
            {2, 21, 57, 0, 0, 0, 0, 0},
            {3, 18, 35, 46, 0, 0, 0, 0},
            {3, 14, 25, 46, 0, 0, 0, 0},
            {3, 25, 44, 46, 0, 0, 0, 0},
            {5, 7, 14, 19, 25, 44, 0, 0},
            {3, 1, 2, 11, 0, 0, 0, 0},
            {3, 10, 14, 19, 0, 0, 0, 0},
            {2, 44, 53, 0, 0, 0, 0, 0},
            {2, 25, 46, 0, 0, 0, 0, 0},
            {3, 18, 44, 46, 0, 0, 0, 0},
            {1, 74, 0, 0, 0, 0, 0, 0},
            {1, 25, 0, 0, 0, 0, 0, 0},
            {1, 23, 0, 0, 0, 0, 0, 0},
            {4, 14, 25, 38, 46, 0, 0, 0},
            {2, 25, 85, 0, 0, 0, 0, 0},
            {5, 29, 34, 40, 67, 32, 0, 0},
            {2, 27, 57, 0, 0, 0, 0, 0},
            {2, 20, 21, 0, 0, 0, 0, 0},
            {3, 84, 24, 71, 0, 0, 0, 0},
            {3, 23, 84, 71, 0, 0, 0, 0},
            {3, 7, 18, 46, 0, 0, 0, 0},
            {3, 23, 84, 71, 0, 0, 0, 0},
            {4, 23, 84, 21, 71, 0, 0, 0},
            {2, 23, 84, 0, 0, 0, 0, 0},
            {7, 34, 40, 30, 36, 37, 74, 77},
            {3, 34, 81, 77, 0, 0, 0, 0},
            {1, 29, 0, 0, 0, 0, 0, 0},
            {2, 40, 67, 0, 0, 0, 0, 0},
            {1, 35, 0, 0, 0, 0, 0, 0},
            {3, 29, 40, 77, 0, 0, 0, 0},
            {4, 18, 33, 46, 36, 0, 0, 0},
            {2, 18, 46, 0, 0, 0, 0, 0},
            {3, 35, 74, 77, 0, 0, 0, 0},
            {3, 18, 46, 85, 0, 0, 0, 0},
            {2, 59, 65, 0, 0, 0, 0, 0},
            {3, 67, 30, 32, 0, 0, 0, 0},
            {3, 7, 23, 29, 0, 0, 0, 0},
            {5, 7, 23, 25, 35, 46, 0, 0},
            {2, 44, 12, 0, 0, 0, 0, 0},
            {3, 14, 25, 45, 0, 0, 0, 0},
            {6, 14, 18, 25, 35, 44, 0, 0},
            {3, 18, 25, 35, 0, 0, 0, 0},
            {1, 14, 0, 0, 0, 0, 0, 0},
            {3, 75, 21, 71, 0, 0, 0, 0},
            {1, 25, 0, 0, 0, 0, 0, 0},
            {1, 29, 0, 0, 0, 0, 0, 0},
            {1, 84, 0, 0, 0, 0, 0, 0},
            {3, 44, 45, 53, 0, 0, 0, 0},
            {2, 44, 52, 0, 0, 0, 0, 0},
            {2, 43, 12, 0, 0, 0, 0, 0},
            {2, 73, 12, 0, 0, 0, 0, 0},
            {1, 21, 0, 0, 0, 0, 0, 0},
            {2, 23, 21, 0, 0, 0, 0, 0},
            {2, 2, 85, 0, 0, 0, 0, 0},
            {2, 65, 60, 0, 0, 0, 0, 0},
            {2, 65, 59, 0, 0, 0, 0, 0},
            {3, 64, 76, 86, 0, 0, 0, 0},
            {1, 29, 0, 0, 0, 0, 0, 0},
            {2, 35, 85, 0, 0, 0, 0, 0},
            {2, 59, 85, 0, 0, 0, 0, 0},
            {1, 60, 0, 0, 0, 0, 0, 0},
            {1, 45, 0, 0, 0, 0, 0, 0},
            {3, 20, 34, 40, 0, 0, 0, 0},
            {2, 70, 71, 0, 0, 0, 0, 0},
            {3, 59, 70, 71, 0, 0, 0, 0},
            {1, 71, 0, 0, 0, 0, 0, 0},
            {3, 23, 24, 70, 0, 0, 0, 0},
            {1, 60, 0, 0, 0, 0, 0, 0},
            {2, 23, 84, 0, 0, 0, 0, 0},
            {3, 15, 35, 77, 0, 0, 0, 0},
            {3, 23, 61, 64, 0, 0, 0, 0},
            {4, 59, 32, 64, 86, 0, 0, 0},
            {2, 34, 30, 0, 0, 0, 0, 0},
            {1, 52, 0, 0, 0, 0, 0, 0},
            {4, 1, 11, 14, 63, 0, 0, 0},
            {1, 29, 0, 0, 0, 0, 0, 0},
            {4, 29, 34, 40, 32, 0, 0, 0},
            {3, 18, 35, 46, 0, 0, 0, 0},
            {2, 21, 57, 0, 0, 0, 0, 0},
            {4, 23, 26, 75, 71, 0, 0, 0},
            {4, 18, 38, 63, 82, 0, 0, 0},
            {5, 59, 75, 32, 64, 76, 0, 0}
    };

    public HopsChart() {
        for(int x = 0; x < type.length; x++) {
            int len = link[x][0];
            HopsReplacement temp = new HopsReplacement();
            for(int y = 0; y < len; y++) {
                temp.setHopsname(nameParse(type[link[x][y+1]]),countryParse(type[link[x][y+1]]));
            }
            add(type[x],temp);
        }
    }

    public void add(String key, HopsReplacement hop) {
//        System.out.println(String.format("******* Nokkel = %s ********",key));
        nokkel.add(key);
        hops.put(key,hop);
    }

    public ArrayList<String> getKeySet() {
        return nokkel;
    }

    public ArrayList<String> getHopsReplacement(String key) {
        HopsReplacement rep = hops.get(key);
        ArrayList<String> temp = new ArrayList<String>();
        for(int x = 0; x < rep.size(); x++) {
            if(rep.getHopsCountry(x) != null) {
                temp.add(String.format("%s (%s)",rep.getHopsNames(x),rep.getHopsCountry(x)));
            } else {
                temp.add(String.format("%s",rep.getHopsNames(x)));
            }
        }
        return temp;
    }

    private String nameParse(String kode) {
        String [] base = kode.split(",");
        return base[0];
    }

    private String countryParse(String kode) {
        String [] base = kode.split(",");
        if(base.length == 1) return null;
        return base[1];
    }
}
