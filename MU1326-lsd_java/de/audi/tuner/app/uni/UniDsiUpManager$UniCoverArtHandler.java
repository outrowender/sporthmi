/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.gracenote.CoverArtHandler;
import de.audi.tuner.app.uni.UniDsiUpManager;
import org.dsi.ifc.global.ResourceLocator;

class UniDsiUpManager$UniCoverArtHandler
extends CoverArtHandler {
    private final /* synthetic */ UniDsiUpManager this$0;

    public UniDsiUpManager$UniCoverArtHandler(UniDsiUpManager uniDsiUpManager, TunerBasics tunerBasics) {
        this.this$0 = uniDsiUpManager;
        super(tunerBasics);
    }

    @Override
    public boolean setCoverArt(int n, ResourceLocator resourceLocator) {
        if (super.setCoverArt(n, resourceLocator)) {
            UniDsiUpManager.access$400(this.this$0);
        }
        return false;
    }
}

