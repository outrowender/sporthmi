/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.IContent;
import de.audi.app.media.content.IContentContext;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.evo.content.IImplicitRepeatHandler;
import de.audi.app.media.evo.content.cdda.CDDAContent;
import de.audi.app.media.evo.content.data.DataContent;
import de.audi.app.media.evo.content.data.favorites.IFavoritesController;
import de.audi.app.media.evo.content.dvdvideo.DVDVideoContent;
import de.audi.app.media.evo.content.tv.TVContent;
import de.audi.app.media.extension.IContentProvider;
import de.audi.app.media.logger.IMediaLogger;

public class MediaEVOContentProviderImpl
implements IContentProvider {
    private static final String LOGCLASS;
    private final IMediaLogger logger;
    private volatile IFavoritesController favoritesController;
    private volatile IImplicitRepeatHandler implicitRepeatHandler;

    public MediaEVOContentProviderImpl(IMediaLogger iMediaLogger) {
        this.logger = iMediaLogger;
    }

    @Override
    public boolean provideContent(int n) {
        this.logger.main().log(-2137614336, "[%1.provideContent] '%2'", (Object)"MediaEVOContentProviderImpl", (long)n);
        return n == 0 || n == 1 || n == 2 || n == 4 || n == 3;
    }

    @Override
    public IContent createContent(int n, IContentContext iContentContext, IMediaTerminal iMediaTerminal, IMediaDSIPlayerController iMediaDSIPlayerController) {
        this.logger.main().log(1078071040, "[%1.createContent] '%2'", (Object)"MediaEVOContentProviderImpl", (long)n);
        switch (n) {
            case 0: {
                return new CDDAContent(iContentContext, iMediaTerminal, iMediaDSIPlayerController);
            }
            case 1: {
                return new DataContent(iContentContext, iMediaTerminal, iMediaDSIPlayerController, this.implicitRepeatHandler, this.favoritesController);
            }
            case 2: {
                return new DVDVideoContent(iContentContext, iMediaTerminal, iMediaDSIPlayerController);
            }
            case 3: 
            case 4: {
                return new TVContent(iContentContext, iMediaTerminal);
            }
        }
        return null;
    }

    public void setFavoritesController(IFavoritesController iFavoritesController) {
        this.favoritesController = iFavoritesController;
    }

    public void setImplicitRepeatHandler(IImplicitRepeatHandler iImplicitRepeatHandler) {
        this.implicitRepeatHandler = iImplicitRepeatHandler;
    }
}

