/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

import de.audi.remotehmi.ui.mib2.grid.IGrid;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public interface IPreviewInfo {
    public static final int STATE_UNHANDLED = 0;
    public static final int STATE_ERROR = 1;
    public static final int STATE_UPDATE_RECEIVED = 2;
    public static final int STATE_UPDATE_RECEIVED_STALE = 3;
    public static final int LOCATION_UNKNOWN = -1;
    public static final int LOCATION_MYSCREEN = 0;
    public static final int LOCATION_MYDEST = 1;
    public static final String TYPE_NEWS = "news";
    public static final String TYPE_WEATHER = "weather";
    public static final String TYPE_PARKINFO = "parkinfo";
    public static final String TYPE_ESTATIONS = "estations";
    public static final String TYPE_MY_DEST = "myDestinations";
    public static final String TYPE_FUELPRICES = "fuelprices";
    public static final String TYPE_CALENDAR = "calendar";
    public static final List TYPES = Collections.unmodifiableList(Arrays.asList(new String[]{"news", "weather", "parkinfo", "estations", "myDestinations", "fuelprices", "calendar"}));

    public IGrid getPreviewGrid();

    public String getPrevId();

    public int getLocation();

    public String getType();

    public String getApplicationId();

    public String getApplicationContext();
}

