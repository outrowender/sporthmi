/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

public interface SpellerListener {
    public void keyPressed(int var1, int var2, int var3);

    public void keyReleased(int var1, int var2, int var3);

    public void keyTyped(int var1, int var2, int var3);

    public void textChanged(int var1, String var2, char var3, int var4);

    public void focusedCharacter(int var1, char var2, int var3);

    public void commandPressed(int var1, int var2, int var3);
}

