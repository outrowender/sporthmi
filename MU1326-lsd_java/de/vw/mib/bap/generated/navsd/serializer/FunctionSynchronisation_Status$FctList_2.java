/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionSynchronisation_Status$FctList_2
implements BAPEntity {
    public boolean fct_OnlineNavigationStateIsToBeSynchronised;
    public boolean fct_ExitViewIsToBeSynchronised;
    public boolean fct_SemidynamicRouteGuidanceIsToBeSynchronised;
    private static final int RESERVED_BIT_3__4_BITSIZE;
    public boolean fct_Fsg_SetupIsToBeSynchronised;
    public boolean fct_MapPresentationIsToBeSynchronised;
    public boolean reserved_bit_7;
    private static final int FCT_LIST_2_BITSIZE;

    public FunctionSynchronisation_Status$FctList_2() {
        this.internalReset();
        this.customInitialization();
    }

    public FunctionSynchronisation_Status$FctList_2(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.fct_OnlineNavigationStateIsToBeSynchronised = false;
        this.fct_ExitViewIsToBeSynchronised = false;
        this.fct_SemidynamicRouteGuidanceIsToBeSynchronised = false;
        this.fct_Fsg_SetupIsToBeSynchronised = false;
        this.fct_MapPresentationIsToBeSynchronised = false;
        this.reserved_bit_7 = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionSynchronisation_Status$FctList_2 functionSynchronisation_Status$FctList_2 = (FunctionSynchronisation_Status$FctList_2)bAPEntity;
        return this.fct_OnlineNavigationStateIsToBeSynchronised == functionSynchronisation_Status$FctList_2.fct_OnlineNavigationStateIsToBeSynchronised && this.fct_ExitViewIsToBeSynchronised == functionSynchronisation_Status$FctList_2.fct_ExitViewIsToBeSynchronised && this.fct_SemidynamicRouteGuidanceIsToBeSynchronised == functionSynchronisation_Status$FctList_2.fct_SemidynamicRouteGuidanceIsToBeSynchronised && this.fct_Fsg_SetupIsToBeSynchronised == functionSynchronisation_Status$FctList_2.fct_Fsg_SetupIsToBeSynchronised && this.fct_MapPresentationIsToBeSynchronised == functionSynchronisation_Status$FctList_2.fct_MapPresentationIsToBeSynchronised && this.reserved_bit_7 == functionSynchronisation_Status$FctList_2.reserved_bit_7;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FctList_2:");
        stringBuffer.append("\n - Bit 0: ");
        if (this.fct_OnlineNavigationStateIsToBeSynchronised) {
            stringBuffer.append("true  (Fct. OnlineNavigationState is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct. OnlineNavigationState is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.fct_ExitViewIsToBeSynchronised) {
            stringBuffer.append("true  (Fct. ExitView is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct. ExitView is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 2: ");
        if (this.fct_SemidynamicRouteGuidanceIsToBeSynchronised) {
            stringBuffer.append("true  (Fct. SemidynamicRouteGuidance is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct. SemidynamicRouteGuidance is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 5: ");
        if (this.fct_Fsg_SetupIsToBeSynchronised) {
            stringBuffer.append("true  (Fct. FSG_Setup is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct. FSG_Setup is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 6: ");
        if (this.fct_MapPresentationIsToBeSynchronised) {
            stringBuffer.append("true  (Fct. MapPresentation is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct. MapPresentation is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 7: ");
        if (this.reserved_bit_7) {
            stringBuffer.append("true  (reserved");
        } else {
            stringBuffer.append("false  (reserved");
        }
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.fct_OnlineNavigationStateIsToBeSynchronised);
        bitStream.pushBoolean(this.fct_ExitViewIsToBeSynchronised);
        bitStream.pushBoolean(this.fct_SemidynamicRouteGuidanceIsToBeSynchronised);
        bitStream.resetBits(2);
        bitStream.pushBoolean(this.fct_Fsg_SetupIsToBeSynchronised);
        bitStream.pushBoolean(this.fct_MapPresentationIsToBeSynchronised);
        bitStream.pushBoolean(this.reserved_bit_7);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.fct_OnlineNavigationStateIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fct_ExitViewIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fct_SemidynamicRouteGuidanceIsToBeSynchronised = bitStream.popFrontBoolean();
        bitStream.discardBits(2);
        this.fct_Fsg_SetupIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fct_MapPresentationIsToBeSynchronised = bitStream.popFrontBoolean();
        this.reserved_bit_7 = bitStream.popFrontBoolean();
    }
}

