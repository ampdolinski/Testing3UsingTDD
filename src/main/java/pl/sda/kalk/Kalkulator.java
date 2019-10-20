package pl.sda.kalk;

public class Kalkulator {
    public static int dodaj(String liczby) {

        String[] liczbyTab = podzialWprowadzonegoCiaguZnakowNaTabliceLiczb(liczby);

        String liczbyUjemne = "";
        int suma = 0;

        gdyZbiorLiczbJestPusty(liczby, liczbyTab);

        SumowanieLiczbDo1000 sumowanieLiczbDo1000 = new SumowanieLiczbDo1000(liczbyTab, liczbyUjemne, suma).invoke();
        liczbyUjemne = sumowanieLiczbDo1000.getLiczbyUjemne();
        suma = sumowanieLiczbDo1000.getSuma();

        coSieDziejeGdyLiczbyUjemne(liczbyUjemne);

        return suma;
    }

    private static String[] podzialWprowadzonegoCiaguZnakowNaTabliceLiczb(String liczby) {
        return liczby.split("[^\\d-]+");
    }

    private static void gdyZbiorLiczbJestPusty(String liczby, String[] liczbyTab) {
        if (liczby.equals("") || liczbyTab.length == 0) {
            throw new RuntimeException();
        }
    }

    private static void coSieDziejeGdyLiczbyUjemne(String liczbyUjemne) {
        if (!liczbyUjemne.equals("")) {
            throw new RuntimeException("Negatives not allowed: "
                    + liczbyUjemne.substring(0, liczbyUjemne.length() - 1));
        }
    }

    private static class SumowanieLiczbDo1000 {
        private String[] liczbyTab;
        private String liczbyUjemne;
        private int suma;

        public SumowanieLiczbDo1000(String[] liczbyTab, String liczbyUjemne, int suma) {
            this.liczbyTab = liczbyTab;
            this.liczbyUjemne = liczbyUjemne;
            this.suma = suma;
        }

        public String getLiczbyUjemne() {
            return liczbyUjemne;
        }

        public int getSuma() {
            return suma;
        }

        public SumowanieLiczbDo1000 invoke() {
            for (String num : liczbyTab) {
                if (!num.equals("") && Integer.parseInt(num) <= 1000) {
                    if (Integer.parseInt(num) < 0) {
                        liczbyUjemne += num + ", ";
                    }
                    suma += Integer.parseInt(num);
                }
            }
            return this;
        }
    }
}