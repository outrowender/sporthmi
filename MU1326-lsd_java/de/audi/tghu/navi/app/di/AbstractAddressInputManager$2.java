/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.AbstractAddressInputManager;

class AbstractAddressInputManager$2
extends NavCommand {
    private final /* synthetic */ AbstractAddressInputManager this$0;

    AbstractAddressInputManager$2(AbstractAddressInputManager abstractAddressInputManager, String string) {
        this.this$0 = abstractAddressInputManager;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.localPersistNavLocationHelper.savePersistentState((byte[])this.getCommandList().get("LOCATION_STREAM"));
        this.getCommandList().commandFinished();
    }
}

