/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.waveplayer;

import de.audi.tghu.waveplayer.WavePlayerClient;

class WavePlayerMaster$Request {
    final WavePlayerClient client;
    final int id;
    final int toneId;

    WavePlayerMaster$Request(WavePlayerClient wavePlayerClient, int n, int n2) {
        this.client = wavePlayerClient;
        this.id = n;
        this.toneId = n2;
    }
}

