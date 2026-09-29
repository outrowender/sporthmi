/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework;

import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.BlackListFilterRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.IPRPEngine;
import de.esolutions.hmi.widgets.audi.evo.prpframework.MinStrokeLengthIsNotReachedRuleAsia;
import de.esolutions.hmi.widgets.audi.evo.prpframework.PRPEngineEurope;
import de.esolutions.hmi.widgets.audi.evo.prpframework.SpaceDashBoostRuleAsia;
import de.esolutions.hmi.widgets.audi.evo.prpframework.SpaceDashBoostRuleKorea;
import de.esolutions.hmi.widgets.audi.evo.prpframework.WhiteListFilterRule;
import de.esolutions.hmi.widgets.audi.evo.widgets.IInputTextInfoProvider;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework.CharacterMap;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework.IPRPAsiaFreeTextRules;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework.IPRPAsiaTrufflesInputRules;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework.IPRPAsianMatchSpellerRules;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework.MatchSpellerAmbiguousCharacterBoostingRule;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework.MatchSpellerCaseInsensitiveCharRule;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework.SimplifiedTraditionalMappingRule;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework.SingleCharFilterRule;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework.TouchCharacterDefinitionAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework.UpperLowerCaseHandlingJPRule;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework.WeirdRadicalRule;

public final class PRPEngineAsia
extends PRPEngineEurope
implements IPRPEngine,
IPRPAsiaFreeTextRules,
IPRPAsianMatchSpellerRules,
IPRPAsiaTrufflesInputRules {
    private static final int[] RULE_DEF_PASSWORD_WLAN_ASIA = new int[]{27, 20, 9, 10, 31, 11, 12};
    private static final int[] RULE_DEF_PIN_ASIA = new int[]{27, 20, 7, 9, 10, 11};
    private static final int[] RULE_DEF_DTMF_ASIA = new int[]{27, 20, 7, 9, 10, 11};
    static final int[] RULE_DEF_DEFAULT_ASIA = new int[]{27, 16, 20, 2, 21, 5, 8, 9, 10, 11, 12};
    static final int[] RULE_DEF_MESSAGING_SMS_TW = new int[]{27, 16, 20, 2, 21, 5, 8, 9, 10, 11, 12, 30};
    private static final int[] RULE_DEF_EMAIL_RECIPIENT_ASIA = new int[]{27, 16, 20, 2, 19, 5, 6, 7, 8, 9, 10, 31, 12, 11};
    private static final int[] RULE_DEF_EMAIL_RECIPIENT_ASIA_TW = new int[]{27, 16, 20, 2, 19, 5, 6, 7, 8, 9, 10, 31, 12, 11, 30};

    public PRPEngineAsia(int n, int n2, IInputTextInfoProvider iInputTextInfoProvider, int n3, LogChannel logChannel) {
        super(TouchCharacterDefinitionAsia.getInstance(), n, n2, iInputTextInfoProvider, n3, logChannel);
    }

    @Override
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
                    this.generateRuleSet(RULE_DEF_ASIA_GENERALMATCHINPUT, n);
                    break;
                }
                case 20: {
                    this.generateRuleSet(RULE_DEF_ASIA_HOUSENUMBERMATCHINPUT_DEST_NAVI, n);
                    break;
                }
                case 32: {
                    this.generateFreeTextRules(n);
                    break;
                }
                case 114: {
                    this.generateRuleSet(RULE_DEF_ASIA_NUMBERINPUT_PHONE, n);
                    break;
                }
                case 51: {
                    this.generateTrufflesDestNaviInputRules(n);
                    break;
                }
                case 52: 
                case 55: {
                    this.generateTrufflesPhoneInputRules(n);
                    break;
                }
                case 48: 
                case 49: 
                case 50: 
                case 53: 
                case 54: {
                    this.generateTrufflesInputRules(n);
                    break;
                }
                case 33: 
                case 81: 
                case 82: {
                    this.generateRuleSet(RULE_DEF_PASSWORD_WLAN_ASIA, n);
                    break;
                }
                case 113: {
                    this.generateRuleSet(RULE_DEF_DTMF_ASIA, n);
                    break;
                }
                case 64: {
                    this.generateRuleSet(RULE_DEF_PIN_ASIA, n);
                    break;
                }
                case 80: {
                    this.generateRuleSet(RULE_DEF_DEFAULT_ASIA, n);
                    break;
                }
                case 96: 
                case 97: {
                    this.generateMessagingEmailRecipientInputRules(n);
                    break;
                }
                case 98: {
                    this.generateMessagingSMSRecipientInputRules(n);
                    break;
                }
                default: {
                    super.setupRules(n);
                }
            }
        }
    }

    private void generateMessagingSMSRecipientInputRules(int n) {
        if (n == 24 || n == 25) {
            this.generateRuleSet(RULE_DEF_MESSAGING_SMS_TW, n);
        } else {
            this.generateRuleSet(RULE_DEF_DEFAULT_ASIA, n);
        }
    }

    private void generateMessagingEmailRecipientInputRules(int n) {
        if (n == 24 || n == 25) {
            this.generateRuleSet(RULE_DEF_EMAIL_RECIPIENT_ASIA_TW, n);
        } else {
            this.generateRuleSet(RULE_DEF_EMAIL_RECIPIENT_ASIA, n);
        }
    }

    private void generateTrufflesPhoneInputRules(int n) {
        if (n == 24 || n == 25) {
            this.generateRuleSet(RULE_DEF_ASIA_TRUFFLESINPUT_PHONE_TW, n);
        } else {
            this.generateRuleSet(RULE_DEF_ASIA_TRUFFLESINPUT_PHONE, n);
        }
    }

    private void generateTrufflesDestNaviInputRules(int n) {
        if (n == 24 || n == 25) {
            this.generateRuleSet(RULE_DEF_ASIA_TRUFFLESINPUT_DEST_NAVI_TW, n);
        } else {
            this.generateRuleSet(RULE_DEF_ASIA_TRUFFLESINPUT_DEST_NAVI, n);
        }
    }

    private void generateFreeTextRules(int n) {
        switch (n) {
            case 14: 
            case 15: {
                this.generateRuleSet(RULE_DEF_ASIA_FREETEXT_CN, n);
                break;
            }
            case 23: {
                this.generateRuleSet(RULE_DEF_ASIA_FREETEXT_CN, n);
                break;
            }
            case 24: 
            case 25: {
                this.generateRuleSet(RULE_DEF_ASIA_FREETEXT_TW, n);
                break;
            }
            case 12: 
            case 13: {
                this.generateRuleSet(RULE_DEF_ASIA_FREETEXT_JP, n);
                break;
            }
            case 16: 
            case 17: {
                this.generateRuleSet(RULE_DEF_ASIA_FREETEXT_KR, n);
                break;
            }
            default: {
                this.generateRuleSet(RULE_DEF_ASIA_FREETEXT_BASIC, n);
            }
        }
    }

    private void generateTrufflesInputRules(int n) {
        switch (n) {
            case 14: 
            case 15: {
                this.generateRuleSet(RULE_DEF_ASIA_TRUFFLESINPUT_CN, n);
                break;
            }
            case 23: {
                this.generateRuleSet(RULE_DEF_ASIA_TRUFFLESINPUT_CN, n);
                break;
            }
            case 24: 
            case 25: {
                this.generateRuleSet(RULE_DEF_ASIA_TRUFFLESINPUT_TW, n);
                break;
            }
            case 12: 
            case 13: {
                this.generateRuleSet(RULE_DEF_ASIA_TRUFFLESINPUT_JP, n);
                break;
            }
            case 16: 
            case 17: {
                this.generateRuleSet(RULE_DEF_ASIA_TRUFFLESINPUT_KR, n);
                break;
            }
            default: {
                this.generateRuleSet(RULE_DEF_ASIA_TRUFFLESINPUT_BASIC, n);
            }
        }
    }

    @Override
    protected AbstractPRPRule createRule(int n) {
        AbstractPRPRule abstractPRPRule;
        switch (n) {
            case 29: {
                abstractPRPRule = new UpperLowerCaseHandlingJPRule();
                break;
            }
            case 27: {
                abstractPRPRule = new SingleCharFilterRule('\b');
                break;
            }
            case 28: {
                abstractPRPRule = new SingleCharFilterRule(' ');
                break;
            }
            case 11: {
                abstractPRPRule = new BlackListFilterRule(1, "Start-Of-Text-Filter");
                break;
            }
            case 12: {
                abstractPRPRule = new BlackListFilterRule(0, "Start-Of-Word-Filter");
                break;
            }
            case 10: {
                abstractPRPRule = new WhiteListFilterRule(2, "Context-Filter");
                break;
            }
            case 20: {
                abstractPRPRule = new MinStrokeLengthIsNotReachedRuleAsia();
                break;
            }
            case 21: {
                if (AbstractWidget.isKr()) {
                    abstractPRPRule = new SpaceDashBoostRuleKorea();
                    break;
                }
                abstractPRPRule = new SpaceDashBoostRuleAsia();
                break;
            }
            case 24: 
            case 26: {
                abstractPRPRule = new WeirdRadicalRule(CharacterMap.getInstance());
                if (14 == this.languageIndex) {
                    ((WeirdRadicalRule)abstractPRPRule).setMapType(1);
                    break;
                }
                if (23 != this.languageIndex) break;
                ((WeirdRadicalRule)abstractPRPRule).setMapType(2);
                break;
            }
            case 30: {
                abstractPRPRule = new SimplifiedTraditionalMappingRule(CharacterMap.getInstance());
                ((SimplifiedTraditionalMappingRule)abstractPRPRule).setMapType(0);
                break;
            }
            case 99: {
                abstractPRPRule = new MatchSpellerAmbiguousCharacterBoostingRule();
                break;
            }
            case 98: {
                abstractPRPRule = new MatchSpellerCaseInsensitiveCharRule();
                break;
            }
            default: {
                abstractPRPRule = super.createRule(n);
            }
        }
        return abstractPRPRule;
    }

    public static void setRuleConfig(int n, int[] nArray) {
        EXTERNAL_RULE_CONFIG.put(Util.createInteger(n), nArray);
    }
}

