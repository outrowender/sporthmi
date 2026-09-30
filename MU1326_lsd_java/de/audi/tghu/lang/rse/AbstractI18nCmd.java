/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.lang.rse;

import de.audi.atip.base.FwServices;
import de.audi.atip.rse.AbstractRSECommand;

public abstract class AbstractI18nCmd
extends AbstractRSECommand {
    private static final short I18N_MODULE = 4608;
    public static final short SET_LANGUAGE_AT_RSE = 4609;
    public static final short QUERY_LANGUAGE_FROM_MU = 4610;
    private final FwServices fwServices;

    AbstractI18nCmd(FwServices fwServices, int n) {
        super(n);
        this.fwServices = fwServices;
    }

    protected FwServices getFwServices() {
        return this.fwServices;
    }
}

