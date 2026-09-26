/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.dom;

import java.util.Vector;
import org.w3c.dom.DOMStringList;

public class DOMStringListImpl
implements DOMStringList {
    private Vector fStrings;

    public DOMStringListImpl() {
        this.fStrings = new Vector();
    }

    public DOMStringListImpl(Vector vector) {
        this.fStrings = vector;
    }

    @Override
    public String item(int n) {
        try {
            return (String)this.fStrings.elementAt(n);
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            return null;
        }
    }

    @Override
    public int getLength() {
        return this.fStrings.size();
    }

    @Override
    public boolean contains(String string) {
        return this.fStrings.contains(string);
    }

    public void add(String string) {
        this.fStrings.add(string);
    }
}

