/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DictationValueSentence;

public interface DSIOnlineDictationListener
extends DSIListener {
    public void dictationResult(int var1);

    public void finishDictationResponse(int var1);

    public void dictationValueList(DictationValueSentence var1);
}

