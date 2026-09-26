/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.dab.DABDSIUpManager;
import de.audi.tuner.app.gracenote.CoverArtHandler;
import org.dsi.ifc.global.ResourceLocator;

class DABDSIUpManager$DabCoverArtHandler
extends CoverArtHandler {
    private final /* synthetic */ DABDSIUpManager this$0;

    public DABDSIUpManager$DabCoverArtHandler(DABDSIUpManager dABDSIUpManager, TunerBasics tunerBasics) {
        this.this$0 = dABDSIUpManager;
        super(tunerBasics);
    }

    @Override
    public boolean setCoverArt(int n, ResourceLocator resourceLocator) {
        if (super.setCoverArt(n, resourceLocator)) {
            DABDSIUpManager.access$900(this.this$0);
        }
        return false;
    }
}

