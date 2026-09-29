/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.StreamToLocationCommand;

class HomeAddressHandler$1
extends NavCommand {
    private final /* synthetic */ HomeAddressHandler this$0;

    HomeAddressHandler$1(HomeAddressHandler homeAddressHandler, String string) {
        this.this$0 = homeAddressHandler;
        super(string);
    }

    @Override
    public void execute() {
        byte[] byArray = HomeAddressHandler.access$000(this.this$0).loadPersistentState();
        if (byArray == null || byArray.length == 0) {
            this.logger.log(-2137614336, "DeserializeHomeAddress#getPersistetHomeAddress() %1", (Object)byArray);
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandFinishedWithPostCommand(new StreamToLocationCommand(byArray));
        }
    }
}

