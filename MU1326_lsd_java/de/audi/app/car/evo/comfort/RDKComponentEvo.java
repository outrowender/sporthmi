/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.comfort;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.exception.ValueConverterStrategyException;
import de.audi.app.car.common.util.IValueConverterStrategy;
import de.audi.app.car.core.comfort.AbstractRDKComponent;
import de.audi.app.car.core.comfort.IRDKTireDisplay;
import de.audi.app.car.core.comfort.RDKTireDisplay;
import org.dsi.ifc.carcomfort.RDKViewOptions;

public class RDKComponentEvo
extends AbstractRDKComponent {
    public RDKComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    public int getID() {
        return 20;
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600130, (short)11);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600130, 1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600125, (short)11);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600126, (short)11);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600129, (short)11);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600130);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600125);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600126);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600129);
    }

    protected void updateMenuEntryVisibility(RDKViewOptions rDKViewOptions) {
        boolean bl;
        boolean bl2 = bl = rDKViewOptions.getConfiguration().getSystem() != 0;
        if (bl) {
            this.getLogChannel().log(1000000, "[RDKComponentEvo#updateMenuEntryVisibility] HIGH variant of RDK detected");
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600125, this.getMenuEntryVisibilityState(rDKViewOptions.getTireDisplay()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600126, this.getMenuEntryVisibilityState(rDKViewOptions.getPressureChanged()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600129, this.getMenuEntryVisibilityState(rDKViewOptions.getTireChanged()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600130, 1);
        } else {
            this.getLogChannel().log(1000000, "[RDKComponentEvo#updateMenuEntryVisibility] LOW variant of RDK detected");
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600125, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600126, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600129, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600130, this.getMenuEntryVisibilityState(rDKViewOptions.getPressureChanged()));
        }
    }

    protected synchronized IRDKTireDisplay getRDKTireDisplayInstance() {
        if (this.rdkTireDisplay == null) {
            return new RDKTireDisplay(this.getLogChannel(), this.getApplication().getFrameworkAccess());
        }
        return this.rdkTireDisplay;
    }

    protected IValueConverterStrategy getRdkSpeedLimitConverterStrategy() throws ValueConverterStrategyException {
        throw new ValueConverterStrategyException(2);
    }

    protected IValueConverterStrategy getRdkPressureLevelConverterStrategy() throws ValueConverterStrategyException {
        throw new ValueConverterStrategyException(2);
    }
}

