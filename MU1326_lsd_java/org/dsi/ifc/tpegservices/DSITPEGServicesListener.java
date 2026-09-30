/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tpegservices;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.tpegservices.FuelPriceInformation;
import org.dsi.ifc.tpegservices.NewsCategory;
import org.dsi.ifc.tpegservices.ResourceInformation;
import org.dsi.ifc.tpegservices.SimpleMapData;
import org.dsi.ifc.tpegservices.WeatherInfo;

public interface DSITPEGServicesListener
extends DSIListener {
    public void updateTPEGContentAvailability(int[] var1, int var2);

    public void updateSimpleMapsBookmarks(SimpleMapData[] var1, int var2);

    public void requestLocationDetailsResponse(NavLocation var1);

    public void requestFuelPriceInformationResponse(FuelPriceInformation[] var1);

    public void requestNewsInformationResponse(NewsCategory var1);

    public void requestSimpleMapListResponse(int var1, int var2, SimpleMapData[] var3);

    public void addSimpleMapBookmarkResult(int var1, int var2);

    public void deleteSimpleMapBookmarkResult(int var1, int var2);

    public void deleteAllSimpleMapBookmarksResult(int var1);

    public void requestResourceInformationResponse(int var1, ResourceInformation var2);

    public void setLanguageResponse(boolean var1);

    public void requestWeatherInfoResult(WeatherInfo var1, int var2);
}

