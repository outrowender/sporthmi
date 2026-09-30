/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.travelguide;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.travelguide.TravelGuideMemoryListElement;

public interface DSITravelGuideListener
extends DSIListener {
    public void importTravelGuideResult(int var1, int var2);

    public void updateTravelGuideMemoryListElement(TravelGuideMemoryListElement var1, int var2, int var3);

    public void deleteTravelGuideResult(int var1);

    public void updateTravelGuideMemoryList(TravelGuideMemoryListElement[] var1, int var2);
}

