/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.adb;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.phone.core.adb.TelAddressbookHandlerImpl;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.PersonalData;
import org.dsi.ifc.organizer.PhoneData;

public class TelADBSetSpeedDialFavoriteCommand
extends AbstractADBCommand {
    private AdbEntry speedDialEntry;
    static /* synthetic */ Class class$de$audi$app$phone$core$adb$TelADBSetSpeedDialFavoriteCommand;

    private TelADBSetSpeedDialFavoriteCommand(ADBApplication aDBApplication, AdbEntry adbEntry) {
        super(aDBApplication);
        this.speedDialEntry = adbEntry;
    }

    public void execute() {
        this.logger.log(1000000, "TelADBSetSpeedDialFavoriteCommand#execute()");
        boolean bl = this.adbDSIAccess.setSpeedDial(this.speedDialEntry);
        if (!bl) {
            this.logger.log(10000, "TelADBSetSpeedDialFavoriteCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    public void setSpeedDialResult(int n) {
        this.logger.log(1000000, "TelADBSetSpeedDialFavoriteCommand#setSpeedDialResult(): success: %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        this.commandList.commandFinished();
    }

    public static void createTelADBSetSpeedDialFavoriteCommand(TelAddressbookHandlerImpl telAddressbookHandlerImpl, String string, int n, int n2, String string2, String string3, String string4, String string5, ResourceLocator resourceLocator) {
        AdbEntry adbEntry = new AdbEntry();
        adbEntry.phoneData = new PhoneData[]{new PhoneData(string, n, n2)};
        adbEntry.personalData = new PersonalData(string3, string5, string2, string4, null, null, null, resourceLocator);
        TelADBSetSpeedDialFavoriteCommand telADBSetSpeedDialFavoriteCommand = new TelADBSetSpeedDialFavoriteCommand(telAddressbookHandlerImpl, adbEntry);
        CommandList commandList = new CommandList(telAddressbookHandlerImpl.getCommandListManager());
        commandList.add(telADBSetSpeedDialFavoriteCommand);
        commandList.execute((class$de$audi$app$phone$core$adb$TelADBSetSpeedDialFavoriteCommand == null ? (class$de$audi$app$phone$core$adb$TelADBSetSpeedDialFavoriteCommand = TelADBSetSpeedDialFavoriteCommand.class$("de.audi.app.phone.core.adb.TelADBSetSpeedDialFavoriteCommand")) : class$de$audi$app$phone$core$adb$TelADBSetSpeedDialFavoriteCommand).getName());
    }

    public static void createTelADBSetSpeedDialFavoriteCommand(ADBApplication aDBApplication, AdbEntry adbEntry) {
        TelADBSetSpeedDialFavoriteCommand telADBSetSpeedDialFavoriteCommand = new TelADBSetSpeedDialFavoriteCommand(aDBApplication, adbEntry);
        CommandList commandList = new CommandList(aDBApplication.getCommandListManager());
        commandList.add(telADBSetSpeedDialFavoriteCommand);
        commandList.execute((class$de$audi$app$phone$core$adb$TelADBSetSpeedDialFavoriteCommand == null ? (class$de$audi$app$phone$core$adb$TelADBSetSpeedDialFavoriteCommand = TelADBSetSpeedDialFavoriteCommand.class$("de.audi.app.phone.core.adb.TelADBSetSpeedDialFavoriteCommand")) : class$de$audi$app$phone$core$adb$TelADBSetSpeedDialFavoriteCommand).getName());
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

