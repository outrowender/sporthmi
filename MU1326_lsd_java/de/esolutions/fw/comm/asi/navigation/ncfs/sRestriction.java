/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs;

public class sRestriction {
    public long id;
    public long edgeId;
    public int startAt;
    public int endAt;
    public int type;
    public short value;
    public int addSignType;
    public String addSignValue;

    public long getId() {
        return this.id;
    }

    public void setId(long l) {
        this.id = l;
    }

    public long getEdgeId() {
        return this.edgeId;
    }

    public void setEdgeId(long l) {
        this.edgeId = l;
    }

    public int getStartAt() {
        return this.startAt;
    }

    public void setStartAt(int n) {
        this.startAt = n;
    }

    public int getEndAt() {
        return this.endAt;
    }

    public void setEndAt(int n) {
        this.endAt = n;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int n) {
        this.type = n;
    }

    public short getValue() {
        return this.value;
    }

    public void setValue(short s) {
        this.value = s;
    }

    public int getAddSignType() {
        return this.addSignType;
    }

    public void setAddSignType(int n) {
        this.addSignType = n;
    }

    public String getAddSignValue() {
        return this.addSignValue;
    }

    public void setAddSignValue(String string) {
        this.addSignValue = string;
    }

    public sRestriction() {
    }

    public sRestriction(long l, long l2, int n, int n2, int n3, short s, int n4, String string) {
        this.id = l;
        this.edgeId = l2;
        this.startAt = n;
        this.endAt = n2;
        this.type = n3;
        this.value = s;
        this.addSignType = n4;
        this.addSignValue = string;
    }

    public String toString() {
        return "sRestriction{" + "id=" + this.id + ", edgeId=" + this.edgeId + ", startAt=" + this.startAt + ", endAt=" + this.endAt + ", type=" + this.type + ", value=" + this.value + ", addSignType=" + this.addSignType + ", addSignValue=" + this.addSignValue + "}";
    }
}

