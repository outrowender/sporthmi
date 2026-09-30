/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.startup;

public interface DisclaimerHandler {
    public static final DisclaimerHandler NULL_DISCLAIMER_HANDLER = new DisclaimerHandler(){

        public boolean isNaviDisclaimerAcceptedorHidden() {
            return true;
        }

        public void acceptDisclaimer() {
        }
    };

    public void acceptDisclaimer();

    public boolean isNaviDisclaimerAcceptedorHidden();
}

