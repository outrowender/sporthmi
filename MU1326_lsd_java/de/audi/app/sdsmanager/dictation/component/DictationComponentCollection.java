/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.component;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.component.IDictationComponent;
import de.audi.app.sdsmanager.dictation.osgi.IServiceRegistry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class DictationComponentCollection {
    private final List components = new ArrayList();

    DictationComponentCollection() {
    }

    public synchronized void add(IDictationComponent iDictationComponent) {
        this.components.add(iDictationComponent);
    }

    public synchronized void initAll(DictationComponentManager dictationComponentManager) {
        Iterator iterator = this.components.iterator();
        while (iterator.hasNext()) {
            ((IDictationComponent)iterator.next()).init(dictationComponentManager);
        }
    }

    public synchronized void disposeAll() {
        Iterator iterator = this.components.iterator();
        while (iterator.hasNext()) {
            ((IDictationComponent)iterator.next()).dispose();
        }
    }

    public synchronized void connectAll(IServiceRegistry iServiceRegistry) {
        Iterator iterator = this.components.iterator();
        while (iterator.hasNext()) {
            ((IDictationComponent)iterator.next()).connect(iServiceRegistry);
        }
    }

    public synchronized void disconnectAll() {
        Iterator iterator = this.components.iterator();
        while (iterator.hasNext()) {
            ((IDictationComponent)iterator.next()).disconnect();
        }
    }
}

