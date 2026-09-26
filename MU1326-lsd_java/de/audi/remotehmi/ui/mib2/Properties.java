/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2;

import de.audi.remotehmi.ui.core.PropertiesCore;
import de.audi.remotehmi.ui.mib2.Properties$1;
import de.audi.remotehmi.ui.mib2.Properties$2;
import de.audi.remotehmi.ui.mib2.Properties$3;
import de.audi.remotehmi.ui.mib2.Properties$4;
import de.audi.remotehmi.ui.mib2.Properties$5;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface Properties
extends PropertiesCore {
    public static final String PROP_GRID_LIST;
    public static final String PROP_SPELLER;
    public static final String PROP_GRID_VIEW_TYPE;
    public static final String PROP_DECORATOR_URL;
    public static final String PROP_DECORATOR_IMAGE;
    public static final String PROP_DECORATOR_MAP;
    public static final String PROP_DECORATOR_MAP_STYLE;
    public static final String PROP_VIEW_DATA_TYPE;
    public static final String PROP_SCREEN_TYPE;
    public static final String VALUE_SCREEN_TYPE_MAIN;
    public static final String VALUE_SCREEN_TYPE_OPTIONS;
    public static final Object VALUE_SCREEN_TYPE_AUTO;
    public static final String PROP_CAR_SCREEN_LAYOUT;
    public static final String VALUE_CAR_SCREEN_LAYOUT_HIGH;
    public static final String VALUE_CAR_SCREEN_LAYOUT_HIGH_TT;
    public static final String VALUE_CAR_SCREEN_LAYOUT_LOW;
    public static final Map GRID_ROW_GAP_VALUES_TT;
    public static final Map GRID_ROW_GAP_VALUES_NON_TT;
    public static final Map GRID_COLUMN_GAP_VALUES_TT;
    public static final Map GRID_COLUMN_GAP_VALUES_NON_TT;
    public static final String PROP_LAYOUT;
    public static final String VALUE_LAYOUT_FULL;
    public static final String VALUE_LAYOUT_AUTO;
    public static final String VALUE_LAYOUT_DECORATOR;
    public static final List LAYOUTS;
    public static final String PROP_MAP_OVERLAY_TRANSPARENT_DEFAULT;
    public static final String PROP_ROUTEGUIDANCE_LAT;
    public static final String PROP_ROUTEGUIDANCE_LON;
    public static final String PROP_ROUTEGUIDANCE_POIID;
    public static final String PROP_MAP_OVERLAY_LAT1;
    public static final String PROP_MAP_OVERLAY_LON1;
    public static final String PROP_MAP_OVERLAY_LAT2;
    public static final String PROP_MAP_OVERLAY_LON2;
    public static final String PROP_MAP_OVERLAY_PATH;
    public static final String PROP_MAP_OVERLAY_DESCRIPTION;
    public static final String PROP_MAP_OVERLAY_DELAY;
    public static final String PROP_ACTION_SEND_OSRAPPLICATIONS;
    public static final String PROP_PREPARED_IMAGE;
    public static final String PROP_BACK_BEHAVIOR;
    public static final String PROP_NPS_CONFIGURATION;
    public static final int ORDER_NONE;
    public static final int ORDER_TITLE;
    public static final int ORDER_ARTIST;
    public static final int ORDER_ALBUM;
    public static final int ORDER_STATION;
    public static final int ORDER_GENRE;
    public static final Map ORDER_OPTIONS;

    static {
        VALUE_SCREEN_TYPE_AUTO = "auto";
        GRID_ROW_GAP_VALUES_TT = Collections.unmodifiableMap(new Properties$1());
        GRID_ROW_GAP_VALUES_NON_TT = Collections.unmodifiableMap(new Properties$2());
        GRID_COLUMN_GAP_VALUES_TT = Collections.unmodifiableMap(new Properties$3());
        GRID_COLUMN_GAP_VALUES_NON_TT = Collections.unmodifiableMap(new Properties$4());
        LAYOUTS = Collections.unmodifiableList(Arrays.asList(new String[]{"full", "auto", "decorator"}));
        ORDER_OPTIONS = new Properties$5();
    }
}

