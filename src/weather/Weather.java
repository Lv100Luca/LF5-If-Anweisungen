package weather;

public class Weather {
    private static final String NICE_WEATHER_MESSAGE = "Heute ist ein schöner Tag!";
    private static final String BAD_WEATHER_MESSAGE = "Heute ist es nicht so schön!";
    private static final int NICE_WEATHER_TEMPERATURE = 22;

    public String evaluateWeather(double temperature) {
        if (temperature >= NICE_WEATHER_TEMPERATURE)
            return NICE_WEATHER_MESSAGE;

        return BAD_WEATHER_MESSAGE;
    }
}
