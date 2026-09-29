/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.TextEditorListener;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import java.util.LinkedList;

public interface TextEditorModelApp
extends HMIModelApp {
    public static final int MODE_HAPTIC;
    public static final int MODE_LINGUISTIC;
    public static final int COMMAND_NEW;
    public static final int COMMAND_DELETE;

    default public void setTextArray(String[][] stringArray) {
    }

    default public String[][] getTextArray() {
    }

    default public void setText(LinkedList linkedList) {
    }

    default public LinkedList getText() {
    }

    default public void setListener(TextEditorListener textEditorListener) {
    }

    default public void setDictationMode(int n) {
    }

    default public int getDictationMode() {
    }

    default public void setMaxLength(int n) {
    }

    default public int getMaxLength() {
    }
}

