/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.details;

import de.audi.app.navi.evo.addressinput.poi.details.PoiStackListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.addressinput.listbuilders.IEvoListRowBuilder;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiStackDetailsRowBuilder
implements IEvoListRowBuilder {
    private final IconHandler iconHandler;

    public PoiStackDetailsRowBuilder(IconHandler iconHandler) {
        this.iconHandler = iconHandler;
    }

    public EvoListRow buildListRow(LIValueListElement lIValueListElement, int n) {
        PoiStackListRow poiStackListRow = new PoiStackListRow(this.iconHandler, lIValueListElement, n);
        return poiStackListRow;
    }
}

