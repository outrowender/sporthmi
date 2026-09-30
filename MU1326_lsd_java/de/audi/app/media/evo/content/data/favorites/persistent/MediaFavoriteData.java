/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.favorites.persistent;

import java.io.Serializable;

public class MediaFavoriteData
implements Serializable {
    private static final long serialVersionUID = -932483248742134853L;
    private final int broweMode;
    private final String path;
    private final String favorite;

    public MediaFavoriteData(int n, String string, String string2) {
        this.broweMode = n;
        this.path = string;
        this.favorite = string2;
    }

    public int getBroweMode() {
        return this.broweMode;
    }

    public String getPath() {
        return this.path;
    }

    public String getFavorite() {
        return this.favorite;
    }
}

