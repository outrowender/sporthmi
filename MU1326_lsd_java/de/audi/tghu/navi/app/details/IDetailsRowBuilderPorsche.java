/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.details;

import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.global.NavLocation;

public interface IDetailsRowBuilderPorsche {
    public static final int COLUMN_ICON = 0;
    public static final int COLUMN_TEXT = 1;
    public static final int COLUMN_LAYOUT = 2;
    public static final int COLUMN_COUNT = 3;
    public static final int LAYOUT_TEXT = 0;
    public static final int LAYOUT_ICON_TEXT = 1;

    public EvoListRow buildCityListRow(NavLocation var1, int var2);

    public EvoListRow buildAddressListRow(NavLocation var1, int var2);

    public EvoListRow buildTextListRow(String var1, int var2);
}

