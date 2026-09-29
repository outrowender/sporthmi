/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.ButtonModelApp;

public interface TextfieldModelApp
extends ButtonModelApp {
    default public void setTexts(String string, String string2) {
    }

    default public void setText1(String string) {
    }

    default public String getText1() {
    }

    default public void setText2(String string) {
    }

    default public String getText2() {
    }

    default public int getBitmapRessourceID() {
    }

    default public void setBitmapResourceID(int n) {
    }
}

