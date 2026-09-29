/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.memory.DABMemoryRow;
import org.dsi.ifc.radio.ServiceInfo;

class MemoryListHandler$DABPresetNameUpdateTimer
extends DefaultTimerListener {
    volatile DabStation activeService = new DabStation();
    Timer timer;
    private final /* synthetic */ MemoryListHandler this$0;

    MemoryListHandler$DABPresetNameUpdateTimer(MemoryListHandler memoryListHandler, long l) {
        this.this$0 = memoryListHandler;
        this.timer = new Timer("DABPresetNameUpdateTimer", l, true, this);
    }

    void updatedMuteStatus(boolean bl) {
        if (bl) {
            this.timer.cancel();
        } else {
            this.timer.restart();
        }
    }

    void setActiveService(DabStation dabStation) {
        if (!dabStation.getShortName().equals(this.activeService.getShortName()) || !dabStation.getFullName().equals(this.activeService.getFullName())) {
            this.timer.restart();
            MemoryListHandler.access$1500((MemoryListHandler)this.this$0).main.log(1078071040, "[MLH.DABPresetNameUpdateTimer.setActiveService] %1", (Object)dabStation);
            this.activeService = new DabStation(Utilities.copy(dabStation.ensemble), Utilities.copy(dabStation.service), Utilities.copy(dabStation.component));
        }
    }

    @Override
    public void fireTimer(Timer timer) {
        int n = MemoryListHandler.access$1600(this.this$0, this.activeService.service.sID, this.activeService.service.ensID, -1);
        if (n == -1) {
            return;
        }
        DABMemoryRow dABMemoryRow = (DABMemoryRow)MemoryListHandler.access$1700(this.this$0).getRow(n);
        ServiceInfo serviceInfo = dABMemoryRow.getService();
        if (!serviceInfo.shortName.equals(this.activeService.service.shortName) || !serviceInfo.fullName.equals(this.activeService.service.fullName)) {
            MemoryListHandler.access$1500((MemoryListHandler)this.this$0).main.log(1078071040, "[MLH.DABPresetNameUpdateTimer.fireTimer] Name changed for %1", (Object)this.activeService);
            TunerObjectContainer tunerObjectContainer = new TunerObjectContainer(this.activeService);
            dABMemoryRow.performNameChange(tunerObjectContainer);
            MemoryListHandler.access$1700(this.this$0).setRow(n, dABMemoryRow);
            MemoryListHandler.access$1800(this.this$0);
        }
    }
}

