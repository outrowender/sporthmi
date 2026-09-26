/*
 * Decompiled with CFR 0.152.
 */
package de.eso.remotehmi.xpath;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Node;

public abstract class AbstractPathEntry {
    public String name;
    public String ns;

    public AbstractPathEntry(String string, String string2) {
        this.name = string;
        this.ns = string2;
    }

    public abstract void match(Map map, Node node, List list) {
    }

    public List matchList(Map map, List list) {
        ArrayList arrayList = new ArrayList(5);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            Object object = list.get(i2);
            if (!(object instanceof Node)) {
                throw new RuntimeException(new StringBuffer().append("Invalid child ").append(object).toString());
            }
            Node node = (Node)object;
            this.match(map, node, arrayList);
        }
        return arrayList;
    }
}

