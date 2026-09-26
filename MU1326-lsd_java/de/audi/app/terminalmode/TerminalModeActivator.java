/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.TerminalModeActivator$1;
import de.audi.app.terminalmode.core.TerminalModeApplication;
import de.audi.app.terminalmode.evo.EvoTMConfiguration;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.base.IFrameworkAccess;
import org.osgi.framework.BundleContext;

public class TerminalModeActivator
extends AbstractActivator {
    private volatile TerminalModeApplication terminalModeManager;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.terminalModeManager = new TerminalModeApplication(bundleContext, this.framework, new EvoTMConfiguration(this.framework), new TerminalModeActivator$1(this));
        this.terminalModeManager.init();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (null != this.terminalModeManager) {
            this.terminalModeManager.deinit();
        }
        super.stop(bundleContext);
    }

    static /* synthetic */ IFrameworkAccess access$000(TerminalModeActivator terminalModeActivator) {
        return terminalModeActivator.framework;
    }
}

