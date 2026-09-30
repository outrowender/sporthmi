/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tpegservices;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.NavLocation;

public interface DSITPEGServicesC {
    public void requestSimpleMapList(int var1, int var2) throws MethodException;

    public void addSimpleMapBookmark(int var1) throws MethodException;

    public void deleteSimpleMapBookmark(int var1) throws MethodException;

    public void deleteAllSimpleMapBookmarks() throws MethodException;

    public void requestLocationDetails(int var1) throws MethodException;

    public void requestFuelPriceInformation(int var1, int var2) throws MethodException;

    public void requestSortedFuelPriceInformation(int var1, int var2, int var3) throws MethodException;

    public void requestNewsInformation(int var1) throws MethodException;

    public void requestResourceInformation(int var1) throws MethodException;

    public void setLanguage(String var1) throws MethodException;

    public void requestWeatherInfo(NavLocation var1, int var2, int var3) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

