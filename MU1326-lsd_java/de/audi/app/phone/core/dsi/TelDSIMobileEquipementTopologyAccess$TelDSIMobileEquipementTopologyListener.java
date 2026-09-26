/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.TelDSIMobileEquipementTopologyAccess;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener$1;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener$2;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener$3;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentTopologyListener;

class TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener
implements DSIMobileEquipmentTopologyListener,
ICommandResponseSupplier {
    private final /* synthetic */ TelDSIMobileEquipementTopologyAccess this$0;

    TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess) {
        this.this$0 = telDSIMobileEquipementTopologyAccess;
    }

    @Override
    public DSIListener getDSIDefaultHandler() {
        return TelDSIMobileEquipementTopologyAccess.access$100(this.this$0);
    }

    @Override
    public CommandList getActiveCommandList() {
        return TelDSIMobileEquipementTopologyAccess.access$200(this.this$0).getActiveCommandList();
    }

    @Override
    public LogChannel getLogChannel() {
        return TelDSIMobileEquipementTopologyAccess.access$300(this.this$0).getLogChannel("App.Phone.DSI.CL");
    }

    @Override
    public String getHandlerName() {
        return "TelDSIMobileEquipementTopologyListener";
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        Buffer buffer = new Buffer();
        buffer.append("errorCode=");
        buffer.append(n);
        buffer.append(", ");
        TelDSIMobileEquipementTopologyAccess.access$400(this.this$0).log(-1601830656, "[TelDSIMobileEquipementTopologyListener#asyncException] %1", (Object)buffer);
    }

    @Override
    public void updateUsage(int[] nArray, int n) {
        if (n == 1) {
            TelDSIMobileEquipementTopologyAccess.access$1100(this.this$0).enqueueEvent(new TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener$1(this, "DSIMobileEquipementTopologyListener#updateUsage", nArray));
        }
    }

    @Override
    public void updateTopology(int[] nArray, int n) {
        if (n == 1) {
            TelDSIMobileEquipementTopologyAccess.access$1900(this.this$0).enqueueEvent(new TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener$2(this, "DSIMobileEquipementTopologyListener#updateTopology", nArray));
        }
    }

    @Override
    public void responseChangeTopology(int n) {
        CommandResponse.execute(this, new TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener$3(this, n));
    }

    static /* synthetic */ TelDSIMobileEquipementTopologyAccess access$500(TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener telDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener) {
        return telDSIMobileEquipementTopologyAccess$TelDSIMobileEquipementTopologyListener.this$0;
    }
}

