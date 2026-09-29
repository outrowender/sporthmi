/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.AbstractAddressInputManager;
import de.audi.tghu.navi.app.li.sc.SpellerContextManager;

class AbstractAddressInputManager$4
extends NavCommand {
    private final /* synthetic */ AbstractAddressInputManager this$0;

    AbstractAddressInputManager$4(AbstractAddressInputManager abstractAddressInputManager, String string) {
        this.this$0 = abstractAddressInputManager;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.spellerStack.reset();
        SpellerContextManager.reset();
        this.getCommandList().commandFinished();
    }
}

