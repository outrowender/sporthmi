/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.wordprediction;

import de.audi.atip.wordprediction.IWordPredictionResponseListener;

public interface IWordPredictionServiceListener
extends IWordPredictionResponseListener {
    default public boolean isStartContextBasedPredictionValid() {
    }

    default public void onWordPredictionServiceReady() {
    }

    default public void onWordPredictionServiceRemoved() {
    }
}

