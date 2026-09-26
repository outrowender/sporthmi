/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.guidance;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.block.PersistBlockCommand;
import de.audi.tghu.navi.app.command.block.SetBlockDescriptionCommand;
import de.audi.tghu.navi.app.guidance.SimpleDetourHandler;
import de.audi.tghu.navi.app.util.Util;

class SimpleDetourHandler$1
extends NavCommand {
    private final /* synthetic */ SimpleDetourHandler this$0;

    SimpleDetourHandler$1(SimpleDetourHandler simpleDetourHandler, String string) {
        this.this$0 = simpleDetourHandler;
        super(string);
    }

    @Override
    public void execute() {
        Object object = this.getCommandList().get("BLOCK_UID");
        if (object == null) {
            this.getCommandList().commandAborted("No UID put into CommandList, abort!!!");
            return;
        }
        long l = (Long)object;
        CommandList commandList = SimpleDetourHandler.access$000(this.this$0).createCommandList();
        if (!Util.isEmpty("@@TRAFFIC_AHEAD@@")) {
            commandList.add(new SetBlockDescriptionCommand(new long[]{l}, "@@TRAFFIC_AHEAD@@"));
        }
        commandList.add(new PersistBlockCommand(new long[]{l}));
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

