/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.mmicombi.IMMICombiPopupManager;
import de.audi.tghu.hmi.evo.TerminalContextEvo;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class TerminalContextEvo$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ TerminalContextEvo this$0;

    TerminalContextEvo$1(TerminalContextEvo terminalContextEvo) {
        this.this$0 = terminalContextEvo;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        IMMICombiPopupManager iMMICombiPopupManager = (IMMICombiPopupManager)this.this$0.getFramework().getBundleCxt().getService(serviceReference);
        iMMICombiPopupManager.setMainUnitPopupManager(TerminalContextEvo.access$000(this.this$0));
        TerminalContextEvo.access$102(this.this$0, iMMICombiPopupManager);
        return iMMICombiPopupManager;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }
}

