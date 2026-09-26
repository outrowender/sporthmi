/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.evo.parking;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.earlyfunc.core.parking.AbstractParkingFocusPropertyDecorator;
import de.audi.app.earlyfunc.core.parking.IParkingFocusPropertyConfig;
import de.audi.app.earlyfunc.core.parking.IParkingSystemController;
import de.audi.app.earlyfunc.core.parking.ParkingPopupIdentifier;
import de.audi.app.earlyfunc.core.parking.vps.AbstractParkingSystemVPSComponent;
import de.audi.app.earlyfunc.evo.parking.ParkingSystemVPSComponentEvo$1;
import de.audi.atip.hmi.MMIKombiPopupIDMapper;
import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;

public class ParkingSystemVPSComponentEvo
extends AbstractParkingSystemVPSComponent {
    private static final int VPS_POPUP_ID;
    private static final int OPS_SUBSTITUTE_HIDDEN;
    private static final int OPS_SUBSTITUTE_SHOWN;
    private AbstractParkingFocusPropertyDecorator focusPropertyDecorator;

    public ParkingSystemVPSComponentEvo(ICarApplication iCarApplication, IParkingSystemController iParkingSystemController) {
        super(iCarApplication, iParkingSystemController);
    }

    @Override
    public void init() {
        this.getLogChannel().log(-2137614336, "[ParkingSystemVPSComponentEvo#init] setting PARKING_VPS_SHOW_OPS_SUBSTITUTE_REPRESENTATION_CHOICE to %1", 0L);
        this.getChoiceModel(-66248704).setValue(0);
        super.init();
    }

    @Override
    protected void initVisibility() {
    }

    @Override
    protected void deinitVisibility() {
    }

    @Override
    protected void updateMenuEntryVisibility(ParkingSystemViewOptions parkingSystemViewOptions) {
    }

    @Override
    public int getID() {
        return 4;
    }

    @Override
    public ParkingPopupIdentifier getHMIPopupID(int n) {
        return new ParkingPopupIdentifier(0, 0x200B2000);
    }

    @Override
    public int getHMIPopupPrio(int n) {
        int n2 = MMIKombiPopupIDMapper.getMMIKombiSlotID(0x200B2000);
        int n3 = MMIKombiPopupIDMapper.getMMIKombiPrio(0x200B2000);
        return this.getApplication().getFrameworkAccess().getSysConstManager().getHMIInternalPopupPrio(n2, n3);
    }

    @Override
    public IParkingFocusPropertyConfig createFocusPropertyDecorator(IParkingFocusPropertyConfig iParkingFocusPropertyConfig) {
        if (this.focusPropertyDecorator == null) {
            this.focusPropertyDecorator = new ParkingSystemVPSComponentEvo$1(this, iParkingFocusPropertyConfig);
            return this.focusPropertyDecorator;
        }
        return iParkingFocusPropertyConfig;
    }

    @Override
    public void updateVPSFailure(boolean bl, int n) {
        this.getLogChannel().log(-2137614336, "[ParkingSystemVPSComponentEvo#updateVPSFailure] VPSFailure=%1, validFlag=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(-234086400).setValue(bl ? 1 : 0);
        }
    }

    @Override
    public void setActive(boolean bl, DisplayContent displayContent) {
        int n = 0;
        if (displayContent != null && displayContent.popup == 2) {
            n = 1;
            this.getLogChannel().log(-2137614336, "[ParkingSystemVPSComponentEvo#setActive] Show OPS substitute. DisplayContent popup: %1", (long)displayContent.popup);
        } else {
            this.getLogChannel().log(-2137614336, "[ParkingSystemVPSComponentEvo#setActive] setting PARKING_VPS_SHOW_OPS_SUBSTITUTE_REPRESENTATION_CHOICE to %1", (long)n);
        }
        this.getChoiceModel(-66248704).setValue(n);
        super.setActive(bl, displayContent);
    }
}

