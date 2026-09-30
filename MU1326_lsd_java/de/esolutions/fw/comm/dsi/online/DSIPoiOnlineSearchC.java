/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public interface DSIPoiOnlineSearchC {
    public void poiStartSelectionZoom(String var1, int var2, int var3, int var4, int var5, int var6) throws MethodException;

    public void dynamicPoiStartSelectionZoom(int var1, int var2, int var3, int var4, int var5, int var6, int var7) throws MethodException;

    public void poiStartSelection(String var1, int var2, int var3, int var4, int var5) throws MethodException;

    public void dynamicPoiStartSelection(int var1, int var2, int var3, int var4, int var5, int var6) throws MethodException;

    public void poiStopSelection() throws MethodException;

    public void poiRequestValueList(int var1, int var2) throws MethodException;

    public void poiStartVoiceSelection(int var1, int var2, int var3, int var4, boolean var5, int var6) throws MethodException;

    public void poiRawVoiceDataAvailable(String var1, int var2) throws MethodException;

    public void poiRequestSpellingSuggestion() throws MethodException;

    public void usedPoi(PoiOnlineSearchValuelistElement var1, int var2) throws MethodException;

    public void setLanguage(String var1) throws MethodException;

    public void setFallbackLanguage(String var1) throws MethodException;

    public void poiVoiceSearchActive() throws MethodException;

    public void precheckDynamicPOICategory(int var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

