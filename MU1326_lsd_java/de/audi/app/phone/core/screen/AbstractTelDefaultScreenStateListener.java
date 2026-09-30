/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.screen;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.screen.IScreenStateListener;

public class AbstractTelDefaultScreenStateListener
extends AbstractPhoneComponent
implements IScreenStateListener {
    private final int screenID;

    public AbstractTelDefaultScreenStateListener(ITelApplication iTelApplication, String string, int n) {
        super(iTelApplication, string);
        this.screenID = n;
    }

    public void init() {
        super.init();
        this.getApplication().getPopupScreenStateDispatcher().addScreenStateListener(this.screenID, this);
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getPopupScreenStateDispatcher().removeScreenStateListener(this.screenID, this);
    }

    public void screenVisible(int n) {
    }

    public void screenHidden(int n) {
    }

    public void notifyScreenConnected(int n) {
    }

    public void notifyScreenFadedOut(int n) {
    }
}

