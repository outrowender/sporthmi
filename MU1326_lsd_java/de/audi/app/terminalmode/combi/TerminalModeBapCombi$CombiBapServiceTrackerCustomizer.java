/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.combi;

import de.audi.app.terminalmode.combi.NullCombiBAPService;
import de.audi.app.terminalmode.combi.TerminalModeBapCombi;
import de.audi.app.terminalmode.combi.TerminalModeBapCombi$1;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTerminalMode;
import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import org.osgi.framework.ServiceReference;

final class TerminalModeBapCombi$CombiBapServiceTrackerCustomizer
extends DefaultServiceTrackerCustomizer {
    private final /* synthetic */ TerminalModeBapCombi this$0;

    private TerminalModeBapCombi$CombiBapServiceTrackerCustomizer(TerminalModeBapCombi terminalModeBapCombi) {
        this.this$0 = terminalModeBapCombi;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        CombiBAPServiceTerminalMode combiBAPServiceTerminalMode = (CombiBAPServiceTerminalMode)TerminalModeBapCombi.access$800(this.this$0).getServiceManager().getService(serviceReference);
        if (combiBAPServiceTerminalMode != null) {
            TerminalModeBapCombi.access$700(this.this$0).log(1078071040, "[TerminalModeCombi.addingService] %1", (Object)combiBAPServiceTerminalMode);
            TerminalModeBapCombi.access$502(this.this$0, combiBAPServiceTerminalMode);
        }
        return combiBAPServiceTerminalMode;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        TerminalModeBapCombi.access$700(this.this$0).log(1078071040, "[TerminalModeCombi.removedService] %1", object);
        TerminalModeBapCombi.access$502(this.this$0, new NullCombiBAPService(TerminalModeBapCombi.access$700(this.this$0)));
        TerminalModeBapCombi.access$900(this.this$0).ungetService(serviceReference);
    }

    /* synthetic */ TerminalModeBapCombi$CombiBapServiceTrackerCustomizer(TerminalModeBapCombi terminalModeBapCombi, TerminalModeBapCombi$1 terminalModeBapCombi$1) {
        this(terminalModeBapCombi);
    }
}

