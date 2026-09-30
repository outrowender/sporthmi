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
    public int getTerminalID();

    public DispatcherBase getDispatcher();

    public IDiagnosisManager getDiagnosisManager();

    public IServiceManager getServiceManager();

    public IFrameworkAccess getFramework();

    public ITitlelineHMIHandler getTitlelineHMIHandler();

    public IAudioManager getAudioManager();

    public IContentManager getContentManager();

    public ISourceController getSourceController();

    public ISDSCommandDistpacher getSDSDispatcher();

    public IMediaConfiguration getConfiguration();

    public IMediaPersistence getMediaPersistence();

    public IMediaDSIBaseController getDSIBaseController();

    public void addActionProxyListener(int var1, IActionProxyListener var2);

    public void addActionProxyListener(int[] var1, IActionProxyListener var2);

    public void removeActionProxyListener(IActionProxyListener var1);

    public boolean isRearSeatTerminal();

    public boolean isFrontTerminal();

    public boolean supportsCombiDisplay();

    public boolean isVisible();

    public IMediaLogger getLogger();

    public ISourceResolver getSourceResolver();

    public void resetSettings(int var1);

    public void addResetSettingsListener(IResetSettingsListener var1);

    public SelectionBrowser getSelectionBrowser();

    public boolean isStartup();
}

