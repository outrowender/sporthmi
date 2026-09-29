/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.evo.parking;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.earlyfunc.core.parking.IParkingSystemController;
import de.audi.app.earlyfunc.core.parking.ParkingPopupIdentifier;
import de.audi.app.earlyfunc.core.parking.pla.AbstractParkingSystemPLAComponent;
import de.audi.app.earlyfunc.evo.parking.ParkingSystemPLAComponentEvo$PLAKeyConsumptionListener;
import de.audi.atip.hmi.MMIKombiPopupIDMapper;
import de.audi.atip.hmi.view.IPopupKeyConsuptionStrategy;
import de.audi.atip.hmi.view.PopupKeyConsuptionStrategy;

public class ParkingSystemPLAComponentEvo
extends AbstractParkingSystemPLAComponent {
    private static final int PLA_POPUP_ID;
    private IPopupKeyConsuptionStrategy blockedStrategy;
    private IPopupKeyConsuptionStrategy unblockedStrategy;
    private IPopupKeyConsuptionStrategy defaultStrategy;
    private final ParkingSystemPLAComponentEvo$PLAKeyConsumptionListener blockedKeyConsumptionListener = new ParkingSystemPLAComponentEvo$PLAKeyConsumptionListener(this, true);
    private final ParkingSystemPLAComponentEvo$PLAKeyConsumptionListener unblockedKeyConsumptionListener = new ParkingSystemPLAComponentEvo$PLAKeyConsumptionListener(this, false);

    public ParkingSystemPLAComponentEvo(ICarApplication iCarApplication, IParkingSystemController iParkingSystemController) {
        super(iCarApplication, iParkingSystemController);
        this.blockedStrategy = new PopupKeyConsuptionStrategy(0x200B2000);
        this.blockedStrategy.setHKPressFilter(new int[]{30, 15, 34, 36, 55, 1, 2, 3, 4, 5, 6, 7, 35, 82, 83, 84, 58, 59, 78, 11, 9, 77, 22, 71, 69, 70, 68, 73, 72, 74, 75, 43, 44, 45, 46, 47, 48, 79, 80});
        this.blockedStrategy.registerPopupKeyConsumptionListener(this.blockedKeyConsumptionListener);
        this.unblockedStrategy = new PopupKeyConsuptionStrategy(0x200B2000);
        this.unblockedStrategy.setHKPressFilter(new int[]{30, 34, 36, 55, 1, 2, 3, 4, 5, 6, 7, 35, 82, 83, 84, 58, 59, 43, 44, 45, 46, 47, 48, 79, 80});
        this.unblockedStrategy.registerPopupKeyConsumptionListener(this.unblockedKeyConsumptionListener);
        this.defaultStrategy = new PopupKeyConsuptionStrategy(0x200B2000);
        this.defaultStrategy.setHKPressFilter(null);
    }

    @Override
    protected void initVisibility() {
    }

    @Override
    protected void deinitVisibility() {
    }

    @Override
    public int getID() {
        return 6;
    }

    @Override
    protected int getPLAPartialPopupID() {
        return 671817728;
    }

    @Override
    protected int getDefaultMessagePartialPopupID() {
        return 1275797504;
    }

    @Override
    protected int getSplitscreenCenteredMessagePartialPopupID() {
        return 705372160;
    }

    @Override
    protected int getSingleLineMessagePartialPopupID() {
        return 1141579776;
    }

    @Override
    protected int getOPSStandaloneLeftMessagePartialPopupID() {
        return 1124802560;
    }

    @Override
    protected int getOPSStandaloneRightMessagePartialPopupID() {
        return 1208688640;
    }

    @Override
    protected int getStartParkOutMessagePartialPopupID() {
        return 1175134208;
    }

    protected int getBigPLAMessagePartialPopupID() {
        return 705372160;
    }

    @Override
    public IPopupKeyConsuptionStrategy getPLAPopupConsumptionStrategy(boolean bl) {
        return bl ? this.blockedStrategy : this.unblockedStrategy;
    }

    @Override
    public IPopupKeyConsuptionStrategy getDefaultPLAPopupConsumptionStrategy() {
        return this.defaultStrategy;
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
}

