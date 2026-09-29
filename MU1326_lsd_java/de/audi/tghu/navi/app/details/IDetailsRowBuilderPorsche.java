/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.details;

import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.global.NavLocation;

public interface IDetailsRowBuilderPorsche {
    public static final int COLUMN_ICON;
    public static final int COLUMN_TEXT;
    public static final int COLUMN_LAYOUT;
    public static final int COLUMN_COUNT;
    public static final int LAYOUT_TEXT;
    public static final int LAYOUT_ICON_TEXT;

    default public EvoListRow buildCityListRow(NavLocation navLocation, int n) {
    }

    default public EvoListRow buildAddressListRow(NavLocation navLocation, int n) {
    }

    default public EvoListRow buildTextListRow(String string, int n) {
    }
}

