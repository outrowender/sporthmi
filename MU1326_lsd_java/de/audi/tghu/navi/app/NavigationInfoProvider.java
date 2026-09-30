/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.OperationManager;
import de.audi.tghu.navi.app.call.CommandListCallManager;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;

public class NavigationInfoProvider
implements DumpInfoProvider {
    private final OperationManager operationManager;
    private final CommandListCallManager commandListCallManager;

    public NavigationInfoProvider(OperationManager operationManager, CommandListCallManager commandListCallManager) {
        this.operationManager = operationManager;
        this.commandListCallManager = commandListCallManager;
    }

    public void dump(PrintStream printStream, String string) {
        String string2;
        try {
            printStream.println("Operation status:");
            string2 = this.operationManager.toString();
            printStream.println(string2);
        }
        catch (Exception exception) {
            exception.printStackTrace(printStream);
        }
        printStream.println();
        try {
            printStream.println("Queue status:");
            string2 = this.commandListCallManager.getQueue().printStatus();
            printStream.println(string2);
        }
        catch (Exception exception) {
            exception.printStackTrace(printStream);
        }
    }

    public String getName() {
        return "NavigationInfo";
    }
}

