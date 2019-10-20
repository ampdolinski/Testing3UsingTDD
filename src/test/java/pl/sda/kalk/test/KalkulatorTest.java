package pl.sda.kalk.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.sda.kalk.Kalkulator;

public class KalkulatorTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Ignore
    @Test(expected = RuntimeException.class)
    public void nieWiecejNizDwieLiczby() {
        Kalkulator.dodaj("1,2,3");
    }

    @Ignore
    @Test
    public void pustyTekstDajeZero() {
        Assert.assertEquals(0, Kalkulator.dodaj(""));
    }

    @Test
    public void zwracaSume2WprowadzonychLiczb() {
        Assert.assertEquals(10, Kalkulator.dodaj("5,5"));

    }

    @Test
    public void dozwracaSume1WprowadzonejLiczby() {
        Assert.assertEquals(60, Kalkulator.dodaj("20,20,20"));
    }

    @Test(expected = RuntimeException.class)
    public void niezerowaIloscLiczb() {
        Kalkulator.dodaj("");
    }

    @Ignore
    @Test
    public void dozwoloneZnakiNowejLinii() {
        Assert.assertEquals(10, Kalkulator.dodaj("5\n,\n5"));
    }

    @Test
    public void dozwoloneZnaki() {
        Assert.assertEquals(3, Kalkulator.dodaj("//;\n1;2"));
    }

    @Test
    public void niedozwoloneLiczbyUjemne1() {
        exception.expect(RuntimeException.class);
        exception.expectMessage("-5");
        Kalkulator.dodaj("-5, 5");
    }

    @Test
    public void wiekszeNiz1000Ignorowane(){
        Assert.assertEquals(1020, Kalkulator.dodaj("1,1001,19,1000"));
    }

    @Test
    public void dozwoloneZnaki2() {
        Assert.assertEquals(10, Kalkulator.dodaj("!!1\n,!!2,!!,3,!!4"));
    }

    @Test
    public void dozwoloneZnaki3() {
        Assert.assertEquals(11, Kalkulator.dodaj("//ppp\n2,2ppp2ppp2\n1,2"));
    }

    @Test
    public void wieleSeparatorow() {
        Assert.assertEquals(6, Kalkulator.dodaj("//{%\n1{2%3"));
    }

    @Test
    public void wieleSeparatorow2() {
        Assert.assertEquals(6, Kalkulator.dodaj("//{%\n1{2%3"));
    }

    @Test
    public void wieleSeparatorow3() {
        Assert.assertEquals(6, Kalkulator.dodaj("//:::%%\n1:::2%%3"));
    }
}