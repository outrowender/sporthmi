/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.content.media.AbstractPlayerSelectionRequest;
import de.audi.app.media.selection.IFavoritePlayerSelectionListener;

public class DataPlayerSelectionOnStartup
extends AbstractPlayerSelectionRequest {
    private final IFavoritePlayerSelectionListener selectionListener;

    public DataPlayerSelectionOnStartup(int n, long l, IFavoritePlayerSelectionListener iFavoritePlayerSelectionListener) {
        super(n, l, false, true);
        this.selectionListener = iFavoritePlayerSelectionListener;
    }

    public void responseSetSelection(boolean bl) {
        this.selectionListener.playFavoriteSelectionDone(bl);
    }
}

