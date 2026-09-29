/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.details;

import de.audi.atip.hmi.model.list.EvoListRow;

public interface IDetailsRowBuilder {
    public static final int COLUMN_ICON;
    public static final int COLUMN_TEXT;
    public static final int COLUMN_LAYOUT;
    public static final int COLUMN_COUNT;
    public static final int LAYOUT_TEXT;
    public static final int LAYOUT_ICON_TEXT;

    default public EvoListRow buildListRow(String string, int n) {
    }

    default public EvoListRow buildListRowWithIcon(String string, int n, int n2) {
    }
}

