/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.a2dp;

import de.audi.app.bluetooth.core.AbstractBluetoothCommand;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.bluetooth.DSIBluetooth;

final class CommandSetA2DPUserSetting
extends AbstractBluetoothCommand {
    private final boolean active;
    static /* synthetic */ Class class$de$audi$app$bluetooth$core$a2dp$CommandSetA2DPUserSetting;

    static void schedule(IBluetoothApplication iBluetoothApplication, DSIBluetooth dSIBluetooth, boolean bl) {
        CommandSetA2DPUserSetting commandSetA2DPUserSetting = new CommandSetA2DPUserSetting(iBluetoothApplication.getLogChannel(), dSIBluetooth, bl);
        AbstractBluetoothCommand.schedule(iBluetoothApplication.getCommandListManager(), commandSetA2DPUserSetting);
    }

    private CommandSetA2DPUserSetting(LogChannel logChannel, DSIBluetooth dSIBluetooth, boolean bl) {
        super(logChannel, dSIBluetooth, (class$de$audi$app$bluetooth$core$a2dp$CommandSetA2DPUserSetting == null ? (class$de$audi$app$bluetooth$core$a2dp$CommandSetA2DPUserSetting = CommandSetA2DPUserSetting.class$("de.audi.app.bluetooth.core.a2dp.CommandSetA2DPUserSetting")) : class$de$audi$app$bluetooth$core$a2dp$CommandSetA2DPUserSetting).getName());
        this.active = bl;
    }

    @Override
    public void execute() {
        this.dsiBluetooth.requestSetA2DPUserSetting(this.active);
    }

    @Override
    public void responseSetA2DPUserSetting(int n) {
        this.logger.log(-2137614336, "CommandSetA2DPUserSetting#responseSetA2DPUserSetting(): result=%1", (long)n);
        this.commandList.commandFinished();
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

