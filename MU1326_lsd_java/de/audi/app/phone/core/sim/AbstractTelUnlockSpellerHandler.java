/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.sim.AbstractTelUnlockSpellerHandler$TelUnlockOkButtonListener;
import de.audi.app.phone.core.sim.AbstractTelUnlockSpellerHandler$TelUnlockSpellerHandler;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;

abstract class AbstractTelUnlockSpellerHandler
extends AbstractPhoneComponent {
    private final String name;
    private final SpellerModelApp spellerModel;
    private final ButtonModelApp okButton;

    AbstractTelUnlockSpellerHandler(ITelApplication iTelApplication, String string, int n, int n2, int n3, int n4) {
        super(iTelApplication, "App.Phone.LockState");
        this.name = string;
        this.spellerModel = this.getSpellerModel(n);
        this.okButton = this.getButtonModel(n2);
        this.addSubPhoneComponent(new AbstractTelUnlockSpellerHandler$TelUnlockSpellerHandler(this, iTelApplication, "App.Phone.LockState", n, n3, n4));
        this.addSubPhoneComponent(new AbstractTelUnlockSpellerHandler$TelUnlockOkButtonListener(this, iTelApplication, "App.Phone.LockState", n2));
    }

    protected abstract void codeEntered(String string, int n) {
    }

    protected void fireEvent(int n) {
        this.spellerModel.fireEvent(n);
    }

    void clearSpeller() {
        this.spellerModel.clear();
        this.okButton.setStatus(0);
    }

    static /* synthetic */ String access$000(AbstractTelUnlockSpellerHandler abstractTelUnlockSpellerHandler) {
        return abstractTelUnlockSpellerHandler.name;
    }

    static /* synthetic */ ButtonModelApp access$100(AbstractTelUnlockSpellerHandler abstractTelUnlockSpellerHandler) {
        return abstractTelUnlockSpellerHandler.okButton;
    }

    static /* synthetic */ SpellerModelApp access$200(AbstractTelUnlockSpellerHandler abstractTelUnlockSpellerHandler) {
        return abstractTelUnlockSpellerHandler.spellerModel;
    }
}

