/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.sds.sm;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.SDPromptTextAccess;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.modelaccess.LabelModelGUI;
import de.audi.atip.hmi.modelaccess.TextfieldModelGUI;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.sds.sm.Activator;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.ByteArrayData;
import java.io.IOException;
import java.io.InputStream;

public class SDTextFactory
implements I18NTarget,
SDPromptTextAccess {
    private static final String[][] SPECIAL_CHARS_ARRAY = new String[][]{{"quot", "34"}, {"amp", "38"}, {"lt", "60"}, {"gt", "62"}, {"apos", "39"}};
    public static final int ID_MULTIPLIER = 10000;
    protected int moduleID = 0;
    protected static int currentLanguage = -1;
    private ByteArrayData stringResources = null;
    private static final String EMPTY_STRING = "";
    private final String defaultLanguage;
    private final HMIService hmiService;
    private final LogChannel logChannel;
    private String resource;
    private Activator activator;

    protected SDTextFactory(HMIService hMIService, LogChannel logChannel, IFrameworkAccess iFrameworkAccess, Activator activator) {
        this.defaultLanguage = "de_DE";
        this.hmiService = hMIService;
        this.logChannel = logChannel;
        this.activator = activator;
    }

    private String getDefaultLanguage() {
        return "de_DE";
    }

    public String getName() {
        String string = System.getProperty("variant.skin");
        if (string == null) {
            this.logChannel.log(1000, "[SDTextFactory#getName] system property 'variant.skin' is unknown! Can not determine current variant! Try to use fallback HIGH-Variant.");
            return "HMISpeechEvoHighMMIKombi";
        }
        String string2 = "HMISpeech" + string;
        this.logChannel.log(1000000, "[SDTextFactory#getName] Determined HMI-Bundle for Prompt-Resources is '%1'.", (Object)string2);
        return string2;
    }

    protected ClassLoader getResourceClassLoader() {
        return this.getClass().getClassLoader() != null ? this.getClass().getClassLoader() : ClassLoader.getSystemClassLoader();
    }

    protected String getText(int n, int[] nArray, int[] nArray2) {
        this.logChannel.log(1000000, "[SDTextFactory#getText] Getting text with id '%1', containg dynamic Content of ModelIDs '%2', modelTypes '%3'.", (Object)Integer.toString(n), (Object)nArray, (Object)nArray2);
        String string = this.getText(n);
        this.logChannel.log(1000000, "[SDTextFactory#getText] Original text is '%1'.", (Object)string);
        String string2 = this.processTextReplacement(string, this.hmiService, nArray, nArray2);
        this.logChannel.log(1000000, "[SDTextFactory#getText] Returning '%1'.", (Object)string2);
        return string2;
    }

    protected String getText(int n, String string) {
        return this.getText(n);
    }

    protected String getText(int n) {
        this.logChannel.log(1000000, "[SDTextFactory#getText] Using resource '%1'.", (Object)this.resource);
        this.logChannel.log(1000000, "[SDTextFactory#getText] Getting text with id '%1'.", (long)n);
        try {
            String string = this.stringResources.getString(n - this.moduleID * 10000);
            if (string != null) {
                this.logChannel.log(1000000, "[SDTextFactory#getText] Returning text '%1'.", (Object)string);
                return string;
            }
            this.logChannel.log(100000, "[SDTextFactory#getText] Text with ID '%1' not found in resource-files!", (long)n);
            return EMPTY_STRING;
        }
        catch (Exception exception) {
            this.logChannel.log(1000000, "[SDTextFactory#getText] Exception '%1' occured.", (Object)exception.getMessage());
            exception.printStackTrace();
            return EMPTY_STRING;
        }
    }

    public String getSDPromptText(int n) {
        return this.getText(n);
    }

    public void setLanguage(Language language) {
        this.logChannel.log(1000000, "[SDTextFactory#setLanguage] called, language is '%1', hmiCode '%2'", (Object)language.getLanguageName(), (Object)language.getHmiCode());
        this.activator.unregisterSDPromptTextAccess();
        InputStream inputStream = null;
        try {
            ClassLoader classLoader = this.getResourceClassLoader();
            this.resource = "resources/" + this.getName() + "/strings_" + language.getHmiCode() + ".data";
            inputStream = classLoader.getResourceAsStream(this.resource);
            if (inputStream == null) {
                this.logChannel.log(1000, "[SDTextFactory#setLanguage] WARNING, cannot load resource-file '%1', trying fallback", (Object)this.resource);
                this.resource = "resources/" + this.getName() + "/strings_" + this.getDefaultLanguage() + ".data";
                inputStream = classLoader.getResourceAsStream(this.resource);
            }
            if (inputStream == null) {
                this.logChannel.log(1000, "[SDTextFactory#setLanguage] WARNING, cannot load resource-file '%1', trying fallback", (Object)this.resource);
                this.resource = "resources/" + this.getName() + "/strings.data";
                inputStream = classLoader.getResourceAsStream(this.resource);
            }
            if (inputStream != null) {
                this.logChannel.log(1000000, "[SDTextFactory#setLanguage] '%1' loaded.", (Object)this.resource);
                this.stringResources = new ByteArrayData(inputStream);
            } else {
                this.logChannel.log(1000, "[SDTextFactory#setLanguage] WARNING, cannot load resource-file '%1'. The following prompts will contain empty Strings!", (Object)this.resource);
            }
            currentLanguage = language.getLanguageIndex();
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
        this.activator.registerSDPromptTextAccess();
    }

    public int getLanguage() {
        return currentLanguage;
    }

    public String processTextReplacement(String string, HMIService hMIService, int[] nArray, int[] nArray2) {
        Buffer buffer = new Buffer();
        if (string == null) {
            return string;
        }
        int n = string.indexOf(37);
        if (n < 0) {
            return string;
        }
        int n2 = 0;
        int n3 = 0;
        HMIModel hMIModel = null;
        for (int i2 = 0; i2 < 100; ++i2) {
            if (n == -1) {
                buffer.append(string.substring(n2, string.length()));
                break;
            }
            buffer.append(string.substring(n2, n));
            if (++n >= string.length()) {
                this.logChannel.log(1000, "[SDTextFactory#processTextReplacement] There is no replacement index set.");
                break;
            }
            char c2 = string.charAt(n);
            if (Character.isDigit(c2)) {
                n3 = Integer.parseInt(string.substring(n, n + 1));
                if (0 <= n3 - 1 && n3 - 1 < nArray.length) {
                    hMIModel = hMIService.getModel(6, nArray[n3 - 1]);
                    if (hMIModel != null) {
                        if (nArray2 != null) {
                            String string2;
                            if (nArray2[n3 - 1] == 3) {
                                string2 = ((LabelModelGUI)((Object)hMIModel)).getText();
                                if (string2 != null) {
                                    buffer.append(SDTextFactory.escapeXml(string2));
                                }
                            } else if (nArray2[n3 - 1] == 8) {
                                string2 = ((TextfieldModelGUI)((Object)hMIModel)).getText1();
                                if (string2 != null) {
                                    buffer.append(SDTextFactory.escapeXml(string2));
                                }
                            } else if (nArray2[n3 - 1] == 2) {
                                string2 = Integer.toString(((ChoiceModelGUI)((Object)hMIModel)).getValue());
                                buffer.append(string2);
                            } else {
                                this.logChannel.log(1000, "[SDTextFactory#processTextReplacement] Unsupported model type '%1' detected!", (long)nArray2[n3 - 1]);
                            }
                        } else {
                            this.logChannel.log(1000, "[SDTextFactory#processTextReplacement] modelTypes are null!");
                        }
                    }
                } else {
                    this.logChannel.log(1000, "[SDTextFactory#processTextReplacement] There is no model for placeholder with index '%1' present.", (long)(n3 - 1));
                }
            } else {
                buffer.append('%');
                buffer.append(c2);
            }
            n2 = n + 1;
            n = string.indexOf(37, n2);
        }
        return buffer.toString();
    }

    public static String escapeXml(String string) {
        Buffer buffer = new Buffer(string.length() * 2);
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            String string2 = SDTextFactory.replaceChar(c2);
            if (string2 == null) {
                buffer.append(c2);
                continue;
            }
            buffer.append('&');
            buffer.append(string2);
            buffer.append(';');
        }
        return buffer.toString();
    }

    private static String replaceChar(char c2) {
        for (int i2 = 0; i2 < SPECIAL_CHARS_ARRAY.length; ++i2) {
            if (Integer.parseInt(SPECIAL_CHARS_ARRAY[i2][1]) != c2) continue;
            return SPECIAL_CHARS_ARRAY[i2][0];
        }
        return null;
    }
}

