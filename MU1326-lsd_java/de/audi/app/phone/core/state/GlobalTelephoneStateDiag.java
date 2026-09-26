/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.core.state;

import de.audi.app.phone.core.dsi.Topology;
import de.audi.app.phone.core.state.GlobalTelephoneState;
import de.audi.atip.log.NullLogChannel;
import de.esolutions.fw.util.commons.Buffer;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;

public class GlobalTelephoneStateDiag
implements IPhoneDiagComponent {
    final GlobalTelephoneState globalTelephoneState;

    public GlobalTelephoneStateDiag(GlobalTelephoneState globalTelephoneState) {
        this.globalTelephoneState = globalTelephoneState;
    }

    public String getGlobalTelephoneState() {
        return this.globalTelephoneState.toString();
    }

    public String getPrimaryDevice() {
        Buffer buffer = new Buffer();
        buffer.append("--------------- PRIMARY DEVICE ------------------------");
        buffer.append("\n");
        buffer.append(this.globalTelephoneState.getPrimaryDevice());
        buffer.append("\n");
        return buffer.toString();
    }

    public String getSecondaryDevice() {
        Buffer buffer = new Buffer();
        buffer.append("--------------- SECONDARY DEVICE ----------------------");
        buffer.append("\n");
        buffer.append(this.globalTelephoneState.getSecondaryDevice());
        buffer.append("\n");
        return buffer.toString();
    }

    public String getDataOnlyNadDevice() {
        Buffer buffer = new Buffer();
        buffer.append("------------- DATA_ONLY_NAD DEVICE ---------------------");
        buffer.append("\n");
        buffer.append(this.globalTelephoneState.getDataOnlyNadDevice());
        buffer.append("\n");
        return buffer.toString();
    }

    public void cmdUpdateTopologyInit() {
        this.globalTelephoneState.updateTopology(new Topology(NullLogChannel.getInstance(), true, new int[]{-2, -2, -2}));
    }
}

