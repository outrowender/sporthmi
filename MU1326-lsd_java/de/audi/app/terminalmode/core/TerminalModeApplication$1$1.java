/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.core;

import de.audi.app.terminalmode.ITerminalLogger;
import de.audi.app.terminalmode.core.TerminalModeApplication;
import de.audi.app.terminalmode.core.TerminalModeApplication$1;
import de.audi.app.terminalmode.util.StreamableStorageContainer;
import de.audi.atip.utils.injector.IInjector;
import de.audi.atip.utils.injector.Injector$IProvider;

class TerminalModeApplication$1$1
implements Injector$IProvider {
    private final /* synthetic */ TerminalModeApplication$1 this$1;

    TerminalModeApplication$1$1(TerminalModeApplication$1 terminalModeApplication$1) {
        this.this$1 = terminalModeApplication$1;
    }

    @Override
    public Object provide(IInjector iInjector, Object object) {
        return new StreamableStorageContainer(TerminalModeApplication$1.access$000(this.this$1).getStorageMgr(), ((ITerminalLogger)iInjector.getInstance(TerminalModeApplication.class$de$audi$app$terminalmode$ITerminalLogger == null ? (TerminalModeApplication.class$de$audi$app$terminalmode$ITerminalLogger = TerminalModeApplication.class$("de.audi.app.terminalmode.ITerminalLogger")) : TerminalModeApplication.class$de$audi$app$terminalmode$ITerminalLogger)).main(), 1008, 1);
    }
}

