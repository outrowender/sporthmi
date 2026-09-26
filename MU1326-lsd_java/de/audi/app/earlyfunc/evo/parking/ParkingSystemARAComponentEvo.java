/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.evo.parking;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.earlyfunc.core.parking.AbstractParkingFocusPropertyDecorator;
import de.audi.app.earlyfunc.core.parking.IParkingFocusPropertyConfig;
import de.audi.app.earlyfunc.core.parking.IParkingSystemController;
import de.audi.app.earlyfunc.core.parking.ParkingPopupIdentifier;
import de.audi.app.earlyfunc.core.parking.ara.AbstractParkingSystemARAComponent;
import de.audi.app.earlyfunc.evo.parking.ParkingSystemARAComponentEvo$1;
import de.audi.app.earlyfunc.evo.parking.ParkingSystemARAComponentEvo$ARAKeyConsumptionListener;
import de.audi.atip.hmi.MMIKombiPopupIDMapper;
import de.audi.atip.hmi.view.IPopupKeyConsuptionStrategy;
import de.audi.atip.hmi.view.PopupKeyConsuptionStrategy;

public class ParkingSystemARAComponentEvo
extends AbstractParkingSystemARAComponent {
    public static final short CODING_ID;
    private static final int ARA_POPUP_ID;
    private AbstractParkingFocusPropertyDecorator focusPropertyDecorator;
    private IPopupKeyConsuptionStrategy blockedStrategy;
    private IPopupKeyConsuptionStrategy unblockedStrategy;
    private final ParkingSystemARAComponentEvo$ARAKeyConsumptionListener keyConsumptionListener = new ParkingSystemARAComponentEvo$ARAKeyConsumptionListener(this, null);

    public ParkingSystemARAComponentEvo(ICarApplication iCarApplication, IParkingSystemController iParkingSystemController) {
        super(iCarApplication, iParkingSystemController);
    }

    @Override
    public void init() {
        super.init();
        this.blockedStrategy = new PopupKeyConsuptionStrategy(0x200B2000);
        this.blockedStrategy.setHKPressFilter(new int[]{30, 15, 34, 36, 55, 1, 2, 3, 4, 5, 6, 7, 35, 82, 83, 84, 58, 59, 78, 11, 22});
        this.blockedStrategy.registerPopupKeyConsumptionListener(this.keyConsumptionListener);
        this.unblockedStrategy = new PopupKeyConsuptionStrategy(0x200B2000);
        this.unblockedStrategy.setHKPressFilter(null);
        this.unblockedStrategy.registerPopupKeyConsumptionListener(this.keyConsumptionListener);
    }

    @Override
    protected void initVisibility() {
    }

    @Override
    protected void deinitVisibility() {
    }

    @Override
    public int getID() {
        return 5;
    }

    @Override
    protected int getDefaultMessagePartialPopupID() {
        return 1728782336;
    }

    @Override
    protected int getSplitscreenCenteredMessagePartialPopupID() {
        return 688594944;
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
            this.focusPropertyDecorator = new ParkingSystemARAComponentEvo$1(this, iParkingFocusPropertyConfig);
            return this.focusPropertyDecorator;
        }
        return iParkingFocusPropertyConfig;
    }

    @Override
    public IPopupKeyConsuptionStrategy getAraPopupConsumptionStrategy(boolean bl) {
        return bl ? this.blockedStrategy : this.unblockedStrategy;
    }
}

