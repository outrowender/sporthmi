/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.favorites.persistent;

import de.esolutions.fw.util.commons.Buffer;
import java.io.Serializable;

public class FavoriteHeaderData
implements Serializable {
    private static final long serialVersionUID = 722811022815740669L;
    private final int sourceType;
    private final String mediaId;
    private final int persistentKey;
    private int lastUsed;

    public FavoriteHeaderData(int n, int n2, String string) {
        this(n, n2, string, 0);
    }

    protected FavoriteHeaderData(int n, int n2, String string, int n3) {
        this.sourceType = n2;
        this.mediaId = string;
        this.persistentKey = n;
        this.lastUsed = n3;
    }

    protected int getSourceType() {
        return this.sourceType;
    }

    protected String getMediaId() {
        return this.mediaId;
    }

    protected int getPersistentKey() {
        return this.persistentKey;
    }

    protected int getLastUsed() {
        return this.lastUsed;
    }

    protected void setLastUsed(int n) {
        this.lastUsed = n < 0 ? 0 : n;
    }

    public String toString() {
        Buffer buffer = new Buffer(40);
        buffer.append("key='");
        buffer.append(this.persistentKey);
        buffer.append("' src='");
        buffer.append(this.sourceType);
        buffer.append("' id='");
        buffer.append(this.mediaId);
        buffer.append("' lastuse='");
        buffer.append(this.lastUsed);
        buffer.append("'");
        return buffer.toString();
    }
}

