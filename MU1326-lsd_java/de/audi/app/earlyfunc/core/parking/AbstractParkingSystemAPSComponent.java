/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemComponent;
import de.audi.app.earlyfunc.core.parking.IParkingSystemController;
import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.PDCSound;
import org.dsi.ifc.carparkingsystem.PDCSoundReproduction;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;

public abstract class AbstractParkingSystemAPSComponent
extends AbstractParkingSystemComponent {
    public AbstractParkingSystemAPSComponent(ICarApplication iCarApplication, IParkingSystemController iParkingSystemController) {
        super(iCarApplication, iParkingSystemController, "App.EarlyFunc.Parking");
    }

    @Override
    public String getName() {
        return "Parking system APS";
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{3, 4, 27, 28, 29, 30, 5, 6, 55, 56, 57, 58, 7})};
    }

    @Override
    protected void initModels() {
    }

    @Override
    protected void deinitModels() {
    }

    @Override
    public void setActive(boolean bl, DisplayContent displayContent) {
        this.getLogChannel().log(-2137614336, "[AbstractParkingSystemAPSComponent#setActive] active=%1, displayContent=%2", bl, (Object)displayContent);
    }

    @Override
    public int[] getSupportedDSIPopupIDs() {
        return new int[0];
    }

    @Override
    public int getParkingSystemID() {
        return 1;
    }

    @Override
    public void updateParkingSystemViewOptions(ParkingSystemViewOptions parkingSystemViewOptions, int n) {
        super.updateParkingSystemViewOptions(parkingSystemViewOptions, n);
        if (n == 1 && parkingSystemViewOptions != null) {
            if (parkingSystemViewOptions.getPdcFrequencyFront().getState() != 0 || parkingSystemViewOptions.getPdcFrequencyRear().getState() != 0) {
                this.controller.registerParkingSystemComponent(this);
            } else {
                this.controller.unregisterParkingSystemComponent(this);
            }
            this.primaryAttributeFirstSetReceived();
        }
    }

    @Override
    public void updatePDCFrequenceFront(int n, int n2) {
        if (n2 == 1) {
            super.updatePDCFrequenceFront(n, n2);
        }
    }

    @Override
    public void updatePDCFrequenceRear(int n, int n2) {
        if (n2 == 1) {
            super.updatePDCFrequenceRear(n, n2);
        }
    }

    @Override
    public void updatePDCFrequenceRight(int n, int n2) {
        if (n2 == 1) {
            super.updatePDCFrequenceRight(n, n2);
        }
    }

    @Override
    public void updatePDCFrequenceLeft(int n, int n2) {
        if (n2 == 1) {
            super.updatePDCFrequenceLeft(n, n2);
        }
    }

    @Override
    public void updatePDCVolumeFront(int n, int n2) {
        if (n2 == 1) {
            super.updatePDCVolumeFront(n, n2);
        }
    }

    @Override
    public void updatePDCVolumeRear(int n, int n2) {
        if (n2 == 1) {
            super.updatePDCVolumeRear(n, n2);
        }
    }

    @Override
    public void updatePDCVolumeRight(int n, int n2) {
        if (n2 == 1) {
            super.updatePDCVolumeRight(n, n2);
        }
    }

    @Override
    public void updatePDCVolumeLeft(int n, int n2) {
        if (n2 == 1) {
            super.updatePDCVolumeLeft(n, n2);
        }
    }

    @Override
    public void updatePDCMute(boolean bl, int n) {
        if (n == 1) {
            super.updatePDCMute(bl, n);
        }
    }

    @Override
    public void updatePDCSoundReproduction(PDCSoundReproduction pDCSoundReproduction, int n) {
        if (n == 1) {
            super.updatePDCSoundReproduction(pDCSoundReproduction, n);
        }
    }

    @Override
    public void updatePDCSoundFront(PDCSound pDCSound, int n) {
        if (n == 1) {
            super.updatePDCSoundFront(pDCSound, n);
        }
    }

    @Override
    public void updatePDCSoundRear(PDCSound pDCSound, int n) {
        if (n == 1) {
            super.updatePDCSoundRear(pDCSound, n);
        }
    }

    @Override
    public void updatePDCSoundLeft(PDCSound pDCSound, int n) {
        if (n == 1) {
            super.updatePDCSoundLeft(pDCSound, n);
        }
    }

    @Override
    public void updatePDCSoundRight(PDCSound pDCSound, int n) {
        if (n == 1) {
            super.updatePDCSoundRight(pDCSound, n);
        }
    }
}

