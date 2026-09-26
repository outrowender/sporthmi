/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.dsi;

import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.amfm.dsi.AMFMDSIUpManager;
import de.audi.tuner.app.gracenote.CoverArtHandler;
import org.dsi.ifc.global.ResourceLocator;

class AMFMDSIUpManager$FmCoverArtHandler
extends CoverArtHandler {
    private final TunerModels models;
    private final /* synthetic */ AMFMDSIUpManager this$0;

    public AMFMDSIUpManager$FmCoverArtHandler(AMFMDSIUpManager aMFMDSIUpManager, TunerBasics tunerBasics) {
        this.this$0 = aMFMDSIUpManager;
        super(tunerBasics);
        this.models = tunerBasics.getModels();
    }

    @Override
    public void requestCoverArt(String string, String string2, String string3) {
        int n = this.models.getActiveTuner();
        if (n == 1 || n == 4) {
            super.requestCoverArt(string, string2, string3);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean setCoverArt(int n, ResourceLocator resourceLocator) {
        Object object = AMFMDSIUpManager.access$200(this.this$0);
        synchronized (object) {
            if (super.setCoverArt(n, resourceLocator)) {
                AMFMDSIUpManager.access$1602(this.this$0, true);
                AMFMDSIUpManager.access$1200(this.this$0);
            }
            return false;
        }
    }
}

