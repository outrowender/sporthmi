/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.obex.core;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIObexAuthentication;

public class NullDSIObexAuthentication
extends NullService
implements DSIObexAuthentication {
    public NullDSIObexAuthentication(LogChannel logChannel) {
        super(logChannel, "DSIObexAuthentication");
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    public void setNotification(DSIListener dSIListener) {
        this.log();
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    public void clearNotification(DSIListener dSIListener) {
        this.log();
    }

    public void setAuthenticationInfo(int n, String string, String string2) {
        this.log();
    }
}

