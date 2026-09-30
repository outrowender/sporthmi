/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.favorite;

import de.audi.tghu.navi.app.favorite.IFavoriteLocationFormat;
import org.dsi.ifc.global.NavLocation;

public class FavoriteLocationFormatDummy
implements IFavoriteLocationFormat {
    public String getDefaultName(NavLocation navLocation) {
        return "";
    }
}

