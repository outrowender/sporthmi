/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer;

import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.transfer.ITransferListener;

public interface ITransferController {
    public static final int TRANSFER_ENCODINGQUALITY_MAX;
    public static final int TRANSFER_ENCODINGQUALITY_HIGH;

    default public void start() {
    }

    default public void abort() {
    }

    default public void setEncodingQuality(int n) {
    }

    default public void activate(ISourceSlot iSourceSlot) {
    }

    default public void setTransferListener(ITransferListener iTransferListener) {
    }
}

