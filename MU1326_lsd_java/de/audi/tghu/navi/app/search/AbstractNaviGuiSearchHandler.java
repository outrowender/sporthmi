/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractGuiSearchHandler;
import de.audi.atip.search.AbstractSearch;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public abstract class AbstractNaviGuiSearchHandler
extends AbstractGuiSearchHandler {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    protected final IPreviewMap previewMap;
    private boolean isActive;

    public AbstractNaviGuiSearchHandler(int[] nArray, BaseListModelApp baseListModelApp, SpellerModelApp spellerModelApp, ChoiceModelApp choiceModelApp, LogChannel logChannel, AbstractSearch abstractSearch, IPreviewMap iPreviewMap) {
        super(nArray, baseListModelApp, spellerModelApp, choiceModelApp, logChannel, abstractSearch);
        this.previewMap = iPreviewMap;
    }

    public abstract NavLocation extractNavLocationFromRow(EvoListRow evoListRow) {
    }

    public abstract void handleIfPoiIsCallable(NavLocation navLocation, EvoListRow evoListRow) {
    }

    public void hidePreviewMap() {
        this.previewMap.hidePreviewMap();
    }

    public void focusPreviewAreaAroundCCP() {
        this.previewMap.setPreviewAreaAroundCCP(1);
    }

    public boolean isActive() {
        this.lc.log(-2137614336, "%2#isActive: %1", this.isActive, (Object)this.CLASS_NAME);
        return this.isActive;
    }

    public void setIsActive(boolean bl) {
        this.lc.log(-2137614336, "%2#setIsActive: %1", bl, (Object)this.CLASS_NAME);
        this.isActive = bl;
    }

    public void focusPreviewMapOnNavLocation(NavLocation navLocation, boolean bl) {
        if (navLocation != null) {
            if (this.lc.isDebug2()) {
                this.lc.log(14808325, "%1#focusPreviewMapOnNavLocation() - location = %2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
            }
            if (bl) {
                this.previewMap.setPreviewFavorite(navLocation, 1, null, null);
            } else {
                this.previewMap.setPreviewLocationDistant(navLocation, 1, null, null);
            }
        } else {
            this.lc.log(-2137614336, "%1#focusPreviewMapOnNavLocation() - no location", (Object)this.CLASS_NAME);
        }
    }

    public NavLocation getNavLocationFromTrufflesCoord(float f2, float f3) {
        int n = Util.degreeStringToWgs84(String.valueOf(f2));
        int n2 = Util.degreeStringToWgs84(String.valueOf(f3));
        return Util.getLocationFromGeoPos(n, n2);
    }

    public void focusPreviewMapOnPOIs(NavLocation[] navLocationArray) {
        if (navLocationArray != null && navLocationArray.length > 0) {
            if (this.lc.isDebug2()) {
                this.lc.log(14808325, "%1#focusPreviewMapOnPOIs() - poi = %2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocationArray[0]));
            }
            this.previewMap.setPreviewPOIsOnboardDistant(navLocationArray, 1, null, null);
        } else {
            this.lc.log(-2137614336, "%1#focusPreviewMapOnPOIs() - no location", (Object)this.CLASS_NAME);
        }
    }

    public void focusPreviewMapOnDestination(NavLocation navLocation) {
        if (navLocation != null) {
            if (this.lc.isDebug2()) {
                this.lc.log(14808325, "%1#focusPreviewMapOnDestination() - location = %2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
            }
            this.previewMap.setPreviewDestination(navLocation, 1, null, null);
        } else if (this.lc.isDebug2()) {
            this.lc.log(14808325, "%1#focusPreviewMapOnNavLocation() - no location", (Object)this.CLASS_NAME);
        }
    }

    public void focusPreviewMapOnCity(NavLocation navLocation) {
        if (navLocation != null) {
            if (this.lc.isDebug2()) {
                this.lc.log(14808325, "%1#focusPreviewMapOnNavLocation() - location = %2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
            }
            this.previewMap.setPreviewLocationCity(navLocation, 1, null, null);
        } else if (this.lc.isDebug2()) {
            this.lc.log(14808325, "%1#focusPreviewMapOnNavLocation() - no location", (Object)this.CLASS_NAME);
        }
    }
}

