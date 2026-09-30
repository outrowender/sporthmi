/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.core;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import java.util.List;

public interface ITerminalModeApplicationFactory {
    public ITerminalModeComponent createHmiApplication(IContext var1);

    public ITerminalModeComponent createActionProxy(IContext var1);

    public List getVariantComponents(IContext var1);
}

