/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.model;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultModelListenerBase;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;

public class TelDefaultButtonListener
extends TelDefaultModelListenerBase
implements ButtonListener {
    private final ButtonModelApp buttonModel;

    public TelDefaultButtonListener(ITelApplication iTelApplication, int n) {
        super(iTelApplication, n);
        this.buttonModel = this.getButtonModel(n);
    }

    public TelDefaultButtonListener(ITelApplication iTelApplication, String string, int n) {
        super(iTelApplication, string, n);
        this.buttonModel = this.getButtonModel(n);
    }

    public void init() {
        super.init();
        this.buttonModel.setButtonListener(this);
    }

    public void deinit() {
        super.deinit();
        this.buttonModel.resetListener();
    }

    protected ButtonModelApp getButtonModel() {
        return this.buttonModel;
    }

    public void keyPressed(int n, int n2, int n3) {
        if (this.log.isDebug()) {
            this.log.log(10000000, "[TelDefaultButtonListener#keyPressed] %1", (Object)TelDefaultButtonListener.getLogMessage(n, n2, n3));
        }
    }

    public void keyReleased(int n, int n2, int n3) {
        if (this.log.isDebug()) {
            this.log.log(10000000, "[TelDefaultButtonListener#keyReleased] %1", (Object)TelDefaultButtonListener.getLogMessage(n, n2, n3));
        }
    }

    public void keyTyped(int n, int n2, int n3) {
        if (this.log.isInfo()) {
            this.log.log(1000000, "[TelDefaultButtonListener#keyTyped] %1", (Object)TelDefaultButtonListener.getLogMessage(n, n2, n3));
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
        if (this.log.isDebug()) {
            this.log.log(10000000, "[TelDefaultButtonListener#keyLongTyped] %1", (Object)TelDefaultButtonListener.getLogMessage(n, n2, n3));
        }
    }
}

