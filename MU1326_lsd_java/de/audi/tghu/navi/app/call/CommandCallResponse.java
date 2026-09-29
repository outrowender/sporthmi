/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.call;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.audi.tghu.navi.app.call.CommandListCallManager;
import de.audi.tghu.navi.app.call.INavCall;

public abstract class CommandCallResponse
extends CommandResponse {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void executeCall(ICommandResponseSupplier iCommandResponseSupplier, CommandListCallManager commandListCallManager, CommandResponse commandResponse) {
        boolean bl = false;
        CommandListCallManager commandListCallManager2 = commandListCallManager;
        synchronized (commandListCallManager2) {
            INavCall iNavCall = commandListCallManager.getCall();
            if (iNavCall != null) {
                iNavCall.setHandled(false);
                commandResponse.call(iNavCall);
                bl = iNavCall.didHandle();
            }
        }
        if (!bl) {
            CommandCallResponse.execute(iCommandResponseSupplier, commandResponse);
        }
    }
}

