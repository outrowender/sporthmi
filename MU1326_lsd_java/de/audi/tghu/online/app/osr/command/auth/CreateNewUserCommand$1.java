/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command.auth;

import de.audi.tghu.online.app.osr.command.auth.CreateNewUserCommand;
import de.audi.tghu.online.app.osr.command.auth.OSRDeleteUserCommand$IDeleteUserCommandResponseListener;
import org.dsi.ifc.online.OSRUser;

class CreateNewUserCommand$1
implements OSRDeleteUserCommand$IDeleteUserCommandResponseListener {
    private final /* synthetic */ CreateNewUserCommand this$0;

    CreateNewUserCommand$1(CreateNewUserCommand createNewUserCommand) {
        this.this$0 = createNewUserCommand;
    }

    @Override
    public void removeUserResponse(OSRUser oSRUser, int n) {
        CreateNewUserCommand.access$000(this.this$0).log(1078071040, "CreateNewUserCommand#cancelCommand() deleted user %1", (Object)oSRUser);
        this.this$0.getCommandList().commandFinished();
    }
}

