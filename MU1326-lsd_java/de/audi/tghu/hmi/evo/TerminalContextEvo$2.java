/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.view.IScreenChangeManager;
import de.audi.atip.mmicombi.IMMICombiPopupManager;
import de.audi.atip.mmicombi.IMMICombiScreenChangeManager;
import de.audi.tghu.hmi.PopupManager;
import de.audi.tghu.hmi.evo.TerminalContextEvo;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class TerminalContextEvo$2
implements ServiceTrackerCustomizer {
    private final /* synthetic */ TerminalContextEvo this$0;

    TerminalContextEvo$2(TerminalContextEvo terminalContextEvo) {
        this.this$0 = terminalContextEvo;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        IMMICombiScreenChangeManager iMMICombiScreenChangeManager = (IMMICombiScreenChangeManager)this.this$0.getFramework().getBundleCxt().getService(serviceReference);
        iMMICombiScreenChangeManager.setScreenChangeManager(TerminalContextEvo.access$200(this.this$0).getScreenChangeUnit());
        TerminalContextEvo.access$300(this.this$0).setScreenChangeUnit((IScreenChangeManager)((Object)iMMICombiScreenChangeManager));
        PopupManager popupManager = null;
        if (TerminalContextEvo.access$400(this.this$0) instanceof PopupManager) {
            popupManager = (PopupManager)TerminalContextEvo.access$500(this.this$0);
        } else if (TerminalContextEvo.access$600(this.this$0) instanceof IMMICombiPopupManager) {
            popupManager = (PopupManager)((IMMICombiPopupManager)TerminalContextEvo.access$700(this.this$0)).getMainUnitPopupManager();
        }
        popupManager.setScreenChangeUnit((IScreenChangeManager)((Object)iMMICombiScreenChangeManager));
        return iMMICombiScreenChangeManager;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }
}

