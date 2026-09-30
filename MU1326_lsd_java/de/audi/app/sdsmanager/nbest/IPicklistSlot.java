/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.nbest;

public interface IPicklistSlot {
    public String getText();

    public void setText(String var1);

    public String getObjectStringID();

    public long getObjID();

    public int getIndex();

    public boolean isDuplicateSlot(IPicklistSlot var1);
}

