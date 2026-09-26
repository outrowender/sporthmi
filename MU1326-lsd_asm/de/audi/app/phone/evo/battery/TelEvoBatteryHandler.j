.version 50 0 
.class public super [296] 
.super [298] 
.field private static final [299] [300] 
.field private final [301] [302] 
.field private final [303] [304] 
.field private final [305] [306] 

.method private static [308] : [309] 
    .attribute [307] .code stack 2 locals 0 
L0:     iload_0 
L1:     ifeq L9 
L4:     iload_0 
L5:     iconst_1 
L6:     if_icmpne L13 
L9:     iconst_1 
L10:    goto L14 
L13:    iconst_0 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method private static [310] : [311] 
    .attribute [307] .code stack 2 locals 0 
L0:     ldc [2] 
L2:     aload_0 
L3:     invokevirtual [31] 
L6:     ifne L13 
L9:     iconst_1 
L10:    goto L14 
L13:    iconst_0 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [312] : [313] 
    .attribute [307] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [47] 
L5:     aload_0 
L6:     new [53] 
L9:     dup 
L10:    iconst_2 
L11:    invokespecial [48] 
L14:    putfield [54] 
L17:    aload_0 
L18:    aload_1 
L19:    invokeinterface [55] 0 
L24:    invokeinterface [56] 0 
L29:    sipush 4343 
L32:    invokeinterface [57] 0 
L37:    putfield [58] 
L40:    aload_0 
L41:    aload_1 
L42:    putfield [59] 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method protected [314] : [315] 
    .attribute [307] .code stack 6 locals 5 
L0:     aload_0 
L1:     getfield [35] 
L4:     ldc [4] 
L6:     ldc [5] 
L8:     aload_1 
L9:     aload_2 
L10:    iload_3 
L11:    invokestatic [6] 
L14:    invokevirtual [36] 
L17:    aload_0 
L18:    getfield [32] 
L21:    dup 
L22:    astore 4 
L24:    monitorenter 
        .catch [0] from L25 to L77 using L278 
L25:    aload_0 
L26:    getfield [32] 
L29:    aload_2 
L30:    invokevirtual [37] 
L33:    ifeq L53 
L36:    aload_0 
L37:    getfield [32] 
L40:    aload_2 
L41:    invokevirtual [38] 
L44:    checkcast [7] 
L47:    invokevirtual [39] 
L50:    goto L54 
L53:    iconst_0 
L54:    istore 5 
L56:    iload 5 
L58:    ifeq L78 
L61:    aload_0 
L62:    getfield [35] 
L65:    ldc [8] 
L67:    ldc [9] 
L69:    aload_1 
L70:    aload_2 
L71:    invokevirtual [40] 
L74:    aload 4 
L76:    monitorexit 
L77:    return 
        .catch [0] from L78 to L275 using L278 
L78:    aload_2 
L79:    invokestatic [10] 
L82:    ifeq L194 
L85:    iload_3 
L86:    invokestatic [11] 
L89:    ifeq L173 
L92:    aload_0 
L93:    invokespecial [49] 
L96:    ifeq L152 
L99:    aload_0 
L100:   invokespecial [50] 
L103:   ifeq L127 
L106:   aload_0 
L107:   aload_2 
L108:   iload_3 
L109:   invokespecial [51] 
L112:   aload_0 
L113:   getfield [32] 
L116:   aload_2 
L117:   getstatic [12] 
L120:   invokevirtual [41] 
L123:   pop 
L124:   goto L200 
L127:   aload_0 
L128:   getfield [35] 
L131:   ldc [8] 
L133:   ldc [13] 
L135:   aload_0 
L136:   getfield [33] 
L139:   invokeinterface [60] 0 
L144:   i2l 
L145:   invokevirtual [42] 
L148:   pop 
L149:   goto L200 
L152:   aload_0 
L153:   aload_2 
L154:   iload_3 
L155:   invokespecial [51] 
L158:   aload_0 
L159:   getfield [32] 
L162:   aload_2 
L163:   getstatic [12] 
L166:   invokevirtual [41] 
L169:   pop 
L170:   goto L200 
L173:   aload_0 
L174:   aload_2 
L175:   iload_3 
L176:   invokespecial [52] 
L179:   aload_0 
L180:   getfield [32] 
L183:   aload_2 
L184:   getstatic [14] 
L187:   invokevirtual [41] 
L190:   pop 
L191:   goto L200 
L194:   aload_0 
L195:   aload_2 
L196:   iload_3 
L197:   invokespecial [52] 
L200:   aload_0 
L201:   getfield [32] 
L204:   invokevirtual [43] 
L207:   invokeinterface [61] 0 
L212:   astore 6 
L214:   aload 6 
L216:   invokeinterface [62] 0 
L221:   ifeq L272 
L224:   aload 6 
L226:   invokeinterface [63] 0 
L231:   checkcast [15] 
L234:   astore 7 
L236:   aload_0 
L237:   aload 7 
L239:   invokevirtual [44] 
L242:   ifne L269 
L245:   aload_0 
L246:   getfield [35] 
L249:   ldc [4] 
L251:   ldc [16] 
L253:   aload 7 
L255:   invokevirtual [45] 
L258:   pop 
L259:   aload_0 
L260:   getfield [32] 
L263:   aload 7 
L265:   invokevirtual [46] 
L268:   pop 
L269:   goto L214 
L272:   aload 4 
L274:   monitorexit 
L275:   goto L286 
        .catch [0] from L278 to L283 using L278 
L278:   astore 8 
L280:   aload 4 
L282:   monitorexit 
L283:   aload 8 
L285:   athrow 
L286:   return 
L287:   nop 
L288:   
    .end code 
.end method 

.method private [316] : [317] 
    .attribute [307] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [35] 
L4:     ldc [8] 
L6:     ldc [17] 
L8:     aload_1 
L9:     iload_2 
L10:    invokestatic [6] 
L13:    invokevirtual [40] 
L16:    aload_0 
L17:    getfield [34] 
L20:    invokeinterface [55] 0 
L25:    invokeinterface [64] 0 
L30:    iconst_0 
L31:    ldc [18] 
L33:    invokeinterface [65] 0 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method private [318] : [319] 
    .attribute [307] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [35] 
L4:     ldc [4] 
L6:     ldc [19] 
L8:     aload_1 
L9:     iload_2 
L10:    invokestatic [6] 
L13:    invokevirtual [40] 
L16:    aload_0 
L17:    getfield [34] 
L20:    invokeinterface [55] 0 
L25:    invokeinterface [64] 0 
L30:    iconst_0 
L31:    ldc [18] 
L33:    invokeinterface [66] 0 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method private [320] : [321] 
    .attribute [307] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     ifnull L23 
L7:     aload_0 
L8:     getfield [33] 
L11:    invokeinterface [60] 0 
L16:    ifne L23 
L19:    iconst_1 
L20:    goto L24 
L23:    iconst_0 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private final [322] : [323] 
    .attribute [307] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     invokeinterface [55] 0 
L9:     sipush 4162 
L12:    invokeinterface [67] 0 
L17:    iconst_1 
L18:    if_icmpne L25 
L21:    iconst_1 
L22:    goto L26 
L25:    iconst_0 
L26:    areturn 
L27:    nop 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [68] 
.const [3] = Class [69] 
.const [4] = Int -2137614336 
.const [5] = String [70] 
.const [6] = Method [71] [72] 
.const [7] = Class [73] 
.const [8] = Int 1078071040 
.const [9] = String [74] 
.const [10] = Method [75] [76] 
.const [11] = Method [77] [78] 
.const [12] = Field [79] [80] 
.const [13] = String [81] 
.const [14] = Field [82] [83] 
.const [15] = Class [84] 
.const [16] = String [85] 
.const [17] = String [86] 
.const [18] = Int 898892800 
.const [19] = String [87] 
.const [20] = Class [88] 
.const [21] = Class [89] 
.const [22] = Class [90] 
.const [23] = Class [91] 
.const [24] = Class [92] 
.const [25] = Class [93] 
.const [26] = Class [94] 
.const [27] = Class [95] 
.const [28] = Class [96] 
.const [29] = Class [97] 
.const [30] = Class [98] 
.const [31] = Method [99] [100] 
.const [32] = Field [101] [102] 
.const [33] = Field [103] [104] 
.const [34] = Field [105] [106] 
.const [35] = Field [107] [108] 
.const [36] = Method [109] [110] 
.const [37] = Method [111] [112] 
.const [38] = Method [113] [114] 
.const [39] = Method [115] [116] 
.const [40] = Method [117] [118] 
.const [41] = Method [119] [120] 
.const [42] = Method [121] [122] 
.const [43] = Method [123] [124] 
.const [44] = Method [125] [126] 
.const [45] = Method [127] [128] 
.const [46] = Method [129] [130] 
.const [47] = Method [131] [132] 
.const [48] = Method [133] [134] 
.const [49] = Method [135] [136] 
.const [50] = Method [137] [138] 
.const [51] = Method [139] [140] 
.const [52] = Method [141] [142] 
.const [53] = Class [143] 
.const [54] = Field [144] [145] 
.const [55] = InterfaceMethod [146] [147] 
.const [56] = InterfaceMethod [148] [149] 
.const [57] = InterfaceMethod [150] [151] 
.const [58] = Field [152] [153] 
.const [59] = Field [154] [155] 
.const [60] = InterfaceMethod [156] [157] 
.const [61] = InterfaceMethod [158] [159] 
.const [62] = InterfaceMethod [160] [161] 
.const [63] = InterfaceMethod [162] [163] 
.const [64] = InterfaceMethod [164] [165] 
.const [65] = InterfaceMethod [166] [167] 
.const [66] = InterfaceMethod [168] [169] 
.const [67] = InterfaceMethod [170] [171] 
.const [68] = Utf8 '' 
.const [69] = Utf8 java/util/HashMap 
.const [70] = Utf8 '[TelEvoBatteryHandler#handleBatteryChargeLevel] called. meBTAddress=%2, batteryChargeLevel=%3, meFriendlyName=%1' 
.const [71] = Class [172] 
.const [72] = NameAndType [173] [174] 
.const [73] = Utf8 java/lang/Boolean 
.const [74] = Utf8 '[TelEvoBatteryHandler#handleBatteryChargeLevel] popup for (%1,%2) already shown --> NOP!' 
.const [75] = Class [175] 
.const [76] = NameAndType [176] [177] 
.const [77] = Class [178] 
.const [78] = NameAndType [179] [180] 
.const [79] = Class [181] 
.const [80] = NameAndType [182] [183] 
.const [81] = Utf8 '[TelEvoBatteryHandler#handleBatteryChargeLevel] Info popups were desabled by user, NOT showing low battery level warning. InfoPopupModel.getValue()=%1' 
.const [82] = Class [184] 
.const [83] = NameAndType [185] [186] 
.const [84] = Utf8 java/lang/String 
.const [85] = Utf8 '[TelEvoBatteryHandler#handleBatteryChargeLevel] removing btAddress %1 from map' 
.const [86] = Utf8 '[TelEvoBatteryHandler#showBatteryWarningPopup] meBTAddress=%1, batteryChargeLevel=%2' 
.const [87] = Utf8 '[TelEvoBatteryHandler#removeBatteryWarningPopup] meBTAddress=%1, batteryChargeLevel=%2' 
.const [88] = Utf8 de/audi/app/phone/evo/battery/TelEvoBatteryHandler 
.const [89] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler 
.const [90] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [91] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [92] = Utf8 de/audi/atip/hmi/HMIService 
.const [93] = Utf8 java/lang/Integer 
.const [94] = Utf8 de/audi/atip/log/LogChannel 
.const [95] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [96] = Utf8 java/util/Set 
.const [97] = Utf8 java/util/Iterator 
.const [98] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [99] = Class [187] 
.const [100] = NameAndType [188] [189] 
.const [101] = Class [190] 
.const [102] = NameAndType [191] [192] 
.const [103] = Class [193] 
.const [104] = NameAndType [194] [195] 
.const [105] = Class [196] 
.const [106] = NameAndType [197] [198] 
.const [107] = Class [199] 
.const [108] = NameAndType [200] [201] 
.const [109] = Class [202] 
.const [110] = NameAndType [203] [204] 
.const [111] = Class [205] 
.const [112] = NameAndType [206] [207] 
.const [113] = Class [208] 
.const [114] = NameAndType [209] [210] 
.const [115] = Class [211] 
.const [116] = NameAndType [212] [213] 
.const [117] = Class [214] 
.const [118] = NameAndType [215] [216] 
.const [119] = Class [217] 
.const [120] = NameAndType [218] [219] 
.const [121] = Class [220] 
.const [122] = NameAndType [221] [222] 
.const [123] = Class [223] 
.const [124] = NameAndType [224] [225] 
.const [125] = Class [226] 
.const [126] = NameAndType [227] [228] 
.const [127] = Class [229] 
.const [128] = NameAndType [230] [231] 
.const [129] = Class [232] 
.const [130] = NameAndType [233] [234] 
.const [131] = Class [235] 
.const [132] = NameAndType [236] [237] 
.const [133] = Class [238] 
.const [134] = NameAndType [239] [240] 
.const [135] = Class [241] 
.const [136] = NameAndType [242] [243] 
.const [137] = Class [244] 
.const [138] = NameAndType [245] [246] 
.const [139] = Class [247] 
.const [140] = NameAndType [248] [249] 
.const [141] = Class [250] 
.const [142] = NameAndType [251] [252] 
.const [143] = Utf8 java/util/HashMap 
.const [144] = Class [253] 
.const [145] = NameAndType [254] [255] 
.const [146] = Class [256] 
.const [147] = NameAndType [257] [258] 
.const [148] = Class [259] 
.const [149] = NameAndType [260] [261] 
.const [150] = Class [262] 
.const [151] = NameAndType [263] [264] 
.const [152] = Class [265] 
.const [153] = NameAndType [266] [267] 
.const [154] = Class [268] 
.const [155] = NameAndType [269] [270] 
.const [156] = Class [271] 
.const [157] = NameAndType [272] [273] 
.const [158] = Class [274] 
.const [159] = NameAndType [275] [276] 
.const [160] = Class [277] 
.const [161] = NameAndType [278] [279] 
.const [162] = Class [280] 
.const [163] = NameAndType [281] [282] 
.const [164] = Class [283] 
.const [165] = NameAndType [284] [285] 
.const [166] = Class [286] 
.const [167] = NameAndType [287] [288] 
.const [168] = Class [289] 
.const [169] = NameAndType [290] [291] 
.const [170] = Class [292] 
.const [171] = NameAndType [293] [294] 
.const [172] = Utf8 java/lang/Integer 
.const [173] = Utf8 toString 
.const [174] = Utf8 (I)Ljava/lang/String; 
.const [175] = Utf8 de/audi/app/phone/evo/battery/TelEvoBatteryHandler 
.const [176] = Utf8 btDeviceAvailable 
.const [177] = Utf8 (Ljava/lang/String;)Z 
.const [178] = Utf8 de/audi/app/phone/evo/battery/TelEvoBatteryHandler 
.const [179] = Utf8 isBatteryLevelLow 
.const [180] = Utf8 (I)Z 
.const [181] = Utf8 java/lang/Boolean 
.const [182] = Utf8 TRUE 
.const [183] = Utf8 Ljava/lang/Boolean; 
.const [184] = Utf8 java/lang/Boolean 
.const [185] = Utf8 FALSE 
.const [186] = Utf8 Ljava/lang/Boolean; 
.const [187] = Utf8 java/lang/String 
.const [188] = Utf8 equals 
.const [189] = Utf8 (Ljava/lang/Object;)Z 
.const [190] = Utf8 de/audi/app/phone/evo/battery/TelEvoBatteryHandler 
.const [191] = Utf8 popupShownMap 
.const [192] = Utf8 Ljava/util/HashMap; 
.const [193] = Utf8 de/audi/app/phone/evo/battery/TelEvoBatteryHandler 
.const [194] = Utf8 infoPopupModel 
.const [195] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [196] = Utf8 de/audi/app/phone/evo/battery/TelEvoBatteryHandler 
.const [197] = Utf8 phoneApplication 
.const [198] = Utf8 Lde/audi/app/phone/core/ITelApplication; 
.const [199] = Utf8 de/audi/app/phone/evo/battery/TelEvoBatteryHandler 
.const [200] = Utf8 log 
.const [201] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [202] = Utf8 de/audi/atip/log/LogChannel 
.const [203] = Utf8 log 
.const [204] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [205] = Utf8 java/util/HashMap 
.const [206] = Utf8 containsKey 
.const [207] = Utf8 (Ljava/lang/Object;)Z 
.const [208] = Utf8 java/util/HashMap 
.const [209] = Utf8 get 
.const [210] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [211] = Utf8 java/lang/Boolean 
.const [212] = Utf8 booleanValue 
.const [213] = Utf8 ()Z 
.const [214] = Utf8 de/audi/atip/log/LogChannel 
.const [215] = Utf8 log 
.const [216] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [217] = Utf8 java/util/HashMap 
.const [218] = Utf8 put 
.const [219] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [220] = Utf8 de/audi/atip/log/LogChannel 
.const [221] = Utf8 log 
.const [222] = Utf8 (ILjava/lang/String;J)Z 
.const [223] = Utf8 java/util/HashMap 
.const [224] = Utf8 keySet 
.const [225] = Utf8 ()Ljava/util/Set; 
.const [226] = Utf8 de/audi/app/phone/evo/battery/TelEvoBatteryHandler 
.const [227] = Utf8 isConnectedViaSAPOrHFP 
.const [228] = Utf8 (Ljava/lang/String;)Z 
.const [229] = Utf8 de/audi/atip/log/LogChannel 
.const [230] = Utf8 log 
.const [231] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [232] = Utf8 java/util/HashMap 
.const [233] = Utf8 remove 
.const [234] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [235] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler 
.const [236] = Utf8 <init> 
.const [237] = Utf8 (Lde/audi/app/phone/core/ITelApplication;)V 
.const [238] = Utf8 java/util/HashMap 
.const [239] = Utf8 <init> 
.const [240] = Utf8 (I)V 
.const [241] = Utf8 de/audi/app/phone/evo/battery/TelEvoBatteryHandler 
.const [242] = Utf8 isWLCPhoneBoxInstalled 
.const [243] = Utf8 ()Z 
.const [244] = Utf8 de/audi/app/phone/evo/battery/TelEvoBatteryHandler 
.const [245] = Utf8 areInfoPopupsAvailable 
.const [246] = Utf8 ()Z 
.const [247] = Utf8 de/audi/app/phone/evo/battery/TelEvoBatteryHandler 
.const [248] = Utf8 showBatteryWarningPopup 
.const [249] = Utf8 (Ljava/lang/String;I)V 
.const [250] = Utf8 de/audi/app/phone/evo/battery/TelEvoBatteryHandler 
.const [251] = Utf8 removeBatteryWarningPopup 
.const [252] = Utf8 (Ljava/lang/String;I)V 
.const [253] = Utf8 de/audi/app/phone/evo/battery/TelEvoBatteryHandler 
.const [254] = Utf8 popupShownMap 
.const [255] = Utf8 Ljava/util/HashMap; 
.const [256] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [257] = Utf8 getFrameworkAccess 
.const [258] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [259] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [260] = Utf8 getHMIService 
.const [261] = Utf8 ()Lde/audi/atip/hmi/HMIService; 
.const [262] = Utf8 de/audi/atip/hmi/HMIService 
.const [263] = Utf8 getChoiceModel 
.const [264] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [265] = Utf8 de/audi/app/phone/evo/battery/TelEvoBatteryHandler 
.const [266] = Utf8 infoPopupModel 
.const [267] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [268] = Utf8 de/audi/app/phone/evo/battery/TelEvoBatteryHandler 
.const [269] = Utf8 phoneApplication 
.const [270] = Utf8 Lde/audi/app/phone/core/ITelApplication; 
.const [271] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [272] = Utf8 getValue 
.const [273] = Utf8 ()I 
.const [274] = Utf8 java/util/Set 
.const [275] = Utf8 iterator 
.const [276] = Utf8 ()Ljava/util/Iterator; 
.const [277] = Utf8 java/util/Iterator 
.const [278] = Utf8 hasNext 
.const [279] = Utf8 ()Z 
.const [280] = Utf8 java/util/Iterator 
.const [281] = Utf8 next 
.const [282] = Utf8 ()Ljava/lang/Object; 
.const [283] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [284] = Utf8 getHmiServiceApp 
.const [285] = Utf8 ()Lde/audi/atip/hmi/IHMIServiceApp; 
.const [286] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [287] = Utf8 showPartialPopup 
.const [288] = Utf8 (II)V 
.const [289] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [290] = Utf8 removePartialPopup 
.const [291] = Utf8 (II)V 
.const [292] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [293] = Utf8 getSysConst 
.const [294] = Utf8 (I)I 
.const [295] = Utf8 de/audi/app/phone/evo/battery/TelEvoBatteryHandler 
.const [296] = Class [295] 
.const [297] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler 
.const [298] = Class [297] 
.const [299] = Utf8 BATTERY_POPUP 
.const [300] = Utf8 I 
.const [301] = Utf8 infoPopupModel 
.const [302] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [303] = Utf8 phoneApplication 
.const [304] = Utf8 Lde/audi/app/phone/core/ITelApplication; 
.const [305] = Utf8 popupShownMap 
.const [306] = Utf8 Ljava/util/HashMap; 
.const [307] = Utf8 Code 
.const [308] = Utf8 isBatteryLevelLow 
.const [309] = Utf8 (I)Z 
.const [310] = Utf8 btDeviceAvailable 
.const [311] = Utf8 (Ljava/lang/String;)Z 
.const [312] = Utf8 <init> 
.const [313] = Utf8 (Lde/audi/app/phone/core/ITelApplication;)V 
.const [314] = Utf8 handleBatteryChargeLevel 
.const [315] = Utf8 (Ljava/lang/String;Ljava/lang/String;I)V 
.const [316] = Utf8 showBatteryWarningPopup 
.const [317] = Utf8 (Ljava/lang/String;I)V 
.const [318] = Utf8 removeBatteryWarningPopup 
.const [319] = Utf8 (Ljava/lang/String;I)V 
.const [320] = Utf8 areInfoPopupsAvailable 
.const [321] = Utf8 ()Z 
.const [322] = Utf8 isWLCPhoneBoxInstalled 
.const [323] = Utf8 ()Z 
.end class 
