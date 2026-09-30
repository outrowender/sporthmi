/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

import de.audi.remotehmi.IRemoteHMISpeechCommandSDS;
import de.audi.remotehmi.IRemoteHMISpeechContext;
import de.audi.remotehmi.IRemoteHMISpeechHelpContext;
import de.audi.remotehmi.IRemoteHMISpeechHelpIntroPrompt;
import de.audi.remotehmi.IRemoteHMISpeechTopicContext;
import de.audi.remotehmi.RemoteHMIView;

public interface IRemoteHMIListener {
    public void setContextResult(int var1);

    public void stopResult(int var1);

    public void indicateContext(String var1, int var2);

    public void indicateView(String var1, RemoteHMIView var2);

    public void indicateViewProperties(String var1, RemoteHMIView var2);

    public void indicateSpeechContext(String var1, IRemoteHMISpeechContext var2);

    public void indicateSpeechHelpContexts(IRemoteHMISpeechHelpContext[] var1, IRemoteHMISpeechTopicContext[] var2, IRemoteHMISpeechHelpIntroPrompt var3);

    public void indicateSpeechGlobalCommands(IRemoteHMISpeechCommandSDS[] var1);

    public void indicateCommand(int var1, Object var2);

    public void indicateCurrentSpeechHelpContext(String var1);

    public void indicateLogMessage(LogLevel var1, String var2, String var3, Object var4, Object var5, Object var6, Object var7);

    public void indicateContextRemoved(String var1);

    public void indicateContextCreated(String var1, int var2);

    public void indicateContextSuspended(String var1);

    public void indicateContextsCommandDisplay(IRemoteHMISpeechContext.CommandDisplay var1);

    public static final class LogLevel {
        public static final LogLevel TRACE = new LogLevel();
        public static final LogLevel DEBUG = new LogLevel();
        public static final LogLevel INFO = new LogLevel();
        public static final LogLevel WARN = new LogLevel();
        public static final LogLevel ERROR = new LogLevel();
    }
}

