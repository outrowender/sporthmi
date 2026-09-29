/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone;

public interface IPlayerModificationListener {
    default public void skip(boolean bl, int n) {
    }

    default public void seek(boolean bl, boolean bl2) {
    }

    default public void resume() {
    }

    default public void pause(boolean bl) {
    }
}

