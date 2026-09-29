/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;

public class ResetSpellerStackCommand
extends NavCommand {
    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute - resetting speller stack", (Object)this.CLASS_NAME);
        SpellerStack.getInstance().reset();
        this.getCommandList().commandFinished();
    }
}

