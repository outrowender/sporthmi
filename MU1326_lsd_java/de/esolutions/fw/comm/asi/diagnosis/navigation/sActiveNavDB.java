/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigation;

public class sActiveNavDB {
    public long msg_id;
    public int db;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public int getDb() {
        return this.db;
    }

    public void setDb(int n) {
        this.db = n;
    }

    public sActiveNavDB() {
    }

    public sActiveNavDB(long l, int n) {
        this.msg_id = l;
        this.db = n;
    }

    public String toString() {
        return "sActiveNavDB{" + "msg_id=" + this.msg_id + ", db=" + this.db + "}";
    }
}

