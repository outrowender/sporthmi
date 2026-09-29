/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi;

import de.audi.atip.interapp.NaviService$POISDSListEntry;

public interface ISDSNaviPOIValueSettingCommand {
    default public void responseSelectPOIByUID(byte by, NaviService$POISDSListEntry[] naviService$POISDSListEntryArray) {
    }

    default public void responseSelectPOIByListIndex(byte by) {
    }
}

