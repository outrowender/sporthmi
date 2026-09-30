/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.dsiadapter.IDsiDictationAdapter;
import de.audi.app.sdsmanager.dictation.osgi.BundleEnvironment;
import de.audi.app.sdsmanager.dictation.osgi.ServiceManager;
import de.audi.app.sdsmanager.dictation.recognizer.IRecognizerStateObserver;
import de.audi.app.sdsmanager.dictation.texteditor.IExtendedTextEditor;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;

public final class DictationService {
    private volatile LogChannel log;
    private volatile ServiceManager serviceManager;
    private volatile DictationComponentManager dictationComponentManager;

    public void start(BundleContext bundleContext, IFrameworkAccess iFrameworkAccess) {
        this.log = iFrameworkAccess.getLogChannel("App.SDS.Dictation");
        this.log.log(1000000, "[DictationService#start]");
        BundleEnvironment bundleEnvironment = new BundleEnvironment(bundleContext, iFrameworkAccess);
        this.serviceManager = new ServiceManager(bundleEnvironment);
        this.dictationComponentManager = new DictationComponentManager(bundleEnvironment);
        this.dictationComponentManager.init(this.dictationComponentManager);
        this.dictationComponentManager.connect(this.serviceManager);
    }

    public void stop() {
        this.log.log(1000000, "[DictationComponentManager#stop]");
        this.serviceManager.disconnect();
        this.dictationComponentManager.disconnect();
        this.dictationComponentManager.dispose();
    }

    public IDsiDictationAdapter getDsiDictationAdapter() {
        return this.dictationComponentManager.getDsiDictationAdapter();
    }

    public IRecognizerStateObserver getRecognizerStateObserver() {
        return this.dictationComponentManager.getRecognizerStateObserver();
    }

    public IExtendedTextEditor getExtendedTextEditor() {
        return this.dictationComponentManager.getExtendedTextEditor();
    }
}

