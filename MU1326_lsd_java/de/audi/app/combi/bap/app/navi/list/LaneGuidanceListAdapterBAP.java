/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.navi.list;

import de.audi.app.bap.fw.arrays.AbstractListAdapterBAP;
import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.utils.BAPStringUtilities;
import de.audi.app.combi.bap.app.navi.list.LaneGuidanceHandler;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.audi.atip.interapp.combi.bap.navi.data.CombiBAPNaviLaneGuidanceData;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.generated.navsd.serializer.LaneGuidance_ChangedArray;
import de.vw.mib.bap.generated.navsd.serializer.LaneGuidance_LaneGuidance;
import de.vw.mib.bap.generated.navsd.serializer.LaneGuidance_StatusArray;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.StatusArray;

public class LaneGuidanceListAdapterBAP
extends AbstractListAdapterBAP {
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$navi$data$CombiBAPNaviLaneGuidanceData;

    public LaneGuidanceListAdapterBAP(AbstractCombiModule abstractCombiModule, LaneGuidanceHandler laneGuidanceHandler) {
        super(abstractCombiModule, 24, laneGuidanceHandler);
    }

    protected void sendStatusRequest(GetArrayIndication getArrayIndication, CombiBAPArrayElement[] combiBAPArrayElementArray, StatusArray statusArray) {
        LaneGuidance_StatusArray laneGuidance_StatusArray = (LaneGuidance_StatusArray)statusArray;
        laneGuidance_StatusArray.laneGuidanceOnOff = ((LaneGuidanceHandler)this.listHandler).isLaneGuidanceEnabled() ? 1 : 0;
        super.sendStatusRequest(getArrayIndication, combiBAPArrayElementArray, laneGuidance_StatusArray);
    }

    protected int getCommonRecordAddress(boolean[] blArray) {
        boolean bl = blArray[0] || blArray[1] || blArray[2];
        boolean bl2 = blArray[0] || blArray[1];
        boolean bl3 = blArray[0] || blArray[1];
        boolean bl4 = blArray[0];
        boolean bl5 = blArray[0];
        boolean bl6 = blArray[0] || blArray[1] || blArray[2] || blArray[3];
        boolean bl7 = blArray[0] || blArray[1] || blArray[2] || blArray[3];
        return CombiBAPNaviLaneGuidanceData.getRecordAddress(false, bl, bl2, bl3, bl4, bl5, bl6, bl7);
    }

    protected BAPArrayElement convertArrayElement(CombiBAPArrayElement combiBAPArrayElement, ArrayHeader arrayHeader) {
        LaneGuidance_LaneGuidance laneGuidance_LaneGuidance = new LaneGuidance_LaneGuidance(arrayHeader);
        if (combiBAPArrayElement instanceof CombiBAPNaviLaneGuidanceData) {
            CombiBAPNaviLaneGuidanceData combiBAPNaviLaneGuidanceData = (CombiBAPNaviLaneGuidanceData)combiBAPArrayElement;
            laneGuidance_LaneGuidance.setPos(combiBAPNaviLaneGuidanceData.getPosID());
            laneGuidance_LaneGuidance.laneDirection = combiBAPNaviLaneGuidanceData.getLaneDirection();
            laneGuidance_LaneGuidance.laneSidestreets.setContent(BAPStringUtilities.convertToRawString(combiBAPNaviLaneGuidanceData.getLaneSideStreets()));
            laneGuidance_LaneGuidance.laneType = combiBAPNaviLaneGuidanceData.getLaneType();
            laneGuidance_LaneGuidance.laneMarking_left = combiBAPNaviLaneGuidanceData.getLaneMarkingLeft();
            laneGuidance_LaneGuidance.laneMarking_right = combiBAPNaviLaneGuidanceData.getLaneMarkingRight();
            laneGuidance_LaneGuidance.laneDescription = combiBAPNaviLaneGuidanceData.getLaneDescription();
            laneGuidance_LaneGuidance.guidanceInfo = combiBAPNaviLaneGuidanceData.getGuidanceInfo();
        } else {
            this.logChannel.log(10000, "[LaneGuidanceListAdapterBAP#convertLaneGuidanceData] wrong dataType (expected: %1, is: %2)", (Object)(class$de$audi$atip$interapp$combi$bap$navi$data$CombiBAPNaviLaneGuidanceData == null ? (class$de$audi$atip$interapp$combi$bap$navi$data$CombiBAPNaviLaneGuidanceData = LaneGuidanceListAdapterBAP.class$("de.audi.atip.interapp.combi.bap.navi.data.CombiBAPNaviLaneGuidanceData")) : class$de$audi$atip$interapp$combi$bap$navi$data$CombiBAPNaviLaneGuidanceData).getName(), (Object)combiBAPArrayElement.getClass().getName());
        }
        return laneGuidance_LaneGuidance;
    }

    protected BAPArrayElement createArrayElement(ArrayHeader arrayHeader, int n) {
        LaneGuidance_LaneGuidance laneGuidance_LaneGuidance = new LaneGuidance_LaneGuidance(arrayHeader);
        laneGuidance_LaneGuidance.setPos(n);
        return laneGuidance_LaneGuidance;
    }

    protected ChangedArray createChangedArraySerializer() {
        LaneGuidance_ChangedArray laneGuidance_ChangedArray = new LaneGuidance_ChangedArray();
        laneGuidance_ChangedArray.laneGuidanceOnOff = ((LaneGuidanceHandler)this.listHandler).isLaneGuidanceEnabled() ? 1 : 0;
        return laneGuidance_ChangedArray;
    }

    protected StatusArray createStatusArraySerializer() {
        return new LaneGuidance_StatusArray();
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

