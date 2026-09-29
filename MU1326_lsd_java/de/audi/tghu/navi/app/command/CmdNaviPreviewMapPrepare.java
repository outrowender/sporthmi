/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.command.NavCommand;
import java.util.ArrayList;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;

public class CmdNaviPreviewMapPrepare
extends NavCommand {
    private final IPreviewMap previewMap;
    private NavLocation[] poiNavLocations;
    private final NavLocationWgs84 currentSearchLocation;
    private final int searchContext;
    private boolean hidePreviewMap;

    public CmdNaviPreviewMapPrepare(IPreviewMap iPreviewMap, NavLocation[] navLocationArray, NavLocationWgs84 navLocationWgs84, int n) {
        this.poiNavLocations = navLocationArray;
        this.previewMap = iPreviewMap;
        this.currentSearchLocation = navLocationWgs84;
        this.searchContext = n;
        this.hidePreviewMap = false;
    }

    public void setHidePreviewMap(boolean bl) {
        this.hidePreviewMap = bl;
    }

    public boolean getHidePreviewMap() {
        return this.hidePreviewMap;
    }

    @Override
    public void execute() {
        this.poiNavLocations = this.removeInvalidLocations(this.poiNavLocations);
        if (this.poiNavLocations.length == 0 || this.hidePreviewMap) {
            this.logger.log(-2137614336, "%1#execute - previewMap.hidePreviewMap() - hidePreviewMap = %2", (Object)this.CLASS_NAME, (Object)String.valueOf(this.hidePreviewMap));
            this.previewMap.hidePreviewMap();
            this.hidePreviewMap = true;
        } else if (this.currentSearchLocation == null || this.searchContext == 1) {
            this.logger.log(-2137614336, "%1#execute - previewMap.previewPOIsAroundCCP(poiNavLocations)", (Object)this.CLASS_NAME);
            this.previewMap.setPreviewPOIsOnboardAroundCCP(this.poiNavLocations, 1, null, null);
        } else if (this.searchContext == 4 || this.searchContext == 0) {
            this.logger.log(-2137614336, "%1#execute - previewMap.previewPOIsAroundReferencePoint(poiNavLocations, currentSearchLocation)", (Object)this.CLASS_NAME);
            this.previewMap.setPreviewPOIsOnboardAroundReferencePoint(this.poiNavLocations, this.currentSearchLocation, 1, null, null);
        } else if (this.searchContext == 2 || this.searchContext == 3) {
            this.logger.log(-2137614336, "%1#execute - previewMap.previewPOIsAroundDestination(poiNavLocations, currentSearchLocation)", (Object)this.CLASS_NAME);
            this.previewMap.setPreviewPOIsOnboardAroundDestination(this.poiNavLocations, this.currentSearchLocation, 1, null, null);
        } else {
            this.logger.log(-2137614336, "%1#execute - previewMap.previewPOIs(poiNavLocations);", (Object)this.CLASS_NAME);
            this.previewMap.setPreviewPOIsOnboard(this.poiNavLocations, 1, null, null);
        }
        this.getCommandList().commandFinished();
    }

    private NavLocation[] removeInvalidLocations(NavLocation[] navLocationArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < navLocationArray.length; ++i2) {
            if (!navLocationArray[i2].isPositionValid()) continue;
            arrayList.add(navLocationArray[i2]);
        }
        return (NavLocation[])arrayList.toArray(new NavLocation[arrayList.size()]);
    }
}

