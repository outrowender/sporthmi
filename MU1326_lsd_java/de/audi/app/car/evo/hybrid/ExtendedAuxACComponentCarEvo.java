/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.hybrid;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.mer.IMenuEntryRegistry;
import de.audi.app.car.core.hybrid.AbstractExtendetAuxACComponent;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerConfiguration;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class ExtendedAuxACComponentCarEvo
extends AbstractExtendetAuxACComponent {
    final short CODING_ID = (short)46;

    public ExtendedAuxACComponentCarEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-332789504, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-316012288, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-299235072, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-282457856, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-248903424, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-232126208, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-215348992, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-198571776, (short)46);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-332789504);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-316012288);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-299235072);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-282457856);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-248903424);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-232126208);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-215348992);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-198571776);
    }

    @Override
    protected void updateMenuEntryVisibility(AuxHeaterCoolerViewOptions auxHeaterCoolerViewOptions) {
        if (auxHeaterCoolerViewOptions.auxHeaterCoolerExtendedConditioning != null) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-332789504, this.getMenuEntryVisibilityState(auxHeaterCoolerViewOptions.auxHeaterCoolerExtendedConditioning));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-299235072, this.getMenuEntryVisibilityState(auxHeaterCoolerViewOptions.auxHeaterCoolerWindowHeating));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-282457856, this.getMenuEntryVisibilityState(auxHeaterCoolerViewOptions.auxHeaterCoolerUnlockClimating));
            this.configureAuxHeaterCoolerClimatingZonesVisibility(auxHeaterCoolerViewOptions);
        } else {
            this.removeExtendetOptionsMenuEntry();
        }
    }

    private void configureAuxHeaterCoolerClimatingZonesVisibility(AuxHeaterCoolerViewOptions auxHeaterCoolerViewOptions) {
        CarViewOption carViewOption = auxHeaterCoolerViewOptions.getAuxHeaterCoolerExtendedConditioning();
        IMenuEntryRegistry iMenuEntryRegistry = this.getApplication().getMenuEntryRegistry();
        AuxHeaterCoolerConfiguration auxHeaterCoolerConfiguration = auxHeaterCoolerViewOptions.getConfiguration();
        AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning = null;
        if (auxHeaterCoolerConfiguration != null) {
            auxHeaterCoolerExtendedConditioning = auxHeaterCoolerConfiguration.getExtendedConditioning();
        }
        if (auxHeaterCoolerExtendedConditioning != null && carViewOption.getState() == 2) {
            iMenuEntryRegistry.updateMenuEntryVisibility(-248903424, auxHeaterCoolerExtendedConditioning.isZ1rl() ? 0 : 1);
            iMenuEntryRegistry.updateMenuEntryVisibility(-232126208, auxHeaterCoolerExtendedConditioning.isZ1rr() ? 0 : 1);
            iMenuEntryRegistry.updateMenuEntryVisibility(-215348992, auxHeaterCoolerExtendedConditioning.isZ2rl() ? 0 : 1);
            iMenuEntryRegistry.updateMenuEntryVisibility(-198571776, auxHeaterCoolerExtendedConditioning.isZ2rr() ? 0 : 1);
        } else if (auxHeaterCoolerExtendedConditioning != null && carViewOption.getState() == 1) {
            iMenuEntryRegistry.updateMenuEntryVisibility(-248903424, auxHeaterCoolerExtendedConditioning.isZ1rl() ? this.getMenuEntryVisibilityState(carViewOption) : 1);
            iMenuEntryRegistry.updateMenuEntryVisibility(-232126208, auxHeaterCoolerExtendedConditioning.isZ1rr() ? this.getMenuEntryVisibilityState(carViewOption) : 1);
            iMenuEntryRegistry.updateMenuEntryVisibility(-215348992, auxHeaterCoolerExtendedConditioning.isZ2rl() ? this.getMenuEntryVisibilityState(carViewOption) : 1);
            iMenuEntryRegistry.updateMenuEntryVisibility(-198571776, auxHeaterCoolerExtendedConditioning.isZ2rr() ? this.getMenuEntryVisibilityState(carViewOption) : 1);
        } else {
            iMenuEntryRegistry.updateMenuEntryVisibility(-248903424, 1);
            iMenuEntryRegistry.updateMenuEntryVisibility(-232126208, 1);
            iMenuEntryRegistry.updateMenuEntryVisibility(-215348992, 1);
            iMenuEntryRegistry.updateMenuEntryVisibility(-198571776, 1);
        }
    }

    private void removeExtendetOptionsMenuEntry() {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-332789504, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-299235072, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-282457856, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-248903424, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-232126208, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-215348992, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-198571776, 1);
    }

    @Override
    public int getID() {
        return 56;
    }
}

