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

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600812, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600813, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600814, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600815, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600817, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600818, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600819, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600820, (short)46);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600812);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600813);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600814);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600815);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600817);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600818);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600819);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600820);
    }

    protected void updateMenuEntryVisibility(AuxHeaterCoolerViewOptions auxHeaterCoolerViewOptions) {
        if (auxHeaterCoolerViewOptions.auxHeaterCoolerExtendedConditioning != null) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600812, this.getMenuEntryVisibilityState(auxHeaterCoolerViewOptions.auxHeaterCoolerExtendedConditioning));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600814, this.getMenuEntryVisibilityState(auxHeaterCoolerViewOptions.auxHeaterCoolerWindowHeating));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600815, this.getMenuEntryVisibilityState(auxHeaterCoolerViewOptions.auxHeaterCoolerUnlockClimating));
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
            iMenuEntryRegistry.updateMenuEntryVisibility(600817, auxHeaterCoolerExtendedConditioning.isZ1rl() ? 0 : 1);
            iMenuEntryRegistry.updateMenuEntryVisibility(600818, auxHeaterCoolerExtendedConditioning.isZ1rr() ? 0 : 1);
            iMenuEntryRegistry.updateMenuEntryVisibility(600819, auxHeaterCoolerExtendedConditioning.isZ2rl() ? 0 : 1);
            iMenuEntryRegistry.updateMenuEntryVisibility(600820, auxHeaterCoolerExtendedConditioning.isZ2rr() ? 0 : 1);
        } else if (auxHeaterCoolerExtendedConditioning != null && carViewOption.getState() == 1) {
            iMenuEntryRegistry.updateMenuEntryVisibility(600817, auxHeaterCoolerExtendedConditioning.isZ1rl() ? this.getMenuEntryVisibilityState(carViewOption) : 1);
            iMenuEntryRegistry.updateMenuEntryVisibility(600818, auxHeaterCoolerExtendedConditioning.isZ1rr() ? this.getMenuEntryVisibilityState(carViewOption) : 1);
            iMenuEntryRegistry.updateMenuEntryVisibility(600819, auxHeaterCoolerExtendedConditioning.isZ2rl() ? this.getMenuEntryVisibilityState(carViewOption) : 1);
            iMenuEntryRegistry.updateMenuEntryVisibility(600820, auxHeaterCoolerExtendedConditioning.isZ2rr() ? this.getMenuEntryVisibilityState(carViewOption) : 1);
        } else {
            iMenuEntryRegistry.updateMenuEntryVisibility(600817, 1);
            iMenuEntryRegistry.updateMenuEntryVisibility(600818, 1);
            iMenuEntryRegistry.updateMenuEntryVisibility(600819, 1);
            iMenuEntryRegistry.updateMenuEntryVisibility(600820, 1);
        }
    }

    private void removeExtendetOptionsMenuEntry() {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600812, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600814, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600815, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600817, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600818, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600819, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600820, 1);
    }

    public int getID() {
        return 56;
    }
}

