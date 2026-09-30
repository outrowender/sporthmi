/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.interapp;

import de.audi.app.media.source.ISourceSlot;

public interface ITransferStateListener {
    public void importStarted(ISourceSlot var1);

    public void importProgressChanged(int var1);

    public void importStopped();
}

