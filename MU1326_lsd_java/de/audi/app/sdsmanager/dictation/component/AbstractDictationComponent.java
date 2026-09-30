/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.component;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.component.DictationComponentCollection;
import de.audi.app.sdsmanager.dictation.component.IDictationComponent;
import de.audi.app.sdsmanager.dictation.osgi.BundleEnvironment;
import de.audi.app.sdsmanager.dictation.osgi.IServiceRegistry;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;

public abstract class AbstractDictationComponent
implements IDictationComponent {
    protected final BundleContext bundleContext;
    protected final IFrameworkAccess framework;
    protected final LogChannel log;
    protected volatile DictationComponentManager dictationComponentManager;
    private final DictationComponentCollection subcomponents = new DictationComponentCollection();

    protected AbstractDictationComponent(BundleEnvironment bundleEnvironment, String string) {
        this.framework = bundleEnvironment.getFramework();
        this.bundleContext = bundleEnvironment.getBundleContext();
        this.log = this.framework.getLogChannel(string);
    }

    public final void addComponent(IDictationComponent iDictationComponent) {
        this.subcomponents.add(iDictationComponent);
    }

    public void init(DictationComponentManager dictationComponentManager) {
        this.dictationComponentManager = dictationComponentManager;
        this.subcomponents.initAll(dictationComponentManager);
    }

    public void dispose() {
        this.subcomponents.disposeAll();
    }

    public void connect(IServiceRegistry iServiceRegistry) {
        this.subcomponents.connectAll(iServiceRegistry);
    }

    public void disconnect() {
        this.subcomponents.disconnectAll();
    }
}

