/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.evo.parking;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.earlyfunc.core.parking.AbstractParkingFocusPropertyDecorator;
import de.audi.app.earlyfunc.core.parking.IParkingFocusPropertyConfig;
import de.audi.app.earlyfunc.core.parking.IParkingSystemController;
import de.audi.app.earlyfunc.core.parking.ParkingFocusPropertyCollection;
import de.audi.app.earlyfunc.core.parking.ParkingPopupIdentifier;
import de.audi.app.earlyfunc.core.parking.vps.AbstractParkingSystemVPSComponent;
import de.audi.atip.hmi.MMIKombiPopupIDMapper;
import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;

public class ParkingSystemVPSComponentEvo
extends AbstractParkingSystemVPSComponent {
    private static final int VPS_POPUP_ID = 0x200B20;
    private static final int OPS_SUBSTITUTE_HIDDEN = 0;
    private static final int OPS_SUBSTITUTE_SHOWN = 1;
    private AbstractParkingFocusPropertyDecorator focusPropertyDecorator;

    public ParkingSystemVPSComponentEvo(ICarApplication iCarApplication, IParkingSystemController iParkingSystemController) {
        super(iCarApplication, iParkingSystemController);
    }

    public void init() {
        this.getLogChannel().log(10000000, "[ParkingSystemVPSComponentEvo#init] setting PARKING_VPS_SHOW_OPS_SUBSTITUTE_REPRESENTATION_CHOICE to %1", 0L);
        this.getChoiceModel(2100732).setValue(0);
        super.init();
    }

    protected void initVisibility() {
    }

    protected void deinitVisibility() {
    }

    protected void updateMenuEntryVisibility(ParkingSystemViewOptions parkingSystemViewOptions) {
    }

    public int getID() {
        return 4;
    }

    public ParkingPopupIdentifier getHMIPopupID(int n) {
        return new ParkingPopupIdentifier(0, 0x200B20);
    }

    public int getHMIPopupPrio(int n) {
        int n2 = MMIKombiPopupIDMapper.getMMIKombiSlotID(0x200B20);
        int n3 = MMIKombiPopupIDMapper.getMMIKombiPrio(0x200B20);
        return this.getApplication().getFrameworkAccess().getSysConstManager().getHMIInternalPopupPrio(n2, n3);
    }

    public IParkingFocusPropertyConfig createFocusPropertyDecorator(IParkingFocusPropertyConfig iParkingFocusPropertyConfig) {
        if (this.focusPropertyDecorator == null) {
            this.focusPropertyDecorator = new AbstractParkingFocusPropertyDecorator(iParkingFocusPropertyConfig){

                protected ParkingFocusPropertyCollection prepareFocusProperties(ParkingFocusPropertyCollection parkingFocusPropertyCollection) {
                    if (ParkingSystemVPSComponentEvo.this.getCurrentVPSView() == 1) {
                        ParkingSystemVPSComponentEvo.this.getLogChannel().log(10000000, "[AbstractParkingFocusPropertyDecorator] VPS FocusPropertyDecorator adds property FOCUS_EARLY_APPS_REARVIEW_IN_ANZEIGE('%1').", -221000551L);
                        parkingFocusPropertyCollection.addFocusProperty(-221000551);
                    } else if (ParkingSystemVPSComponentEvo.this.getCurrentVPSView() == 4) {
                        ParkingSystemVPSComponentEvo.this.getLogChannel().log(10000000, "[AbstractParkingFocusPropertyDecorator] VPS FocusPropertyDecorator adds property FOCUS_EARLY_APPS_DRAUFSICHT_IN_ANZEIGE('%1').", -831752975L);
                        parkingFocusPropertyCollection.addFocusProperty(-831752975);
                    }
                    return parkingFocusPropertyCollection;
                }
            };
            return this.focusPropertyDecorator;
        }
        return iParkingFocusPropertyConfig;
    }

    public void updateVPSFailure(boolean bl, int n) {
        this.getLogChannel().log(10000000, "[ParkingSystemVPSComponentEvo#updateVPSFailure] VPSFailure=%1, validFlag=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(2100466).setValue(bl ? 1 : 0);
        }
    }

    public void setActive(boolean bl, DisplayContent displayContent) {
        int n = 0;
        if (displayContent != null && displayContent.popup == 2) {
            n = 1;
            this.getLogChannel().log(10000000, "[ParkingSystemVPSComponentEvo#setActive] Show OPS substitute. DisplayContent popup: %1", (long)displayContent.popup);
        } else {
            this.getLogChannel().log(10000000, "[ParkingSystemVPSComponentEvo#setActive] setting PARKING_VPS_SHOW_OPS_SUBSTITUTE_REPRESENTATION_CHOICE to %1", (long)n);
        }
        this.getChoiceModel(2100732).setValue(n);
        super.setActive(bl, displayContent);
    }
}

