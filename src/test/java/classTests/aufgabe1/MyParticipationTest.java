package test.java.classTests.aufgabe1;

import main.java.aufgabe1.Participation;
import test.java.miniTestSuite.MyClassTest;
import test.java.miniTestSuite.MyMiniTestSuite;
import test.java.miniTestSuite.MyTestInterface;

public class MyParticipationTest extends MyClassTest implements MyTestInterface {

    @Override
    public boolean run() {
        return testGetters()
            && testExtendedGetters()
            && testPrint()
            && testPrint1()
            && testEquals()
            && testHashCode();
    }

    private boolean testGetters() {
        print("testGetters()");
        String racer = "Mikaela Shiffrin";
        String race = "Lienz 2011 Ladies' Slalom";
        int bibnumber = 40;
        Participation testParticipation = new Participation(race, racer, bibnumber);

        return testPassed(MyMiniTestSuite.assertEquals(racer, testParticipation.getRacer())
            && MyMiniTestSuite.assertEquals(race, testParticipation.getRace())
            && MyMiniTestSuite.assertEquals(bibnumber, testParticipation.getBibnumber()));
    }

    private boolean testExtendedGetters() {
        print("testExtendedGetters()");
        String racer = "Mikaela Shiffrin";
        String race = "Lienz 2011 Ladies' Slalom";
        int bibnumber = 40;
        int place = 3;
        String runtime = "IncredibleTime";
        Participation testParticipation = new Participation(race, racer, bibnumber, place, runtime);

        return testPassed(MyMiniTestSuite.assertEquals(racer, testParticipation.getRacer())
            && MyMiniTestSuite.assertEquals(race, testParticipation.getRace())
            && MyMiniTestSuite.assertEquals(bibnumber, testParticipation.getBibnumber())
            && MyMiniTestSuite.assertEquals(place, testParticipation.getPlace())
            && MyMiniTestSuite.assertEquals(runtime, testParticipation.getRuntime()));
    }

    private boolean testPrint() {
        print("testPrint()");
        String racer = "Mikaela Shiffrin";
        String race = "Lienz 2011 Ladies' Slalom";
        int bibnumber = 40;
        Participation testParticipation = new Participation(race, racer, bibnumber);

        MyMiniTestSuite.changeOutToFile();
        testParticipation.print();
        return testPassed(MyMiniTestSuite.assertOutContent("40 Mikaela Shiffrin (Lienz 2011 Ladies\' Slalom)"));
    }

    private boolean testPrint1() {
        print("testPrint1()");

        String racer = "Mikaela Shiffrin";
        String race = "Lienz 2011 Ladies' Slalom";
        int bibnumber = 40;
        int place = 3;
        String runtime = "IncredibleTime";
        Participation testParticipation = new Participation(race, racer, bibnumber);
        Participation testParticipation2 = new Participation(race, racer, bibnumber, place, runtime);

        MyMiniTestSuite.changeOutToFile();
        testParticipation.print();
        boolean emptyElement = MyMiniTestSuite.assertOutContent("40 Mikaela Shiffrin (Lienz 2011 Ladies\' Slalom)");

        MyMiniTestSuite.changeOutToFile();
        testParticipation2.print1();
        boolean filledElement = MyMiniTestSuite.assertOutContent("40 Mikaela Shiffrin (Lienz 2011 Ladies' Slalom); " +
            "3; IncredibleTime");

        return testPassed(emptyElement
            && filledElement);
    }

    private boolean testEquals() {
        print("testEquals()");
        String racer = "Mikaela Shiffrin";
        String race = "Lienz 2011 Ladies' Slalom";
        String racer2 = "Hermann Meier";
        int bibnumber = 40;
        Participation x = new Participation(race, racer, bibnumber);
        Participation y = new Participation(race, racer, bibnumber);
        Participation z = new Participation(race, racer, bibnumber);
        Participation a = new Participation(race, racer2, bibnumber);

        return testPassed(
            MyMiniTestSuite.assertFalse(x.equals(null))
            && MyMiniTestSuite.assertTrue(x.equals(x))
            && MyMiniTestSuite.assertTrue(x.equals(y))
            && MyMiniTestSuite.assertTrue(y.equals(z))
            && MyMiniTestSuite.assertTrue(x.equals(z))
            && MyMiniTestSuite.assertFalse(x.equals(a))
        );
    }

    private boolean testHashCode() {
        print("testHashCode()");
        String racer = "Mikaela Shiffrin";
        String race = "Lienz 2011 Ladies' Slalom";
        int bibnumber = 40;
        Participation x = new Participation(race, racer, bibnumber);
        Participation y = new Participation(race, racer, bibnumber);

        int xHash = x.hashCode();
        System.out.println(xHash);

        return testPassed(
                MyMiniTestSuite.assertTrue(x.equals(y))
                && MyMiniTestSuite.assertEquals(x.hashCode(), y.hashCode())
                && MyMiniTestSuite.assertEquals(x.hashCode(), xHash)
        );
    }
}
