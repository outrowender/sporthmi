/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.error;

import de.audi.atip.error.ErrorManager;
import de.audi.atip.error.ErrorManager$1;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;

class ErrorManager$VersionInfoProvider
implements DumpInfoProvider {
    private final /* synthetic */ ErrorManager this$0;

    private ErrorManager$VersionInfoProvider(ErrorManager errorManager) {
        this.this$0 = errorManager;
    }

    @Override
    public String getName() {
        return "VersionInfo";
    }

    @Override
    public void dump(PrintStream printStream, String string) {
        printStream.println("-- OS Information --");
        printStream.println(new StringBuffer().append("CPU:            ").append(System.getProperty("os.arch")).toString());
        printStream.println(new StringBuffer().append("OS:             ").append(System.getProperty("os.name")).toString());
        printStream.println(new StringBuffer().append("Version:        ").append(System.getProperty("os.version")).toString());
        printStream.println();
        printStream.println("-- Java Information --");
        printStream.println(new StringBuffer().append("Java Vendor:    ").append(System.getProperty("java.vendor")).toString());
        printStream.println(new StringBuffer().append("Java Version:   ").append(System.getProperty("java.vm.version")).toString());
        printStream.println(new StringBuffer().append("Java VM Info:   ").append(System.getProperty("java.vm.info")).toString());
        printStream.println(new StringBuffer().append("Class Version:  ").append(System.getProperty("java.class.version")).toString());
        printStream.println(new StringBuffer().append("JXE Romimage:   ").append(System.getProperty("jxe.current.romimage.version")).toString());
        printStream.println(new StringBuffer().append("Library Version:").append(System.getProperty("com.ibm.oti.vm.library.version")).toString());
        printStream.println();
        printStream.println("-- DSI Information --");
        printStream.println(new StringBuffer().append("DSI_IFC_Version: ").append(ErrorManager.access$600(this.this$0).getVersionInfo().getDsiIfcVersion()).toString());
        printStream.println(new StringBuffer().append("Framework:       ").append(ErrorManager.access$600(this.this$0).getVersionInfo().getFrameworkVersion()).toString());
        printStream.println();
        printStream.println("-- HMI Information --");
        printStream.println(new StringBuffer().append("Variant:         ").append(System.getProperty("variant.label")).toString());
        printStream.println(new StringBuffer().append("HMI Version:     ").append(ErrorManager.access$600(this.this$0).getVersionInfo().getHMIVersion()).toString());
        printStream.println(new StringBuffer().append("Kanzi Version:   ").append(ErrorManager.access$600(this.this$0).getVersionInfo().getKanziVersion()).toString());
        printStream.println(new StringBuffer().append("Texttool:        ").append(ErrorManager.access$600(this.this$0).getVersionInfo().getTextToolVersion()).toString());
        printStream.println(new StringBuffer().append("Texttool_SDS:    ").append(ErrorManager.access$600(this.this$0).getVersionInfo().getTextToolSDSVersion()).toString());
    }

    /* synthetic */ ErrorManager$VersionInfoProvider(ErrorManager errorManager, ErrorManager$1 errorManager$1) {
        this(errorManager);
    }
}

