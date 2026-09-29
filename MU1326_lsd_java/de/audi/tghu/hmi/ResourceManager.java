/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIBundle;
import de.audi.atip.hmi.view.IImageLoader;
import de.audi.atip.log.LogChannel;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class ResourceManager {
    public static final boolean LOAD_FROM_FILE;
    protected final LogChannel logHMIService;
    protected final IFrameworkAccess framework;
    protected final int terminalID;
    private IImageLoader imageLoader;

    public ResourceManager(IFrameworkAccess iFrameworkAccess, int n) {
        this.framework = iFrameworkAccess;
        this.logHMIService = iFrameworkAccess.getLogChannel("Fw.HMIService.Main");
        this.terminalID = n;
    }

    public Object getImageImpl(int n, boolean bl, int n2, int n3) {
        this.logHMIService.log(-2137614336, "ResourceManager: HMIServiceImpl.getImage(id = %1, %2) called; moduleId == %3 ", (long)n, (long)(n / -1601830656));
        Object object = null;
        if (bl) {
            object = this.getImageLoader().getImageFromCache(n, n3, this.terminalID);
        }
        if (object == null) {
            HMIBundle hMIBundle = this.framework.getHMIService().getHMIBundle(n);
            if (hMIBundle != null) {
                String string;
                String string2;
                this.logHMIService.log(-2137614336, "ResourceManager: HMIServiceImpl.getImage(): targetHmiBundle == %1 ", (Object)hMIBundle);
                object = LOAD_FROM_FILE ? ((string2 = hMIBundle.getImagePath(n, this.terminalID)) != null ? this.getImageLoader().loadImage(n, string2, false, bl, n2, n3, this.terminalID) : this.getImageLoader().getErrorImage()) : ((string = this.getFilePathFromUrl(hMIBundle.getImageUrlFromClassloader(n))) != null ? this.getImageLoader().loadImageAbsolutePath(n, string, false, bl, n2, n3, this.terminalID) : this.getImageLoader().getErrorImage());
            } else {
                this.logHMIService.log(-2137614336, "ResourceManager: HMIServiceImpl.getImage(): No HMIBundle for ID %1 ", (long)n);
                object = this.getImageLoader().getErrorImage();
            }
        }
        this.logHMIService.log(-2137614336, "ResourceManager: HMIServiceImpl.getImage() finished: returning: %1 ", object);
        return object;
    }

    protected String getFilePathFromUrl(URL uRL) {
        if (uRL == null) {
            return null;
        }
        try {
            URI uRI = new URI(uRL.toExternalForm());
            File file = new File(uRI);
            return file.getAbsolutePath();
        }
        catch (URISyntaxException uRISyntaxException) {
            this.logHMIService.log(-2137614336, "ResourceManager#getFilePathFromUrl: can not build URI from url: %1", (Object)uRL, (Throwable)uRISyntaxException);
            return null;
        }
    }

    private IImageLoader getImageLoader() {
        if (this.imageLoader == null) {
            this.imageLoader = this.framework.getHMITerminalRegistry().getTerminal(this.terminalID).getImageLoader();
        }
        return this.imageLoader;
    }

    static {
        String string = System.getProperty("ImageRoot");
        LOAD_FROM_FILE = string != null;
    }
}

