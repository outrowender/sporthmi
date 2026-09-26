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

    @Override
    public int getID() {
        return 20;
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1109920000, (short)11);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1109920000, 1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1026033920, (short)11);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1042811136, (short)11);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1093142784, (short)11);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1109920000);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1026033920);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1042811136);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1093142784);
    }

    @Override
    protected void updateMenuEntryVisibility(RDKViewOptions rDKViewOptions) {
        boolean bl;
        boolean bl2 = bl = rDKViewOptions.getConfiguration().getSystem() != 0;
        if (bl) {
            this.getLogChannel().log(1078071040, "[RDKComponentEvo#updateMenuEntryVisibility] HIGH variant of RDK detected");
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1026033920, this.getMenuEntryVisibilityState(rDKViewOptions.getTireDisplay()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1042811136, this.getMenuEntryVisibilityState(rDKViewOptions.getPressureChanged()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1093142784, this.getMenuEntryVisibilityState(rDKViewOptions.getTireChanged()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1109920000, 1);
        } else {
            this.getLogChannel().log(1078071040, "[RDKComponentEvo#updateMenuEntryVisibility] LOW variant of RDK detected");
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1026033920, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1042811136, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1093142784, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1109920000, this.getMenuEntryVisibilityState(rDKViewOptions.getPressureChanged()));
        }
    }

    @Override
    protected synchronized IRDKTireDisplay getRDKTireDisplayInstance() {
        if (this.rdkTireDisplay == null) {
            return new RDKTireDisplay(this.getLogChannel(), this.getApplication().getFrameworkAccess());
        }
        return this.rdkTireDisplay;
    }

    @Override
    protected IValueConverterStrategy getRdkSpeedLimitConverterStrategy() {
        throw new ValueConverterStrategyException(2);
    }

    @Override
    protected IValueConverterStrategy getRdkPressureLevelConverterStrategy() {
        throw new ValueConverterStrategyException(2);
    }
}

