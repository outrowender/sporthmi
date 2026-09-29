/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system.proximity;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;

public class ProximitySensorHandler
implements MsgListener,
ChoiceListener {
    private final IFrameworkAccess framework;
    private final LogChannel log;
    private ChoiceModelApp proximityChoiceModel;

    public ProximitySensorHandler(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.log = this.framework.getLogChannel("App.System.Proximity");
    }

    @Override
    public void processMsg(int n) {
        switch (n) {
            case 101: {
                int n2 = this.framework.getSysConstManager().getSysConst(4175);
                this.proximityChoiceModel = this.framework.getHmiServiceApp().getChoiceModel(4125);
                if (n2 == 0) {
                    this.proximityChoiceModel.setValue(0);
                    this.log.log(1078071040, "No proximity sensor available");
                } else {
                    this.proximityChoiceModel.setValue(this.framework.getStorageMgr().getInt(1011, 45, 1));
                    this.proximityChoiceModel.setChoiceListener(this);
                }
                this.log.log(1078071040, "Initializing proximity sensor value to %1", (long)this.proximityChoiceModel.getValue());
                break;
            }
        }
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

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        switch (n) {
            case 4125: {
                this.log.log(1078071040, "Proximity sensor setting %1 is pressed", (long)n2);
                if (this.proximityChoiceModel == null) break;
                this.proximityChoiceModel.setValue(n2);
                this.framework.getStorageMgr().setInt(1011, 45, this.proximityChoiceModel.getValue());
                break;
            }
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }
}

