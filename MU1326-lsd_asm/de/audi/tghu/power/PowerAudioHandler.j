.version 50 0 
.class final super [218] 
.super [220] 
.implements [222] 
.field private final [223] [224] 
.field private final [225] [226] 
.field private static final [227] [228] 
.field private [229] [230] 
.field private volatile [231] [232] 

.method [234] : [235] 
    .attribute [233] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [49] 
L4:     aload_0 
L5:     iconst_1 
L6:     putfield [52] 
L9:     aload_0 
L10:    aload_1 
L11:    putfield [53] 
L14:    aload_0 
L15:    aload_1 
L16:    invokevirtual [36] 
L19:    ldc [2] 
L21:    invokeinterface [54] 0 
L26:    putfield [55] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [236] : [237] 
    .attribute [233] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     ldc [5] 
L10:    invokevirtual [38] 
L13:    pop 
L14:    aload_0 
L15:    iconst_0 
L16:    putfield [52] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [238] : [239] 
    .attribute [233] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     ldc [3] 
L6:     ldc [6] 
L8:     ldc [5] 
L10:    aload_1 
L11:    invokevirtual [39] 
L14:    aload_0 
L15:    aload_1 
L16:    putfield [56] 
L19:    return 
L20:    
    .end code 
.end method 

.method private [240] : [241] 
    .attribute [233] .code stack 1 locals 1 
L0:     iconst_3 
L1:     istore_2 
L2:     iload_1 
L3:     lookupswitch 
            3 : L28 
            4 : L33 
            default : L38 

L28:    iconst_3 
L29:    istore_2 
L30:    goto L40 
L33:    iconst_3 
L34:    istore_2 
L35:    goto L40 
L38:    iconst_3 
L39:    istore_2 
L40:    iload_2 
L41:    areturn 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [242] : [243] 
    .attribute [233] .code stack 8 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     ldc [3] 
L6:     ldc [7] 
L8:     ldc [5] 
L10:    iload_1 
L11:    i2l 
L12:    invokevirtual [41] 
L15:    pop 
L16:    aload_0 
L17:    getfield [40] 
L20:    ifnull L60 
L23:    aload_0 
L24:    getfield [37] 
L27:    ldc [3] 
L29:    ldc [8] 
L31:    ldc [5] 
L33:    aload_0 
L34:    iload_1 
L35:    invokespecial [50] 
L38:    i2l 
L39:    iload_1 
L40:    i2l 
L41:    invokevirtual [42] 
L44:    pop 
L45:    aload_0 
L46:    getfield [40] 
L49:    aload_0 
L50:    iload_1 
L51:    invokespecial [50] 
L54:    iload_1 
L55:    invokeinterface [57] 0 
L60:    return 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [244] : [245] 
    .attribute [233] .code stack 8 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     ldc [3] 
L6:     ldc [9] 
L8:     ldc [5] 
L10:    iload_1 
L11:    i2l 
L12:    invokevirtual [41] 
L15:    pop 
L16:    aload_0 
L17:    getfield [34] 
L20:    ifeq L38 
L23:    aload_0 
L24:    getfield [37] 
L27:    ldc [3] 
L29:    ldc [10] 
L31:    ldc [5] 
L33:    invokevirtual [38] 
L36:    pop 
L37:    return 
L38:    aload_0 
L39:    getfield [40] 
L42:    ifnull L82 
L45:    aload_0 
L46:    getfield [37] 
L49:    ldc [3] 
L51:    ldc [11] 
L53:    ldc [5] 
L55:    aload_0 
L56:    iload_1 
L57:    invokespecial [50] 
L60:    i2l 
L61:    iload_1 
L62:    i2l 
L63:    invokevirtual [42] 
L66:    pop 
L67:    aload_0 
L68:    getfield [40] 
L71:    aload_0 
L72:    iload_1 
L73:    invokespecial [50] 
L76:    iload_1 
L77:    invokeinterface [58] 0 
L82:    return 
L83:    nop 
L84:    
    .end code 
.end method 

.method public [246] : [247] 
    .attribute [233] .code stack 5 locals 1 
L0:     new [59] 
L3:     dup 
L4:     invokespecial [51] 
L7:     ldc [13] 
L9:     invokevirtual [43] 
L12:    iload_1 
L13:    invokevirtual [44] 
L16:    ldc [14] 
L18:    invokevirtual [43] 
L21:    iload_2 
L22:    invokevirtual [44] 
L25:    ldc [15] 
L27:    invokevirtual [43] 
L30:    iload_3 
L31:    invokevirtual [44] 
L34:    invokevirtual [45] 
L37:    astore 4 
L39:    aload_0 
L40:    getfield [37] 
L43:    sipush 10000 
L46:    ldc [16] 
L48:    ldc [5] 
L50:    aload 4 
L52:    invokevirtual [39] 
L55:    return 
L56:    
    .end code 
.end method 

.method public [248] : [249] 
    .attribute [233] .code stack 8 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     ldc [3] 
L6:     ldc [17] 
L8:     ldc [5] 
L10:    iload_1 
L11:    i2l 
L12:    iload_2 
L13:    i2l 
L14:    invokevirtual [42] 
L17:    pop 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [250] : [251] 
    .attribute [233] .code stack 8 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     ldc [3] 
L6:     ldc [18] 
L8:     ldc [5] 
L10:    iload_1 
L11:    i2l 
L12:    iload_2 
L13:    i2l 
L14:    invokevirtual [42] 
L17:    pop 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [252] : [253] 
    .attribute [233] .code stack 8 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     ldc [3] 
L6:     ldc [19] 
L8:     ldc [5] 
L10:    iload_1 
L11:    i2l 
L12:    iload_2 
L13:    i2l 
L14:    invokevirtual [42] 
L17:    pop 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [254] : [255] 
    .attribute [233] .code stack 8 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     ldc [3] 
L6:     ldc [20] 
L8:     ldc [5] 
L10:    iload_1 
L11:    i2l 
L12:    iload_2 
L13:    i2l 
L14:    invokevirtual [42] 
L17:    pop 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [256] : [257] 
    .attribute [233] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     ldc [3] 
L6:     ldc [21] 
L8:     ldc [5] 
L10:    iload_1 
L11:    ifeq L19 
L14:    ldc [22] 
L16:    goto L21 
L19:    ldc [23] 
L21:    invokevirtual [39] 
L24:    iload_1 
L25:    ifeq L38 
L28:    aload_0 
L29:    getfield [35] 
L32:    invokevirtual [46] 
L35:    invokevirtual [47] 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [258] : [259] 
    .attribute [233] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     ldc [3] 
L6:     ldc [24] 
L8:     ldc [5] 
L10:    invokevirtual [38] 
L13:    pop 
L14:    aload_0 
L15:    getfield [40] 
L18:    ifnonnull L37 
L21:    aload_0 
L22:    getfield [37] 
L25:    sipush 10000 
L28:    ldc [25] 
L30:    ldc [5] 
L32:    invokevirtual [38] 
L35:    pop 
L36:    return 
L37:    aload_0 
L38:    getfield [35] 
L41:    getfield [48] 
L44:    ifeq L61 
L47:    aload_0 
L48:    getfield [40] 
L51:    iconst_3 
L52:    iconst_0 
L53:    invokeinterface [57] 0 
L58:    goto L83 
L61:    aload_0 
L62:    getfield [40] 
L65:    iconst_3 
L66:    iconst_3 
L67:    invokeinterface [57] 0 
L72:    aload_0 
L73:    getfield [40] 
L76:    iconst_3 
L77:    iconst_4 
L78:    invokeinterface [57] 0 
L83:    return 
L84:    
    .end code 
.end method 

.method public [260] : [261] 
    .attribute [233] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     ldc [3] 
L6:     ldc [26] 
L8:     ldc [5] 
L10:    iload_3 
L11:    ifeq L19 
L14:    ldc [22] 
L16:    goto L21 
L19:    ldc [23] 
L21:    invokevirtual [39] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [60] 
.const [3] = Int -2137614336 
.const [4] = String [61] 
.const [5] = String [62] 
.const [6] = String [63] 
.const [7] = String [64] 
.const [8] = String [65] 
.const [9] = String [66] 
.const [10] = String [67] 
.const [11] = String [68] 
.const [12] = Class [69] 
.const [13] = String [70] 
.const [14] = String [71] 
.const [15] = String [72] 
.const [16] = String [73] 
.const [17] = String [74] 
.const [18] = String [75] 
.const [19] = String [76] 
.const [20] = String [77] 
.const [21] = String [78] 
.const [22] = String [79] 
.const [23] = String [80] 
.const [24] = String [81] 
.const [25] = String [82] 
.const [26] = String [83] 
.const [27] = Class [84] 
.const [28] = Class [85] 
.const [29] = Class [86] 
.const [30] = Class [87] 
.const [31] = Class [88] 
.const [32] = Class [89] 
.const [33] = Class [90] 
.const [34] = Field [91] [92] 
.const [35] = Field [93] [94] 
.const [36] = Method [95] [96] 
.const [37] = Field [97] [98] 
.const [38] = Method [99] [100] 
.const [39] = Method [101] [102] 
.const [40] = Field [103] [104] 
.const [41] = Method [105] [106] 
.const [42] = Method [107] [108] 
.const [43] = Method [109] [110] 
.const [44] = Method [111] [112] 
.const [45] = Method [113] [114] 
.const [46] = Method [115] [116] 
.const [47] = Method [117] [118] 
.const [48] = Field [119] [120] 
.const [49] = Method [121] [122] 
.const [50] = Method [123] [124] 
.const [51] = Method [125] [126] 
.const [52] = Field [127] [128] 
.const [53] = Field [129] [130] 
.const [54] = InterfaceMethod [131] [132] 
.const [55] = Field [133] [134] 
.const [56] = Field [135] [136] 
.const [57] = InterfaceMethod [137] [138] 
.const [58] = InterfaceMethod [139] [140] 
.const [59] = Class [141] 
.const [60] = Utf8 'Fw.Power.Audio' 
.const [61] = Utf8 '[%1.enableAudioHandling]' 
.const [62] = Utf8 PowerAudioHandler 
.const [63] = Utf8 '[%1.setAudioDeviceService] audioService:%2' 
.const [64] = Utf8 '[%1.mute] HT:%2' 
.const [65] = Utf8 '[%1.requestConnection] AC:%2, HT:%3' 
.const [66] = Utf8 '[%1.demute] HT:%2' 
.const [67] = Utf8 '[%1.demute] Request mute connection if the first screen is not yet available.' 
.const [68] = Utf8 '[%1.releaseConnection] AC:%2, HT:%3' 
.const [69] = Utf8 java/lang/StringBuffer 
.const [70] = Utf8 'AC:' 
.const [71] = Utf8 ', HT:' 
.const [72] = Utf8 ', errorCode:' 
.const [73] = Utf8 '[%1.errorConnection] %2' 
.const [74] = Utf8 '[%1.fadeIn] AC:%2, HT:%3' 
.const [75] = Utf8 '[%1.pauseConnection] AC:%2, HT:%3' 
.const [76] = Utf8 '[%1.startConnection] AC:%2, HT:%3' 
.const [77] = Utf8 '[%1.stopConnection] AC:%2, HT:%3' 
.const [78] = Utf8 '[%1.updateAMAvailable] available:%2' 
.const [79] = Utf8 true 
.const [80] = Utf8 false 
.const [81] = Utf8 '[%1.updateAMAvailableFromFSMStandby] request MUTE_STANDBY' 
.const [82] = Utf8 '[%1.updateAMAvailableFromFSMStandby] dsiAudio == null' 
.const [83] = Utf8 '[%1.updateVolumeLock] VL:%3' 
.const [84] = Utf8 de/audi/tghu/power/PowerAudioHandler 
.const [85] = Utf8 java/lang/Object 
.const [86] = Utf8 de/audi/tghu/power/PowerManager 
.const [87] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [88] = Utf8 de/audi/atip/log/LogChannel 
.const [89] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [90] = Utf8 de/audi/tghu/power/PowerCommandFactory 
.const [91] = Class [142] 
.const [92] = NameAndType [143] [144] 
.const [93] = Class [145] 
.const [94] = NameAndType [146] [147] 
.const [95] = Class [148] 
.const [96] = NameAndType [149] [150] 
.const [97] = Class [151] 
.const [98] = NameAndType [152] [153] 
.const [99] = Class [154] 
.const [100] = NameAndType [155] [156] 
.const [101] = Class [157] 
.const [102] = NameAndType [158] [159] 
.const [103] = Class [160] 
.const [104] = NameAndType [161] [162] 
.const [105] = Class [163] 
.const [106] = NameAndType [164] [165] 
.const [107] = Class [166] 
.const [108] = NameAndType [167] [168] 
.const [109] = Class [169] 
.const [110] = NameAndType [170] [171] 
.const [111] = Class [172] 
.const [112] = NameAndType [173] [174] 
.const [113] = Class [175] 
.const [114] = NameAndType [176] [177] 
.const [115] = Class [178] 
.const [116] = NameAndType [179] [180] 
.const [117] = Class [181] 
.const [118] = NameAndType [182] [183] 
.const [119] = Class [184] 
.const [120] = NameAndType [185] [186] 
.const [121] = Class [187] 
.const [122] = NameAndType [188] [189] 
.const [123] = Class [190] 
.const [124] = NameAndType [191] [192] 
.const [125] = Class [193] 
.const [126] = NameAndType [194] [195] 
.const [127] = Class [196] 
.const [128] = NameAndType [197] [198] 
.const [129] = Class [199] 
.const [130] = NameAndType [200] [201] 
.const [131] = Class [202] 
.const [132] = NameAndType [203] [204] 
.const [133] = Class [205] 
.const [134] = NameAndType [206] [207] 
.const [135] = Class [208] 
.const [136] = NameAndType [209] [210] 
.const [137] = Class [211] 
.const [138] = NameAndType [212] [213] 
.const [139] = Class [214] 
.const [140] = NameAndType [215] [216] 
.const [141] = Utf8 java/lang/StringBuffer 
.const [142] = Utf8 de/audi/tghu/power/PowerAudioHandler 
.const [143] = Utf8 muteTillFirstScreen 
.const [144] = Utf8 Z 
.const [145] = Utf8 de/audi/tghu/power/PowerAudioHandler 
.const [146] = Utf8 powerManager 
.const [147] = Utf8 Lde/audi/tghu/power/PowerManager; 
.const [148] = Utf8 de/audi/tghu/power/PowerManager 
.const [149] = Utf8 getFramework 
.const [150] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [151] = Utf8 de/audi/tghu/power/PowerAudioHandler 
.const [152] = Utf8 lc 
.const [153] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [154] = Utf8 de/audi/atip/log/LogChannel 
.const [155] = Utf8 log 
.const [156] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [157] = Utf8 de/audi/atip/log/LogChannel 
.const [158] = Utf8 log 
.const [159] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [160] = Utf8 de/audi/tghu/power/PowerAudioHandler 
.const [161] = Utf8 dsiAudio 
.const [162] = Utf8 Lde/audi/atip/audio/HMIAudioService; 
.const [163] = Utf8 de/audi/atip/log/LogChannel 
.const [164] = Utf8 log 
.const [165] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [166] = Utf8 de/audi/atip/log/LogChannel 
.const [167] = Utf8 log 
.const [168] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [169] = Utf8 java/lang/StringBuffer 
.const [170] = Utf8 append 
.const [171] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [172] = Utf8 java/lang/StringBuffer 
.const [173] = Utf8 append 
.const [174] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [175] = Utf8 java/lang/StringBuffer 
.const [176] = Utf8 toString 
.const [177] = Utf8 ()Ljava/lang/String; 
.const [178] = Utf8 de/audi/tghu/power/PowerManager 
.const [179] = Utf8 getPwrCmdFactory 
.const [180] = Utf8 ()Lde/audi/tghu/power/PowerCommandFactory; 
.const [181] = Utf8 de/audi/tghu/power/PowerCommandFactory 
.const [182] = Utf8 setAMAvailableCmd 
.const [183] = Utf8 ()V 
.const [184] = Utf8 de/audi/tghu/power/PowerManager 
.const [185] = Utf8 IS_FRONT_MU 
.const [186] = Utf8 Z 
.const [187] = Utf8 java/lang/Object 
.const [188] = Utf8 <init> 
.const [189] = Utf8 ()V 
.const [190] = Utf8 de/audi/tghu/power/PowerAudioHandler 
.const [191] = Utf8 getMuteConnectionByTerminal 
.const [192] = Utf8 (I)I 
.const [193] = Utf8 java/lang/StringBuffer 
.const [194] = Utf8 <init> 
.const [195] = Utf8 ()V 
.const [196] = Utf8 de/audi/tghu/power/PowerAudioHandler 
.const [197] = Utf8 muteTillFirstScreen 
.const [198] = Utf8 Z 
.const [199] = Utf8 de/audi/tghu/power/PowerAudioHandler 
.const [200] = Utf8 powerManager 
.const [201] = Utf8 Lde/audi/tghu/power/PowerManager; 
.const [202] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [203] = Utf8 getLogChannel 
.const [204] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [205] = Utf8 de/audi/tghu/power/PowerAudioHandler 
.const [206] = Utf8 lc 
.const [207] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [208] = Utf8 de/audi/tghu/power/PowerAudioHandler 
.const [209] = Utf8 dsiAudio 
.const [210] = Utf8 Lde/audi/atip/audio/HMIAudioService; 
.const [211] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [212] = Utf8 requestConnection 
.const [213] = Utf8 (II)V 
.const [214] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [215] = Utf8 releaseConnection 
.const [216] = Utf8 (II)V 
.const [217] = Utf8 de/audi/tghu/power/PowerAudioHandler 
.const [218] = Class [217] 
.const [219] = Utf8 java/lang/Object 
.const [220] = Class [219] 
.const [221] = Utf8 de/audi/atip/audio/HMIAudioServiceListener 
.const [222] = Class [221] 
.const [223] = Utf8 powerManager 
.const [224] = Utf8 Lde/audi/tghu/power/PowerManager; 
.const [225] = Utf8 lc 
.const [226] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [227] = Utf8 LOGCLASS 
.const [228] = Utf8 Ljava/lang/String; 
.const [229] = Utf8 muteTillFirstScreen 
.const [230] = Utf8 Z 
.const [231] = Utf8 dsiAudio 
.const [232] = Utf8 Lde/audi/atip/audio/HMIAudioService; 
.const [233] = Utf8 Code 
.const [234] = Utf8 <init> 
.const [235] = Utf8 (Lde/audi/tghu/power/PowerManager;)V 
.const [236] = Utf8 enableAudioHandling 
.const [237] = Utf8 ()V 
.const [238] = Utf8 setAudioDeviceService 
.const [239] = Utf8 (Lde/audi/atip/audio/HMIAudioService;)V 
.const [240] = Utf8 getMuteConnectionByTerminal 
.const [241] = Utf8 (I)I 
.const [242] = Utf8 mute 
.const [243] = Utf8 (I)V 
.const [244] = Utf8 demute 
.const [245] = Utf8 (I)V 
.const [246] = Utf8 errorConnection 
.const [247] = Utf8 (III)V 
.const [248] = Utf8 fadedIn 
.const [249] = Utf8 (II)V 
.const [250] = Utf8 pauseConnection 
.const [251] = Utf8 (II)V 
.const [252] = Utf8 startConnection 
.const [253] = Utf8 (II)V 
.const [254] = Utf8 stopConnection 
.const [255] = Utf8 (II)V 
.const [256] = Utf8 updateAMAvailable 
.const [257] = Utf8 (Z)V 
.const [258] = Utf8 updateAMAvailableFromFSMStandby 
.const [259] = Utf8 ()V 
.const [260] = Utf8 updateVolumeLock 
.const [261] = Utf8 (IIZ)V 
.end class 
