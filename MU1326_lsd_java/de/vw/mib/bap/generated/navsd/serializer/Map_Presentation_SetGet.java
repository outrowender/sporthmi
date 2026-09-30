/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.navsd.serializer.Map_Presentation_ASG_HMI_State;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class Map_Presentation_SetGet
implements SetGetProperty {
    public final Map_Presentation_ASG_HMI_State asg_Hmi_State = new Map_Presentation_ASG_HMI_State();

    public Map_Presentation_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public Map_Presentation_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.asg_Hmi_State.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        Map_Presentation_SetGet map_Presentation_SetGet = (Map_Presentation_SetGet)bAPEntity;
        return this.asg_Hmi_State.equalTo(map_Presentation_SetGet.asg_Hmi_State);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Map_Presentation_SetGet:");
        stringBuffer.append("\n - ASG_HMI_State - ");
        stringBuffer.append(this.asg_Hmi_State.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        return n += this.asg_Hmi_State.bitSize();
    }

    public void serialize(BitStream bitStream) {
        this.asg_Hmi_State.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.asg_Hmi_State.deserialize(bitStream);
    }

    public static int functionId() {
        return 54;
    }

    public int getFunctionId() {
        return Map_Presentation_SetGet.functionId();
    }
}

