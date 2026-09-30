/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.standard;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.textconstants.ITextConstantsConverter;
import de.audi.tghu.online.app.IOnlineLanguageChangeListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class OnlineI18NHandler
implements ITextConstantsConverter,
I18NTarget {
    private final Map currentTexts = new HashMap();
    private Field[] textConstantFields;
    private LogChannel logChannel;
    private HMIService service;
    List listeners = new ArrayList(1);

    public OnlineI18NHandler(Field[] fieldArray, LogChannel logChannel, HMIService hMIService) {
        this.service = hMIService;
        this.textConstantFields = fieldArray;
        this.logChannel = logChannel;
        this.generateFields();
        this.logChannel.log(1000000, "OnlineI18NHandler#c'tor");
    }

    private void generateFields() {
        this.currentTexts.clear();
        if (this.textConstantFields != null && this.textConstantFields.length > 0) {
            int n = this.textConstantFields.length;
            for (int i2 = 0; i2 < n; ++i2) {
                Field field = this.textConstantFields[i2];
                String string = field.getName();
                try {
                    Object object;
                    int n2 = field.getType().isArray() ? (((int[])(object = (int[])field.get(null))).length == 1 ? object[0] : -1) : field.getInt(null);
                    object = this.service.getText(n2);
                    this.currentTexts.put(string, object);
                    continue;
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    this.logChannel.log(10000, "OnlineI18NHandler#generateFields(): IllegalArgumentException %1 for field %2", (Object)illegalArgumentException, (Object)field.getName());
                    continue;
                }
                catch (IllegalAccessException illegalAccessException) {
                    this.logChannel.log(10000, "OnlineI18NHandler#generateFields(): IllegalAccessException %1 for field %2", (Object)illegalAccessException, (Object)field.getName());
                }
            }
        } else {
            this.logChannel.log(10000, "OnlineI18NHandler#generateFields(): fields where NUll or Empty ");
        }
    }

    public String getText(String string) {
        String string2 = "";
        string2 = (String)this.currentTexts.get(string);
        if (string2 == null || string2.length() == 0) {
            return "Text constant '" + string + "' could not be replaced!";
        }
        return string2;
    }

    public void setLanguage(Language language) {
        this.logChannel.log(1000000, "OnlineI18NHandler#setLanguage: changed to %1", (Object)language.getLanguageName());
        this.generateFields();
        this.notifyListeners();
    }

    public void addLanguageChangedListener(IOnlineLanguageChangeListener iOnlineLanguageChangeListener) {
        this.listeners.add(iOnlineLanguageChangeListener);
    }

    private void notifyListeners() {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ((IOnlineLanguageChangeListener)iterator.next()).languageChanged();
        }
    }
}

