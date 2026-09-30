/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.app.terminalmode.dsi.AbstractResource;
import de.audi.app.terminalmode.dsi.IDSIResource;
import de.audi.app.terminalmode.dsi.carplay.CarplayUtils;
import org.dsi.ifc.carplay.Resource;

public class CarPlayResource
extends AbstractResource
implements IDSIResource {
    private final int activeApplications;

    public CarPlayResource(Resource resource) {
        super(CarPlayResource.mapResourceIdCarplay2HMI(resource.getResourceID()), CarPlayResource.mapResourceOwnerCarplay2HMI(resource.getOwner()));
        this.activeApplications = 0;
    }

    public CarPlayResource(int n, int n2, int n3) {
        super(n, n2);
        this.activeApplications = n3;
    }

    public int getDSIResourceId() {
        return CarPlayResource.mapResourceIdHMI2Carplay(this.getResourceId());
    }

    public int getDSIResourceOwner() {
        return CarPlayResource.mapResourceOwnerHMI2Carplay(this.getOwner());
    }

    public int getDSITransferPriority(boolean bl) {
        System.out.println("wieso nicht hier??? ");
        return CarplayUtils.getDsiTransferPriority(this.activeApplications, this.getResourceId() == 1, bl);
    }

    public int getDSITakeType(boolean bl) {
        System.out.println("hierhin gehst du ja auch!");
        return CarplayUtils.getDsiTransferType(this.activeApplications, this.getResourceId() == 1, bl);
    }

    public int getDSITakeConstraint(boolean bl) {
        return CarplayUtils.getDsiTakeConstraint(this.activeApplications, this.getResourceId() == 1, bl);
    }

    public int getDSIBorrowConstraint(boolean bl) {
        return CarplayUtils.getDsiBorrowConstraint(this.activeApplications, this.getResourceId() == 1, bl);
    }

    public int getDSIUnborrowConstraint(boolean bl) {
        return CarplayUtils.getDsiUnborrowConstraint(this.activeApplications, this.getResourceId() == 1, bl);
    }

    public static int mapResourceIdCarplay2HMI(int n) {
        switch (n) {
            case 1: {
                return 2;
            }
            case 2: {
                return 1;
            }
        }
        return 0;
    }

    public static int mapResourceOwnerCarplay2HMI(int n) {
        switch (n) {
            case 2: {
                return 2;
            }
            case 1: {
                return 1;
            }
        }
        return 0;
    }

    public static int mapResourceIdHMI2Carplay(int n) {
        switch (n) {
            case 3: {
                return 1;
            }
            case 1: {
                return 2;
            }
        }
        return 0;
    }

    public static int mapResourceOwnerHMI2Carplay(int n) {
        switch (n) {
            case 2: {
                return 2;
            }
            case 1: {
                return 1;
            }
        }
        return 0;
    }
}

