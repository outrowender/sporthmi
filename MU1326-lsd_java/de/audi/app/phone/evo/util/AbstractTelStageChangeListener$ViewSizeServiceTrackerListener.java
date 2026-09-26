/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.util;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.util.AbstractTelServiceTracker;
import de.audi.app.phone.evo.util.AbstractTelStageChangeListener;
import de.audi.atip.mmicombi.IViewSizeListener;
import de.audi.atip.mmicombi.IViewSizeManager;

class AbstractTelStageChangeListener$ViewSizeServiceTrackerListener
extends AbstractTelServiceTracker
implements IViewSizeListener {
    private final /* synthetic */ AbstractTelStageChangeListener this$0;

    public AbstractTelStageChangeListener$ViewSizeServiceTrackerListener(AbstractTelStageChangeListener abstractTelStageChangeListener, ITelApplication iTelApplication, String string) {
        this.this$0 = abstractTelStageChangeListener;
        super(iTelApplication, string, AbstractTelStageChangeListener.class$de$audi$atip$mmicombi$IViewSizeManager == null ? (AbstractTelStageChangeListener.class$de$audi$atip$mmicombi$IViewSizeManager = AbstractTelStageChangeListener.class$("de.audi.atip.mmicombi.IViewSizeManager")) : AbstractTelStageChangeListener.class$de$audi$atip$mmicombi$IViewSizeManager);
    }

    @Override
    protected void serviceAvailable(Object object) {
        ((IViewSizeManager)object).addViewSizeListener(this);
    }

    @Override
    protected void serviceRemoved(Object object) {
    }

    @Override
    public void viewSizeChanged(int n) {
        switch (n) {
            case 2: {
                this.this$0.largeStateShown();
                break;
            }
            case 3: {
                this.log.log(-2137614336, "[AbstractTelStageChangeListener.ViewSizeServiceTrackerListener#viewSizeChanged] VIEW_SIZE_LOGICAL_POPUP --> NOP!");
                break;
            }
            case 0: {
                this.log.log(-2137614336, "[AbstractTelStageChangeListener.ViewSizeServiceTrackerListener#viewSizeChanged] VIEW_SIZE_NO_CHANGE --> NOP!");
                break;
            }
            case 1: {
                this.this$0.smallStageShown();
                break;
            }
            default: {
                this.log.log(-1601830656, "[AbstractTelStageChangeListener.ViewSizeServiceTrackerListener#viewSizeChanged] unknown view size %1", (long)n);
            }
        }
    }
}

