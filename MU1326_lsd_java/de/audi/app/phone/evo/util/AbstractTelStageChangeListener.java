/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.util;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.util.AbstractTelServiceTracker;
import de.audi.atip.mmicombi.IViewSizeListener;
import de.audi.atip.mmicombi.IViewSizeManager;

public abstract class AbstractTelStageChangeListener
extends AbstractPhoneComponent {
    static /* synthetic */ Class class$de$audi$atip$mmicombi$IViewSizeManager;

    public AbstractTelStageChangeListener(ITelApplication iTelApplication, String string) {
        super(iTelApplication, string);
        this.addSubPhoneComponent(new ViewSizeServiceTrackerListener(iTelApplication, string));
    }

    protected abstract void smallStageShown();

    protected abstract void largeStateShown();

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class ViewSizeServiceTrackerListener
    extends AbstractTelServiceTracker
    implements IViewSizeListener {
        public ViewSizeServiceTrackerListener(ITelApplication iTelApplication, String string) {
            super(iTelApplication, string, class$de$audi$atip$mmicombi$IViewSizeManager == null ? (class$de$audi$atip$mmicombi$IViewSizeManager = AbstractTelStageChangeListener.class$("de.audi.atip.mmicombi.IViewSizeManager")) : class$de$audi$atip$mmicombi$IViewSizeManager);
        }

        protected void serviceAvailable(Object object) {
            ((IViewSizeManager)object).addViewSizeListener(this);
        }

        protected void serviceRemoved(Object object) {
        }

        public void viewSizeChanged(int n) {
            switch (n) {
                case 2: {
                    AbstractTelStageChangeListener.this.largeStateShown();
                    break;
                }
                case 3: {
                    this.log.log(10000000, "[AbstractTelStageChangeListener.ViewSizeServiceTrackerListener#viewSizeChanged] VIEW_SIZE_LOGICAL_POPUP --> NOP!");
                    break;
                }
                case 0: {
                    this.log.log(10000000, "[AbstractTelStageChangeListener.ViewSizeServiceTrackerListener#viewSizeChanged] VIEW_SIZE_NO_CHANGE --> NOP!");
                    break;
                }
                case 1: {
                    AbstractTelStageChangeListener.this.smallStageShown();
                    break;
                }
                default: {
                    this.log.log(100000, "[AbstractTelStageChangeListener.ViewSizeServiceTrackerListener#viewSizeChanged] unknown view size %1", (long)n);
                }
            }
        }
    }
}

