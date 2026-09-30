/*
 * Decompiled with CFR 0.152.
 */
package de.eso.remotehmi.xpath;

import de.eso.remotehmi.xpath.AbstractPathEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Node;

public class SelectorPathEntry
extends AbstractPathEntry {
    public SelectorPathEntry(String string) {
        super(string, null);
    }

    public void match(Map map, Node node, List list) {
    }

    public List matchList(Map map, List list) {
        int n = -1;
        try {
            double d2 = Double.parseDouble(this.name);
            n = (int)d2;
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (n == -1) {
            throw new RuntimeException("Invalid index " + this.name + ".");
        }
        if (--n < 0 || n >= list.size()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(list.get(n));
        return arrayList;
    }
}

