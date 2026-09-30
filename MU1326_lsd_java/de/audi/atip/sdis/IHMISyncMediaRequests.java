/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sdis;

import de.audi.atip.sdis.IHMISyncRequests;

public interface IHMISyncMediaRequests
extends IHMISyncRequests {
    public static final int MEDIA_SOURCE_STATE_EMPTY = 0;
    public static final int MEDIA_SOURCE_STATE_LOADING = 1;
    public static final int MEDIA_SOURCE_STATE_READY = 2;

    public void playEntry(long var1);

    public void resume();

    public void pause();

    public void skip(int var1);

    public void setActiveSource(Source var1);

    public static class Source {
        public String name;
        public int type;
        public int slotIdx;
        public int state;
    }

    public static class ListEntry {
        public long id;
        public String title;
        public String artist;
        public String album;
        public String coverUrl;
    }
}

