/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system.wlc;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;

public class WirelessChargingHandler
implements MsgListener,
ChoiceListener {
    private final IFrameworkAccess framework;
    private final LogChannel log;
    private ChoiceModelApp wlcInfoPopupModel;

    public WirelessChargingHandler(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.log = this.framework.getLogChannel("App.System.WirelessCharging");
    }

    @Override
    public void processMsg(int n) {
        switch (n) {
            case 101: {
                this.wlcInfoPopupModel = this.framework.getHmiServiceApp().getChoiceModel(4343);
                if (!this.isWirelessChargingAvailable()) break;
                this.wlcInfoPopupModel.setValue(this.framework.getStorageMgr().getInt(1009, 10, 0));
                this.wlcInfoPopupModel.setChoiceListener(this);
                this.log.log(1078071040, "Enabling wireless charging info popups, allocation value to %1", (long)this.wlcInfoPopupModel.getValue());
                break;
            }
        }
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n == this.wlcInfoPopupModel.getID()) {
            this.log.log(1078071040, "[WirelessChargingVolumeRange.itemSelected] itemID : %1", (long)n2);
            this.framework.getStorageMgr().setInt(1009, 10, n2);
            this.wlcInfoPopupModel.setValue(n2);
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
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

    private final boolean isWirelessChargingAvailable() {
        return this.framework.getSysConst(4162) == 1;
    }
}

