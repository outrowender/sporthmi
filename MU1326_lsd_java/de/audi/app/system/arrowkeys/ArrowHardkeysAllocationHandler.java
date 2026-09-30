/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system.arrowkeys;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;

public class ArrowHardkeysAllocationHandler
implements MsgListener,
ChoiceListener {
    private final IFrameworkAccess framework;
    private final LogChannel log;
    private ChoiceModelApp arrowHardkeysAllocationChoiceModel;

    public ArrowHardkeysAllocationHandler(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.log = this.framework.getLogChannel("App.System.ArrowKeys");
    }

    public void processMsg(int n) {
        switch (n) {
            case 101: {
                this.arrowHardkeysAllocationChoiceModel = this.framework.getHmiServiceApp().getChoiceModel(4304);
                this.arrowHardkeysAllocationChoiceModel.setValue(this.framework.getStorageMgr().getInt(1011, 49, 1));
                this.arrowHardkeysAllocationChoiceModel.setChoiceListener(this);
                this.log.log(1000000, "Initializing arrow hardkeys allocation value to %1", (long)this.arrowHardkeysAllocationChoiceModel.getValue());
                break;
            }
        }
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        switch (n) {
            case 4304: {
                this.log.log(1000000, "Arrow Khardkeys allocation setting %1 is pressed", (long)n2);
                if (this.arrowHardkeysAllocationChoiceModel == null) break;
                this.arrowHardkeysAllocationChoiceModel.setValue(n2);
                this.framework.getStorageMgr().setInt(1011, 49, this.arrowHardkeysAllocationChoiceModel.getValue());
                break;
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }
}

