/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import org.dsi.ifc.sdars.CategoryInfo;

public class CategoryInfoExt
extends CategoryInfo {
    public static final CategoryInfoExt EMPTY_CATEGORY = new CategoryInfoExt(-1, "", "", true);
    public final boolean isGracenoteRequest;

    public CategoryInfoExt(CategoryInfo categoryInfo, boolean bl) {
        super(categoryInfo.categoryNumber, categoryInfo.shortLabel, categoryInfo.fullLabel);
        this.isGracenoteRequest = bl;
    }

    public CategoryInfoExt(short s, String string, String string2, boolean bl) {
        super(s, string, string2);
        this.isGracenoteRequest = bl;
    }
}

