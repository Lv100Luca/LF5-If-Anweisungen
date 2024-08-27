package horoscope;

import java.util.HashMap;

// todo implement tests for this class
public class HoroscopeGenerator {
    public String getHoroscope(int day, int month) {
        HashMap<Integer, String> horoscopeTenthDays = zehnerstelleMap();
        HashMap<Integer, String> horoscopeDays = einsterstelleMap();
        HashMap<Integer, String> horoscopeMonths = monatsMap();

        var zehnerstelle = getHoroscopeZehnerstelle(day);
        var einsterstelle = getHoroscopeEinerstelle(day);

        var sb = new StringBuilder()
        .append(horoscopeTenthDays.get(zehnerstelle))
        .append(" ")
        .append(horoscopeDays.get(einsterstelle))
        .append(" ")
        .append(horoscopeMonths.get(month));

        return sb.toString();
    }

    private int getHoroscopeZehnerstelle(int day) {
        return (int) day / 10; // use explicit cast
    }

    private int getHoroscopeEinerstelle(int day) {
        return day % 10;
    }

    private HashMap<Integer, String> zehnerstelleMap() {
        var map = new HashMap<Integer, String>();

        map.put(0, "In der Familie");
        map.put(1, "In der Partnerschaft");
        map.put(2, "Im Berufsleben");
        map.put(3, "In der Liebe");

        return map;
    }

    private HashMap<Integer, String> einsterstelleMap() {
        var map = new HashMap<Integer, String>();

        map.put(0, "fehlt Ihnen die Ausdauer.");
        map.put(1, "kündigen sich Veränderungen an.");
        map.put(2, "lassen Erfolge auf sich warten.");
        map.put(3, "neigen Sie zur Bequemlichkeit.");
        map.put(4, "müssen Sie mit unangenehmen Überraschungen rechnen.");
        map.put(5, "sind Sie besonders kreativ.");
        map.put(6, "befinden Sie sich in einer produktiven Phase.");
        map.put(7, "eilen Sie von Erfolg zu Erfolg.");
        map.put(8, "kann es zu einer Auseinandersetzung kommen.");
        map.put(9, "sind Sie besonders aktiv.");

        return map;
    }

    private HashMap<Integer, String> monatsMap() {
        var map = new HashMap<Integer, String>();

        map.put(1, "Machen Sie weiter So");
        map.put(2, "Lassen Sie sich nicht beeinflussen");
        map.put(3, "Hören Sie auf den Rat eines Freundes");
        map.put(4, "Werden Sie nicht übermütig");
        map.put(5, "Seien Sie weniger kritisch");
        map.put(6, "Ab und zu eine Pause einlegen");
        map.put(7, "Suchen Sie eine Aussprache");
        map.put(8, "Denken Sie nicht nur an sich");
        map.put(9, "Nicht immer nur an andere denken");
        map.put(10, "Achten Sie auf Ihre Gesundheit");
        map.put(11, "Geldausgaben verschieben");
        map.put(12, "Idealer Zeitpunkt für einen Neuanfang");

        return map;
    }
}
