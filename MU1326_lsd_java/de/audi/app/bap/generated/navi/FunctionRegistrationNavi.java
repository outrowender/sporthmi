/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.navi;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.IFunctionRegistrationFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.fw.functiontypes.IBAPFunction;
import de.audi.app.bap.utils.FunctionIDs;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.generated.navsd.serializer.ASG_Capabilities_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.ASG_Capabilities_Status;
import de.vw.mib.bap.generated.navsd.serializer.ActiveRgType_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.ActiveRgType_Status;
import de.vw.mib.bap.generated.navsd.serializer.Address_List_ChangedArray;
import de.vw.mib.bap.generated.navsd.serializer.Address_List_GetArray;
import de.vw.mib.bap.generated.navsd.serializer.Address_List_StatusArray;
import de.vw.mib.bap.generated.navsd.serializer.Altitude_Status;
import de.vw.mib.bap.generated.navsd.serializer.BAP_Config_Reset;
import de.vw.mib.bap.generated.navsd.serializer.BAP_Config_Status;
import de.vw.mib.bap.generated.navsd.serializer.Calibration_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.Calibration_Status;
import de.vw.mib.bap.generated.navsd.serializer.CompassInfo_Status;
import de.vw.mib.bap.generated.navsd.serializer.CurrentPositionInfo_Status;
import de.vw.mib.bap.generated.navsd.serializer.DestinationInfo_Status;
import de.vw.mib.bap.generated.navsd.serializer.DistanceToDestination_Status;
import de.vw.mib.bap.generated.navsd.serializer.DistanceToNextManeuver_Status;
import de.vw.mib.bap.generated.navsd.serializer.ETC_Status_Status;
import de.vw.mib.bap.generated.navsd.serializer.Exitview_Status;
import de.vw.mib.bap.generated.navsd.serializer.FSG_OperationState_Status;
import de.vw.mib.bap.generated.navsd.serializer.FSG_Setup_Status;
import de.vw.mib.bap.generated.navsd.serializer.FavoriteDest_List_ChangedArray;
import de.vw.mib.bap.generated.navsd.serializer.FavoriteDest_List_GetArray;
import de.vw.mib.bap.generated.navsd.serializer.FavoriteDest_List_StatusArray;
import de.vw.mib.bap.generated.navsd.serializer.FunctionList_Status;
import de.vw.mib.bap.generated.navsd.serializer.FunctionSynchronisation_Status;
import de.vw.mib.bap.generated.navsd.serializer.GetNextListPos_Result;
import de.vw.mib.bap.generated.navsd.serializer.GetNextListPos_StartResult;
import de.vw.mib.bap.generated.navsd.serializer.InfoStates_Status;
import de.vw.mib.bap.generated.navsd.serializer.LaneGuidance_ChangedArray;
import de.vw.mib.bap.generated.navsd.serializer.LaneGuidance_GetArray;
import de.vw.mib.bap.generated.navsd.serializer.LaneGuidance_StatusArray;
import de.vw.mib.bap.generated.navsd.serializer.LastDest_List_ChangedArray;
import de.vw.mib.bap.generated.navsd.serializer.LastDest_List_GetArray;
import de.vw.mib.bap.generated.navsd.serializer.LastDest_List_StatusArray;
import de.vw.mib.bap.generated.navsd.serializer.MagnetFieldZone_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.MagnetFieldZone_Status;
import de.vw.mib.bap.generated.navsd.serializer.ManeuverDescriptor_Status;
import de.vw.mib.bap.generated.navsd.serializer.ManeuverState_Status;
import de.vw.mib.bap.generated.navsd.serializer.MapColorAndType_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.MapColorAndType_Status;
import de.vw.mib.bap.generated.navsd.serializer.MapScale_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.MapScale_Status;
import de.vw.mib.bap.generated.navsd.serializer.MapViewAndOrientation_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.MapViewAndOrientation_Status;
import de.vw.mib.bap.generated.navsd.serializer.Map_Presentation_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.Map_Presentation_Status;
import de.vw.mib.bap.generated.navsd.serializer.NavBook_ChangedArray;
import de.vw.mib.bap.generated.navsd.serializer.NavBook_GetArray;
import de.vw.mib.bap.generated.navsd.serializer.NavBook_StatusArray;
import de.vw.mib.bap.generated.navsd.serializer.NbSpeller_Result;
import de.vw.mib.bap.generated.navsd.serializer.NbSpeller_StartResult;
import de.vw.mib.bap.generated.navsd.serializer.OnlineNavigationState_Status;
import de.vw.mib.bap.generated.navsd.serializer.POI_List_ChangedArray;
import de.vw.mib.bap.generated.navsd.serializer.POI_List_GetArray;
import de.vw.mib.bap.generated.navsd.serializer.POI_List_StatusArray;
import de.vw.mib.bap.generated.navsd.serializer.POI_Search_Result;
import de.vw.mib.bap.generated.navsd.serializer.POI_Search_StartResult;
import de.vw.mib.bap.generated.navsd.serializer.PreferredDest_List_Status;
import de.vw.mib.bap.generated.navsd.serializer.RG_ActDeact_Result;
import de.vw.mib.bap.generated.navsd.serializer.RG_ActDeact_StartResult;
import de.vw.mib.bap.generated.navsd.serializer.RG_Status_Status;
import de.vw.mib.bap.generated.navsd.serializer.RepeatLastNavAnnouncement_Result;
import de.vw.mib.bap.generated.navsd.serializer.SemidynamicRouteGuidance_Status;
import de.vw.mib.bap.generated.navsd.serializer.TMCinfo_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.TMCinfo_Status;
import de.vw.mib.bap.generated.navsd.serializer.TimeToDestination_Status;
import de.vw.mib.bap.generated.navsd.serializer.TrafficBlock_Indication_Status;
import de.vw.mib.bap.generated.navsd.serializer.TurnToInfo_Status;
import de.vw.mib.bap.generated.navsd.serializer.VoiceGuidance_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.VoiceGuidance_Status;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.requests.StatusAckProperty;
import de.vw.mib.bap.requests.StatusArray;
import de.vw.mib.bap.requests.StatusProperty;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class FunctionRegistrationNavi
implements IFunctionRegistrationFSG {
    private BAPFunctionPropertyFSG bapConfig;
    private BAPFunctionPropertyFSG functionList;
    private BAPFunctionPropertyFSG fsgOperationState;
    private BAPFunctionPropertyFSG compassInfo;
    private BAPFunctionPropertyFSG rgStatus;
    private BAPFunctionPropertyFSG distanceToNextManeuver;
    private BAPFunctionPropertyFSG currentPositionInfo;
    private BAPFunctionPropertyFSG turnToInfo;
    private BAPFunctionPropertyFSG distanceToDestination;
    private BAPFunctionPropertyFSG timeToDestination;
    private BAPFunctionPropertyFSG maneuverDescriptor;
    private BAPFunctionArrayFSG laneGuidance;
    private BAPFunctionPropertyFSG tmCinfo;
    private BAPFunctionPropertyFSG magnetFieldZone;
    private BAPFunctionPropertyFSG calibration;
    private BAPFunctionPropertyFSG asgCapabilities;
    private BAPFunctionArrayFSG lastDestList;
    private BAPFunctionArrayFSG favoriteDestList;
    private BAPFunctionPropertyFSG preferredDestList;
    private BAPFunctionArrayFSG navBook;
    private BAPFunctionArrayFSG addressList;
    private BAPFunctionMethodFSG rgActDeact;
    private BAPFunctionMethodFSG repeatLastNavAnnouncement;
    private BAPFunctionPropertyFSG voiceGuidance;
    private BAPFunctionPropertyFSG functionSynchronisation;
    private BAPFunctionPropertyFSG infoStates;
    private BAPFunctionPropertyFSG activeRgType;
    private BAPFunctionPropertyFSG trafficBlockIndication;
    private BAPFunctionMethodFSG getNextListPos;
    private BAPFunctionMethodFSG nbSpeller;
    private BAPFunctionPropertyFSG mapColorAndType;
    private BAPFunctionPropertyFSG mapViewAndOrientation;
    private BAPFunctionPropertyFSG mapScale;
    private BAPFunctionPropertyFSG destinationInfo;
    private BAPFunctionPropertyFSG altitude;
    private BAPFunctionPropertyFSG onlineNavigationState;
    private BAPFunctionPropertyFSG exitview;
    private BAPFunctionPropertyFSG semidynamicRouteGuidance;
    private BAPFunctionMethodFSG poiSearch;
    private BAPFunctionArrayFSG poiList;
    private BAPFunctionPropertyFSG fsgSetup;
    private BAPFunctionPropertyFSG mapPresentation;
    private BAPFunctionPropertyFSG maneuverState;
    private BAPFunctionPropertyFSG etcStatus;
    private boolean initialized = false;
    private final LogChannel logChannel;
    private final List allProperties = new ArrayList(33);
    private final List allMethods = new ArrayList(5);
    private final List allArrays = new ArrayList(6);

    public FunctionRegistrationNavi(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.logChannel = abstractBAPModuleFSG.getLogChannel();
        this.initialize(abstractBAPModuleFSG);
    }

    private void initialize(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.logChannel.log(10000000, "[FunctionRegistrationNavi#initialize] start initialization");
        this.initializeProperties(abstractBAPModuleFSG);
        this.initializeMethods(abstractBAPModuleFSG);
        this.initializeArrays(abstractBAPModuleFSG);
        this.initialized = true;
        this.logChannel.log(10000000, "[FunctionRegistrationNavi#initialize] initialization completed");
    }

    private void initializeProperties(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.logChannel.log(10000000, "[FunctionRegistrationNavi#initializeProperties] initialize properties");
        this.bapConfig = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(2);
        this.bapConfig.setResetSerializer(new BAP_Config_Reset());
        this.allProperties.add(this.bapConfig);
        this.functionList = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(3);
        this.allProperties.add(this.functionList);
        this.fsgOperationState = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(15);
        this.allProperties.add(this.fsgOperationState);
        this.compassInfo = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(16);
        this.allProperties.add(this.compassInfo);
        this.rgStatus = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(17);
        this.allProperties.add(this.rgStatus);
        this.distanceToNextManeuver = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(18);
        this.allProperties.add(this.distanceToNextManeuver);
        this.currentPositionInfo = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(19);
        this.allProperties.add(this.currentPositionInfo);
        this.turnToInfo = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(20);
        this.allProperties.add(this.turnToInfo);
        this.distanceToDestination = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(21);
        this.allProperties.add(this.distanceToDestination);
        this.timeToDestination = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(22);
        this.allProperties.add(this.timeToDestination);
        this.maneuverDescriptor = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(23);
        this.allProperties.add(this.maneuverDescriptor);
        this.tmCinfo = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(25);
        this.tmCinfo.setSetGetSerializer(new TMCinfo_SetGet());
        this.allProperties.add(this.tmCinfo);
        this.magnetFieldZone = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(26);
        this.magnetFieldZone.setSetGetSerializer(new MagnetFieldZone_SetGet());
        this.allProperties.add(this.magnetFieldZone);
        this.calibration = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(27);
        this.calibration.setSetGetSerializer(new Calibration_SetGet());
        this.allProperties.add(this.calibration);
        this.asgCapabilities = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(28);
        this.asgCapabilities.setSetGetSerializer(new ASG_Capabilities_SetGet());
        this.allProperties.add(this.asgCapabilities);
        this.preferredDestList = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(31);
        this.allProperties.add(this.preferredDestList);
        this.voiceGuidance = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(36);
        this.voiceGuidance.setSetGetSerializer(new VoiceGuidance_SetGet());
        this.allProperties.add(this.voiceGuidance);
        this.functionSynchronisation = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(37);
        this.allProperties.add(this.functionSynchronisation);
        this.infoStates = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(38);
        this.allProperties.add(this.infoStates);
        this.activeRgType = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(39);
        this.activeRgType.setSetGetSerializer(new ActiveRgType_SetGet());
        this.allProperties.add(this.activeRgType);
        this.trafficBlockIndication = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(40);
        this.allProperties.add(this.trafficBlockIndication);
        this.mapColorAndType = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(43);
        this.mapColorAndType.setSetGetSerializer(new MapColorAndType_SetGet());
        this.allProperties.add(this.mapColorAndType);
        this.mapViewAndOrientation = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(44);
        this.mapViewAndOrientation.setSetGetSerializer(new MapViewAndOrientation_SetGet());
        this.allProperties.add(this.mapViewAndOrientation);
        this.mapScale = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(45);
        this.mapScale.setSetGetSerializer(new MapScale_SetGet());
        this.allProperties.add(this.mapScale);
        this.destinationInfo = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(46);
        this.allProperties.add(this.destinationInfo);
        this.altitude = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(47);
        this.allProperties.add(this.altitude);
        this.onlineNavigationState = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(48);
        this.allProperties.add(this.onlineNavigationState);
        this.exitview = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(49);
        this.allProperties.add(this.exitview);
        this.semidynamicRouteGuidance = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(50);
        this.allProperties.add(this.semidynamicRouteGuidance);
        this.fsgSetup = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(53);
        this.allProperties.add(this.fsgSetup);
        this.mapPresentation = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(54);
        this.mapPresentation.setSetGetSerializer(new Map_Presentation_SetGet());
        this.allProperties.add(this.mapPresentation);
        this.maneuverState = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(55);
        this.allProperties.add(this.maneuverState);
        this.etcStatus = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(56);
        this.allProperties.add(this.etcStatus);
    }

    private void initializeMethods(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.logChannel.log(10000000, "[FunctionRegistrationNavi#initializeMethods] initialize methods");
        this.rgActDeact = abstractBAPModuleFSG.createBAPFunctionMethodFSG(34);
        this.rgActDeact.setStartResultSerializer(new RG_ActDeact_StartResult());
        this.allMethods.add(this.rgActDeact);
        this.repeatLastNavAnnouncement = abstractBAPModuleFSG.createBAPFunctionMethodFSG(35);
        this.allMethods.add(this.repeatLastNavAnnouncement);
        this.getNextListPos = abstractBAPModuleFSG.createBAPFunctionMethodFSG(41);
        this.getNextListPos.setStartResultSerializer(new GetNextListPos_StartResult());
        this.allMethods.add(this.getNextListPos);
        this.nbSpeller = abstractBAPModuleFSG.createBAPFunctionMethodFSG(42);
        this.nbSpeller.setStartResultSerializer(new NbSpeller_StartResult());
        this.allMethods.add(this.nbSpeller);
        this.poiSearch = abstractBAPModuleFSG.createBAPFunctionMethodFSG(51);
        this.poiSearch.setStartResultSerializer(new POI_Search_StartResult());
        this.allMethods.add(this.poiSearch);
    }

    private void initializeArrays(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.logChannel.log(10000000, "[FunctionRegistrationNavi#initializeArrays] initialize arrays");
        this.laneGuidance = abstractBAPModuleFSG.createBAPFunctionArrayFSG(24);
        this.laneGuidance.setGetArraySerializer(new LaneGuidance_GetArray());
        this.allArrays.add(this.laneGuidance);
        this.lastDestList = abstractBAPModuleFSG.createBAPFunctionArrayFSG(29);
        this.lastDestList.setGetArraySerializer(new LastDest_List_GetArray());
        this.allArrays.add(this.lastDestList);
        this.favoriteDestList = abstractBAPModuleFSG.createBAPFunctionArrayFSG(30);
        this.favoriteDestList.setGetArraySerializer(new FavoriteDest_List_GetArray());
        this.allArrays.add(this.favoriteDestList);
        this.navBook = abstractBAPModuleFSG.createBAPFunctionArrayFSG(32);
        this.navBook.setGetArraySerializer(new NavBook_GetArray());
        this.allArrays.add(this.navBook);
        this.addressList = abstractBAPModuleFSG.createBAPFunctionArrayFSG(33);
        this.addressList.setGetArraySerializer(new Address_List_GetArray());
        this.allArrays.add(this.addressList);
        this.poiList = abstractBAPModuleFSG.createBAPFunctionArrayFSG(52);
        this.poiList.setGetArraySerializer(new POI_List_GetArray());
        this.allArrays.add(this.poiList);
    }

    public BAPFunctionMethodFSG getBAPFunctionMethodFSG(int n) {
        try {
            return (BAPFunctionMethodFSG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationNavi#getBAPFunctionMethod] function is not of type 'Method': fctID=%1", (Object)FunctionIDs.getDescription(50, n));
            return null;
        }
    }

    public BAPFunctionPropertyFSG getBAPFunctionPropertyFSG(int n) {
        try {
            return (BAPFunctionPropertyFSG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationNavi#getBAPFunctionProperty] function is not of type 'Property': fctID=%1", (Object)FunctionIDs.getDescription(50, n));
            return null;
        }
    }

    public BAPFunctionArrayFSG getBAPFunctionArrayFSG(int n) {
        try {
            return (BAPFunctionArrayFSG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationNavi#getBAPFunctionArray] function is not of type 'Array': fctID=%1", (Object)FunctionIDs.getDescription(50, n));
            return null;
        }
    }

    public IBAPFunction getBAPFunction(int n) {
        if (!this.initialized) {
            this.logChannel.log(10000, "[FunctionRegistrationNavi#getBAPFunction] function registration not initialized yet for lsgID=%1", (Object)LSGIDs.getDescription(50), (long)n);
        }
        switch (n) {
            case 2: {
                return this.bapConfig;
            }
            case 3: {
                return this.functionList;
            }
            case 15: {
                return this.fsgOperationState;
            }
            case 16: {
                return this.compassInfo;
            }
            case 17: {
                return this.rgStatus;
            }
            case 18: {
                return this.distanceToNextManeuver;
            }
            case 19: {
                return this.currentPositionInfo;
            }
            case 20: {
                return this.turnToInfo;
            }
            case 21: {
                return this.distanceToDestination;
            }
            case 22: {
                return this.timeToDestination;
            }
            case 23: {
                return this.maneuverDescriptor;
            }
            case 24: {
                return this.laneGuidance;
            }
            case 25: {
                return this.tmCinfo;
            }
            case 26: {
                return this.magnetFieldZone;
            }
            case 27: {
                return this.calibration;
            }
            case 28: {
                return this.asgCapabilities;
            }
            case 29: {
                return this.lastDestList;
            }
            case 30: {
                return this.favoriteDestList;
            }
            case 31: {
                return this.preferredDestList;
            }
            case 32: {
                return this.navBook;
            }
            case 33: {
                return this.addressList;
            }
            case 34: {
                return this.rgActDeact;
            }
            case 35: {
                return this.repeatLastNavAnnouncement;
            }
            case 36: {
                return this.voiceGuidance;
            }
            case 37: {
                return this.functionSynchronisation;
            }
            case 38: {
                return this.infoStates;
            }
            case 39: {
                return this.activeRgType;
            }
            case 40: {
                return this.trafficBlockIndication;
            }
            case 41: {
                return this.getNextListPos;
            }
            case 42: {
                return this.nbSpeller;
            }
            case 43: {
                return this.mapColorAndType;
            }
            case 44: {
                return this.mapViewAndOrientation;
            }
            case 45: {
                return this.mapScale;
            }
            case 46: {
                return this.destinationInfo;
            }
            case 47: {
                return this.altitude;
            }
            case 48: {
                return this.onlineNavigationState;
            }
            case 49: {
                return this.exitview;
            }
            case 50: {
                return this.semidynamicRouteGuidance;
            }
            case 51: {
                return this.poiSearch;
            }
            case 52: {
                return this.poiList;
            }
            case 53: {
                return this.fsgSetup;
            }
            case 54: {
                return this.mapPresentation;
            }
            case 55: {
                return this.maneuverState;
            }
            case 56: {
                return this.etcStatus;
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationNavi#getBAPFunction] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(50), (Object)FunctionIDs.getDescription(50, n));
        return null;
    }

    public List getAllProperties() {
        return this.allProperties;
    }

    public List getAllMethods() {
        return this.allMethods;
    }

    public List getAllArrays() {
        return this.allArrays;
    }

    public void resetBAPFunctions() {
        this.logChannel.log(10000000, "[FunctionRegistrationNavi#resetBAPFunctions]");
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

    public ResultMethod createResultForMethodFSG(int n) {
        switch (n) {
            case 34: {
                return new RG_ActDeact_Result();
            }
            case 35: {
                return new RepeatLastNavAnnouncement_Result();
            }
            case 41: {
                return new GetNextListPos_Result();
            }
            case 42: {
                return new NbSpeller_Result();
            }
            case 51: {
                return new POI_Search_Result();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationNavi#createResultForMethodFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(50), (Object)FunctionIDs.getDescription(50, n));
        return null;
    }

    public StatusProperty createStatusForPropertyFSG(int n) {
        switch (n) {
            case 2: {
                return new BAP_Config_Status();
            }
            case 3: {
                return new FunctionList_Status();
            }
            case 15: {
                return new FSG_OperationState_Status();
            }
            case 16: {
                return new CompassInfo_Status();
            }
            case 17: {
                return new RG_Status_Status();
            }
            case 18: {
                return new DistanceToNextManeuver_Status();
            }
            case 19: {
                return new CurrentPositionInfo_Status();
            }
            case 20: {
                return new TurnToInfo_Status();
            }
            case 21: {
                return new DistanceToDestination_Status();
            }
            case 22: {
                return new TimeToDestination_Status();
            }
            case 23: {
                return new ManeuverDescriptor_Status();
            }
            case 25: {
                return new TMCinfo_Status();
            }
            case 26: {
                return new MagnetFieldZone_Status();
            }
            case 27: {
                return new Calibration_Status();
            }
            case 28: {
                return new ASG_Capabilities_Status();
            }
            case 31: {
                return new PreferredDest_List_Status();
            }
            case 36: {
                return new VoiceGuidance_Status();
            }
            case 37: {
                return new FunctionSynchronisation_Status();
            }
            case 38: {
                return new InfoStates_Status();
            }
            case 39: {
                return new ActiveRgType_Status();
            }
            case 40: {
                return new TrafficBlock_Indication_Status();
            }
            case 43: {
                return new MapColorAndType_Status();
            }
            case 44: {
                return new MapViewAndOrientation_Status();
            }
            case 45: {
                return new MapScale_Status();
            }
            case 46: {
                return new DestinationInfo_Status();
            }
            case 47: {
                return new Altitude_Status();
            }
            case 48: {
                return new OnlineNavigationState_Status();
            }
            case 49: {
                return new Exitview_Status();
            }
            case 50: {
                return new SemidynamicRouteGuidance_Status();
            }
            case 53: {
                return new FSG_Setup_Status();
            }
            case 54: {
                return new Map_Presentation_Status();
            }
            case 55: {
                return new ManeuverState_Status();
            }
            case 56: {
                return new ETC_Status_Status();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationNavi#createStatusForPropertyFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(50), (Object)FunctionIDs.getDescription(50, n));
        return null;
    }

    public StatusAckProperty createStatusAckForPropertyFSG(int n) {
        switch (n) {
            default: 
        }
        this.logChannel.log(10000, "[FunctionRegistrationNavi#createStatusAckForPropertyFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(50), (Object)FunctionIDs.getDescription(50, n));
        return null;
    }

    public StatusArray createStatusArrayForArrayFSG(int n) {
        switch (n) {
            case 24: {
                return new LaneGuidance_StatusArray();
            }
            case 29: {
                return new LastDest_List_StatusArray();
            }
            case 30: {
                return new FavoriteDest_List_StatusArray();
            }
            case 32: {
                return new NavBook_StatusArray();
            }
            case 33: {
                return new Address_List_StatusArray();
            }
            case 52: {
                return new POI_List_StatusArray();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationNavi#createStatusArrayForArrayFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(50), (Object)FunctionIDs.getDescription(50, n));
        return null;
    }

    public ChangedArray createChangedArrayForArrayFSG(int n) {
        switch (n) {
            case 24: {
                return new LaneGuidance_ChangedArray();
            }
            case 29: {
                return new LastDest_List_ChangedArray();
            }
            case 30: {
                return new FavoriteDest_List_ChangedArray();
            }
            case 32: {
                return new NavBook_ChangedArray();
            }
            case 33: {
                return new Address_List_ChangedArray();
            }
            case 52: {
                return new POI_List_ChangedArray();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationNavi#createChangedArrayForArrayFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(50), (Object)FunctionIDs.getDescription(50, n));
        return null;
    }
}

