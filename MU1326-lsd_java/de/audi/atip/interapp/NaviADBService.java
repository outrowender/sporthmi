/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.NaviADBService$LocationInputHandler;
import de.audi.atip.metrics.GeoMetric;
import de.audi.atip.preset.DefinitionRequest;
import org.dsi.ifc.organizer.AdbEntry;

public interface NaviADBService {
    default public void setDestination(byte[] byArray, String string) {
    }

    default public void setDestination(AdbEntry adbEntry, int n, String string) {
    }

    default public void setDestination(LocationInputHandler locationInputHandler, AdbEntry adbEntry, int n, String string) {
    }

    default public void setDestination(String string, String string2, String string3) {
    }

    default public void showDestinationInMap(byte[] byArray, String string) {
    }

    default public void showDestinationInMap(String string, String string2, String string3) {
    }

    default public void parkNearDestination(byte[] byArray, String string) {
    }

    default public void parkNearDestination(String string, String string2, String string3) {
    }

    default public void poiNearDestination(byte[] byArray, String string) {
    }

    default public void poiNearDestination(String string, String string2, String string3) {
    }

    default public void editLocation(LocationInputHandler locationInputHandler, byte[] byArray) {
    }

    default public void editLocation(LocationInputHandler locationInputHandler, AdbEntry adbEntry, int n) {
    }

    default public void enterPreviewMap(int n, int n2) {
    }

    default public void focusPreviewMap(byte[] byArray) {
    }

    default public void focusPreviewMap(String string, String string2) {
    }

    default public void focusPreviewMap(AdbEntry adbEntry, int n) {
    }

    default public void exitPreviewMap() {
    }

    default public void addToFavorites(byte[] byArray, String string) {
    }

    default public void addToFavorites(String string, String string2, String string3) {
    }

    default public void definePreset(DefinitionRequest definitionRequest, byte[] byArray, String string) {
    }

    default public void definePreset(DefinitionRequest definitionRequest, String string, String string2, String string3) {
    }

    default public String[] getLocationName(byte[] byArray) {
    }

    default public String getLocationNameSingleLine(byte[] byArray) {
    }

    default public GeoMetric convertDecimalsToGeoMetric(String string, String string2) {
    }

    default public byte[] resolveGeoCoords(int n, int n2, String string) {
    }
}

