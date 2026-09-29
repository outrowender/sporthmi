/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listbuilders;

import de.audi.app.navi.evo.addressinput.poi.listbuilders.PoiNameListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.addressinput.listbuilders.IEvoListRowBuilder;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiNameListRowBuilder
implements IEvoListRowBuilder {
    @Override
    public EvoListRow buildListRow(LIValueListElement lIValueListElement, int n) {
        PoiNameListRow poiNameListRow = new PoiNameListRow(lIValueListElement, n);
        return poiNameListRow;
    }
}

