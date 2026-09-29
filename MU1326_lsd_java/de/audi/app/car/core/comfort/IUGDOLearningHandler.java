/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

public interface IUGDOLearningHandler {
    default public void startLearningButton(int n, int n2) {
    }

    default public void startLearningButton() {
    }

    default public void startLearningButtonFixkitDefaultMode() {
    }

    default public int getCurrentHardkeyButton() {
    }

    default public int getCurrentSoftkeyButton() {
    }

    default public boolean isLearningStarted() {
    }

    default public void resetLearningStartedState() {
    }

    default public void abortUgdoLearning() {
    }

    default public int getLearningState() {
    }
}

