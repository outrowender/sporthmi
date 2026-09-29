/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToPOIOnlineSearchSequence$1;

public class ReturnNavLocationToPOIOnlineSearchSequence {
    private final ICommandListFactory commandListFactory;

    public ReturnNavLocationToPOIOnlineSearchSequence(ICommandListFactory iCommandListFactory) {
        this.commandListFactory = iCommandListFactory;
    }

    public void start() {
        CommandList commandList = this.getStartCommandList();
        commandList.execute("ReturnNavLocationToNaviOnlineSequence#start");
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new ReturnNavLocationToPOIOnlineSearchSequence$1(this));
        return commandList;
    }
}

