/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.INaviFormattingService;
import de.audi.atip.interapp.MapService;
import de.audi.atip.interapp.NaviADBService;
import de.audi.atip.interapp.NaviOnlineService;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public class NaviComponent
extends AbstractRemoteHMIComponent {
    private NaviService naviService;
    private NaviADBService naviADBService;
    private IPreviewMap previewMapService;
    private MapService mapService;
    private INaviFormattingService formattingService;

    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        this.setRemoteHMILocationInputMode(false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setRemoteHMILocationInputMode(boolean bl) {
        this.logChannel.log(1000000, "NaviComponent#setRemoteHMILocationInputMode: %1", (Object)Boolean.toString(bl));
        NaviComponent naviComponent = this;
        synchronized (naviComponent) {
            this.remoteHmiService.getFrameworkAccess().getHmiServiceApp().getButtonModel(205).setStatus(bl ? 1 : 0);
        }
    }

    public void setNaviService(NaviService naviService) {
        this.naviService = naviService;
    }

    public void setNaviServiceNoInit(NaviService naviService) {
        this.naviService = naviService;
    }

    public NaviService getNaviService() {
        return this.naviService;
    }

    public NaviOnlineService getNaviOnlineService() {
        NaviService naviService = this.getNaviService();
        if (naviService != null) {
            return naviService.getNaviOnlineService();
        }
        return null;
    }

    public INaviFormattingService getFormattingService() {
        return this.formattingService;
    }

    public MapService getMapService() {
        return this.mapService;
    }

    public void setMapService(MapService mapService) {
        this.mapService = mapService;
    }

    public void setPreviewMap(IPreviewMap iPreviewMap) {
        this.previewMapService = iPreviewMap;
    }

    public IPreviewMap getPreviewMap() {
        return this.previewMapService;
    }

    public NaviADBService getNaviADBService() {
        return this.naviADBService;
    }

    public void setNaviADBService(NaviADBService naviADBService) {
        this.naviADBService = naviADBService;
    }

    public void setNaviFormattingService(INaviFormattingService iNaviFormattingService) {
        this.formattingService = iNaviFormattingService;
    }
}

