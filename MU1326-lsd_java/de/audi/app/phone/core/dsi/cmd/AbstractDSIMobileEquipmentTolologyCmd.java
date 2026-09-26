/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSICmd;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentTopology;

public abstract class AbstractDSIMobileEquipmentTolologyCmd
extends AbstractTelDSICmd {
    protected final DSIMobileEquipmentTopology dsi;

    public AbstractDSIMobileEquipmentTolologyCmd(LogChannel logChannel, String string, int n, DSIMobileEquipmentTopology dSIMobileEquipmentTopology, ITelDSIResponseListener iTelDSIResponseListener) {
        super(logChannel, string, n, iTelDSIResponseListener);
        this.dsi = dSIMobileEquipmentTopology;
    }
}

