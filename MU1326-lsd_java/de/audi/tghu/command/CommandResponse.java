/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.command;

import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandResponseSupplier;
import org.dsi.ifc.base.DSIListener;

public abstract class CommandResponse {
    public abstract void call(DSIListener dSIListener) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void execute(ICommandResponseSupplier iCommandResponseSupplier, CommandResponse commandResponse) {
        CommandList commandList = iCommandResponseSupplier.getActiveCommandList();
        DSIListener dSIListener = iCommandResponseSupplier.getDSIDefaultHandler();
        if (commandList != null) {
            CommandList commandList2 = commandList;
            synchronized (commandList2) {
                Command command = commandList.getActiveCommand();
                DSIListener dSIListener2 = command != null ? command : dSIListener;
                commandResponse.call(dSIListener2);
                super.notifyAll();
            }
        } else {
            commandResponse.call(dSIListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void executeTryCatch(ICommandResponseSupplier iCommandResponseSupplier, CommandResponse commandResponse, String string) {
        CommandList commandList = iCommandResponseSupplier.getActiveCommandList();
        DSIListener dSIListener = iCommandResponseSupplier.getDSIDefaultHandler();
        if (commandList != null) {
            CommandList commandList2 = commandList;
            synchronized (commandList2) {
                Command command = commandList.getActiveCommand();
                DSIListener dSIListener2 = command != null ? command : dSIListener;
                try {
                    commandResponse.call(dSIListener2);
                }
                catch (Exception exception) {
                    iCommandResponseSupplier.getLogChannel().log(10000, "%1#%2() - exception! See following lines.", (Object)iCommandResponseSupplier.getHandlerName(), (Object)string);
                    iCommandResponseSupplier.getLogChannel().log(10000, "Exception: ", (Throwable)exception);
                    commandList.commandAborted(exception);
                }
                finally {
                    super.notifyAll();
                }
            }
        }
        commandResponse.call(dSIListener);
    }
}

