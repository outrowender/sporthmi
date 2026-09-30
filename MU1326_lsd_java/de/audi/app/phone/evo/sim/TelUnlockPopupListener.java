/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.sim;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.screen.IPopupStateListener;

public class TelUnlockPopupListener
extends AbstractPhoneComponent
implements IPopupStateListener {
    private static String getUnlockPopupName(int n) {
        switch (n) {
            case 300013: {
                return "POPUP_TEL_UNLOCK_ID";
            }
            case 300016: {
                return "POPUP_TEL_UNLOCK_ASSOCIATED_ID";
            }
        }
        return String.valueOf(n);
    }

    public TelUnlockPopupListener(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    public void init() {
        super.init();
        this.getApplication().getPopupScreenStateDispatcher().addPopupStateListener(300013, this);
        this.getApplication().getPopupScreenStateDispatcher().addPopupStateListener(300016, this);
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getPopupScreenStateDispatcher().removePopupStateListener(300013, this);
        this.getApplication().getPopupScreenStateDispatcher().removePopupStateListener(300016, this);
    }

    public void notifyPopupVisible(int n) {
        this.log.log(10000000, "[TelUnlockPopupListener#notifyPopupVisible] %1", (Object)TelUnlockPopupListener.getUnlockPopupName(n));
        this.getChoiceModel(4494).setValue(1);
    }

    public void notifyPopupHidden(int n) {
        this.log.log(10000000, "[TelUnlockPopupListener#notifyPopupHidden] %1", (Object)TelUnlockPopupListener.getUnlockPopupName(n));
        this.getChoiceModel(4494).setValue(0);
    }

    public void notifyPopupRemoved(int n) {
        this.log.log(10000000, "[TelUnlockPopupListener#notifyPopupRemoved] %1", (Object)TelUnlockPopupListener.getUnlockPopupName(n));
        this.getChoiceModel(4494).setValue(0);
    }
}

