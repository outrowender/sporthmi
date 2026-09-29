/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.gracenote.CoverArtHandler;
import de.audi.tuner.app.sdars.PdtInfoHandler;
import org.dsi.ifc.global.ResourceLocator;

class PdtInfoHandler$SDARSCoverArtHandler
extends CoverArtHandler {
    private final /* synthetic */ PdtInfoHandler this$0;

    public PdtInfoHandler$SDARSCoverArtHandler(PdtInfoHandler pdtInfoHandler, TunerBasics tunerBasics) {
        this.this$0 = pdtInfoHandler;
        super(tunerBasics);
    }

    @Override
    public boolean setCoverArt(int n, ResourceLocator resourceLocator) {
        boolean bl = super.setCoverArt(n, resourceLocator);
        if (bl) {
            PdtInfoHandler.access$700(this.this$0);
        }
        return bl;
    }
}

