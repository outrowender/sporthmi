/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.coverflow;

import de.audi.app.media.dsi.IDSIController;
import de.audi.app.media.dsi.coverflow.ICoverflowListener;
import de.audi.app.media.source.ISourceSlot;

public interface ICoverflowDSIController
extends IDSIController {
    public static final long FIRST_ALBUM_ID;

    default public void setCoverflowListener(ICoverflowListener iCoverflowListener) {
    }

    default public void deinitialize() {
    }

    default public void initialize(ISourceSlot iSourceSlot) {
    }

    default public void startActive() {
    }

    default public void startSingle() {
    }

    default public void startPreview() {
    }

    default public void stop() {
    }

    default public void moveFocus(long l, boolean bl) {
    }

    default public void scrollTicks(int n) {
    }

    default public void setScrollMode(int n) {
    }

    default public void selectAlbum(long l) {
    }

    default public void requestAlbumIdxForFID(long l) {
    }
}

