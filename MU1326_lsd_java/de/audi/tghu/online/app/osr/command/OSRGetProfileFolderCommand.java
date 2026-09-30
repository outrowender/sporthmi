/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command;

import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public class OSRGetProfileFolderCommand
extends AbstractOSRCommand {
    private OSRUser user;
    private String domain;
    private ORSGetProfileFolderCommandListener listener;
    private boolean authenticated;

    public OSRGetProfileFolderCommand(OSRUser oSRUser, String string, boolean bl, ORSGetProfileFolderCommandListener oRSGetProfileFolderCommandListener) {
        this.user = oSRUser;
        this.domain = string;
        this.listener = oRSGetProfileFolderCommandListener;
        this.authenticated = bl;
    }

    public void execute() {
        this.logger.log(1000000, "ORSGetProfileFolderCommand#execute() ");
        this.getDSI().getProfileFolder(this.user, this.domain);
    }

    public void getProfileFolderResponse(int n, String string, OSRUser oSRUser, String string2) {
        this.logger.log(1000000, "ORSGetProfileFolderCommand#getProfileFolderResponse() %3 %1 path: %2", (Object)(oSRUser != null ? oSRUser.getName() : ""), (Object)string, (long)n);
        if (this.listener != null) {
            this.listener.getProfileFolderResponse(n, string, oSRUser, string2, this.authenticated);
        }
        this.getCommandList().commandFinished();
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }

    public static interface ORSGetProfileFolderCommandListener {
        public void getProfileFolderResponse(int var1, String var2, OSRUser var3, String var4, boolean var5);
    }
}

