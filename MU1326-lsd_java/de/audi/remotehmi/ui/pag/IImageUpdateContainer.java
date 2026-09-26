/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.pag;

public interface IImageUpdateContainer {
    public static final int ID_TITLEIMAGE;
    public static final int ID_LISTIMAGE;
    public static final int ID_BUTTONIMAGE;
    public static final int ID_COMMENT_IMAGE;

    default public String getPath() {
    }

    default public String getGridId() {
    }

    default public int getListIndex() {
    }

    default public int getRowIndex() {
    }

    default public int getColumnLocation() {
    }

    default public void setPath(String string) {
    }

    default public void setColumnLocation(int n) {
    }
}

