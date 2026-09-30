/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.core.model.TelDefaultSpellerListener;
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
        this.addSubPhoneComponent(new TelUnlockSpellerHandler(iTelApplication, "App.Phone.LockState", n, n3, n4));
        this.addSubPhoneComponent(new TelUnlockOkButtonListener(iTelApplication, "App.Phone.LockState", n2));
    }

    protected abstract void codeEntered(String var1, int var2);

    protected void fireEvent(int n) {
        this.spellerModel.fireEvent(n);
    }

    void clearSpeller() {
        this.spellerModel.clear();
        this.okButton.setStatus(0);
    }

    private class TelUnlockSpellerHandler
    extends TelDefaultSpellerListener {
        private final int minSpellerLength;
        private final int maxSpellerLength;

        public TelUnlockSpellerHandler(ITelApplication iTelApplication, String string, int n, int n2, int n3) {
            super(iTelApplication, string, n);
            this.minSpellerLength = n2;
            this.maxSpellerLength = n3;
        }

        public void init() {
            super.init();
            this.setMinMaxLength(this.minSpellerLength, this.maxSpellerLength);
        }

        public void textChanged(int n, String string, char c2, int n2) {
            this.log.log(1000000, "[%1.UnlockSpellerHandler#textChanged] text=%1, latestChar=%2", (Object)AbstractTelUnlockSpellerHandler.this.name, (Object)string, (long)c2);
            this.setOKButtonEnabled(string);
        }

        private void setOKButtonEnabled(String string) {
            int n = this.getSpellerModel().getMinLength();
            int n2 = this.getSpellerModel().getMaxLength();
            if (string != null) {
                if (string.length() >= n && string.length() <= n2) {
                    AbstractTelUnlockSpellerHandler.this.okButton.setStatus(1);
                } else {
                    AbstractTelUnlockSpellerHandler.this.okButton.setStatus(0);
                }
            } else {
                AbstractTelUnlockSpellerHandler.this.okButton.setStatus(0);
            }
        }

        public void keyTyped(int n, int n2, int n3) {
            AbstractTelUnlockSpellerHandler.this.codeEntered(AbstractTelUnlockSpellerHandler.this.spellerModel.getText(), n3);
        }
    }

    private class TelUnlockOkButtonListener
    extends TelDefaultButtonListener {
        public TelUnlockOkButtonListener(ITelApplication iTelApplication, String string, int n) {
            super(iTelApplication, string, n);
        }

        public void init() {
            super.init();
            this.getButtonModel().setStatus(0);
        }

        public void keyTyped(int n, int n2, int n3) {
            AbstractTelUnlockSpellerHandler.this.codeEntered(AbstractTelUnlockSpellerHandler.this.spellerModel.getText(), n3);
        }
    }
}

