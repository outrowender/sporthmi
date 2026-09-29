/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener;

import de.audi.app.navi.evo.addressinput.poi.PoiManager;
import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public abstract class AbstractPoiScreenHmiListener
implements MenuModelListener {
    public static final int AMOUNT_OF_POIS_TO_DISPLAY;
    protected boolean displayMultiplePois = true;
    protected final NavigationEnv env;
    protected final PoiManager poiManager;
    protected final LogChannel logChannel;
    protected final IPreviewMap previewMapInterface;
    protected final PoiSearchArea poiSearchArea;
    protected static final int SPELLER_OPENED;
    protected static final int SPELLER_CLOSED;
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());

    public AbstractPoiScreenHmiListener(NavigationEnv navigationEnv, PoiManager poiManager, IPreviewMap iPreviewMap, PoiSearchArea poiSearchArea) {
        this.env = navigationEnv;
        this.poiManager = poiManager;
        this.previewMapInterface = iPreviewMap;
        this.poiSearchArea = poiSearchArea;
        this.logChannel = navigationEnv.getPOILogChannel();
        this.registerAsListener();
    }

    public abstract CommandList getStartCommandList() {
    }

    protected abstract void registerAsListener() {
    }

    public abstract void preparePreviewMap() {
    }

    protected LIValueListElement getLiValueListElement(EvoListRow evoListRow, int n) {
        return PoiScreensEvo.getLiValueListElementFromRow(evoListRow, n);
    }

    protected void previewSearchLocation(int n, NavLocation navLocation) {
        this.logChannel.log(-2137614336, "AbstractPoiScreenHmiListener#previewSearchLocation() - currentSearchLocation=%1, searchContext=%2", (Object)LocationFormatter.formatLocationShort(navLocation), (long)n);
        if (navLocation == null) {
            switch (n) {
                case 1: {
                    this.previewMapInterface.setPreviewRoute(true, 1, null, null);
                    break;
                }
                case 5: {
                    this.previewMapInterface.setPreviewAreaAroundCCP(1);
                    break;
                }
                default: {
                    this.logChannel.log(-2137614336, "AbstractPoiScreenHmiListener#previewSearchLocation() - unknown search context: %1", (long)n);
                    this.previewMapInterface.setPreviewAreaAroundCCP(1);
                    break;
                }
            }
        } else if (n == 2 || n == 3) {
            this.previewMapInterface.setPreviewDestination(navLocation, 1, null, null);
        } else if (n == 0) {
            this.previewMapInterface.setPreviewAreaAroundCCP(1);
        } else if (n == 4) {
            this.previewMapInterface.setPreviewLocationCity(navLocation, 1, null, null);
        } else {
            this.previewMapInterface.setPreviewLocation(navLocation, 1, null, null);
        }
    }

    public void updateResultsAvailable() {
    }

    public void updateSearchStarted() {
    }

    public void resetPendingPreviewMapRequests() {
    }
}

