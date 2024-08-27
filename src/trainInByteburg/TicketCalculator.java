package trainInByteburg;

public class TicketCalculator {
    private static final int BASE_PRICE = 2;
    private static final int ZONE_CROSSING_PRICE = 1;
    private static final int NEIGHBOURED_STATION_PRICE = 1;
    private static final int TERMINAL_STATION_PRICE = 1;

    private static final int ZONE_BORDER_STATION_NUMBER = 3;
    private static final int TERMINAL_STATION_NUMBER = 6;
    private static final int CENTER_STATION_NUMBER = 0;

    private static final int[] availableLines = {1, 2, 3, 4, 5};

    public static void main(String[] args) {
    }

    public int calculateTicketprice(int startRailwayStation, int exitRailwayStation) {
        if (!isValidStation(startRailwayStation) || !isValidStation(exitRailwayStation))
            return -1;

        if (isNeighbouredStation(startRailwayStation, exitRailwayStation)) {
            System.out.println("Using price for neighboured station");
            return NEIGHBOURED_STATION_PRICE;
        }

        var price = BASE_PRICE;

        var nrOFZoneBorderCrossings = getNrOfZoneBorderCrossings(startRailwayStation, exitRailwayStation);

        System.out.println("Adding " + nrOFZoneBorderCrossings + " to price");

        price += nrOFZoneBorderCrossings;

        var nrOfUsedTerminalStations = getNrOfUsedTerminalStations(startRailwayStation, exitRailwayStation);
        System.out.println("Adding " + nrOfUsedTerminalStations + " to price");

        price += nrOfUsedTerminalStations * TERMINAL_STATION_PRICE;

        return price;
    }

    private static boolean isNeighbouredStation(int startStation, int exitStation) {
        var startLineNumber = getLineNumber(startStation);
        var exitLineNumber = getLineNumber(exitStation);
        var startStationNumber = getStationNumber(startStation);
        var exitStationNumber = getStationNumber(exitStation);

        if (isSameLine(startStation, exitStation))
            // check if the distance is 1
            return getDistance(startStation, exitStation) == 1;

        var isCircleStation = startStationNumber == ZONE_BORDER_STATION_NUMBER ||
                exitStationNumber == ZONE_BORDER_STATION_NUMBER;

        if (!isCircleStation)
            return false;

        var startLineNormalized = startLineNumber - 1;
        var exitLineNormalized = exitLineNumber - 1;

        if (startLineNumber == 1 && exitLineNumber == availableLines.length) {
            System.out.println("special case for traveling from first line to the last line over station 3"); // todo fixme
            return true;
        }


        return (startLineNormalized + 1) % availableLines.length == exitLineNormalized ||
                (startLineNormalized - 1) % availableLines.length == exitLineNormalized;
    }

    private static boolean isSameLine(int startStation, int exitStation) {
        if (getLineNumber(startStation) == CENTER_STATION_NUMBER || getLineNumber(exitStation) == CENTER_STATION_NUMBER)
            return true;

        return getLineNumber(startStation) == getLineNumber(exitStation);
    }

    private static int getLineNumber(int station) {
        return (int) station / 10;
    }

    private static int getStationNumber(int station) {
        return station % 10;
    }

    private static int getNrOfZoneBorderCrossings(int startStation, int exitStation) {
        var startLineNumber = getLineNumber(startStation);
        var exitLineNumber = getLineNumber(exitStation);

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

    private static boolean numberIsBetween(int number, int boundA, int boundB) {
        return number >= boundA && number <= boundB || number <= boundA && number >= boundB;
    }

    private static int getNrOfUsedTerminalStations(int startStation, int exitStation) {
        var startStationNumber = getStationNumber(startStation);
        var exitStationNumber = getStationNumber(exitStation);

        var terminalStationsUsed = 0;

        if (startStationNumber == TERMINAL_STATION_NUMBER)
            terminalStationsUsed++;

        if (exitStationNumber == TERMINAL_STATION_NUMBER)
            terminalStationsUsed++;

        return terminalStationsUsed;
    }

    private static int getDistance(int startStation, int exitStation) {
        return Math.abs(getStationNumber(startStation) - getStationNumber(exitStation));
    }

    private static boolean isValidStation(int station) {
        var lineNumber = getLineNumber(station);
        var stationNumber = getStationNumber(station);

        if (lineNumber == CENTER_STATION_NUMBER && stationNumber == CENTER_STATION_NUMBER)
            return true;

        var lineNumberValid = lineNumber > 0 && lineNumber <= availableLines.length;
        var stationNumberValid = stationNumber >= 0 && stationNumber <= 6;

        return lineNumberValid && stationNumberValid;
    }
}