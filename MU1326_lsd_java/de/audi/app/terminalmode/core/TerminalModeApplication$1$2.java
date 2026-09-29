/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.core;

import de.audi.app.terminalmode.ITerminalLogger;
import de.audi.app.terminalmode.core.TerminalModeApplication;
import de.audi.app.terminalmode.core.TerminalModeApplication$1;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.utils.injector.IInjector;
import de.audi.atip.utils.injector.Injector$IProvider;
import de.audi.tghu.command.CommandListManager;

class TerminalModeApplication$1$2
implements Injector$IProvider {
    private final /* synthetic */ TerminalModeApplication$1 this$1;

    TerminalModeApplication$1$2(TerminalModeApplication$1 terminalModeApplication$1) {
        this.this$1 = terminalModeApplication$1;
    }

    @Override
    public Object provide(IInjector iInjector, Object object) {
        return new CommandListManager("TerminalModeCLM", (IFrameworkAccess)iInjector.getInstance(TerminalModeApplication.class$de$audi$atip$base$IFrameworkAccess == null ? (TerminalModeApplication.class$de$audi$atip$base$IFrameworkAccess = TerminalModeApplication.class$("de.audi.atip.base.IFrameworkAccess")) : TerminalModeApplication.class$de$audi$atip$base$IFrameworkAccess), ((ITerminalLogger)iInjector.getInstance(TerminalModeApplication.class$de$audi$app$terminalmode$ITerminalLogger == null ? (TerminalModeApplication.class$de$audi$app$terminalmode$ITerminalLogger = TerminalModeApplication.class$("de.audi.app.terminalmode.ITerminalLogger")) : TerminalModeApplication.class$de$audi$app$terminalmode$ITerminalLogger)).commandList(), null, null);
    }
}

