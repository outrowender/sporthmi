/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import org.dsi.ifc.global.NavLocation;

public interface NaviSDSPOIOnlineServiceListener {
    default public void updatePOIOnlineSearchResults(byte by, String string, String[] stringArray) {
    }

    default public void poiOnlineSetSearchAreaResult(byte by) {
    }

    default public void poiOnlineSearchDidYouMeanResult(byte by) {
    }

    default public void setSuggestions(boolean bl) {
    }

    default public void responseSelectDestination(NavLocation navLocation) {
    }
}

