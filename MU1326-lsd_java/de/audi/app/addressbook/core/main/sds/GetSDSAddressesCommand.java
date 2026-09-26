/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.sds;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.app.addressbook.core.common.AbstractADBEntryDetailsListRowBuilder;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.app.addressbook.core.main.sds.ADBSDSHandler;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.interapp.ADBSDSAddressDetails;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;

public class GetSDSAddressesCommand
extends AbstractADBCommand {
    private AbstractAddressBookApplication appAdr;
    private long entryId;
    private ADBSDSHandler sdsHandler;
    private boolean showBusinessAddresses;
    private boolean showPrivateAddresses;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$sds$GetSDSAddressesCommand;

    public GetSDSAddressesCommand(AbstractAddressBookApplication abstractAddressBookApplication, long l, ADBSDSHandler aDBSDSHandler, boolean bl, boolean bl2) {
        super(abstractAddressBookApplication);
        this.appAdr = abstractAddressBookApplication;
        this.entryId = l;
        this.sdsHandler = aDBSDSHandler;
        this.showBusinessAddresses = bl;
        this.showPrivateAddresses = bl2;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "GetSDSAddressesCommand#execute()");
        boolean bl = this.adbDSIAccess.getEntries(new long[]{this.entryId}, 0, 0);
        if (!bl) {
            this.logger.log(10000, "GetSDSAddressesCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
            this.sdsHandler.showAddressesResult(1, new int[0], "");
        }
    }

    @Override
    public void getEntriesResult(int n, AdbEntry[] adbEntryArray) {
        this.logger.log(-2137614336, "GetSDSAddressesCommand#getEntriesResult(): success: %2, entryList: %1", (Object)adbEntryArray, (Object)ADBDbgUtils.dbgSuccessFlag(n));
        if (n == 0) {
            if (adbEntryArray.length == 1) {
                AdbEntry adbEntry = adbEntryArray[0];
                this.logger.log(1078071040, "GetSDSAddressesCommand#getEntriesResult(): got entry: %1", (Object)adbEntry);
                ADBUtils.checkAndFixADBEntry(adbEntry, this.appAdr.getFramework());
                if (!this.showBusinessAddresses) {
                    adbEntry.addressData[0] = new AddressData(1, "", "", "", "", "", "", false, "", 0, null, new ResourceLocator());
                }
                if (!this.showPrivateAddresses) {
                    adbEntry.addressData[1] = new AddressData(2, "", "", "", "", "", "", false, "", 0, null, new ResourceLocator());
                }
                this.appAdr.getHMIService().getLabelModel(1303382528).setText(adbEntry.combinedName);
                BaseListModelApp baseListModelApp = this.appAdr.getHMIService().getBaseListModel(3856);
                AbstractADBEntryDetailsListRowBuilder.fillAddressList(adbEntry, baseListModelApp, this.sdsHandler.getRowBuilder());
                ADBSDSAddressDetails[] aDBSDSAddressDetailsArray = GetSDSAddressesCommand.createSDSAddressDetails(baseListModelApp);
                this.sdsHandler.setAddressDetails(aDBSDSAddressDetailsArray);
                int[] nArray = new int[aDBSDSAddressDetailsArray.length];
                for (int i2 = 0; i2 < aDBSDSAddressDetailsArray.length; ++i2) {
                    nArray[i2] = aDBSDSAddressDetailsArray[i2].getAddressType();
                }
                this.sdsHandler.showAddressesResult(0, nArray, adbEntry.combinedName);
            } else {
                this.logger.log(10000, "GetSDSAddressesCommand#getEntriesResult(): exactly one entry was requested, but entryList length is: %1", (long)adbEntryArray.length);
                this.sdsHandler.showAddressesResult(1, new int[0], "");
            }
        } else {
            this.sdsHandler.showAddressesResult(1, new int[0], "");
        }
        this.commandList.commandFinished();
    }

    public static void createGetSDSAddressesCommand(AbstractAddressBookApplication abstractAddressBookApplication, long l, ADBSDSHandler aDBSDSHandler, boolean bl, boolean bl2) {
        GetSDSAddressesCommand getSDSAddressesCommand = new GetSDSAddressesCommand(abstractAddressBookApplication, l, aDBSDSHandler, bl, bl2);
        CommandList commandList = new CommandList(abstractAddressBookApplication.getCommandListManager());
        commandList.add(getSDSAddressesCommand);
        commandList.execute((class$de$audi$app$addressbook$core$main$sds$GetSDSAddressesCommand == null ? (class$de$audi$app$addressbook$core$main$sds$GetSDSAddressesCommand = GetSDSAddressesCommand.class$("de.audi.app.addressbook.core.main.sds.GetSDSAddressesCommand")) : class$de$audi$app$addressbook$core$main$sds$GetSDSAddressesCommand).getName());
    }

    private static ADBSDSAddressDetails[] createSDSAddressDetails(BaseListModelApp baseListModelApp) {
        ADBSDSAddressDetails[] aDBSDSAddressDetailsArray = new ADBSDSAddressDetails[baseListModelApp.getLength()];
        for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
            ADBEntryDetailsListRow aDBEntryDetailsListRow = (ADBEntryDetailsListRow)baseListModelApp.getRow(i2);
            aDBSDSAddressDetailsArray[i2] = new ADBSDSAddressDetails(aDBEntryDetailsListRow.getEntry(), aDBEntryDetailsListRow.getAddressType());
        }
        return aDBSDSAddressDetailsArray;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

