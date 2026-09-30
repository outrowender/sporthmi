/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.esolutions.fw.util.commons.Buffer;

public final class DataBrowserListElement {
    public static final int TYPE_DIRECTORY = 1;
    public static final int TYPE_FOCUS_LIST_ELEMENT = 2;
    public static final int INVALID_ENTRYID = -1;
    public static final int INVALID_CONTENTYPE = -1;
    private final int type;
    private final long entryID;
    private final String filename;
    private final int contentType;

    public static DataBrowserListElement createDirectoryElement(long l, int n) {
        return new DataBrowserListElement(1, l, n);
    }

    public static DataBrowserListElement createDirectoryElement(long l, int n, String string) {
        return new DataBrowserListElement(1, l, n, string);
    }

    public static DataBrowserListElement createFocusListElement(long l, int n) {
        return new DataBrowserListElement(2, l, n);
    }

    public static DataBrowserListElement createDirectoryElement(String string, int n) {
        return new DataBrowserListElement(1, string, n);
    }

    private DataBrowserListElement(int n, long l, int n2) {
        this.type = n;
        this.entryID = l;
        this.contentType = n2;
        this.filename = "";
    }

    private DataBrowserListElement(int n, long l, int n2, String string) {
        this.type = n;
        this.entryID = l;
        this.contentType = n2;
        this.filename = string;
    }

    private DataBrowserListElement(int n, String string, int n2) {
        this.type = n;
        this.entryID = -1L;
        this.contentType = n2;
        this.filename = string;
    }

    public int getType() {
        return this.type;
    }

    public long getEntryID() {
        return this.entryID;
    }

    public int getContentType() {
        return this.contentType;
    }

    public String getFilename() {
        return this.filename;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        switch (this.type) {
            case 1: {
                buffer.append("DIR[").append(this.entryID).append(",").append(this.contentType).append(",").append(this.filename);
                break;
            }
            case 2: {
                buffer.append("FOCUS[").append(this.entryID).append(",").append(this.contentType);
                break;
            }
        }
        buffer.append("]");
        return buffer.toString();
    }
}

