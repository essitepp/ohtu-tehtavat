
package ohtu;

public class Player implements Comparable<Player>{
    private String name;
    private String team;
    private int goals;
    private int assists;
    private String nationality;

    public String getNationality() {
        return nationality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public int getPoints() {
        return this.goals + this.assists;
    }

    @Override
    public String toString() {
        return name + "\t" + team + "\t" + goals + 
                " + " + assists + " = " + getPoints();
    }

    @Override
    public int compareTo(Player t) {
        return t.getPoints() - this.getPoints();
    }
      
}
