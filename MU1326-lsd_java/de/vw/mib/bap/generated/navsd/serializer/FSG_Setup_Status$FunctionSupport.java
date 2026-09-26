/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status$FunctionSupport
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean activationDeactivationOfTheVideoNavigationSupported;
    private static final int FUNCTION_SUPPORT_BITSIZE;

    public FSG_Setup_Status$FunctionSupport() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Status$FunctionSupport(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.activationDeactivationOfTheVideoNavigationSupported = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status$FunctionSupport fSG_Setup_Status$FunctionSupport = (FSG_Setup_Status$FunctionSupport)bAPEntity;
        return this.activationDeactivationOfTheVideoNavigationSupported == fSG_Setup_Status$FunctionSupport.activationDeactivationOfTheVideoNavigationSupported;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FunctionSupport:");
        stringBuffer.append("\n - Bit 0: ");
        if (this.activationDeactivationOfTheVideoNavigationSupported) {
            stringBuffer.append("true  (activation/deactivation of the video navigation supported (DF4.4)");
        } else {
            stringBuffer.append("false  (activation/deactivation of the video navigation not supported (DF4.4)");
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
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.activationDeactivationOfTheVideoNavigationSupported);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.activationDeactivationOfTheVideoNavigationSupported = bitStream.popFrontBoolean();
    }
}

