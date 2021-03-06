package main.java.aufgabe1;

/*
This class will be extended in the ad-hoc-assignment, and will be used
in future assignments, so it is highly recommended to solve this
assignment.

This class is part of software for ski racing administration.
 */
public class Participation {

    // Assignment 1.1:

    private String race, racer, runtime;
    private int bibnumber, place;

    // A new object constructed by
    //
    //   new Participation("Lienz 2011 Ladies' Slalom", "Mikaela Shiffrin", 40)
    //
    // shall specify the name of the race, the racer, and the bibnumber.
    public Participation(String race, String racer, int bibnumber) {
        this.race = race;
        this.racer = racer;
        this.bibnumber = bibnumber;
    }

    public Participation(String race, String racer, int bibnumber, int place, String runtime) {
        this(race, racer, bibnumber);
        this.place = place;
        this.runtime = runtime;
    }

    // Returns the 'race' of this participation.
    public String getRace() {
        return race;
    }

    // Returns the 'racer' of this participation.
    public String getRacer() {
        return racer;
    }

    // Returns the 'bibnumber' of this participation.
    public int getBibnumber() {
        return bibnumber;
    }

    public int getPlace() {
        return place;
    }

    public String getRuntime() {
        return runtime;
    }

    // Output the following (without newline at the start or end) for
    // the participation created by the constructor call above:
    //
    // 40 Mikaela Shiffrin (Lienz 2011 Ladies' Slalom)
    //
    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return bibnumber + " " + racer + " (" + race + ")";
    }

    // adhoc4
    public String toString(String x, int y) {
        if (race.compareTo(x) <= 0 && bibnumber > y){
            return bibnumber + " " + racer + " (" + race + ")";
        }
        return "";
    }

    public void print1() {
        System.out.print(this);
        if(place == 0 && runtime == null) {
            System.out.println();
            return;
        }

        System.out.println("; " + place + "; " + runtime);
    }

    // In addition to the standard requirements for equals, a
    // participation is equal to another object of class Participation if
    // and only if the 'racer's are equal and the 'race's are equal.
    public boolean equals(Object o) {
        // TODO: implement this method
        if (this == o) return true;
        if (o == null || o.getClass() != Participation.class) return false;

        Participation cmp = (Participation) o;

        return (race.equals(cmp.race) && racer.equals(cmp.racer));
    }

    // Computes a hash code for 'this' that satisfies the requirements for
    // hash codes (see Section 3.1.3 in the Skriptum).
    public int hashCode() {
        // TODO: implement this method
        int m = Integer.MAX_VALUE;
        double A = (Math.sqrt(5) - 1) / 2;
        int k = 0;
        for (char c : (race + racer).toCharArray()) {
            k += c;
        }
        return (int) Math.floor(m * (k * A - Math.floor(k * A)));
    }

    // Question:
    
    // Should there also be setter methods for the object variables?
    // Why or why not?
    // No, because the variables do not need to be changed at the moment.

    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        // TODO: write your own test cases here if necessary.
    }

}
