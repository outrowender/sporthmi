/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.AdbContactsGuiSearchHandler;
import de.audi.app.navi.evo.search.AdbContactsGuiSearchHandler$2$1;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.StreamToLocationCommand;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;

class AdbContactsGuiSearchHandler$2
extends NavCommand {
    private final /* synthetic */ AdbContactsGuiSearchHandler this$0;

    AdbContactsGuiSearchHandler$2(AdbContactsGuiSearchHandler adbContactsGuiSearchHandler, String string) {
        this.this$0 = adbContactsGuiSearchHandler;
        super(string);
    }

    @Override
    public void execute() {
        AdbContactsGuiSearchHandler.access$100(this.this$0).removeAll();
        AdbEntry adbEntry = this.this$0.naviADBHandler.getCurrentEntry();
        this.logger.log(-2137614336, "AdbContactsGuiSearchHandler#enter selection screen, entry is [%1]", adbEntry.entryId);
        CommandList commandList = this.getAddRowCL(adbEntry.addressData[1], 1);
        commandList.add(this.getAddRowCL(adbEntry.addressData[0], 0));
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }

    private CommandList getAddRowCL(AddressData addressData, int n) {
        CommandList commandList = this.this$0.commandListFactory.createCommandList();
        if (this.addressExistsFor(addressData)) {
            this.logger.log(-2137614336, "Location existed");
            commandList.add(new StreamToLocationCommand(addressData.navLocation));
            commandList.add(this.addressExistingCreateAddRowCmd(n));
        } else {
            this.logger.log(-2137614336, "Location did not exist");
            commandList.add(this.noAddressCreateAddRowCmd(n));
        }
        return commandList;
    }

    public boolean addressExistsFor(AddressData addressData) {
        return addressData != null && addressData.navLocation != null && addressData.navLocation.length != 0;
    }

    private NavCommand addressExistingCreateAddRowCmd(int n) {
        return this.createAddRowCommand(n, true);
    }

    private NavCommand noAddressCreateAddRowCmd(int n) {
        return this.createAddRowCommand(n, false);
    }

    private NavCommand createAddRowCommand(int n, boolean bl) {
        return new AdbContactsGuiSearchHandler$2$1(this, new StringBuffer().append("Add address ").append(n).toString(), bl, n);
    }

    static /* synthetic */ AdbContactsGuiSearchHandler access$200(AdbContactsGuiSearchHandler$2 adbContactsGuiSearchHandler$2) {
        return adbContactsGuiSearchHandler$2.this$0;
    }
}

