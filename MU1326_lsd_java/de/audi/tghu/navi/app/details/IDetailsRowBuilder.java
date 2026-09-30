/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.details;

import de.audi.atip.hmi.model.list.EvoListRow;

public interface IDetailsRowBuilder {
    public static final int COLUMN_ICON = 0;
    public static final int COLUMN_TEXT = 1;
    public static final int COLUMN_LAYOUT = 2;
    public static final int COLUMN_COUNT = 3;
    public static final int LAYOUT_TEXT = 0;
    public static final int LAYOUT_ICON_TEXT = 1;

    public EvoListRow buildListRow(String var1, int var2);

    public EvoListRow buildListRowWithIcon(String var1, int var2, int var3);
}

