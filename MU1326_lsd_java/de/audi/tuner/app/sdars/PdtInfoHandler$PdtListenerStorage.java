/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.sdars.PdtInfoHandler$1;
import de.audi.tuner.app.sdars.PdtInfoHandler$ClassifiedPdtListener;
import de.audi.tuner.ifc.listener.IPdtListener;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;

class PdtInfoHandler$PdtListenerStorage {
    private final Map sIdToClassifiedListenerList = new HashMap();

    private PdtInfoHandler$PdtListenerStorage() {
    }

    public void addListener(int n, IPdtListener iPdtListener, boolean bl) {
        ArrayList arrayList = (ArrayList)this.sIdToClassifiedListenerList.get(new Integer(n));
        if (arrayList == null) {
            arrayList = new ArrayList(10);
            this.sIdToClassifiedListenerList.put(new Integer(n), arrayList);
        }
        Iterator iterator = arrayList.iterator();
        boolean bl2 = false;
        while (iterator.hasNext()) {
            PdtInfoHandler$ClassifiedPdtListener pdtInfoHandler$ClassifiedPdtListener = (PdtInfoHandler$ClassifiedPdtListener)iterator.next();
            if (!pdtInfoHandler$ClassifiedPdtListener.pdtListener.equals(iPdtListener)) continue;
            pdtInfoHandler$ClassifiedPdtListener.interestedInGracenoteCoverArt = bl;
            bl2 = true;
            break;
        }
        if (!bl2) {
            arrayList.add(new PdtInfoHandler$ClassifiedPdtListener(iPdtListener, bl));
        }
    }

    public boolean removeListener(int n, IPdtListener iPdtListener) {
        boolean bl = this.hasListenersForSidInterestedInGracenoteCoverArt(n);
        ArrayList arrayList = (ArrayList)this.sIdToClassifiedListenerList.get(new Integer(n));
        if (arrayList != null) {
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                if (!((PdtInfoHandler$ClassifiedPdtListener)iterator.next()).pdtListener.equals(iPdtListener)) continue;
                iterator.remove();
            }
            if (arrayList.isEmpty()) {
                this.sIdToClassifiedListenerList.remove(new Integer(n));
            }
        }
        boolean bl2 = !this.hasListenersForSidInterestedInGracenoteCoverArt(n);
        return bl && bl2;
    }

    public Collection getAllSIdsWithRegisteredListeners() {
        return new ArrayList(this.sIdToClassifiedListenerList.keySet());
    }

    public Collection getListenersForSId(int n) {
        ArrayList arrayList = (ArrayList)this.sIdToClassifiedListenerList.get(new Integer(n));
        List list = Collections.EMPTY_LIST;
        if (arrayList != null) {
            list = new ArrayList(arrayList.size());
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                list.add(((PdtInfoHandler$ClassifiedPdtListener)iterator.next()).pdtListener);
            }
        }
        return list;
    }

    public boolean hasListenersForSid(int n) {
        return this.sIdToClassifiedListenerList.containsKey(new Integer(n));
    }

    public boolean hasListenersForSidInterestedInGracenoteCoverArt(int n) {
        ArrayList arrayList = (ArrayList)this.sIdToClassifiedListenerList.get(new Integer(n));
        if (arrayList != null) {
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                if (!((PdtInfoHandler$ClassifiedPdtListener)iterator.next()).interestedInGracenoteCoverArt) continue;
                return true;
            }
        }
        return false;
    }

    public String dumpListenerData() {
        Buffer buffer = new Buffer(1000);
        Iterator iterator = this.sIdToClassifiedListenerList.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            Integer n = (Integer)map$Entry.getKey();
            ArrayList arrayList = (ArrayList)map$Entry.getValue();
            buffer.append("sId ").append(n.toString()).append(": ");
            Iterator iterator2 = arrayList.iterator();
            while (iterator2.hasNext()) {
                PdtInfoHandler$ClassifiedPdtListener pdtInfoHandler$ClassifiedPdtListener = (PdtInfoHandler$ClassifiedPdtListener)iterator2.next();
                buffer.append(pdtInfoHandler$ClassifiedPdtListener.pdtListener);
                buffer.append(" (gracenote ").append(pdtInfoHandler$ClassifiedPdtListener.interestedInGracenoteCoverArt).append("), ");
            }
            buffer.delete(buffer.length() - 2, buffer.length());
            buffer.append("\n");
        }
        return buffer.toString();
    }

    /* synthetic */ PdtInfoHandler$PdtListenerStorage(PdtInfoHandler$1 pdtInfoHandler$1) {
        this();
    }
}

