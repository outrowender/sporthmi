/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.core.ITerminalModeApplicationFactory;
import de.audi.app.terminalmode.core.TerminalModeApplication;
import de.audi.app.terminalmode.evo.BTPopupHandler;
import de.audi.app.terminalmode.evo.EvoTMConfiguration;
import de.audi.app.terminalmode.evo.MMICombiStageListener;
import de.audi.app.terminalmode.evo.TerminalModeActionProxyImpl;
import de.audi.app.terminalmode.evo.TerminalModeHMIApplication;
import de.audi.app.terminalmode.hmi.NewDeviceHMIHandler;
import de.audi.atip.activator.AbstractActivator;
import java.util.ArrayList;
import java.util.List;
import org.osgi.framework.BundleContext;

public class TerminalModeActivator
extends AbstractActivator {
    private volatile TerminalModeApplication terminalModeManager;

    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.terminalModeManager = new TerminalModeApplication(bundleContext, this.framework, new EvoTMConfiguration(this.framework), new ITerminalModeApplicationFactory(){

            public ITerminalModeComponent createHmiApplication(IContext iContext) {
                return new TerminalModeHMIApplication(iContext);
            }

            public ITerminalModeComponent createActionProxy(IContext iContext) {
                return new TerminalModeActionProxyImpl(iContext);
            }

            public List getVariantComponents(IContext iContext) {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(new BTPopupHandler(iContext));
                arrayList.add(new NewDeviceHMIHandler(iContext));
                if (iContext.getFramework().getScreenRes() == 4) {
                    arrayList.add(new MMICombiStageListener(iContext.getLogger(), iContext.getServiceManager(), iContext.getActionProxyDispatcher(), TerminalModeActivator.this.framework, iContext.getEventBus()));
                }
                return arrayList;
            }
        });
        this.terminalModeManager.init();
    }

    public void stop(BundleContext bundleContext) {
        if (null != this.terminalModeManager) {
            this.terminalModeManager.deinit();
        }
        super.stop(bundleContext);
    }
}

