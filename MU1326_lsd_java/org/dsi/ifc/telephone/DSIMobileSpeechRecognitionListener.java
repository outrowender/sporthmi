/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephone;

import org.dsi.ifc.base.DSIListener;

public interface DSIMobileSpeechRecognitionListener
extends DSIListener {
    public void updateSpeechRecognitionAvailable(int var1, int var2);

    public void updateSpeechRecognitionActive(int var1, int var2);

    public void updateSpeechRecognitionType(int var1, int var2);

    public void responseStartSpeechRecognition(int var1);

    public void responseStopSpeechRecognition(int var1);
}

