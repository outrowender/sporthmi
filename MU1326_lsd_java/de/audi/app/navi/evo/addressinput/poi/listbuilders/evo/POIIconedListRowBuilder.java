/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listbuilders.evo;

import de.audi.app.navi.evo.addressinput.poi.listbuilders.evo.PoiIconedListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.addressinput.listbuilders.IEvoListRowBuilder;
import org.dsi.ifc.navigation.LIValueListElement;

public class POIIconedListRowBuilder
implements IEvoListRowBuilder {
    private final IconHandler iconHandler;

    public POIIconedListRowBuilder(IconHandler iconHandler) {
        this.iconHandler = iconHandler;
    }

    public EvoListRow buildListRow(LIValueListElement lIValueListElement, int n) {
        return new PoiIconedListRow(this.iconHandler, lIValueListElement, n);
    }
}

