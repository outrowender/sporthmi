/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.call;

import de.audi.tghu.command.ICommand;
import de.audi.tghu.navi.app.call.CommandListCallManager;

public interface INavCall
extends ICommand {
    default public boolean didHandle() {
    }

    default public void setHandled(boolean bl) {
    }

    default public void execute(String string) {
    }

    default public void setManager(CommandListCallManager commandListCallManager) {
    }
}

