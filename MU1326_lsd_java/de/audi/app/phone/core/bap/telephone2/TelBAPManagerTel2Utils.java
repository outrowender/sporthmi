/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone2;

public class TelBAPManagerTel2Utils {
    static boolean telModeSupportsData(int n) {
        return n == 2 || n == 0 || n == 1;
    }
}

