/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.util;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;

public class NullDSIService
extends NullService
implements DSIBase {
    protected NullDSIService(LogChannel logChannel, String string) {
        super(logChannel, string);
    }

    protected NullDSIService(LogChannel logChannel, int n, String string) {
        super(logChannel, n, string);
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.log();
    }
}

