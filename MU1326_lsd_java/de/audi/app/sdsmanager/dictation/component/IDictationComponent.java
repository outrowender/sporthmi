/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.component;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.osgi.IServiceRegistry;

public interface IDictationComponent {
    public void addComponent(IDictationComponent var1);

    public void init(DictationComponentManager var1);

    public void dispose();

    public void connect(IServiceRegistry var1);

    public void disconnect();
}

