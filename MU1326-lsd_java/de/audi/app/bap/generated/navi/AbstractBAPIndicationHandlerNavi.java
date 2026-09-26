/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.navi;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.fw.indication.AbstractBAPIndicationHandlerFSG;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.datatypes.BAPArray;
import de.vw.mib.bap.generated.navsd.serializer.ASG_Capabilities_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.ActiveRgType_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.Calibration_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.GetNextListPos_StartResult;
import de.vw.mib.bap.generated.navsd.serializer.MagnetFieldZone_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.MapColorAndType_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.MapScale_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.MapViewAndOrientation_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.Map_Presentation_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.NbSpeller_StartResult;
import de.vw.mib.bap.generated.navsd.serializer.POI_Search_StartResult;
import de.vw.mib.bap.generated.navsd.serializer.RG_ActDeact_StartResult;
import de.vw.mib.bap.generated.navsd.serializer.TMCinfo_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.VoiceGuidance_SetGet;
import de.vw.mib.bap.requests.AckProperty;
import de.vw.mib.bap.requests.SetGetArray;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.requests.StartResultMethod;

public abstract class AbstractBAPIndicationHandlerNavi
extends AbstractBAPIndicationHandlerFSG {
    public AbstractBAPIndicationHandlerNavi(AbstractBAPModuleFSG abstractBAPModuleFSG, LogChannel logChannel) {
        super(abstractBAPModuleFSG, logChannel);
    }

    @Override
    public void processIndicationStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, StartResultMethod startResultMethod) {
        switch (bAPFunctionMethodFSG.getFctID()) {
            case 34: {
                this.processRgActDeactStartResult(bAPFunctionMethodFSG, (RG_ActDeact_StartResult)startResultMethod);
                break;
            }
            case 35: {
                this.processRepeatLastNavAnnouncementStartResult(bAPFunctionMethodFSG);
                break;
            }
            case 41: {
                this.processGetNextListPosStartResult(bAPFunctionMethodFSG, (GetNextListPos_StartResult)startResultMethod);
                break;
            }
            case 42: {
                this.processNbSpellerStartResult(bAPFunctionMethodFSG, (NbSpeller_StartResult)startResultMethod);
                break;
            }
            case 51: {
                this.processPoiSearchStartResult(bAPFunctionMethodFSG, (POI_Search_StartResult)startResultMethod);
                break;
            }
            default: {
                this.logChannel.log(10000, "AbstractBAPIndicationHandlerNavi#processIndicationStartResult not implemented for fctID=%1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
            }
        }
    }

    @Override
    public void processIndicationAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        switch (bAPFunctionMethodFSG.getFctID()) {
            case 34: {
                this.processRgActDeactAbort(bAPFunctionMethodFSG);
                break;
            }
            case 35: {
                this.processRepeatLastNavAnnouncementAbort(bAPFunctionMethodFSG);
                break;
            }
            case 41: {
                this.processGetNextListPosAbort(bAPFunctionMethodFSG);
                break;
            }
            case 42: {
                this.processNbSpellerAbort(bAPFunctionMethodFSG);
                break;
            }
            case 51: {
                this.processPoiSearchAbort(bAPFunctionMethodFSG);
                break;
            }
            default: {
                this.logChannel.log(10000, "AbstractBAPIndicationHandlerNavi#processIndicationAbort not implemented for fctID=%1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
            }
        }
    }

    @Override
    public void processIndicationSet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, SetGetProperty setGetProperty) {
        switch (bAPFunctionPropertyFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerNavi#processIndicationSet not implemented for fctID=%1", (Object)bAPFunctionPropertyFSG.getFctIDDescription());
    }

    @Override
    public void processIndicationSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, SetGetProperty setGetProperty) {
        switch (bAPFunctionPropertyFSG.getFctID()) {
            case 25: {
                this.processTmCinfoSetGet(bAPFunctionPropertyFSG, (TMCinfo_SetGet)setGetProperty);
                break;
            }
            case 26: {
                this.processMagnetFieldZoneSetGet(bAPFunctionPropertyFSG, (MagnetFieldZone_SetGet)setGetProperty);
                break;
            }
            case 27: {
                this.processCalibrationSetGet(bAPFunctionPropertyFSG, (Calibration_SetGet)setGetProperty);
                break;
            }
            case 28: {
                this.processAsgCapabilitiesSetGet(bAPFunctionPropertyFSG, (ASG_Capabilities_SetGet)setGetProperty);
                break;
            }
            case 36: {
                this.processVoiceGuidanceSetGet(bAPFunctionPropertyFSG, (VoiceGuidance_SetGet)setGetProperty);
                break;
            }
            case 39: {
                this.processActiveRgTypeSetGet(bAPFunctionPropertyFSG, (ActiveRgType_SetGet)setGetProperty);
                break;
            }
            case 43: {
                this.processMapColorAndTypeSetGet(bAPFunctionPropertyFSG, (MapColorAndType_SetGet)setGetProperty);
                break;
            }
            case 44: {
                this.processMapViewAndOrientationSetGet(bAPFunctionPropertyFSG, (MapViewAndOrientation_SetGet)setGetProperty);
                break;
            }
            case 45: {
                this.processMapScaleSetGet(bAPFunctionPropertyFSG, (MapScale_SetGet)setGetProperty);
                break;
            }
            case 54: {
                this.processMapPresentationSetGet(bAPFunctionPropertyFSG, (Map_Presentation_SetGet)setGetProperty);
                break;
            }
            default: {
                this.logChannel.log(10000, "AbstractBAPIndicationHandlerNavi#processIndicationSetGet not implemented for fctID=%1", (Object)bAPFunctionPropertyFSG.getFctIDDescription());
            }
        }
    }

    @Override
    public void processIndicationAck(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, AckProperty ackProperty) {
        switch (bAPFunctionPropertyFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerNavi#processIndicationAck not implemented for fctID=%1", (Object)bAPFunctionPropertyFSG.getFctIDDescription());
    }

    @Override
    public void processIndicationAckArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, BAPArray bAPArray) {
        switch (bAPFunctionArrayFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerNavi#processIndicationAck not implemented for fctID=%1", (Object)bAPFunctionArrayFSG.getFctIDDescription());
    }

    @Override
    public void processIndicationSetArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, SetGetArray setGetArray) {
        switch (bAPFunctionArrayFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerNavi#processIndicationSetArray not implemented for fctID=%1", (Object)bAPFunctionArrayFSG.getFctIDDescription());
    }

    @Override
    public void processIndicationSetGetArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, SetGetArray setGetArray) {
        switch (bAPFunctionArrayFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerNavi#processIndicationSetGetArray not implemented for fctID=%1", (Object)bAPFunctionArrayFSG.getFctIDDescription());
    }

    protected abstract void processTmCinfoSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, TMCinfo_SetGet tMCinfo_SetGet) {
    }

    protected abstract void processMagnetFieldZoneSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, MagnetFieldZone_SetGet magnetFieldZone_SetGet) {
    }

    protected abstract void processCalibrationSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, Calibration_SetGet calibration_SetGet) {
    }

    protected abstract void processAsgCapabilitiesSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, ASG_Capabilities_SetGet aSG_Capabilities_SetGet) {
    }

    protected abstract void processRgActDeactAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processRgActDeactStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, RG_ActDeact_StartResult rG_ActDeact_StartResult) {
    }

    protected abstract void processRepeatLastNavAnnouncementAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processRepeatLastNavAnnouncementStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processVoiceGuidanceSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, VoiceGuidance_SetGet voiceGuidance_SetGet) {
    }

    protected abstract void processActiveRgTypeSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, ActiveRgType_SetGet activeRgType_SetGet) {
    }

    protected abstract void processGetNextListPosAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processGetNextListPosStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, GetNextListPos_StartResult getNextListPos_StartResult) {
    }

    protected abstract void processNbSpellerAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processNbSpellerStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, NbSpeller_StartResult nbSpeller_StartResult) {
    }

    protected abstract void processMapColorAndTypeSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, MapColorAndType_SetGet mapColorAndType_SetGet) {
    }

    protected abstract void processMapViewAndOrientationSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, MapViewAndOrientation_SetGet mapViewAndOrientation_SetGet) {
    }

    protected abstract void processMapScaleSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, MapScale_SetGet mapScale_SetGet) {
    }

    protected abstract void processPoiSearchAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    protected abstract void processPoiSearchStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, POI_Search_StartResult pOI_Search_StartResult) {
    }

    protected abstract void processMapPresentationSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, Map_Presentation_SetGet map_Presentation_SetGet) {
    }
}

