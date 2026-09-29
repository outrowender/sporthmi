/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

public interface IVisualFeedback {
    default public void showTextFeedback(String string) {
    }

    default public void showFullScreenFeedback() {
    }

    default public void hideFeedback() {
    }
}

