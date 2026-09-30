/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.doctor.command;

import de.esolutions.fw.comm.agent.doctor.DoctorShell;
import java.io.PrintStream;

public interface IDoctorCommand {
    public String[] getNames();

    public String getDescription();

    public String getUsage();

    public String getSignature();

    public String getAllNames();

    public Boolean matchCommandName(String var1);

    public boolean handle(DoctorShell var1, String[] var2, PrintStream var3);

    public boolean checkArgs(String[] var1);
}

