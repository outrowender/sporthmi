/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util.osgi;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;

public class NullDSIBase
extends NullService
implements DSIBase {
    protected NullDSIBase(LogChannel logChannel, String string) {
        super(logChannel, string);
    }

    protected NullDSIBase(LogChannel logChannel, int n, String string) {
        super(logChannel, n, string);
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log("setNotification");
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.log("setNotification");
    }

    public void setNotification(DSIListener dSIListener) {
        this.log("setNotification");
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log("clearNotification");
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.log("clearNotification");
    }

    public void clearNotification(DSIListener dSIListener) {
        this.log("clearNotification");
    }
}

