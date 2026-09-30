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
        this.subtitle = onlineModelBankAccess.getLabelModel(2301002);
        this.subtitle.setText("");
        this.breadcrumb = onlineModelBankAccess.getLabelModel(2301001);
        this.breadcrumb.setText("");
        this.waitingIcon = onlineModelBankAccess.getChoiceModel(2301003);
        this.textModel = onlineModelBankAccess.getLabelModel(2301014);
        modelGroup.add(this.textModel);
        modelGroup.add(this.subtitle);
        modelGroup.add(this.breadcrumb);
        modelGroup.add(this.waitingIcon);
    }

    public void updateViewProperties(HMIProperties hMIProperties, boolean bl, RemoteHMIContext remoteHMIContext) {
        this.handleScreenType(hMIProperties);
        super.updateViewProperties(hMIProperties, bl, remoteHMIContext);
        this.breadcrumb.setText("");
        this.subtitle.setText("");
        this.waitingIcon.setValue(1);
        this.textModel.setText(hMIProperties.getString("displayText"));
        remoteHMIContext.setLastAction(new RemoteHMIAction(0));
    }

    public void onExit() {
        super.onExit();
    }

    public boolean isTriggerScreenChange() {
        return true;
    }

    public boolean doLockModelGroup() {
        return true;
    }
}

