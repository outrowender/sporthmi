/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.metrics.GeoMetric;
import de.audi.atip.preset.DefinitionRequest;
import org.dsi.ifc.organizer.AdbEntry;

public interface NaviADBService {
    public void setDestination(byte[] var1, String var2);

    public void setDestination(AdbEntry var1, int var2, String var3);

    public void setDestination(LocationInputHandler var1, AdbEntry var2, int var3, String var4);

    public void setDestination(String var1, String var2, String var3);

    public void showDestinationInMap(byte[] var1, String var2);

    public void showDestinationInMap(String var1, String var2, String var3);

    public void parkNearDestination(byte[] var1, String var2);

    public void parkNearDestination(String var1, String var2, String var3);

    public void poiNearDestination(byte[] var1, String var2);

    public void poiNearDestination(String var1, String var2, String var3);

    public void editLocation(LocationInputHandler var1, byte[] var2);

    public void editLocation(LocationInputHandler var1, AdbEntry var2, int var3);

    public void enterPreviewMap(int var1, int var2);

    public void focusPreviewMap(byte[] var1);

    public void focusPreviewMap(String var1, String var2);

    public void focusPreviewMap(AdbEntry var1, int var2);

    public void exitPreviewMap();

    public void addToFavorites(byte[] var1, String var2);

    public void addToFavorites(String var1, String var2, String var3);

    public void definePreset(DefinitionRequest var1, byte[] var2, String var3);

    public void definePreset(DefinitionRequest var1, String var2, String var3, String var4);

    public String[] getLocationName(byte[] var1);

    public String getLocationNameSingleLine(byte[] var1);

    public GeoMetric convertDecimalsToGeoMetric(String var1, String var2);

    public byte[] resolveGeoCoords(int var1, int var2, String var3);

    public static interface LocationInputHandler {
        public void updateLocation(byte[] var1);

        public void sessionClosed();
    }
}

