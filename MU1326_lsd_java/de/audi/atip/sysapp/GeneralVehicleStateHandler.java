/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.KbdService;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.interapp.def.NullHMIAudioService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.power.PowerEventListener;
import de.audi.atip.sysapp.GeneralVehicleStateHandler$AudioListener;
import de.audi.atip.sysapp.GeneralVehicleStateHandler$SpeedHandler;
import de.audi.atip.sysapp.GeneralVehicleStateHandler$SpeedListener3DWizard;
import de.audi.atip.sysapp.GeneralVehicleStateHandler$SpeedListenerSperrKonzept;
import de.audi.atip.sysapp.GeneralVehicleStateHandler$SpeedListenerTV;
import de.audi.atip.sysapp.IStandStillListener;
import de.audi.atip.sysapp.SpeedThresholdListener;
import de.audi.atip.sysapp.SysApp;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.generalvehiclestates.AirbagData;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener;
import org.dsi.ifc.generalvehiclestates.TLOViewOptions;
import org.dsi.ifc.generalvehiclestates.TankInfo;
import org.dsi.ifc.global.CarViewOption;
import org.osgi.framework.ServiceReference;

public final class GeneralVehicleStateHandler
implements DSIGeneralVehicleStatesListener,
PowerEventListener {
    private static final int SIZE_SPEED_THRESHHOLD_ARRY;
    private final SysApp sysApp;
    private final List[] speedHandlers;
    private final boolean[] currentThresholdValues;
    private final List standStillListeners = new ArrayList();
    private final LogChannel lc;
    private boolean apsStatusKnown = false;
    private SDSService sdsService = null;
    private KbdService kbdService = null;
    private volatile boolean acousticParkingSystemActive;
    private HMIAudioService audioService;
    final HMIAudioServiceListener audioListener;
    static /* synthetic */ Class class$de$audi$atip$hmi$KbdService;

    GeneralVehicleStateHandler(SysApp sysApp) {
        this.sysApp = sysApp;
        this.lc = sysApp.getFramework().getLogChannel("Fw.VehicleState");
        this.updateClampAll(false, false);
        this.speedHandlers = new List[16];
        this.currentThresholdValues = new boolean[16];
        this.audioService = new NullHMIAudioService(this.lc);
        this.audioListener = new GeneralVehicleStateHandler$AudioListener(this, null);
        this.registerThreshold(new GeneralVehicleStateHandler$SpeedListener3DWizard(this, null), 1);
        this.registerThreshold(new GeneralVehicleStateHandler$SpeedListenerTV(this, null), 2);
        this.registerThreshold(new GeneralVehicleStateHandler$SpeedListenerSperrKonzept(this, null), 12);
    }

    private final HMIService getHMIService() {
        return this.sysApp.getFramework().getHMIService();
    }

    private void updateClampAll(boolean bl, boolean bl2) {
        this.getHMIService().getChoiceModel(53).setValue(bl ? 1 : 0);
        this.getHMIService().getChoiceModel(53).setStatus(bl ? 1 : 0);
        this.getHMIService().getChoiceModel(52).setValue(bl2 ? 1 : 0);
        this.getHMIService().getChoiceModel(52).setStatus(bl2 ? 1 : 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private List getSpeedManagerList(int n) {
        try {
            List[] listArray = this.speedHandlers;
            synchronized (this.speedHandlers) {
                List list = this.speedHandlers[n];
                if (list == null) {
                    this.speedHandlers[n] = list = new ArrayList(5);
                    this.currentThresholdValues[n] = false;
                }
                // ** MonitorExit[var2_2] (shouldn't be in output)
                return list;
            }
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            this.lc.log(10000, "undefined speed thresholdId %1, using default instead!");
            return this.getSpeedManagerList(0);
        }
    }

    private GeneralVehicleStateHandler$SpeedHandler findSpeedHandler(List list, SpeedThresholdListener speedThresholdListener) {
        for (int i2 = 0; i2 < list.size(); ++i2) {
            GeneralVehicleStateHandler$SpeedHandler generalVehicleStateHandler$SpeedHandler = (GeneralVehicleStateHandler$SpeedHandler)list.get(i2);
            if (speedThresholdListener == null || generalVehicleStateHandler$SpeedHandler.listener != speedThresholdListener) continue;
            return generalVehicleStateHandler$SpeedHandler;
        }
        return null;
    }

    private void removeSpeedHandler(List list, SpeedThresholdListener speedThresholdListener) {
        GeneralVehicleStateHandler$SpeedHandler generalVehicleStateHandler$SpeedHandler = this.findSpeedHandler(list, speedThresholdListener);
        if (generalVehicleStateHandler$SpeedHandler != null) {
            list.remove(generalVehicleStateHandler$SpeedHandler);
        }
    }

    synchronized void registerThreshold(SpeedThresholdListener speedThresholdListener, int n) {
        GeneralVehicleStateHandler$SpeedHandler generalVehicleStateHandler$SpeedHandler = new GeneralVehicleStateHandler$SpeedHandler(speedThresholdListener);
        List list = this.getSpeedManagerList(n);
        this.removeSpeedHandler(list, speedThresholdListener);
        list.add(generalVehicleStateHandler$SpeedHandler);
        generalVehicleStateHandler$SpeedHandler.fireThreshold(n, this.currentThresholdValues[n]);
    }

    synchronized void unregisterThreshold(SpeedThresholdListener speedThresholdListener) {
        for (int i2 = 0; i2 < this.speedHandlers.length; ++i2) {
            List list = this.speedHandlers[i2];
            if (list == null) continue;
            this.removeSpeedHandler(list, speedThresholdListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void registerStandStillListener(IStandStillListener iStandStillListener) {
        List list = this.standStillListeners;
        synchronized (list) {
            this.standStillListeners.add(iStandStillListener);
        }
        this.updateVehicleStandstill(this.sysApp.isStandstill(), 1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void unregisterStandStillListener(IStandStillListener iStandStillListener) {
        List list = this.standStillListeners;
        synchronized (list) {
            this.standStillListeners.remove(iStandStillListener);
        }
    }

    private synchronized void updateVelocityThreshold(String string, int n, boolean bl, int n2) {
        if (n2 == 1) {
            this.lc.log(-2137614336, "threshold update for %1", (Object)string);
            List list = this.getSpeedManagerList(n);
            this.currentThresholdValues[n] = bl;
            for (int i2 = 0; i2 < list.size(); ++i2) {
                GeneralVehicleStateHandler$SpeedHandler generalVehicleStateHandler$SpeedHandler = (GeneralVehicleStateHandler$SpeedHandler)list.get(i2);
                generalVehicleStateHandler$SpeedHandler.fireThreshold(n, bl);
            }
        } else {
            this.lc.log(-2137614336, "invalid threshold update for %1", (Object)string);
        }
    }

    void registerAudioService(HMIAudioService hMIAudioService) {
        this.lc.log(-2137614336, "[GeneralVehicleStateHandler.registerAudioService] %1", (Object)hMIAudioService);
        this.audioService = hMIAudioService;
    }

    void deregisterAudioService() {
        this.audioService = new NullHMIAudioService(this.lc);
    }

    @Override
    public void updateBrowserBordBookVelocityThreshold(boolean bl, int n) {
        this.updateVelocityThreshold("BrowserBordBookVelocityThreshold", 5, bl, n);
    }

    @Override
    public void updateBrowserSlideShowVelocityThreshold(boolean bl, int n) {
        this.updateVelocityThreshold("BrowserSlideShowVelocityThreshold", 4, bl, n);
    }

    @Override
    public void updateBrowserTravelAgentVelocityThreshold(boolean bl, int n) {
        this.updateVelocityThreshold("BrowserTravelAgentVelocityThreshold", 6, bl, n);
    }

    @Override
    public void updateBrowserWebVelocityThreshold(boolean bl, int n) {
        this.updateVelocityThreshold("BrowserWebVelocityThreshold", 7, bl, n);
    }

    @Override
    public void updateCarVelocityThreshold(boolean bl, int n) {
        this.updateVelocityThreshold("CarVelocityThreshold", 1, bl, n);
    }

    @Override
    public void updateHDDVelocityThreshold(boolean bl, int n) {
        this.updateVelocityThreshold("HDDVelocityThreshold", 3, bl, n);
    }

    @Override
    public void updateTVVelocityThreshold(boolean bl, int n) {
        this.updateVelocityThreshold("TVVelocityThreshold", 2, bl, n);
    }

    final void setSDSService(SDSService sDSService) {
        this.sdsService = sDSService;
        if (sDSService != null) {
            this.updateBlockPTT();
        }
    }

    private final void updateBlockPTT() {
        this.lc.log(1078071040, "[GeneralVehicleStateHandler.updateBlockPTT] block:%1", this.acousticParkingSystemActive);
        if (this.sdsService != null) {
            this.sdsService.disablePTT(this.acousticParkingSystemActive, true, (byte)9);
        } else {
            this.lc.log(-1601830656, "[GeneralVehicleStateHandler.updateBlockPTT] blockPTT: No SDS service available!");
        }
    }

    @Override
    public void updateAcousticParkingSystem(boolean bl, int n) {
        int n2 = n == 1 ? -2137614336 : -1601830656;
        this.lc.log(n2, "[GeneralVehicleStateHandler.updateAcousticParkingSystem] active:%1 valid:%2", bl, (long)n);
        if (n == 1) {
            if (!this.apsStatusKnown) {
                this.apsStatusKnown = true;
                this.sysApp.getFramework().getStartupMgr().logStartupEvent("[APS] first valid APS status update!");
            }
            this.acousticParkingSystemActive = bl;
            this.updateBlockPTT();
            this.updateAudioConnection();
        }
    }

    private void updateAudioConnection() {
        if (this.acousticParkingSystemActive) {
            this.audioService.requestConnection(4);
        } else {
            this.audioService.releaseConnection(4);
        }
    }

    @Override
    public void updateAirbagData(AirbagData airbagData, int n) {
    }

    @Override
    public void updateDimmedHeadlight(boolean bl, int n) {
    }

    @Override
    public void updateTankInfo(TankInfo tankInfo, int n) {
    }

    @Override
    public void updateDisplayDayNightDesign(boolean bl, int n) {
    }

    @Override
    public void updateBTBondingVelocityThreshold(boolean bl, int n) {
        this.updateVelocityThreshold("BTBondingThreshold", 10, bl, n);
    }

    @Override
    public void updateMessagingVelocityThreshold(boolean bl, int n) {
        this.updateVelocityThreshold("MessagingThreshold", 11, bl, n);
    }

    @Override
    public void updateDestinationInputVelocityThreshold(boolean bl, int n) {
        this.updateVelocityThreshold("DestinationInputThreshold", 12, bl, n);
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void updateBWSVelocityThreshold(boolean bl, int n) {
        this.updateVelocityThreshold("BWSVelocityThreshold", 8, bl, n);
    }

    @Override
    public void updateRadiotextVelocityThreshold(boolean bl, int n) {
        this.updateVelocityThreshold("RadiotextVelocityThreshold", 9, bl, n);
    }

    @Override
    public void updateReverseGear(boolean bl, int n) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateVehicleStandstill(boolean bl, int n) {
        this.lc.log(-2137614336, "[GeneralVehicleStateHandler.updateVehicleStandstill] standstill=%1, valid=%2", bl, (long)n);
        if (n == 1) {
            Object object;
            if (this.kbdService == null) {
                object = this.sysApp.getFramework().getBundleCxt().getServiceReference((class$de$audi$atip$hmi$KbdService == null ? (class$de$audi$atip$hmi$KbdService = GeneralVehicleStateHandler.class$("de.audi.atip.hmi.KbdService")) : class$de$audi$atip$hmi$KbdService).getName());
                this.kbdService = (KbdService)this.sysApp.getFramework().getBundleCxt().getService((ServiceReference)object);
            }
            if (this.kbdService != null && this.kbdService.isTouchKeypanel()) {
                this.kbdService.setGenericSetting(249, bl ? 0 : 1);
            }
            this.sysApp.setStandstill(bl);
            object = null;
            Object object2 = this.standStillListeners;
            synchronized (object2) {
                object = new ArrayList(this.standStillListeners);
            }
            object2 = object.iterator();
            while (object2.hasNext()) {
                IStandStillListener iStandStillListener = (IStandStillListener)object2.next();
                iStandStillListener.updateStandStill(bl);
            }
        }
    }

    @Override
    public void updateDSSSViewOption(CarViewOption carViewOption, int n) {
    }

    @Override
    public void notifyPowerListenerOnEnterState(int n, int n2) {
        this.sysApp.setPowerState(n);
    }

    @Override
    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    @Override
    public void notifyPowerTriggerAction(int n, int n2) {
    }

    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.updateClampAll(bl, bl2);
    }

    @Override
    public void updateServiceKeyData(byte[] byArray, int n) {
    }

    @Override
    public void updateServiceKeyViewOption(CarViewOption carViewOption, int n) {
    }

    @Override
    public void updatePersonalizationStatus(boolean bl, int n, int n2) {
    }

    @Override
    public void updateTLOViewOptions(TLOViewOptions tLOViewOptions, int n) {
    }

    @Override
    public void updateEmergencyAssistVolLowering(int n, int n2) {
    }

    @Override
    public void updateParkingBrake(boolean bl, int n) {
    }

    @Override
    public void updateSTPState(int n, int n2) {
    }

    @Override
    public void updateAutomaticGearShiftTransMode(int n, int n2) {
    }

    @Override
    public void updateAppConnectTrigger(int n, int n2) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ void access$400(GeneralVehicleStateHandler generalVehicleStateHandler) {
        generalVehicleStateHandler.updateAudioConnection();
    }

    static /* synthetic */ SysApp access$500(GeneralVehicleStateHandler generalVehicleStateHandler) {
        return generalVehicleStateHandler.sysApp;
    }

    static /* synthetic */ LogChannel access$600(GeneralVehicleStateHandler generalVehicleStateHandler) {
        return generalVehicleStateHandler.lc;
    }
}

