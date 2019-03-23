package test.java.classTests;

import main.java.aufgabe1.Participation;
import main.java.aufgabe2.Participations;
import test.java.miniTestSuite.MyClassTest;
import test.java.miniTestSuite.MyMiniTestSuite;
import test.java.miniTestSuite.MyTestInterface;

public class MyParticipationsTest extends MyClassTest implements MyTestInterface {

    @Override
    public boolean run() {
        return testPrint()
            && testLookupRacer();
    }

    private boolean testPrint() {
        print("testPrint()");

        Participations participations = new Participations(100);

        participations.add(new Participation("Kitzbühel", "Marcel Hirscher", 1));
        participations.add(new Participation("Kitzbühel", "Hermann Maier", 2));
        participations.add(new Participation("Kitzbühel", "Benni Raich", 3));

        MyMiniTestSuite.changeOutToFile();
        participations.print();
        return MyMiniTestSuite.assertOutContent("1 Marcel Hirscher (Kitzbühel)\n" +
            "\n" +
            "2 Hermann Maier (Kitzbühel)\n" +
            "\n" +
            "3 Benni Raich (Kitzbühel)" +
            "\n");
    }

    private boolean testLookupRacer() {
        print("testLookupRacer()");

        Participations participations = new Participations(100);
        String lookupName = "Marcel Hirscher";
        Participation lookupParticipation = new Participation("Kitzbühel", "Marcel Hirscher", 1);
        String lookupWrongName = "aldskjfhalsdhflajhsdf";

        participations.add(lookupParticipation);
        participations.add(new Participation("Kitzbühel", "Hermann Maier", 2));
        participations.add(new Participation("Kitzbühel", "Benni Raich", 3));

        return MyMiniTestSuite.assertEquals(participations.lookupRacer(lookupName), lookupParticipation)
            && MyMiniTestSuite.assertEquals(participations.lookupRacer(lookupWrongName), null);
    }
}
