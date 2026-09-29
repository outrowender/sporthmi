/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.HMIViewGridListener;
import de.audi.app.online.evo.HMIViewLocationInputListenerEvo;
import de.audi.app.online.evo.HMIViewMapListener;
import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.atip.interapp.NaviOnlineService;
import de.audi.atip.interapp.NaviOnlineService$MapStateService;
import de.audi.atip.interapp.NaviService;
import de.audi.tghu.online.app.remotehmi.NaviComponent;

public class NaviComponentEvo
extends NaviComponent {
    @Override
    public void setNaviService(NaviService naviService) {
        super.setNaviService(naviService);
        NaviOnlineService naviOnlineService = this.getNaviOnlineService();
        if (naviOnlineService == null) {
            this.logChannel.log(10000, "NaviComponentEvo#setNaviService: NaviOnlineService is null");
        } else {
            HMIViewMapListener hMIViewMapListener = (HMIViewMapListener)this.remoteHmiService.getViewListener(6000);
            if (hMIViewMapListener == null) {
                this.logChannel.log(10000, "NaviComponentEvo#setNaviService: HMIViewMapListener is null");
            } else {
                naviOnlineService.setListener(hMIViewMapListener);
            }
            HMIViewGridListener hMIViewGridListener = (HMIViewGridListener)this.remoteHmiService.getViewListener(13000);
            if (hMIViewGridListener == null) {
                this.logChannel.log(10000, "NaviComponentEvo#setNaviService: HMIViewGridListener is null");
            } else {
                naviOnlineService.setRRDListener(hMIViewGridListener);
            }
            HMIViewLocationInputListenerEvo hMIViewLocationInputListenerEvo = (HMIViewLocationInputListenerEvo)this.remoteHmiService.getViewListener(6100);
            if (hMIViewGridListener == null) {
                this.logChannel.log(10000, "NaviComponentEvo#setNaviService: HMIViewLocationInputListenerEvo is null");
            } else {
                naviOnlineService.setSearchAreaListener(hMIViewLocationInputListenerEvo);
            }
            NaviOnlineService$MapStateService naviOnlineService$MapStateService = this.remoteHmiService.getMapStateService();
            if (naviOnlineService$MapStateService == null) {
                this.logChannel.log(10000, "NaviComponentEvo#setNaviService: mapStateService is null");
            } else {
                naviOnlineService.setMapStateService(naviOnlineService$MapStateService);
            }
        }
        this.logChannel.log(-2137614336, "NaviComponentEvo#setNaviService: send initial action data");
        this.remoteHmiService.invokeAction(this.remoteHmiService.getAction(1));
        if (naviService != null) {
            ((RemoteHMIServiceEvo)this.remoteHmiService).onlineEvoServiceProvider.sendSavedAppsUpdateToDestAndMap(naviService);
        }
    }
}

