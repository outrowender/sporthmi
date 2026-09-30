/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.HMIModelApp;

public interface LabelModelApp
extends HMIModelApp {
    public void setText(String var1);

    public String getText();

    public int getLength();
}

