/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class Map_Presentation_ASG_HMI_State
implements BAPEntity {
    private static final int RESERVED_BIT_3__7_BITSIZE;
    public boolean rightSideMenueOpen;
    public boolean leftSideMenueOpen;
    public boolean largeMapView;
    private static final int MAP_PRESENTATION_ASG_HMI_STATE_BITSIZE;

    public Map_Presentation_ASG_HMI_State() {
        this.internalReset();
        this.customInitialization();
    }

    public Map_Presentation_ASG_HMI_State(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.rightSideMenueOpen = false;
        this.leftSideMenueOpen = false;
        this.largeMapView = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        Map_Presentation_ASG_HMI_State map_Presentation_ASG_HMI_State = (Map_Presentation_ASG_HMI_State)bAPEntity;
        return this.rightSideMenueOpen == map_Presentation_ASG_HMI_State.rightSideMenueOpen && this.leftSideMenueOpen == map_Presentation_ASG_HMI_State.leftSideMenueOpen && this.largeMapView == map_Presentation_ASG_HMI_State.largeMapView;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Map_Presentation_ASG_HMI_State:");
        stringBuffer.append("\n - Bit 2: ");
        if (this.rightSideMenueOpen) {
            stringBuffer.append("true  (right side menue open");
        } else {
            stringBuffer.append("false  (right side menue closed");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.leftSideMenueOpen) {
            stringBuffer.append("true  (left side menue open");
        } else {
            stringBuffer.append("false  (left sidemenue closed");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.largeMapView) {
            stringBuffer.append("true  (large map view");
        } else {
            stringBuffer.append("false  (small map view");
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
        bitStream.resetBits(5);
        bitStream.pushBoolean(this.rightSideMenueOpen);
        bitStream.pushBoolean(this.leftSideMenueOpen);
        bitStream.pushBoolean(this.largeMapView);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(5);
        this.rightSideMenueOpen = bitStream.popFrontBoolean();
        this.leftSideMenueOpen = bitStream.popFrontBoolean();
        this.largeMapView = bitStream.popFrontBoolean();
    }
}

