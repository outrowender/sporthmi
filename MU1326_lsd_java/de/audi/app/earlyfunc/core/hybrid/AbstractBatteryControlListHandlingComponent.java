/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.car.common.adapter.AbstractDSICarHybridAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.listhandling.BatteryControlPowerProviderRAx;
import de.audi.app.car.common.listhandling.BatteryControlProfileRAx;
import de.audi.app.car.common.listhandling.ListHandlingHelper;
import de.audi.app.car.common.listhandling.SyncedBCProfileRAxArray;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.atip.interapp.IBatteryControlListHandlingCallback;
import de.audi.atip.interapp.IBatteryControlListHandlingService;
import de.audi.atip.metrics.DateMetric;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.dsi.ifc.carhybrid.BatteryControlConfiguration;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderAH;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA0;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA1;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA2;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRAE;
import org.dsi.ifc.carhybrid.BatteryControlProfileOperation;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA0;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA1;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA2;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA3;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA4;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA5;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA6;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA7;
import org.dsi.ifc.carhybrid.BatteryControlProfilesAH;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;

public abstract class AbstractBatteryControlListHandlingComponent
extends AbstractDSICarHybridAdapter
implements IBatteryControlListHandlingService {
    private CarServiceProvider serviceProvider;
    private static final String LOGCHANNEL_NAME = "App.EarlyFunc.BatteryControlListHandling";
    public static final short CODING_ID = 41;
    private BatteryControlViewOptions currBConViewOptions;
    private BatteryControlConfiguration bcConfig = null;
    private List calledBackComponents = new ArrayList();
    private int lastKnownPowProvListPos = 0;
    private int lastKnownProfListPos = 0;
    private int totalNumOfPowProv = 0;
    private int totalNumOfProfiles = 0;
    private int countTransmittedPowerProvElems = 0;
    private int countTransmittedProfileElems = 0;
    private final int bcListSize;
    private final BatteryControlPowerProviderRAx[] powProvList = new BatteryControlPowerProviderRAx[8];
    private static final int POWERPROVIDER_LIST_RECORDCONTENT = 2;
    private static final int INIT_PROFILE_LIST_START_ELEMENT = 0;
    private static final int PROFILE_LIST_RECORDCONTENT = 5;
    private int maxProfileTransmittableElems = 0;
    private int maxPowProvTransmittableElems = 0;
    private final SyncedBCProfileRAxArray profListArray = new SyncedBCProfileRAxArray(8);
    static /* synthetic */ Class class$de$audi$atip$interapp$IBatteryControlListHandlingService;

    public AbstractBatteryControlListHandlingComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
        this.bcListSize = 8;
    }

    public void init() {
        super.init();
        ListHandlingHelper.init(this.getLogChannel());
        this.serviceProvider = new CarServiceProvider((class$de$audi$atip$interapp$IBatteryControlListHandlingService == null ? (class$de$audi$atip$interapp$IBatteryControlListHandlingService = AbstractBatteryControlListHandlingComponent.class$("de.audi.atip.interapp.IBatteryControlListHandlingService")) : class$de$audi$atip$interapp$IBatteryControlListHandlingService).getName(), this, null, this.getApplication().getBundleContext(), this.getApplication().getFrameworkAccess().getLogChannel(LOGCHANNEL_NAME));
        this.serviceProvider.startService();
    }

    public void deinit() {
        this.serviceProvider.stopService();
    }

    public String getName() {
        return "BatteryControlListHandling";
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{6}, new int[]{11, 12, 13, 14, 10, 18, 16, 15, 17, 9, 8})};
    }

    public String getCurrentViewOptions() {
        if (this.currBConViewOptions == null) {
            return "no view options received yet";
        }
        return this.currBConViewOptions.toString();
    }

    protected void initModels() {
    }

    protected void deinitModels() {
    }

    protected void initVisibility() {
    }

    protected void deinitVisibility() {
    }

    public void updateBatteryControlViewOptions(BatteryControlViewOptions batteryControlViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateBatteryControlViewOptions(%1), valid=%2", (Object)(batteryControlViewOptions != null ? this.formatViewOptionsLog(batteryControlViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1 && batteryControlViewOptions != null) {
            this.currBConViewOptions = batteryControlViewOptions;
            if (batteryControlViewOptions.getConfiguration() != null) {
                this.bcConfig = batteryControlViewOptions.getConfiguration();
            }
            this.primaryAttributeFirstSetReceived();
        }
    }

    public synchronized int getProfileListLength() {
        if (this.profListArray != null) {
            return this.profListArray.length();
        }
        return 0;
    }

    public BatteryControlProfileOperation getBatteryControlProfileOperation(int n) {
        BatteryControlProfileOperation batteryControlProfileOperation;
        BatteryControlProfileOperation batteryControlProfileOperation2 = this.getProfileListLength() > n && null != this.profListArray.get(n) && null != (batteryControlProfileOperation = this.profListArray.get(n).getProfileOperation()) ? new BatteryControlProfileOperation(batteryControlProfileOperation.isCharge(), batteryControlProfileOperation.isClimate(), batteryControlProfileOperation.isClimateWithoutExternalSupply(), batteryControlProfileOperation.isAutoDefrost(), batteryControlProfileOperation.isSeatHeaterFrontLeft(), batteryControlProfileOperation.isSeatHeaterFrontRight(), batteryControlProfileOperation.isSeatHeaterRearLeft(), batteryControlProfileOperation.isSeatHeaterRearRight()) : new BatteryControlProfileOperation();
        return batteryControlProfileOperation2;
    }

    public void setBatteryControlProfileOperation(int n, boolean bl, boolean bl2, boolean bl3) {
        BatteryControlProfilesAH batteryControlProfilesAH = new BatteryControlProfilesAH();
        batteryControlProfilesAH.arrayContent = 1;
        batteryControlProfilesAH.recordContent = 5;
        batteryControlProfilesAH.numOfElements = 1;
        batteryControlProfilesAH.startElement = n;
        batteryControlProfilesAH.transactionID = 1;
        batteryControlProfilesAH.asgID = 1;
        if (this.profListArray != null && this.profListArray.get(n) != null) {
            this.getLogChannel().log(10000000, "[AbstractBatteryControlListHandlingComponent#setBatteryControlProfileOperation] calling -> copyFromBatteryControlProfileRAx with index: '%1'", (long)n);
            BatteryControlProfileRA5 batteryControlProfileRA5 = (BatteryControlProfileRA5)ListHandlingHelper.copyFromBatteryControlProfileRAx(this.profListArray.get(n), 5);
            batteryControlProfileRA5.getProfileOperation().charge = bl;
            batteryControlProfileRA5.getProfileOperation().climate = bl2;
            batteryControlProfileRA5.getProfileOperation().climateWithoutExternalSupply = bl3;
            BatteryControlProfileRA5[] batteryControlProfileRA5Array = new BatteryControlProfileRA5[]{batteryControlProfileRA5};
            this.getLogChannel().log(1000000, "calling -> DSI.setBatteryControlProfileListRA5: arrayHeader=%1, data=%2", (Object)batteryControlProfilesAH, (Object)batteryControlProfileRA5Array);
            this.getDSI().setBatteryControlProfileListRA5(batteryControlProfilesAH, batteryControlProfileRA5Array);
        } else {
            this.getLogChannel().log(10000, "[AbstractBatteryControlListHandlingComponent#setBatteryControlProfileOperation] Profile list is 'null'");
        }
    }

    public synchronized boolean isProfileXOperationClimate(int n) {
        if (this.getProfileListLength() > n && this.profListArray.get(n) != null && this.profListArray.get((int)n).profileOperation != null) {
            return this.profListArray.get((int)n).profileOperation.climate;
        }
        return false;
    }

    public synchronized boolean isProfileXOperationCharge(int n) {
        if (this.getProfileListLength() > n && this.profListArray.get(n) != null && this.profListArray.get((int)n).profileOperation != null) {
            return this.profListArray.get((int)n).profileOperation.charge;
        }
        return false;
    }

    public synchronized void setProfileXOperationCharge(int n, boolean bl) {
        BatteryControlProfilesAH batteryControlProfilesAH = new BatteryControlProfilesAH();
        batteryControlProfilesAH.arrayContent = 1;
        batteryControlProfilesAH.recordContent = 5;
        batteryControlProfilesAH.numOfElements = 1;
        batteryControlProfilesAH.startElement = n;
        batteryControlProfilesAH.transactionID = 1;
        batteryControlProfilesAH.asgID = 1;
        if (this.profListArray != null && this.profListArray.get(n) != null) {
            this.getLogChannel().log(1000000, "setProfileXOperationCharge calling -> copyFromBatteryControlProfileRAx with index:%1", (long)n);
            BatteryControlProfileRA5 batteryControlProfileRA5 = (BatteryControlProfileRA5)ListHandlingHelper.copyFromBatteryControlProfileRAx(this.profListArray.get(n), 5);
            BatteryControlProfileRA5[] batteryControlProfileRA5Array = new BatteryControlProfileRA5[]{batteryControlProfileRA5};
            batteryControlProfileRA5Array[0].profileOperation.charge = bl;
            this.getLogChannel().log(1000000, "calling -> setBatteryControlProfileListRA5: arrayHeader=%1, data=%2", (Object)batteryControlProfilesAH, (Object)batteryControlProfileRA5Array);
            this.getDSI().setBatteryControlProfileListRA5(batteryControlProfilesAH, batteryControlProfileRA5Array);
        } else {
            this.getLogChannel().log(1000000, "[AbstractBatteryControlListHandlingComponent]: setProfileXOperationCharge: profList is null");
        }
    }

    public synchronized void setProfileXOperationClimate(int n, boolean bl) {
        BatteryControlProfilesAH batteryControlProfilesAH = new BatteryControlProfilesAH();
        batteryControlProfilesAH.arrayContent = 1;
        batteryControlProfilesAH.recordContent = 5;
        batteryControlProfilesAH.numOfElements = 1;
        batteryControlProfilesAH.startElement = n;
        batteryControlProfilesAH.transactionID = 1;
        batteryControlProfilesAH.asgID = 1;
        if (this.profListArray != null && this.profListArray.get(n) != null) {
            this.getLogChannel().log(1000000, "setProfileXOperationClimate calling -> copyFromBatteryControlProfileRAx with index:%1", (long)n);
            BatteryControlProfileRA5 batteryControlProfileRA5 = (BatteryControlProfileRA5)ListHandlingHelper.copyFromBatteryControlProfileRAx(this.profListArray.get(n), 5);
            BatteryControlProfileRA5[] batteryControlProfileRA5Array = new BatteryControlProfileRA5[]{batteryControlProfileRA5};
            if (batteryControlProfileRA5Array[0].profileOperation == null) {
                batteryControlProfileRA5Array[0].profileOperation = new BatteryControlProfileOperation();
            }
            batteryControlProfileRA5Array[0].profileOperation.climate = bl;
            this.getLogChannel().log(1000000, "calling -> setBatteryControlProfileListRA5: arrayHeader=%1, data=%2", (Object)batteryControlProfilesAH, (Object)batteryControlProfileRA5Array);
            this.getDSI().setBatteryControlProfileListRA5(batteryControlProfilesAH, batteryControlProfileRA5Array);
        } else {
            this.getLogChannel().log(1000000, "[AbstractBatteryControlListHandlingComponent]: setProfileXOperationClimate: profList is null");
        }
    }

    public synchronized boolean isProfileXOperation2Heater(int n) {
        if (this.getProfileListLength() > n && this.profListArray.get(n) != null && this.profListArray.get((int)n).profileOperation2 != null) {
            return this.profListArray.get((int)n).profileOperation2.parkHeater;
        }
        return false;
    }

    public synchronized boolean isProfileXOperation2HeaterAutomatic(int n) {
        if (this.getProfileListLength() > n && this.profListArray.get(n) != null && this.profListArray.get((int)n).profileOperation2 != null) {
            return this.profListArray.get((int)n).profileOperation2.parkHeaterAutomatic;
        }
        return false;
    }

    public synchronized int getProfile1Pos() {
        if (this.profListArray.get(1) != null) {
            return this.profListArray.get((int)1).pos;
        }
        return -1;
    }

    public synchronized int getProfileXProviderDataId(int n) {
        if (this.profListArray.get(n) != null) {
            return this.profListArray.get((int)n).providerDataId;
        }
        return -1;
    }

    public synchronized int getProfile2Pos() {
        if (this.profListArray.get(2) != null) {
            return this.profListArray.get((int)2).pos;
        }
        return -1;
    }

    public int getProfile3Pos() {
        if (this.profListArray.get(3) != null) {
            return this.profListArray.get((int)3).pos;
        }
        return -1;
    }

    public synchronized void setProfileXOperation2Heater(int n, boolean bl) {
    }

    public synchronized void setProfileXOperation2HeaterAutomatic(int n, boolean bl) {
    }

    private synchronized void setProfileXProviderDataId(int n, int n2) {
        BatteryControlProfilesAH batteryControlProfilesAH = new BatteryControlProfilesAH();
        batteryControlProfilesAH.arrayContent = 1;
        batteryControlProfilesAH.recordContent = 5;
        batteryControlProfilesAH.numOfElements = 1;
        batteryControlProfilesAH.startElement = n2;
        batteryControlProfilesAH.transactionID = 1;
        batteryControlProfilesAH.asgID = 1;
        if (this.profListArray != null && this.profListArray.get(n2) != null) {
            this.getLogChannel().log(1000000, "setProfileXProviderDataId calling -> copyFromBatteryControlProfileRAx  with index:%1", (long)n2);
            BatteryControlProfileRA5 batteryControlProfileRA5 = (BatteryControlProfileRA5)ListHandlingHelper.copyFromBatteryControlProfileRAx(this.profListArray.get(n2), 5);
            BatteryControlProfileRA5[] batteryControlProfileRA5Array = new BatteryControlProfileRA5[]{batteryControlProfileRA5};
            batteryControlProfileRA5Array[0].providerDataId = n;
            this.getDSI().setBatteryControlProfileListRA5(batteryControlProfilesAH, batteryControlProfileRA5Array);
        } else {
            this.getLogChannel().log(1000000, "[AbstractBatteryControlListHandlingComponent]: setProfileXProviderDataId: profList is null");
        }
    }

    public synchronized void setProfile1ProviderDataId(int n) {
        this.setProfileXProviderDataId(n, 1);
    }

    public synchronized void setProfile2ProviderDataId(int n) {
        this.setProfileXProviderDataId(n, 2);
    }

    public void setProfile3ProviderDataId(int n) {
        this.setProfileXProviderDataId(n, 3);
    }

    public synchronized void setAuxAcClimateSystem(int n, int n2) {
        BatteryControlProfilesAH batteryControlProfilesAH = new BatteryControlProfilesAH();
        batteryControlProfilesAH.arrayContent = 1;
        batteryControlProfilesAH.recordContent = 5;
        batteryControlProfilesAH.numOfElements = 1;
        batteryControlProfilesAH.startElement = n;
        batteryControlProfilesAH.transactionID = 1;
        batteryControlProfilesAH.asgID = 1;
        if (this.profListArray != null && this.profListArray.get(n) != null) {
            this.getLogChannel().log(1000000, "setAuxAcClimateSystem calling -> copyFromBatteryControlProfileRAx with index:%1", (long)n);
            BatteryControlProfileRA5 batteryControlProfileRA5 = (BatteryControlProfileRA5)ListHandlingHelper.copyFromBatteryControlProfileRAx(this.profListArray.get(n), 5);
            BatteryControlProfileRA5[] batteryControlProfileRA5Array = new BatteryControlProfileRA5[]{batteryControlProfileRA5};
            switch (n2) {
                case 0: {
                    batteryControlProfileRA5Array[0].profileOperation2.parkHeater = true;
                    batteryControlProfileRA5Array[0].profileOperation2.parkHeaterAutomatic = false;
                    break;
                }
                case 1: {
                    batteryControlProfileRA5Array[0].profileOperation2.parkHeater = false;
                    batteryControlProfileRA5Array[0].profileOperation2.parkHeaterAutomatic = false;
                    break;
                }
                case 2: {
                    batteryControlProfileRA5Array[0].profileOperation2.parkHeater = true;
                    batteryControlProfileRA5Array[0].profileOperation2.parkHeaterAutomatic = true;
                    break;
                }
            }
            this.getLogChannel().log(1000000, "calling -> setBatteryControlProfileListRA5: arrayHeader=%1, data=%2", (Object)batteryControlProfilesAH, (Object)batteryControlProfileRA5Array);
            this.getDSI().setBatteryControlProfileListRA5(batteryControlProfilesAH, batteryControlProfileRA5Array);
        } else {
            this.getLogChannel().log(1000000, "[AbstractBatteryControlListHandlingComponent]: setAuxAcClimateSystem: profList is null");
        }
    }

    public synchronized void registerCalledBackComponent(IBatteryControlListHandlingCallback iBatteryControlListHandlingCallback) {
        this.calledBackComponents.add(iBatteryControlListHandlingCallback);
    }

    public synchronized void setPreferredLoadingTimer1() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(((DateMetric)this.getMetricsModel(2100420).getMetric()).getDate());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(((DateMetric)this.getMetricsModel(2100411).getMetric()).getDate());
        BatteryControlPowerProviderAH batteryControlPowerProviderAH = new BatteryControlPowerProviderAH();
        batteryControlPowerProviderAH.arrayContent = 1;
        batteryControlPowerProviderAH.recordContent = 2;
        batteryControlPowerProviderAH.numOfElements = 1;
        batteryControlPowerProviderAH.startElement = 1;
        batteryControlPowerProviderAH.transactionID = 1;
        batteryControlPowerProviderAH.asgID = 1;
        BatteryControlPowerProviderRA2 batteryControlPowerProviderRA2 = new BatteryControlPowerProviderRA2();
        BatteryControlPowerProviderRA2[] batteryControlPowerProviderRA2Array = new BatteryControlPowerProviderRA2[]{batteryControlPowerProviderRA2};
        batteryControlPowerProviderRA2Array[0].nrStartHour = calendar.get(11);
        batteryControlPowerProviderRA2Array[0].nrStartMinute = calendar.get(12);
        batteryControlPowerProviderRA2Array[0].nrEndHour = calendar2.get(11);
        batteryControlPowerProviderRA2Array[0].nrEndMinute = calendar2.get(12);
        batteryControlPowerProviderRA2Array[0].pos = 1;
        this.getLogChannel().log(1000000, "calling -> setBatteryControlPowerProviderRA2: arrayHeader=%1, data=%2", (Object)batteryControlPowerProviderAH, (Object)batteryControlPowerProviderRA2Array);
        this.getDSI().setBatteryControlPowerProviderRA2(batteryControlPowerProviderAH, batteryControlPowerProviderRA2Array);
    }

    public synchronized void setPreferredLoadingTimer2() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(((DateMetric)this.getMetricsModel(0x200CCC).getMetric()).getDate());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(((DateMetric)this.getMetricsModel(2100409).getMetric()).getDate());
        BatteryControlPowerProviderAH batteryControlPowerProviderAH = new BatteryControlPowerProviderAH();
        batteryControlPowerProviderAH.arrayContent = 1;
        batteryControlPowerProviderAH.recordContent = 2;
        batteryControlPowerProviderAH.numOfElements = 1;
        batteryControlPowerProviderAH.startElement = 2;
        batteryControlPowerProviderAH.transactionID = 1;
        batteryControlPowerProviderAH.asgID = 1;
        BatteryControlPowerProviderRA2 batteryControlPowerProviderRA2 = new BatteryControlPowerProviderRA2();
        BatteryControlPowerProviderRA2[] batteryControlPowerProviderRA2Array = new BatteryControlPowerProviderRA2[]{batteryControlPowerProviderRA2};
        batteryControlPowerProviderRA2Array[0].nrStartHour = calendar.get(11);
        batteryControlPowerProviderRA2Array[0].nrStartMinute = calendar.get(12);
        batteryControlPowerProviderRA2Array[0].nrEndHour = calendar2.get(11);
        batteryControlPowerProviderRA2Array[0].nrEndMinute = calendar2.get(12);
        batteryControlPowerProviderRA2Array[0].pos = 2;
        this.getLogChannel().log(1000000, "setBatteryControlPowerProviderRA2: arrayHeader=%1, data=%2", (Object)batteryControlPowerProviderAH, (Object)batteryControlPowerProviderRA2Array);
        this.getDSI().setBatteryControlPowerProviderRA2(batteryControlPowerProviderAH, batteryControlPowerProviderRA2Array);
    }

    public void responseProfileListRA0(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA0[] batteryControlProfileRA0Array) {
        this.getLogChannel().log(1000000, "responseProfileListRA0: arrayHeader=%1, data=%2", (Object)batteryControlProfilesAH, (Object)batteryControlProfileRA0Array);
        this.responseProfileListRAx(batteryControlProfilesAH, batteryControlProfileRA0Array, 0);
    }

    public void responseProfileListRA1(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA1[] batteryControlProfileRA1Array) {
        this.getLogChannel().log(1000000, "responseProfileListRA1: arrayHeader=%1, data=%2", (Object)batteryControlProfilesAH, (Object)batteryControlProfileRA1Array);
        this.responseProfileListRAx(batteryControlProfilesAH, batteryControlProfileRA1Array, 1);
    }

    public void responseProfileListRA2(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA2[] batteryControlProfileRA2Array) {
        this.getLogChannel().log(1000000, "responseProfileListRA2: arrayHeader=%1, data=%2", (Object)batteryControlProfilesAH, (Object)batteryControlProfileRA2Array);
        this.responseProfileListRAx(batteryControlProfilesAH, batteryControlProfileRA2Array, 2);
    }

    public void responseProfileListRA3(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA3[] batteryControlProfileRA3Array) {
        this.getLogChannel().log(1000000, "responseProfileListRA3: arrayHeader=%1, data=%2", (Object)batteryControlProfilesAH, (Object)batteryControlProfileRA3Array);
        this.responseProfileListRAx(batteryControlProfilesAH, batteryControlProfileRA3Array, 3);
    }

    public void responseProfileListRA4(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA4[] batteryControlProfileRA4Array) {
        this.getLogChannel().log(1000000, "responseProfileListRA4: arrayHeader=%1, data=%2", (Object)batteryControlProfilesAH, (Object)batteryControlProfileRA4Array);
        this.responseProfileListRAx(batteryControlProfilesAH, batteryControlProfileRA4Array, 4);
    }

    public void responseProfileListRA5(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA5[] batteryControlProfileRA5Array) {
        this.getLogChannel().log(1000000, "responseProfileListRA5: arrayHeader=%1, data=%2", (Object)batteryControlProfilesAH, (Object)batteryControlProfileRA5Array);
        this.responseProfileListRAx(batteryControlProfilesAH, batteryControlProfileRA5Array, 5);
    }

    public void responseProfileListRA6(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA6[] batteryControlProfileRA6Array) {
        this.getLogChannel().log(1000000, "responseProfileListRA6: arrayHeader=%1, data=%2", (Object)batteryControlProfilesAH, (Object)batteryControlProfileRA6Array);
        this.responseProfileListRAx(batteryControlProfilesAH, batteryControlProfileRA6Array, 6);
    }

    public void responseProfileListRA7(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA7[] batteryControlProfileRA7Array) {
        this.getLogChannel().log(1000000, "responseProfileListRA7: arrayHeader=%1, data=%2", (Object)batteryControlProfilesAH, (Object)batteryControlProfileRA7Array);
        this.responseProfileListRAx(batteryControlProfilesAH, batteryControlProfileRA7Array, 7);
    }

    private void responseProfileListRAx(BatteryControlProfilesAH batteryControlProfilesAH, Object[] objectArray, int n) {
        this.getLogChannel().log(1000000, "responseProfileListRA%1 is called with header: %2", (Object)String.valueOf(n), (Object)batteryControlProfilesAH);
        BatteryControlProfileRAx[] batteryControlProfileRAxArray = ListHandlingHelper.mergeBatteryControlProfileArray(objectArray, this.profListArray);
        if (batteryControlProfileRAxArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                this.profListArray.set(batteryControlProfileRAxArray[i2], batteryControlProfileRAxArray[i2].getPos());
                this.getLogChannel().log(1000000, "profileListElement: =%1", objectArray[i2]);
            }
            this.countTransmittedProfileElems += batteryControlProfilesAH.numOfElements;
            this.extractProfileListData(batteryControlProfileRAxArray);
            if (this.shouldForwardProfileRequest(batteryControlProfilesAH.numOfElements)) {
                this.issueProfileForwardRequest(batteryControlProfilesAH);
            }
        } else {
            this.getLogChannel().log(10000, "[responseProfileListRAx] Could not merge array. Update ignored.");
        }
    }

    private boolean shouldForwardProfileRequest(int n) {
        boolean bl;
        boolean bl2 = bl = this.totalNumOfProfiles - this.countTransmittedProfileElems > 0 && n >= this.maxProfileTransmittableElems;
        if (!bl) {
            this.countTransmittedProfileElems = 0;
        }
        return bl;
    }

    private void issueProfileForwardRequest(BatteryControlProfilesAH batteryControlProfilesAH) {
        this.getLogChannel().log(1000000, "issueProfileForwardRequest: arrayHeader=%1", (Object)batteryControlProfilesAH);
        BatteryControlProfilesAH batteryControlProfilesAH2 = new BatteryControlProfilesAH();
        batteryControlProfilesAH2.arrayContent = 2;
        batteryControlProfilesAH2.startElement = this.lastKnownProfListPos;
        batteryControlProfilesAH2.recordContent = 5;
        batteryControlProfilesAH2.asgID = 1;
        batteryControlProfilesAH2.numOfElements = this.totalNumOfProfiles - this.countTransmittedProfileElems > 8 ? this.bcConfig.getProfilesTransmittableElements().getRa5() : this.totalNumOfProfiles - this.countTransmittedProfileElems;
        batteryControlProfilesAH2.transactionID = this.getTransactionId(batteryControlProfilesAH.transactionID);
        this.getDSI().requestBatteryControlProfileList(batteryControlProfilesAH2);
    }

    private void extractProfileListData(BatteryControlProfileRAx[] batteryControlProfileRAxArray) {
        for (int i2 = 0; i2 < this.calledBackComponents.size(); ++i2) {
            IBatteryControlListHandlingCallback iBatteryControlListHandlingCallback = (IBatteryControlListHandlingCallback)this.calledBackComponents.get(i2);
            for (int i3 = 0; i3 < batteryControlProfileRAxArray.length; ++i3) {
                if (iBatteryControlListHandlingCallback != null && batteryControlProfileRAxArray[i3].profileOperation != null) {
                    iBatteryControlListHandlingCallback.onBatteryControlProfileOperationChanged(batteryControlProfileRAxArray[i3].getPos(), batteryControlProfileRAxArray[i3].profileOperation);
                }
                if (batteryControlProfileRAxArray[i3].getPos() == 1) {
                    if (batteryControlProfileRAxArray[i3].profileOperation != null) {
                        ((IBatteryControlListHandlingCallback)this.calledBackComponents.get(i2)).updateChargeTimerClimateChoice(1, batteryControlProfileRAxArray[i3].profileOperation.climate ? 1 : 0);
                    }
                    this.updateClimateSystemTypeForProfileX(batteryControlProfileRAxArray[i3], i2);
                }
                if (batteryControlProfileRAxArray[i3].getPos() == 2) {
                    if (batteryControlProfileRAxArray[i3].profileOperation != null) {
                        ((IBatteryControlListHandlingCallback)this.calledBackComponents.get(i2)).updateChargeTimerClimateChoice(2, batteryControlProfileRAxArray[i3].profileOperation.climate ? 1 : 0);
                    }
                    this.updateClimateSystemTypeForProfileX(batteryControlProfileRAxArray[i3], i2);
                }
                if (batteryControlProfileRAxArray[i3].getPos() == 3) {
                    this.updateClimateSystemTypeForProfileX(batteryControlProfileRAxArray[i3], i2);
                }
                if (batteryControlProfileRAxArray[i3].getPos() == 4) {
                    this.updateClimateSystemTypeForProfileX(batteryControlProfileRAxArray[i3], i2);
                }
                if (batteryControlProfileRAxArray[i3].getPos() == 6) {
                    this.updateClimateSystemTypeForProfileX(batteryControlProfileRAxArray[i3], i2);
                }
                this.lastKnownProfListPos = batteryControlProfileRAxArray[i3].getPos();
            }
        }
    }

    private void updateClimateSystemTypeForProfileX(BatteryControlProfileRAx batteryControlProfileRAx, int n) {
        if (batteryControlProfileRAx.profileOperation2 != null) {
            boolean bl = batteryControlProfileRAx.profileOperation2.isParkHeater();
            boolean bl2 = batteryControlProfileRAx.profileOperation2.isParkHeaterAutomatic();
            if (bl && !bl2) {
                ((IBatteryControlListHandlingCallback)this.calledBackComponents.get(n)).updateClimateSystemType(batteryControlProfileRAx.getPos(), 0);
            } else if (bl && bl2) {
                ((IBatteryControlListHandlingCallback)this.calledBackComponents.get(n)).updateClimateSystemType(batteryControlProfileRAx.getPos(), 2);
            } else if (!bl && !bl2) {
                ((IBatteryControlListHandlingCallback)this.calledBackComponents.get(n)).updateClimateSystemType(batteryControlProfileRAx.getPos(), 1);
            }
        }
    }

    public void responsePowerProviderListRA0(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA0[] batteryControlPowerProviderRA0Array) {
        this.responsePowerProviderListRAx(batteryControlPowerProviderAH, batteryControlPowerProviderRA0Array, 0);
    }

    public void responsePowerProviderListRA1(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA1[] batteryControlPowerProviderRA1Array) {
        this.responsePowerProviderListRAx(batteryControlPowerProviderAH, batteryControlPowerProviderRA1Array, 1);
    }

    public void responsePowerProviderListRA2(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA2[] batteryControlPowerProviderRA2Array) {
        this.responsePowerProviderListRAx(batteryControlPowerProviderAH, batteryControlPowerProviderRA2Array, 2);
    }

    public void responsePowerProviderListRAE(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRAE[] batteryControlPowerProviderRAEArray) {
        this.responsePowerProviderListRAx(batteryControlPowerProviderAH, batteryControlPowerProviderRAEArray, 3);
    }

    private void responsePowerProviderListRAx(BatteryControlPowerProviderAH batteryControlPowerProviderAH, Object[] objectArray, int n) {
        this.getLogChannel().log(1000000, "responsePowerProviderListRAx: arrayHeader=%1, data=%2", (Object)batteryControlPowerProviderAH, (Object)objectArray);
        BatteryControlPowerProviderRAx[] batteryControlPowerProviderRAxArray = ListHandlingHelper.copyToBatteryControlPowerProviderArray(objectArray, n);
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            int n2 = batteryControlPowerProviderRAxArray[i2].getPos();
            this.powProvList[n2] = batteryControlPowerProviderRAxArray[i2];
            this.getLogChannel().log(1000000, "powerProviderListElement: =%1", objectArray[i2]);
        }
        this.countTransmittedPowerProvElems += batteryControlPowerProviderAH.numOfElements;
        this.extractPreferredLoadingTimeData(batteryControlPowerProviderAH, batteryControlPowerProviderRAxArray);
        if (this.shouldForwardPowerProvRequest(batteryControlPowerProviderAH.numOfElements)) {
            this.issuePowerProvForwardRequest(batteryControlPowerProviderAH);
        }
    }

    private boolean shouldForwardPowerProvRequest(int n) {
        boolean bl;
        boolean bl2 = bl = this.totalNumOfPowProv - this.countTransmittedPowerProvElems > 0 && n >= this.maxPowProvTransmittableElems;
        if (!bl) {
            this.countTransmittedPowerProvElems = 0;
        }
        return bl;
    }

    private void issuePowerProvForwardRequest(BatteryControlPowerProviderAH batteryControlPowerProviderAH) {
        this.getLogChannel().log(1000000, "issuePowerProvForwardRequest: arrayHeader=%1", (Object)batteryControlPowerProviderAH);
        BatteryControlPowerProviderAH batteryControlPowerProviderAH2 = new BatteryControlPowerProviderAH();
        batteryControlPowerProviderAH2.arrayContent = 2;
        batteryControlPowerProviderAH2.startElement = this.lastKnownPowProvListPos;
        batteryControlPowerProviderAH2.recordContent = 2;
        batteryControlPowerProviderAH2.asgID = 1;
        batteryControlPowerProviderAH2.numOfElements = this.totalNumOfPowProv - this.countTransmittedPowerProvElems > 8 ? this.bcConfig.getPowerProviderTransmittableElements().getRa2() : this.totalNumOfPowProv - this.countTransmittedPowerProvElems;
        batteryControlPowerProviderAH2.transactionID = this.getTransactionId(batteryControlPowerProviderAH.transactionID);
        this.getDSI().requestBatteryControlPowerProviderList(batteryControlPowerProviderAH2);
    }

    private void extractPreferredLoadingTimeData(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRAx[] batteryControlPowerProviderRAxArray) {
        this.getLogChannel().log(1000000, "extractPreferredLoadingTimeData: arrayHeader=%1, data=%2", (Object)batteryControlPowerProviderAH, (Object)batteryControlPowerProviderRAxArray);
        for (int i2 = 0; i2 < batteryControlPowerProviderRAxArray.length; ++i2) {
            if (batteryControlPowerProviderRAxArray[i2].getPos() == 1 || batteryControlPowerProviderRAxArray[i2].getPos() == 2) {
                int n;
                int n2;
                Calendar calendar = Calendar.getInstance();
                calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), batteryControlPowerProviderRAxArray[i2].nrStartHour, batteryControlPowerProviderRAxArray[i2].nrStartMinute);
                Date date = calendar.getTime();
                Calendar calendar2 = Calendar.getInstance();
                calendar2.set(calendar2.get(1), calendar2.get(2), calendar2.get(5), batteryControlPowerProviderRAxArray[i2].nrEndHour, batteryControlPowerProviderRAxArray[i2].nrEndMinute);
                Date date2 = calendar2.getTime();
                switch (batteryControlPowerProviderRAxArray[i2].getPos()) {
                    case 1: {
                        n2 = 2100420;
                        n = 2100411;
                        break;
                    }
                    case 2: {
                        n2 = 0x200CCC;
                        n = 2100409;
                        break;
                    }
                    default: {
                        n2 = 2100420;
                        n = 2100411;
                    }
                }
                DateMetric dateMetric = (DateMetric)this.getMetricsModel(n2).getMetric();
                if (dateMetric == null) {
                    dateMetric = new DateMetric(date, 1);
                }
                dateMetric.setDate(date);
                this.getMetricsModel(n2).setMetric(dateMetric);
                DateMetric dateMetric2 = (DateMetric)this.getMetricsModel(n).getMetric();
                if (dateMetric2 == null) {
                    dateMetric2 = new DateMetric(date2, 1);
                }
                dateMetric2.setDate(date2);
                this.getMetricsModel(n).setMetric(dateMetric2);
                this.getLogChannel().log(1000000, "preferredLoadingTime: startTime =%1, EndTime =%2", (Object)dateMetric.getDate(), (Object)dateMetric2.getDate());
            }
            this.lastKnownPowProvListPos = batteryControlPowerProviderRAxArray[i2].getPos();
        }
    }

    private int getTransactionId(int n) {
        int n2 = n >= 15 ? 1 : (n <= 0 ? 1 : n++);
        return n2;
    }

    public void updateBatteryControlTotalNumberOfProfiles(int n, int n2) {
        this.getLogChannel().log(1000000, "updateBatteryControlTotalNumberOfProfiles: numberOfProfiles=%1, validFlag=%2", (long)n, (long)n2);
        if (n2 == 1) {
            this.totalNumOfProfiles = n;
        }
    }

    public void updateBatteryControlTotalNumberOfPowerProvider(int n, int n2) {
        this.getLogChannel().log(1000000, "updateBatteryControlTotalNumberOfPowerProvider: numberOfPowerProvider=%1, validFlag=%2", (long)n, (long)n2);
        if (n2 == 1) {
            this.totalNumOfPowProv = n;
        }
    }

    public void updateBatteryControlProfilesListUpdateInfo(BatteryControlProfilesAH batteryControlProfilesAH, int[] nArray, int n) {
        this.getLogChannel().log(1000000, "updateBatteryControlProfilesListUpdateInfo: listUpdateInfo=%1, valid=%2", (Object)batteryControlProfilesAH, (long)n);
        if (n == 1) {
            BatteryControlProfilesAH batteryControlProfilesAH2 = new BatteryControlProfilesAH();
            batteryControlProfilesAH2.arrayContent = 1;
            batteryControlProfilesAH2.recordContent = 5;
            batteryControlProfilesAH2.startElement = batteryControlProfilesAH.getNumOfElements() != 1 ? 0 : batteryControlProfilesAH.getStartElement();
            batteryControlProfilesAH2.asgID = 1;
            if (this.bcConfig != null && this.bcConfig.getProfilesTransmittableElements() != null) {
                this.maxProfileTransmittableElems = this.bcConfig.getProfilesTransmittableElements().getRa5();
                batteryControlProfilesAH2.numOfElements = this.maxProfileTransmittableElems >= 8 ? 8 : (batteryControlProfilesAH.numOfElements == 1 ? 1 : this.maxProfileTransmittableElems);
            } else {
                batteryControlProfilesAH2.numOfElements = 0;
            }
            batteryControlProfilesAH2.transactionID = this.getTransactionId(batteryControlProfilesAH.transactionID);
            this.getDSI().requestBatteryControlProfileList(batteryControlProfilesAH2);
        }
    }

    public void updateBatteryControlPowerProviderListUpdateInfo(BatteryControlPowerProviderAH batteryControlPowerProviderAH, int[] nArray, int n) {
        this.getLogChannel().log(1000000, "updateBatteryControlPowerProviderListUpdateInfo: listUpdateInfo=%1, validFlag=%2", (Object)batteryControlPowerProviderAH, (long)n);
        if (n == 1) {
            BatteryControlPowerProviderAH batteryControlPowerProviderAH2 = new BatteryControlPowerProviderAH();
            batteryControlPowerProviderAH2.arrayContent = 1;
            batteryControlPowerProviderAH2.startElement = 0;
            batteryControlPowerProviderAH2.recordContent = 2;
            batteryControlPowerProviderAH2.asgID = 1;
            if (this.bcConfig.getPowerProviderTransmittableElements() != null) {
                this.maxPowProvTransmittableElems = this.bcConfig.getPowerProviderTransmittableElements().getRa2();
                batteryControlPowerProviderAH2.numOfElements = this.maxPowProvTransmittableElems >= 8 ? 8 : this.maxPowProvTransmittableElems;
            } else {
                batteryControlPowerProviderAH2.numOfElements = 0;
            }
            batteryControlPowerProviderAH2.transactionID = this.getTransactionId(batteryControlPowerProviderAH.transactionID);
            this.getDSI().requestBatteryControlPowerProviderList(batteryControlPowerProviderAH2);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

