/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.PartialPopupComponent$1;
import de.audi.app.online.evo.PartialPopupComponent$2;
import de.audi.app.online.evo.PartialPopupScreenAccess;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.ArrayUtilities;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public class PartialPopupComponent
extends AbstractRemoteHMIComponent
implements ButtonListener {
    private PartialPopupScreenAccess screenAccess;
    private String[] buttonIds;

    public PartialPopupComponent(LogChannel logChannel, RemoteHMIService remoteHMIService, ModelGroup modelGroup, OnlineModelBankAccess onlineModelBankAccess) {
        this.screenAccess = new PartialPopupScreenAccess(logChannel, remoteHMIService, modelGroup, onlineModelBankAccess, null);
    }

    @Override
    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        remoteHMIService.addCommandHandler(684625985, new PartialPopupComponent$1(this, "partial-popup-show", remoteHMIService));
        remoteHMIService.addCommandHandler(701403201, new PartialPopupComponent$2(this, "partial-popup-hide"));
        this.screenAccess.getButton1().setButtonListener(this);
        this.screenAccess.getButton2().setButtonListener(this);
    }

    private void showPopup(HMIProperties hMIProperties) {
        this.hidePopup();
        String string = hMIProperties.getString("displayText");
        this.screenAccess.getMessageModel().setText(string);
        int n = this.configureButtons(hMIProperties);
        int n2 = hMIProperties.getInt("value");
        if (n2 != 0) {
            this.screenAccess.getTimeoutModel().setValue(1);
        } else {
            this.screenAccess.getButtonsModel().setValue(1);
        }
        this.logChannel.log(1078071040, "PartialPopupComponent#showPopup: popup shown with displayText='%1', timeoutMilliseconds=%2, buttonCount=%3", (Object)string, (long)n2, (long)n);
    }

    private void hidePopup() {
        this.screenAccess.getButtonsModel().setValue(0);
        this.screenAccess.getTimeoutModel().setValue(0);
        this.logChannel.log(1078071040, "PartialPopupComponent#hidePopup: called");
    }

    private int configureButtons(HMIProperties hMIProperties) {
        this.buttonIds = hMIProperties.getStringArray("buttonTextId");
        String[] stringArray = hMIProperties.getStringArray("buttonText");
        int n = stringArray == null ? 0 : stringArray.length;
        this.screenAccess.getLabelButton1().setText(ArrayUtilities.getSafeArrayValue(stringArray, 0));
        this.screenAccess.getLabelButton2().setText(ArrayUtilities.getSafeArrayValue(stringArray, 1));
        this.screenAccess.getButton1().setStatus(n > 0 ? 1 : 0);
        this.screenAccess.getButton2().setStatus(n > 1 ? 1 : 0);
        return n;
    }

    private String getButtonId(int n) {
        return this.buttonIds != null && n < this.buttonIds.length ? this.buttonIds[n] : "";
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        int n4;
        if (n == this.screenAccess.getIdButton1()) {
            n4 = 0;
        } else if (n == this.screenAccess.getIdButton2()) {
            n4 = 1;
        } else {
            this.logChannel.log(-1601830656, "PartialPopupComponent#keyPressed: called with unknown key with modelId=%1", (long)n);
            return;
        }
        RemoteHMIAction remoteHMIAction = this.remoteHmiService.getAction(-1045063680);
        HMIProperties hMIProperties = remoteHMIAction.getParameters();
        hMIProperties.putInt("selectedNumber", n4);
        hMIProperties.putString("selectedId", this.getButtonId(n4));
        this.remoteHmiService.invokeAction(remoteHMIAction);
        this.screenAccess.getButtonsModel().setValue(0);
        this.screenAccess.flushModelGroup();
        this.logChannel.log(1078071040, "PartialPopupComponent#keyPressed: called with keyIndex=%1", (long)n4);
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    static /* synthetic */ void access$100(PartialPopupComponent partialPopupComponent, HMIProperties hMIProperties) {
        partialPopupComponent.showPopup(hMIProperties);
    }

    static /* synthetic */ PartialPopupScreenAccess access$200(PartialPopupComponent partialPopupComponent) {
        return partialPopupComponent.screenAccess;
    }

    static /* synthetic */ void access$300(PartialPopupComponent partialPopupComponent) {
        partialPopupComponent.hidePopup();
    }
}

