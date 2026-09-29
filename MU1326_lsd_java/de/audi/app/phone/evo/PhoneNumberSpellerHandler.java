/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo;

import de.audi.app.phone.core.NumberSpellerHandlerBase;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.app.phone.evo.PhoneNumberSpellerHandler$ClearNumberSpellerListener;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;

public class PhoneNumberSpellerHandler
extends NumberSpellerHandlerBase
implements ButtonListener {
    public PhoneNumberSpellerHandler(ITelEvoApplication iTelEvoApplication) {
        super(iTelEvoApplication);
        this.addSubPhoneComponent(new PhoneNumberSpellerHandler$ClearNumberSpellerListener(this, iTelEvoApplication));
    }

    @Override
    public void init() {
        super.init();
        this.getButtonModel(1922368512).setButtonListener(this);
        this.getButtonModel(1922368512).setStatus(0);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getButtonModel(1922368512).resetListener();
    }

    @Override
    protected SpellerModelApp getSpellerModel() {
        return this.getSpellerModel(-2003434496);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        super.keyTyped(n, n2, n3);
        if (n == 1922368512) {
            this.dialNumberInSpeller(n3);
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        super.textChanged(n, string, c2, n2);
        this.getButtonModel(1922368512).setStatus(string != null && string.length() > 0 && string.length() <= 40 ? 1 : 0);
    }

    @Override
    protected void clearSpellerContent() {
        super.clearSpellerContent();
        this.getButtonModel(1922368512).setStatus(0);
    }
}

