/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AsianInputMethod;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionDataFetcher;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionDataFetcherListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractConversionDataFetcher
implements IConversionDataFetcher {
    private List registeredConversionFetcherListener = new LinkedList();

    @Override
    public final void registerConversionFetcherListener(IConversionDataFetcherListener iConversionDataFetcherListener) {
        this.registeredConversionFetcherListener.add(iConversionDataFetcherListener);
    }

    @Override
    public final boolean unregisterConversionFetcherListener(IConversionDataFetcherListener iConversionDataFetcherListener) {
        Iterator iterator = this.registeredConversionFetcherListener.iterator();
        while (iterator.hasNext()) {
            IConversionDataFetcherListener iConversionDataFetcherListener2 = (IConversionDataFetcherListener)iterator.next();
            if (iConversionDataFetcherListener2 != iConversionDataFetcherListener) continue;
            iterator.remove();
            return true;
        }
        return false;
    }

    protected final void notifyConversionsAvailable(String string, List list) {
        Iterator iterator = this.registeredConversionFetcherListener.iterator();
        while (iterator.hasNext()) {
            IConversionDataFetcherListener iConversionDataFetcherListener = (IConversionDataFetcherListener)iterator.next();
            iConversionDataFetcherListener.onConversionAvailableChange(string, list);
        }
    }

    protected final void notifyNextValidCharactersChanged(String string, String string2) {
        this.notifyNextValidCharactersChanged(string, string2, null);
    }

    protected final void notifyNextValidCharactersChanged(String string, String string2, String string3) {
        Iterator iterator = this.registeredConversionFetcherListener.iterator();
        while (iterator.hasNext()) {
            IConversionDataFetcherListener iConversionDataFetcherListener = (IConversionDataFetcherListener)iterator.next();
            iConversionDataFetcherListener.onNextValidCharactersChange(string, string2, string3);
        }
    }

    public static int getIndexOfItem(List list, String string) {
        for (int i2 = 0; i2 < list.size(); ++i2) {
            if (!list.get(i2).equals(string)) continue;
            return i2;
        }
        return -1;
    }

    @Override
    public void requestInitialValidCharacters() {
    }

    @Override
    public void setInputMethod(AsianInputMethod asianInputMethod) {
    }
}

