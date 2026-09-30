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
import de.audi.app.earlyfunc.core.parking.ara.AbstractParkingSystemARAComponent;
import de.audi.atip.hmi.MMIKombiPopupIDMapper;
import de.audi.atip.hmi.view.IPopupKeyConsumptionListener;
import de.audi.atip.hmi.view.IPopupKeyConsuptionStrategy;
import de.audi.atip.hmi.view.PopupKeyConsuptionStrategy;

public class ParkingSystemARAComponentEvo
extends AbstractParkingSystemARAComponent {
    public static final short CODING_ID = 44;
    private static final int ARA_POPUP_ID = 0x200B20;
    private AbstractParkingFocusPropertyDecorator focusPropertyDecorator;
    private IPopupKeyConsuptionStrategy blockedStrategy;
    private IPopupKeyConsuptionStrategy unblockedStrategy;
    private final ARAKeyConsumptionListener keyConsumptionListener = new ARAKeyConsumptionListener();

    public ParkingSystemARAComponentEvo(ICarApplication iCarApplication, IParkingSystemController iParkingSystemController) {
        super(iCarApplication, iParkingSystemController);
    }

    public void init() {
        super.init();
        this.blockedStrategy = new PopupKeyConsuptionStrategy(0x200B20);
        this.blockedStrategy.setHKPressFilter(new int[]{30, 15, 34, 36, 55, 1, 2, 3, 4, 5, 6, 7, 35, 82, 83, 84, 58, 59, 78, 11, 22});
        this.blockedStrategy.registerPopupKeyConsumptionListener(this.keyConsumptionListener);
        this.unblockedStrategy = new PopupKeyConsuptionStrategy(0x200B20);
        this.unblockedStrategy.setHKPressFilter(null);
        this.unblockedStrategy.registerPopupKeyConsumptionListener(this.keyConsumptionListener);
    }

    protected void initVisibility() {
    }

    protected void deinitVisibility() {
    }

    public int getID() {
        return 5;
    }

    protected int getDefaultMessagePartialPopupID() {
        return 2100071;
    }

    protected int getSplitscreenCenteredMessagePartialPopupID() {
        return 2100009;
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
                    if (ParkingSystemARAComponentEvo.this.isAraActive()) {
                        ParkingSystemARAComponentEvo.this.getLogChannel().log(10000000, "[AbstractParkingFocusPropertyDecorator] ARA FocusPropertyDecorator adds property FOCUS_EARLY_APPS_A_R_A_AKTIV('%1').", 1948600019L);
                        parkingFocusPropertyCollection.addFocusProperty(1948600019);
                    }
                    return parkingFocusPropertyCollection;
                }
            };
            return this.focusPropertyDecorator;
        }
        return iParkingFocusPropertyConfig;
    }

    public IPopupKeyConsuptionStrategy getAraPopupConsumptionStrategy(boolean bl) {
        return bl ? this.blockedStrategy : this.unblockedStrategy;
    }

    private final class ARAKeyConsumptionListener
    implements IPopupKeyConsumptionListener {
        private ARAKeyConsumptionListener() {
        }

        public void hKPressed(boolean bl, int n) {
            if (ParkingSystemARAComponentEvo.this.getLogChannel().isDebug()) {
                ParkingSystemARAComponentEvo.this.getLogChannel().log(10000000, "[ARAKeyConsumptionListener#hKPressed] keyCode='%2', consumed='%1', ", bl, (long)n);
            }
            if (bl) {
                if (ParkingSystemARAComponentEvo.this.getLogChannel().isDebug()) {
                    ParkingSystemARAComponentEvo.this.getLogChannel().log(10000000, "[ARAKeyConsumptionListener#hKPressed] User interaction prohibited = 'true'");
                }
            } else if (ParkingSystemARAComponentEvo.this.getLogChannel().isDebug()) {
                ParkingSystemARAComponentEvo.this.getLogChannel().log(10000000, "[ARAKeyConsumptionListener#hKPressed] User interaction prohibited = 'false'");
            }
        }
    }
}

