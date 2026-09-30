/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSICmd;
import de.audi.atip.log.LogChannel;

public abstract class AbstractTelDSIMECommand
extends AbstractTelDSICmd {
    protected final ITelDSIMobileEquipmentRequestWrapper dsi;

    public AbstractTelDSIMECommand(ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, String string, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        super(logChannel, string, n, iTelDSIResponseListener);
        this.dsi = iTelDSIMobileEquipmentRequestWrapper;
    }

    protected boolean isDSIAvailable() {
        if (this.dsi == null) {
            this.logger.log(100000, "[AbstractTelDSIMECommand#isDSIAvailable] request wrapper is null!");
            return false;
        }
        boolean bl = this.dsi.isDSIAvailable();
        if (!bl) {
            this.logger.log(100000, "[AbstractTelDSIMECommand#isDSIAvailable] dsi not available!");
        }
        return bl;
    }
}

