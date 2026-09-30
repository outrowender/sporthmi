/*
 * Decompiled with CFR 0.152.
 */
package de.eso.remotehmi.xpath;

import de.eso.remotehmi.xpath.AbstractPathEntry;
import de.eso.remotehmi.xpath.ExpressionCache;
import de.eso.remotehmi.xpath.NodeListWrapper;
import de.eso.remotehmi.xpath.PoorMansXPathException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Node;

public class PoorMansXPath {
    private static final ExpressionCache cache = new ExpressionCache();

    public static Object resolve(Map map, Node node, String string) throws PoorMansXPathException {
        AbstractPathEntry[] abstractPathEntryArray = cache.get(map, string);
        if (abstractPathEntryArray == null) {
            return null;
        }
        List list = new ArrayList(5);
        try {
            list.add(node);
            for (int i2 = 0; i2 < abstractPathEntryArray.length; ++i2) {
                AbstractPathEntry abstractPathEntry = abstractPathEntryArray[i2];
                List list2 = abstractPathEntry.matchList(map, list);
                if (list2.size() == 0) {
                    return null;
                }
                list = list2;
            }
        }
        catch (NullPointerException nullPointerException) {
            list = null;
        }
        catch (Exception exception) {
            list = null;
        }
        return new NodeListWrapper(list);
    }
}

