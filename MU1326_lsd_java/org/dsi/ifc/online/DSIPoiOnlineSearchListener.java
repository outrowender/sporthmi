/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;

public interface DSIPoiOnlineSearchListener
extends DSIListener {
    public void poiResult(int var1, int var2, int var3);

    public void poiSpellingSuggestion(int var1, String var2, String[] var3);

    public void poiValueList(int var1, int var2, PoiOnlineSearchValuelist var3, int var4, int var5);

    public void precheckDynamicPOICategoryResponse(int var1, OSRServiceState var2);
}

