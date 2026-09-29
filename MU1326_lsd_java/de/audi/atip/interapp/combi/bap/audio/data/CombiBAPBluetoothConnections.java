/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio.data;

import de.esolutions.fw.util.commons.Buffer;

public final class CombiBAPBluetoothConnections {
    private boolean audioplayerActive;
    private boolean handsFreeProfileActive;
    private boolean phonebookAccessProfileActive;
    private boolean simAccessProfileActive;

    public CombiBAPBluetoothConnections(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.audioplayerActive = bl;
        this.handsFreeProfileActive = bl2;
        this.phonebookAccessProfileActive = bl3;
        this.simAccessProfileActive = bl4;
    }

    public boolean isAudioplayerActive() {
        return this.audioplayerActive;
    }

    public boolean isHandsFreeProfileActive() {
        return this.handsFreeProfileActive;
    }

    public boolean isPhonebookAccessProfileActive() {
        return this.phonebookAccessProfileActive;
    }

    public boolean isSimAccessProfileActive() {
        return this.simAccessProfileActive;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("CombiBAPBluetoothConnections{audioplayerActive=");
        buffer.append(this.audioplayerActive);
        buffer.append(", handsFreeProfileActive=");
        buffer.append(this.handsFreeProfileActive);
        buffer.append(", phonebookAccessProfileActive=");
        buffer.append(this.phonebookAccessProfileActive);
        buffer.append(", simAccessProfileActive=");
        buffer.append(this.simAccessProfileActive);
        buffer.append('}');
        return buffer.toString();
    }
}

