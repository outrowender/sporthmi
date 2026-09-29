/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

import de.audi.remotehmi.ui.mib2.grid.IGrid;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public interface IPreviewInfo {
    public static final int STATE_UNHANDLED;
    public static final int STATE_ERROR;
    public static final int STATE_UPDATE_RECEIVED;
    public static final int STATE_UPDATE_RECEIVED_STALE;
    public static final int LOCATION_UNKNOWN;
    public static final int LOCATION_MYSCREEN;
    public static final int LOCATION_MYDEST;
    public static final String TYPE_NEWS;
    public static final String TYPE_WEATHER;
    public static final String TYPE_PARKINFO;
    public static final String TYPE_ESTATIONS;
    public static final String TYPE_MY_DEST;
    public static final String TYPE_FUELPRICES;
    public static final String TYPE_CALENDAR;
    public static final List TYPES;

    default public IGrid getPreviewGrid() {
    }

    default public String getPrevId() {
    }

    default public int getLocation() {
    }

    default public String getType() {
    }

    default public String getApplicationId() {
    }

    default public String getApplicationContext() {
    }

    static {
        TYPES = Collections.unmodifiableList(Arrays.asList(new String[]{"news", "weather", "parkinfo", "estations", "myDestinations", "fuelprices", "calendar"}));
    }
}

