/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.PartialPopupScreenAccess;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.ArrayUtilities;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.RemoteHMITask;

public class PartialPopupComponent
extends AbstractRemoteHMIComponent
implements ButtonListener {
    private PartialPopupScreenAccess screenAccess;
    private String[] buttonIds;

    public PartialPopupComponent(LogChannel logChannel, RemoteHMIService remoteHMIService, ModelGroup modelGroup, OnlineModelBankAccess onlineModelBankAccess) {
        this.screenAccess = new PartialPopupScreenAccess(logChannel, remoteHMIService, modelGroup, onlineModelBankAccess, null);
    }

    public void init(LogChannel logChannel, final RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        remoteHMIService.addCommandHandler(1100009000, new AbstractCommandHandler("partial-popup-show"){

            public void indicateCommand(int n, final Object object) {
                RemoteHMITask remoteHMITask = new RemoteHMITask(){

                    public void run() {
                        PartialPopupComponent.this.showPopup((HMIProperties)object);
                        PartialPopupComponent.this.screenAccess.flushModelGroup();
                    }

                    public boolean isCoalescable() {
                        return false;
                    }

                    public Long getDelayMillis() {
                        return new Long(100L);
                    }

                    public boolean coalesceWith(RemoteHMITask remoteHMITask) {
                        return false;
                    }
                };
                remoteHMIService.execute(remoteHMITask);
            }
        });
        remoteHMIService.addCommandHandler(1100009001, new AbstractCommandHandler("partial-popup-hide"){

            public void indicateCommand(int n, Object object) {
                PartialPopupComponent.this.hidePopup();
                PartialPopupComponent.this.screenAccess.flushModelGroup();
            }
        });
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
        this.logChannel.log(1000000, "PartialPopupComponent#showPopup: popup shown with displayText='%1', timeoutMilliseconds=%2, buttonCount=%3", (Object)string, (long)n2, (long)n);
    }

    private void hidePopup() {
        this.screenAccess.getButtonsModel().setValue(0);
        this.screenAccess.getTimeoutModel().setValue(0);
        this.logChannel.log(1000000, "PartialPopupComponent#hidePopup: called");
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

    public void keyPressed(int n, int n2, int n3) {
        int n4;
        if (n == this.screenAccess.getIdButton1()) {
            n4 = 0;
        } else if (n == this.screenAccess.getIdButton2()) {
            n4 = 1;
        } else {
            this.logChannel.log(100000, "PartialPopupComponent#keyPressed: called with unknown key with modelId=%1", (long)n);
            return;
        }
        RemoteHMIAction remoteHMIAction = this.remoteHmiService.getAction(10008001);
        HMIProperties hMIProperties = remoteHMIAction.getParameters();
        hMIProperties.putInt("selectedNumber", n4);
        hMIProperties.putString("selectedId", this.getButtonId(n4));
        this.remoteHmiService.invokeAction(remoteHMIAction);
        this.screenAccess.getButtonsModel().setValue(0);
        this.screenAccess.flushModelGroup();
        this.logChannel.log(1000000, "PartialPopupComponent#keyPressed: called with keyIndex=%1", (long)n4);
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }
}

