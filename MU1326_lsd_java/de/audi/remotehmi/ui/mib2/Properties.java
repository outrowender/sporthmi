/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2;

import de.audi.remotehmi.ui.core.PropertiesCore;
import de.audi.remotehmi.util.EnumHelper;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Properties
extends PropertiesCore {
    public static final String PROP_GRID_LIST = "gridList";
    public static final String PROP_SPELLER = "speller";
    public static final String PROP_GRID_VIEW_TYPE = "gridViewType";
    public static final String PROP_DECORATOR_URL = "decoratorUrl";
    public static final String PROP_DECORATOR_IMAGE = "decoratorImage";
    public static final String PROP_DECORATOR_MAP = "decoratorMap";
    public static final String PROP_DECORATOR_MAP_STYLE = "decoratorMapStyle";
    public static final String PROP_VIEW_DATA_TYPE = "type";
    public static final String PROP_SCREEN_TYPE = "screenType";
    public static final String VALUE_SCREEN_TYPE_MAIN = "main";
    public static final String VALUE_SCREEN_TYPE_OPTIONS = "options";
    public static final Object VALUE_SCREEN_TYPE_AUTO = "auto";
    public static final String PROP_CAR_SCREEN_LAYOUT = "carScreenLayout";
    public static final String VALUE_CAR_SCREEN_LAYOUT_HIGH = "high";
    public static final String VALUE_CAR_SCREEN_LAYOUT_HIGH_TT = "highTT";
    public static final String VALUE_CAR_SCREEN_LAYOUT_LOW = "low";
    public static final Map GRID_ROW_GAP_VALUES_TT = Collections.unmodifiableMap(new HashMap(){
        private static final long serialVersionUID = 1L;
        {
            this.put("le1t", new Integer(14));
            this.put("le1b", new Integer(11));
            this.put("le2", new Integer(32));
            this.put("le2t", new Integer(16));
            this.put("le2b", new Integer(16));
            this.put("le3", new Integer(26));
            this.put("le4", new Integer(22));
            this.put("le4t", new Integer(11));
            this.put("le4b", new Integer(11));
            this.put("le5", new Integer(54));
            this.put("ze2", new Integer(15));
        }
    });
    public static final Map GRID_ROW_GAP_VALUES_NON_TT = Collections.unmodifiableMap(new HashMap(){
        private static final long serialVersionUID = 1L;
        {
            this.put("le1t", new Integer(15));
            this.put("le1b", new Integer(12));
            this.put("le2", new Integer(36));
            this.put("le2t", new Integer(18));
            this.put("le2b", new Integer(18));
            this.put("le3", new Integer(29));
            this.put("le4", new Integer(24));
            this.put("le4t", new Integer(12));
            this.put("le4b", new Integer(12));
            this.put("le5", new Integer(59));
            this.put("ze2", new Integer(17));
        }
    });
    public static final Map GRID_COLUMN_GAP_VALUES_TT = Collections.unmodifiableMap(new HashMap(){
        private static final long serialVersionUID = 1L;
        {
            this.put("g1", new Integer(22));
            this.put("g2", new Integer(61));
            this.put("i1", new Integer(15));
        }
    });
    public static final Map GRID_COLUMN_GAP_VALUES_NON_TT = Collections.unmodifiableMap(new HashMap(){
        private static final long serialVersionUID = 1L;
        {
            this.put("g1", new Integer(24));
            this.put("g2", new Integer(67));
            this.put("i1", new Integer(17));
        }
    });
    public static final String PROP_LAYOUT = "layout";
    public static final String VALUE_LAYOUT_FULL = "full";
    public static final String VALUE_LAYOUT_AUTO = "auto";
    public static final String VALUE_LAYOUT_DECORATOR = "decorator";
    public static final List LAYOUTS = Collections.unmodifiableList(Arrays.asList(new String[]{"full", "auto", "decorator"}));
    public static final String PROP_MAP_OVERLAY_TRANSPARENT_DEFAULT = "mapOverlayTransparentDefault";
    public static final String PROP_ROUTEGUIDANCE_LAT = "guidanceResultLat";
    public static final String PROP_ROUTEGUIDANCE_LON = "guidanceResultLon";
    public static final String PROP_ROUTEGUIDANCE_POIID = "guidanceResultPoiId";
    public static final String PROP_MAP_OVERLAY_LAT1 = "mapOverlayLat1";
    public static final String PROP_MAP_OVERLAY_LON1 = "mapOverlayLon1";
    public static final String PROP_MAP_OVERLAY_LAT2 = "mapOverlayLat2";
    public static final String PROP_MAP_OVERLAY_LON2 = "mapOverlayLon2";
    public static final String PROP_MAP_OVERLAY_PATH = "mapOverlayPath";
    public static final String PROP_MAP_OVERLAY_DESCRIPTION = "mapOverlayDescription";
    public static final String PROP_MAP_OVERLAY_DELAY = "mapOverlayDelay";
    public static final String PROP_ACTION_SEND_OSRAPPLICATIONS = "OsrApplications";
    public static final String PROP_PREPARED_IMAGE = "propPreparedImage";
    public static final String PROP_BACK_BEHAVIOR = "backBehavior";
    public static final String PROP_NPS_CONFIGURATION = "npsConfiguration";
    public static final int ORDER_NONE = -1;
    public static final int ORDER_TITLE = 0;
    public static final int ORDER_ARTIST = 1;
    public static final int ORDER_ALBUM = 2;
    public static final int ORDER_STATION = 3;
    public static final int ORDER_GENRE = 4;
    public static final Map ORDER_OPTIONS = new HashMap(){
        private static final long serialVersionUID = -2334177256358173042L;
        {
            this.put("title", new Integer(0));
            this.put("artist", new Integer(1));
            this.put("album", new Integer(2));
            this.put("station", new Integer(3));
            this.put("genre", new Integer(4));
        }
    };

    public static class BackBehavior {
        private static final EnumHelper enumHelper = new EnumHelper();
        private final String name;
        private final boolean openSelectionDrawerOnHkReturn;
        public static final BackBehavior normal = new BackBehavior("normal", false);
        public static final BackBehavior openSelectionDrawer = new BackBehavior("openSelectionDrawer", true);

        private BackBehavior(String string, boolean bl) {
            this.name = string;
            this.openSelectionDrawerOnHkReturn = bl;
            enumHelper.addInstance(string, this);
        }

        public String getName() {
            return this.name;
        }

        public static final BackBehavior valueOf(String string) {
            return (BackBehavior)enumHelper.valueOf(string);
        }

        public String toString() {
            return this.getName();
        }

        public boolean isSelectionDrawerOpenedOnHkReturn() {
            return this.openSelectionDrawerOnHkReturn;
        }
    }
}

