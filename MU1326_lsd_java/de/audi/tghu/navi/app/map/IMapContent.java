/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.poi.POICategoryManager;
import org.dsi.ifc.map.LayerProperty;

public interface IMapContent
extends POICategoryManager.POICategoriesObserver {
    public static final int STANDARD_ROWS_MAX = 150;
    public static final int STANDARD_COLUMN_LLD = 0;
    public static final int STANDARD_COLUMN_ICON = 1;
    public static final int STANDARD_COLUMN_ICON_ID = 2;
    public static final int STANDARD_COLUMN_TEXT = 3;
    public static final int STANDARD_COLUMN_TEXT_ID = 4;
    public static final int STANDARD_COLUMN_CHECKED = 5;
    public static final int STANDARD_COLUMN_ROW_TYPE = 6;
    public static final int STANDARD_COLUMN_ROW_ID = 7;
    public static final int STANDARD_COLUMN_ICON_RES = 8;
    public static final int STANDARD_COLUMN_ENABLED = 9;
    public static final int STANDARD_COLUMN_MAX = 10;
    public static final int LLD_ICON_TEXT = 0;
    public static final int LLD_ICONID_TEXTID = 1;
    public static final int LLD_ICON_TEXTID = 2;
    public static final int LLD_ICONRES_TEXT = 3;
    public static final int LLD_ICON_TEXT_PARENT = 4;
    public static final int ROW_TYPE_STATIC = 0;
    public static final int ROW_TYPE_DYNAMIC = 1;
    public static final int STATIC_ROW_SPEEDANDFLOW_FREEFLOW = 0;
    public static final int STATIC_ROW_SPEEDANDFLOW_CONGESTIONS = 1;
    public static final int STATIC_ROW_TMC = 2;
    public static final int STATIC_ROW_3D_LANDMARKS = 3;
    public static final int STATIC_ROW_3D_BUILDINGS = 4;
    public static final int STATIC_ROW_FAVORITEN = 5;
    public static final int STATIC_ROW_PIC_NAV = 6;
    public static final int STATIC_ROW_RANGE = 7;
    public static final int STATIC_ROW_WEATHER = 8;
    public static final int STATIC_ROW_BRANDED_POIS = 9;
    public static final int STATIC_ROW_TOP_BUISINESS = 10;
    public static final int STATIC_ROW_TOP_PRIVATE = 11;
    public static final int STATIC_ROW_PERSONAL_POIS = 12;
    public static final int STATIC_ROW_CAR2X = 13;
    public static final int STATIC_ROW_3D_MODEL = 14;
    public static final int STATIC_ROW_MAX = 15;
    public static final int TEXT_INDEX_SPEEDANDFLOW_FREEFLOW = 0;
    public static final int TEXT_INDEX_SPEEDANDFLOW_CONGESTIONS = 1;
    public static final int TEXT_INDEX_TMC = 2;
    public static final int TEXT_INDEX_CAR2X = 3;
    public static final int TEXT_INDEX_3D_LANDMARKS = 4;
    public static final int TEXT_INDEX_3D_BUILDINGS = 5;
    public static final int TEXT_INDEX_FAVORITE = 6;
    public static final int TEXT_INDEX_PIC_NAV = 7;
    public static final int TEXT_INDEX_HORIZONT_MARKER = 8;
    public static final int TEXT_INDEX_RANGE = 9;
    public static final int TEXT_INDEX_BRANDED_POIS = 10;
    public static final int TEXT_INDEX_PERSONAL_POIS = 11;
    public static final int TEXT_INDEX_WEATHER = 12;
    public static final int TEXT_INDEX_3D_MODEL = 0;
    public static final int ICON_INDEX_NONE = -1;
    public static final int ICON_INDEX_TMC = 0;
    public static final int ICON_INDEX_3D_LANDMARKS = 1;
    public static final int ICON_INDEX_3D_BUILDINGS = 4;
    public static final int ICON_INDEX_TMC_NAR = 5;
    public static final int ICON_INDEX_SPEEDANDFLOW_FREEFLOW = 6;
    public static final int ICON_INDEX_SPEEDANDFLOW_CONGESTIONS = 7;
    public static final int ICON_INDEX_BRANDED_POIS = 8;
    public static final int ICON_INDEX_PIC_NAV = 9;
    public static final int ICON_INDEX_WEATHER = 10;
    public static final int ICON_INDEX_3D_MODEL = -1;
    public static final int GE_LAYERS_ROWS_MAX = 100;
    public static final int GE_LAYERS_COLUMN_TEXT = 0;
    public static final int GE_LAYERS_COLUMN_VISIBLE = 1;
    public static final int GE_LAYERS_COLUMN_ICON = 2;
    public static final int GE_LAYERS_COLUMN_UID = 3;
    public static final int GE_LAYERS_COLUMN_PARENT = 4;
    public static final int GE_LAYERS_COLUMN_TYPE = 5;
    public static final int GE_LAYERS_COLUMN_MAX = 6;
    public static final int IMPORT_ROWS_MAX = 255;
    public static final int IMPORT_COLUMN_KMLFILE = 0;
    public static final int IMPORT_COLUMN_VISIBLE = 1;
    public static final int IMPORT_COLUMN_MAX = 2;
    public static final int SELECTED_SD_NONE = 0;
    public static final int SELECTED_SD_LEFT = 1;
    public static final int SELECTED_SD_RIGHT = 2;
    public static final String SD1_MOUNT_POINT = "/fs/sd0/";
    public static final String SD2_MOUNT_POINT = "/fs/sd1/";

    public void backupDynamicPOIVisibilityAndHide();

    public void setPOIVisibility(boolean var1);

    public int[] getSystemLayers();

    public int[] getSystemLayersAvailable();

    public void initializeSystemLayers(int[] var1, int[] var2, boolean var3);

    public void restoreDynamicPOIVisibility();

    public void updateAvailableLayers(LayerProperty[] var1);

    public void updateVisibleLayers(int[] var1);

    public boolean toggleTMC();

    public void onChangedMapRenderer();

    public void updateEhCategoryVisibility(int[] var1);

    public void refresh();

    public int[] getPoiVisibility();

    public void resetSettings();

    public boolean isWeatherInMapSelected();

    public void checkWeatherInMap(boolean var1, boolean var2, boolean var3);

    public String getName();

    public void jumpToInclude();

    public void activateDeactivateWeatherInMap(boolean var1);
}

