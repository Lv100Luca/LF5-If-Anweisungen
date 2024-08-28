package trainInByteburg;

import java.util.ArrayList;
import java.util.List;

public class TicketCalculator {
    private static final int BASE_PRICE = 2;
    private static final int ZONE_CROSSING_PRICE = 1;
    private static final int NEIGHBOURED_STATION_PRICE = 1;
    private static final int TERMINAL_STATION_PRICE = 1;

    private static final int ZONE_BORDER_STATION_NUMBER = 3;
    private static final int TERMINAL_STATION_NUMBER = 6;
    private static final int CENTER_STATION_NUMBER = 0;

    private static final ArrayList<Integer> availableLines = new ArrayList<>(
            List.of(1, 2, 3, 4, 5)
    );

    private static final ArrayList<Integer> availableStations = new ArrayList<>(
            List.of(0, 1, 2, 3, 4, 5, 6));

    private int startLineNumber;
    private int exitLineNumber;
    private int startStationNumber;
    private int exitStationNumber;

    private void init(int startRailwayStation, int exitRailwayStation) {
        startLineNumber = getLineNumber(startRailwayStation);
        exitLineNumber = getLineNumber(exitRailwayStation);
        startStationNumber = getStationNumber(startRailwayStation);
        exitStationNumber = getStationNumber(exitRailwayStation);
    }

    public int calculateTicketprice(int startRailwayStation, int exitRailwayStation) {
        init(startRailwayStation, exitRailwayStation);

        if (!isValidStation(startRailwayStation) || !isValidStation(exitRailwayStation))
            return -1;

        if (isNeighbouredStation()) {
            System.out.println("Using price for neighboured station");
            return NEIGHBOURED_STATION_PRICE;
        }

        var price = BASE_PRICE;

        var nrOFZoneBorderCrossings = getNrOfZoneBorderCrossings(startRailwayStation, exitRailwayStation);

        System.out.println("Adding " + nrOFZoneBorderCrossings + " to price for border crossings");

        price += nrOFZoneBorderCrossings;

        var nrOfUsedTerminalStations = getNrOfUsedTerminalStations();
        System.out.println("Adding " + nrOfUsedTerminalStations + " to price use of terminal stations");

        price += nrOfUsedTerminalStations * TERMINAL_STATION_PRICE;

        return price;
    }

    private boolean isNeighbouredStation() {
        if (isSameLine() && getDistance() == 1)
            return true;

        var isCircleStation = startStationNumber == ZONE_BORDER_STATION_NUMBER ||
                exitStationNumber == ZONE_BORDER_STATION_NUMBER;

        if (!isCircleStation)
            return false;

        var startLineNormalized = startLineNumber - 1;
        var exitLineNormalized = exitLineNumber - 1;

        return ((startLineNormalized + availableLines.size()) + 1) % availableLines.size() == exitLineNormalized ||
                ((startLineNormalized + availableLines.size()) - 1) % availableLines.size() == exitLineNormalized;
    }

    private boolean isSameLine() {
        if (startStationNumber == CENTER_STATION_NUMBER || exitStationNumber == CENTER_STATION_NUMBER)
            return true;

        return startLineNumber == exitLineNumber;
    }

    private static int getLineNumber(int station) {
        return (int) station / 10;
    }

    private static int getStationNumber(int station) {
        return station % 10;
    }

    private int getNrOfZoneBorderCrossings(int startStation, int exitStation) {
        if (startLineNumber == exitLineNumber) { // if journey doesnt not cross center station
            if (isCrossingZoneBorder(startStation, exitStation))
                return 1;
            return 0;
        }

        // journey crosses center station
        var zoneCrossings = 0;

        if (isCrossingZoneBorder(startStation, CENTER_STATION_NUMBER))
            zoneCrossings++;

        if (isCrossingZoneBorder(exitStation, CENTER_STATION_NUMBER))
            zoneCrossings++;


        return zoneCrossings;
    }

    private static boolean isCrossingZoneBorder(int startStation, int exitStation) {
        var start = getStationNumber(startStation);
        var end = getStationNumber(exitStation);

        var movingOutwards = start < end;

        if (movingOutwards) {
            return start <= ZONE_BORDER_STATION_NUMBER && ZONE_BORDER_STATION_NUMBER < end;
        }

        return start > ZONE_BORDER_STATION_NUMBER && ZONE_BORDER_STATION_NUMBER >= end;
    }

    private boolean numberIsBetween(int number, int boundA, int boundB) {
        return number >= boundA && number <= boundB || number <= boundA && number >= boundB;
    }

    private int getNrOfUsedTerminalStations() {
        var terminalStationsUsed = 0;

        if (startStationNumber == TERMINAL_STATION_NUMBER)
            terminalStationsUsed++;

        if (exitStationNumber == TERMINAL_STATION_NUMBER)
            terminalStationsUsed++;

        return terminalStationsUsed;
    }

    private int getDistance() {
        return Math.abs(startStationNumber - exitStationNumber);
    }

    private boolean isValidStation(int station) {
        var lineNumber = getLineNumber(station);
        var stationNumber = getStationNumber(station);

        if (lineNumber == CENTER_STATION_NUMBER && stationNumber == CENTER_STATION_NUMBER)
            return true;

        return isStationValid(stationNumber) && isLineValid(lineNumber);
    }

    private boolean isStationValid(int station) {
        for (int stationNumber : availableStations) {
            if (stationNumber == station) {
                return true;
            }
        }

        return false;
    }

    private boolean isLineValid(int line) {
        for (int lineNumber : availableLines) {
            if (lineNumber == line) {
                return true;
            }
        }
        return false;
    }
}