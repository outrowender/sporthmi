/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.core;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import java.util.List;

public interface ITerminalModeApplicationFactory {
    default public ITerminalModeComponent createHmiApplication(IContext iContext) {
    }

    default public ITerminalModeComponent createActionProxy(IContext iContext) {
    }

    default public List getVariantComponents(IContext iContext) {
    }
}

