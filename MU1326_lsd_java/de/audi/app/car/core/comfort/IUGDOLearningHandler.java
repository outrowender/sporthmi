/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

public interface IUGDOLearningHandler {
    public void startLearningButton(int var1, int var2);

    public void startLearningButton();

    public void startLearningButtonFixkitDefaultMode();

    public int getCurrentHardkeyButton();

    public int getCurrentSoftkeyButton();

    public boolean isLearningStarted();

    public void resetLearningStartedState();

    public void abortUgdoLearning();

    public int getLearningState();
}

