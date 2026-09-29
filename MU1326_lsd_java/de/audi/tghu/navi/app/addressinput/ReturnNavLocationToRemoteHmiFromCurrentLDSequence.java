/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToRemoteHmiFromCurrentLDSequence$1;

public class ReturnNavLocationToRemoteHmiFromCurrentLDSequence {
    private final ICommandListFactory commandListFactory;

    public ReturnNavLocationToRemoteHmiFromCurrentLDSequence(ICommandListFactory iCommandListFactory) {
        this.commandListFactory = iCommandListFactory;
    }

    public void start() {
        CommandList commandList = this.getStartCommandList();
        commandList.execute("ReturnNavLocationToRemoteHmiFromCurrentLDSequence#start");
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new ReturnNavLocationToRemoteHmiFromCurrentLDSequence$1(this));
        return commandList;
    }
}

