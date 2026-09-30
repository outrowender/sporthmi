/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.TextEditorListener;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import java.util.LinkedList;

public interface TextEditorModelApp
extends HMIModelApp {
    public static final int MODE_HAPTIC = 0;
    public static final int MODE_LINGUISTIC = 1;
    public static final int COMMAND_NEW = 1;
    public static final int COMMAND_DELETE = 2;

    public void setTextArray(String[][] var1);

    public String[][] getTextArray();

    public void setText(LinkedList var1);

    public LinkedList getText();

    public void setListener(TextEditorListener var1);

    public void setDictationMode(int var1);

    public int getDictationMode();

    public void setMaxLength(int var1);

    public int getMaxLength();
}

