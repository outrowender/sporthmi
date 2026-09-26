/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import java.util.LinkedList;
import org.dsi.ifc.online.DictationValueSentence;

public interface ITranscriptPreprocessor {
    default public LinkedList preprocessTranscript(DictationValueSentence dictationValueSentence) {
    }
}

