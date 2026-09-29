/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.combi.CombiDiagnosisConnectorAudio
 */
package de.audi.app.combi.bap.app.audio;

import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.fw.IBAPFunctionFactoryFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.fw.request.IDataTypeMapping;
import de.audi.app.bap.generated.audio.DataTypeMappingAudio;
import de.audi.app.bap.generated.audio.ErrorCodesAudio;
import de.audi.app.bap.generated.audio.FunctionIDsAudio;
import de.audi.app.bap.generated.audio.FunctionRegistrationAudio;
import de.audi.app.bap.utils.IErrorCodes;
import de.audi.app.bap.utils.IFunctionIDs;
import de.audi.app.combi.bap.AbstractCombiBAPApplication;
import de.audi.app.combi.bap.app.audio.AbstractFunctionListAudio;
import de.audi.app.combi.bap.app.audio.AppConnectorMedia;
import de.audi.app.combi.bap.app.audio.AppConnectorTV;
import de.audi.app.combi.bap.app.audio.AppConnectorTerminalMode;
import de.audi.app.combi.bap.app.audio.AppConnectorTone;
import de.audi.app.combi.bap.app.audio.AppConnectorTuner;
import de.audi.app.combi.bap.app.audio.AudioApplicationInFocusHandler;
import de.audi.app.combi.bap.app.audio.BAPIndicationHandlerAudio;
import de.audi.app.combi.bap.app.audio.BAPPropertyInfoStatesWithOverCurrentSupport;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio$1;
import de.audi.app.combi.bap.app.audio.DedicatedAudioControlHandler;
import de.audi.app.combi.bap.app.audio.InitializationManagerAudio;
import de.audi.app.combi.bap.app.audio.ServiceManagerAudio;
import de.audi.app.combi.bap.app.audio.functionsync.FunctionSynchronizationHandlerAudio;
import de.audi.app.combi.bap.app.audio.info.AppConnectorInfo;
import de.audi.app.combi.bap.app.audio.list.ListManagerAudio;
import de.audi.app.combi.bap.app.audio.sds.AppConnectorSDS;
import de.audi.app.combi.bap.app.audio.system.AppConnectorSystem;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.atip.interapp.ExternalKeyListener;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceInfo;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceInfoListener;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceMedia;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceMediaListener;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceSDS;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceSystem;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTV;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTVListener;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTerminalMode;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTerminalModeListener;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTone;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceToneListener;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTuner;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTunerListener;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import de.audi.atip.timer.Timer;
import de.mib.swdiagnosis.combi.CombiDiagnosisConnectorAudio;
import de.vw.mib.bap.generated.audiosd.serializer.InfoStates_Status;
import de.vw.mib.bap.generated.audiosd.serializer.SDS_State_Status;
import org.osgi.framework.BundleContext;

public class CombiModuleAudio
extends AbstractCombiModule
implements MsgListener {
    private final CombiBAPAudioSource previousActiveSource = CombiModuleAudio.getDefaultSource();
    private static final int[] ERROR_MAPPING = new int[10];
    private boolean firstScreenShown = false;
    private final AppConnectorMedia appConnectorMedia;
    private final AppConnectorTuner appConnectorTuner;
    private final AppConnectorTV appConnectorTV;
    private final AppConnectorTerminalMode appConnectorTerminalMode;
    private final AppConnectorTone appConnectorTone;
    private final AppConnectorSDS appConnectorSDS;
    private final AppConnectorInfo appConnectorInfo;
    private final AppConnectorSystem appConnectorSystem;
    private final DedicatedAudioControlHandler dedicatedAudioControlHandler;
    private final AudioApplicationInFocusHandler activeAudioApplicationHandler;
    private ExternalKeyListener externKeyListener;
    private static final int TIMEOUT_TEMP_SDS_STATE;
    private int tempSDSStateOldState;
    private final Timer tempSDSStateTimer;
    private final BAPPropertyInfoStatesWithOverCurrentSupport infoStatesFunctionWithOverCurrentSupport = new BAPPropertyInfoStatesWithOverCurrentSupport(this, this.getBAPFunctionPropertyFSG(30));

    public static CombiBAPAudioSource getDefaultSource() {
        return new CombiBAPAudioSource(0, 0, 0, 255, "");
    }

    public CombiModuleAudio(AbstractCombiBAPApplication abstractCombiBAPApplication, AbstractFunctionListAudio abstractFunctionListAudio) {
        this(abstractCombiBAPApplication, abstractFunctionListAudio, null);
    }

    public CombiModuleAudio(AbstractCombiBAPApplication abstractCombiBAPApplication, AbstractFunctionListAudio abstractFunctionListAudio, IBAPFunctionFactoryFSG iBAPFunctionFactoryFSG) {
        super(49, (AbstractBAPApplication)abstractCombiBAPApplication, iBAPFunctionFactoryFSG);
        this.functionListFsg = abstractFunctionListAudio;
        this.functionListFsg.init(this);
        this.activeAudioApplicationHandler = new AudioApplicationInFocusHandler(this.logChannel);
        this.activeAudioApplicationHandler.addObserver((InitializationManagerAudio)this.initializationManager);
        this.dedicatedAudioControlHandler = new DedicatedAudioControlHandler(this);
        this.appConnectorMedia = new AppConnectorMedia(this);
        this.addAppConnector("Media", this.appConnectorMedia);
        this.appConnectorTuner = new AppConnectorTuner(this);
        this.addAppConnector("Tuner", this.appConnectorTuner);
        this.appConnectorTV = new AppConnectorTV(this);
        this.addAppConnector("TV", this.appConnectorTV);
        this.appConnectorTerminalMode = new AppConnectorTerminalMode(this);
        this.addAppConnector("TerminalMode", this.appConnectorTerminalMode);
        this.appConnectorTone = new AppConnectorTone(this);
        this.addAppConnector("Tone", this.appConnectorTone);
        this.appConnectorSDS = new AppConnectorSDS(this);
        this.addAppConnector("SDSManager", this.appConnectorSDS);
        this.appConnectorInfo = new AppConnectorInfo(this);
        this.addAppConnector("Info", this.appConnectorInfo);
        this.appConnectorSystem = new AppConnectorSystem(this);
        this.addAppConnector("System", this.appConnectorSystem);
        this.getBAPFunctionMethodFSG(24).setConcurrentOperationMode(1);
        this.listManager = new ListManagerAudio(this, abstractCombiBAPApplication.isMOSTListSupported());
        this.appConnectorSDS.updateSDSState(1);
        this.tempSDSStateTimer = new Timer("tempSDSStateTimer", 5, this.logChannel, new CombiModuleAudio$1(this), 0, true);
    }

    @Override
    protected void initModuleComponents() {
        this.logChannel.log(-2137614336, "[CombiModuleAudio#initModuleComponents]");
        this.indicationHandler = new BAPIndicationHandlerAudio(this);
        this.functionRegistration = new FunctionRegistrationAudio(this);
        this.initializationManager = new InitializationManagerAudio(this, this.getBAPFunctionPropertyFSG(15), this.bapApplication.getDSIBAPController(), this.bapApplication.getPowerState());
        this.functionSyncHandler = new FunctionSynchronizationHandlerAudio(this);
    }

    @Override
    protected void initServiceManager(BundleContext bundleContext) {
        this.serviceManager = new ServiceManagerAudio(this, bundleContext);
    }

    @Override
    protected void initDiagnosisConnector() {
        this.diagnosisConnectorFsg = new CombiDiagnosisConnectorAudio((AbstractCombiBAPApplication)this.bapApplication, this);
    }

    public CombiBAPAudioSource getPreviousActiveSource() {
        return this.previousActiveSource;
    }

    @Override
    public String getLSGDescription() {
        return "0x31 (AUDIO)";
    }

    @Override
    public IFunctionIDs getFunctionIDs() {
        return new FunctionIDsAudio();
    }

    @Override
    public IErrorCodes getErrorIDs() {
        return new ErrorCodesAudio();
    }

    @Override
    public int[] getErrorMapping() {
        return ERROR_MAPPING;
    }

    @Override
    public IDataTypeMapping getDataTypeMapping() {
        return new DataTypeMappingAudio();
    }

    public CombiBAPServiceMedia getMediaService() {
        return this.appConnectorMedia;
    }

    public CombiBAPServiceMediaListener getMediaServiceListener() {
        return (CombiBAPServiceMediaListener)this.appConnectorMedia.getAppServiceListener();
    }

    public CombiBAPServiceTuner getTunerService() {
        return this.appConnectorTuner;
    }

    public CombiBAPServiceTunerListener getTunerServiceListener() {
        return (CombiBAPServiceTunerListener)this.appConnectorTuner.getAppServiceListener();
    }

    public CombiBAPServiceTV getTVService() {
        return this.appConnectorTV;
    }

    public CombiBAPServiceTVListener getTVServiceListener() {
        return (CombiBAPServiceTVListener)this.appConnectorTV.getAppServiceListener();
    }

    public CombiBAPServiceTerminalMode getTerminalModeService() {
        return this.appConnectorTerminalMode;
    }

    public CombiBAPServiceTerminalModeListener getTerminalModeServiceListener() {
        return (CombiBAPServiceTerminalModeListener)this.appConnectorTerminalMode.getAppServiceListener();
    }

    public CombiBAPServiceTone getToneService() {
        return this.appConnectorTone;
    }

    public CombiBAPServiceToneListener getToneServiceListener() {
        return (CombiBAPServiceToneListener)this.appConnectorTone.getAppServiceListener();
    }

    public CombiBAPServiceSDS getSDSService() {
        return this.appConnectorSDS;
    }

    public CombiBAPServiceInfo getInfoService() {
        return this.appConnectorInfo;
    }

    public CombiBAPServiceInfoListener getInfoServiceListener() {
        return (CombiBAPServiceInfoListener)this.appConnectorInfo.getAppServiceListener();
    }

    public CombiBAPServiceSystem getSystemService() {
        return this.appConnectorSystem;
    }

    public ExternalKeyListener getExternalKeyListener() {
        return this.externKeyListener;
    }

    public void setExternalKeyListener(ExternalKeyListener externalKeyListener) {
        this.externKeyListener = externalKeyListener;
    }

    public DedicatedAudioControlHandler getDedicatedAudioControlHandler() {
        return this.dedicatedAudioControlHandler;
    }

    public AudioApplicationInFocusHandler getAudioApplicationFocusHandler() {
        return this.activeAudioApplicationHandler;
    }

    public boolean isFirstScreenShown() {
        return this.firstScreenShown;
    }

    @Override
    protected boolean isRelevantForUpdateProperties(int n) {
        if (n == 43) {
            return false;
        }
        return super.isRelevantForUpdateProperties(n);
    }

    @Override
    public void processMsg(int n) {
        if (n == 2 && !this.firstScreenShown) {
            this.logChannel.log(-2137614336, "[CombiModuleAudio#processMsg] first screen shown");
            this.firstScreenShown = true;
            this.initializationManager.updateOperationState();
        } else if (n == 58) {
            if (!((InitializationManagerAudio)this.initializationManager).isSDSAvailable()) {
                this.setTempSDSState(8);
            } else if (((InitializationManagerAudio)this.initializationManager).isSDSInitalizing()) {
                this.setTempSDSState(2);
            }
        } else if (n == 43) {
            this.appConnectorMedia.updateActiveInfoState(30);
            this.appConnectorTuner.updateActiveInfoState(30);
            this.appConnectorTV.updateActiveInfoState(30);
            this.appConnectorTerminalMode.updateActiveInfoState(30);
        } else if (n == 44) {
            this.appConnectorMedia.restoreInfoState(30);
            this.appConnectorTuner.restoreInfoState(30);
            this.appConnectorTV.restoreInfoState(30);
            this.appConnectorTerminalMode.restoreInfoState(30);
        } else if (n == 8 || n == 5 || n == 6) {
            if (this.getFrameworkAccess().getSysApp().isEngineeringDownloadActive()) {
                this.appConnectorMedia.updateActiveInfoState(31);
                this.appConnectorTuner.updateActiveInfoState(31);
                this.appConnectorTV.updateActiveInfoState(31);
                this.appConnectorTerminalMode.updateActiveInfoState(31);
            }
        } else if ((n == 9 || n == 7) && this.getFrameworkAccess().getSysApp().isEngineeringDownloadActive()) {
            this.appConnectorMedia.restoreInfoState(31);
            this.appConnectorTuner.restoreInfoState(31);
            this.appConnectorTV.restoreInfoState(31);
            this.appConnectorTerminalMode.restoreInfoState(31);
        }
    }

    public void statusREQInfoStates(InfoStates_Status infoStates_Status) {
        this.infoStatesFunctionWithOverCurrentSupport.statusREQ(infoStates_Status);
    }

    private void setTempSDSState(int n) {
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.getBAPFunctionPropertyFSG(41);
        SDS_State_Status sDS_State_Status = (SDS_State_Status)bAPFunctionPropertyFSG.getLastStatus();
        if (sDS_State_Status.state == n) {
            this.logChannel.log(-2137614336, "[CombiModuleAudio#setTempSDSState] temp SDS state=%1 already set -> ignore", (long)n);
        } else {
            this.logChannel.log(-2137614336, "[CombiModuleAudio#setTempSDSState] state=%1", (long)n);
            this.tempSDSStateOldState = sDS_State_Status.state;
            this.appConnectorSDS.updateSDSState(n);
        }
        this.tempSDSStateTimer.restart();
    }

    @Override
    public void notifyPowerStateChanged() {
        super.notifyPowerStateChanged();
        if (!this.bapApplication.getPowerState().isPowerOn()) {
            this.appConnectorMedia.updateActiveInfoState(26);
            this.appConnectorTuner.updateActiveInfoState(26);
        } else {
            this.appConnectorMedia.restoreInfoState(26);
            this.appConnectorTuner.restoreInfoState(26);
        }
    }

    static /* synthetic */ Timer access$000(CombiModuleAudio combiModuleAudio) {
        return combiModuleAudio.tempSDSStateTimer;
    }

    static /* synthetic */ int access$100(CombiModuleAudio combiModuleAudio) {
        return combiModuleAudio.tempSDSStateOldState;
    }

    static /* synthetic */ LogChannel access$200(CombiModuleAudio combiModuleAudio) {
        return combiModuleAudio.logChannel;
    }

    static /* synthetic */ AppConnectorSDS access$300(CombiModuleAudio combiModuleAudio) {
        return combiModuleAudio.appConnectorSDS;
    }

    static {
        CombiModuleAudio.ERROR_MAPPING[0] = 65;
        CombiModuleAudio.ERROR_MAPPING[1] = 65;
        CombiModuleAudio.ERROR_MAPPING[2] = 65;
        CombiModuleAudio.ERROR_MAPPING[3] = 80;
        CombiModuleAudio.ERROR_MAPPING[4] = 65;
        CombiModuleAudio.ERROR_MAPPING[5] = 65;
        CombiModuleAudio.ERROR_MAPPING[6] = 66;
        CombiModuleAudio.ERROR_MAPPING[7] = 65;
        CombiModuleAudio.ERROR_MAPPING[8] = 34;
        CombiModuleAudio.ERROR_MAPPING[9] = 67;
    }
}

