/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer.dsi;

import de.audi.app.media.dsi.IDSIController;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.app.media.transfer.dsi.IMediaRecorderListener;

public interface IMediaDSIRecorderController
extends IDSIController {
    default public void setRecorderListener(IMediaRecorderListener iMediaRecorderListener) {
    }

    default public IMediaRecorderListener getRecorderListener() {
    }

    default public void setActiveMedia(MediaSourceSlot mediaSourceSlot) {
    }

    default public void setSelection(int n) {
    }

    default public void startImport(boolean bl) {
    }

    default public void abortImport() {
    }

    default public void startDelete() {
    }

    default public void abortDelete() {
    }

    default public void setEncodingQuality(int n) {
    }
}

