/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.core;

import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.app.terminalmode.core.TerminalModeApplication;
import de.audi.app.terminalmode.core.TerminalModeApplication$1;
import de.audi.atip.utils.injector.IInjector;
import de.audi.atip.utils.injector.Injector$IProvider;

class TerminalModeApplication$1$6
implements Injector$IProvider {
    private final /* synthetic */ TerminalModeApplication$1 this$1;

    TerminalModeApplication$1$6(TerminalModeApplication$1 terminalModeApplication$1) {
        this.this$1 = terminalModeApplication$1;
    }

    @Override
    public Object provide(IInjector iInjector, Object object) {
        return iInjector.getInstance(SmartphoneManager$SmartphoneType.ANDROIDAUTO2, TerminalModeApplication.class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2Subsystem == null ? (TerminalModeApplication.class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2Subsystem = TerminalModeApplication.class$("de.audi.app.terminalmode.smartphone.androidauto2.AndroidAuto2Subsystem")) : TerminalModeApplication.class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2Subsystem);
    }
}

