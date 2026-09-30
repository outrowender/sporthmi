/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.coverflow;

import de.audi.app.media.dsi.IDSIController;
import de.audi.app.media.dsi.coverflow.ICoverflowListener;
import de.audi.app.media.source.ISourceSlot;

public interface ICoverflowDSIController
extends IDSIController {
    public static final long FIRST_ALBUM_ID = -1L;

    public void setCoverflowListener(ICoverflowListener var1);

    public void deinitialize();

    public void initialize(ISourceSlot var1);

    public void startActive();

    public void startSingle();

    public void startPreview();

    public void stop();

    public void moveFocus(long var1, boolean var3);

    public void scrollTicks(int var1);

    public void setScrollMode(int var1);

    public void selectAlbum(long var1);

    public void requestAlbumIdxForFID(long var1);
}

