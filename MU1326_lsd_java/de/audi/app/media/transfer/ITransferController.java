/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer;

import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.transfer.ITransferListener;

public interface ITransferController {
    public static final int TRANSFER_ENCODINGQUALITY_MAX = 0;
    public static final int TRANSFER_ENCODINGQUALITY_HIGH = 1;

    public void start();

    public void abort();

    public void setEncodingQuality(int var1);

    public void activate(ISourceSlot var1);

    public void setTransferListener(ITransferListener var1);
}

