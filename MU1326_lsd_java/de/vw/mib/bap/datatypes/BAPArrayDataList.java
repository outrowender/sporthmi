/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.datatypes;

import de.vw.mib.bap.datatypes.BAPArrayElement;
import java.util.Iterator;
import java.util.List;

public interface BAPArrayDataList {
    public int size();

    public BAPArrayElement get(int var1);

    public BAPArrayDataList getElements(int var1, int var2);

    public BAPArrayElement getFirst();

    public BAPArrayElement getLast();

    public Iterator getIterator();

    public BAPArrayElement[] toArray();

    public boolean addToList(List var1);

    public boolean addToList(int var1, List var2);
}

