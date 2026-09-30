/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import org.dsi.ifc.global.NavLocation;

public interface NaviSDSPOIOnlineServiceListener {
    public void updatePOIOnlineSearchResults(byte var1, String var2, String[] var3);

    public void poiOnlineSetSearchAreaResult(byte var1);

    public void poiOnlineSearchDidYouMeanResult(byte var1);

    public void setSuggestions(boolean var1);

    public void responseSelectDestination(NavLocation var1);
}

