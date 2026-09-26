/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.esolutions.fw.util.commons.Buffer;

public class DataBrowserListSelectionData {
    private final int category;
    private final int path;
    private final int listType;

    public DataBrowserListSelectionData(int n, int n2, int n3) {
        this.category = n;
        this.path = n2;
        this.listType = n3;
    }

    public int getCategory() {
        return this.category;
    }

    public int getPath() {
        return this.path;
    }

    public int getListType() {
        return this.listType;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("'").append(this.getCategory()).append("','").append(this.getPath()).append("','").append(this.getListType()).append("'");
        return buffer.toString();
    }
}

