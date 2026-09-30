/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.NumberSpellerHandlerBase;
import de.audi.app.phone.core.ap.AbstractTelActionProxyListener;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import java.util.Map;

public class PhoneNumberSpellerHandler
extends NumberSpellerHandlerBase
implements ButtonListener {
    public PhoneNumberSpellerHandler(ITelEvoApplication iTelEvoApplication) {
        super(iTelEvoApplication);
        this.addSubPhoneComponent(new ClearNumberSpellerListener(iTelEvoApplication));
    }

    public void init() {
        super.init();
        this.getButtonModel(300402).setButtonListener(this);
        this.getButtonModel(300402).setStatus(0);
    }

    public void deinit() {
        super.deinit();
        this.getButtonModel(300402).resetListener();
    }

    protected SpellerModelApp getSpellerModel() {
        return this.getSpellerModel(300680);
    }

    public void keyTyped(int n, int n2, int n3) {
        super.keyTyped(n, n2, n3);
        if (n == 300402) {
            this.dialNumberInSpeller(n3);
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void textChanged(int n, String string, char c2, int n2) {
        super.textChanged(n, string, c2, n2);
        this.getButtonModel(300402).setStatus(string != null && string.length() > 0 && string.length() <= 40 ? 1 : 0);
    }

    protected void clearSpellerContent() {
        super.clearSpellerContent();
        this.getButtonModel(300402).setStatus(0);
    }

    private class ClearNumberSpellerListener
    extends AbstractTelActionProxyListener {
        public ClearNumberSpellerListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Main", 33);
        }

        protected void actionProxyCalled(Map map) {
            PhoneNumberSpellerHandler.this.clearSpellerContent();
        }
    }
}

