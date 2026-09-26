/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandResponseSupplier;
import org.dsi.ifc.base.DSIListener;

class TelDSIMobileEquipmentListener$10
implements ICommandResponseSupplier {
    private final /* synthetic */ TelDSIMobileEquipmentListener this$0;

    TelDSIMobileEquipmentListener$10(TelDSIMobileEquipmentListener telDSIMobileEquipmentListener) {
        this.this$0 = telDSIMobileEquipmentListener;
    }

    @Override
    public LogChannel getLogChannel() {
        return this.this$0.cmdListLogChannel;
    }

    @Override
    public String getHandlerName() {
        return "TelDSIMobileEquipmentListenerHangup";
    }

    @Override
    public DSIListener getDSIDefaultHandler() {
        return this.this$0.defaultListener;
    }

    @Override
    public CommandList getActiveCommandList() {
        return TelDSIMobileEquipmentListener.access$000(this.this$0).getActiveCommandList();
    }
}

