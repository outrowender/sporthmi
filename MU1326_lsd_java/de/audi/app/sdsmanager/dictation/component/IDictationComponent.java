/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.component;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.osgi.IServiceRegistry;

public interface IDictationComponent {
    default public void addComponent(IDictationComponent iDictationComponent) {
    }

    default public void init(DictationComponentManager dictationComponentManager) {
    }

    default public void dispose() {
    }

    default public void connect(IServiceRegistry iServiceRegistry) {
    }

    default public void disconnect() {
    }
}

