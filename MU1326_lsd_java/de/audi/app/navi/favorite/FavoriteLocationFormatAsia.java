/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.favorite;

import de.audi.app.navi.favorite.FavoriteLocationFormatEU;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import org.dsi.ifc.global.NavLocation;

public class FavoriteLocationFormatAsia
extends FavoriteLocationFormatEU {
    private NavigationEnv env;

    public FavoriteLocationFormatAsia(NavigationEnv navigationEnv) {
        super(navigationEnv);
        this.env = navigationEnv;
    }

    @Override
    public String formatAddress(NavLocation navLocation) {
        return AddressFormatter.formatOneLine(navLocation, this.env).getFirstLineAsText();
    }
}

