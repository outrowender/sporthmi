/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.hmi.NewDeviceHMIHandler
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.TerminalModeActivator;
import de.audi.app.terminalmode.core.ITerminalModeApplicationFactory;
import de.audi.app.terminalmode.evo.BTPopupHandler;
import de.audi.app.terminalmode.evo.MMICombiStageListener;
import de.audi.app.terminalmode.evo.TerminalModeActionProxyImpl;
import de.audi.app.terminalmode.evo.TerminalModeHMIApplication;
import de.audi.app.terminalmode.hmi.NewDeviceHMIHandler;
import java.util.ArrayList;
import java.util.List;

class TerminalModeActivator$1
implements ITerminalModeApplicationFactory {
    private final /* synthetic */ TerminalModeActivator this$0;

    TerminalModeActivator$1(TerminalModeActivator terminalModeActivator) {
        this.this$0 = terminalModeActivator;
    }

    @Override
    public ITerminalModeComponent createHmiApplication(IContext iContext) {
        return new TerminalModeHMIApplication(iContext);
    }

    @Override
    public ITerminalModeComponent createActionProxy(IContext iContext) {
        return new TerminalModeActionProxyImpl(iContext);
    }

    @Override
    public List getVariantComponents(IContext iContext) {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new BTPopupHandler(iContext));
        arrayList.add(new NewDeviceHMIHandler(iContext));
        if (iContext.getFramework().getScreenRes() == 4) {
            arrayList.add(new MMICombiStageListener(iContext.getLogger(), iContext.getServiceManager(), iContext.getActionProxyDispatcher(), TerminalModeActivator.access$000(this.this$0), iContext.getEventBus()));
        }
        return arrayList;
    }
}

