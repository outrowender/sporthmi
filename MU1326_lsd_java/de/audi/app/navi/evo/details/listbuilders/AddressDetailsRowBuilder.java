/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.details.listbuilders;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.details.IDetailsRowBuilder;

public class AddressDetailsRowBuilder
implements IDetailsRowBuilder {
    public EvoListRow buildListRow(String string, int n) {
        EvoListRow evoListRow = new EvoListRow(n, 3);
        evoListRow.setText(1, string);
        evoListRow.setInteger(2, 0);
        return evoListRow;
    }

    public EvoListRow buildListRowWithIcon(String string, int n, int n2) {
        EvoListRow evoListRow = new EvoListRow(n2, 3);
        IconCell iconCell = new IconCell(new HMIResourceLocator(n));
        evoListRow.setIconCell(0, iconCell);
        evoListRow.setText(1, string);
        evoListRow.setInteger(2, 1);
        return evoListRow;
    }
}

