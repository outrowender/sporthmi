.version 50 0 
.class public super [279] 
.super [281] 
.implements [283] 
.implements [285] 
.field private static final [286] [287] 
.field private static final [288] [289] 
.field private static final [290] [291] 
.field private static final [292] [293] 
.field private static final [294] [295] 
.field private final [296] [297] 
.field private final [298] [299] 
.field private final [300] [301] 
.field private [302] [303] 
.field private final [304] [305] 
.field private [306] [307] 

.method public [309] : [310] 
    .attribute [308] .code stack 8 locals 0 
L0:     aload_0 
L1:     invokespecial [52] 
L4:     aload_0 
L5:     aload_0 
L6:     invokespecial [53] 
L9:     invokestatic [2] 
L12:    putfield [57] 
L15:    aload_0 
L16:    aload_1 
L17:    putfield [58] 
L20:    aload_0 
L21:    aload_1 
L22:    invokevirtual [34] 
L25:    putfield [59] 
L28:    aload_0 
L29:    new [60] 
L32:    dup 
L33:    ldc [4] 
L35:    ldc_w [1] 
L38:    iconst_1 
L39:    aload_0 
L40:    invokespecial [54] 
L43:    putfield [61] 
L46:    aload_0 
L47:    iconst_1 
L48:    putfield [62] 
L51:    aload_0 
L52:    iconst_0 
L53:    putfield [63] 
L56:    return 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [311] : [312] 
    .attribute [308] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [35] 
L4:     ldc [5] 
L6:     ldc [6] 
L8:     aload_0 
L9:     getfield [32] 
L12:    iload_1 
L13:    invokestatic [7] 
L16:    invokevirtual [39] 
L19:    aload_0 
L20:    iload_1 
L21:    putfield [63] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public interface [313] : [314] 
    .attribute [308] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [315] : [316] 
    .attribute [308] .code stack 2 locals 3 
L0:     iload_1 
L1:     ifeq L8 
L4:     iconst_2 
L5:     goto L9 
L8:     iconst_1 
L9:     istore 4 
L11:    aload_0 
L12:    getfield [33] 
L15:    ldc [8] 
L17:    invokevirtual [40] 
L20:    iload 4 
L22:    invokeinterface [64] 0 
L27:    return 
L28:    
    .end code 
.end method 

.method public [317] : [318] 
    .attribute [308] .code stack 8 locals 1 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [55] 
L5:     istore_2 
L6:     aload_0 
L7:     getfield [35] 
L10:    ldc [9] 
L12:    new [65] 
L15:    dup 
L16:    invokespecial [56] 
L19:    aload_0 
L20:    getfield [32] 
L23:    invokevirtual [41] 
L26:    ldc [11] 
L28:    invokevirtual [41] 
L31:    invokevirtual [42] 
L34:    iload_1 
L35:    i2l 
L36:    iload_2 
L37:    i2l 
L38:    aload_0 
L39:    getfield [38] 
L42:    invokevirtual [43] 
L45:    aload_0 
L46:    getfield [38] 
L49:    ifeq L69 
L52:    aload_0 
L53:    getfield [35] 
L56:    ldc [5] 
L58:    ldc [12] 
L60:    aload_0 
L61:    getfield [32] 
L64:    invokevirtual [44] 
L67:    pop 
L68:    return 
L69:    aload_0 
L70:    getfield [33] 
L73:    ldc [13] 
L75:    invokevirtual [40] 
L78:    iload_2 
L79:    invokeinterface [64] 0 
L84:    aload_0 
L85:    iconst_0 
L86:    invokevirtual [45] 
L89:    aload_0 
L90:    getfield [33] 
L93:    invokevirtual [46] 
L96:    invokeinterface [66] 0 
L101:   iconst_0 
L102:   ldc [14] 
L104:   invokeinterface [67] 0 
L109:   return 
L110:   nop 
L111:   nop 
L112:   
    .end code 
.end method 

.method public [319] : [320] 
    .attribute [308] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [35] 
L4:     ldc [9] 
L6:     ldc [15] 
L8:     aload_0 
L9:     getfield [32] 
L12:    invokevirtual [44] 
L15:    pop 
L16:    aload_0 
L17:    getfield [33] 
L20:    invokevirtual [46] 
L23:    invokeinterface [66] 0 
L28:    iconst_0 
L29:    ldc [14] 
L31:    invokeinterface [68] 0 
L36:    return 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [321] : [322] 
    .attribute [308] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [36] 
L4:     invokevirtual [47] 
L7:     pop 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [323] : [324] 
    .attribute [308] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [62] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [325] : [326] 
    .attribute [308] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     ldc [16] 
L6:     invokevirtual [40] 
L9:     iload_1 
L10:    ifeq L17 
L13:    iconst_1 
L14:    goto L18 
L17:    iconst_0 
L18:    invokeinterface [64] 0 
L23:    return 
L24:    
    .end code 
.end method 

.method public [327] : [328] 
    .attribute [308] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [35] 
L4:     ldc [17] 
L6:     ldc [18] 
L8:     aload_0 
L9:     getfield [32] 
L12:    aload_1 
L13:    invokevirtual [39] 
L16:    aload_0 
L17:    getfield [37] 
L20:    ifne L30 
L23:    aload_0 
L24:    invokevirtual [48] 
L27:    goto L46 
L30:    aload_0 
L31:    getfield [35] 
L34:    ldc [17] 
L36:    ldc [19] 
L38:    aload_0 
L39:    getfield [32] 
L42:    invokevirtual [44] 
L45:    pop 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [329] : [330] 
    .attribute [308] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [35] 
L4:     ldc [17] 
L6:     ldc [20] 
L8:     aload_0 
L9:     getfield [32] 
L12:    aload_1 
L13:    invokevirtual [39] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [331] : [332] 
    .attribute [308] .code stack 4 locals 0 
L0:     iload_1 
L1:     ldc [14] 
L3:     if_icmpeq L7 
L6:     return 
L7:     aload_0 
L8:     getfield [35] 
L11:    ldc [5] 
L13:    ldc [21] 
L15:    aload_0 
L16:    getfield [32] 
L19:    invokevirtual [44] 
L22:    pop 
L23:    aload_0 
L24:    getfield [36] 
L27:    invokevirtual [49] 
L30:    ifeq L41 
L33:    aload_0 
L34:    getfield [36] 
L37:    invokevirtual [47] 
L40:    pop 
L41:    aload_0 
L42:    getfield [36] 
L45:    invokevirtual [50] 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public enum [333] : [334] 
    .attribute [308] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method private [335] : [336] 
    .attribute [308] .code stack 8 locals 1 
L0:     iconst_0 
L1:     istore_2 
L2:     iload_1 
L3:     sipush 135 
L6:     if_icmpne L14 
L9:     iconst_1 
L10:    istore_2 
L11:    goto L22 
L14:    iload_1 
L15:    bipush 121 
L17:    if_icmpne L22 
L20:    iconst_2 
L21:    istore_2 
L22:    aload_0 
L23:    getfield [35] 
L26:    ldc [5] 
L28:    ldc [22] 
L30:    aload_0 
L31:    getfield [32] 
L34:    iload_1 
L35:    i2l 
L36:    iload_2 
L37:    i2l 
L38:    invokevirtual [51] 
L41:    pop 
L42:    iload_2 
L43:    areturn 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [70] [71] 
.const [3] = Class [72] 
.const [4] = String [73] 
.const [5] = Int -2137614336 
.const [6] = String [74] 
.const [7] = Method [75] [76] 
.const [8] = Int -14940672 
.const [9] = Int -1601830656 
.const [10] = Class [77] 
.const [11] = String [78] 
.const [12] = String [79] 
.const [13] = Int -2028075520 
.const [14] = Int -417724928 
.const [15] = String [80] 
.const [16] = Int -233110016 
.const [17] = Int 1078071040 
.const [18] = String [81] 
.const [19] = String [82] 
.const [20] = String [83] 
.const [21] = String [84] 
.const [22] = String [85] 
.const [23] = Class [86] 
.const [24] = Class [87] 
.const [25] = Class [88] 
.const [26] = Class [89] 
.const [27] = Class [90] 
.const [28] = Class [91] 
.const [29] = Class [92] 
.const [30] = Class [93] 
.const [31] = Class [94] 
.const [32] = Field [95] [96] 
.const [33] = Field [97] [98] 
.const [34] = Method [99] [100] 
.const [35] = Field [101] [102] 
.const [36] = Field [103] [104] 
.const [37] = Field [105] [106] 
.const [38] = Field [107] [108] 
.const [39] = Method [109] [110] 
.const [40] = Method [111] [112] 
.const [41] = Method [113] [114] 
.const [42] = Method [115] [116] 
.const [43] = Method [117] [118] 
.const [44] = Method [119] [120] 
.const [45] = Method [121] [122] 
.const [46] = Method [123] [124] 
.const [47] = Method [125] [126] 
.const [48] = Method [127] [128] 
.const [49] = Method [129] [130] 
.const [50] = Method [131] [132] 
.const [51] = Method [133] [134] 
.const [52] = Method [135] [136] 
.const [53] = Method [137] [138] 
.const [54] = Method [139] [140] 
.const [55] = Method [141] [142] 
.const [56] = Method [143] [144] 
.const [57] = Field [145] [146] 
.const [58] = Field [147] [148] 
.const [59] = Field [149] [150] 
.const [60] = Class [151] 
.const [61] = Field [152] [153] 
.const [62] = Field [154] [155] 
.const [63] = Field [156] [157] 
.const [64] = InterfaceMethod [158] [159] 
.const [65] = Class [160] 
.const [66] = InterfaceMethod [161] [162] 
.const [67] = InterfaceMethod [163] [164] 
.const [68] = InterfaceMethod [165] [166] 
.const [69] = Int 812974080 
.const [70] = Class [167] 
.const [71] = NameAndType [168] [169] 
.const [72] = Utf8 de/audi/atip/timer/Timer 
.const [73] = Utf8 ClosePopupTimer 
.const [74] = Utf8 '%1#setFuelWarningActive - active=%2' 
.const [75] = Class [170] 
.const [76] = NameAndType [171] [172] 
.const [77] = Utf8 java/lang/StringBuffer 
.const [78] = Utf8 '#showPopUp() - poiCategory=%1; fuelTypeChoice=%2; fuelWarningPopupIsCurrentlyShown=%3' 
.const [79] = Utf8 '%1#showPopUp - fuel warning is active -> not showing popup.' 
.const [80] = Utf8 '%1#hidePopUp()' 
.const [81] = Utf8 '%1#fireTimer() - Timer: %2' 
.const [82] = Utf8 '%1#fireTimer() - Timer ignored! ' 
.const [83] = Utf8 '%1#cancelTimer() - Timer: %2' 
.const [84] = Utf8 '%1#popupVisible() ' 
.const [85] = Utf8 '%1#determineChoiceModel - poiCategory=%2; choiceModelVal=%3' 
.const [86] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningModelAccess 
.const [87] = Utf8 java/lang/Object 
.const [88] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [89] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [90] = Utf8 java/lang/Boolean 
.const [91] = Utf8 de/audi/atip/log/LogChannel 
.const [92] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [93] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [94] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [95] = Class [173] 
.const [96] = NameAndType [174] [175] 
.const [97] = Class [176] 
.const [98] = NameAndType [177] [178] 
.const [99] = Class [179] 
.const [100] = NameAndType [180] [181] 
.const [101] = Class [182] 
.const [102] = NameAndType [183] [184] 
.const [103] = Class [185] 
.const [104] = NameAndType [186] [187] 
.const [105] = Class [188] 
.const [106] = NameAndType [189] [190] 
.const [107] = Class [191] 
.const [108] = NameAndType [192] [193] 
.const [109] = Class [194] 
.const [110] = NameAndType [195] [196] 
.const [111] = Class [197] 
.const [112] = NameAndType [198] [199] 
.const [113] = Class [200] 
.const [114] = NameAndType [201] [202] 
.const [115] = Class [203] 
.const [116] = NameAndType [204] [205] 
.const [117] = Class [206] 
.const [118] = NameAndType [207] [208] 
.const [119] = Class [209] 
.const [120] = NameAndType [210] [211] 
.const [121] = Class [212] 
.const [122] = NameAndType [213] [214] 
.const [123] = Class [215] 
.const [124] = NameAndType [216] [217] 
.const [125] = Class [218] 
.const [126] = NameAndType [219] [220] 
.const [127] = Class [221] 
.const [128] = NameAndType [222] [223] 
.const [129] = Class [224] 
.const [130] = NameAndType [225] [226] 
.const [131] = Class [227] 
.const [132] = NameAndType [228] [229] 
.const [133] = Class [230] 
.const [134] = NameAndType [231] [232] 
.const [135] = Class [233] 
.const [136] = NameAndType [234] [235] 
.const [137] = Class [236] 
.const [138] = NameAndType [237] [238] 
.const [139] = Class [239] 
.const [140] = NameAndType [240] [241] 
.const [141] = Class [242] 
.const [142] = NameAndType [243] [244] 
.const [143] = Class [245] 
.const [144] = NameAndType [246] [247] 
.const [145] = Class [248] 
.const [146] = NameAndType [249] [250] 
.const [147] = Class [251] 
.const [148] = NameAndType [252] [253] 
.const [149] = Class [254] 
.const [150] = NameAndType [255] [256] 
.const [151] = Utf8 de/audi/atip/timer/Timer 
.const [152] = Class [257] 
.const [153] = NameAndType [258] [259] 
.const [154] = Class [260] 
.const [155] = NameAndType [261] [262] 
.const [156] = Class [263] 
.const [157] = NameAndType [264] [265] 
.const [158] = Class [266] 
.const [159] = NameAndType [267] [268] 
.const [160] = Utf8 java/lang/StringBuffer 
.const [161] = Class [269] 
.const [162] = NameAndType [270] [271] 
.const [163] = Class [272] 
.const [164] = NameAndType [273] [274] 
.const [165] = Class [275] 
.const [166] = NameAndType [276] [277] 
.const [167] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [168] = Utf8 getClassNameFromPackageName 
.const [169] = Utf8 (Ljava/lang/Class;)Ljava/lang/String; 
.const [170] = Utf8 java/lang/Boolean 
.const [171] = Utf8 valueOf 
.const [172] = Utf8 (Z)Ljava/lang/Boolean; 
.const [173] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningModelAccess 
.const [174] = Utf8 CLASS_NAME 
.const [175] = Utf8 Ljava/lang/String; 
.const [176] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningModelAccess 
.const [177] = Utf8 env 
.const [178] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [179] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [180] = Utf8 getLogChannel 
.const [181] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [182] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningModelAccess 
.const [183] = Utf8 logger 
.const [184] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [185] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningModelAccess 
.const [186] = Utf8 closePopupTimer 
.const [187] = Utf8 Lde/audi/atip/timer/Timer; 
.const [188] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningModelAccess 
.const [189] = Utf8 ignoreFireTimer 
.const [190] = Utf8 Z 
.const [191] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningModelAccess 
.const [192] = Utf8 fuelWarningPopupIsCurrentlyShown 
.const [193] = Utf8 Z 
.const [194] = Utf8 de/audi/atip/log/LogChannel 
.const [195] = Utf8 log 
.const [196] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [197] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [198] = Utf8 getChoiceModel 
.const [199] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [200] = Utf8 java/lang/StringBuffer 
.const [201] = Utf8 append 
.const [202] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [203] = Utf8 java/lang/StringBuffer 
.const [204] = Utf8 toString 
.const [205] = Utf8 ()Ljava/lang/String; 
.const [206] = Utf8 de/audi/atip/log/LogChannel 
.const [207] = Utf8 log 
.const [208] = Utf8 (ILjava/lang/String;JJZ)V 
.const [209] = Utf8 de/audi/atip/log/LogChannel 
.const [210] = Utf8 log 
.const [211] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [212] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningModelAccess 
.const [213] = Utf8 setIgnoreCloseTimer 
.const [214] = Utf8 (Z)V 
.const [215] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [216] = Utf8 getFramework 
.const [217] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [218] = Utf8 de/audi/atip/timer/Timer 
.const [219] = Utf8 cancel 
.const [220] = Utf8 ()Z 
.const [221] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningModelAccess 
.const [222] = Utf8 hidePopUp 
.const [223] = Utf8 ()V 
.const [224] = Utf8 de/audi/atip/timer/Timer 
.const [225] = Utf8 isRunning 
.const [226] = Utf8 ()Z 
.const [227] = Utf8 de/audi/atip/timer/Timer 
.const [228] = Utf8 restart 
.const [229] = Utf8 ()V 
.const [230] = Utf8 de/audi/atip/log/LogChannel 
.const [231] = Utf8 log 
.const [232] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [233] = Utf8 java/lang/Object 
.const [234] = Utf8 <init> 
.const [235] = Utf8 ()V 
.const [236] = Utf8 java/lang/Object 
.const [237] = Utf8 getClass 
.const [238] = Utf8 ()Ljava/lang/Class; 
.const [239] = Utf8 de/audi/atip/timer/Timer 
.const [240] = Utf8 <init> 
.const [241] = Utf8 (Ljava/lang/String;JZLde/audi/atip/timer/TimerListener;)V 
.const [242] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningModelAccess 
.const [243] = Utf8 determineChoiceModel 
.const [244] = Utf8 (I)I 
.const [245] = Utf8 java/lang/StringBuffer 
.const [246] = Utf8 <init> 
.const [247] = Utf8 ()V 
.const [248] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningModelAccess 
.const [249] = Utf8 CLASS_NAME 
.const [250] = Utf8 Ljava/lang/String; 
.const [251] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningModelAccess 
.const [252] = Utf8 env 
.const [253] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [254] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningModelAccess 
.const [255] = Utf8 logger 
.const [256] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [257] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningModelAccess 
.const [258] = Utf8 closePopupTimer 
.const [259] = Utf8 Lde/audi/atip/timer/Timer; 
.const [260] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningModelAccess 
.const [261] = Utf8 ignoreFireTimer 
.const [262] = Utf8 Z 
.const [263] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningModelAccess 
.const [264] = Utf8 fuelWarningPopupIsCurrentlyShown 
.const [265] = Utf8 Z 
.const [266] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [267] = Utf8 setValue 
.const [268] = Utf8 (I)V 
.const [269] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [270] = Utf8 getHmiServiceApp 
.const [271] = Utf8 ()Lde/audi/atip/hmi/IHMIServiceApp; 
.const [272] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [273] = Utf8 showPartialPopup 
.const [274] = Utf8 (II)V 
.const [275] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [276] = Utf8 removePartialPopup 
.const [277] = Utf8 (II)V 
.const [278] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningModelAccess 
.const [279] = Class [278] 
.const [280] = Utf8 java/lang/Object 
.const [281] = Class [280] 
.const [282] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/IFuelWarningModelAccess 
.const [283] = Class [282] 
.const [284] = Utf8 de/audi/atip/timer/TimerListener 
.const [285] = Class [284] 
.const [286] = Utf8 CLOSE_DELAY 
.const [287] = Utf8 J 
.const [288] = Utf8 FUEL_TYPE_CHOICE_MODEL_DEFAULT 
.const [289] = Utf8 I 
.const [290] = Utf8 FUEL_TYPE_CHOICE_MODEL_CNG 
.const [291] = Utf8 I 
.const [292] = Utf8 FUEL_TYPE_CHOICE_MODEL_DIESEL 
.const [293] = Utf8 I 
.const [294] = Utf8 terminalId 
.const [295] = Utf8 I 
.const [296] = Utf8 CLASS_NAME 
.const [297] = Utf8 Ljava/lang/String; 
.const [298] = Utf8 logger 
.const [299] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [300] = Utf8 closePopupTimer 
.const [301] = Utf8 Lde/audi/atip/timer/Timer; 
.const [302] = Utf8 ignoreFireTimer 
.const [303] = Utf8 Z 
.const [304] = Utf8 env 
.const [305] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [306] = Utf8 fuelWarningPopupIsCurrentlyShown 
.const [307] = Utf8 Z 
.const [308] = Utf8 Code 
.const [309] = Utf8 <init> 
.const [310] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;)V 
.const [311] = Utf8 setFuelWarningActive 
.const [312] = Utf8 (Z)V 
.const [313] = Utf8 isFuelWarningActive 
.const [314] = Utf8 ()Z 
.const [315] = Utf8 onStartSequence 
.const [316] = Utf8 (Z)V 
.const [317] = Utf8 showPopUp 
.const [318] = Utf8 (I)V 
.const [319] = Utf8 hidePopUp 
.const [320] = Utf8 ()V 
.const [321] = Utf8 cleanup 
.const [322] = Utf8 ()V 
.const [323] = Utf8 setIgnoreCloseTimer 
.const [324] = Utf8 (Z)V 
.const [325] = Utf8 setFuelWarningChoiceModel 
.const [326] = Utf8 (Z)V 
.const [327] = Utf8 fireTimer 
.const [328] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.const [329] = Utf8 cancelTimer 
.const [330] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.const [331] = Utf8 popupVisible 
.const [332] = Utf8 (II)V 
.const [333] = Utf8 popupHidden 
.const [334] = Utf8 (II)V 
.const [335] = Utf8 determineChoiceModel 
.const [336] = Utf8 (I)I 
.end class 
