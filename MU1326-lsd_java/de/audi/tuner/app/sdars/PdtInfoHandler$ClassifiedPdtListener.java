/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.ifc.listener.IPdtListener;

class PdtInfoHandler$ClassifiedPdtListener {
    public final IPdtListener pdtListener;
    public boolean interestedInGracenoteCoverArt;

    public PdtInfoHandler$ClassifiedPdtListener(IPdtListener iPdtListener, boolean bl) {
        this.pdtListener = iPdtListener;
        this.interestedInGracenoteCoverArt = bl;
    }
}

