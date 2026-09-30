/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.wordprediction;

import de.audi.atip.wordprediction.IWordPredictionResponseListener;

public interface IWordPredictionServiceListener
extends IWordPredictionResponseListener {
    public boolean isStartContextBasedPredictionValid();

    public void onWordPredictionServiceReady();

    public void onWordPredictionServiceRemoved();
}

