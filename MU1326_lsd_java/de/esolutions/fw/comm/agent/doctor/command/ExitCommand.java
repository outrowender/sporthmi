/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.doctor.command;

import de.esolutions.fw.comm.agent.doctor.DoctorShell;
import de.esolutions.fw.comm.agent.doctor.command.AbstractDoctorCommand;
import java.io.PrintStream;

public class ExitCommand
extends AbstractDoctorCommand {
    public String[] getNames() {
        return new String[]{"quit", "exit"};
    }

    public String getDescription() {
        return "exit doctor shell";
    }

    public boolean handle(DoctorShell doctorShell, String[] stringArray, PrintStream printStream) {
        return true;
    }

    public boolean checkArgs(String[] stringArray) {
        return stringArray.length == 0;
    }
}

