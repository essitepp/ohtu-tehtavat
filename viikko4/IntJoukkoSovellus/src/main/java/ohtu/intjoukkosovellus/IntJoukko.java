package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            System.out.println("Kapasiteetin oltava positiivinen");
            return;
        }
        if (kasvatuskoko <= 0) {
            System.out.println("Kasvatuskoon oltava positiivinen");
            return;
        }
        ljono = new int[kapasiteetti];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {
        if (kuuluu(luku)) {
            return false;
        }
        ljono[alkioidenLkm] = luku;
        alkioidenLkm++;
        if (alkioidenLkm == ljono.length) {
            laajenna();
        }
        return true;
    }

    private void laajenna() {
        int[] uusi = new int[ljono.length + kasvatuskoko];
        for (int i = 0; i < ljono.length; i++) {
            uusi[i] = ljono[i];
        }
        ljono = uusi;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (ljono[i] == luku) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        if (!kuuluu(luku)) {
            return false;
        }
        int indeksi = etsiIndeksi(luku);
        alkioidenLkm--;
        for (int i = indeksi; i < alkioidenLkm; i++) {
            ljono[i] = ljono[i + 1];
        }
        ljono[alkioidenLkm] = 0;
        return true;
    }

    private int etsiIndeksi(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (ljono[i] == luku) {
                return i;
            }
        }
        return -1;
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        String tuotos = "{";
        for (int i = 0; i <= alkioidenLkm - 1; i++) {
            tuotos += ljono[i];
            if (i < alkioidenLkm - 1) {
                tuotos += ", ";
            }
        }
        tuotos += "}";
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko(a.alkioidenLkm + b.alkioidenLkm);
        for (int i = 0; i < a.alkioidenLkm; i++) {
            yhdiste.lisaa(a.ljono[i]);
        }
        for (int i = 0; i < b.alkioidenLkm; i++) {
            yhdiste.lisaa(b.ljono[i]);
        }
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko(a.alkioidenLkm);
        for (int i = 0; i < a.alkioidenLkm; i++) {
            if (b.kuuluu(a.ljono[i])) {
                leikkaus.lisaa(a.ljono[i]);
            }
        }
        return leikkaus;
    }
    
    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko(a.alkioidenLkm);
        for (int i = 0; i < a.alkioidenLkm; i++) {
            if (!b.kuuluu(a.ljono[i])) {
                erotus.lisaa(a.ljono[i]);
            }
        }
        return erotus;
    }
}
