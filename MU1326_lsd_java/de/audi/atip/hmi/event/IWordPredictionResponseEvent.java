/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.log.LogChannel;
import de.audi.atip.wordprediction.IWordPredictionResponseListener;
import de.audi.atip.wordprediction.WordPredictionUseCase;

public interface IWordPredictionResponseEvent {
    public static final int TYPE_UPDATE_VALUES = 120012;
    public static final int TYPE_ERROR = 120013;

    public void dispatchToResponseListener(IWordPredictionResponseListener var1, LogChannel var2);

    public int getResponseId();

    public int getEventType();

    public WordPredictionUseCase getSourceUseCase();
}

