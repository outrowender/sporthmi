/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.audiosd.serializer.ASG_Capabilities_PresentationCapabilities;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ASG_Capabilities_SetGet
implements SetGetProperty {
    public final ASG_Capabilities_PresentationCapabilities presentationCapabilities = new ASG_Capabilities_PresentationCapabilities();

    public ASG_Capabilities_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public ASG_Capabilities_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.presentationCapabilities.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        ASG_Capabilities_SetGet aSG_Capabilities_SetGet = (ASG_Capabilities_SetGet)bAPEntity;
        return this.presentationCapabilities.equalTo(aSG_Capabilities_SetGet.presentationCapabilities);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ASG_Capabilities_SetGet:");
        stringBuffer.append("\n - PresentationCapabilities - ");
        stringBuffer.append(this.presentationCapabilities.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        return n += this.presentationCapabilities.bitSize();
    }

    public void serialize(BitStream bitStream) {
        this.presentationCapabilities.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.presentationCapabilities.deserialize(bitStream);
    }

    public static int functionId() {
        return 43;
    }

    public int getFunctionId() {
        return ASG_Capabilities_SetGet.functionId();
    }
}

