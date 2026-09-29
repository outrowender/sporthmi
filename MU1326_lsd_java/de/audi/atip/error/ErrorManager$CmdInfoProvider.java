/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.error;

import de.audi.atip.error.ErrorManager$1;
import de.audi.atip.util.CommandLineExecuter;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;

class ErrorManager$CmdInfoProvider
implements DumpInfoProvider {
    private String name;
    private String cmd;
    private PrintStream[] additionalSinks;
    private String[] args;

    private ErrorManager$CmdInfoProvider(String string, String string2, String[] stringArray, PrintStream[] printStreamArray) {
        this.name = string;
        this.cmd = string2;
        this.args = stringArray;
        this.additionalSinks = printStreamArray;
    }

    private ErrorManager$CmdInfoProvider(String string, String string2, String[] stringArray) {
        this(string, string2, stringArray, (PrintStream[])null);
    }

    @Override
    public void dump(PrintStream printStream, String string) {
        PrintStream[] printStreamArray;
        if (this.additionalSinks == null) {
            printStreamArray = new PrintStream[]{printStream};
        } else {
            printStreamArray = new PrintStream[this.additionalSinks.length + 1];
            System.arraycopy((Object)printStreamArray, 0, (Object)this.additionalSinks, 0, this.additionalSinks.length);
            printStreamArray[this.additionalSinks.length] = printStream;
        }
        CommandLineExecuter.executeCommand(this.cmd, this.args, printStreamArray);
    }

    @Override
    public String getName() {
        return this.name;
    }

    /* synthetic */ ErrorManager$CmdInfoProvider(String string, String string2, String[] stringArray, ErrorManager$1 errorManager$1) {
        this(string, string2, stringArray);
    }
}

