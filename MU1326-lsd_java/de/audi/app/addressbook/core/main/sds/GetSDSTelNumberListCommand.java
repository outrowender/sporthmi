/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.sds;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.ADBModelUtils;
import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.app.addressbook.core.common.AbstractADBEntryDetailsListRowBuilder;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.app.addressbook.core.main.sds.ADBSDSHandler;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.AdbEntry;

public class GetSDSTelNumberListCommand
extends AbstractADBCommand {
    private static final int PHONETYPE_GENERAL;
    private AbstractAddressBookApplication appAdr;
    private long entryId;
    private ADBSDSHandler sdsHandler;
    private int sdsPhoneNumberTypes;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$sds$GetSDSTelNumberListCommand;

    public GetSDSTelNumberListCommand(AbstractAddressBookApplication abstractAddressBookApplication, long l, ADBSDSHandler aDBSDSHandler, int n) {
        super(abstractAddressBookApplication);
        this.appAdr = abstractAddressBookApplication;
        this.entryId = l;
        this.sdsHandler = aDBSDSHandler;
        this.sdsPhoneNumberTypes = n;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "GetSDSTelNumberListCommand#execute()");
        boolean bl = this.adbDSIAccess.getEntries(new long[]{this.entryId}, 0, 0);
        if (!bl) {
            this.logger.log(10000, "GetSDSTelNumberListCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
            this.sdsHandler.fillTelNumberListResult(1, "", null, new int[0]);
        }
    }

    @Override
    public void getEntriesResult(int n, AdbEntry[] adbEntryArray) {
        this.logger.log(-2137614336, "GetSDSTelNumberListCommand#getEntriesResult(): success: %2, entryList: %1", (Object)adbEntryArray, (Object)ADBDbgUtils.dbgSuccessFlag(n));
        if (n == 0) {
            if (adbEntryArray.length == 1) {
                this.logger.log(-2137614336, "GetSDSTelNumberListCommand#getEntriesResult(): got entry: %1", (Object)adbEntryArray[0]);
                ADBUtils.checkAndFixADBEntry(adbEntryArray[0], this.appAdr.getFramework());
                this.appAdr.getHMIService().getLabelModel(1303382528).setText(adbEntryArray[0].combinedName);
                int[] nArray = new int[ADBUtils.countPhoneNumbers(adbEntryArray[0])];
                int n2 = 0;
                for (int i2 = 0; i2 < adbEntryArray[0].phoneData.length; ++i2) {
                    if (ADBUtils.isValidPhoneNumber(adbEntryArray[0].phoneData[i2])) {
                        nArray[n2++] = ADBModelUtils.getIconTypeForPhoneNumber(adbEntryArray[0].phoneData[i2].numberType);
                    }
                    if (GetSDSTelNumberListCommand.doesNumberTypeMatchFilter(this.sdsPhoneNumberTypes, adbEntryArray[0].phoneData[i2].numberType)) continue;
                    adbEntryArray[0].phoneData[i2].number = "";
                }
                AbstractADBEntryDetailsListRowBuilder.fillTelNumberList(adbEntryArray[0], this.appAdr.getHMIService().getBaseListModel(3857), this.sdsHandler.getRowBuilder());
                ResourceLocator resourceLocator = adbEntryArray[0].personalData != null ? adbEntryArray[0].personalData.contactPicture : null;
                this.sdsHandler.fillTelNumberListResult(0, adbEntryArray[0].combinedName, resourceLocator, nArray);
            } else {
                this.logger.log(10000, "GetSDSTelNumberListCommand#getEntriesResult(): exactly one entry was requested, but entryList length is: %1", (long)adbEntryArray.length);
                this.sdsHandler.fillTelNumberListResult(1, "", null, new int[0]);
            }
        } else {
            this.sdsHandler.fillTelNumberListResult(1, "", null, new int[0]);
        }
        this.commandList.commandFinished();
    }

    public static boolean doesNumberTypeMatchFilter(int n, int n2) {
        int n3 = ADBModelUtils.getModelPhoneNumberCategory(n);
        int n4 = ADBModelUtils.getModelPhoneNumberType(n);
        int n5 = ADBModelUtils.getModelPhoneNumberCategory(n2);
        int n6 = ADBModelUtils.getModelPhoneNumberType(n2);
        return (n & 6) != 6 && (n3 == 3 || n3 == n5) && (n4 == 2 || n4 == n6) || (n & 6) == 6 && (n5 == 0 && n6 == 2 || n5 == 2 && n6 == 2 || n5 == 3 && n6 == 2);
    }

    public static void createGetSDSTelNumberListCommand(AbstractAddressBookApplication abstractAddressBookApplication, long l, ADBSDSHandler aDBSDSHandler, int n) {
        GetSDSTelNumberListCommand getSDSTelNumberListCommand = new GetSDSTelNumberListCommand(abstractAddressBookApplication, l, aDBSDSHandler, n);
        CommandList commandList = new CommandList(abstractAddressBookApplication.getCommandListManager());
        commandList.add(getSDSTelNumberListCommand);
        commandList.execute((class$de$audi$app$addressbook$core$main$sds$GetSDSTelNumberListCommand == null ? (class$de$audi$app$addressbook$core$main$sds$GetSDSTelNumberListCommand = GetSDSTelNumberListCommand.class$("de.audi.app.addressbook.core.main.sds.GetSDSTelNumberListCommand")) : class$de$audi$app$addressbook$core$main$sds$GetSDSTelNumberListCommand).getName());
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

