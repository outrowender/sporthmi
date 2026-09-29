/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.cmd;

import de.audi.tghu.command.CommandList;
import de.audi.tv.app.cmd.ITVCmdManager;

public class TVCommandList
extends CommandList {
    TVCommandList(ITVCmdManager iTVCmdManager, int n) {
        super(iTVCmdManager.getCommandListManager());
        Integer n2 = new Integer(n);
        this.put(n2, n2);
        this.put("CL_TYPE", n2);
    }
}

