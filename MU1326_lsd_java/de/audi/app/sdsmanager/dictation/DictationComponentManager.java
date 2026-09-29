/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.sds.dictation.DictationSwDiagnosis
 */
package de.audi.app.sdsmanager.dictation;

import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateManager;
import de.audi.app.sdsmanager.dictation.combinedstate.IDictationStateManager;
import de.audi.app.sdsmanager.dictation.component.AbstractDictationComponent;
import de.audi.app.sdsmanager.dictation.component.IDictationComponent;
import de.audi.app.sdsmanager.dictation.dispatcher.DispatcherManager;
import de.audi.app.sdsmanager.dictation.dispatcher.IDispatcherManager;
import de.audi.app.sdsmanager.dictation.dsi.DsiOnlineDictationAccess;
import de.audi.app.sdsmanager.dictation.dsi.DsiOnlineDictationPrimaryListener;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter;
import de.audi.app.sdsmanager.dictation.language.LanguageManager;
import de.audi.app.sdsmanager.dictation.osgi.BundleEnvironment;
import de.audi.app.sdsmanager.dictation.progressbar.RecordingProgressBarController;
import de.audi.app.sdsmanager.dictation.recognizer.IRecognizerStateObserver;
import de.audi.app.sdsmanager.dictation.statechoice.DictationStateChoiceController;
import de.audi.app.sdsmanager.dictation.texteditor.ExtendedTextEditor;
import de.audi.app.sdsmanager.dictation.texteditor.IExtendedTextEditor;
import de.audi.app.sdsmanager.dictation.user.UserIdManager;
import de.audi.atip.base.IFrameworkAccess;
import de.mib.swdiagnosis.sds.dictation.DictationSwDiagnosis;
import org.osgi.framework.BundleContext;

public final class DictationComponentManager
extends AbstractDictationComponent {
    private final DispatcherManager dispatcherManager;
    private final DsiOnlineDictationAccess dsiOnlineDictationAccess;
    private final DsiOnlineDictationPrimaryListener dsiOnlineDictationPrimaryListener;
    private final DsiDictationAdapter dsiDictationAdapter;
    private final DictationStateManager dictationStateManager;
    private final ExtendedTextEditor extendedTextEditor;
    private final DictationSwDiagnosis dictationSwDiagnosis;

    public DictationComponentManager(BundleEnvironment bundleEnvironment) {
        super(bundleEnvironment, "App.SDS.Dictation");
        this.dispatcherManager = new DispatcherManager(bundleEnvironment);
        this.addComponent(this.dispatcherManager);
        this.dictationSwDiagnosis = new DictationSwDiagnosis(bundleEnvironment);
        this.addComponent((IDictationComponent)this.dictationSwDiagnosis);
        this.dsiOnlineDictationAccess = new DsiOnlineDictationAccess(bundleEnvironment);
        this.dsiOnlineDictationPrimaryListener = new DsiOnlineDictationPrimaryListener(bundleEnvironment);
        this.addComponent(this.dsiOnlineDictationAccess);
        this.addComponent(this.dsiOnlineDictationPrimaryListener);
        this.dsiDictationAdapter = new DsiDictationAdapter(bundleEnvironment);
        this.addComponent(this.dsiDictationAdapter);
        this.dictationStateManager = new DictationStateManager(bundleEnvironment);
        this.addComponent(this.dictationStateManager);
        DictationStateChoiceController dictationStateChoiceController = new DictationStateChoiceController(bundleEnvironment);
        RecordingProgressBarController recordingProgressBarController = new RecordingProgressBarController(bundleEnvironment);
        this.addComponent(dictationStateChoiceController);
        this.addComponent(recordingProgressBarController);
        this.addComponent(new LanguageManager(bundleEnvironment));
        this.addComponent(new UserIdManager(bundleEnvironment));
        this.extendedTextEditor = new ExtendedTextEditor(bundleEnvironment);
        this.addComponent(this.extendedTextEditor);
    }

    public IFrameworkAccess getFramework() {
        return this.framework;
    }

    public BundleContext getBundleContext() {
        return this.bundleContext;
    }

    public IDispatcherManager getDispatcherManager() {
        return this.dispatcherManager;
    }

    public DsiOnlineDictationAccess getDsiOnlineDictationAccess() {
        return this.dsiOnlineDictationAccess;
    }

    public DsiOnlineDictationPrimaryListener getDsiOnlineDictationPrimaryListener() {
        return this.dsiOnlineDictationPrimaryListener;
    }

    public DsiDictationAdapter getDsiDictationAdapter() {
        return this.dsiDictationAdapter;
    }

    public IRecognizerStateObserver getRecognizerStateObserver() {
        return this.dictationStateManager;
    }

    public IDictationStateManager getDictationStateManager() {
        return this.dictationStateManager;
    }

    public IExtendedTextEditor getExtendedTextEditor() {
        return this.extendedTextEditor;
    }

    public DictationSwDiagnosis getDictationSwDiagnosis() {
        return this.dictationSwDiagnosis;
    }
}

