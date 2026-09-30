/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi;

import de.audi.atip.interapp.NaviService;

public interface ISDSNaviPOIValueSettingCommand {
    public void responseSelectPOIByUID(byte var1, NaviService.POISDSListEntry[] var2);

    public void responseSelectPOIByListIndex(byte var1);
}

