/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.logging;

import de.audi.app.terminalmode.logging.Arrays2;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;

public class DSIBaseLoggingDecorator
implements DSIBase {
    protected final String logClass;
    protected final LogChannel lc;
    protected final int level;
    private final DSIBase wrappee;

    public DSIBaseLoggingDecorator(DSIBase dSIBase, LogChannel logChannel, int n, String string) {
        this.wrappee = dSIBase;
        this.lc = logChannel;
        this.level = n;
        this.logClass = string;
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.lc.log(this.level, "-> [%1.setNotification] attributes %2, listener %3", (Object)this.logClass, (Object)Arrays2.toString(nArray), (Object)dSIListener);
        this.wrappee.setNotification(nArray, dSIListener);
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.lc.log(this.level, "-> [%1.setNotification] attribute %2, listener %3", (Object)this.logClass, (Object)Integer.toString(n), (Object)dSIListener);
        this.wrappee.setNotification(n, dSIListener);
    }

    public void setNotification(DSIListener dSIListener) {
        this.lc.log(this.level, "-> [%1.setNotification] %2", (Object)this.logClass, (Object)dSIListener);
        this.wrappee.setNotification(dSIListener);
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.lc.log(this.level, "-> [%1.clearNotification] attributes %2, listener %3", (Object)this.logClass, (Object)Arrays2.toString(nArray), (Object)dSIListener);
        this.wrappee.clearNotification(nArray, dSIListener);
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.lc.log(this.level, "-> [%1.clearNotification] attribute %2, listener %3", (Object)this.logClass, (Object)Integer.toString(n), (Object)dSIListener);
        this.wrappee.clearNotification(n, dSIListener);
    }

    public void clearNotification(DSIListener dSIListener) {
        this.lc.log(this.level, "-> [%1.clearNotification] %2", (Object)this.logClass, (Object)dSIListener);
        this.wrappee.clearNotification(dSIListener);
    }
}

