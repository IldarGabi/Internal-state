package newRadio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    //    change stations
    @Test
    void changeOnNextRadioStations() {
        Radio stations = new Radio();
        assertEquals(0, stations.getMinRadioStation());
        assertEquals(0, stations.getMaxRadioStation());
        stations.setMaxRadioStation(9);
        stations.setCurrentRadioStationNumber(7);
        stations.setMinRadioStation(0);
        stations.changeOnNextRadioStations();
        long expected = 8;
        assertEquals(expected, stations.getCurrentRadioStationNumber());
        System.out.println(expected);
    }

    @Test
    void changeOnPrevRadioStations() {
        Radio stations = new Radio();
        stations.setMaxRadioStation(9);
        stations.setCurrentRadioStationNumber(7);
        stations.setMinRadioStation(0);
        stations.changeOnPrevRadioStations();
        long expected = 6;
        assertEquals(expected, stations.getCurrentRadioStationNumber());
        System.out.println(expected);
    }

    @Test
    void nextAfterLastRadioStations() {
        Radio stations = new Radio();
        stations.setMaxRadioStation(9);
        stations.setCurrentRadioStationNumber(9);
        stations.setMinRadioStation(0);
        stations.changeOnNextRadioStations();
        long expected = 0;
        assertEquals(expected, stations.getCurrentRadioStationNumber());
        System.out.println(expected);
    }

    @Test
    void prevAfterFirstRadioStations() {
        Radio stations = new Radio();
        stations.setMaxRadioStation(9);
        stations.setCurrentRadioStationNumber(0);
        stations.setMinRadioStation(0);
        stations.changeOnPrevRadioStations();
        long expected = 9;
        assertEquals(expected, stations.getCurrentRadioStationNumber());
        System.out.println(expected);
    }

    @Test
    void overMaxRadioStations() {
        Radio stations = new Radio();
        stations.setMaxRadioStation(9);
        stations.setCurrentRadioStationNumber(100);
        stations.setMinRadioStation(0);
        long expected = 9;
        assertEquals(expected, stations.getCurrentRadioStationNumber());
        System.out.println(expected);
    }

    @Test
    void underMinRadioStations() {
        Radio stations = new Radio();
        stations.setMaxRadioStation(9);
        stations.setCurrentRadioStationNumber(-999);
        stations.setMinRadioStation(0);
        long expected = 0;
        assertEquals(expected, stations.getCurrentRadioStationNumber());
        System.out.println(expected);
    }

    //    Tests on change volume
    @Test
    void changeVolumeIncrease() {
        Radio stations = new Radio();
        assertEquals(0, stations.getMinVolume());
        assertEquals(0, stations.getMaxVolume());
        stations.setMaxVolume(10);
        stations.setCurrentVolume(5);
        stations.setMinVolume(0);
        stations.changeVolumeIncrease();
        long expected = 6;
        assertEquals(expected, stations.getCurrentVolume());
        System.out.println(expected);
    }

    @Test
    void changeVolumeDecrease() {
        Radio stations = new Radio();
        stations.setMaxVolume(10);
        stations.setCurrentVolume(9);
        stations.setMinVolume(0);
        stations.changeVolumeDecrease();
        long expected = 8;
        assertEquals(expected, stations.getCurrentVolume());
        System.out.println(expected);
    }

    @Test
    void currentVolumeEqualMax() {
        Radio stations = new Radio();
        stations.setMaxVolume(10);
        stations.setCurrentVolume(10);
        stations.setMinVolume(0);
        long expected = 10;
        assertEquals(expected, stations.getCurrentVolume());
        System.out.println(expected);
    }

    @Test
    void currentVolumeEqualMin() {
        Radio stations = new Radio();
        stations.setMaxVolume(10);
        stations.setCurrentVolume(0);
        stations.setMinVolume(0);
        long expected = 0;
        assertEquals(expected, stations.getCurrentVolume());
        System.out.println(expected);
    }

    @Test
    void currentVolumeUnderMin() {
        Radio stations = new Radio();
        stations.changeVolumeDecrease();
        stations.setMaxVolume(10);
        stations.setCurrentVolume(-444);
        stations.setMinVolume(0);
        long expected = 0;
        assertEquals(expected, stations.getCurrentVolume());
        System.out.println(expected);
    }

    @Test
    void currentVolumeOverMax() {
        Radio stations = new Radio();
        stations.setMaxVolume(10);
        stations.changeVolumeIncrease();
        stations.setCurrentVolume(1000);
        stations.setMinVolume(0);
        long expected = 10;
        assertEquals(expected, stations.getCurrentVolume());
        System.out.println(expected);
    }
}