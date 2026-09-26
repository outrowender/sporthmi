/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.diagnosis;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalLogger;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.diagnosis.IDiagnosisDataProvider;
import de.audi.tghu.command.CommandListManager;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;
import java.util.List;

public class DiagnosisProvider
implements ITerminalModeComponent,
IDiagnosisDataProvider {
    private static final String LOGCLASS;
    private IContext context;
    private CommandListManager commandListManager;
    private ITerminalLogger logger;

    public DiagnosisProvider(IContext iContext) {
        this.context = iContext;
    }

    @Override
    public void init() {
        this.context.getDiagnosisManager().addDataProvider(-1, this);
        this.commandListManager = this.context.getCommandListManager();
        this.logger = this.context.getLogger();
    }

    @Override
    public void deinit() {
    }

    @Override
    public String getDiagKey() {
        return "getCommandQueue";
    }

    @Override
    public String getDiagValue() {
        this.logger.main().log(1078071040, "[%1.getDiagValue]", (Object)"DiagnosisProvider");
        Buffer buffer = new Buffer(500);
        if (null != this.commandListManager.getActiveCommandList()) {
            buffer.append(this.commandListManager.getActiveCommandList().toString());
        }
        List list = this.commandListManager.getQueue().getCommandLists();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            buffer.append(iterator.next().toString());
        }
        return buffer.toString();
    }
}

