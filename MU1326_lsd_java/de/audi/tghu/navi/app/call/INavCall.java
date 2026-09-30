/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.call;

import de.audi.tghu.command.ICommand;
import de.audi.tghu.navi.app.call.CommandListCallManager;

public interface INavCall
extends ICommand {
    public boolean didHandle();

    public void setHandled(boolean var1);

    public void execute(String var1);

    public void setManager(CommandListCallManager var1);
}

