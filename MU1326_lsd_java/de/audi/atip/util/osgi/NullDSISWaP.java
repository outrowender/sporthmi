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

    @Override
    public void encryptFile(String string, String string2, byte[] byArray) {
        this.log();
    }

    @Override
    public void checkSignature(String string, short[] sArray, int n, long l) {
        this.log();
    }

    @Override
    public void getPublicKey() {
        this.log();
    }

    @Override
    public void checkSingleFsc(int n) {
        this.log();
    }

    @Override
    public void decryptFile(String string, String string2, byte[] byArray) {
        this.log();
    }

    public void getFscDetails(int n, int n2) {
        this.log();
    }

    @Override
    public void triggerSoftwareEnabling() {
        this.log();
    }

    @Override
    public void importFSCs(int n) {
        this.log();
    }

    @Override
    public void exportCCD(int n) {
        this.log();
    }

    @Override
    public void getHistory() {
        this.log();
    }

    @Override
    public void getFscDetails(int n, int n2, int n3) {
        this.log();
    }
}

