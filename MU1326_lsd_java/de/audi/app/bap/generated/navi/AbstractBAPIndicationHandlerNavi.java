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

    public void processIndicationSet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, SetGetProperty setGetProperty) {
        switch (bAPFunctionPropertyFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerNavi#processIndicationSet not implemented for fctID=%1", (Object)bAPFunctionPropertyFSG.getFctIDDescription());
    }

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

    public void processIndicationAck(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, AckProperty ackProperty) {
        switch (bAPFunctionPropertyFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerNavi#processIndicationAck not implemented for fctID=%1", (Object)bAPFunctionPropertyFSG.getFctIDDescription());
    }

    public void processIndicationAckArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, BAPArray bAPArray) {
        switch (bAPFunctionArrayFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerNavi#processIndicationAck not implemented for fctID=%1", (Object)bAPFunctionArrayFSG.getFctIDDescription());
    }

    public void processIndicationSetArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, SetGetArray setGetArray) {
        switch (bAPFunctionArrayFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerNavi#processIndicationSetArray not implemented for fctID=%1", (Object)bAPFunctionArrayFSG.getFctIDDescription());
    }

    public void processIndicationSetGetArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, SetGetArray setGetArray) {
        switch (bAPFunctionArrayFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerNavi#processIndicationSetGetArray not implemented for fctID=%1", (Object)bAPFunctionArrayFSG.getFctIDDescription());
    }

    protected abstract void processTmCinfoSetGet(BAPFunctionPropertyFSG var1, TMCinfo_SetGet var2);

    protected abstract void processMagnetFieldZoneSetGet(BAPFunctionPropertyFSG var1, MagnetFieldZone_SetGet var2);

    protected abstract void processCalibrationSetGet(BAPFunctionPropertyFSG var1, Calibration_SetGet var2);

    protected abstract void processAsgCapabilitiesSetGet(BAPFunctionPropertyFSG var1, ASG_Capabilities_SetGet var2);

    protected abstract void processRgActDeactAbort(BAPFunctionMethodFSG var1);

    protected abstract void processRgActDeactStartResult(BAPFunctionMethodFSG var1, RG_ActDeact_StartResult var2);

    protected abstract void processRepeatLastNavAnnouncementAbort(BAPFunctionMethodFSG var1);

    protected abstract void processRepeatLastNavAnnouncementStartResult(BAPFunctionMethodFSG var1);

    protected abstract void processVoiceGuidanceSetGet(BAPFunctionPropertyFSG var1, VoiceGuidance_SetGet var2);

    protected abstract void processActiveRgTypeSetGet(BAPFunctionPropertyFSG var1, ActiveRgType_SetGet var2);

    protected abstract void processGetNextListPosAbort(BAPFunctionMethodFSG var1);

    protected abstract void processGetNextListPosStartResult(BAPFunctionMethodFSG var1, GetNextListPos_StartResult var2);

    protected abstract void processNbSpellerAbort(BAPFunctionMethodFSG var1);

    protected abstract void processNbSpellerStartResult(BAPFunctionMethodFSG var1, NbSpeller_StartResult var2);

    protected abstract void processMapColorAndTypeSetGet(BAPFunctionPropertyFSG var1, MapColorAndType_SetGet var2);

    protected abstract void processMapViewAndOrientationSetGet(BAPFunctionPropertyFSG var1, MapViewAndOrientation_SetGet var2);

    protected abstract void processMapScaleSetGet(BAPFunctionPropertyFSG var1, MapScale_SetGet var2);

    protected abstract void processPoiSearchAbort(BAPFunctionMethodFSG var1);

    protected abstract void processPoiSearchStartResult(BAPFunctionMethodFSG var1, POI_Search_StartResult var2);

    protected abstract void processMapPresentationSetGet(BAPFunctionPropertyFSG var1, Map_Presentation_SetGet var2);
}

