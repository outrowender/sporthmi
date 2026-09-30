/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.error;

import java.io.PrintStream;

public interface DumpInfoProvider {
    public String getName();

    public void dump(PrintStream var1, String var2);
}

