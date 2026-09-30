/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.ButtonModelApp;

public interface TextfieldModelApp
extends ButtonModelApp {
    public void setTexts(String var1, String var2);

    public void setText1(String var1);

    public String getText1();

    public void setText2(String var1);

    public String getText2();

    public int getBitmapRessourceID();

    public void setBitmapResourceID(int var1);
}

