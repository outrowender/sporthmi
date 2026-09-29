/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rse;

import de.audi.atip.rse.AbstractRSECommand;

public abstract class RSENaviCommand
extends AbstractRSECommand {
    private static final short RSE_MODULE_NAVI;
    public static final short NAVI_TRANSFER_LOCATION;
    public static final short NAVI_SYNC_CRITERIA;

    protected RSENaviCommand(int n) {
        super(n);
    }
}

