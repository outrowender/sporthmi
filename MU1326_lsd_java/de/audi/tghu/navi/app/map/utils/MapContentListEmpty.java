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
        this.logger.log(-1601830656, "%1 - not implemented.");
    }

    @Override
    public void backupDynamicPOIVisibilityAndHide() {
        this.warn("MapContentListEmpty#backupDynamicPOIVisibilityAndHide()");
    }

    @Override
    public void setPOIVisibility(boolean bl) {
        this.warn("MapContentListEmpty#copyCategoriesToActiveContext()");
    }

    @Override
    public int[] getSystemLayers() {
        this.warn("MapContentListEmpty#getSystemLayers()");
        return new int[]{-1};
    }

    @Override
    public void initializeSystemLayers(int[] nArray, int[] nArray2, boolean bl) {
        this.warn("MapContentListEmpty#initializeSystemLayers()");
    }

    @Override
    public void updateVisibleLayers(int[] nArray) {
        this.warn("MapContentListEmpty#updateVisibleLayers()");
    }

    @Override
    public void updateAvailableLayers(LayerProperty[] layerPropertyArray) {
        this.warn("MapContentListEmpty#updateAvailableLayers()");
    }

    public void setStoredSystemLayers() {
        this.warn("MapContentListEmpty#setStoredSystemLayers()");
    }

    @Override
    public void restoreDynamicPOIVisibility() {
        this.warn("MapContentListEmpty#restoreDynamicPOIVisibility()");
    }

    @Override
    public void processCategories(int n, Category[] categoryArray) {
        this.warn("MapContentListEmpty#processCategories()");
    }

    @Override
    public boolean toggleTMC() {
        this.warn("MapContentListEmpty#toggleTMC()");
        return false;
    }

    @Override
    public void onChangedMapRenderer() {
    }

    @Override
    public void updateEhCategoryVisibility(int[] nArray) {
    }

    @Override
    public void refresh() {
    }

    @Override
    public int[] getPoiVisibility() {
        return new int[0];
    }

    @Override
    public int[] getSystemLayersAvailable() {
        return new int[0];
    }

    @Override
    public void resetSettings() {
    }

    @Override
    public boolean isWeatherInMapSelected() {
        this.warn("MapContentListEmpty#isWeatherInMapSelected()");
        return false;
    }

    @Override
    public void checkWeatherInMap(boolean bl, boolean bl2, boolean bl3) {
        this.warn("MapContentListEmpty#checkWeatherInMap()");
    }

    @Override
    public String getName() {
        Buffer buffer = new Buffer(50);
        buffer.append("MapContentListEmpty[");
        buffer.append(this.toString());
        buffer.append(']');
        return buffer.toString();
    }

    @Override
    public void jumpToInclude() {
        this.warn("MapContentListEmpty#jumpToInclude()");
    }

    @Override
    public void activateDeactivateWeatherInMap(boolean bl) {
        this.warn("MapContentListEmpty#activateDeactivateWeatherInMap()");
    }
}

