/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.interapp;

import de.audi.app.media.source.ISourceSlot;

public interface ITransferStateListener {
    default public void importStarted(ISourceSlot iSourceSlot) {
    }

    default public void importProgressChanged(int n) {
    }

    default public void importStopped() {
    }
}

