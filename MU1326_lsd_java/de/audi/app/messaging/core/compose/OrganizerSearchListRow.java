/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.app.addressbook.core.common.search.organizer.ADBOrganizerSearchListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.organizer.DataSet;

public class OrganizerSearchListRow
extends ADBOrganizerSearchListRow {
    protected int adbMode;

    protected OrganizerSearchListRow(DataSet dataSet, int n) {
        super(dataSet);
        this.adbMode = n;
        this.setInteger(0, ADBUtils.hasRelevantData(dataSet, n) ? 1 : 0);
    }

    public EvoListRow copy() {
        return new OrganizerSearchListRow(this.dataSet, this.adbMode);
    }

    public static OrganizerSearchListRow[] createFromDataSets(DataSet[] dataSetArray, int n) {
        if (dataSetArray == null) {
            return null;
        }
        OrganizerSearchListRow[] organizerSearchListRowArray = new OrganizerSearchListRow[dataSetArray.length];
        for (int i2 = 0; i2 < dataSetArray.length; ++i2) {
            organizerSearchListRowArray[i2] = new OrganizerSearchListRow(dataSetArray[i2], n);
        }
        return organizerSearchListRowArray;
    }
}

