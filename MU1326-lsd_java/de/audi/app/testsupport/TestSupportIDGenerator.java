/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.testsupport;

public class TestSupportIDGenerator {
    private volatile int nextID = 0;

    protected void reset() {
        this.nextID = 0;
    }

    protected int getID() {
        return this.nextID++;
    }
}

