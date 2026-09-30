/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.evo.common.search.organizer;

import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.app.addressbook.core.common.search.organizer.ADBOrganizerSearchListRow;
import de.audi.app.addressbook.evo.common.search.ADBFocusPropertiesHelper;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.organizer.DataSet;

public class ADBEvoOrganizerSearchListRow
extends ADBOrganizerSearchListRow {
    protected int adbMode;
    protected int entryDrawerCategory;

    protected ADBEvoOrganizerSearchListRow(DataSet dataSet, int n, int n2) {
        super(dataSet);
        this.adbMode = n;
        this.entryDrawerCategory = n2;
        this.setInteger(0, ADBUtils.hasRelevantData(dataSet, n) ? 1 : 0);
        this.setPropertyCell(4, new PropertyListCell(n2, ADBFocusPropertiesHelper.getFocusProperties(dataSet)));
        this.setInteger(8, 0);
    }

    public EvoListRow copy() {
        ADBEvoOrganizerSearchListRow aDBEvoOrganizerSearchListRow = new ADBEvoOrganizerSearchListRow(this.dataSet, this.adbMode, this.entryDrawerCategory);
        aDBEvoOrganizerSearchListRow.setOpen(this.isOpen());
        return aDBEvoOrganizerSearchListRow;
    }

    public static ADBEvoOrganizerSearchListRow[] createFromDataSets(DataSet[] dataSetArray, int n, int n2) {
        if (dataSetArray == null) {
            return null;
        }
        ADBEvoOrganizerSearchListRow[] aDBEvoOrganizerSearchListRowArray = new ADBEvoOrganizerSearchListRow[dataSetArray.length];
        for (int i2 = 0; i2 < dataSetArray.length; ++i2) {
            aDBEvoOrganizerSearchListRowArray[i2] = new ADBEvoOrganizerSearchListRow(dataSetArray[i2], n, n2);
        }
        return aDBEvoOrganizerSearchListRowArray;
    }

    public void setOpen(boolean bl) {
        this.setInteger(8, bl ? 1 : 0);
    }

    public boolean isOpen() {
        return this.getInteger(8) == 1;
    }
}

