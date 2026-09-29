/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.core;

import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.app.terminalmode.core.TerminalModeApplication;
import de.audi.app.terminalmode.core.TerminalModeApplication$1;
import de.audi.atip.utils.injector.IInjector;
import de.audi.atip.utils.injector.Injector$IProvider;

class TerminalModeApplication$1$9
implements Injector$IProvider {
    private final /* synthetic */ TerminalModeApplication$1 this$1;

    TerminalModeApplication$1$9(TerminalModeApplication$1 terminalModeApplication$1) {
        this.this$1 = terminalModeApplication$1;
    }

    @Override
    public Object provide(IInjector iInjector, Object object) {
        return iInjector.getInstance(SmartphoneManager$SmartphoneType.CARLIFE, TerminalModeApplication.class$de$audi$app$terminalmode$smartphone$carlife$CarlifeSubsystem == null ? (TerminalModeApplication.class$de$audi$app$terminalmode$smartphone$carlife$CarlifeSubsystem = TerminalModeApplication.class$("de.audi.app.terminalmode.smartphone.carlife.CarlifeSubsystem")) : TerminalModeApplication.class$de$audi$app$terminalmode$smartphone$carlife$CarlifeSubsystem);
    }
}

