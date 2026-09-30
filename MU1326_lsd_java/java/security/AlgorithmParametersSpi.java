/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;

public abstract class AlgorithmParametersSpi {
    protected abstract byte[] engineGetEncoded() throws IOException;

    protected abstract byte[] engineGetEncoded(String var1) throws IOException;

    protected abstract AlgorithmParameterSpec engineGetParameterSpec(Class var1) throws InvalidParameterSpecException;

    protected abstract void engineInit(byte[] var1) throws IOException;

    protected abstract void engineInit(byte[] var1, String var2) throws IOException;

    protected abstract void engineInit(AlgorithmParameterSpec var1) throws InvalidParameterSpecException;

    protected abstract String engineToString();
}

