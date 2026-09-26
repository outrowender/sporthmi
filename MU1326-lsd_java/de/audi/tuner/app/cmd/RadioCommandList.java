/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd;

import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tuner.app.cmd.IRadioCmdManager;

public class RadioCommandList
extends CommandList {
    public RadioCommandList(IRadioCmdManager iRadioCmdManager, String string) {
        super(iRadioCmdManager.getCommandListManager());
        this.put(string, string);
        this.put("CL_TYPE", string);
    }

    public final void addBeforeFadeTo(Command command) {
        int n = this.size();
        if (n >= 2) {
            this.add(n - 2, command);
        }
    }

    public final void addAtFirstPos(Command command) {
        this.add(0, command);
    }

    public String getType() {
        return (String)this.get("CL_TYPE");
    }
}

