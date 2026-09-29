/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import java.util.LinkedList;

public interface TextEditorModelGUI
extends HMIModelGUI {
    public static final int MODE_HAPTIC;
    public static final int MODE_LINGUISTIC;
    public static final int COMMAND_NEW;
    public static final int COMMAND_DELETE;

    default public void openAlternativesList(int n, int n2) {
    }

    default public void alternativeSelected(int n, int n2, int n3) {
    }

    default public void textChanged(int n, int n2, int n3) {
    }

    default public void editedText(LinkedList linkedList) {
    }

    default public LinkedList getText() {
    }

    default public int getDictationMode() {
    }

    default public int getMaxLength() {
    }

    default public void commandPressed(int n, int n2) {
    }
}

