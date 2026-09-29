/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.core;

import de.audi.app.terminalmode.core.TerminalModeApplication;
import de.audi.app.terminalmode.core.TerminalModeApplication$1;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController;
import de.audi.atip.utils.injector.IInjector;
import de.audi.atip.utils.injector.Injector$IProvider;

class TerminalModeApplication$1$4
implements Injector$IProvider {
    private final /* synthetic */ TerminalModeApplication$1 this$1;

    TerminalModeApplication$1$4(TerminalModeApplication$1 terminalModeApplication$1) {
        this.this$1 = terminalModeApplication$1;
    }

    @Override
    public Object provide(IInjector iInjector, Object object) {
        return ((SmartphoneIntegrationDSILifecycleController)iInjector.getInstance(TerminalModeApplication.class$de$audi$app$terminalmode$dsi$smartphoneintegration$SmartphoneIntegrationDSILifecycleController == null ? (TerminalModeApplication.class$de$audi$app$terminalmode$dsi$smartphoneintegration$SmartphoneIntegrationDSILifecycleController = TerminalModeApplication.class$("de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController")) : TerminalModeApplication.class$de$audi$app$terminalmode$dsi$smartphoneintegration$SmartphoneIntegrationDSILifecycleController)).getSMIDSIController();
    }
}

