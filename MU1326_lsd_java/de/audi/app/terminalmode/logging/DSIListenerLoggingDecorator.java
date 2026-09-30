/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.logging;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;

public class DSIListenerLoggingDecorator
implements DSIListener {
    protected final String logClass;
    protected final LogChannel lc;
    protected final int level;
    private final DSIListener wrappee;

    public DSIListenerLoggingDecorator(DSIListener dSIListener, LogChannel logChannel, int n, String string) {
        this.wrappee = dSIListener;
        this.lc = logChannel;
        this.level = n;
        this.logClass = string;
    }

    public void asyncException(int n, String string, int n2) {
        this.lc.log(this.level, "<- [%1.asyncException] errorCode %2, errorMsg %3 requestType", (Object)this.logClass, (Object)new Integer(n), (Object)string, (Object)Integer.toString(n2));
        this.wrappee.asyncException(n, string, n2);
    }
}

