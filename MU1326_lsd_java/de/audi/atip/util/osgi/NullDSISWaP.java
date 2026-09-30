/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util.osgi;

import de.audi.atip.log.LogChannel;
import de.audi.atip.util.osgi.NullDSIBase;
import org.dsi.ifc.swap.DSISWaP;

public class NullDSISWaP
extends NullDSIBase
implements DSISWaP {
    public NullDSISWaP(LogChannel logChannel) {
        super(logChannel, "DSISWaP");
    }

    public void encryptFile(String string, String string2, byte[] byArray) {
        this.log();
    }

    public void checkSignature(String string, short[] sArray, int n, long l) {
        this.log();
    }

    public void getPublicKey() {
        this.log();
    }

    public void checkSingleFsc(int n) {
        this.log();
    }

    public void decryptFile(String string, String string2, byte[] byArray) {
        this.log();
    }

    public void getFscDetails(int n, int n2) {
        this.log();
    }

    public void triggerSoftwareEnabling() {
        this.log();
    }

    public void importFSCs(int n) {
        this.log();
    }

    public void exportCCD(int n) {
        this.log();
    }

    public void getHistory() {
        this.log();
    }

    public void getFscDetails(int n, int n2, int n3) {
        this.log();
    }
}

