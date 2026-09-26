/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.startup;

import de.audi.tghu.navi.startup.DisclaimerHandler$1;

public interface DisclaimerHandler {
    public static final DisclaimerHandler NULL_DISCLAIMER_HANDLER = new DisclaimerHandler$1();

    default public void acceptDisclaimer() {
    }

    default public boolean isNaviDisclaimerAcceptedorHidden() {
    }
}

