/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsi;

import de.audi.app.sdsmanager.dictation.component.AbstractDictationComponent;
import de.audi.app.sdsmanager.dictation.osgi.BundleEnvironment;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;
import java.util.Collection;
import java.util.LinkedList;
import org.dsi.ifc.online.DSIOnlineDictationListener;
import org.dsi.ifc.online.DictationValueSentence;

final class DsiOnlineDictationDefaultListener
extends AbstractDictationComponent
implements DSIOnlineDictationListener {
    private final Collection subscribers = new LinkedList();

    public DsiOnlineDictationDefaultListener(BundleEnvironment bundleEnvironment) {
        super(bundleEnvironment, "App.SDS.Dictation");
    }

    public synchronized void addSubscriber(DSIOnlineDictationListener dSIOnlineDictationListener) {
        this.subscribers.add(dSIOnlineDictationListener);
    }

    private synchronized DSIOnlineDictationListener[] getCurrentSubscribers() {
        Object[] objectArray = new DSIOnlineDictationListener[this.subscribers.size()];
        this.subscribers.toArray(objectArray);
        return objectArray;
    }

    public void asyncException(int n, String string, int n2) {
        this.log.log(100000, "[DsiOnlineDictationDefaultListener##asyncException] Not implemented.");
    }

    public void dictationResult(int n) {
        this.log.log(10000000, "[DsiOnlineDictationDefaultListener#dictationResult]");
        DSIOnlineDictationListener[] dSIOnlineDictationListenerArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < dSIOnlineDictationListenerArray.length; ++i2) {
            try {
                dSIOnlineDictationListenerArray[i2].dictationResult(n);
                continue;
            }
            catch (Exception exception) {
                DictationUtil.logException(this.log, exception, "[DsiOnlineDictationDefaultListener#dictationResult]");
            }
        }
    }

    public void finishDictationResponse(int n) {
        this.log.log(100000, "[DsiOnlineDictationDefaultListener#finishDictationResponse] Not implemented.");
    }

    public void dictationValueList(DictationValueSentence dictationValueSentence) {
        this.log.log(100000, "[DsiOnlineDictationDefaultListener#dictationValueList] Not implemented.");
    }
}

