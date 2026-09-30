/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.commands.edit;

import de.audi.app.addressbook.core.common.ADBAddressUtils;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.app.addressbook.core.main.commands.edit.AbstractGetEntryCommand;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.organizer.AdbEntry;

public class GetEntryAndEditNavDestinationCommand
extends AbstractGetEntryCommand {
    private short addressIndex;
    private int mode;
    public static final int MODE_CREATE = 0;
    public static final int MODE_EDIT = 1;
    private int tbmMode;
    public static final int TBM_MODE_UNDECIDED = 0;
    public static final int TBM_MODE_USE_TBM = 1;
    public static final int TBM_MODE_CREATE_NEW = 2;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$commands$edit$GetEntryAndEditNavDestinationCommand;

    public GetEntryAndEditNavDestinationCommand(AbstractAddressBookApplication abstractAddressBookApplication, long l, int n, short s, int n2) {
        super(abstractAddressBookApplication, l);
        this.mode = n;
        this.addressIndex = s;
        this.tbmMode = n2;
    }

    public boolean handleGetEntryResult(AdbEntry adbEntry) {
        this.logger.log(1000000, "GetEntryAndEditNavDestinationCommand#handleGetEntryResult(): entry: %1", (Object)ADBDbgUtils.dbgShort(adbEntry));
        if (!this.appAdr.getNaviGateway().isNaviReady()) {
            return false;
        }
        if (this.mode == 0 && this.tbmMode == 0) {
            if (ADBAddressUtils.hasValidPostalAddress(adbEntry.addressData[this.addressIndex])) {
                this.logger.log(1000000, "GetEntryAndEditNavDestinationCommand#handleGetEntryResult(): MODE_CREATE, TBM_MODE_UNDECIDED, postal address available --> show partial poup");
                this.appAdr.getHMIService().getChoiceModel(700545).setValue(1);
            } else {
                this.logger.log(1000000, "GetEntryAndEditNavDestinationCommand#handleGetEntryResult(): MODE_CREATE, TBM_MODE_UNDECIDED, no postal address available --> registering location input handler for creating a new nav location at index %1", (long)this.addressIndex);
                this.appAdr.getHMIService().getChoiceModel(700545).setValue(0);
                this.appAdr.getNaviGateway().editLocation(this.appAdr.getLocationInputHandler(), null);
            }
            return true;
        }
        if (this.mode == 0) {
            if (ADBAddressUtils.hasValidPostalAddress(adbEntry.addressData[this.addressIndex]) && this.tbmMode == 1) {
                this.logger.log(1000000, "GetEntryAndEditNavDestinationCommand#handleGetEntryResult(): registering try-best-match location input handler for postal address at index %1", (long)this.addressIndex);
                this.appAdr.getNaviGateway().editLocation(this.appAdr.getLocationInputHandler(), adbEntry, this.addressIndex);
            } else {
                this.logger.log(1000000, "GetEntryAndEditNavDestinationCommand#handleGetEntryResult(): registering location input handler for creating a new nav location at index %1", (long)this.addressIndex);
                this.appAdr.getNaviGateway().editLocation(this.appAdr.getLocationInputHandler(), null);
            }
            return true;
        }
        if (this.mode == 1) {
            this.logger.log(1000000, "GetEntryAndEditNavDestinationCommand#handleGetEntryResult(): registering location input handler for editing of nav location at index %1", (long)this.addressIndex);
            this.appAdr.getNaviGateway().editLocation(this.appAdr.getLocationInputHandler(), adbEntry.addressData[this.addressIndex].navLocation);
            return true;
        }
        this.logger.log(10000, "GetEntryAndEditNavDestinationCommand#handleGetEntryResult(): unknown mode: %1", (long)this.mode);
        return false;
    }

    public static void createGetEntryAndEditNavDestinationCommand(AbstractAddressBookApplication abstractAddressBookApplication, long l, int n, int n2) {
        CommandList commandList = new CommandList(abstractAddressBookApplication.getCommandListManager());
        commandList.add(new GetEntryAndEditNavDestinationCommand(abstractAddressBookApplication, l, n, (short)n2, 0));
        commandList.execute((class$de$audi$app$addressbook$core$main$commands$edit$GetEntryAndEditNavDestinationCommand == null ? (class$de$audi$app$addressbook$core$main$commands$edit$GetEntryAndEditNavDestinationCommand = GetEntryAndEditNavDestinationCommand.class$("de.audi.app.addressbook.core.main.commands.edit.GetEntryAndEditNavDestinationCommand")) : class$de$audi$app$addressbook$core$main$commands$edit$GetEntryAndEditNavDestinationCommand).getName());
    }

    public static void createGetEntryAndEditNavDestinationCommand(AbstractAddressBookApplication abstractAddressBookApplication, long l, int n, int n2, int n3) {
        CommandList commandList = new CommandList(abstractAddressBookApplication.getCommandListManager());
        commandList.add(new GetEntryAndEditNavDestinationCommand(abstractAddressBookApplication, l, n, (short)n2, n3));
        commandList.execute((class$de$audi$app$addressbook$core$main$commands$edit$GetEntryAndEditNavDestinationCommand == null ? (class$de$audi$app$addressbook$core$main$commands$edit$GetEntryAndEditNavDestinationCommand = GetEntryAndEditNavDestinationCommand.class$("de.audi.app.addressbook.core.main.commands.edit.GetEntryAndEditNavDestinationCommand")) : class$de$audi$app$addressbook$core$main$commands$edit$GetEntryAndEditNavDestinationCommand).getName());
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

