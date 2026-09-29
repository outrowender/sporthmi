/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;

public final class FunctionCounter {
    public static final String FUNCTIONCOUNTER_ACTIVE;
    private static final int MAX_ENTRIES;
    public static final int NAV_DEST_EDIT_COUNTRY;
    public static final int NAV_DEST_EDIT_CITYNAME;
    public static final int NAV_EDIT_STREET_AFTER_CITY;
    public static final int NAV_EDIT_JUNCTION_AFTER_CITY;
    public static final int NAV_EDIT_HOUSENUMBER_AFTER_CITY;
    public static final int NAV_DEST_EDIT_STREET;
    public static final int NAV_DEST_MAIN_FORM_ADD_DESTINATION;
    public static final int NAV_EDIT_CITY_CENTER;
    public static final int NAV_MEM_LAST;
    public static final int NAV_MEM_LAST_DELETE;
    public static final int NAV_MEM_ADR_LOAD;
    public static final int NAV_MEM_ADR_STORE;
    public static final int NAV_MEM_ROUTE_LOAD;
    public static final int NAV_MEM_ROUTE_SAVE;
    public static final int NAV_MEM_ROUTE_DEL;
    public static final int NAV_INFO;
    public static final int NAV_RP_CAL_LIST;
    public static final int NAV_RP_ROUTE_OPT;
    public static final int TRAFFIC_NAV_RFROM;
    public static final int NAV_SETUP_MAIN;
    public static final int NAV_SETUP_MAPCONTENT;
    public static final int NAV_SETUP_POS_MENU;
    public static final int NAV_SETUP_MAP_DIRECTION;
    public static final int NAV_DEST_POI_TOP;
    public static final int NAV_DEST_POI_NAME;
    public static final int NAV_DEST_POI_POS;
    public static final int NAV_DEST_POI_AR;
    public static final int NAV_DEST_POI_NAT;
    public static final int NAV_DEST_POI_CITY;
    public static final int NAV_DEST_POI_TEL;
    public static final int NAV_DEST_POI_DEST;
    public static final int NAV_EDIT_POI_AFTER_CITY;
    public static final int FUEL_FEATURE;
    public static final int TEL_NUMBER_EDIT_SINGLE;
    public static final int ADR_EDIT_FORM_POST_MAIN;
    public static final int ADR_NAV_DEST_FORM;
    public static final int ADR_NAV_DEST_FORM_NO_MATCH;
    private String[] keys = null;
    private int[] counters = null;
    private final boolean active = Boolean.getBoolean("FUNCTIONCOUNTER_ACTIVE");
    final LogChannel logChannel;
    final NavigationEnv env;

    public FunctionCounter(NavigationEnv navigationEnv) {
        this.logChannel = navigationEnv.getLogChannel();
        this.env = navigationEnv;
    }

    private synchronized String[] initKeys() {
        String[] stringArray = new String[53];
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            stringArray[i2] = "";
        }
        stringArray[0] = "DI_EDIT_COUNTRY";
        stringArray[1] = "DI_EDIT_CITYNAME";
        stringArray[2] = "DI_EDIT_STR_AFTERCITY";
        stringArray[4] = "DI_EDIT_JUNC_AFTERCITY";
        stringArray[5] = "DI_EDIT_HNR_AFTERCITY";
        stringArray[6] = "DI_DEST_EDIT_STREET";
        stringArray[7] = "DI_ADD_DESTINATION";
        stringArray[8] = "DI_EDIT_CITY_CENTER";
        stringArray[11] = "NAV_MEM_LAST";
        stringArray[12] = "NAV_MEM_LAST_DELETE";
        stringArray[13] = "NAV_MEM_ADR_LOAD";
        stringArray[14] = "NAV_MEM_ADR_STORE";
        stringArray[15] = "NAV_MEM_ROUTE_LOAD";
        stringArray[16] = "NAV_MEM_ROUTE_SAVE";
        stringArray[17] = "NAV_MEM_ROUTE_DEL";
        stringArray[20] = "NAV_INFO";
        stringArray[21] = "NAV_RP_CAL_LIST";
        stringArray[22] = "NAV_RP_ROUTE_OPT";
        stringArray[23] = "TRAFFIC_NAV_RFROM";
        stringArray[25] = "NAV_SETUP_MAIN";
        stringArray[26] = "NAV_SETUP_MAPCONTENT";
        stringArray[27] = "NAV_SETUP_POS_MENU";
        stringArray[28] = "NAV_SETUP_MAP_DIR";
        stringArray[30] = "DI_POI_TOP";
        stringArray[31] = "DI_POI_NAME";
        stringArray[32] = "DI_POI_POS";
        stringArray[33] = "DI_POI_AR";
        stringArray[34] = "DI_POI_NAT";
        stringArray[35] = "DI_POI_CITY";
        stringArray[36] = "DI_POI_TEL";
        stringArray[37] = "DI_POI_DEST";
        stringArray[38] = "DI_POI_AFTER_CITY";
        stringArray[39] = "DI_POI_FUEL_FEATURE";
        stringArray[40] = "TEL_NR_EDIT_SINGLE";
        stringArray[50] = "ADR_NDF_POST_MAIN";
        stringArray[51] = "ADR_NDF";
        stringArray[52] = "ADR_NDF_NO_MATCH";
        return stringArray;
    }

    private synchronized void saveState() {
        if (!this.active) {
            return;
        }
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        iStorageAccess.setIntArray(1004, 710, this.counters);
    }

    private synchronized void loadState() {
        if (!this.active) {
            this.counters = new int[53];
            this.keys = this.initKeys();
            return;
        }
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        try {
            this.counters = iStorageAccess.getIntArray(1004, 710, new int[0]);
            if (this.counters.length < 53) {
                int[] nArray = new int[53];
                System.arraycopy((Object)this.counters, 0, (Object)nArray, 0, this.counters.length);
                this.counters = nArray;
                iStorageAccess.setIntArray(1004, 710, this.counters);
            }
        }
        catch (Exception exception) {
            this.counters = new int[53];
            iStorageAccess.setIntArray(1004, 710, this.counters);
        }
        this.keys = this.initKeys();
    }

    public synchronized void incCounter(int n) {
        this.logChannel.log(-2137614336, "FunctionCounter#incCounter( %1 ) ", (long)n);
        if (this.counters == null) {
            this.loadState();
        }
        int n2 = n;
        this.counters[n2] = this.counters[n2] + 1;
        this.saveState();
    }

    public synchronized void clearCounters() {
        this.loadState();
        this.counters = new int[this.counters.length];
        this.saveState();
    }

    public synchronized String toString() {
        if (this.counters == null) {
            this.loadState();
        }
        Buffer buffer = new Buffer();
        buffer.append('(');
        for (int i2 = 0; i2 < 53; ++i2) {
            buffer.append(this.keys[i2]).append(": ").append(this.counters[i2]).append(", ");
        }
        buffer.append(')');
        return buffer.toString();
    }

    public synchronized void exportList() {
        Buffer buffer = new Buffer();
        buffer.append("------FunctionCounter List-----\n");
        for (int i2 = 0; i2 < 53; ++i2) {
            if (!Util.isEmpty(this.keys[i2])) {
                buffer.append(this.keys[i2]).append("\n");
                continue;
            }
            buffer.append("[Slot ").append(i2).append("]\n");
        }
        buffer.append("------End FunctionCounter List-----\n");
        System.out.println(buffer);
    }
}

