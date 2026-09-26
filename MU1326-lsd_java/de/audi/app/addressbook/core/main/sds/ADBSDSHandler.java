/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.sds;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.ADBListRow;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.app.addressbook.core.main.models.AddressBookEntryDetailsListRowBuilder;
import de.audi.app.addressbook.core.main.sds.GetEntryNamesCommand;
import de.audi.app.addressbook.core.main.sds.GetPickListDataSetsCommand;
import de.audi.app.addressbook.core.main.sds.GetSDSAddressesCommand;
import de.audi.app.addressbook.core.main.sds.GetSDSEmailListCommand;
import de.audi.app.addressbook.core.main.sds.GetSDSTelNumberListCommand;
import de.audi.app.addressbook.core.main.sds.SDSGetEntryCommand;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.interapp.ADBSDSAddressDetails;
import de.audi.atip.interapp.ADBSDSService;
import de.audi.atip.interapp.ADBSDSService$EmailAddressDetails;
import de.audi.atip.interapp.ADBSDSService$TelNumberDetails;
import de.audi.atip.interapp.ADBSDSServiceListener;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.EmailData;
import org.dsi.ifc.organizer.PhoneData;

public class ADBSDSHandler
implements ADBSDSService {
    private LogChannel log;
    private AbstractAddressBookApplication appAdr;
    private ADBSDSServiceListener sdsListener;
    private ADBSDSAddressDetails[] addressDetails;
    private AddressBookEntryDetailsListRowBuilder rowBuilder;

    public ADBSDSHandler(AbstractAddressBookApplication abstractAddressBookApplication, LogChannel logChannel) {
        this.appAdr = abstractAddressBookApplication;
        this.log = logChannel;
        this.rowBuilder = new AddressBookEntryDetailsListRowBuilder(abstractAddressBookApplication);
    }

    public void setSDSServiceListener(ADBSDSServiceListener aDBSDSServiceListener) {
        this.log.log(1078071040, "ADBSDSHandler#setSDSServiceListener(): got ADBSDSServiceListener: %1", (Object)aDBSDSServiceListener);
        this.sdsListener = aDBSDSServiceListener;
    }

    public void setAddressDetails(ADBSDSAddressDetails[] aDBSDSAddressDetailsArray) {
        this.addressDetails = aDBSDSAddressDetailsArray;
    }

    public AddressBookEntryDetailsListRowBuilder getRowBuilder() {
        return this.rowBuilder;
    }

    @Override
    public void fillAdbPickList(long[] lArray, String[] stringArray, int[] nArray) {
        this.log.log(1078071040, "ADBSDSHandler#fillAdbPickList()");
        if (lArray == null || stringArray == null || nArray == null || lArray.length != stringArray.length || stringArray.length != nArray.length) {
            this.log.log(10000, "ADBSDSHandler#fillAdbPickList(): invalid parameters!");
            this.fillAdbPickListResult(1);
            return;
        }
        GetPickListDataSetsCommand.createGetPickListDataSetsCommand(this.appAdr, lArray, stringArray, nArray, this);
    }

    @Override
    public void fillTelNumberList(long l, int n) {
        this.log.log(1078071040, "ADBSDSHandler#fillTelNumberList(): entryID: %1, phoneNumberTypes: %2", l, (long)n);
        GetSDSTelNumberListCommand.createGetSDSTelNumberListCommand(this.appAdr, l, this, n);
    }

    @Override
    public ADBSDSService$TelNumberDetails getTelNumberDetails(int n) {
        BaseListModelApp baseListModelApp = this.appAdr.getHMIService().getBaseListModel(3857);
        ADBEntryDetailsListRow aDBEntryDetailsListRow = (ADBEntryDetailsListRow)baseListModelApp.getRow(n);
        ADBSDSService$TelNumberDetails aDBSDSService$TelNumberDetails = new ADBSDSService$TelNumberDetails();
        PhoneData phoneData = aDBEntryDetailsListRow.getEntry().getPhoneData()[aDBEntryDetailsListRow.getDataIndex()];
        aDBSDSService$TelNumberDetails.telNumber = phoneData.getNumber();
        aDBSDSService$TelNumberDetails.telNumberType = phoneData.getNumberType();
        aDBSDSService$TelNumberDetails.combinedName = aDBEntryDetailsListRow.getEntry().getCombinedName();
        aDBSDSService$TelNumberDetails.entryType = aDBEntryDetailsListRow.getEntry().getEntryType();
        this.log.log(1078071040, "ADBSDSHandler#getTelNumberDetails(): combinedName: %1, telNumber: %2, telNumberType: %3", (Object)aDBSDSService$TelNumberDetails.combinedName, (Object)aDBSDSService$TelNumberDetails.telNumber, (long)aDBSDSService$TelNumberDetails.telNumberType);
        return aDBSDSService$TelNumberDetails;
    }

    @Override
    public void fillEmailList(long l) {
        this.log.log(-2137614336, "ADBSDSHandler#fillEmailList(): entryID: %1", l);
        GetSDSEmailListCommand.createGetSDSEmailListCommand(this.appAdr, l, this);
    }

    @Override
    public ADBSDSService$EmailAddressDetails getEmailAddressDetails(int n, int n2) {
        HMIModelApp hMIModelApp = this.appAdr.getHMIService().getModelApp(n);
        if (hMIModelApp == null || !(hMIModelApp instanceof BaseListModelApp)) {
            this.log.log(10000, "ADBSDSHandler#getEmailAddressDetails(): model with id %1 not found or not a BaseListModelApp", (long)n);
            return null;
        }
        BaseListModelApp baseListModelApp = (BaseListModelApp)hMIModelApp;
        EvoListRow evoListRow = baseListModelApp.getRow(n2);
        if (evoListRow == null || !(evoListRow instanceof ADBEntryDetailsListRow)) {
            this.log.log(10000, "ADBSDSHandler#getEmailAddressDetails(): row at index %1 not found in model with id %2, or row is not an ADBEntryDetailsListRow", (long)n2, (long)n);
            return null;
        }
        ADBEntryDetailsListRow aDBEntryDetailsListRow = (ADBEntryDetailsListRow)evoListRow;
        ADBSDSService$EmailAddressDetails aDBSDSService$EmailAddressDetails = new ADBSDSService$EmailAddressDetails();
        EmailData emailData = aDBEntryDetailsListRow.getEntry().getEmailData()[aDBEntryDetailsListRow.getDataIndex()];
        aDBSDSService$EmailAddressDetails.email = emailData.getEmailAddr();
        aDBSDSService$EmailAddressDetails.combinedName = aDBEntryDetailsListRow.getEntry().getCombinedName();
        aDBSDSService$EmailAddressDetails.entryType = aDBEntryDetailsListRow.getEntry().getEntryType();
        this.log.log(1078071040, "ADBSDSHandler#getEmailAddressDetails(): combinedName: %1, email: %2, entryType: %3", (Object)aDBSDSService$EmailAddressDetails.combinedName, (Object)aDBSDSService$EmailAddressDetails.email, (Object)ADBDbgUtils.dbgEntryType(aDBSDSService$EmailAddressDetails.entryType));
        return aDBSDSService$EmailAddressDetails;
    }

    @Override
    public void showAddresses(long l, boolean bl, boolean bl2) {
        this.log.log(1078071040, "ADBSDSHandler#showAddresses(): entryID: %1", l);
        GetSDSAddressesCommand.createGetSDSAddressesCommand(this.appAdr, l, this, bl, bl2);
    }

    @Override
    public ADBSDSAddressDetails getAddressDetails(int n) {
        if (this.addressDetails == null || this.addressDetails.length == 0) {
            this.log.log(10000, "ADBSDSHandler#getAddressDetails(): no addressDetails available.");
            return null;
        }
        for (int i2 = 0; i2 < this.addressDetails.length; ++i2) {
            if (this.addressDetails[i2].getAddressType() != n) continue;
            this.log.log(1078071040, "ADBSDSHandler#getAddressDetails(): returning addressDetails with addressType: %1", (long)this.addressDetails[i2].getAddressType());
            return this.addressDetails[i2];
        }
        this.log.log(10000, "ADBSDSHandler#getAddressDetails(): no addressDetails available for addressType %1.", (long)n);
        return null;
    }

    @Override
    public long getCurrentEntryId() {
        long l = this.appAdr.getCurrentEntry() != null ? this.appAdr.getCurrentEntry().entryId : 0L;
        this.log.log(1078071040, "ADBSDSHandler#getCurrentEntryId(): currentEntryId: %1", l);
        return l;
    }

    @Override
    public int getAdbProfileID() {
        int n = this.appAdr.getAdbStateHandler().getActiveProfile();
        this.log.log(1078071040, "ADBSDSHandler#getAdbProfileID(): activeProfileNum: %1", (long)n);
        return n;
    }

    @Override
    public void openEntryDetails(long l) {
        this.log.log(1078071040, "ADBSDSHandler#openEntryDetails(): entryID: %1", l);
        SDSGetEntryCommand.createSDSGetEntryCommand(this.appAdr, l, this.appAdr.getHMIService().getModelApp(1370491392), this);
    }

    @Override
    public long getEntryIDFromListRow(EvoListRow evoListRow) {
        long l = 0L;
        if (evoListRow != null && evoListRow instanceof ADBListRow) {
            l = ((ADBListRow)((Object)evoListRow)).getEntryId();
        }
        this.log.log(1078071040, "ADBSDSHandler#getEntryIDFromListRow(): returning entryId %1", l);
        return l;
    }

    @Override
    public void getEntryNames(long[] lArray) {
        this.log.log(1078071040, "ADBSDSHandler#getEntryNames(): entryIDs: %1", (Object)lArray);
        GetEntryNamesCommand.createGetEntryNamesCommand(this.appAdr, lArray, this);
    }

    public void fillAdbPickListResult(int n) {
        this.log.log(1078071040, "ADBSDSHandler#fillAdbPickListResult(): resultCode: %1", (Object)ADBDbgUtils.dbgAdbSDSServiceResultCode(n));
        if (this.sdsListener != null) {
            this.sdsListener.responseFillAdbPickList(n);
        } else {
            this.log.log(10000, "ADBSDSHandler#fillAdbPickListResult(): sdsListener not available!");
        }
    }

    public void fillTelNumberListResult(int n, String string, ResourceLocator resourceLocator, int[] nArray) {
        this.log.log(1078071040, "ADBSDSHandler#fillTelNumberListResult(): resultCode: %1, combinedName: %2, contactPicture: %3, totalNumPhoneNumbers: %4", (Object)ADBDbgUtils.dbgAdbSDSServiceResultCode(n), (Object)string, (Object)resourceLocator, (Object)nArray);
        if (this.sdsListener != null) {
            this.sdsListener.responseFillTelNumberList(n, string, resourceLocator == null ? -1 : resourceLocator.getId(), resourceLocator == null ? null : resourceLocator.getUrl(), nArray);
        } else {
            this.log.log(10000, "ADBSDSHandler#fillTelNumberListResult(): sdsListener not available!");
        }
    }

    public void fillEmailListResult(int n, String string, ResourceLocator resourceLocator, int n2) {
        this.log.log(1078071040, "ADBSDSHandler#fillEmailListResult(): resultCode: %1, combinedName: %2, contactPicture: %3, totalNumEmailAddresses: %4", (Object)ADBDbgUtils.dbgAdbSDSServiceResultCode(n), (Object)string, (Object)resourceLocator, (long)n2);
        if (this.sdsListener != null) {
            this.sdsListener.responseFillEmailList(n, string, resourceLocator == null ? -1 : resourceLocator.getId(), resourceLocator == null ? null : resourceLocator.getUrl(), n2);
        } else {
            this.log.log(10000, "ADBSDSHandler#fillEmailListResult(): sdsListener not available!");
        }
    }

    public void showAddressesResult(int n, int[] nArray, String string) {
        this.log.log(1078071040, "ADBSDSHandler#showAddressesResult(): resultCode: %2, availableAddresses: %1", (Object)nArray, (Object)ADBDbgUtils.dbgAdbSDSServiceResultCode(n));
        if (this.sdsListener != null) {
            this.sdsListener.responseShowAddresses(n, nArray, string);
        } else {
            this.log.log(10000, "ADBSDSHandler#showAddressesResult(): sdsListener not available!");
        }
    }

    @Override
    public byte freezeDynamicLists() {
        return 0;
    }

    @Override
    public byte unfreezeDynamicLists() {
        return 0;
    }

    public void openEntryDetailsResult(int n, String string) {
        this.log.log(1078071040, "ADBSDSHandler#openEntryDetailsResult(): success: %2, entryName: %1", (Object)string, (Object)ADBDbgUtils.dbgAdbSDSServiceResultCode(n));
        if (this.sdsListener != null) {
            this.sdsListener.responseOpenEntryDetails(n, string);
        } else {
            this.log.log(10000, "ADBSDSHandler#openEntryDetailsResult(): sdsListener not available!");
        }
    }

    public void getEntryNamesResult(String[] stringArray) {
        this.log.log(1078071040, "ADBSDSHandler#getEntryNamesResult(): entryNames: %1", (Object)stringArray);
        if (this.sdsListener != null) {
            this.sdsListener.responseGetEntryNames(stringArray);
        } else {
            this.log.log(10000, "ADBSDSHandler#getEntryNamesResult(): sdsListener not available!");
        }
    }
}

