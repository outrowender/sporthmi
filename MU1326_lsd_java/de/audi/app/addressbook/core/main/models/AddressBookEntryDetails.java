/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.models;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.ADBModelUtils;
import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.app.addressbook.core.common.AbstractADBEntryDetailsListRowBuilder;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.app.addressbook.core.main.models.AddressBookEntryDetailsListRowBuilder;
import de.audi.app.addressbook.core.main.models.EntryDetailsRowSelectionHandler;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.organizer.AdbEntry;

public class AddressBookEntryDetails
implements BaseListModelListener {
    private LabelModelApp combinedNameLabel;
    private LabelModelApp firstLineNameLabel;
    private LabelModelApp secondLineNameLabel;
    private LabelModelApp combinedPhoneticLabel;
    private LabelModelApp organizationNameLabel;
    private ChoiceModelApp entryTypeChoice;
    private ResourceLocatorModelApp contactPicture;
    private BaseListModelApp telNumberList;
    private BaseListModelApp addressList;
    private BaseListModelApp emailList;
    private LogChannel log;
    private AbstractAddressBookApplication appAdr;
    private AddressBookEntryDetailsListRowBuilder rowBuilder;
    private final ModelGroup detailGroup = new ModelGroup();

    public AddressBookEntryDetails(AbstractAddressBookApplication abstractAddressBookApplication, AddressBookEntryDetailsListRowBuilder addressBookEntryDetailsListRowBuilder, LogChannel logChannel, BaseListModelApp baseListModelApp, BaseListModelApp baseListModelApp2, BaseListModelApp baseListModelApp3) {
        this.appAdr = abstractAddressBookApplication;
        this.log = logChannel;
        this.rowBuilder = addressBookEntryDetailsListRowBuilder;
        this.combinedNameLabel = abstractAddressBookApplication.getHMIService().getLabelModel(700443);
        this.firstLineNameLabel = abstractAddressBookApplication.getHMIService().getLabelModel(700589);
        this.secondLineNameLabel = abstractAddressBookApplication.getHMIService().getLabelModel(700590);
        this.combinedPhoneticLabel = abstractAddressBookApplication.getHMIService().getLabelModel(700560);
        this.organizationNameLabel = abstractAddressBookApplication.getHMIService().getLabelModel(700441);
        this.entryTypeChoice = abstractAddressBookApplication.getHMIService().getChoiceModel(700440);
        this.contactPicture = abstractAddressBookApplication.getHMIService().getResourceLocatorModel(700442);
        this.telNumberList = baseListModelApp;
        this.telNumberList.setListener(this);
        this.addressList = baseListModelApp2;
        this.addressList.setListener(this);
        this.emailList = baseListModelApp3;
        this.emailList.setListener(this);
    }

    public BaseListModelApp getTelNumberList() {
        return this.telNumberList;
    }

    public BaseListModelApp getAddressList() {
        return this.addressList;
    }

    public void updateEntryDetails(AdbEntry adbEntry) {
        this.log.log(1000000, "AddressBookEntryDetails#updateEntryDetails(): entry: %1", (Object)ADBDbgUtils.dbgShort(adbEntry));
        this.groupModels();
        ADBUtils.checkAndFixADBEntry(adbEntry, this.appAdr.getFramework());
        this.combinedNameLabel.setText(adbEntry.getCombinedName());
        boolean bl = this.appAdr.getHMIService().getChoiceModel(700494).getValue() == 1;
        this.setTwoLineName(adbEntry.getPersonalData().getFirstName(), adbEntry.getPersonalData().getLastName(), bl);
        this.combinedPhoneticLabel.setText(ADBModelUtils.getCombinedName(adbEntry.getPersonalData().getLastNameSound(), adbEntry.getPersonalData().getFirstNameSound(), this.appAdr.getHMIService().getChoiceModel(700494).getValue()));
        this.organizationNameLabel.setText(ADBUtils.isEmpty(adbEntry.getPersonalData().getOrganization()) ? "" : adbEntry.getPersonalData().getOrganization());
        this.entryTypeChoice.setValue(ADBModelUtils.getEntryTypeModelValue(adbEntry.entryType));
        ADBModelUtils.updatePicture(adbEntry.getPersonalData().getContactPicture(), this.contactPicture, this.log);
        AbstractADBEntryDetailsListRowBuilder.fillTelNumberList(adbEntry, this.telNumberList, this.rowBuilder);
        AbstractADBEntryDetailsListRowBuilder.fillAddressList(adbEntry, this.addressList, this.rowBuilder);
        AbstractADBEntryDetailsListRowBuilder.fillEmailList(adbEntry, this.emailList, this.rowBuilder);
        this.flushGroup();
    }

    public void setTwoLineName(String string, String string2, boolean bl) {
        if (ADBUtils.isEmpty(string)) {
            this.firstLineNameLabel.setText(string2);
            this.secondLineNameLabel.setText("");
        } else if (ADBUtils.isEmpty(string2)) {
            this.firstLineNameLabel.setText(string);
            this.secondLineNameLabel.setText("");
        } else {
            this.firstLineNameLabel.setText(bl ? string : string2);
            this.secondLineNameLabel.setText(bl ? string2 : string);
        }
    }

    private void groupModels() {
        this.detailGroup.add(this.combinedNameLabel);
        this.detailGroup.add(this.firstLineNameLabel);
        this.detailGroup.add(this.secondLineNameLabel);
        this.detailGroup.add(this.combinedPhoneticLabel);
        this.detailGroup.add(this.organizationNameLabel);
        this.detailGroup.add(this.telNumberList);
        this.detailGroup.add(this.emailList);
        this.detailGroup.add(this.addressList);
    }

    private void flushGroup() {
        this.detailGroup.flush();
        this.detailGroup.removeAll();
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (evoListRow instanceof ADBEntryDetailsListRow) {
            ADBEntryDetailsListRow aDBEntryDetailsListRow = (ADBEntryDetailsListRow)evoListRow;
            this.log.log(1000000, "AddressBookEntryDetails#itemSelected(): index: %1, entryId: %2, terminal: %3", (long)n2, aDBEntryDetailsListRow.getEntry().getEntryId(), (long)n4);
            boolean bl = n4 != 7;
            n3 = bl ? n3 : 0;
            boolean bl2 = EntryDetailsRowSelectionHandler.entryDetailsRowSelected(this.appAdr, aDBEntryDetailsListRow, n3, bl);
            if (bl2) {
                this.appAdr.getHMIService().getModelApp(n).fireEvent(n4);
            }
        } else {
            this.log.log(10000, "AddressBookEntryDetails#itemSelected(): evoRow is not an ADBEntryDetailsListRow!");
        }
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (evoListRow instanceof ADBEntryDetailsListRow) {
            ADBEntryDetailsListRow aDBEntryDetailsListRow = (ADBEntryDetailsListRow)evoListRow;
            this.log.log(1000000, "AddressBookEntryDetails#itemFocused(): index: %1, entryId: %2", (long)n2, aDBEntryDetailsListRow.getEntry().getEntryId());
            EntryDetailsRowSelectionHandler.entryDetailsRowFocused(this.appAdr, aDBEntryDetailsListRow);
        } else {
            this.log.log(10000, "AddressBookEntryDetails#itemFocused(): evoRow is not an ADBEntryDetailsListRow!");
        }
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }
}

