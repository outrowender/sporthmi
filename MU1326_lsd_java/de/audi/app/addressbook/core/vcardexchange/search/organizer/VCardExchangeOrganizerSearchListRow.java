/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.vcardexchange.search.organizer;

import de.audi.app.addressbook.core.common.search.organizer.ADBOrganizerSearchListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import java.util.Set;
import org.dsi.ifc.organizer.DataSet;

public class VCardExchangeOrganizerSearchListRow
extends ADBOrganizerSearchListRow {
    protected VCardExchangeOrganizerSearchListRow(DataSet dataSet, boolean bl) {
        super(dataSet);
        this.setInteger(6, bl ? 1 : 0);
    }

    public EvoListRow copy() {
        return new VCardExchangeOrganizerSearchListRow(this.dataSet, this.getInteger(6) == 1);
    }

    public void toggleCheckBox() {
        this.setInteger(6, this.getInteger(6) == 0 ? 1 : 0);
    }

    public static VCardExchangeOrganizerSearchListRow[] createFromDataSets(DataSet[] dataSetArray, boolean bl, Set set) {
        if (dataSetArray == null) {
            return null;
        }
        VCardExchangeOrganizerSearchListRow[] vCardExchangeOrganizerSearchListRowArray = new VCardExchangeOrganizerSearchListRow[dataSetArray.length];
        for (int i2 = 0; i2 < dataSetArray.length; ++i2) {
            boolean bl2 = bl == set.contains(new Long(dataSetArray[i2].getEntryId()));
            vCardExchangeOrganizerSearchListRowArray[i2] = new VCardExchangeOrganizerSearchListRow(dataSetArray[i2], bl2);
        }
        return vCardExchangeOrganizerSearchListRowArray;
    }
}

