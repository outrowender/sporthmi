/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.audio;

import de.audi.app.combi.bap.dsi.fastlist.IDSIFastListScrollingController;

public interface IDSIFastListAudio
extends IDSIFastListScrollingController {
    default public void pushFunctionAvailabilityAudio(int n) {
    }

    default public void responseNotifyCurrentListSizeAudio(boolean bl) {
    }
}

