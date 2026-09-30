/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.screen;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.screen.IPopupStateListener;

public abstract class AbstractTelPopupHandler
extends AbstractPhoneComponent
implements IPopupStateListener {
    private static final int STATE_IDLE = 0;
    private static final int STATE_SHOW_REQUESTED = 1;
    private static final int STATE_VISIBLE = 2;
    private static final int STATE_HIDDEN = 3;
    private static final int STATE_REMOVE_REQUESTED = 4;
    private final int popupID;
    private volatile int state;

    private static String getStateName(int n) {
        switch (n) {
            case 0: {
                return "STATE_IDLE";
            }
            case 1: {
                return "STATE_SHOW_REQUESTED";
            }
            case 2: {
                return "STATE_VISIBLE";
            }
            case 3: {
                return "STATE_HIDDEN";
            }
            case 4: {
                return "STATE_REMOVE_REQUESTED";
            }
        }
        return "UNKNOWN_STATE: " + n;
    }

    public AbstractTelPopupHandler(ITelApplication iTelApplication, int n) {
        super(iTelApplication, "App.Phone.Main");
        this.popupID = n;
    }

    public AbstractTelPopupHandler(ITelApplication iTelApplication, String string, int n) {
        super(iTelApplication, string);
        this.popupID = n;
    }

    public void init() {
        super.init();
        this.getApplication().getPopupScreenStateDispatcher().addPopupStateListener(this.popupID, this);
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getPopupScreenStateDispatcher().removePopupStateListener(this.popupID, this);
    }

    protected abstract String getPopupName(int var1);

    private String getPopupNameWithID(int n) {
        return this.getPopupName(n) + "(" + n + ")";
    }

    public int getPopupState() {
        return this.state;
    }

    public void requestShowPopup() {
        this.requestShowPopup(0);
    }

    public void requestRemovePopup() {
        this.requestRemovePopup(0);
    }

    public void requestShowPopup(int n) {
        int n2 = this.state;
        if (n2 == 0 || n2 == 4 || n2 == 1) {
            this.log.log(1000000, "[AbstractTelPopupHandler#requestShowPopup] %1, terminalID=%2", (Object)this.getPopupNameWithID(this.popupID), (long)n);
            this.state = 1;
            this.getApplication().getFrameworkAccess().getHMIService().showPopup(this.popupID, n);
        } else {
            this.log.log(1000000, "[AbstractTelPopupHandler#requestShowPopup] state is %1 --> NOP!", (Object)AbstractTelPopupHandler.getStateName(n2));
        }
    }

    public void requestRemovePopup(int n) {
        int n2 = this.state;
        if (n2 == 3 || n2 == 1 || n2 == 2 || n2 == 4) {
            this.log.log(1000000, "[AbstractTelPopupHandler#requestRemovePopup] %1, terminalID=%2", (Object)this.getPopupNameWithID(this.popupID), (long)n);
            this.state = 4;
            this.getApplication().getFrameworkAccess().getHMIService().removePopup(this.popupID, n);
        } else {
            this.log.log(1000000, "[AbstractTelPopupHandler#requestRemovePopup] state is %1 --> NOP!", (Object)AbstractTelPopupHandler.getStateName(n2));
        }
    }

    public void notifyPopupVisible(int n) {
        this.log.log(1000000, "[AbstractTelPopupHandler#notifyPopupVisible] %1", (Object)this.getPopupNameWithID(this.popupID));
        this.state = 2;
    }

    public void notifyPopupHidden(int n) {
        this.log.log(1000000, "[AbstractTelPopupHandler#notifyPopupHidden] %1", (Object)this.getPopupNameWithID(this.popupID));
        this.state = 3;
    }

    public void notifyPopupRemoved(int n) {
        this.log.log(1000000, "[AbstractTelPopupHandler#notifyPopupRemoved] %1", (Object)this.getPopupNameWithID(this.popupID));
        this.state = 0;
    }
}

