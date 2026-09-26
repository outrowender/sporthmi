/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
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

    @Override
    public void match(Map map, Node node, List list) {
    }

    @Override
    public List matchList(Map map, List list) {
        int n = -1;
        try {
            double d2 = Double.parseDouble((String)this.name);
            n = (int)d2;
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (n == -1) {
            throw new RuntimeException(new StringBuffer().append("Invalid index ").append(this.name).append(".").toString());
        }
        if (--n < 0 || n >= list.size()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(list.get(n));
        return arrayList;
    }
}

