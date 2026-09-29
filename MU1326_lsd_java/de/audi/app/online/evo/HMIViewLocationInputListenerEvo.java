/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.AbstractHMIViewListenerEvo;
import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.interapp.NaviOnlineService;
import de.audi.atip.interapp.NaviOnlineService$NaviOnlineSearchAreaListener;
import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.remotehmi.RemoteHMILocation;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.util.NavUtil;
import de.esolutions.fw.util.commons.Buffer;

public class HMIViewLocationInputListenerEvo
extends AbstractHMIViewListenerEvo
implements NaviOnlineService$NaviOnlineSearchAreaListener {
    public HMIViewLocationInputListenerEvo(LogChannel logChannel, ModelGroup modelGroup, OnlineModelBankAccess onlineModelBankAccess, HMIService hMIService, RemoteHMIServiceEvo remoteHMIServiceEvo) {
        super(logChannel, modelGroup, onlineModelBankAccess, hMIService, remoteHMIServiceEvo);
        modelGroup.add(onlineModelBankAccess.getButtonModel(622600960));
        modelGroup.add(onlineModelBankAccess.getButtonModel(639378176));
        modelGroup.add(onlineModelBankAccess.getButtonModel(656155392));
        modelGroup.add(onlineModelBankAccess.getLabelModel(3891));
        modelGroup.add(onlineModelBankAccess.getLabelModel(3890));
    }

    @Override
    public void updateViewProperties(HMIProperties hMIProperties, boolean bl, RemoteHMIContext remoteHMIContext) {
        this.handleScreenType(hMIProperties);
        super.updateViewProperties(hMIProperties, bl, remoteHMIContext);
        LabelModelApp labelModelApp = this.modelBank.getLabelModel(3891);
        LabelModelApp labelModelApp2 = this.modelBank.getLabelModel(3890);
        this.setTitles(labelModelApp, labelModelApp2, hMIProperties);
        NaviOnlineService naviOnlineService = this.remoteHmiService.getNaviComponent().getNaviOnlineService();
        this.checkNaviOperable(naviOnlineService);
        if (naviOnlineService != null) {
            if (bl) {
                this.logChannel.log(1078071040, "HMIViewLocationInputListenerEvo#updateViewProperties: calling NaviOnlineService to prepare address input");
                naviOnlineService.prepareAddressForm();
            } else {
                this.logChannel.log(1078071040, "HMIViewLocationInputListenerEvo#updateViewProperties: got non-initial view, not calling NaviOnlineService");
            }
        } else {
            this.logChannel.log(10000, "HMIViewLocationInputListenerEvo#updateViewProperties: NaviOnlineService is not available");
        }
    }

    public int getViewID() {
        return 6100;
    }

    @Override
    public void updateSearchLocation(IMyLocationAccessor iMyLocationAccessor) {
        Buffer buffer = new Buffer();
        buffer.append(iMyLocationAccessor.getCountry());
        buffer.append(", ");
        buffer.append(iMyLocationAccessor.getTown());
        buffer.append(", ");
        buffer.append(iMyLocationAccessor.getStreet());
        this.logChannel.log(-2137614336, "HMIViewLocationInputListenerEvo#updateSearchLocation: %1/%2, %3, %4", (Object)Double.toString((double)iMyLocationAccessor.getLatitude()), (Object)Double.toString((double)iMyLocationAccessor.getLongitude()), (Object)buffer.toString(), (Object)iMyLocationAccessor.getHousenumber());
        RemoteHMIAction remoteHMIAction = this.getAction(300);
        remoteHMIAction.getParameters().putInt("selectedNumber", 0);
        remoteHMIAction.getParameters().putString("selectedId", this.getSelectedId(0));
        remoteHMIAction.getParameters().putString("actionId", this.getSelectedId(0));
        RemoteHMILocation remoteHMILocation = NavUtil.getRemoteLocationFromNavLocation(iMyLocationAccessor);
        remoteHMIAction.getParameters().put("loc", remoteHMILocation);
        this.invokeAction(remoteHMIAction);
    }

    public ListModelApp getRightDrawerModel() {
        return this.modelBank.getListModel(404431616);
    }
}

