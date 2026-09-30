/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.view.HMIView;
import de.audi.atip.hmi.view.IDrawerController;
import de.audi.atip.hmi.view.IPartialPopupController;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.i18n.Language;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.ByteArrayData;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public abstract class AbstractScreenFactory {
    protected static final String IMAGE_ROOT = "images/";
    protected static final String KZB_ROOT = System.getProperty("kzbResourceFolder", "kzbs/");
    private static final String EMPTY_STRING = "";
    public static final int IMG_ID_OFFSET = 0;
    protected int moduleID;
    protected int currentLanguage = -1;
    private ByteArrayData stringResources = null;
    private IFrameworkAccess framework;

    protected AbstractScreenFactory(int n, IFrameworkAccess iFrameworkAccess) {
        this.moduleID = n;
        this.framework = iFrameworkAccess;
        this.setLanguage(iFrameworkAccess.getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI"));
    }

    protected IFrameworkAccess getFramework() {
        return this.framework;
    }

    public Screen getScreen(int n, int n2) {
        int n3 = n / 100000;
        if (n3 != this.moduleID) {
            throw new IllegalArgumentException("wrong module id " + n3);
        }
        Screen screen = this.getScreenWithMainArea(n, n2);
        this.clearRefWidgets(n2);
        return screen;
    }

    public void clearRefWidgets(int n) {
    }

    public abstract Screen getScreenWithMainArea(int var1, int var2);

    protected abstract Screen createScreen(int var1, int var2);

    protected abstract Screen createDefaultScreen(int var1, int var2);

    public abstract String getName();

    protected final ClassLoader getResourceClassLoader() {
        return this.getClass().getClassLoader() != null ? this.getClass().getClassLoader() : ClassLoader.getSystemClassLoader();
    }

    public String getText(int n) {
        try {
            String string = this.stringResources.getString(n - this.moduleID * 100000);
            if (string != null) {
                return string;
            }
            return EMPTY_STRING;
        }
        catch (Exception exception) {
            return EMPTY_STRING;
        }
    }

    public int getTextStatus(int n) {
        try {
            int n2 = this.stringResources.getFlag(n - this.moduleID * 100000) & 0xF;
            if (n2 > 0) {
                return n2;
            }
            return 0;
        }
        catch (Exception exception) {
            return 0;
        }
    }

    public String getAltText(int n) {
        try {
            String string = this.stringResources.getAltString(n - this.moduleID * 100000);
            if (string != null) {
                return string;
            }
            return EMPTY_STRING;
        }
        catch (Exception exception) {
            return EMPTY_STRING;
        }
    }

    public int getAltTextStatus(int n) {
        try {
            int n2 = this.stringResources.getFlag(n - this.moduleID * 100000) >> 4 & 0xF;
            if (n2 > 0) {
                return n2;
            }
            return 0;
        }
        catch (Exception exception) {
            return 0;
        }
    }

    public String getText(int n, int n2) {
        if (n2 == 1) {
            return this.getAltText(n);
        }
        return this.getText(n);
    }

    public int getTextStatus(int n, int n2) {
        if (n2 == 1) {
            return this.getAltTextStatus(n);
        }
        return this.getTextStatus(n);
    }

    public URL getImageUrlFromClassloader(int n) {
        String string = this.buildImagePathForClassloader(n);
        try {
            URL uRL = this.getResourceClassLoader().getResource(string);
            if (uRL == null) {
                this.getLogChannel().log(10000, "Can't find URL for image id: %2, searching at relative path: %1", (Object)string, (long)n);
            }
            return uRL;
        }
        catch (Exception exception) {
            this.getLogChannel().log(10000, "Error getting URL for image with relative path: %1", (Object)string, (Throwable)exception);
            return null;
        }
    }

    public URL getKzbUrlFromClassloader(String string) {
        Buffer buffer = new Buffer();
        buffer.append(KZB_ROOT).append(this.getName()).append('/').append(string);
        String string2 = buffer.toString();
        try {
            URL uRL = this.getResourceClassLoader().getResource(string2);
            if (uRL == null) {
                this.getLogChannel().log(10000, "Can't find URL for '%1'-KZB, searching at relative path: %2", (Object)string, (Object)string2);
            }
            return uRL;
        }
        catch (Exception exception) {
            this.getLogChannel().log(10000, "Error getting URL for KZB with relative path: %1", (Object)string2, (Throwable)exception);
            return null;
        }
    }

    public URL getKzbUrlFromClassloader(int n) {
        Buffer buffer = new Buffer();
        buffer.append(KZB_ROOT).append(this.getName()).append('/').append(n).append(".kzb");
        String string = buffer.toString();
        try {
            URL uRL = this.getResourceClassLoader().getResource(string);
            if (uRL == null) {
                this.getLogChannel().log(10000, "Can't find URL for KZB id: %2, searching at relative path: %1", (Object)string, (long)n);
            }
            return uRL;
        }
        catch (Exception exception) {
            this.getLogChannel().log(10000, "Error getting URL for KZB with relative path: %1", (Object)string, (Throwable)exception);
            return null;
        }
    }

    protected String buildImagePathForClassloader(int n) {
        Buffer buffer = new Buffer();
        buffer.append(IMAGE_ROOT).append(this.getName()).append('/').append(n).append(".png");
        return buffer.toString();
    }

    public URL getImageUrlFromClassloader(int n, int n2) {
        return this.getImageUrlFromClassloader(n);
    }

    private LogChannel getLogChannel() {
        return this.getFramework().getLogChannel("Fw.ScreenFactory");
    }

    public String getImagePath(int n, int n2) {
        Buffer buffer = new Buffer();
        buffer.append(this.getName()).append('/').append(n).append(".png");
        return buffer.toString();
    }

    public String getKzbPath(String string) {
        Buffer buffer = new Buffer();
        buffer.append(this.getName()).append('/').append(string);
        return buffer.toString();
    }

    public String getKzbPath(int n, int n2) {
        Buffer buffer = new Buffer();
        buffer.append(this.getName()).append('/').append(n).append(".kzb");
        return buffer.toString();
    }

    public final void setLanguage(Language language) {
        if (language.getLanguageIndex() != this.currentLanguage) {
            String string = language.getHmiCode();
            InputStream inputStream = null;
            try {
                ClassLoader classLoader = this.getResourceClassLoader();
                Buffer buffer = new Buffer();
                buffer.append("resources/").append(this.getName()).append("/strings_").append(string).append(".data");
                InputStream inputStream2 = classLoader.getResourceAsStream(buffer.toString());
                if (inputStream2 != null) {
                    inputStream = new BufferedInputStream(inputStream2, 4096);
                }
                if (inputStream != null) {
                    this.stringResources = new ByteArrayData(inputStream);
                }
                this.currentLanguage = language.getLanguageIndex();
            }
            catch (IOException iOException) {
                this.stringResources = null;
                iOException.printStackTrace();
            }
            catch (RuntimeException runtimeException) {
                this.stringResources = null;
                runtimeException.printStackTrace();
                throw runtimeException;
            }
            finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    }
                    catch (IOException iOException) {
                        iOException.printStackTrace();
                    }
                }
            }
        }
    }

    public int getLanguage() {
        return this.currentLanguage;
    }

    public abstract void executeCondition(int var1, int var2, HMIView[] var3, int var4);

    public final boolean evaluateSimpleChoiceModelValueEqualsCondition(int n, int n2, int n3) {
        try {
            return ((ChoiceModel)this.framework.getHMIService().getModel(n2, n)).getValue() == n3;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public final boolean evaluateSimpleChoiceModelValueGreaterCondition(int n, int n2, int n3) {
        try {
            return ((ChoiceModel)this.framework.getHMIService().getModel(n2, n)).getValue() > n3;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public final boolean evaluateSimpleChoiceModelValueLesserCondition(int n, int n2, int n3) {
        try {
            return ((ChoiceModel)this.framework.getHMIService().getModel(n2, n)).getValue() < n3;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public final boolean evaluateSimpleAbstractModelStatusEqualsCondition(int n, int n2, int n3) {
        try {
            return this.framework.getHMIService().getModel(n2, n).getStatus() == n3;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public final boolean evaluateSimpleAbstractModelStatusGreaterCondition(int n, int n2, int n3) {
        try {
            return this.framework.getHMIService().getModel(n2, n).getStatus() > n3;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public final boolean evaluateSimpleAbstractModelStatusLesserCondition(int n, int n2, int n3) {
        try {
            return this.framework.getHMIService().getModel(n2, n).getStatus() < n3;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public final boolean evaluateSimpleSysConstEqualsCondition(int n, int n2) {
        return this.framework.getSysConst(n) == n2;
    }

    public final boolean evaluateSimpleSysConstGreaterCondition(int n, int n2) {
        return this.framework.getSysConst(n) > n2;
    }

    public IDrawerController[] getSelectionDrawers(int n) {
        return null;
    }

    public IDrawerController[] getOptionDrawers(int n) {
        return null;
    }

    public IDrawerController getEntertainmentDrawer(int n) {
        return null;
    }

    public IDrawerController[] getEntertainmentDrawerContents(int n) {
        return null;
    }

    public HMIView getWidgetTemplate(int n, int n2) {
        return null;
    }

    public IPartialPopupController getPartialPopup(int n, int n2) {
        return null;
    }

    public IPartialPopupController[] getPartialPopupStubs(int n) {
        return null;
    }
}

