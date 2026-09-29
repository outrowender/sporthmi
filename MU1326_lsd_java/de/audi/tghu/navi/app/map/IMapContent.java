/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.poi.POICategoryManager$POICategoriesObserver;
import org.dsi.ifc.map.LayerProperty;

public interface IMapContent
extends POICategoryManager$POICategoriesObserver {
    public static final int STANDARD_ROWS_MAX;
    public static final int STANDARD_COLUMN_LLD;
    public static final int STANDARD_COLUMN_ICON;
    public static final int STANDARD_COLUMN_ICON_ID;
    public static final int STANDARD_COLUMN_TEXT;
    public static final int STANDARD_COLUMN_TEXT_ID;
    public static final int STANDARD_COLUMN_CHECKED;
    public static final int STANDARD_COLUMN_ROW_TYPE;
    public static final int STANDARD_COLUMN_ROW_ID;
    public static final int STANDARD_COLUMN_ICON_RES;
    public static final int STANDARD_COLUMN_ENABLED;
    public static final int STANDARD_COLUMN_MAX;
    public static final int LLD_ICON_TEXT;
    public static final int LLD_ICONID_TEXTID;
    public static final int LLD_ICON_TEXTID;
    public static final int LLD_ICONRES_TEXT;
    public static final int LLD_ICON_TEXT_PARENT;
    public static final int ROW_TYPE_STATIC;
    public static final int ROW_TYPE_DYNAMIC;
    public static final int STATIC_ROW_SPEEDANDFLOW_FREEFLOW;
    public static final int STATIC_ROW_SPEEDANDFLOW_CONGESTIONS;
    public static final int STATIC_ROW_TMC;
    public static final int STATIC_ROW_3D_LANDMARKS;
    public static final int STATIC_ROW_3D_BUILDINGS;
    public static final int STATIC_ROW_FAVORITEN;
    public static final int STATIC_ROW_PIC_NAV;
    public static final int STATIC_ROW_RANGE;
    public static final int STATIC_ROW_WEATHER;
    public static final int STATIC_ROW_BRANDED_POIS;
    public static final int STATIC_ROW_TOP_BUISINESS;
    public static final int STATIC_ROW_TOP_PRIVATE;
    public static final int STATIC_ROW_PERSONAL_POIS;
    public static final int STATIC_ROW_CAR2X;
    public static final int STATIC_ROW_3D_MODEL;
    public static final int STATIC_ROW_MAX;
    public static final int TEXT_INDEX_SPEEDANDFLOW_FREEFLOW;
    public static final int TEXT_INDEX_SPEEDANDFLOW_CONGESTIONS;
    public static final int TEXT_INDEX_TMC;
    public static final int TEXT_INDEX_CAR2X;
    public static final int TEXT_INDEX_3D_LANDMARKS;
    public static final int TEXT_INDEX_3D_BUILDINGS;
    public static final int TEXT_INDEX_FAVORITE;
    public static final int TEXT_INDEX_PIC_NAV;
    public static final int TEXT_INDEX_HORIZONT_MARKER;
    public static final int TEXT_INDEX_RANGE;
    public static final int TEXT_INDEX_BRANDED_POIS;
    public static final int TEXT_INDEX_PERSONAL_POIS;
    public static final int TEXT_INDEX_WEATHER;
    public static final int TEXT_INDEX_3D_MODEL;
    public static final int ICON_INDEX_NONE;
    public static final int ICON_INDEX_TMC;
    public static final int ICON_INDEX_3D_LANDMARKS;
    public static final int ICON_INDEX_3D_BUILDINGS;
    public static final int ICON_INDEX_TMC_NAR;
    public static final int ICON_INDEX_SPEEDANDFLOW_FREEFLOW;
    public static final int ICON_INDEX_SPEEDANDFLOW_CONGESTIONS;
    public static final int ICON_INDEX_BRANDED_POIS;
    public static final int ICON_INDEX_PIC_NAV;
    public static final int ICON_INDEX_WEATHER;
    public static final int ICON_INDEX_3D_MODEL;
    public static final int GE_LAYERS_ROWS_MAX;
    public static final int GE_LAYERS_COLUMN_TEXT;
    public static final int GE_LAYERS_COLUMN_VISIBLE;
    public static final int GE_LAYERS_COLUMN_ICON;
    public static final int GE_LAYERS_COLUMN_UID;
    public static final int GE_LAYERS_COLUMN_PARENT;
    public static final int GE_LAYERS_COLUMN_TYPE;
    public static final int GE_LAYERS_COLUMN_MAX;
    public static final int IMPORT_ROWS_MAX;
    public static final int IMPORT_COLUMN_KMLFILE;
    public static final int IMPORT_COLUMN_VISIBLE;
    public static final int IMPORT_COLUMN_MAX;
    public static final int SELECTED_SD_NONE;
    public static final int SELECTED_SD_LEFT;
    public static final int SELECTED_SD_RIGHT;
    public static final String SD1_MOUNT_POINT;
    public static final String SD2_MOUNT_POINT;

    default public void backupDynamicPOIVisibilityAndHide() {
    }

    default public void setPOIVisibility(boolean bl) {
    }

    default public int[] getSystemLayers() {
    }

    default public int[] getSystemLayersAvailable() {
    }

    default public void initializeSystemLayers(int[] nArray, int[] nArray2, boolean bl) {
    }

    default public void restoreDynamicPOIVisibility() {
    }

    default public void updateAvailableLayers(LayerProperty[] layerPropertyArray) {
    }

    default public void updateVisibleLayers(int[] nArray) {
    }

    default public boolean toggleTMC() {
    }

    default public void onChangedMapRenderer() {
    }

    default public void updateEhCategoryVisibility(int[] nArray) {
    }

    default public void refresh() {
    }

    default public int[] getPoiVisibility() {
    }

    default public void resetSettings() {
    }

    default public boolean isWeatherInMapSelected() {
    }

    default public void checkWeatherInMap(boolean bl, boolean bl2, boolean bl3) {
    }

    default public String getName() {
    }

    default public void jumpToInclude() {
    }

    default public void activateDeactivateWeatherInMap(boolean bl) {
    }
}

