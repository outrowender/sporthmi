/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer;

import de.audi.app.media.browser.IBrowseListContext;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.transfer.ITransferLockListener;
import org.dsi.ifc.media.ListEntry;

public interface ITransferListener
extends ITransferLockListener {
    public void readyForTransfer();

    public void activationSuccessful(ISourceSlot var1, IBrowseListContext var2);

    public void activationFailed(ISourceSlot var1);

    public void jukeboxSpaceChanged(long var1, long var3, long var5, long var7, long var9, long var11);

    public void importStarted();

    public void importAborted(long var1, long var3, long var5, boolean var7);

    public void importFinished(long var1, long var3, long var5, boolean var7);

    public void importWillBeResumed();

    public void importIsSuspended();

    public void deletionPostprocessing();

    public void deletionStarted();

    public void deletionFinished();

    public void deletionAborted();

    public void deletionProgressChanged(long var1);

    public void importProgressChanged(long var1, ListEntry var3);

    public void encodingQualityChanged(boolean var1, int var2);

    public void startFailed();

    public void sourceRemoved(ISourceSlot var1);

    public void unreadyToTransfer();
}

