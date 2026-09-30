/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.common.adapter.AbstractDSICarHybridAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.carhybrid.HybridViewOptions;

public abstract class AbstractHybridBaseComponent
extends AbstractDSICarHybridAdapter {
    public static final short CODING_ID = 24;
    private static final String LOGCHANNEL_NAME = "App.Car.Hybrid";
    private volatile HybridViewOptions hybridViewOptions;

    public AbstractHybridBaseComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    public HybridViewOptions getHybridViewOptions() {
        return this.hybridViewOptions;
    }

    public String getCurrentViewOptions() {
        Buffer buffer = new Buffer();
        buffer.append("Hybrid: ");
        buffer.append(this.hybridViewOptions != null ? this.hybridViewOptions.toString() : "No view options received yet!").append('\n');
        return buffer.toString();
    }

    public void updateHybridViewOptions(HybridViewOptions hybridViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractHybridBaseComponent(%1)#updateHybridViewOptions] viewOptions='%2', valid='%3'", (Object)this.getName(), (Object)(hybridViewOptions != null ? this.formatViewOptionsLog(hybridViewOptions.toString()) : "null"), (long)n);
        }
        if (1 == n && hybridViewOptions != null) {
            this.hybridViewOptions = hybridViewOptions;
            this.updateMenuEntryVisibility(this.hybridViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    protected abstract void updateMenuEntryVisibility(HybridViewOptions var1);
}

