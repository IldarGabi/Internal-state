package newRadio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {

    //    change stations

    @Test
    void checkWorkTests() {
        Radio stations = new Radio(8, 9,10,0,100, 0);
        stations.setMinVolume(0);
        stations.setMaxVolume(100);
        stations.setMinRadioStation(0);
        stations.setMaxRadioStation(10);
        stations.setCurrentRadioStationNumber(8);
        stations.setCurrentVolume(9);
        assertEquals(0, stations.getMinVolume());
        assertEquals(100, stations.getMaxVolume());
        assertEquals(0, stations.getMinRadioStation());
        assertEquals(10, stations.getMaxRadioStation());
        assertEquals(8,stations.getCurrentRadioStationNumber());
        assertEquals(9,stations.getCurrentVolume());
    }

    @Test
    void changeOnNextRadioStations() {
        Radio stations = new Radio(8, 9, 10, 0, 100, 0);
        stations.changeOnNextRadioStations();
        long expected = 9;
        assertEquals(expected, stations.getCurrentRadioStationNumber());
        System.out.println(expected);
    }

    @Test
    void changeOnPrevRadioStations() {
        Radio stations = new Radio(7, 10, 10, 0, 100, 0);
        stations.changeOnPrevRadioStations();
        long expected = 6;
        assertEquals(expected, stations.getCurrentRadioStationNumber());
        System.out.println(expected);
    }

    @Test
    void nextAfterLastRadioStations() {
        Radio stations = new Radio(10, 9,10, 0, 100, 0);
        stations.changeOnNextRadioStations();
        long expected = 0;
        assertEquals(expected, stations.getCurrentRadioStationNumber());
        System.out.println(expected);
    }

    @Test
    void prevAfterFirstRadioStations() {
        Radio stations = new Radio(0, 9, 10, 0, 100, 0);
        stations.changeOnPrevRadioStations();
        long expected = 10;
        assertEquals(expected, stations.getCurrentRadioStationNumber());
        System.out.println(expected);
    }

    @Test
    void overMaxRadioStations() {
        Radio stations = new Radio(10000, 9, 10, 0, 100, 0);
        stations.changeOnNextRadioStations();
        long expected = 10;
        assertEquals(expected, stations.getCurrentRadioStationNumber());
        System.out.println(expected);
    }

    @Test
    void underMinRadioStations() {
        Radio stations = new Radio(-5, 9, 10, 0, 100, 0);
        stations.changeOnPrevRadioStations();
        long expected = 0;
        assertEquals(expected, stations.getCurrentRadioStationNumber());
        System.out.println(expected);
    }

    //    Tests on change volume
    @Test
    void changeVolumeIncrease() {
        Radio stations = new Radio(0, 5, 10, 0, 100, 0);
        stations.changeVolumeIncrease();
        long expected = 6;
        assertEquals(expected, stations.getCurrentVolume());
        System.out.println(expected);
    }

    @Test
    void changeVolumeDecrease() {
        Radio stations = new Radio(0, 8, 10, 0, 100, 0);
        stations.changeVolumeDecrease();
        long expected = 7;
        assertEquals(expected, stations.getCurrentVolume());
        System.out.println(expected);
    }

    @Test
    void currentVolumeEqualMax() {
        Radio stations = new Radio(0, 100, 10, 0, 100, 0);
        stations.changeVolumeIncrease();
        long expected = 100;
        assertEquals(expected, stations.getCurrentVolume());
        System.out.println(expected);
    }

    @Test
    void currentVolumeEqualMin() {
        Radio stations = new Radio(0, 0, 10, 0, 100, 0);
        stations.changeVolumeDecrease();
        long expected = 0;
        assertEquals(expected, stations.getCurrentVolume());
        System.out.println(expected);
    }

    @Test
    void currentVolumeUnderMin() {
        Radio stations = new Radio(0, -80, 10, 0, 100, 0);
        stations.changeVolumeDecrease();
        long expected = 0;
        assertEquals(expected, stations.getCurrentVolume());
        System.out.println(expected);
    }

    @Test
    void currentVolumeOverMax() {
        Radio stations = new Radio(0, 1111, 10, 0, 100, 0);
        stations.changeVolumeIncrease();
        long expected = 100;
        assertEquals(expected, stations.getCurrentVolume());
        System.out.println(expected);
    }
}