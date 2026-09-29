/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.log.LogChannel;

public class NullOptionModelListener
implements OptionModelListener {
    private final LogChannel lc;

    NullOptionModelListener(LogChannel logChannel) {
        this.lc = logChannel;
    }

    @Override
    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
        this.lc.log(10000, "[NullOptionModelListener.keyPressed] model:%1 No listener registered!");
    }

    @Override
    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
        this.lc.log(10000, "[NullOptionModelListener.keyReleased] model:%1 No listener registered!");
    }

    @Override
    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        this.lc.log(10000, "[NullOptionModelListener.keyTyped] model:%1 No listener registered!");
    }

    @Override
    public void customAction(int n, int n2, int n3, int n4, int n5) {
        this.lc.log(10000, "[NullOptionModelListener.customAction] model:%1 No listener registered!");
    }
}

