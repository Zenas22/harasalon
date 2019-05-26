public class Stylist {
    private String firstJina,secondJina,baruaPepe;
    private int umri,id;

    public String getFirstJina() {
        return firstJina;
    }

    public String getSecondJina() {
        return secondJina;
    }

    public String getBaruaPepe() {
        return baruaPepe;
    }

    public int getUmri() {
        return umri;
    }

    public int getId() {
        return id;
    }

    public Stylist(int id,String firstJina, String secondJina, String baruaPepe, int umri) {
        this.firstJina = firstJina;
        this.secondJina = secondJina;
        this.baruaPepe = baruaPepe;
        this.umri = umri;
        this.id = id;
    }
}