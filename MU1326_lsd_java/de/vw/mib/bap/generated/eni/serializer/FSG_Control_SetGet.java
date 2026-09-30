/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.eni.serializer.FSG_Control_Controlcode;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Control_SetGet
implements SetGetProperty {
    public FSG_Control_Controlcode controlcode = new FSG_Control_Controlcode();

    public FSG_Control_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Control_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.controlcode.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Control_SetGet fSG_Control_SetGet = (FSG_Control_SetGet)bAPEntity;
        return this.controlcode.equalTo(fSG_Control_SetGet.controlcode);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FSG_Control_SetGet");
        stringBuffer.append("\n - controlcode:" + this.controlcode.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        this.controlcode.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.controlcode.deserialize(bitStream);
    }

    public static int functionId() {
        return 13;
    }

    public int getFunctionId() {
        return FSG_Control_SetGet.functionId();
    }
}

