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
    private static final int VARIANT_INVALID;
    private static final int VARIANT_1_CHECKBOX_ONLY;
    private static final int VARIANT_2_NORMAL;
    private static final int VARIANT_3_HYBRID;

    public PEAComponentEvo(ICarApplication iCarApplication, boolean bl) {
        super(iCarApplication);
        this.hybridFunctionsAvailable = bl;
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(757729536, (short)55);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1373107968, (short)55);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1356330752, (short)55);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(774506752, (short)55);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(757729536, 1);
        if (this.hybridFunctionsAvailable) {
            this.getApplication().getMenuEntryRegistry().registerMenuEntry(451, (short)55);
            this.getApplication().getMenuEntryRegistry().registerMenuEntry(452, (short)55);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(452, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(451, 1);
            this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1456862976, (short)55);
            this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1440085760, (short)55);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1440085760, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1456862976, 1);
        }
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1373107968);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1356330752);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(774506752);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(757729536);
        if (this.hybridFunctionsAvailable) {
            this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(451);
            this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(452);
            this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1456862976);
            this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1440085760);
        }
    }

    @Override
    protected synchronized void updateMenuEntryVisibility() {
        this.updateVisibility();
    }

    @Override
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
        this.getLogChannel().log(1078071040, "[PEAComponentEvo#updateVisibility] determined variant is '%1', setting visibility accordingly", (long)n);
        switch (n) {
            case 1: {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(757729536, this.getMenuEntryVisibilityState(eAViewOptions.getSystem()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1373107968, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(774506752, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1356330752, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(451, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(452, 1);
                break;
            }
            case 2: {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(757729536, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1373107968, this.getMenuEntryVisibilityState(eAViewOptions.getSystem()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(774506752, this.getMenuEntryVisibilityState(eAViewOptions.freeWheeling));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1356330752, this.getMenuEntryVisibilityState(eAViewOptions.getPedalJerk()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(451, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(452, 1);
                break;
            }
            default: {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(757729536, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1373107968, this.getMenuEntryVisibilityState(eAViewOptions.getSystem()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(774506752, this.getMenuEntryVisibilityState(eAViewOptions.freeWheeling));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1356330752, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(451, this.getMenuEntryVisibilityState(eAViewOptions.getPedalJerk()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(452, this.hybridCombustorVisibility);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1456862976, this.getMenuEntryVisibilityState(eAViewOptions.getPedalJerk()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1440085760, this.hybridCombustorVisibility);
            }
        }
    }

    @Override
    public int getID() {
        return 39;
    }
}

