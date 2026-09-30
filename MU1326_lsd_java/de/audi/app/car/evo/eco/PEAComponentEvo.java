/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.eco;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.eco.AbstractPEAComponent;
import de.audi.app.car.evo.eco.PEAComponentHybridAccess;
import org.dsi.ifc.careco.EAViewOptions;

public class PEAComponentEvo
extends AbstractPEAComponent
implements PEAComponentHybridAccess {
    private final boolean hybridFunctionsAvailable;
    private volatile int hybridCombustorVisibility = 1;
    private static final int VARIANT_INVALID = 0;
    private static final int VARIANT_1_CHECKBOX_ONLY = 1;
    private static final int VARIANT_2_NORMAL = 2;
    private static final int VARIANT_3_HYBRID = 3;

    public PEAComponentEvo(ICarApplication iCarApplication, boolean bl) {
        super(iCarApplication);
        this.hybridFunctionsAvailable = bl;
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600621, (short)55);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600238, (short)55);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600239, (short)55);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600622, (short)55);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600621, 1);
        if (this.hybridFunctionsAvailable) {
            this.getApplication().getMenuEntryRegistry().registerMenuEntry(451, (short)55);
            this.getApplication().getMenuEntryRegistry().registerMenuEntry(452, (short)55);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(452, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(451, 1);
            this.getApplication().getMenuEntryRegistry().registerMenuEntry(600745, (short)55);
            this.getApplication().getMenuEntryRegistry().registerMenuEntry(600746, (short)55);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600746, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600745, 1);
        }
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600238);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600239);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600622);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600621);
        if (this.hybridFunctionsAvailable) {
            this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(451);
            this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(452);
            this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600745);
            this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600746);
        }
    }

    protected synchronized void updateMenuEntryVisibility() {
        this.updateVisibility();
    }

    public synchronized void updateHybridFunctionVisibility(int n) {
        this.hybridCombustorVisibility = n;
        this.updateVisibility();
    }

    private void updateVisibility() {
        EAViewOptions eAViewOptions = this.getCurrentViewOptionsObject();
        if (eAViewOptions == null) {
            return;
        }
        boolean bl = this.getMenuEntryVisibilityState(eAViewOptions.getSystem()) != 1;
        boolean bl2 = this.getMenuEntryVisibilityState(eAViewOptions.freeWheeling) != 1;
        boolean bl3 = this.getMenuEntryVisibilityState(eAViewOptions.pedalJerk) != 1;
        boolean bl4 = this.hybridCombustorVisibility != 1;
        int n = 0;
        n = bl && !bl2 && !bl3 && !bl4 ? 1 : (!bl4 ? 2 : 3);
        this.getLogChannel().log(1000000, "[PEAComponentEvo#updateVisibility] determined variant is '%1', setting visibility accordingly", (long)n);
        switch (n) {
            case 1: {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600621, this.getMenuEntryVisibilityState(eAViewOptions.getSystem()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600238, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600622, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600239, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(451, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(452, 1);
                break;
            }
            case 2: {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600621, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600238, this.getMenuEntryVisibilityState(eAViewOptions.getSystem()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600622, this.getMenuEntryVisibilityState(eAViewOptions.freeWheeling));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600239, this.getMenuEntryVisibilityState(eAViewOptions.getPedalJerk()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(451, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(452, 1);
                break;
            }
            default: {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600621, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600238, this.getMenuEntryVisibilityState(eAViewOptions.getSystem()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600622, this.getMenuEntryVisibilityState(eAViewOptions.freeWheeling));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600239, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(451, this.getMenuEntryVisibilityState(eAViewOptions.getPedalJerk()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(452, this.hybridCombustorVisibility);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600745, this.getMenuEntryVisibilityState(eAViewOptions.getPedalJerk()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600746, this.hybridCombustorVisibility);
            }
        }
    }

    public int getID() {
        return 39;
    }
}

