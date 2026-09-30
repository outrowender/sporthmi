/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tpegservices;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.tpegservices.FuelPriceInformation;
import org.dsi.ifc.tpegservices.NewsCategory;
import org.dsi.ifc.tpegservices.ResourceInformation;
import org.dsi.ifc.tpegservices.SimpleMapData;
import org.dsi.ifc.tpegservices.WeatherInfo;

public interface DSITPEGServicesReply {
    public static final String IPL_COMM_UUID = "df2bcc79-5aca-58de-9890-11936aa66c5b";
    public static final String IPL_COMM_INTERFACE_KEY = "38b87564-71b1-5f7e-8a45-5e821f7bee7c";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.5";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.5";

    public void updateTPEGContentAvailability(int[] var1, int var2) throws MethodException;

    public void updateSimpleMapsBookmarks(SimpleMapData[] var1, int var2) throws MethodException;

    public void requestLocationDetailsResponse(NavLocation var1) throws MethodException;

    public void requestFuelPriceInformationResponse(FuelPriceInformation[] var1) throws MethodException;

    public void requestNewsInformationResponse(NewsCategory var1) throws MethodException;

    public void requestSimpleMapListResponse(int var1, int var2, SimpleMapData[] var3) throws MethodException;

    public void addSimpleMapBookmarkResult(int var1, int var2) throws MethodException;

    public void deleteSimpleMapBookmarkResult(int var1, int var2) throws MethodException;

    public void deleteAllSimpleMapBookmarksResult(int var1) throws MethodException;

    public void requestResourceInformationResponse(int var1, ResourceInformation var2) throws MethodException;

    public void setLanguageResponse(boolean var1) throws MethodException;

    public void requestWeatherInfoResult(WeatherInfo var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

