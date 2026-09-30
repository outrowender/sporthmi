/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBConfigUtils;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.list.SetListStyleCommand;
import de.audi.app.addressbook.core.main.commands.init.FinalizeConfigurationCommand;
import de.audi.app.addressbook.core.main.commands.init.SetAutoProfileAllocationCommand;
import de.audi.app.addressbook.core.main.commands.init.SetDefaultPublicProfileVisibilityCommand;
import de.audi.app.addressbook.core.main.commands.init.SetDefaultSortOrderCommand;
import de.audi.app.addressbook.core.main.commands.init.SetMaxLocalEntriesCommand;
import de.audi.app.addressbook.core.main.commands.init.SetMaxPhoneEntriesCommand;
import de.audi.app.addressbook.core.main.commands.init.SetMaxSpeedDialEntriesCommand;
import de.audi.app.addressbook.core.main.commands.init.SetSpeedDialTypeCommand;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class ADBStartupHandler {
    private LogChannel log;
    private ADBApplication appAdr;
    private int startupState = 0;
    private boolean startupComplete = false;

    public ADBStartupHandler(LogChannel logChannel, ADBApplication aDBApplication) {
        this.log = logChannel;
        this.appAdr = aDBApplication;
    }

    public synchronized void updateStartupState(int n) {
        if (this.startupComplete) {
            return;
        }
        this.startupState |= n;
        this.processStartupState(n);
        this.log.log(10000000, "ADBStartupHandler#updateStartupState(): stateUpdate: %1 has been processed --> %2", (Object)ADBDbgUtils.dbgStartupState(n), (Object)this);
        if (this.startupComplete) {
            this.log.log(1000000, "ADBStartupHandler#updateStartupState(): ********** ADB INSTANCE \"%1\" READY NOW **********", (Object)this.appAdr.getClass().getName());
        }
    }

    private void processStartupState(int n) {
        if (n == 16 && (this.startupState & 8) == 8 || n == 8 && (this.startupState & 0x10) == 16) {
            this.log.log(1000000, "ADBStartupHandler#processStartupState(): configuring auto profile allocation");
            SetAutoProfileAllocationCommand.createSetAutoProfileAllocationCommand(this.appAdr);
            boolean bl = ADBConfigUtils.getDefaultPublicVisibility(this.appAdr.getFramework());
            this.log.log(1000000, "ADBStartupHandler#processStartupState(): setting default public profile visibility to %1", bl);
            SetDefaultPublicProfileVisibilityCommand.createSetDefaultPublicProfileVisibilityCommand(this.appAdr, bl);
            int n2 = ADBConfigUtils.getSpeedDialType(this.appAdr.getFramework());
            this.log.log(1000000, "ADBStartupHandler#processStartupState(): setting speed dial type to %1", (long)n2);
            SetSpeedDialTypeCommand.createSetSpeedDialTypeCommand(this.appAdr, n2);
            int n3 = ADBConfigUtils.getMaxSpeedDialEntries(this.appAdr.getFramework());
            this.log.log(1000000, "ADBStartupHandler#processStartupState(): setting the max speed dial entries to %1", (long)n3);
            SetMaxSpeedDialEntriesCommand.createSetMaxSpeedDialEntriesCommand(this.appAdr, n3);
            int n4 = ADBConfigUtils.getDefaultSortOrder(this.appAdr.getFramework());
            this.log.log(1000000, "ADBStartupHandler#processStartupState(): configuring the default sort order for new address book profiles to: %1", (Object)ADBDbgUtils.dbgSortOrder(n4));
            SetDefaultSortOrderCommand.createSetDefaultSortOrderCommand(this.appAdr, n4);
            SetMaxPhoneEntriesCommand.createSetMaxPhoneEntriesCommand(this.appAdr, ADBConfigUtils.getMaxPhoneEntries(this.appAdr.getFramework()));
            SetMaxLocalEntriesCommand.createSetMaxLocalEntriesCommand(this.appAdr, ADBConfigUtils.getMaxPublicEntries(this.appAdr.getFramework()));
            this.log.log(1000000, "ADBStartupHandler#processStartupState(): scheduling FinalizeConfigurationCommand");
            FinalizeConfigurationCommand.createFinalizeConfigurationCommand(this.appAdr);
        }
        if ((this.startupState & this.appAdr.getInitStartupCompleteMask()) == this.appAdr.getInitStartupCompleteMask()) {
            SetListStyleCommand.createSetListStyleCommand(this.appAdr);
            this.startupComplete = true;
            this.appAdr.getAdbStateHandler().setAdbReady(true);
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(200);
        buffer.append("ADBStartupHandler: ");
        buffer.append("startupComplete=").append(this.startupComplete).append("; ");
        buffer.append(this.getInitStateStr("stateInit", 16)).append("; ");
        buffer.append(this.getInitStateStr("stateReady", 32)).append("; ");
        buffer.append(this.getInitStateStr("profileInfo", 4)).append("; ");
        buffer.append(this.getInitStateStr("initDSI", 8)).append("; ");
        buffer.append(this.getInitStateStr("listDSI", 1)).append("; ");
        buffer.append(this.getInitStateStr("editDSI", 64)).append("; ");
        buffer.append(this.getInitStateStr("setupDSI", 128)).append("; ");
        buffer.append(this.getInitStateStr("vExDSI", 256));
        return buffer.toString();
    }

    private String getInitStateStr(String string, int n) {
        Buffer buffer = new Buffer(20);
        boolean bl = (this.appAdr.getInitStartupCompleteMask() & n) != 0;
        buffer.append(bl ? (char)'+' : '-');
        buffer.append(string);
        buffer.append('=');
        buffer.append((this.startupState & n) != 0);
        return buffer.toString();
    }
}

