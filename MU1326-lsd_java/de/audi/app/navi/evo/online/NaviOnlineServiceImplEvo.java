/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.online;

import de.audi.app.navi.evo.online.RemoteHMIAppsDestinationListener;
import de.audi.app.navi.evo.online.RemoteHMIAppsMapListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.NaviOnlineService$POIOnlineData;
import de.audi.atip.interapp.NaviOnlineService$RrdData;
import de.audi.atip.interapp.online.OnlineApplicationOtherContext;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.OperationManager;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.poi.rrd.IRRDListener;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.online.NaviOnlineServiceImpl;
import de.audi.tghu.navi.app.routeguidance.AddSelectedDestinationAtIndexCommandListCreator;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public class NaviOnlineServiceImplEvo
extends NaviOnlineServiceImpl
implements TimerListener {
    public static final long AIR_DELAY;
    private ArrayList airDistanceListEvo;
    private final RemoteHMIAppsMapListener remoteHMIAppsMapListener;
    private final RemoteHMIAppsDestinationListener remoteHMIAppsDestinationListener;
    private final ChoiceModelApp numberOfMiniAppsModel;
    private List previousRemoteHMIApps;

    public NaviOnlineServiceImplEvo(NavigationEnv navigationEnv, LogChannel logChannel, IVehicle iVehicle, MapInterface mapInterface, IRouteManager iRouteManager, OperationManager operationManager, ICommandListFactory iCommandListFactory, IAddressInputForm iAddressInputForm, IRRDListener iRRDListener, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, RemoteHMIAppsDestinationListener remoteHMIAppsDestinationListener, RemoteHMIAppsMapListener remoteHMIAppsMapListener, AddSelectedDestinationAtIndexCommandListCreator addSelectedDestinationAtIndexCommandListCreator) {
        super(navigationEnv, logChannel, iVehicle, mapInterface, iRouteManager, operationManager, iCommandListFactory, iAddressInputForm, iRRDListener, iStartGuidanceToDestinationSequence, addSelectedDestinationAtIndexCommandListCreator);
        this.remoteHMIAppsDestinationListener = remoteHMIAppsDestinationListener;
        this.remoteHMIAppsMapListener = remoteHMIAppsMapListener;
        this.updateAirdistanceTimer = new Timer("NaviOnlineServiceImplEvo", 5, null, this, 0, false);
        this.numberOfMiniAppsModel = navigationEnv.getChoiceModel(-2128607744);
        this.numberOfMiniAppsModel.setValue(0);
        this.numberOfMiniAppsModel.setStatus(3);
    }

    @Override
    public void sendRemoteHMIAppsUpdateToNaviAndMap(List list) {
        int n = list.size();
        this.logChannel.log(-2137614336, "NaviOnlineServiceImplEvo#sendRemoteHMIAppsUpdateToNaviAndMap: Called with list size '%1'", (long)n);
        this.numberOfMiniAppsModel.setValue(n);
        if (this.sameAsPreviousApps(list)) {
            this.logChannel.log(-2137614336, "NaviOnlineServiceImplEvo#sendRemoteHMIAppsUpdateToNaviAndMap: new and old list are same so not updating");
        } else {
            this.previousRemoteHMIApps = list;
            this.remoteHMIAppsDestinationListener.setMiniApps(list, RemoteHMIAppsDestinationListener.ONLINE_RIGHT_DRAWER_ENTRIES_MODELS_FOR_DESTINATION);
            this.remoteHMIAppsMapListener.setMiniApps(list, RemoteHMIAppsMapListener.ONLINE_RIGHT_DRAWER_ENTRIES_MODELS_FOR_MAP);
            int n2 = this.numberOfMiniAppsModel.getValue() == 0 ? 3 : 1;
            this.remoteHMIAppsDestinationListener.configureModelsMiniApps(n2, 48);
        }
    }

    private boolean sameAsPreviousApps(List list) {
        int n;
        if (this.previousRemoteHMIApps == null) {
            this.logChannel.log(-2137614336, "NaviOnlineServiceImplEvo#sameAsPreviousApps: no previous apps exist");
            return false;
        }
        int n2 = this.previousRemoteHMIApps.size();
        if (n2 != (n = list.size())) {
            this.logChannel.log(-2137614336, "NaviOnlineServiceImplEvo#sameAsPreviousApps: number of apps different, previous list size = %1, new list size = %2", (long)n2, (long)n);
            return false;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            OnlineApplicationOtherContext onlineApplicationOtherContext;
            OnlineApplicationOtherContext onlineApplicationOtherContext2 = (OnlineApplicationOtherContext)this.previousRemoteHMIApps.get(i2);
            if (onlineApplicationOtherContext2.equals(onlineApplicationOtherContext = (OnlineApplicationOtherContext)list.get(i2))) continue;
            return false;
        }
        return true;
    }

    @Override
    public void sendMiniAppsDownloadError() {
        this.logChannel.log(-2137614336, "NaviOnlineServiceImplEvo#sendMiniAppsDownloadError: Called");
        this.remoteHMIAppsDestinationListener.errorOccured();
    }

    @Override
    protected void overrideVariantSpecificPOIViewportValues(NaviOnlineService$POIOnlineData[] naviOnlineService$POIOnlineDataArray, PoiOnlineSearchValuelistElement[] poiOnlineSearchValuelistElementArray, int n) {
        super.overrideVariantSpecificPOIViewportValues(naviOnlineService$POIOnlineDataArray, poiOnlineSearchValuelistElementArray, n);
        poiOnlineSearchValuelistElementArray[n].name = naviOnlineService$POIOnlineDataArray[n].line0 != "" && naviOnlineService$POIOnlineDataArray[n].line1 != "" ? new StringBuffer().append(naviOnlineService$POIOnlineDataArray[n].line0).append("\n").append(naviOnlineService$POIOnlineDataArray[n].line1).toString() : naviOnlineService$POIOnlineDataArray[n].line0;
    }

    @Override
    public synchronized void swapModel(Object object, Object object2, Object object3, int n, int n2) {
        int n3 = this.swapModel(this.rrdRequestList, object, object2, object3);
        if (n3 > -1) {
            this.latitudes[n3] = n;
            this.longitudes[n3] = n2;
        }
        this.swapModel(this.airDistanceListEvo, object, object2, object3);
    }

    private int swapModel(ArrayList arrayList, Object object, Object object2, Object object3) {
        if (arrayList == null) {
            return -1;
        }
        int n = arrayList.size();
        for (int i2 = 0; i2 < n; ++i2) {
            NaviOnlineService$RrdData naviOnlineService$RrdData = (NaviOnlineService$RrdData)arrayList.get(i2);
            if (naviOnlineService$RrdData.getModelContainer() != object || naviOnlineService$RrdData.getModel() != object2) continue;
            naviOnlineService$RrdData.setModel(object3);
            return i2;
        }
        return -1;
    }
}

