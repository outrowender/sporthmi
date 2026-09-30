/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system.footer;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;

public class DisplayFooterHandler
implements MsgListener,
ChoiceListener {
    private final IFrameworkAccess framework;
    private final LogChannel log;
    private ChoiceModelApp footerChoiceModel;

    public DisplayFooterHandler(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.log = this.framework.getLogChannel("App.Settings.Display");
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
            case 4233: {
                this.footerChoiceModel.setValue(n2);
                this.framework.getStorageMgr().setInt(1011, 47, this.footerChoiceModel.getValue());
                break;
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void processMsg(int n) {
        switch (n) {
            case 101: {
                this.footerChoiceModel = this.framework.getHmiServiceApp().getChoiceModel(4233);
                this.footerChoiceModel.setValue(this.framework.getStorageMgr().getInt(1011, 47, 1));
                this.footerChoiceModel.setChoiceListener(this);
                this.log.log(1000000, "Initializing footer value to %1", (long)this.footerChoiceModel.getValue());
                break;
            }
        }
    }
}

