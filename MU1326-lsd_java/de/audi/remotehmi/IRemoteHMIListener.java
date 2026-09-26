/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

import de.audi.remotehmi.IRemoteHMIListener$LogLevel;
import de.audi.remotehmi.IRemoteHMISpeechCommandSDS;
import de.audi.remotehmi.IRemoteHMISpeechContext;
import de.audi.remotehmi.IRemoteHMISpeechContext$CommandDisplay;
import de.audi.remotehmi.IRemoteHMISpeechHelpContext;
import de.audi.remotehmi.IRemoteHMISpeechHelpIntroPrompt;
import de.audi.remotehmi.IRemoteHMISpeechTopicContext;
import de.audi.remotehmi.RemoteHMIView;

public interface IRemoteHMIListener {
    default public void setContextResult(int n) {
    }

    default public void stopResult(int n) {
    }

    default public void indicateContext(String string, int n) {
    }

    default public void indicateView(String string, RemoteHMIView remoteHMIView) {
    }

    default public void indicateViewProperties(String string, RemoteHMIView remoteHMIView) {
    }

    default public void indicateSpeechContext(String string, IRemoteHMISpeechContext iRemoteHMISpeechContext) {
    }

    default public void indicateSpeechHelpContexts(IRemoteHMISpeechHelpContext[] iRemoteHMISpeechHelpContextArray, IRemoteHMISpeechTopicContext[] iRemoteHMISpeechTopicContextArray, IRemoteHMISpeechHelpIntroPrompt iRemoteHMISpeechHelpIntroPrompt) {
    }

    default public void indicateSpeechGlobalCommands(IRemoteHMISpeechCommandSDS[] iRemoteHMISpeechCommandSDSArray) {
    }

    default public void indicateCommand(int n, Object object) {
    }

    default public void indicateCurrentSpeechHelpContext(String string) {
    }

    default public void indicateLogMessage(LogLevel logLevel, String string, String string2, Object object, Object object2, Object object3, Object object4) {
    }

    default public void indicateContextRemoved(String string) {
    }

    default public void indicateContextCreated(String string, int n) {
    }

    default public void indicateContextSuspended(String string) {
    }

    default public void indicateContextsCommandDisplay(IRemoteHMISpeechContext.CommandDisplay commandDisplay) {
    }
}

