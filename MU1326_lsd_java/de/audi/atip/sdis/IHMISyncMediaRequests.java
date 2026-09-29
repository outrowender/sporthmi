/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sdis;

import de.audi.atip.sdis.IHMISyncMediaRequests$Source;
import de.audi.atip.sdis.IHMISyncRequests;

public interface IHMISyncMediaRequests
extends IHMISyncRequests {
    public static final int MEDIA_SOURCE_STATE_EMPTY;
    public static final int MEDIA_SOURCE_STATE_LOADING;
    public static final int MEDIA_SOURCE_STATE_READY;

    default public void playEntry(long l) {
    }

    default public void resume() {
    }

    default public void pause() {
    }

    default public void skip(int n) {
    }

    default public void setActiveSource(IHMISyncMediaRequests$Source iHMISyncMediaRequests$Source) {
    }
}

