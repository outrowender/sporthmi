/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.adb;

import de.audi.app.addressbook.core.common.search.organizer.ADBOrganizerSearchListRow;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.organizer.DataSet;

public class TelEvoADBMatchSpellerListRow
extends ADBOrganizerSearchListRow {
    public TelEvoADBMatchSpellerListRow(DataSet dataSet) {
        this(dataSet, false);
    }

    private TelEvoADBMatchSpellerListRow(DataSet dataSet, boolean bl) {
        super(dataSet);
        this.setPropertyCell(4, new PropertyListCell(1859627275, new int[]{-1571551967}));
        this.setOpen(bl);
    }

    public EvoListRow copy() {
        return new TelEvoADBMatchSpellerListRow(this.dataSet, this.isOpen());
    }

    public void setOpen(boolean bl) {
        this.setInteger(8, bl ? 1 : 0);
    }

    public boolean isOpen() {
        return this.getInteger(8) == 1;
    }
}

