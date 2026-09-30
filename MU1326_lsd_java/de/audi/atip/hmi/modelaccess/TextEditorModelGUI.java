/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import java.util.LinkedList;

public interface TextEditorModelGUI
extends HMIModelGUI {
    public static final int MODE_HAPTIC = 0;
    public static final int MODE_LINGUISTIC = 1;
    public static final int COMMAND_NEW = 1;
    public static final int COMMAND_DELETE = 2;

    public void openAlternativesList(int var1, int var2);

    public void alternativeSelected(int var1, int var2, int var3);

    public void textChanged(int var1, int var2, int var3);

    public void editedText(LinkedList var1);

    public LinkedList getText();

    public int getDictationMode();

    public int getMaxLength();

    public void commandPressed(int var1, int var2);
}

