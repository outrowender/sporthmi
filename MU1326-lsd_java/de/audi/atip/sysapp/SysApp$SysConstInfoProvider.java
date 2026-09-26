/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp;

import de.audi.atip.activator.FrameworkException;
import de.audi.atip.sysapp.SysApp;
import de.audi.atip.sysapp.SysApp$1;
import de.audi.atip.sysapp.carcoding.ISysConstManager;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;

class SysApp$SysConstInfoProvider
implements DumpInfoProvider {
    private final /* synthetic */ SysApp this$0;

    private SysApp$SysConstInfoProvider(SysApp sysApp) {
        this.this$0 = sysApp;
    }

    @Override
    public String getName() {
        return "SysConst";
    }

    @Override
    public void dump(PrintStream printStream, String string) {
        try {
            ISysConstManager iSysConstManager = this.this$0.getSysConstManager();
            printStream.println(iSysConstManager.dumpCarData());
            printStream.println("\n");
        }
        catch (FrameworkException frameworkException) {
            printStream.println("SysConstManager not available!\n");
        }
    }

    /* synthetic */ SysApp$SysConstInfoProvider(SysApp sysApp, SysApp$1 sysApp$1) {
        this(sysApp);
    }
}

