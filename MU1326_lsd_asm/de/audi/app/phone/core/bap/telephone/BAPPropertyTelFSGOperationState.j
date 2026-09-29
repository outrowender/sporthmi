.version 50 0 
.class super [297] 
.super [299] 
.field private volatile [300] [301] 
.field private [302] [303] 
.field private [304] [305] 
.field private [306] [307] 
.field private [308] [309] 
.field private [310] [311] 
.field private [312] [313] 
.field private final [314] [315] 
.field private [316] [317] 

.method [319] : [320] 
    .attribute [318] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [40] 
L6:     aload_0 
L7:     iconst_1 
L8:     putfield [46] 
L11:    return 
L12:    
    .end code 
.end method 

.method private [321] : [322] 
    .attribute [318] .code stack 3 locals 3 
L0:     aload_1 
L1:     ifnonnull L18 
L4:     aload_0 
L5:     getfield [20] 
L8:     sipush 10000 
L11:    ldc [2] 
L13:    invokevirtual [21] 
L16:    pop 
L17:    return 
L18:    aload_0 
L19:    getfield [20] 
L22:    ldc [3] 
L24:    ldc [4] 
L26:    invokevirtual [21] 
L29:    pop 
L30:    aload_1 
L31:    invokeinterface [47] 0 
L36:    astore_2 
L37:    aload_2 
L38:    ifnull L54 
L41:    aload_2 
L42:    invokeinterface [48] 0 
L47:    ifeq L54 
L50:    iconst_1 
L51:    goto L55 
L54:    iconst_0 
L55:    istore_3 
L56:    iload_3 
L57:    ifeq L65 
L60:    aload_0 
L61:    iconst_1 
L62:    putfield [49] 
L65:    aload_1 
L66:    ifnull L78 
L69:    aload_1 
L70:    invokeinterface [50] 0 
L75:    goto L79 
L78:    aconst_null 
L79:    astore 4 
L81:    aload 4 
L83:    ifnull L155 
L86:    aload 4 
L88:    invokeinterface [51] 0 
L93:    ifnull L155 
L96:    aload_0 
L97:    aload 4 
L99:    invokeinterface [52] 0 
L104:   putfield [53] 
L107:   aload_0 
L108:   aload 4 
L110:   invokeinterface [51] 0 
L115:   invokevirtual [24] 
L118:   putfield [54] 
L121:   aload_0 
L122:   aload 4 
L124:   invokeinterface [51] 0 
L129:   invokevirtual [26] 
L132:   putfield [55] 
L135:   aload_0 
L136:   aload_1 
L137:   invokeinterface [56] 0 
L142:   putfield [57] 
L145:   aload_0 
L146:   aload_1 
L147:   invokeinterface [58] 0 
L152:   putfield [59] 
L155:   aload_0 
L156:   invokespecial [41] 
L159:   return 
L160:   
    .end code 
.end method 

.method private [323] : [324] 
    .attribute [318] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [20] 
L4:     ldc [3] 
L6:     ldc [5] 
L8:     invokevirtual [21] 
L11:    pop 
L12:    aload_0 
L13:    getfield [22] 
L16:    ifeq L26 
L19:    aload_0 
L20:    bipush 15 
L22:    putfield [60] 
L25:    return 
L26:    aload_0 
L27:    getfield [27] 
L30:    tableswitch 0 
            L96 
            L104 
            L214 
            L278 
            L104 
            L214 
            L278 
            L251 
            L278 
            L260 
            L278 
            L278 
            L269 
            default : L278 

L96:    aload_0 
L97:    iconst_0 
L98:    putfield [60] 
L101:   goto L278 
L104:   aload_0 
L105:   getfield [29] 
L108:   iconst_2 
L109:   if_icmpne L116 
L112:   iconst_0 
L113:   goto L120 
L116:   aload_0 
L117:   getfield [28] 
L120:   istore_1 
L121:   iload_1 
L122:   tableswitch 0 
            L160 
            L169 
            L160 
            L178 
            L178 
            L186 
            default : L194 

L160:   aload_0 
L161:   bipush 18 
L163:   putfield [60] 
L166:   goto L278 
L169:   aload_0 
L170:   bipush 9 
L172:   putfield [60] 
L175:   goto L278 
L178:   aload_0 
L179:   iconst_5 
L180:   putfield [60] 
L183:   goto L278 
L186:   aload_0 
L187:   iconst_1 
L188:   putfield [60] 
L191:   goto L278 
L194:   aload_0 
L195:   getfield [20] 
L198:   ldc [3] 
L200:   ldc [6] 
L202:   aload_0 
L203:   getfield [28] 
L206:   i2l 
L207:   invokevirtual [31] 
L210:   pop 
L211:   goto L278 
L214:   aload_0 
L215:   aload_0 
L216:   getfield [25] 
L219:   invokespecial [42] 
L222:   ifeq L234 
L225:   aload_0 
L226:   bipush 7 
L228:   putfield [60] 
L231:   goto L278 
L234:   aload_0 
L235:   getfield [25] 
L238:   iconst_3 
L239:   if_icmpne L278 
L242:   aload_0 
L243:   bipush 15 
L245:   putfield [60] 
L248:   goto L278 
L251:   aload_0 
L252:   bipush 19 
L254:   putfield [60] 
L257:   goto L278 
L260:   aload_0 
L261:   bipush 20 
L263:   putfield [60] 
L266:   goto L278 
L269:   aload_0 
L270:   bipush 12 
L272:   putfield [60] 
L275:   goto L278 
L278:   return 
L279:   nop 
L280:   
    .end code 
.end method 

.method private [325] : [326] 
    .attribute [318] .code stack 2 locals 0 
L0:     iload_1 
L1:     iconst_2 
L2:     if_icmpeq L14 
L5:     iload_1 
L6:     ifeq L14 
L9:     iload_1 
L10:    iconst_1 
L11:    if_icmpne L18 
L14:    iconst_1 
L15:    goto L19 
L18:    iconst_0 
L19:    areturn 
L20:    
    .end code 
.end method 

.method protected [327] : [328] 
    .attribute [318] .code stack 1 locals 0 
L0:     iconst_1 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [329] : [330] 
    .attribute [318] .code stack 5 locals 3 
L0:     aload_0 
L1:     invokevirtual [32] 
L4:     astore_1 
L5:     aload_0 
L6:     invokevirtual [33] 
L9:     astore_2 
L10:    aload_1 
L11:    ifnonnull L27 
L14:    aload_0 
L15:    getfield [20] 
L18:    ldc [3] 
L20:    ldc [7] 
L22:    invokevirtual [21] 
L25:    pop 
L26:    return 
L27:    aload_0 
L28:    aload_1 
L29:    invokespecial [43] 
L32:    new [61] 
L35:    dup 
L36:    aload_0 
L37:    getfield [30] 
L40:    aload_0 
L41:    getfield [23] 
L44:    aload_0 
L45:    invokespecial [44] 
L48:    pop 
L49:    iconst_1 
L50:    invokespecial [45] 
L53:    astore_3 
L54:    aload_3 
L55:    aload_0 
L56:    getfield [34] 
L59:    invokevirtual [35] 
L62:    ifne L105 
L65:    aload_2 
L66:    ifnull L105 
L69:    aload_0 
L70:    getfield [20] 
L73:    ldc [9] 
L75:    ldc [10] 
L77:    aload_3 
L78:    invokevirtual [36] 
L81:    pop 
L82:    aload_2 
L83:    aload_3 
L84:    invokevirtual [37] 
L87:    aload_3 
L88:    invokevirtual [38] 
L91:    aload_3 
L92:    invokevirtual [39] 
L95:    invokeinterface [63] 0 
L100:   aload_0 
L101:   aload_3 
L102:   putfield [62] 
L105:   return 
L106:   nop 
L107:   nop 
L108:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [64] 
.const [3] = Int -2137614336 
.const [4] = String [65] 
.const [5] = String [66] 
.const [6] = String [67] 
.const [7] = String [68] 
.const [8] = Class [69] 
.const [9] = Int 1078071040 
.const [10] = String [70] 
.const [11] = Class [71] 
.const [12] = Class [72] 
.const [13] = Class [73] 
.const [14] = Class [74] 
.const [15] = Class [75] 
.const [16] = Class [76] 
.const [17] = Class [77] 
.const [18] = Class [78] 
.const [19] = Class [79] 
.const [20] = Field [80] [81] 
.const [21] = Method [82] [83] 
.const [22] = Field [84] [85] 
.const [23] = Field [86] [87] 
.const [24] = Method [88] [89] 
.const [25] = Field [90] [91] 
.const [26] = Method [92] [93] 
.const [27] = Field [94] [95] 
.const [28] = Field [96] [97] 
.const [29] = Field [98] [99] 
.const [30] = Field [100] [101] 
.const [31] = Method [102] [103] 
.const [32] = Method [104] [105] 
.const [33] = Method [106] [107] 
.const [34] = Field [108] [109] 
.const [35] = Method [110] [111] 
.const [36] = Method [112] [113] 
.const [37] = Method [114] [115] 
.const [38] = Method [116] [117] 
.const [39] = Method [118] [119] 
.const [40] = Method [120] [121] 
.const [41] = Method [122] [123] 
.const [42] = Method [124] [125] 
.const [43] = Method [126] [127] 
.const [44] = Method [128] [129] 
.const [45] = Method [130] [131] 
.const [46] = Field [132] [133] 
.const [47] = InterfaceMethod [134] [135] 
.const [48] = InterfaceMethod [136] [137] 
.const [49] = Field [138] [139] 
.const [50] = InterfaceMethod [140] [141] 
.const [51] = InterfaceMethod [142] [143] 
.const [52] = InterfaceMethod [144] [145] 
.const [53] = Field [146] [147] 
.const [54] = Field [148] [149] 
.const [55] = Field [150] [151] 
.const [56] = InterfaceMethod [152] [153] 
.const [57] = Field [154] [155] 
.const [58] = InterfaceMethod [156] [157] 
.const [59] = Field [158] [159] 
.const [60] = Field [160] [161] 
.const [61] = Class [162] 
.const [62] = Field [163] [164] 
.const [63] = InterfaceMethod [165] [166] 
.const [64] = Utf8 'BAPPropertyTelFSGOperationState#updateArgs telephoneState is null' 
.const [65] = Utf8 '[BAPPropertyTelFSGOperationState#updateArgs call' 
.const [66] = Utf8 '[BAPPropertyTelFSGOperationState#updateTelState] call' 
.const [67] = Utf8 'PhoneBAPPropertyFSGOperationState#telStateChanged: For ACTIVATIONSTATE_PHONE_OFF no action for %1' 
.const [68] = Utf8 '[BAPPropertyTelFSGOperationState#update nothing to update:  globalTelephoneState is null]' 
.const [69] = Utf8 de/audi/app/phone/core/bap/TelBapFSGOperationStateStruct 
.const [70] = Utf8 '[BAPPropertyTelFSGOperationState#update] updating cluster: %1' 
.const [71] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelFSGOperationState 
.const [72] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [73] = Utf8 de/audi/atip/log/LogChannel 
.const [74] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [75] = Utf8 de/audi/atip/interapp/phone/IEcallState 
.const [76] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [77] = Utf8 org/dsi/ifc/telephoneng/ActivationStateStruct 
.const [78] = Utf8 java/lang/Object 
.const [79] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [80] = Class [167] 
.const [81] = NameAndType [168] [169] 
.const [82] = Class [170] 
.const [83] = NameAndType [171] [172] 
.const [84] = Class [173] 
.const [85] = NameAndType [174] [175] 
.const [86] = Class [176] 
.const [87] = NameAndType [177] [178] 
.const [88] = Class [179] 
.const [89] = NameAndType [180] [181] 
.const [90] = Class [182] 
.const [91] = NameAndType [183] [184] 
.const [92] = Class [185] 
.const [93] = NameAndType [186] [187] 
.const [94] = Class [188] 
.const [95] = NameAndType [189] [190] 
.const [96] = Class [191] 
.const [97] = NameAndType [192] [193] 
.const [98] = Class [194] 
.const [99] = NameAndType [195] [196] 
.const [100] = Class [197] 
.const [101] = NameAndType [198] [199] 
.const [102] = Class [200] 
.const [103] = NameAndType [201] [202] 
.const [104] = Class [203] 
.const [105] = NameAndType [204] [205] 
.const [106] = Class [206] 
.const [107] = NameAndType [207] [208] 
.const [108] = Class [209] 
.const [109] = NameAndType [210] [211] 
.const [110] = Class [212] 
.const [111] = NameAndType [213] [214] 
.const [112] = Class [215] 
.const [113] = NameAndType [216] [217] 
.const [114] = Class [218] 
.const [115] = NameAndType [219] [220] 
.const [116] = Class [221] 
.const [117] = NameAndType [222] [223] 
.const [118] = Class [224] 
.const [119] = NameAndType [225] [226] 
.const [120] = Class [227] 
.const [121] = NameAndType [228] [229] 
.const [122] = Class [230] 
.const [123] = NameAndType [231] [232] 
.const [124] = Class [233] 
.const [125] = NameAndType [234] [235] 
.const [126] = Class [236] 
.const [127] = NameAndType [237] [238] 
.const [128] = Class [239] 
.const [129] = NameAndType [240] [241] 
.const [130] = Class [242] 
.const [131] = NameAndType [243] [244] 
.const [132] = Class [245] 
.const [133] = NameAndType [246] [247] 
.const [134] = Class [248] 
.const [135] = NameAndType [249] [250] 
.const [136] = Class [251] 
.const [137] = NameAndType [252] [253] 
.const [138] = Class [254] 
.const [139] = NameAndType [255] [256] 
.const [140] = Class [257] 
.const [141] = NameAndType [258] [259] 
.const [142] = Class [260] 
.const [143] = NameAndType [261] [262] 
.const [144] = Class [263] 
.const [145] = NameAndType [264] [265] 
.const [146] = Class [266] 
.const [147] = NameAndType [267] [268] 
.const [148] = Class [269] 
.const [149] = NameAndType [270] [271] 
.const [150] = Class [272] 
.const [151] = NameAndType [273] [274] 
.const [152] = Class [275] 
.const [153] = NameAndType [276] [277] 
.const [154] = Class [278] 
.const [155] = NameAndType [279] [280] 
.const [156] = Class [281] 
.const [157] = NameAndType [282] [283] 
.const [158] = Class [284] 
.const [159] = NameAndType [285] [286] 
.const [160] = Class [287] 
.const [161] = NameAndType [288] [289] 
.const [162] = Utf8 de/audi/app/phone/core/bap/TelBapFSGOperationStateStruct 
.const [163] = Class [290] 
.const [164] = NameAndType [291] [292] 
.const [165] = Class [293] 
.const [166] = NameAndType [294] [295] 
.const [167] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelFSGOperationState 
.const [168] = Utf8 log 
.const [169] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [170] = Utf8 de/audi/atip/log/LogChannel 
.const [171] = Utf8 log 
.const [172] = Utf8 (ILjava/lang/String;)Z 
.const [173] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelFSGOperationState 
.const [174] = Utf8 isLowPriorityEcallActive 
.const [175] = Utf8 Z 
.const [176] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelFSGOperationState 
.const [177] = Utf8 isPrivacyMode 
.const [178] = Utf8 Z 
.const [179] = Utf8 org/dsi/ifc/telephoneng/ActivationStateStruct 
.const [180] = Utf8 getTelMode 
.const [181] = Utf8 ()I 
.const [182] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelFSGOperationState 
.const [183] = Utf8 telMode 
.const [184] = Utf8 I 
.const [185] = Utf8 org/dsi/ifc/telephoneng/ActivationStateStruct 
.const [186] = Utf8 getTelActivationState 
.const [187] = Utf8 ()I 
.const [188] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelFSGOperationState 
.const [189] = Utf8 actState 
.const [190] = Utf8 I 
.const [191] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelFSGOperationState 
.const [192] = Utf8 phoneModuleState 
.const [193] = Utf8 I 
.const [194] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelFSGOperationState 
.const [195] = Utf8 nadMode 
.const [196] = Utf8 I 
.const [197] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelFSGOperationState 
.const [198] = Utf8 telState 
.const [199] = Utf8 I 
.const [200] = Utf8 de/audi/atip/log/LogChannel 
.const [201] = Utf8 log 
.const [202] = Utf8 (ILjava/lang/String;J)Z 
.const [203] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelFSGOperationState 
.const [204] = Utf8 getTelephoneState 
.const [205] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [206] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelFSGOperationState 
.const [207] = Utf8 getCombiService 
.const [208] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [209] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelFSGOperationState 
.const [210] = Utf8 fsgOperationStateStruct 
.const [211] = Utf8 Lde/audi/app/phone/core/bap/TelBapFSGOperationStateStruct; 
.const [212] = Utf8 de/audi/app/phone/core/bap/TelBapFSGOperationStateStruct 
.const [213] = Utf8 equals 
.const [214] = Utf8 (Ljava/lang/Object;)Z 
.const [215] = Utf8 de/audi/atip/log/LogChannel 
.const [216] = Utf8 log 
.const [217] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [218] = Utf8 de/audi/app/phone/core/bap/TelBapFSGOperationStateStruct 
.const [219] = Utf8 getTelState 
.const [220] = Utf8 ()I 
.const [221] = Utf8 de/audi/app/phone/core/bap/TelBapFSGOperationStateStruct 
.const [222] = Utf8 isPrivacyModeActive 
.const [223] = Utf8 ()Z 
.const [224] = Utf8 de/audi/app/phone/core/bap/TelBapFSGOperationStateStruct 
.const [225] = Utf8 isEnhancedPrivacyModeActive 
.const [226] = Utf8 ()Z 
.const [227] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [228] = Utf8 <init> 
.const [229] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [230] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelFSGOperationState 
.const [231] = Utf8 updateTelState 
.const [232] = Utf8 ()V 
.const [233] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelFSGOperationState 
.const [234] = Utf8 isSIMUsed 
.const [235] = Utf8 (I)Z 
.const [236] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelFSGOperationState 
.const [237] = Utf8 updateArgs 
.const [238] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [239] = Utf8 java/lang/Object 
.const [240] = Utf8 getClass 
.const [241] = Utf8 ()Ljava/lang/Class; 
.const [242] = Utf8 de/audi/app/phone/core/bap/TelBapFSGOperationStateStruct 
.const [243] = Utf8 <init> 
.const [244] = Utf8 (IZZ)V 
.const [245] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelFSGOperationState 
.const [246] = Utf8 enhancedPrivacyModeActive 
.const [247] = Utf8 Z 
.const [248] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [249] = Utf8 getConnectedGatewayState 
.const [250] = Utf8 ()Lde/audi/atip/interapp/phone/IEcallState; 
.const [251] = Utf8 de/audi/atip/interapp/phone/IEcallState 
.const [252] = Utf8 isLowPrioritySOSEmergencyCallType 
.const [253] = Utf8 ()Z 
.const [254] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelFSGOperationState 
.const [255] = Utf8 isLowPriorityEcallActive 
.const [256] = Utf8 Z 
.const [257] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [258] = Utf8 getCallLeadingDevice 
.const [259] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [260] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [261] = Utf8 getActivationState 
.const [262] = Utf8 ()Lorg/dsi/ifc/telephoneng/ActivationStateStruct; 
.const [263] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [264] = Utf8 isPrivacyMode 
.const [265] = Utf8 ()Z 
.const [266] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelFSGOperationState 
.const [267] = Utf8 isPrivacyMode 
.const [268] = Utf8 Z 
.const [269] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelFSGOperationState 
.const [270] = Utf8 telMode 
.const [271] = Utf8 I 
.const [272] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelFSGOperationState 
.const [273] = Utf8 actState 
.const [274] = Utf8 I 
.const [275] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [276] = Utf8 getPhoneModuleState 
.const [277] = Utf8 ()I 
.const [278] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelFSGOperationState 
.const [279] = Utf8 phoneModuleState 
.const [280] = Utf8 I 
.const [281] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [282] = Utf8 getNadMode 
.const [283] = Utf8 ()I 
.const [284] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelFSGOperationState 
.const [285] = Utf8 nadMode 
.const [286] = Utf8 I 
.const [287] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelFSGOperationState 
.const [288] = Utf8 telState 
.const [289] = Utf8 I 
.const [290] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelFSGOperationState 
.const [291] = Utf8 fsgOperationStateStruct 
.const [292] = Utf8 Lde/audi/app/phone/core/bap/TelBapFSGOperationStateStruct; 
.const [293] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [294] = Utf8 updateFSGOperationState 
.const [295] = Utf8 (IZZ)V 
.const [296] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelFSGOperationState 
.const [297] = Class [296] 
.const [298] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [299] = Class [298] 
.const [300] = Utf8 fsgOperationStateStruct 
.const [301] = Utf8 Lde/audi/app/phone/core/bap/TelBapFSGOperationStateStruct; 
.const [302] = Utf8 telMode 
.const [303] = Utf8 I 
.const [304] = Utf8 actState 
.const [305] = Utf8 I 
.const [306] = Utf8 phoneModuleState 
.const [307] = Utf8 I 
.const [308] = Utf8 telState 
.const [309] = Utf8 I 
.const [310] = Utf8 isPrivacyMode 
.const [311] = Utf8 Z 
.const [312] = Utf8 nadMode 
.const [313] = Utf8 I 
.const [314] = Utf8 enhancedPrivacyModeActive 
.const [315] = Utf8 Z 
.const [316] = Utf8 isLowPriorityEcallActive 
.const [317] = Utf8 Z 
.const [318] = Utf8 Code 
.const [319] = Utf8 <init> 
.const [320] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [321] = Utf8 updateArgs 
.const [322] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [323] = Utf8 updateTelState 
.const [324] = Utf8 ()V 
.const [325] = Utf8 isSIMUsed 
.const [326] = Utf8 (I)Z 
.const [327] = Utf8 doProcessGlobalTelephoneStateUpdate 
.const [328] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)Z 
.const [329] = Utf8 updateAsync 
.const [330] = Utf8 ()V 
.end class 
