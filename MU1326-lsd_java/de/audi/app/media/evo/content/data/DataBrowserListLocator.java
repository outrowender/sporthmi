/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.evo.content.data.DataBrowserListElement;
import de.esolutions.fw.util.commons.Buffer;

public class DataBrowserListLocator {
    private final int category;
    private final int pathType;
    private final DataBrowserListElement[] path;

    public DataBrowserListLocator(int n, int n2) {
        this.category = n;
        this.pathType = n2;
        this.path = new DataBrowserListElement[0];
    }

    private DataBrowserListLocator(int n, int n2, DataBrowserListElement[] dataBrowserListElementArray, DataBrowserListElement dataBrowserListElement) {
        this.category = n;
        this.pathType = n2;
        this.path = new DataBrowserListElement[dataBrowserListElementArray.length + 1];
        System.arraycopy((Object)dataBrowserListElementArray, 0, (Object)this.path, 0, dataBrowserListElementArray.length);
        this.path[dataBrowserListElementArray.length] = dataBrowserListElement;
    }

    public DataBrowserListLocator add(DataBrowserListElement dataBrowserListElement) {
        return new DataBrowserListLocator(this.category, this.pathType, this.path, dataBrowserListElement);
    }

    public int getSize() {
        return this.path.length;
    }

    public int getCategory() {
        return this.category;
    }

    public int getPathType() {
        return this.pathType;
    }

    public DataBrowserListElement[] getPath() {
        return this.path;
    }

    public DataBrowserListElement getFocusElement() {
        if (this.path.length > 0 && this.path[this.path.length - 1].getType() == 2) {
            return this.path[this.path.length - 1];
        }
        return null;
    }

    protected static String categoryID2Str(int n) {
        switch (n) {
            case 0: {
                return "CATEGORY_UNDEFINED";
            }
            case 1: {
                return "CATEGORY_PHYSICAL";
            }
            case 2: {
                return "CATEGORY_TITLES";
            }
            case 3: {
                return "CATEGORY_ALBUMS";
            }
            case 4: {
                return "CATEGORY_ARTISTS";
            }
            case 5: {
                return "CATEGORY_GENRES";
            }
            case 6: {
                return "CATEGORY_PLAYLISTS";
            }
            case 7: {
                return "CATEGORY_VIDEOS";
            }
            case 8: {
                return "CATEGORY_PODCASTS";
            }
            case 9: {
                return "CATEGORY_AUDIOBOOKS";
            }
            case 10: {
                return "CATEGORY_COMPOSERS";
            }
            case 11: {
                return "CATEGORY_FAVORITES";
            }
            case 12: {
                return "CATEGORY_RADIO";
            }
        }
        return new StringBuffer().append("UNKNOWN (").append(n).append(")").toString();
    }

    protected static String pathType2Str(int n) {
        switch (n) {
            case 0: {
                return "PATHTYPE_LIST";
            }
            case 1: {
                return "PATHTYPE_SEARCH";
            }
            case 2: {
                return "PATHTYPE_BROWSER_SEARCH";
            }
        }
        return new StringBuffer().append("UNKNOWN(").append(n).append(")").toString();
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("[");
        buffer.append(DataBrowserListLocator.categoryID2Str(this.category)).append(",");
        buffer.append(DataBrowserListLocator.pathType2Str(this.pathType)).append("]");
        for (int i2 = 0; i2 < this.path.length; ++i2) {
            buffer.append(this.path[i2]);
        }
        return buffer.toString();
    }
}

