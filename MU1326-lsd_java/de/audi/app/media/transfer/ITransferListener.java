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
    default public void readyForTransfer() {
    }

    default public void activationSuccessful(ISourceSlot iSourceSlot, IBrowseListContext iBrowseListContext) {
    }

    default public void activationFailed(ISourceSlot iSourceSlot) {
    }

    default public void jukeboxSpaceChanged(long l, long l2, long l3, long l4, long l5, long l6) {
    }

    default public void importStarted() {
    }

    default public void importAborted(long l, long l2, long l3, boolean bl) {
    }

    default public void importFinished(long l, long l2, long l3, boolean bl) {
    }

    default public void importWillBeResumed() {
    }

    default public void importIsSuspended() {
    }

    default public void deletionPostprocessing() {
    }

    default public void deletionStarted() {
    }

    default public void deletionFinished() {
    }

    default public void deletionAborted() {
    }

    default public void deletionProgressChanged(long l) {
    }

    default public void importProgressChanged(long l, ListEntry listEntry) {
    }

    default public void encodingQualityChanged(boolean bl, int n) {
    }

    default public void startFailed() {
    }

    default public void sourceRemoved(ISourceSlot iSourceSlot) {
    }

    default public void unreadyToTransfer() {
    }
}

