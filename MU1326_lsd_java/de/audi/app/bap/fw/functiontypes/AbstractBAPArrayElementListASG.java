/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.requests.StatusArray;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractBAPArrayElementListASG {
    private final LogChannel logChannel;
    private boolean upToDate = false;
    protected final List list = new ArrayList();
    public static final int NOT_FOUND = -1;

    protected AbstractBAPArrayElementListASG(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isUpToDate() {
        List list = this.list;
        synchronized (list) {
            return this.upToDate;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int size() {
        List list = this.list;
        synchronized (list) {
            return this.list.size();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void clear() {
        List list = this.list;
        synchronized (list) {
            this.upToDate = false;
            this.list.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean hasMoreElementsToRequest(StatusArray statusArray) {
        List list = this.list;
        synchronized (list) {
            return statusArray.getNumberOfElements() > this.list.size();
        }
    }

    public abstract boolean isDeleted(BAPArrayElement var1);

    private static int indexOfElementWithPosId(List list, int n) {
        for (int i2 = 0; i2 < list.size(); ++i2) {
            if (((BAPArrayElement)list.get(i2)).getPos() != n) continue;
            return i2;
        }
        return -1;
    }

    public void handleFoundElement(BAPArrayElement bAPArrayElement, int n) {
        if (this.isDeleted(bAPArrayElement)) {
            this.list.remove(n);
        } else {
            this.list.set(n, bAPArrayElement);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void mergeElementsInList(StatusArray statusArray) {
        List list = this.list;
        synchronized (list) {
            if (statusArray.getNumberOfElements() == 0) {
                this.list.clear();
                return;
            }
            Iterator iterator = statusArray.getArrayData().getIterator();
            while (iterator.hasNext()) {
                BAPArrayElement bAPArrayElement = (BAPArrayElement)iterator.next();
                int n = AbstractBAPArrayElementListASG.indexOfElementWithPosId(this.list, bAPArrayElement.getPos());
                if (n == -1) {
                    if (!this.isDeleted(bAPArrayElement)) {
                        this.list.add(bAPArrayElement);
                        continue;
                    }
                    this.logChannel.log(100000, "[BAPArrayElementList#mergeElementsInList] new element marked as deleted. Ignoring:\n%1", (Object)bAPArrayElement);
                    continue;
                }
                this.handleFoundElement(bAPArrayElement, n);
            }
            if (this.list.size() == statusArray.getNumberOfElements()) {
                this.upToDate = true;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object[] toArray(Class clazz, BAPElementConverter bAPElementConverter) {
        List list = this.list;
        synchronized (list) {
            Object[] objectArray = (Object[])Array.newInstance(clazz, this.list.size());
            Iterator iterator = this.list.iterator();
            int n = 0;
            while (iterator.hasNext()) {
                objectArray[n] = bAPElementConverter.convert((BAPArrayElement)iterator.next());
                ++n;
            }
            return objectArray;
        }
    }

    public static interface BAPElementConverter {
        public Object convert(BAPArrayElement var1);
    }
}

