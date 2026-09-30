/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.ArabiaBackspaceRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.BackspaceTopCandidateRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.BlackListFilterRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.DashUnderlineBoostRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.DiacriticBoostingRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.FirstCharNumberLetterBoostRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.FirstCharNumberLetterBoostRuleNAR;
import de.esolutions.hmi.widgets.audi.evo.prpframework.HWREnginePatchesRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.ILBoostRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.IPRPEngine;
import de.esolutions.hmi.widgets.audi.evo.prpframework.ITouchCharacterDefinition;
import de.esolutions.hmi.widgets.audi.evo.prpframework.LetterOverSpecialCharBoostRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.LowerCaseEnforcementRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.MinConfidenceFilterRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.MinStrokeLengthIsNotReachedRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.NumberLetterAlternationBoostRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.Oo0Rule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.PhoneFirstSymbolRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.PlusTRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.PunctuationMarkEnforcementRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import de.esolutions.hmi.widgets.audi.evo.prpframework.SmartDeleteRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.SpaceDashBoostRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.SpeechFilterRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.TouchCharacterDefinitionEurope;
import de.esolutions.hmi.widgets.audi.evo.prpframework.WhiteListFilterRule;
import de.esolutions.hmi.widgets.audi.evo.widgets.IInputTextInfoProvider;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework.ICharacterRegister;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PRPEngineEurope
implements IPRPEngine {
    protected static final Map EXTERNAL_RULE_CONFIG = new HashMap();
    private static final int[] RULE_DEF_DEFAULT = new int[]{33, 34, 32, 16, 2, 3, 4, 5, 6, 7, 8, 9, 10, 31, 11, 12};
    private static final int[] RULE_DEF_INTELLI_DEST = new int[]{33, 34, 32, 16, 105, 104, 2, 3, 4, 5, 6, 7, 8, 9, 10, 31, 11, 12};
    private static final int[] RULE_DEF_STANDARD_MATCH = new int[]{33, 34, 32, 16, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    private static final int[] RULE_DEF_NAV_HOUSENUMBER = new int[]{33, 34, 32, 16, 2, 3, 4, 17, 5, 6, 7, 8, 9, 10, 31, 11, 12};
    private static final int[] RULE_DEF_SEARCHTEXT_PHONE = new int[]{33, 34, 16, 32, 2, 3, 4, 17, 18, 7, 8, 9, 35, 31, 11, 12};
    private static final int[] RULE_DEF_SEARCHTEXT_PHONE_LIST = new int[]{33, 34, 16, 32, 2, 3, 4, 18, 6, 7, 8, 9, 10, 31, 11, 12};
    private static final int[] RULE_DEF_EMAIL_RECIPIENT = new int[]{33, 34, 32, 16, 2, 19, 4, 5, 6, 7, 8, 9, 10, 31, 12, 11};
    private static final int[] RULE_DEF_MULTILINE = new int[]{34, 3, 100, 101, 103, 102, 7, 8, 9, 10, 31, 11, 12};
    private static final int[] RULE_DEF_DTMF = new int[]{33, 34, 32, 7, 9, 10, 11};
    private static final int[] RULE_DEF_PASSWORD_WLAN = new int[]{33, 34, 32, 9, 10, 11, 12};
    private static final int[] RULE_DEF_PIN = new int[]{33, 34, 32, 7, 9, 10, 11};
    protected final int touchPadMode;
    protected final int spellerMode;
    protected final List rules = new ArrayList(15);
    protected final LogChannel lc;
    private final IInputTextInfoProvider infoProvider;
    private final ITouchCharacterDefinition touchCharacterDefinition;
    private List resultList;
    private SpeechFilterRule speechFilter;
    private SmartDeleteRule smartDelete;
    protected int languageIndex = 0;
    private boolean isNAR = false;
    private boolean smartDeleteCaseSensitive = true;
    protected List executedRuleset = null;

    public PRPEngineEurope(int n, int n2, IInputTextInfoProvider iInputTextInfoProvider, int n3, LogChannel logChannel, boolean bl) {
        this(TouchCharacterDefinitionEurope.getInstance(bl), n, n2, iInputTextInfoProvider, n3, logChannel);
        this.setNAR(bl);
    }

    public PRPEngineEurope(int n, int n2, IInputTextInfoProvider iInputTextInfoProvider, int n3, LogChannel logChannel) {
        this(TouchCharacterDefinitionEurope.getInstance(), n, n2, iInputTextInfoProvider, n3, logChannel);
    }

    protected PRPEngineEurope(ITouchCharacterDefinition iTouchCharacterDefinition, int n, int n2, IInputTextInfoProvider iInputTextInfoProvider, int n3, LogChannel logChannel) {
        this.touchCharacterDefinition = iTouchCharacterDefinition;
        this.touchPadMode = n;
        this.spellerMode = n2;
        this.lc = logChannel;
        this.infoProvider = iInputTextInfoProvider;
        this.languageIndex = n3;
        this.setupRules(n3);
    }

    protected void setupRules(int n) {
        Object object = EXTERNAL_RULE_CONFIG.get(Util.createInteger(this.touchPadMode));
        if (object != null && ((int[])object).length > 0) {
            int[] nArray = (int[])object;
            this.generateRuleSet(nArray, n);
        } else {
            switch (this.touchPadMode) {
                case 16: 
                case 17: 
                case 18: 
                case 19: {
                    this.generateRuleSet(RULE_DEF_STANDARD_MATCH, n);
                    break;
                }
                case 20: {
                    this.generateRuleSet(RULE_DEF_NAV_HOUSENUMBER, n);
                    break;
                }
                case 32: {
                    this.generateRuleSet(RULE_DEF_DEFAULT, n);
                    break;
                }
                case 52: {
                    this.generateRuleSet(RULE_DEF_SEARCHTEXT_PHONE, n);
                    break;
                }
                case 55: {
                    this.generateRuleSet(RULE_DEF_SEARCHTEXT_PHONE_LIST, n);
                    break;
                }
                case 48: 
                case 49: 
                case 50: 
                case 53: 
                case 54: {
                    this.generateRuleSet(RULE_DEF_DEFAULT, n);
                    break;
                }
                case 51: {
                    this.generateRuleSet(RULE_DEF_INTELLI_DEST, n);
                    break;
                }
                case 114: {
                    this.generateRuleSet(RULE_DEF_SEARCHTEXT_PHONE, n);
                    break;
                }
                case 113: {
                    this.generateRuleSet(RULE_DEF_DTMF, n);
                    break;
                }
                case 64: {
                    this.generateRuleSet(RULE_DEF_PIN, n);
                    break;
                }
                case 33: 
                case 81: 
                case 82: {
                    this.generateRuleSet(RULE_DEF_PASSWORD_WLAN, n);
                    break;
                }
                case 80: {
                    this.generateRuleSet(RULE_DEF_DEFAULT, n);
                    break;
                }
                case 96: {
                    this.generateRuleSet(RULE_DEF_MULTILINE, n);
                    break;
                }
                case 97: {
                    this.generateRuleSet(RULE_DEF_EMAIL_RECIPIENT, n);
                    break;
                }
                case 98: {
                    this.generateRuleSet(RULE_DEF_DEFAULT, n);
                    break;
                }
                case 18193: {
                    this.rules.add(new RuleConfig(10, ICharacterRegister.WHITELIST_ALLOWING_EVERYTHING));
                    break;
                }
                default: {
                    this.generateRuleSet(new int[]{3, 7, 10}, n);
                }
            }
        }
    }

    protected void generateRuleSet(int[] nArray, int n) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            ICharacterRegister iCharacterRegister;
            int n2 = nArray[i2];
            if (n2 == 10) {
                iCharacterRegister = this.touchCharacterDefinition.getHWRSymbols(this.touchPadMode, this.spellerMode, n);
                this.rules.add(new RuleConfig(10, iCharacterRegister));
                continue;
            }
            if (n2 == 35) {
                iCharacterRegister = this.touchCharacterDefinition.getHWRSymbols(this.touchPadMode, this.spellerMode, n);
                this.rules.add(new RuleConfig(35, iCharacterRegister));
                continue;
            }
            if (n2 == 11) {
                iCharacterRegister = this.touchCharacterDefinition.getBlackList(this.touchPadMode, false);
                this.rules.add(new RuleConfig(11, iCharacterRegister));
                continue;
            }
            if (n2 == 12) {
                iCharacterRegister = this.touchCharacterDefinition.getBlackList(this.touchPadMode, true);
                this.rules.add(new RuleConfig(12, iCharacterRegister));
                continue;
            }
            this.rules.add(new RuleConfig(n2, null));
        }
    }

    public void process(String string, int[] nArray, boolean bl) {
        this.process(string, nArray, null, bl);
    }

    public void process(String string, int[] nArray, String string2, boolean bl) {
        Object object;
        this.resultList = new ArrayList(string.length());
        for (int i2 = 0; i2 < string.length(); ++i2) {
            int n = -1;
            if (nArray != null) {
                n = nArray[i2];
            } else {
                n = 80 - i2 * 5;
                n = Math.max(n, 30);
            }
            object = new RecognizerResult(string.charAt(i2), n);
            this.resultList.add(object);
        }
        if (null == this.executedRuleset) {
            this.executedRuleset = new ArrayList();
        } else {
            this.executedRuleset.clear();
        }
        Iterator iterator = this.rules.iterator();
        while (iterator.hasNext()) {
            RuleConfig ruleConfig = (RuleConfig)iterator.next();
            object = ruleConfig.getRule();
            if (this.shallExecute((AbstractPRPRule)object)) {
                try {
                    long l = AbstractWidget.framework.getMonotonicTime();
                    Object object2 = ruleConfig.getArgument();
                    if (ruleConfig.ruleId == 10 && string2 != null) {
                        if (this.lc.isDebug()) {
                            this.lc.log(10000000, "PRPEngine#executeRule: name=%1 ; using Matchspeller valid Chars and context characters (%2)for this rule!", (Object)((AbstractPRPRule)object).getRuleName(), object2);
                        }
                        ((AbstractPRPRule)object).execute(this.resultList, object2, bl);
                        object2 = string2;
                        ((WhiteListFilterRule)object).setCaseSensitive(false);
                    }
                    if (this.lc.isDebug()) {
                        this.lc.log(10000000, "PRPEngine#executeRule: name=%1 ; argument=%2", (Object)((AbstractPRPRule)object).getRuleName(), object2);
                    }
                    if (((AbstractPRPRule)object).isMinimumStokeLengthSensitive() && bl) {
                        ((AbstractPRPRule)object).execute(this.resultList, object2);
                    } else {
                        ((AbstractPRPRule)object).execute(this.resultList, object2, bl);
                    }
                    if (this.lc.isDebug()) {
                        long l2 = AbstractWidget.framework.getMonotonicTime() - l;
                        Collections.sort(this.resultList, Collections.reverseOrder());
                        this.lc.log(10000000, "PRPEngine#executeRule: Result after rule=%1; time for execution: %2ms", (Object)this.dumpResult(), l2);
                    }
                    this.executedRuleset.add(ruleConfig);
                }
                catch (Exception exception) {
                    this.lc.log(100000, "PRPEngine#executeRule: skip rule '%1' because of exception %2 ", (Object)((AbstractPRPRule)object).getRuleName(), (Throwable)exception);
                }
                continue;
            }
            if (!this.lc.isDebug()) continue;
            this.lc.log(10000000, "PRPEngine#executeRule: skip rule '%1' because of it's validity (currentText=%2)", (Object)((AbstractPRPRule)object).getRuleName(), (Object)this.infoProvider.getCurrentText());
        }
    }

    private boolean shallExecute(AbstractPRPRule abstractPRPRule) {
        int n = abstractPRPRule.getValidity();
        if (n == 1) {
            return this.infoProvider.isStartOfText();
        }
        if (n == 0) {
            return this.infoProvider.isStartOfWord();
        }
        return n == 2;
    }

    protected AbstractPRPRule createRule(int n) {
        AbstractPRPRule abstractPRPRule = null;
        switch (n) {
            case 11: {
                abstractPRPRule = new BlackListFilterRule(1, "Start-Of-Text-Filter");
                break;
            }
            case 12: {
                abstractPRPRule = new BlackListFilterRule(0, "Start-Of-Word-Filter");
                break;
            }
            case 10: {
                abstractPRPRule = new WhiteListFilterRule(2, "Context-Filter", false);
                break;
            }
            case 35: {
                abstractPRPRule = new WhiteListFilterRule(2, "Context-Filter", false, true);
                break;
            }
            case 2: {
                abstractPRPRule = new ILBoostRule();
                break;
            }
            case 5: {
                if (this.isNAR()) {
                    abstractPRPRule = new NumberLetterAlternationBoostRule(14);
                    break;
                }
                abstractPRPRule = new NumberLetterAlternationBoostRule(3);
                break;
            }
            case 18: {
                abstractPRPRule = new NumberLetterAlternationBoostRule(6);
                break;
            }
            case 4: {
                abstractPRPRule = new LetterOverSpecialCharBoostRule();
                break;
            }
            case 16: {
                abstractPRPRule = new HWREnginePatchesRule();
                break;
            }
            case 6: {
                if (this.isNAR) {
                    abstractPRPRule = new FirstCharNumberLetterBoostRuleNAR();
                    break;
                }
                abstractPRPRule = new FirstCharNumberLetterBoostRule();
                break;
            }
            case 100: {
                abstractPRPRule = new FirstCharNumberLetterBoostRule(11);
                break;
            }
            case 101: {
                abstractPRPRule = new NumberLetterAlternationBoostRule(11);
                break;
            }
            case 103: {
                abstractPRPRule = new LowerCaseEnforcementRule();
                break;
            }
            case 102: {
                abstractPRPRule = new PunctuationMarkEnforcementRule();
                break;
            }
            case 3: {
                abstractPRPRule = new SpaceDashBoostRule();
                break;
            }
            case 9: {
                this.speechFilter = new SpeechFilterRule();
                abstractPRPRule = this.speechFilter;
                break;
            }
            case 7: {
                this.smartDelete = new SmartDeleteRule(this.isSmartDeleteCaseSensitive());
                abstractPRPRule = this.smartDelete;
                break;
            }
            case 8: {
                abstractPRPRule = new MinConfidenceFilterRule();
                break;
            }
            case 17: {
                abstractPRPRule = new PhoneFirstSymbolRule();
                break;
            }
            case 19: {
                abstractPRPRule = new DashUnderlineBoostRule();
                break;
            }
            case 31: {
                abstractPRPRule = new DiacriticBoostingRule(this.languageIndex);
                break;
            }
            case 32: {
                abstractPRPRule = new MinStrokeLengthIsNotReachedRule();
                break;
            }
            case 33: {
                abstractPRPRule = new ArabiaBackspaceRule();
                break;
            }
            case 34: {
                abstractPRPRule = new BackspaceTopCandidateRule();
                break;
            }
            case 105: {
                abstractPRPRule = new Oo0Rule();
                break;
            }
            case 104: {
                abstractPRPRule = new PlusTRule();
                break;
            }
            default: {
                this.lc.log(10000, "PRPEngine#createRule: unknown ruleID=%1", (long)n);
            }
        }
        if (abstractPRPRule != null) {
            abstractPRPRule.setInfoProvider(this.infoProvider);
        }
        return abstractPRPRule;
    }

    public String getResult() {
        Collections.sort(this.resultList, Collections.reverseOrder());
        Buffer buffer = new Buffer(this.resultList.size());
        Iterator iterator = this.resultList.iterator();
        while (iterator.hasNext()) {
            RecognizerResult recognizerResult = (RecognizerResult)iterator.next();
            buffer.append(recognizerResult.getCharacter());
        }
        return buffer.toString();
    }

    public String dumpResult() {
        Buffer buffer = new Buffer(this.resultList.size());
        Iterator iterator = this.resultList.iterator();
        while (iterator.hasNext()) {
            RecognizerResult recognizerResult = (RecognizerResult)iterator.next();
            buffer.append(recognizerResult.getCharacter());
            buffer.append('(');
            buffer.append(recognizerResult.getConfidence());
            buffer.append("), ");
        }
        return buffer.toString();
    }

    public void characterEntered(char c2) {
        if (this.smartDelete != null) {
            this.smartDelete.characterEntered(new RecognizerResult(c2, 100));
        }
    }

    public static void setRuleConfig(int n, int[] nArray) {
        EXTERNAL_RULE_CONFIG.put(Util.createInteger(n), nArray);
    }

    public String getSpeechTopMatch() {
        if (this.speechFilter != null && this.speechFilter.getSpeechTopMatch() != null) {
            return String.valueOf(this.speechFilter.getSpeechTopMatch().getCharacter());
        }
        return null;
    }

    public void setNAR(boolean bl) {
        this.isNAR = bl;
    }

    public boolean isNAR() {
        return this.isNAR;
    }

    public void setSmartDeleteCaseSensitive(boolean bl) {
        this.smartDeleteCaseSensitive = bl;
    }

    public boolean isSmartDeleteCaseSensitive() {
        return this.smartDeleteCaseSensitive && this.touchPadMode != 52;
    }

    public List getExecutedRuleset() {
        return this.executedRuleset;
    }

    public class RuleConfig {
        private AbstractPRPRule rule;
        private int ruleId;
        private Object arg;

        public RuleConfig(int n, Object object) {
            this.ruleId = n;
            this.arg = object;
        }

        public Object getArgument() {
            return this.arg;
        }

        public AbstractPRPRule getRule() {
            if (this.rule == null) {
                this.rule = PRPEngineEurope.this.createRule(this.ruleId);
            }
            return this.rule;
        }

        public int getRuleId() {
            return this.ruleId;
        }
    }
}

