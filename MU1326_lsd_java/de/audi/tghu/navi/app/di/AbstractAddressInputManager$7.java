/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.StreamToLocationCommand;
import de.audi.tghu.navi.app.di.AbstractAddressInputManager;

class AbstractAddressInputManager$7
extends NavCommand {
    private final /* synthetic */ AbstractAddressInputManager this$0;

    AbstractAddressInputManager$7(AbstractAddressInputManager abstractAddressInputManager, String string) {
        this.this$0 = abstractAddressInputManager;
        super(string);
    }

    @Override
    public void execute() {
        byte[] byArray = this.this$0.localPersistNavLocationHelper.loadPersistentState();
        this.getCommandList().commandFinishedWithPostCommand(new StreamToLocationCommand(byArray));
    }
}

