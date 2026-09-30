/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.esolutions.fw.util.commons.Buffer;

class PsFreezeData {
    private static final int INITIAL_AGE = 0;
    private String freezedName;
    private int age;

    PsFreezeData(String string) {
        this.freezedName = string;
        this.age = 0;
    }

    PsFreezeData(String string, int n) {
        this.freezedName = string;
        this.age = n;
    }

    public String getFreezedName() {
        return this.freezedName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int n) {
        this.age = n;
    }

    void age() {
        ++this.age;
    }

    boolean isOlder(int n) {
        return this.age > n;
    }

    public String toString() {
        Buffer buffer = new Buffer(50);
        buffer.append("Freezed name: ").append(this.freezedName).append(", Age: ").append(this.age);
        return buffer.toString();
    }
}

