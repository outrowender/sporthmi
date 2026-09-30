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
import de.audi.app.sdsmanager.dictation.osgi.BundleEnvironment;
import de.audi.app.sdsmanager.dictation.osgi.IServiceRegistry;
import de.audi.app.sdsmanager.dictation.osgi.ServiceProperties;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.mib.swdiagnosis.sds.dictation.DsiOnlineDictationListenerDiagPlugIn;
import de.mib.swdiagnosis.sds.dictation.IDiagPlugIn;
import de.mib.swdiagnosis.sds.dictation.IDiagProvider;
import org.dsi.ifc.base.DSIListener;
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

    public void init(DictationComponentManager dictationComponentManager) {
        super.init(dictationComponentManager);
        this.commandResponseSupplier = this.createCommandResponseSupplier();
        dictationComponentManager.getDictationSwDiagnosis().registerDiagProvider((IDiagProvider)this);
    }

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
        return new ICommandResponseSupplier(){
            private final CommandListManager cmdListManager;
            private final LogChannel logChannel;
            private final String handlerName;
            {
                this.cmdListManager = DsiOnlineDictationPrimaryListener.this.dictationComponentManager.getDispatcherManager().getCommandListManager();
                this.logChannel = this.cmdListManager.getLogChannel();
                this.handlerName = DictationUtil.getShortClassName(DsiOnlineDictationPrimaryListener.this.getClass());
            }

            public DSIListener getDSIDefaultHandler() {
                return DsiOnlineDictationPrimaryListener.this.dsiOnlineDictationDefaultListener;
            }

            public CommandList getActiveCommandList() {
                return this.cmdListManager.getActiveCommandList();
            }

            public LogChannel getLogChannel() {
                return this.logChannel;
            }

            public String getHandlerName() {
                return this.handlerName;
            }
        };
    }

    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new DsiOnlineDictationListenerDiagPlugIn((DSIOnlineDictationListener)this)};
    }

    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "[DsiOnlineDictationPrimaryListener#asyncException] errorCode = %1, errorMsg = %2, requestType = %3", (Object)String.valueOf(n), (Object)String.valueOf(string), (Object)String.valueOf(n2));
    }

    public void dictationResult(final int n) {
        this.log.log(1000000, "[DsiOnlineDictationPrimaryListener#dictationResult] returnCode = %1", (long)n);
        this.executeResponse("dictationResult", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIOnlineDictationListener dSIOnlineDictationListener = DsiOnlineDictationPrimaryListener.this.dsiOnlineDictationDefaultListener;
                try {
                    dSIOnlineDictationListener = (DSIOnlineDictationListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    DictationUtil.logException(DsiOnlineDictationPrimaryListener.this.log, classCastException, "[DsiOnlineDictationPrimaryListener#dictationResult]");
                }
                dSIOnlineDictationListener.dictationResult(n);
            }
        });
    }

    public void finishDictationResponse(final int n) {
        this.log.log(1000000, "[DsiOnlineDictationPrimaryListener#finishDictationResponse] result = %1", (long)n);
        this.executeResponse("finishDictationResponse", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIOnlineDictationListener dSIOnlineDictationListener = DsiOnlineDictationPrimaryListener.this.dsiOnlineDictationDefaultListener;
                try {
                    dSIOnlineDictationListener = (DSIOnlineDictationListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    DictationUtil.logException(DsiOnlineDictationPrimaryListener.this.log, classCastException, "[DsiOnlineDictationPrimaryListener#finishDictationResponse]");
                }
                dSIOnlineDictationListener.finishDictationResponse(n);
            }
        });
    }

    public void dictationValueList(final DictationValueSentence dictationValueSentence) {
        if (this.log.isInfo()) {
            this.log.log(1000000, "[DsiOnlineDictationPrimaryListener#dictationValueList] dictationSentence = %1", (Object)String.valueOf(dictationValueSentence));
        }
        this.executeResponse("dictationValueList", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIOnlineDictationListener dSIOnlineDictationListener = DsiOnlineDictationPrimaryListener.this.dsiOnlineDictationDefaultListener;
                try {
                    dSIOnlineDictationListener = (DSIOnlineDictationListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    DictationUtil.logException(DsiOnlineDictationPrimaryListener.this.log, classCastException, "[DsiOnlineDictationPrimaryListener#dictationValueList]");
                }
                dSIOnlineDictationListener.dictationValueList(dictationValueSentence);
            }
        });
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

