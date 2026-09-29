/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.search.organizer;

import de.audi.app.addressbook.core.common.ADBModelUtils;
import de.audi.app.addressbook.core.common.search.ADBSearchListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.DataSet;

public class ADBOrganizerSearchListRow
extends EvoListRow
implements ADBSearchListRow {
    protected DataSet dataSet;

    public ADBOrganizerSearchListRow(DataSet dataSet) {
        super(dataSet.getEntryId(), 11);
        this.dataSet = dataSet;
        this.setInteger(1, 6);
        this.setInteger(2, ADBModelUtils.getEntryTypeModelValue(dataSet.getEntryType()));
        this.setText(3, dataSet.getGeneralDescription1());
    }

    @Override
    public EvoListRow copy() {
        return new ADBOrganizerSearchListRow(this.dataSet);
    }

    public DataSet getDataSet() {
        return this.dataSet;
    }

    @Override
    public long getEntryId() {
        return this.dataSet.getEntryId();
    }

    @Override
    public String getCombinedName() {
        return this.dataSet.getGeneralDescription1();
    }

    @Override
    public int getEntryType() {
        return this.dataSet.getEntryType();
    }

    @Override
    public ResourceLocator getContactPicture() {
        return this.dataSet.getContactPicture();
    }

    @Override
    public int getPhoneCount() {
        return this.dataSet.getPhoneCount();
    }
}

