/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer.dsi;

import de.audi.app.media.dsi.IDSIController;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.app.media.transfer.dsi.IMediaRecorderListener;

public interface IMediaDSIRecorderController
extends IDSIController {
    public void setRecorderListener(IMediaRecorderListener var1);

    public IMediaRecorderListener getRecorderListener();

    public void setActiveMedia(MediaSourceSlot var1);

    public void setSelection(int var1);

    public void startImport(boolean var1);

    public void abortImport();

    public void startDelete();

    public void abortDelete();

    public void setEncodingQuality(int var1);
}

