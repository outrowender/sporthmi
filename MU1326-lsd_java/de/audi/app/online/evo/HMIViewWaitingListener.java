/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.AbstractHMIViewListenerEvo;
import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;

public class HMIViewWaitingListener
extends AbstractHMIViewListenerEvo {
    private LabelModelApp subtitle;
    private LabelModelApp breadcrumb;
    private ChoiceModelApp waitingIcon;
    private LabelModelApp textModel;

    public HMIViewWaitingListener(LogChannel logChannel, ModelGroup modelGroup, OnlineModelBankAccess onlineModelBankAccess, HMIService hMIService, RemoteHMIServiceEvo remoteHMIServiceEvo) {
        super(logChannel, modelGroup, onlineModelBankAccess, hMIService, remoteHMIServiceEvo);
        this.subtitle = onlineModelBankAccess.getLabelModel(1243357952);
        this.subtitle.setText("");
        this.breadcrumb = onlineModelBankAccess.getLabelModel(1226580736);
        this.breadcrumb.setText("");
        this.waitingIcon = onlineModelBankAccess.getChoiceModel(1260135168);
        this.textModel = onlineModelBankAccess.getLabelModel(1444684544);
        modelGroup.add(this.textModel);
        modelGroup.add(this.subtitle);
        modelGroup.add(this.breadcrumb);
        modelGroup.add(this.waitingIcon);
    }

    @Override
    public void updateViewProperties(HMIProperties hMIProperties, boolean bl, RemoteHMIContext remoteHMIContext) {
        this.handleScreenType(hMIProperties);
        super.updateViewProperties(hMIProperties, bl, remoteHMIContext);
        this.breadcrumb.setText("");
        this.subtitle.setText("");
        this.waitingIcon.setValue(1);
        this.textModel.setText(hMIProperties.getString("displayText"));
        remoteHMIContext.setLastAction(new RemoteHMIAction(0));
    }

    @Override
    public void onExit() {
        super.onExit();
    }

    @Override
    public boolean isTriggerScreenChange() {
        return true;
    }

    public boolean doLockModelGroup() {
        return true;
    }
}

