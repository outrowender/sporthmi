/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.evo.parking.ops;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.earlyfunc.core.parking.IParkingSystemController;
import de.audi.app.earlyfunc.core.parking.ParkingPopupIdentifier;
import de.audi.app.earlyfunc.core.parking.ops.AbstractParkingSystemOPSComponent;
import de.audi.app.earlyfunc.core.parking.ops.IOPSDistanceControl;
import de.audi.app.earlyfunc.evo.parking.ops.OPSDistanceControlEvo;
import de.audi.atip.hmi.MMIKombiPopupIDMapper;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.storage.IStorageAccess;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;
import org.dsi.ifc.carparkingsystem.VPSSupportedViews;

public class ParkingSystemOPSComponentEvo
extends AbstractParkingSystemOPSComponent
implements RangeListener {
    public static final int OPS_POPUP_ID = 2100008;

    public ParkingSystemOPSComponentEvo(ICarApplication iCarApplication, IParkingSystemController iParkingSystemController) {
        super(iCarApplication, iParkingSystemController);
    }

    protected void initVisibility() {
    }

    protected void deinitVisibility() {
    }

    protected void initModels() {
        super.initModels();
        this.getRangeModel(2100400).setRangeListener(this);
    }

    protected void loadFromPersistence() {
        IStorageAccess iStorageAccess = this.getApplication().getFrameworkAccess().getStorageMgr();
        int n = iStorageAccess.getInt(1006, 50, 0);
        this.controller.notifyViewModeSettingChanged(this, this.getParkingSystemID(), n, n, true);
        this.trackHoseControl.initializeTrackHoseList();
    }

    public void updateParkingSystemViewOptions(ParkingSystemViewOptions parkingSystemViewOptions, int n) {
        if (null == this.currentViewOptions && n == 1) {
            boolean bl = false;
            VPSSupportedViews vPSSupportedViews = null;
            if (null != parkingSystemViewOptions && null != parkingSystemViewOptions.getVpsConfiguration() && null != (vPSSupportedViews = parkingSystemViewOptions.getVpsConfiguration().getSupportedViews())) {
                bl = vPSSupportedViews.isBirdview();
            } else {
                this.getLogChannel().log(1000000, "[ParkingSystemOPSComponentEvo#updateParkingSystemViewOptions] no viewOptions available");
            }
            IStorageAccess iStorageAccess = this.getApplication().getFrameworkAccess().getStorageMgr();
            int n2 = iStorageAccess.getInt(1006, 50, 0);
            if (this.isCameraViewModePersistedButNotSupported(bl, vPSSupportedViews, n2)) {
                this.getLogChannel().log(1000000, "[ParkingSystemOPSComponentEvo#updateParkingSystemViewOptions] overwrite OPS view mode!");
                iStorageAccess.setInt(1006, 50, 1);
                this.controller.notifyViewModeSettingChanged(this, this.getParkingSystemID(), 1, 1, true);
            }
        }
        super.updateParkingSystemViewOptions(parkingSystemViewOptions, n);
    }

    private boolean isCameraViewModePersistedButNotSupported(boolean bl, VPSSupportedViews vPSSupportedViews, int n) {
        return 0 == n && !bl && vPSSupportedViews != null && vPSSupportedViews.isRearview();
    }

    protected void deinitModels() {
        this.getRangeModel(2100400).resetListener();
        super.deinitModels();
    }

    public int getID() {
        return 3;
    }

    protected IOPSDistanceControl initDistanceControl() {
        return new OPSDistanceControlEvo(this, this.getApplication().getFrameworkAccess().getHmiServiceApp());
    }

    public ParkingPopupIdentifier getHMIPopupID(int n) {
        return new ParkingPopupIdentifier(1, 2100008);
    }

    public int getHMIPopupPrio(int n) {
        int n2 = MMIKombiPopupIDMapper.getMMIKombiSlotID(0x200B20);
        int n3 = MMIKombiPopupIDMapper.getMMIKombiPrio(0x200B20);
        return this.getApplication().getFrameworkAccess().getSysConstManager().getHMIInternalPopupPrio(n2, n3);
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        if (!this.getApplication().getFrameworkAccess().getSysApp().getAdaptationANP().isOPSinDashboardAvailable()) {
            return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{40, 9, 10, 11, 33, 34, 35, 36, 37, 38, 32})};
        }
        this.getLogChannel().log(10000000, "[ParkingSystemOPSComponentEvo#getDSIAttributesSets] No registration for DSI attributes because Flag 'Display OPS in Kombi' (19x1) is set to true.");
        return null;
    }

    public void decrement(int n, int n2, int n3) {
        this.abortOPSStandalonePopup(n);
    }

    public void increment(int n, int n2, int n3) {
        this.abortOPSStandalonePopup(n);
    }

    public void keyPressed(int n, int n2, int n3) {
        super.keyPressed(n, n2, n3);
        this.abortOPSStandalonePopup(n);
    }

    private void abortOPSStandalonePopup(int n) {
        if (n == 2100400) {
            this.getLogChannel().log(10000000, "[ParkingSystemOPSComponentEvo#abortOPSStandalonePopup] modelID='%1'", (long)n);
            this.controller.getPartialPopupHandler().hidePartialPopup(this.getHMIPopupID(0).getHmiPopupID(), true);
        }
    }

    public void updatePDCFailure(boolean bl, int n) {
        this.getLogChannel().log(10000000, "[ParkingSystemOPSomponentEvo#updatePDCFailure] PDCFailure=%1, validFlag=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(2100532).setValue(bl ? 1 : 0);
        }
    }
}

