/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.evo.parking;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.earlyfunc.core.parking.IParkingSystemController;
import de.audi.app.earlyfunc.core.parking.ParkingPopupIdentifier;
import de.audi.app.earlyfunc.core.parking.pla.AbstractParkingSystemPLAComponent;
import de.audi.atip.hmi.MMIKombiPopupIDMapper;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.view.IPopupKeyConsumptionListener;
import de.audi.atip.hmi.view.IPopupKeyConsuptionStrategy;
import de.audi.atip.hmi.view.PopupKeyConsuptionStrategy;

public class ParkingSystemPLAComponentEvo
extends AbstractParkingSystemPLAComponent {
    private static final int PLA_POPUP_ID = 0x200B20;
    private IPopupKeyConsuptionStrategy blockedStrategy;
    private IPopupKeyConsuptionStrategy unblockedStrategy;
    private IPopupKeyConsuptionStrategy defaultStrategy;
    private final PLAKeyConsumptionListener blockedKeyConsumptionListener = new PLAKeyConsumptionListener(true);
    private final PLAKeyConsumptionListener unblockedKeyConsumptionListener = new PLAKeyConsumptionListener(false);

    public ParkingSystemPLAComponentEvo(ICarApplication iCarApplication, IParkingSystemController iParkingSystemController) {
        super(iCarApplication, iParkingSystemController);
        this.blockedStrategy = new PopupKeyConsuptionStrategy(0x200B20);
        this.blockedStrategy.setHKPressFilter(new int[]{30, 15, 34, 36, 55, 1, 2, 3, 4, 5, 6, 7, 35, 82, 83, 84, 58, 59, 78, 11, 9, 77, 22, 71, 69, 70, 68, 73, 72, 74, 75, 43, 44, 45, 46, 47, 48, 79, 80});
        this.blockedStrategy.registerPopupKeyConsumptionListener(this.blockedKeyConsumptionListener);
        this.unblockedStrategy = new PopupKeyConsuptionStrategy(0x200B20);
        this.unblockedStrategy.setHKPressFilter(new int[]{30, 34, 36, 55, 1, 2, 3, 4, 5, 6, 7, 35, 82, 83, 84, 58, 59, 43, 44, 45, 46, 47, 48, 79, 80});
        this.unblockedStrategy.registerPopupKeyConsumptionListener(this.unblockedKeyConsumptionListener);
        this.defaultStrategy = new PopupKeyConsuptionStrategy(0x200B20);
        this.defaultStrategy.setHKPressFilter(null);
    }

    protected void initVisibility() {
    }

    protected void deinitVisibility() {
    }

    public int getID() {
        return 6;
    }

    protected int getPLAPartialPopupID() {
        return 2100008;
    }

    protected int getDefaultMessagePartialPopupID() {
        return 2100044;
    }

    protected int getSplitscreenCenteredMessagePartialPopupID() {
        return 2100010;
    }

    protected int getSingleLineMessagePartialPopupID() {
        return 2100036;
    }

    protected int getOPSStandaloneLeftMessagePartialPopupID() {
        return 2100035;
    }

    protected int getOPSStandaloneRightMessagePartialPopupID() {
        return 2100040;
    }

    protected int getStartParkOutMessagePartialPopupID() {
        return 2100038;
    }

    protected int getBigPLAMessagePartialPopupID() {
        return 2100010;
    }

    public IPopupKeyConsuptionStrategy getPLAPopupConsumptionStrategy(boolean bl) {
        return bl ? this.blockedStrategy : this.unblockedStrategy;
    }

    public IPopupKeyConsuptionStrategy getDefaultPLAPopupConsumptionStrategy() {
        return this.defaultStrategy;
    }

    public ParkingPopupIdentifier getHMIPopupID(int n) {
        return new ParkingPopupIdentifier(0, 0x200B20);
    }

    public int getHMIPopupPrio(int n) {
        int n2 = MMIKombiPopupIDMapper.getMMIKombiSlotID(0x200B20);
        int n3 = MMIKombiPopupIDMapper.getMMIKombiPrio(0x200B20);
        return this.getApplication().getFrameworkAccess().getSysConstManager().getHMIInternalPopupPrio(n2, n3);
    }

    private final class PLAKeyConsumptionListener
    implements IPopupKeyConsumptionListener {
        private final boolean prohibited;

        public PLAKeyConsumptionListener(boolean bl) {
            this.prohibited = bl;
        }

        public void hKPressed(boolean bl, int n) {
            if (ParkingSystemPLAComponentEvo.this.getLogChannel().isDebug()) {
                ParkingSystemPLAComponentEvo.this.getLogChannel().log(10000000, "[PLAKeyConsumptionListener#hKPressed] keyCode='%2', consumed='%1', ", bl, (long)n);
            }
            if (bl) {
                if (this.prohibited) {
                    if (ParkingSystemPLAComponentEvo.this.getLogChannel().isDebug()) {
                        ParkingSystemPLAComponentEvo.this.getLogChannel().log(10000000, "[PLAKeyConsumptionListener#hKPressed] User interaction prohibited = 'true'");
                    }
                } else {
                    boolean bl2;
                    if (ParkingSystemPLAComponentEvo.this.getLogChannel().isDebug()) {
                        ParkingSystemPLAComponentEvo.this.getLogChannel().log(10000000, "[PLAKeyConsumptionListener#hKPressed] User interaction prohibited = 'false'");
                    }
                    if (!(bl2 = KeyEvent.isAppChangeHardkey(n))) {
                        switch (n) {
                            case 15: {
                                bl2 = true;
                                break;
                            }
                        }
                    }
                    if (bl2) {
                        ParkingSystemPLAComponentEvo.this.canceledByHMI();
                    }
                }
            }
        }
    }
}

