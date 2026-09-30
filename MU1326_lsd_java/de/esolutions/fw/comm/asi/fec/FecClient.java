/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec;

import de.esolutions.fw.comm.asi.fec.SFecState;
import de.esolutions.fw.comm.core.method.MethodException;

public interface FecClient {
    public static final String IPL_COMM_UUID = "ff733e4d-6e39-49b8-b354-ee9c22f6cfc9";
    public static final String IPL_COMM_INTERFACE_KEY = "41fc1271-3ffd-552d-a498-7d1f105d825a";
    public static final String IPL_COMM_INTERFACE_VERSION = "0.0.3";
    public static final String IPL_COMM_MODULE_VERSION = "1.1.5";

    public void updateFECs(SFecState[] var1) throws MethodException;

    public static interface Consts {
    }
}

