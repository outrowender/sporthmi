.version 50 0 
.class public super [240] 
.super [242] 
.field private final [243] [244] 
.field private final [245] [246] 

.method public [248] : [249] 
    .attribute [247] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     invokespecial [46] 
L7:     aload_0 
L8:     aload 4 
L10:    putfield [48] 
L13:    aload_0 
L14:    aload 5 
L16:    putfield [49] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [250] : [251] 
    .attribute [247] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [29] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_0 
L9:     invokevirtual [30] 
L12:    invokevirtual [31] 
L15:    pop 
L16:    aload_0 
L17:    getfield [27] 
L20:    iconst_1 
L21:    invokeinterface [50] 0 
L26:    astore_1 
L27:    aload_1 
L28:    ifnonnull L54 
L31:    aload_0 
L32:    getfield [29] 
L35:    ldc [4] 
L37:    ldc [5] 
L39:    aload_0 
L40:    invokevirtual [30] 
L43:    invokevirtual [31] 
L46:    pop 
L47:    aload_0 
L48:    ldc [6] 
L50:    invokevirtual [32] 
L53:    return 
L54:    aload_0 
L55:    getfield [29] 
L58:    ldc [2] 
L60:    ldc [7] 
L62:    aload_0 
L63:    invokevirtual [30] 
L66:    aload_1 
L67:    invokevirtual [33] 
L70:    aload_0 
L71:    aload_1 
L72:    invokevirtual [34] 
L75:    aload_1 
L76:    getfield [35] 
L79:    iconst_1 
L80:    invokestatic [8] 
L83:    aload_1 
L84:    getfield [36] 
L87:    iconst_2 
L88:    invokestatic [8] 
L91:    aload_1 
L92:    getfield [37] 
L95:    iconst_3 
L96:    invokestatic [8] 
L99:    aload_1 
L100:   getfield [38] 
L103:   iconst_4 
L104:   invokestatic [8] 
L107:   aload_1 
L108:   getfield [39] 
L111:   f2i 
L112:   invokestatic [9] 
L115:   aload_1 
L116:   getfield [40] 
L119:   invokestatic [10] 
L122:   aload_1 
L123:   getfield [41] 
L126:   invokestatic [11] 
L129:   aload_0 
L130:   aload_1 
L131:   getfield [42] 
L134:   invokevirtual [43] 
L137:   invokestatic [12] 
L140:   aload_0 
L141:   ldc [13] 
L143:   invokevirtual [32] 
L146:   return 
L147:   nop 
L148:   
    .end code 
.end method 

.method protected [252] : [253] 
    .attribute [247] .code stack 4 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [28] 
L5:     aload_0 
L6:     getfield [44] 
L9:     invokeinterface [53] 0 
L14:    aload_0 
L15:    getfield [29] 
L18:    invokestatic [14] 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected [254] : [255] 
    .attribute [247] .code stack 5 locals 0 
L0:     aload_1 
L1:     getfield [41] 
L4:     lookupswitch 
            2 : L32 
            4 : L69 
            default : L93 

L32:    aload_1 
L33:    getfield [39] 
L36:    fconst_1 
L37:    fcmpg 
L38:    ifge L93 
L41:    aload_1 
L42:    new [54] 
L45:    dup 
L46:    aload_1 
L47:    getfield [39] 
L50:    iconst_2 
L51:    invokespecial [47] 
L54:    iconst_4 
L55:    invokevirtual [45] 
L58:    putfield [51] 
L61:    aload_1 
L62:    iconst_3 
L63:    putfield [52] 
L66:    goto L93 
L69:    aload_1 
L70:    aload_1 
L71:    getfield [39] 
L74:    ldc [16] 
L76:    fdiv 
L77:    f2d 
L78:    invokestatic [17] 
L81:    d2f 
L82:    putfield [51] 
L85:    aload_1 
L86:    iconst_3 
L87:    putfield [52] 
L90:    goto L93 
L93:    return 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [55] 
.const [4] = Int -1601830656 
.const [5] = String [56] 
.const [6] = Int 1100742656 
.const [7] = String [57] 
.const [8] = Method [58] [59] 
.const [9] = Method [60] [61] 
.const [10] = Method [62] [63] 
.const [11] = Method [64] [65] 
.const [12] = Method [66] [67] 
.const [13] = Int 1083965440 
.const [14] = Method [68] [69] 
.const [15] = Class [70] 
.const [16] = Int 16448 
.const [17] = Method [71] [72] 
.const [18] = Class [73] 
.const [19] = Class [74] 
.const [20] = Class [75] 
.const [21] = Class [76] 
.const [22] = Class [77] 
.const [23] = Class [78] 
.const [24] = Class [79] 
.const [25] = Class [80] 
.const [26] = Class [81] 
.const [27] = Field [82] [83] 
.const [28] = Field [84] [85] 
.const [29] = Field [86] [87] 
.const [30] = Method [88] [89] 
.const [31] = Method [90] [91] 
.const [32] = Method [92] [93] 
.const [33] = Method [94] [95] 
.const [34] = Method [96] [97] 
.const [35] = Field [98] [99] 
.const [36] = Field [100] [101] 
.const [37] = Field [102] [103] 
.const [38] = Field [104] [105] 
.const [39] = Field [106] [107] 
.const [40] = Field [108] [109] 
.const [41] = Field [110] [111] 
.const [42] = Field [112] [113] 
.const [43] = Method [114] [115] 
.const [44] = Field [116] [117] 
.const [45] = Method [118] [119] 
.const [46] = Method [120] [121] 
.const [47] = Method [122] [123] 
.const [48] = Field [124] [125] 
.const [49] = Field [126] [127] 
.const [50] = InterfaceMethod [128] [129] 
.const [51] = Field [130] [131] 
.const [52] = Field [132] [133] 
.const [53] = InterfaceMethod [134] [135] 
.const [54] = Class [136] 
.const [55] = Utf8 '%1#execute: called' 
.const [56] = Utf8 '%1#execute: No infoDetails given!' 
.const [57] = Utf8 '%1#execute: infoDetails=%2!' 
.const [58] = Class [137] 
.const [59] = NameAndType [138] [139] 
.const [60] = Class [140] 
.const [61] = NameAndType [141] [142] 
.const [62] = Class [143] 
.const [63] = NameAndType [144] [145] 
.const [64] = Class [146] 
.const [65] = NameAndType [147] [148] 
.const [66] = Class [149] 
.const [67] = NameAndType [150] [151] 
.const [68] = Class [152] 
.const [69] = NameAndType [153] [154] 
.const [70] = Utf8 de/audi/atip/metrics/Distance 
.const [71] = Class [155] 
.const [72] = NameAndType [156] [157] 
.const [73] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviGetInfoCommand 
.const [74] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [75] = Utf8 de/audi/atip/interapp/NaviService$NaviInfoDetails 
.const [76] = Utf8 de/audi/atip/log/LogChannel 
.const [77] = Utf8 de/audi/atip/interapp/NaviService 
.const [78] = Utf8 de/audi/app/sdsmanager/SDSModelAccess 
.const [79] = Utf8 de/audi/app/sdsmanager/apps/SDSHandlerService 
.const [80] = Utf8 de/audi/app/sdsmanager/apps/navi/NaviSDSUtils 
.const [81] = Utf8 java/lang/Math 
.const [82] = Class [158] 
.const [83] = NameAndType [159] [160] 
.const [84] = Class [161] 
.const [85] = NameAndType [162] [163] 
.const [86] = Class [164] 
.const [87] = NameAndType [165] [166] 
.const [88] = Class [167] 
.const [89] = NameAndType [168] [169] 
.const [90] = Class [170] 
.const [91] = NameAndType [171] [172] 
.const [92] = Class [173] 
.const [93] = NameAndType [174] [175] 
.const [94] = Class [176] 
.const [95] = NameAndType [177] [178] 
.const [96] = Class [179] 
.const [97] = NameAndType [180] [181] 
.const [98] = Class [182] 
.const [99] = NameAndType [183] [184] 
.const [100] = Class [185] 
.const [101] = NameAndType [186] [187] 
.const [102] = Class [188] 
.const [103] = NameAndType [189] [190] 
.const [104] = Class [191] 
.const [105] = NameAndType [192] [193] 
.const [106] = Class [194] 
.const [107] = NameAndType [195] [196] 
.const [108] = Class [197] 
.const [109] = NameAndType [198] [199] 
.const [110] = Class [200] 
.const [111] = NameAndType [201] [202] 
.const [112] = Class [203] 
.const [113] = NameAndType [204] [205] 
.const [114] = Class [206] 
.const [115] = NameAndType [207] [208] 
.const [116] = Class [209] 
.const [117] = NameAndType [210] [211] 
.const [118] = Class [212] 
.const [119] = NameAndType [213] [214] 
.const [120] = Class [215] 
.const [121] = NameAndType [216] [217] 
.const [122] = Class [218] 
.const [123] = NameAndType [219] [220] 
.const [124] = Class [221] 
.const [125] = NameAndType [222] [223] 
.const [126] = Class [224] 
.const [127] = NameAndType [225] [226] 
.const [128] = Class [227] 
.const [129] = NameAndType [228] [229] 
.const [130] = Class [230] 
.const [131] = NameAndType [231] [232] 
.const [132] = Class [233] 
.const [133] = NameAndType [234] [235] 
.const [134] = Class [236] 
.const [135] = NameAndType [237] [238] 
.const [136] = Utf8 de/audi/atip/metrics/Distance 
.const [137] = Utf8 de/audi/app/sdsmanager/SDSModelAccess 
.const [138] = Utf8 setNavInfoForLevel 
.const [139] = Utf8 (Ljava/lang/String;I)V 
.const [140] = Utf8 de/audi/app/sdsmanager/SDSModelAccess 
.const [141] = Utf8 setNavInfoDistance 
.const [142] = Utf8 (I)V 
.const [143] = Utf8 de/audi/app/sdsmanager/SDSModelAccess 
.const [144] = Utf8 setNavInfoPOIName 
.const [145] = Utf8 (Ljava/lang/String;)V 
.const [146] = Utf8 de/audi/app/sdsmanager/SDSModelAccess 
.const [147] = Utf8 setNavInfoScaleUnit 
.const [148] = Utf8 (I)V 
.const [149] = Utf8 de/audi/app/sdsmanager/SDSModelAccess 
.const [150] = Utf8 setNavInfoTime 
.const [151] = Utf8 (Ljava/lang/String;)V 
.const [152] = Utf8 de/audi/app/sdsmanager/apps/navi/NaviSDSUtils 
.const [153] = Utf8 formatTimeString 
.const [154] = Utf8 (Lde/audi/atip/metrics/DateMetric;Lde/audi/atip/i18n/ILanguageManager;Lde/audi/atip/base/IFrameworkAccess;Lde/audi/atip/log/LogChannel;)Ljava/lang/String; 
.const [155] = Utf8 java/lang/Math 
.const [156] = Utf8 floor 
.const [157] = Utf8 (D)D 
.const [158] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviGetInfoCommand 
.const [159] = Utf8 service 
.const [160] = Utf8 Lde/audi/atip/interapp/NaviService; 
.const [161] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviGetInfoCommand 
.const [162] = Utf8 languageManager 
.const [163] = Utf8 Lde/audi/atip/i18n/ILanguageManager; 
.const [164] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [165] = Utf8 logger 
.const [166] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [167] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviGetInfoCommand 
.const [168] = Utf8 getName 
.const [169] = Utf8 ()Ljava/lang/String; 
.const [170] = Utf8 de/audi/atip/log/LogChannel 
.const [171] = Utf8 log 
.const [172] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [173] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviGetInfoCommand 
.const [174] = Utf8 sendResult 
.const [175] = Utf8 (I)V 
.const [176] = Utf8 de/audi/atip/log/LogChannel 
.const [177] = Utf8 log 
.const [178] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [179] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviGetInfoCommand 
.const [180] = Utf8 adjustDistance 
.const [181] = Utf8 (Lde/audi/atip/interapp/NaviService$NaviInfoDetails;)V 
.const [182] = Utf8 de/audi/atip/interapp/NaviService$NaviInfoDetails 
.const [183] = Utf8 city 
.const [184] = Utf8 Ljava/lang/String; 
.const [185] = Utf8 de/audi/atip/interapp/NaviService$NaviInfoDetails 
.const [186] = Utf8 street 
.const [187] = Utf8 Ljava/lang/String; 
.const [188] = Utf8 de/audi/atip/interapp/NaviService$NaviInfoDetails 
.const [189] = Utf8 houseNumber 
.const [190] = Utf8 Ljava/lang/String; 
.const [191] = Utf8 de/audi/atip/interapp/NaviService$NaviInfoDetails 
.const [192] = Utf8 country 
.const [193] = Utf8 Ljava/lang/String; 
.const [194] = Utf8 de/audi/atip/interapp/NaviService$NaviInfoDetails 
.const [195] = Utf8 distance 
.const [196] = Utf8 F 
.const [197] = Utf8 de/audi/atip/interapp/NaviService$NaviInfoDetails 
.const [198] = Utf8 poiName 
.const [199] = Utf8 Ljava/lang/String; 
.const [200] = Utf8 de/audi/atip/interapp/NaviService$NaviInfoDetails 
.const [201] = Utf8 distanceUnit 
.const [202] = Utf8 I 
.const [203] = Utf8 de/audi/atip/interapp/NaviService$NaviInfoDetails 
.const [204] = Utf8 time 
.const [205] = Utf8 Lde/audi/atip/metrics/DateMetric; 
.const [206] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviGetInfoCommand 
.const [207] = Utf8 adjustTime 
.const [208] = Utf8 (Lde/audi/atip/metrics/DateMetric;)Ljava/lang/String; 
.const [209] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [210] = Utf8 sdsHandlerService 
.const [211] = Utf8 Lde/audi/app/sdsmanager/apps/SDSHandlerService; 
.const [212] = Utf8 de/audi/atip/metrics/Distance 
.const [213] = Utf8 getValue 
.const [214] = Utf8 (I)F 
.const [215] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [216] = Utf8 <init> 
.const [217] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/sdsmanager/apps/SDSHandlerService;)V 
.const [218] = Utf8 de/audi/atip/metrics/Distance 
.const [219] = Utf8 <init> 
.const [220] = Utf8 (FI)V 
.const [221] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviGetInfoCommand 
.const [222] = Utf8 service 
.const [223] = Utf8 Lde/audi/atip/interapp/NaviService; 
.const [224] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviGetInfoCommand 
.const [225] = Utf8 languageManager 
.const [226] = Utf8 Lde/audi/atip/i18n/ILanguageManager; 
.const [227] = Utf8 de/audi/atip/interapp/NaviService 
.const [228] = Utf8 getNaviInfo 
.const [229] = Utf8 (Z)Lde/audi/atip/interapp/NaviService$NaviInfoDetails; 
.const [230] = Utf8 de/audi/atip/interapp/NaviService$NaviInfoDetails 
.const [231] = Utf8 distance 
.const [232] = Utf8 F 
.const [233] = Utf8 de/audi/atip/interapp/NaviService$NaviInfoDetails 
.const [234] = Utf8 distanceUnit 
.const [235] = Utf8 I 
.const [236] = Utf8 de/audi/app/sdsmanager/apps/SDSHandlerService 
.const [237] = Utf8 getFramework 
.const [238] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [239] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviGetInfoCommand 
.const [240] = Class [239] 
.const [241] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [242] = Class [241] 
.const [243] = Utf8 service 
.const [244] = Utf8 Lde/audi/atip/interapp/NaviService; 
.const [245] = Utf8 languageManager 
.const [246] = Utf8 Lde/audi/atip/i18n/ILanguageManager; 
.const [247] = Utf8 Code 
.const [248] = Utf8 <init> 
.const [249] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/sdsmanager/apps/SDSHandlerService;Lde/audi/atip/interapp/NaviService;Lde/audi/atip/i18n/ILanguageManager;)V 
.const [250] = Utf8 execute 
.const [251] = Utf8 ()V 
.const [252] = Utf8 adjustTime 
.const [253] = Utf8 (Lde/audi/atip/metrics/DateMetric;)Ljava/lang/String; 
.const [254] = Utf8 adjustDistance 
.const [255] = Utf8 (Lde/audi/atip/interapp/NaviService$NaviInfoDetails;)V 
.end class 
