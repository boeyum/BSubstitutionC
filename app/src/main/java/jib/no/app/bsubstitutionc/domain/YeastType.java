package jib.no.app.bsubstitutionc.domain;

public class YeastType {
    private String name = new String();
    private String prod01 = new String();
    private boolean prod01match = true;
    private String prod02 = new String();
    private boolean prod02match = true;
    private String prod03 = new String();
    private boolean prod03match = true;
    private String comment = new String();

    public YeastType(String name, String prod01, boolean prod01match, String prod02, boolean prod02match, String prod03, boolean prod03match, String comment) {
        this.name = name;
        this.prod01 = prod01;
        this.prod01match = prod01match;
        this.prod02 = prod02;
        this.prod02match = prod02match;
        this.prod03 = prod03;
        this.prod03match = prod03match;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public boolean isMatch(int val) {
        switch(val) {
            case 0:return prod01match;
            case 1:return prod02match;
            case 2:return prod03match;
            default:return false;
        }
    }

    public String getType(int val) {
        switch(val) {
            case 0:return prod01;
            case 1:return prod02;
            case 2:return prod03;
            default:return null;
        }
    }
}
