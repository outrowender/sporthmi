/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di;

import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.AbstractAddressInputListener;

class AbstractAddressInputListener$1
extends NavCommand {
    private final /* synthetic */ HomeAddressHandler val$addressHandler;
    private final /* synthetic */ AbstractAddressInputListener this$0;

    AbstractAddressInputListener$1(AbstractAddressInputListener abstractAddressInputListener, HomeAddressHandler homeAddressHandler) {
        this.this$0 = abstractAddressInputListener;
        this.val$addressHandler = homeAddressHandler;
    }

    @Override
    public void execute() {
        this.val$addressHandler.onCreateEditHomeAddress(this.dsiResponseContainer.getLiCurrentLD());
        this.getCommandList().commandFinished();
    }
}

