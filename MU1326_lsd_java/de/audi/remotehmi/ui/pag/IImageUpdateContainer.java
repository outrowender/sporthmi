/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.pag;

public interface IImageUpdateContainer {
    public static final int ID_TITLEIMAGE = 1;
    public static final int ID_LISTIMAGE = 2;
    public static final int ID_BUTTONIMAGE = 3;
    public static final int ID_COMMENT_IMAGE = 4;

    public String getPath();

    public String getGridId();

    public int getListIndex();

    public int getRowIndex();

    public int getColumnLocation();

    public void setPath(String var1);

    public void setColumnLocation(int var1);
}

