/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.utils;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.map.IMapContent;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.map.LayerProperty;
import org.dsi.ifc.navigation.Category;

public class MapContentListEmpty
implements IMapContent {
    private final LogChannel logger;

    public MapContentListEmpty(LogChannel logChannel) {
        this.logger = logChannel;
    }

    private void warn(String string) {
        this.logger.log(100000, "%1 - not implemented.");
    }

    public void backupDynamicPOIVisibilityAndHide() {
        this.warn("MapContentListEmpty#backupDynamicPOIVisibilityAndHide()");
    }

    public void setPOIVisibility(boolean bl) {
        this.warn("MapContentListEmpty#copyCategoriesToActiveContext()");
    }

    public int[] getSystemLayers() {
        this.warn("MapContentListEmpty#getSystemLayers()");
        return new int[]{-1};
    }

    public void initializeSystemLayers(int[] nArray, int[] nArray2, boolean bl) {
        this.warn("MapContentListEmpty#initializeSystemLayers()");
    }

    public void updateVisibleLayers(int[] nArray) {
        this.warn("MapContentListEmpty#updateVisibleLayers()");
    }

    public void updateAvailableLayers(LayerProperty[] layerPropertyArray) {
        this.warn("MapContentListEmpty#updateAvailableLayers()");
    }

    public void setStoredSystemLayers() {
        this.warn("MapContentListEmpty#setStoredSystemLayers()");
    }

    public void restoreDynamicPOIVisibility() {
        this.warn("MapContentListEmpty#restoreDynamicPOIVisibility()");
    }

    public void processCategories(int n, Category[] categoryArray) {
        this.warn("MapContentListEmpty#processCategories()");
    }

    public boolean toggleTMC() {
        this.warn("MapContentListEmpty#toggleTMC()");
        return false;
    }

    public void onChangedMapRenderer() {
    }

    public void updateEhCategoryVisibility(int[] nArray) {
    }

    public void refresh() {
    }

    public int[] getPoiVisibility() {
        return new int[0];
    }

    public int[] getSystemLayersAvailable() {
        return new int[0];
    }

    public void resetSettings() {
    }

    public boolean isWeatherInMapSelected() {
        this.warn("MapContentListEmpty#isWeatherInMapSelected()");
        return false;
    }

    public void checkWeatherInMap(boolean bl, boolean bl2, boolean bl3) {
        this.warn("MapContentListEmpty#checkWeatherInMap()");
    }

    public String getName() {
        Buffer buffer = new Buffer(50);
        buffer.append("MapContentListEmpty[");
        buffer.append(this.toString());
        buffer.append(']');
        return buffer.toString();
    }

    public void jumpToInclude() {
        this.warn("MapContentListEmpty#jumpToInclude()");
    }

    public void activateDeactivateWeatherInMap(boolean bl) {
        this.warn("MapContentListEmpty#activateDeactivateWeatherInMap()");
    }
}

