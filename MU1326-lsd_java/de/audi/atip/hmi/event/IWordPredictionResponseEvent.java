/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.log.LogChannel;
import de.audi.atip.wordprediction.IWordPredictionResponseListener;
import de.audi.atip.wordprediction.WordPredictionUseCase;

public interface IWordPredictionResponseEvent {
    public static final int TYPE_UPDATE_VALUES;
    public static final int TYPE_ERROR;

    default public void dispatchToResponseListener(IWordPredictionResponseListener iWordPredictionResponseListener, LogChannel logChannel) {
    }

    default public int getResponseId() {
    }

    default public int getEventType() {
    }

    default public WordPredictionUseCase getSourceUseCase() {
    }
}

