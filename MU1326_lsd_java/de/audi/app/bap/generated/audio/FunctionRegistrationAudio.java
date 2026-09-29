/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.audio;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.IFunctionRegistrationFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.fw.functiontypes.IBAPFunction;
import de.audi.app.bap.utils.FunctionIDs;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.generated.audiosd.serializer.ASG_Capabilities_SetGet;
import de.vw.mib.bap.generated.audiosd.serializer.ASG_Capabilities_Status;
import de.vw.mib.bap.generated.audiosd.serializer.ActiveSourceName_Status;
import de.vw.mib.bap.generated.audiosd.serializer.ActiveSource_Status;
import de.vw.mib.bap.generated.audiosd.serializer.AnnouncementEscape_Result;
import de.vw.mib.bap.generated.audiosd.serializer.AnnouncementInfo_Status;
import de.vw.mib.bap.generated.audiosd.serializer.BAP_Config_Reset;
import de.vw.mib.bap.generated.audiosd.serializer.BAP_Config_Status;
import de.vw.mib.bap.generated.audiosd.serializer.CommonList_ChangedArray;
import de.vw.mib.bap.generated.audiosd.serializer.CommonList_GetArray;
import de.vw.mib.bap.generated.audiosd.serializer.CommonList_StatusArray;
import de.vw.mib.bap.generated.audiosd.serializer.CurrentStationInfo_Status;
import de.vw.mib.bap.generated.audiosd.serializer.CurrentStation_Handle2_Status;
import de.vw.mib.bap.generated.audiosd.serializer.CurrentStation_Handle_Status;
import de.vw.mib.bap.generated.audiosd.serializer.CurrentVolumeExtended_SetGet;
import de.vw.mib.bap.generated.audiosd.serializer.CurrentVolumeExtended_Status;
import de.vw.mib.bap.generated.audiosd.serializer.CurrentVolume_Status;
import de.vw.mib.bap.generated.audiosd.serializer.CustomerDownloadState_Status;
import de.vw.mib.bap.generated.audiosd.serializer.DedicatedAudioControl_Result;
import de.vw.mib.bap.generated.audiosd.serializer.DedicatedAudioControl_StartResult;
import de.vw.mib.bap.generated.audiosd.serializer.FSG_OperationState_Status;
import de.vw.mib.bap.generated.audiosd.serializer.FSG_Setup_Status;
import de.vw.mib.bap.generated.audiosd.serializer.FunctionList_Status;
import de.vw.mib.bap.generated.audiosd.serializer.FunctionSynchronisation_Status;
import de.vw.mib.bap.generated.audiosd.serializer.GeneralInfoSwitches_SetGet;
import de.vw.mib.bap.generated.audiosd.serializer.GeneralInfoSwitches_Status;
import de.vw.mib.bap.generated.audiosd.serializer.GetNextListPos_Result;
import de.vw.mib.bap.generated.audiosd.serializer.GetNextListPos_StartResult;
import de.vw.mib.bap.generated.audiosd.serializer.InfoStates_Status;
import de.vw.mib.bap.generated.audiosd.serializer.MediaBrowserControl_Result;
import de.vw.mib.bap.generated.audiosd.serializer.MediaBrowserControl_StartResult;
import de.vw.mib.bap.generated.audiosd.serializer.MediaBrowser_ChangedArray;
import de.vw.mib.bap.generated.audiosd.serializer.MediaBrowser_FolderLevel_Status;
import de.vw.mib.bap.generated.audiosd.serializer.MediaBrowser_GetArray;
import de.vw.mib.bap.generated.audiosd.serializer.MediaBrowser_StatusArray;
import de.vw.mib.bap.generated.audiosd.serializer.MediaFileInfo_Result;
import de.vw.mib.bap.generated.audiosd.serializer.MediaFileInfo_StartResult;
import de.vw.mib.bap.generated.audiosd.serializer.MediaImportState_Status;
import de.vw.mib.bap.generated.audiosd.serializer.MediaPath_Status;
import de.vw.mib.bap.generated.audiosd.serializer.Mute_SetGet;
import de.vw.mib.bap.generated.audiosd.serializer.Mute_Status;
import de.vw.mib.bap.generated.audiosd.serializer.OnlineMusic_State_Status;
import de.vw.mib.bap.generated.audiosd.serializer.PlayPosition_Status;
import de.vw.mib.bap.generated.audiosd.serializer.PreferredList_SetGet;
import de.vw.mib.bap.generated.audiosd.serializer.PreferredList_Status;
import de.vw.mib.bap.generated.audiosd.serializer.RadioTV_PresetList_ChangedArray;
import de.vw.mib.bap.generated.audiosd.serializer.RadioTV_PresetList_GetArray;
import de.vw.mib.bap.generated.audiosd.serializer.RadioTV_PresetList_StatusArray;
import de.vw.mib.bap.generated.audiosd.serializer.ReceptionListType_Status;
import de.vw.mib.bap.generated.audiosd.serializer.ReceptionList_ChangedArray;
import de.vw.mib.bap.generated.audiosd.serializer.ReceptionList_GetArray;
import de.vw.mib.bap.generated.audiosd.serializer.ReceptionList_StatusArray;
import de.vw.mib.bap.generated.audiosd.serializer.SDS_State_SetGet;
import de.vw.mib.bap.generated.audiosd.serializer.SDS_State_Status;
import de.vw.mib.bap.generated.audiosd.serializer.SourceList_ChangedArray;
import de.vw.mib.bap.generated.audiosd.serializer.SourceList_GetArray;
import de.vw.mib.bap.generated.audiosd.serializer.SourceList_StatusArray;
import de.vw.mib.bap.generated.audiosd.serializer.SourceState_SetGet;
import de.vw.mib.bap.generated.audiosd.serializer.SourceState_Status;
import de.vw.mib.bap.generated.audiosd.serializer.SwitchRadioMedia_Result;
import de.vw.mib.bap.generated.audiosd.serializer.SwitchRadioMedia_StartResult;
import de.vw.mib.bap.generated.audiosd.serializer.SwitchSource_Result;
import de.vw.mib.bap.generated.audiosd.serializer.SwitchSource_StartResult;
import de.vw.mib.bap.generated.audiosd.serializer.TpMemoInfo_Status;
import de.vw.mib.bap.generated.audiosd.serializer.TpMemoList_ChangedArray;
import de.vw.mib.bap.generated.audiosd.serializer.TpMemoList_GetArray;
import de.vw.mib.bap.generated.audiosd.serializer.TpMemoList_StatusArray;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.requests.StatusAckProperty;
import de.vw.mib.bap.requests.StatusArray;
import de.vw.mib.bap.requests.StatusProperty;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class FunctionRegistrationAudio
implements IFunctionRegistrationFSG {
    private BAPFunctionPropertyFSG bapConfig;
    private BAPFunctionPropertyFSG functionList;
    private BAPFunctionPropertyFSG fsgSetup;
    private BAPFunctionPropertyFSG fsgOperationState;
    private BAPFunctionPropertyFSG activeSource;
    private BAPFunctionPropertyFSG activeSourceName;
    private BAPFunctionPropertyFSG currentVolume;
    private BAPFunctionPropertyFSG mute;
    private BAPFunctionPropertyFSG sourceState;
    private BAPFunctionPropertyFSG currentStationInfo;
    private BAPFunctionPropertyFSG currentStationHandle;
    private BAPFunctionArrayFSG receptionList;
    private BAPFunctionMethodFSG dedicatedAudioControl;
    private BAPFunctionPropertyFSG generalInfoSwitches;
    private BAPFunctionPropertyFSG tpMemoInfo;
    private BAPFunctionArrayFSG tpMemoList;
    private BAPFunctionPropertyFSG announcementInfo;
    private BAPFunctionMethodFSG announcementEscape;
    private BAPFunctionPropertyFSG infoStates;
    private BAPFunctionPropertyFSG receptionListType;
    private BAPFunctionArrayFSG sourceList;
    private BAPFunctionArrayFSG radioTvPresetList;
    private BAPFunctionMethodFSG switchSource;
    private BAPFunctionPropertyFSG mediaBrowserFolderLevel;
    private BAPFunctionArrayFSG mediaBrowser;
    private BAPFunctionPropertyFSG mediaPath;
    private BAPFunctionMethodFSG mediaBrowserControl;
    private BAPFunctionMethodFSG mediaFileInfo;
    private BAPFunctionPropertyFSG preferredList;
    private BAPFunctionPropertyFSG sdsState;
    private BAPFunctionPropertyFSG functionSynchronisation;
    private BAPFunctionPropertyFSG asgCapabilities;
    private BAPFunctionMethodFSG getNextListPos;
    private BAPFunctionMethodFSG switchRadioMedia;
    private BAPFunctionPropertyFSG mediaImportState;
    private BAPFunctionPropertyFSG currentVolumeExtended;
    private BAPFunctionPropertyFSG customerDownloadState;
    private BAPFunctionPropertyFSG onlineMusicState;
    private BAPFunctionArrayFSG commonList;
    private BAPFunctionPropertyFSG currentStationHandle2;
    private BAPFunctionPropertyFSG playPosition;
    private boolean initialized = false;
    private final LogChannel logChannel;
    private final List allProperties = new ArrayList(28);
    private final List allMethods = new ArrayList(7);
    private final List allArrays = new ArrayList(6);

    public FunctionRegistrationAudio(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.logChannel = abstractBAPModuleFSG.getLogChannel();
        this.initialize(abstractBAPModuleFSG);
    }

    private void initialize(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.logChannel.log(-2137614336, "[FunctionRegistrationAudio#initialize] start initialization");
        this.initializeProperties(abstractBAPModuleFSG);
        this.initializeMethods(abstractBAPModuleFSG);
        this.initializeArrays(abstractBAPModuleFSG);
        this.initialized = true;
        this.logChannel.log(-2137614336, "[FunctionRegistrationAudio#initialize] initialization completed");
    }

    private void initializeProperties(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.logChannel.log(-2137614336, "[FunctionRegistrationAudio#initializeProperties] initialize properties");
        this.bapConfig = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(2);
        this.bapConfig.setResetSerializer(new BAP_Config_Reset());
        this.allProperties.add(this.bapConfig);
        this.functionList = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(3);
        this.allProperties.add(this.functionList);
        this.fsgSetup = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(14);
        this.allProperties.add(this.fsgSetup);
        this.fsgOperationState = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(15);
        this.allProperties.add(this.fsgOperationState);
        this.activeSource = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(16);
        this.allProperties.add(this.activeSource);
        this.activeSourceName = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(17);
        this.allProperties.add(this.activeSourceName);
        this.currentVolume = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(18);
        this.allProperties.add(this.currentVolume);
        this.mute = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(19);
        this.mute.setSetGetSerializer(new Mute_SetGet());
        this.allProperties.add(this.mute);
        this.sourceState = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(20);
        this.sourceState.setSetGetSerializer(new SourceState_SetGet());
        this.allProperties.add(this.sourceState);
        this.currentStationInfo = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(21);
        this.allProperties.add(this.currentStationInfo);
        this.currentStationHandle = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(22);
        this.allProperties.add(this.currentStationHandle);
        this.generalInfoSwitches = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(25);
        this.generalInfoSwitches.setSetGetSerializer(new GeneralInfoSwitches_SetGet());
        this.allProperties.add(this.generalInfoSwitches);
        this.tpMemoInfo = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(26);
        this.allProperties.add(this.tpMemoInfo);
        this.announcementInfo = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(28);
        this.allProperties.add(this.announcementInfo);
        this.infoStates = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(30);
        this.allProperties.add(this.infoStates);
        this.receptionListType = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(31);
        this.allProperties.add(this.receptionListType);
        this.mediaBrowserFolderLevel = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(35);
        this.allProperties.add(this.mediaBrowserFolderLevel);
        this.mediaPath = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(37);
        this.allProperties.add(this.mediaPath);
        this.preferredList = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(40);
        this.preferredList.setSetGetSerializer(new PreferredList_SetGet());
        this.allProperties.add(this.preferredList);
        this.sdsState = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(41);
        this.sdsState.setSetGetSerializer(new SDS_State_SetGet());
        this.allProperties.add(this.sdsState);
        this.functionSynchronisation = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(42);
        this.allProperties.add(this.functionSynchronisation);
        this.asgCapabilities = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(43);
        this.asgCapabilities.setSetGetSerializer(new ASG_Capabilities_SetGet());
        this.allProperties.add(this.asgCapabilities);
        this.mediaImportState = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(46);
        this.allProperties.add(this.mediaImportState);
        this.currentVolumeExtended = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(47);
        this.currentVolumeExtended.setSetGetSerializer(new CurrentVolumeExtended_SetGet());
        this.allProperties.add(this.currentVolumeExtended);
        this.customerDownloadState = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(48);
        this.allProperties.add(this.customerDownloadState);
        this.onlineMusicState = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(49);
        this.allProperties.add(this.onlineMusicState);
        this.currentStationHandle2 = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(51);
        this.allProperties.add(this.currentStationHandle2);
        this.playPosition = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(52);
        this.allProperties.add(this.playPosition);
    }

    private void initializeMethods(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.logChannel.log(-2137614336, "[FunctionRegistrationAudio#initializeMethods] initialize methods");
        this.dedicatedAudioControl = abstractBAPModuleFSG.createBAPFunctionMethodFSG(24);
        this.dedicatedAudioControl.setStartResultSerializer(new DedicatedAudioControl_StartResult());
        this.allMethods.add(this.dedicatedAudioControl);
        this.announcementEscape = abstractBAPModuleFSG.createBAPFunctionMethodFSG(29);
        this.allMethods.add(this.announcementEscape);
        this.switchSource = abstractBAPModuleFSG.createBAPFunctionMethodFSG(34);
        this.switchSource.setStartResultSerializer(new SwitchSource_StartResult());
        this.allMethods.add(this.switchSource);
        this.mediaBrowserControl = abstractBAPModuleFSG.createBAPFunctionMethodFSG(38);
        this.mediaBrowserControl.setStartResultSerializer(new MediaBrowserControl_StartResult());
        this.allMethods.add(this.mediaBrowserControl);
        this.mediaFileInfo = abstractBAPModuleFSG.createBAPFunctionMethodFSG(39);
        this.mediaFileInfo.setStartResultSerializer(new MediaFileInfo_StartResult());
        this.allMethods.add(this.mediaFileInfo);
        this.getNextListPos = abstractBAPModuleFSG.createBAPFunctionMethodFSG(44);
        this.getNextListPos.setStartResultSerializer(new GetNextListPos_StartResult());
        this.allMethods.add(this.getNextListPos);
        this.switchRadioMedia = abstractBAPModuleFSG.createBAPFunctionMethodFSG(45);
        this.switchRadioMedia.setStartResultSerializer(new SwitchRadioMedia_StartResult());
        this.allMethods.add(this.switchRadioMedia);
    }

    private void initializeArrays(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.logChannel.log(-2137614336, "[FunctionRegistrationAudio#initializeArrays] initialize arrays");
        this.receptionList = abstractBAPModuleFSG.createBAPFunctionArrayFSG(23);
        this.receptionList.setGetArraySerializer(new ReceptionList_GetArray());
        this.allArrays.add(this.receptionList);
        this.tpMemoList = abstractBAPModuleFSG.createBAPFunctionArrayFSG(27);
        this.tpMemoList.setGetArraySerializer(new TpMemoList_GetArray());
        this.allArrays.add(this.tpMemoList);
        this.sourceList = abstractBAPModuleFSG.createBAPFunctionArrayFSG(32);
        this.sourceList.setGetArraySerializer(new SourceList_GetArray());
        this.allArrays.add(this.sourceList);
        this.radioTvPresetList = abstractBAPModuleFSG.createBAPFunctionArrayFSG(33);
        this.radioTvPresetList.setGetArraySerializer(new RadioTV_PresetList_GetArray());
        this.allArrays.add(this.radioTvPresetList);
        this.mediaBrowser = abstractBAPModuleFSG.createBAPFunctionArrayFSG(36);
        this.mediaBrowser.setGetArraySerializer(new MediaBrowser_GetArray());
        this.allArrays.add(this.mediaBrowser);
        this.commonList = abstractBAPModuleFSG.createBAPFunctionArrayFSG(50);
        this.commonList.setGetArraySerializer(new CommonList_GetArray());
        this.allArrays.add(this.commonList);
    }

    @Override
    public BAPFunctionMethodFSG getBAPFunctionMethodFSG(int n) {
        try {
            return (BAPFunctionMethodFSG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationAudio#getBAPFunctionMethod] function is not of type 'Method': fctID=%1", (Object)FunctionIDs.getDescription(49, n));
            return null;
        }
    }

    @Override
    public BAPFunctionPropertyFSG getBAPFunctionPropertyFSG(int n) {
        try {
            return (BAPFunctionPropertyFSG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationAudio#getBAPFunctionProperty] function is not of type 'Property': fctID=%1", (Object)FunctionIDs.getDescription(49, n));
            return null;
        }
    }

    @Override
    public BAPFunctionArrayFSG getBAPFunctionArrayFSG(int n) {
        try {
            return (BAPFunctionArrayFSG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationAudio#getBAPFunctionArray] function is not of type 'Array': fctID=%1", (Object)FunctionIDs.getDescription(49, n));
            return null;
        }
    }

    @Override
    public IBAPFunction getBAPFunction(int n) {
        if (!this.initialized) {
            this.logChannel.log(10000, "[FunctionRegistrationAudio#getBAPFunction] function registration not initialized yet for lsgID=%1", (Object)LSGIDs.getDescription(49), (long)n);
        }
        switch (n) {
            case 2: {
                return this.bapConfig;
            }
            case 3: {
                return this.functionList;
            }
            case 14: {
                return this.fsgSetup;
            }
            case 15: {
                return this.fsgOperationState;
            }
            case 16: {
                return this.activeSource;
            }
            case 17: {
                return this.activeSourceName;
            }
            case 18: {
                return this.currentVolume;
            }
            case 19: {
                return this.mute;
            }
            case 20: {
                return this.sourceState;
            }
            case 21: {
                return this.currentStationInfo;
            }
            case 22: {
                return this.currentStationHandle;
            }
            case 23: {
                return this.receptionList;
            }
            case 24: {
                return this.dedicatedAudioControl;
            }
            case 25: {
                return this.generalInfoSwitches;
            }
            case 26: {
                return this.tpMemoInfo;
            }
            case 27: {
                return this.tpMemoList;
            }
            case 28: {
                return this.announcementInfo;
            }
            case 29: {
                return this.announcementEscape;
            }
            case 30: {
                return this.infoStates;
            }
            case 31: {
                return this.receptionListType;
            }
            case 32: {
                return this.sourceList;
            }
            case 33: {
                return this.radioTvPresetList;
            }
            case 34: {
                return this.switchSource;
            }
            case 35: {
                return this.mediaBrowserFolderLevel;
            }
            case 36: {
                return this.mediaBrowser;
            }
            case 37: {
                return this.mediaPath;
            }
            case 38: {
                return this.mediaBrowserControl;
            }
            case 39: {
                return this.mediaFileInfo;
            }
            case 40: {
                return this.preferredList;
            }
            case 41: {
                return this.sdsState;
            }
            case 42: {
                return this.functionSynchronisation;
            }
            case 43: {
                return this.asgCapabilities;
            }
            case 44: {
                return this.getNextListPos;
            }
            case 45: {
                return this.switchRadioMedia;
            }
            case 46: {
                return this.mediaImportState;
            }
            case 47: {
                return this.currentVolumeExtended;
            }
            case 48: {
                return this.customerDownloadState;
            }
            case 49: {
                return this.onlineMusicState;
            }
            case 50: {
                return this.commonList;
            }
            case 51: {
                return this.currentStationHandle2;
            }
            case 52: {
                return this.playPosition;
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationAudio#getBAPFunction] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(49), (Object)FunctionIDs.getDescription(49, n));
        return null;
    }

    @Override
    public List getAllProperties() {
        return this.allProperties;
    }

    @Override
    public List getAllMethods() {
        return this.allMethods;
    }

    @Override
    public List getAllArrays() {
        return this.allArrays;
    }

    @Override
    public void resetBAPFunctions() {
        this.logChannel.log(-2137614336, "[FunctionRegistrationAudio#resetBAPFunctions]");
        Iterator iterator = this.allArrays.iterator();
        while (iterator.hasNext()) {
            ((IBAPFunction)iterator.next()).reset();
        }
        iterator = this.allProperties.iterator();
        while (iterator.hasNext()) {
            ((IBAPFunction)iterator.next()).reset();
        }
        iterator = this.allMethods.iterator();
        while (iterator.hasNext()) {
            ((IBAPFunction)iterator.next()).reset();
        }
    }

    @Override
    public ResultMethod createResultForMethodFSG(int n) {
        switch (n) {
            case 24: {
                return new DedicatedAudioControl_Result();
            }
            case 29: {
                return new AnnouncementEscape_Result();
            }
            case 34: {
                return new SwitchSource_Result();
            }
            case 38: {
                return new MediaBrowserControl_Result();
            }
            case 39: {
                return new MediaFileInfo_Result();
            }
            case 44: {
                return new GetNextListPos_Result();
            }
            case 45: {
                return new SwitchRadioMedia_Result();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationAudio#createResultForMethodFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(49), (Object)FunctionIDs.getDescription(49, n));
        return null;
    }

    @Override
    public StatusProperty createStatusForPropertyFSG(int n) {
        switch (n) {
            case 2: {
                return new BAP_Config_Status();
            }
            case 3: {
                return new FunctionList_Status();
            }
            case 14: {
                return new FSG_Setup_Status();
            }
            case 15: {
                return new FSG_OperationState_Status();
            }
            case 16: {
                return new ActiveSource_Status();
            }
            case 17: {
                return new ActiveSourceName_Status();
            }
            case 18: {
                return new CurrentVolume_Status();
            }
            case 19: {
                return new Mute_Status();
            }
            case 20: {
                return new SourceState_Status();
            }
            case 21: {
                return new CurrentStationInfo_Status();
            }
            case 22: {
                return new CurrentStation_Handle_Status();
            }
            case 25: {
                return new GeneralInfoSwitches_Status();
            }
            case 26: {
                return new TpMemoInfo_Status();
            }
            case 28: {
                return new AnnouncementInfo_Status();
            }
            case 30: {
                return new InfoStates_Status();
            }
            case 31: {
                return new ReceptionListType_Status();
            }
            case 35: {
                return new MediaBrowser_FolderLevel_Status();
            }
            case 37: {
                return new MediaPath_Status();
            }
            case 40: {
                return new PreferredList_Status();
            }
            case 41: {
                return new SDS_State_Status();
            }
            case 42: {
                return new FunctionSynchronisation_Status();
            }
            case 43: {
                return new ASG_Capabilities_Status();
            }
            case 46: {
                return new MediaImportState_Status();
            }
            case 47: {
                return new CurrentVolumeExtended_Status();
            }
            case 48: {
                return new CustomerDownloadState_Status();
            }
            case 49: {
                return new OnlineMusic_State_Status();
            }
            case 51: {
                return new CurrentStation_Handle2_Status();
            }
            case 52: {
                return new PlayPosition_Status();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationAudio#createStatusForPropertyFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(49), (Object)FunctionIDs.getDescription(49, n));
        return null;
    }

    @Override
    public StatusAckProperty createStatusAckForPropertyFSG(int n) {
        switch (n) {
            default: 
        }
        this.logChannel.log(10000, "[FunctionRegistrationAudio#createStatusAckForPropertyFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(49), (Object)FunctionIDs.getDescription(49, n));
        return null;
    }

    @Override
    public StatusArray createStatusArrayForArrayFSG(int n) {
        switch (n) {
            case 23: {
                return new ReceptionList_StatusArray();
            }
            case 27: {
                return new TpMemoList_StatusArray();
            }
            case 32: {
                return new SourceList_StatusArray();
            }
            case 33: {
                return new RadioTV_PresetList_StatusArray();
            }
            case 36: {
                return new MediaBrowser_StatusArray();
            }
            case 50: {
                return new CommonList_StatusArray();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationAudio#createStatusArrayForArrayFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(49), (Object)FunctionIDs.getDescription(49, n));
        return null;
    }

    @Override
    public ChangedArray createChangedArrayForArrayFSG(int n) {
        switch (n) {
            case 23: {
                return new ReceptionList_ChangedArray();
            }
            case 27: {
                return new TpMemoList_ChangedArray();
            }
            case 32: {
                return new SourceList_ChangedArray();
            }
            case 33: {
                return new RadioTV_PresetList_ChangedArray();
            }
            case 36: {
                return new MediaBrowser_ChangedArray();
            }
            case 50: {
                return new CommonList_ChangedArray();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationAudio#createChangedArrayForArrayFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(49), (Object)FunctionIDs.getDescription(49, n));
        return null;
    }
}

