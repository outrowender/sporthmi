/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.sds.dictation.DsiOnlineDictationListenerDiagPlugIn
 *  de.mib.swdiagnosis.sds.dictation.IDiagPlugIn
 *  de.mib.swdiagnosis.sds.dictation.IDiagProvider
 */
package de.audi.app.sdsmanager.dictation.dsi;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.component.AbstractDictationComponent;
import de.audi.app.sdsmanager.dictation.dsi.DsiOnlineDictationDefaultListener;
import de.audi.app.sdsmanager.dictation.dsi.DsiOnlineDictationPrimaryListener$1;
import de.audi.app.sdsmanager.dictation.dsi.DsiOnlineDictationPrimaryListener$2;
import de.audi.app.sdsmanager.dictation.dsi.DsiOnlineDictationPrimaryListener$3;
import de.audi.app.sdsmanager.dictation.dsi.DsiOnlineDictationPrimaryListener$4;
import de.audi.app.sdsmanager.dictation.osgi.BundleEnvironment;
import de.audi.app.sdsmanager.dictation.osgi.IServiceRegistry;
import de.audi.app.sdsmanager.dictation.osgi.ServiceProperties;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.mib.swdiagnosis.sds.dictation.DsiOnlineDictationListenerDiagPlugIn;
import de.mib.swdiagnosis.sds.dictation.IDiagPlugIn;
import de.mib.swdiagnosis.sds.dictation.IDiagProvider;
import org.dsi.ifc.online.DSIOnlineDictationListener;
import org.dsi.ifc.online.DictationValueSentence;

public final class DsiOnlineDictationPrimaryListener
extends AbstractDictationComponent
implements DSIOnlineDictationListener,
IDiagProvider {
    private final DsiOnlineDictationDefaultListener dsiOnlineDictationDefaultListener;
    private volatile ICommandResponseSupplier commandResponseSupplier;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOnlineDictationListener;

    public DsiOnlineDictationPrimaryListener(BundleEnvironment bundleEnvironment) {
        super(bundleEnvironment, "App.SDS.Dictation");
        this.dsiOnlineDictationDefaultListener = new DsiOnlineDictationDefaultListener(bundleEnvironment);
        this.addComponent(this.dsiOnlineDictationDefaultListener);
    }

    @Override
    public void init(DictationComponentManager dictationComponentManager) {
        super.init(dictationComponentManager);
        this.commandResponseSupplier = this.createCommandResponseSupplier();
        dictationComponentManager.getDictationSwDiagnosis().registerDiagProvider((IDiagProvider)this);
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        super.connect(iServiceRegistry);
        iServiceRegistry.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = DsiOnlineDictationPrimaryListener.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this, ServiceProperties.createDsiListenerProperties("SDSManager", (class$org$dsi$ifc$online$DSIOnlineDictationListener == null ? (class$org$dsi$ifc$online$DSIOnlineDictationListener = DsiOnlineDictationPrimaryListener.class$("org.dsi.ifc.online.DSIOnlineDictationListener")) : class$org$dsi$ifc$online$DSIOnlineDictationListener).getName(), 0));
    }

    public void addSubscriber(DSIOnlineDictationListener dSIOnlineDictationListener) {
        this.dsiOnlineDictationDefaultListener.addSubscriber(dSIOnlineDictationListener);
    }

    DsiOnlineDictationDefaultListener getDsiOnlineDictationDefaultListener() {
        return this.dsiOnlineDictationDefaultListener;
    }

    private void executeResponse(String string, CommandResponse commandResponse) {
        CommandResponse.executeTryCatch(this.commandResponseSupplier, commandResponse, string);
    }

    private ICommandResponseSupplier createCommandResponseSupplier() {
        return new DsiOnlineDictationPrimaryListener$1(this);
    }

    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new DsiOnlineDictationListenerDiagPlugIn((DSIOnlineDictationListener)this)};
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "[DsiOnlineDictationPrimaryListener#asyncException] errorCode = %1, errorMsg = %2, requestType = %3", (Object)String.valueOf(n), (Object)String.valueOf(string), (Object)String.valueOf(n2));
    }

    @Override
    public void dictationResult(int n) {
        this.log.log(1078071040, "[DsiOnlineDictationPrimaryListener#dictationResult] returnCode = %1", (long)n);
        this.executeResponse("dictationResult", new DsiOnlineDictationPrimaryListener$2(this, n));
    }

    @Override
    public void finishDictationResponse(int n) {
        this.log.log(1078071040, "[DsiOnlineDictationPrimaryListener#finishDictationResponse] result = %1", (long)n);
        this.executeResponse("finishDictationResponse", new DsiOnlineDictationPrimaryListener$3(this, n));
    }

    @Override
    public void dictationValueList(DictationValueSentence dictationValueSentence) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[DsiOnlineDictationPrimaryListener#dictationValueList] dictationSentence = %1", (Object)String.valueOf(dictationValueSentence));
        }
        this.executeResponse("dictationValueList", new DsiOnlineDictationPrimaryListener$4(this, dictationValueSentence));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ DictationComponentManager access$000(DsiOnlineDictationPrimaryListener dsiOnlineDictationPrimaryListener) {
        return dsiOnlineDictationPrimaryListener.dictationComponentManager;
    }

    static /* synthetic */ DsiOnlineDictationDefaultListener access$100(DsiOnlineDictationPrimaryListener dsiOnlineDictationPrimaryListener) {
        return dsiOnlineDictationPrimaryListener.dsiOnlineDictationDefaultListener;
    }

    static /* synthetic */ LogChannel access$200(DsiOnlineDictationPrimaryListener dsiOnlineDictationPrimaryListener) {
        return dsiOnlineDictationPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$300(DsiOnlineDictationPrimaryListener dsiOnlineDictationPrimaryListener) {
        return dsiOnlineDictationPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$400(DsiOnlineDictationPrimaryListener dsiOnlineDictationPrimaryListener) {
        return dsiOnlineDictationPrimaryListener.log;
    }
}

