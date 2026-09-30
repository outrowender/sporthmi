/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public class TLSComponent {
    public static final int DAB_ADD = 0;
    public static final int FM_ADD = 1000;
    public static final int MEM_ADD = 10000;
    private int tlsID;
    private int tunerComponent;
    private int freq;
    private int pi;
    private int ensID;
    private short ensEcc;
    private long sId;
    private int scidi;
    private String name;

    public TLSComponent(String string, int n, int n2, long l, short s, int n3, int n4, boolean bl) {
        this.tunerComponent = n;
        this.ensID = n2;
        this.sId = l;
        this.ensEcc = s;
        this.scidi = n3;
        this.pi = -1;
        this.freq = -1;
        this.name = string;
        this.tlsID = bl ? n4 + 10000 : n4;
    }

    public TLSComponent(String string, int n, int n2, int n3, int n4, boolean bl) {
        this.tunerComponent = n;
        this.ensID = -1;
        this.sId = -1L;
        this.ensEcc = (short)-1;
        this.scidi = -1;
        this.pi = n3;
        this.freq = n2;
        this.name = string;
        this.tlsID = bl ? n4 + 10000 : n4 + 1000;
    }

    public int getTLSID() {
        return this.tlsID;
    }

    public int getFreq() {
        return this.freq;
    }

    public int getPi() {
        return this.pi;
    }

    public int getEnsID() {
        return this.ensID;
    }

    public short getEnsEcc() {
        return this.ensEcc;
    }

    public long getsId() {
        return this.sId;
    }

    public int getScidi() {
        return this.scidi;
    }

    public String getName() {
        return this.name;
    }

    public int getTunerComponent() {
        return this.tunerComponent;
    }
}

