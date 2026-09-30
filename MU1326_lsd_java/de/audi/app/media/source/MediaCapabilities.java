/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import java.util.ArrayList;

public class MediaCapabilities {
    public static final MediaCapabilities EMPTY_CAPABILITIES = new MediaCapabilities();
    private final boolean playerCoverart;
    private final boolean browserCoverart;
    private final boolean video;
    private final boolean playmodes;
    private final boolean search;
    private final boolean contentBrowsing;
    private final boolean rawBrowsing;
    private final boolean importData;

    public MediaCapabilities(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        this.playerCoverart = bl;
        this.browserCoverart = bl2;
        this.video = bl3;
        this.playmodes = bl4;
        this.search = bl5;
        this.contentBrowsing = bl6;
        this.rawBrowsing = bl7;
        this.importData = bl8;
    }

    private MediaCapabilities() {
        this.playerCoverart = false;
        this.browserCoverart = false;
        this.video = false;
        this.playmodes = false;
        this.search = false;
        this.contentBrowsing = false;
        this.rawBrowsing = false;
        this.importData = false;
    }

    public boolean isPlayerCoverart() {
        return this.playerCoverart;
    }

    public boolean isBrowserCoverart() {
        return this.browserCoverart;
    }

    public boolean isVideo() {
        return this.video;
    }

    public boolean isPlaymodes() {
        return this.playmodes;
    }

    public boolean isSearch() {
        return this.search;
    }

    public boolean isContentBrowsing() {
        return this.contentBrowsing;
    }

    public boolean isRawBrowsing() {
        return this.rawBrowsing;
    }

    public boolean isImportData() {
        return this.importData;
    }

    public boolean isListHandling() {
        return this.isRawBrowsing() || this.isContentBrowsing();
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.contentBrowsing ? 1231 : 1237);
        n = 31 * n + (this.playerCoverart ? 1231 : 1237);
        n = 31 * n + (this.browserCoverart ? 1231 : 1237);
        n = 31 * n + (this.importData ? 1231 : 1237);
        n = 31 * n + (this.playmodes ? 1231 : 1237);
        n = 31 * n + (this.rawBrowsing ? 1231 : 1237);
        n = 31 * n + (this.search ? 1231 : 1237);
        n = 31 * n + (this.video ? 1231 : 1237);
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        MediaCapabilities mediaCapabilities = (MediaCapabilities)object;
        if (this.contentBrowsing != mediaCapabilities.contentBrowsing) {
            return false;
        }
        if (this.playerCoverart != mediaCapabilities.playerCoverart) {
            return false;
        }
        if (this.browserCoverart != mediaCapabilities.browserCoverart) {
            return false;
        }
        if (this.importData != mediaCapabilities.importData) {
            return false;
        }
        if (this.playmodes != mediaCapabilities.playmodes) {
            return false;
        }
        if (this.rawBrowsing != mediaCapabilities.rawBrowsing) {
            return false;
        }
        if (this.search != mediaCapabilities.search) {
            return false;
        }
        return this.video == mediaCapabilities.video;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.playerCoverart) {
            arrayList.add("PLAYER_COVERART");
        }
        if (this.browserCoverart) {
            arrayList.add("BROWSER_COVERART");
        }
        if (this.contentBrowsing) {
            arrayList.add("DB_BROWSER");
        }
        if (this.rawBrowsing) {
            arrayList.add("RAW_BROWSER");
        }
        if (this.playmodes) {
            arrayList.add("PLAYMODES");
        }
        if (this.search) {
            arrayList.add("SEARCH");
        }
        if (this.video) {
            arrayList.add("VIDEO");
        }
        if (this.importData) {
            arrayList.add("IMPORT");
        }
        return arrayList.toString();
    }
}

