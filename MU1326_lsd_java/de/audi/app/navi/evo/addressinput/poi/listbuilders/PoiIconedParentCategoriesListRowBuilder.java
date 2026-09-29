/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listbuilders;

import de.audi.app.navi.evo.addressinput.poi.listbuilders.EvoRRDInitialPositionHandler;
import de.audi.app.navi.evo.addressinput.poi.listbuilders.PoiIconedParentCategoriesListRow;
import de.audi.app.navi.evo.addressinput.poi.listbuilders.PoiIconedParentCategoriesParentListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.listbuilders.IEvoListRowBuilder;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiIconedParentCategoriesListRowBuilder
implements IEvoListRowBuilder {
    private final IconHandler iconHandler;
    private final EvoRRDInitialPositionHandler evoRRDInitialPositionHandler;
    private final NavigationEnv env;

    public PoiIconedParentCategoriesListRowBuilder(IconHandler iconHandler, EvoRRDInitialPositionHandler evoRRDInitialPositionHandler, NavigationEnv navigationEnv) {
        this.iconHandler = iconHandler;
        this.evoRRDInitialPositionHandler = evoRRDInitialPositionHandler;
        this.env = navigationEnv;
    }

    @Override
    public EvoListRow buildListRow(LIValueListElement lIValueListElement, int n) {
        if (n == -1) {
            return new PoiIconedParentCategoriesParentListRow(this.iconHandler, lIValueListElement, n, this.evoRRDInitialPositionHandler.getInitialPosition(), this.env);
        }
        return new PoiIconedParentCategoriesListRow(this.iconHandler, lIValueListElement, n, this.evoRRDInitialPositionHandler.getInitialPosition());
    }
}

