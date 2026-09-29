/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media;

import de.audi.app.media.IResetSettingsListener;
import de.audi.app.media.ITitlelineHMIHandler;
import de.audi.app.media.actionproxy.IActionProxyListener;
import de.audi.app.media.audio.IAudioManager;
import de.audi.app.media.configuration.IMediaConfiguration;
import de.audi.app.media.content.IContentManager;
import de.audi.app.media.diagnosis.IDiagnosisManager;
import de.audi.app.media.dsi.media.IMediaDSIBaseController;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.persistence.IMediaPersistence;
import de.audi.app.media.sds.ISDSCommandDistpacher;
import de.audi.app.media.selection.SelectionBrowser;
import de.audi.app.media.source.ISourceController;
import de.audi.app.media.source.ISourceResolver;
import de.audi.atip.base.IFrameworkAccess;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public interface IMediaTerminal {
    default public int getTerminalID() {
    }

    default public DispatcherBase getDispatcher() {
    }

    default public IDiagnosisManager getDiagnosisManager() {
    }

    default public IServiceManager getServiceManager() {
    }

    default public IFrameworkAccess getFramework() {
    }

    default public ITitlelineHMIHandler getTitlelineHMIHandler() {
    }

    default public IAudioManager getAudioManager() {
    }

    default public IContentManager getContentManager() {
    }

    default public ISourceController getSourceController() {
    }

    default public ISDSCommandDistpacher getSDSDispatcher() {
    }

    default public IMediaConfiguration getConfiguration() {
    }

    default public IMediaPersistence getMediaPersistence() {
    }

    default public IMediaDSIBaseController getDSIBaseController() {
    }

    default public void addActionProxyListener(int n, IActionProxyListener iActionProxyListener) {
    }

    default public void addActionProxyListener(int[] nArray, IActionProxyListener iActionProxyListener) {
    }

    default public void removeActionProxyListener(IActionProxyListener iActionProxyListener) {
    }

    default public boolean isRearSeatTerminal() {
    }

    default public boolean isFrontTerminal() {
    }

    default public boolean supportsCombiDisplay() {
    }

    default public boolean isVisible() {
    }

    default public IMediaLogger getLogger() {
    }

    default public ISourceResolver getSourceResolver() {
    }

    default public void resetSettings(int n) {
    }

    default public void addResetSettingsListener(IResetSettingsListener iResetSettingsListener) {
    }

    default public SelectionBrowser getSelectionBrowser() {
    }

    default public boolean isStartup() {
    }
}

