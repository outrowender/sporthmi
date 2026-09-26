/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TerminalModeHandler$TVActionProxy;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeHandler$Properties;

public class TerminalModeHandler {
    final TerminalModeHandler$TVActionProxy actionProxy = new TerminalModeHandler$TVActionProxy(this, null);
    private final TerminalAndScreenModeHandler$Properties terminalModeProperties;

    TerminalModeHandler(TerminalAndScreenModeHandler$Properties terminalAndScreenModeHandler$Properties) {
        this.terminalModeProperties = terminalAndScreenModeHandler$Properties;
    }

    public TerminalModeHandler(TVEnv tVEnv) {
        this(tVEnv.properties.terminalMode);
    }

    static /* synthetic */ TerminalAndScreenModeHandler$Properties access$100(TerminalModeHandler terminalModeHandler) {
        return terminalModeHandler.terminalModeProperties;
    }
}

