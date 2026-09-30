/*
 * Decompiled with CFR 0.152.
 */
package de.eso.remotehmi.xpath;

import de.eso.remotehmi.xpath.AbstractPathEntry;
import de.eso.remotehmi.xpath.PoorMansXPathException;
import de.eso.remotehmi.xpath.PoorMansXPathParser;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

final class ExpressionCache {
    private final Map expressionCache = Collections.synchronizedMap(new WeakHashMap());
    private final int LRU_SIZE;
    private final LinkedList lru = new LinkedList();
    private final Log log = LogFactory.getLog(class$de$eso$remotehmi$xpath$ExpressionCache == null ? (class$de$eso$remotehmi$xpath$ExpressionCache = ExpressionCache.class$("de.eso.remotehmi.xpath.ExpressionCache")) : class$de$eso$remotehmi$xpath$ExpressionCache);
    static /* synthetic */ Class class$de$eso$remotehmi$xpath$ExpressionCache;

    ExpressionCache() {
        this.LRU_SIZE = 64;
    }

    final synchronized AbstractPathEntry[] get(Map map, String string) throws PoorMansXPathException {
        this.lru.remove(string);
        this.lru.addFirst(string);
        while (this.lru.size() > 64) {
            this.lru.removeLast();
        }
        AbstractPathEntry[] abstractPathEntryArray = null;
        SoftReference softReference = (SoftReference)this.expressionCache.get(string);
        if (softReference != null) {
            abstractPathEntryArray = (AbstractPathEntry[])softReference.get();
            if (abstractPathEntryArray != null) {
                return abstractPathEntryArray;
            }
        } else if (this.log.isDebugEnabled()) {
            this.log.debug(string);
        }
        PoorMansXPathParser poorMansXPathParser = new PoorMansXPathParser();
        try {
            abstractPathEntryArray = poorMansXPathParser.parse(map, string);
        }
        catch (Exception exception) {
            throw new PoorMansXPathException(new StringBuffer().append("Parse error for string \"").append(string).append("\".").toString(), exception);
        }
        this.expressionCache.put(string, new SoftReference(abstractPathEntryArray));
        return abstractPathEntryArray;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

