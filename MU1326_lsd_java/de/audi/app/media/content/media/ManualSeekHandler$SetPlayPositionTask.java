/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.IPlayer;

class ManualSeekHandler$SetPlayPositionTask
implements Runnable {
    int position;
    IPlayer player;

    ManualSeekHandler$SetPlayPositionTask(IPlayer iPlayer, int n) {
        this.player = iPlayer;
        this.position = n;
    }

    @Override
    public void run() {
        this.player.setPlayPosition(this.position);
    }
}

