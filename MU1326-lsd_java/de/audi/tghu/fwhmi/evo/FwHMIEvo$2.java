/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi.evo;

import de.audi.atip.hmi.IRootWindow;
import de.audi.atip.hmi.view.IVisualFeedback;
import de.audi.tghu.fwhmi.evo.FwHMIEvo;

class FwHMIEvo$2
implements Runnable {
    private final /* synthetic */ IVisualFeedback val$visualFeedback;
    private final /* synthetic */ IRootWindow val$rootWindow;
    private final /* synthetic */ FwHMIEvo this$0;

    FwHMIEvo$2(FwHMIEvo fwHMIEvo, IVisualFeedback iVisualFeedback, IRootWindow iRootWindow) {
        this.this$0 = fwHMIEvo;
        this.val$visualFeedback = iVisualFeedback;
        this.val$rootWindow = iRootWindow;
    }

    @Override
    public void run() {
        this.val$visualFeedback.hideFeedback();
        this.this$0.getLogRepaintCause().log(-2137614336, "FwHMIEvo#flashScreen: repaint to hide flash");
        this.val$rootWindow.repaint();
    }

    public String toString() {
        return "HideFullScreenFeedback";
    }
}

