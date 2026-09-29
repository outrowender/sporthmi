.version 50 0 
.class public super [349] 
.super [351] 
.implements [353] 
.implements [355] 
.field public static final [356] [357] 
.field public static final [358] [359] 
.field private final [360] [361] 
.field private final [362] [363] 
.field private final [364] [365] 
.field private final [366] [367] 
.field private volatile [368] [369] 
.field private volatile [370] [371] 

.method public [373] : [374] 
    .attribute [372] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_2 
L2:     invokeinterface [62] 0 
L7:     invokeinterface [63] 0 
L12:    aload_1 
L13:    iload 4 
L15:    aload_2 
L16:    invokeinterface [64] 0 
L21:    invokestatic [2] 
L24:    aload_2 
L25:    invokespecial [57] 
L28:    aload_0 
L29:    aload_2 
L30:    invokeinterface [64] 0 
L35:    putfield [65] 
L38:    aload_0 
L39:    aload_1 
L40:    putfield [66] 
L43:    aload_0 
L44:    iload_3 
L45:    putfield [67] 
L48:    aload_0 
L49:    iload 4 
L51:    putfield [68] 
L54:    return 
L55:    nop 
L56:    
    .end code 
.end method 

.method private static [375] : [376] 
    .attribute [372] .code stack 2 locals 0 
L0:     new [69] 
L3:     dup 
L4:     invokespecial [58] 
L7:     ldc [4] 
L9:     invokevirtual [38] 
L12:    aload_0 
L13:    invokevirtual [39] 
L16:    invokevirtual [38] 
L19:    ldc [5] 
L21:    invokevirtual [38] 
L24:    ldc [6] 
L26:    invokevirtual [38] 
L29:    iload_1 
L30:    invokevirtual [40] 
L33:    ldc [5] 
L35:    invokevirtual [38] 
L38:    invokevirtual [41] 
L41:    areturn 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [377] : [378] 
    .attribute [372] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [42] 
L4:     ldc [7] 
L6:     ldc [8] 
L8:     aload_0 
L9:     invokevirtual [43] 
L12:    invokevirtual [44] 
L15:    pop 
L16:    aload_0 
L17:    getfield [34] 
L20:    invokeinterface [70] 0 
L25:    ifeq L73 
L28:    aload_0 
L29:    getfield [34] 
L32:    aload_0 
L33:    invokeinterface [71] 0 
L38:    aload_0 
L39:    iconst_1 
L40:    putfield [72] 
L43:    aload_0 
L44:    getfield [34] 
L47:    aload_0 
L48:    invokeinterface [73] 0 
L53:    aload_0 
L54:    getfield [34] 
L57:    aload_0 
L58:    getfield [35] 
L61:    aload_0 
L62:    getfield [36] 
L65:    invokeinterface [74] 0 
L70:    goto L99 
L73:    aload_0 
L74:    getfield [34] 
L77:    aload_0 
L78:    getfield [35] 
L81:    aload_0 
L82:    getfield [36] 
L85:    invokeinterface [74] 0 
L90:    aload_0 
L91:    invokevirtual [46] 
L94:    invokeinterface [75] 0 
L99:    return 
L100:   
    .end code 
.end method 

.method public [379] : [380] 
    .attribute [372] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [35] 
L4:     aload_1 
L5:     invokevirtual [47] 
L8:     invokevirtual [48] 
L11:    ifeq L15 
L14:    return 
L15:    aload_0 
L16:    aload_1 
L17:    invokevirtual [49] 
L20:    ifne L36 
L23:    aload_1 
L24:    invokevirtual [50] 
L27:    getstatic [9] 
L30:    invokevirtual [51] 
L33:    ifeq L40 
L36:    iconst_1 
L37:    goto L41 
L40:    iconst_0 
L41:    putfield [76] 
L44:    aload_0 
L45:    getfield [42] 
L48:    ldc [7] 
L50:    ldc [10] 
L52:    aload_0 
L53:    invokevirtual [43] 
L56:    aload_1 
L57:    invokevirtual [50] 
L60:    invokestatic [11] 
L63:    aload_0 
L64:    getfield [52] 
L67:    ifeq L75 
L70:    ldc [12] 
L72:    goto L77 
L75:    ldc [13] 
L77:    aload_0 
L78:    getfield [45] 
L81:    ifeq L89 
L84:    ldc [14] 
L86:    goto L91 
L89:    ldc [15] 
L91:    invokevirtual [53] 
L94:    aload_0 
L95:    getfield [52] 
L98:    ifeq L112 
L101:   aload_0 
L102:   getfield [45] 
L105:   ifeq L112 
L108:   aload_0 
L109:   invokespecial [59] 
L112:   aload_1 
L113:   invokevirtual [50] 
L116:   getstatic [16] 
L119:   invokevirtual [51] 
L122:   ifeq L149 
L125:   aload_0 
L126:   getfield [42] 
L129:   sipush 10000 
L132:   ldc [17] 
L134:   aload_0 
L135:   invokevirtual [43] 
L138:   aload_1 
L139:   invokevirtual [47] 
L142:   invokevirtual [54] 
L145:   aload_0 
L146:   invokespecial [59] 
L149:   return 
L150:   nop 
L151:   nop 
L152:   
    .end code 
.end method 

.method public [381] : [382] 
    .attribute [372] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [42] 
L4:     ldc [7] 
L6:     ldc [18] 
L8:     aload_0 
L9:     invokevirtual [43] 
L12:    invokevirtual [44] 
L15:    pop 
L16:    aload_0 
L17:    iconst_0 
L18:    putfield [72] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [383] : [384] 
    .attribute [372] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [42] 
L4:     ldc [7] 
L6:     ldc [19] 
L8:     aload_0 
L9:     invokevirtual [43] 
L12:    invokevirtual [44] 
L15:    pop 
L16:    aload_0 
L17:    iconst_1 
L18:    putfield [72] 
L21:    aload_0 
L22:    getfield [52] 
L25:    ifeq L39 
L28:    aload_0 
L29:    getfield [45] 
L32:    ifeq L39 
L35:    aload_0 
L36:    invokespecial [59] 
L39:    return 
L40:    
    .end code 
.end method 

.method private [385] : [386] 
    .attribute [372] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [60] 
L4:     aload_0 
L5:     getfield [55] 
L8:     invokeinterface [75] 0 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public enum [387] : [388] 
    .attribute [372] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [389] : [390] 
    .attribute [372] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     i2l 
L5:     freturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [391] : [392] 
    .attribute [372] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [42] 
L4:     ldc [20] 
L6:     ldc [21] 
L8:     invokevirtual [56] 
L11:    pop 
L12:    aload_0 
L13:    invokespecial [60] 
L16:    new [77] 
L19:    dup 
L20:    aload_0 
L21:    aload_0 
L22:    getfield [42] 
L25:    invokespecial [61] 
L28:    areturn 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method private [393] : [394] 
    .attribute [372] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     aload_0 
L5:     invokeinterface [78] 0 
L10:    aload_0 
L11:    getfield [34] 
L14:    aload_0 
L15:    invokeinterface [79] 0 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [80] [81] 
.const [3] = Class [82] 
.const [4] = String [83] 
.const [5] = String [84] 
.const [6] = String [85] 
.const [7] = Int 1078071040 
.const [8] = String [86] 
.const [9] = Field [87] [88] 
.const [10] = String [89] 
.const [11] = Method [90] [91] 
.const [12] = String [92] 
.const [13] = String [93] 
.const [14] = String [94] 
.const [15] = String [95] 
.const [16] = Field [96] [97] 
.const [17] = String [98] 
.const [18] = String [99] 
.const [19] = String [100] 
.const [20] = Int -1601830656 
.const [21] = String [101] 
.const [22] = Class [102] 
.const [23] = Class [103] 
.const [24] = Class [104] 
.const [25] = Class [105] 
.const [26] = Class [106] 
.const [27] = Class [107] 
.const [28] = Class [108] 
.const [29] = Class [109] 
.const [30] = Class [110] 
.const [31] = Class [111] 
.const [32] = Class [112] 
.const [33] = Class [113] 
.const [34] = Field [114] [115] 
.const [35] = Field [116] [117] 
.const [36] = Field [118] [119] 
.const [37] = Field [120] [121] 
.const [38] = Method [122] [123] 
.const [39] = Method [124] [125] 
.const [40] = Method [126] [127] 
.const [41] = Method [128] [129] 
.const [42] = Field [130] [131] 
.const [43] = Method [132] [133] 
.const [44] = Method [134] [135] 
.const [45] = Field [136] [137] 
.const [46] = Method [138] [139] 
.const [47] = Method [140] [141] 
.const [48] = Method [142] [143] 
.const [49] = Method [144] [145] 
.const [50] = Method [146] [147] 
.const [51] = Method [148] [149] 
.const [52] = Field [150] [151] 
.const [53] = Method [152] [153] 
.const [54] = Method [154] [155] 
.const [55] = Field [156] [157] 
.const [56] = Method [158] [159] 
.const [57] = Method [160] [161] 
.const [58] = Method [162] [163] 
.const [59] = Method [164] [165] 
.const [60] = Method [166] [167] 
.const [61] = Method [168] [169] 
.const [62] = InterfaceMethod [170] [171] 
.const [63] = InterfaceMethod [172] [173] 
.const [64] = InterfaceMethod [174] [175] 
.const [65] = Field [176] [177] 
.const [66] = Field [178] [179] 
.const [67] = Field [180] [181] 
.const [68] = Field [182] [183] 
.const [69] = Class [184] 
.const [70] = InterfaceMethod [185] [186] 
.const [71] = InterfaceMethod [187] [188] 
.const [72] = Field [189] [190] 
.const [73] = InterfaceMethod [191] [192] 
.const [74] = InterfaceMethod [193] [194] 
.const [75] = InterfaceMethod [195] [196] 
.const [76] = Field [197] [198] 
.const [77] = Class [199] 
.const [78] = InterfaceMethod [200] [201] 
.const [79] = InterfaceMethod [202] [203] 
.const [80] = Class [204] 
.const [81] = NameAndType [205] [206] 
.const [82] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [83] = Utf8 RequestAudioConnection( 
.const [84] = Utf8 ')' 
.const [85] = Utf8 ', timeout=' 
.const [86] = Utf8 '[%1.execute]' 
.const [87] = Class [207] 
.const [88] = NameAndType [208] [209] 
.const [89] = Utf8 '[%1.audioStateChanged] state=%2, %3, %4' 
.const [90] = Class [210] 
.const [91] = NameAndType [211] [212] 
.const [92] = Utf8 audible 
.const [93] = Utf8 'not audible' 
.const [94] = Utf8 'media routes ready' 
.const [95] = Utf8 'media routes not ready' 
.const [96] = Class [213] 
.const [97] = NameAndType [214] [215] 
.const [98] = Utf8 '[%1.audioStateChanged] Error for audio connection %2' 
.const [99] = Utf8 '[%1.mediaRoutesChanging]' 
.const [100] = Utf8 '[%1.mediaRoutesChanged]' 
.const [101] = Utf8 '[RequestAudioConnection.canceled] no response, but still continue' 
.const [102] = Utf8 de/audi/app/terminalmode/statemachine/commands/RequestAudioConnection$1 
.const [103] = Utf8 de/audi/app/terminalmode/statemachine/commands/RequestAudioConnection 
.const [104] = Utf8 de/audi/app/terminalmode/statemachine/commands/AbstractCommand 
.const [105] = Utf8 de/audi/app/terminalmode/IContext 
.const [106] = Utf8 de/audi/app/terminalmode/ITerminalLogger 
.const [107] = Utf8 de/audi/app/terminalmode/audio/TMAudioConnection 
.const [108] = Utf8 de/audi/atip/log/LogChannel 
.const [109] = Utf8 de/audi/app/terminalmode/audio/IAudioManager 
.const [110] = Utf8 de/audi/tghu/command/ICommandList 
.const [111] = Utf8 de/audi/app/terminalmode/audio/AudioConnectionState 
.const [112] = Utf8 de/audi/app/terminalmode/audio/AudioState 
.const [113] = Utf8 java/lang/String 
.const [114] = Class [216] 
.const [115] = NameAndType [217] [218] 
.const [116] = Class [219] 
.const [117] = NameAndType [220] [221] 
.const [118] = Class [222] 
.const [119] = NameAndType [223] [224] 
.const [120] = Class [225] 
.const [121] = NameAndType [226] [227] 
.const [122] = Class [228] 
.const [123] = NameAndType [229] [230] 
.const [124] = Class [231] 
.const [125] = NameAndType [232] [233] 
.const [126] = Class [234] 
.const [127] = NameAndType [235] [236] 
.const [128] = Class [237] 
.const [129] = NameAndType [238] [239] 
.const [130] = Class [240] 
.const [131] = NameAndType [241] [242] 
.const [132] = Class [243] 
.const [133] = NameAndType [244] [245] 
.const [134] = Class [246] 
.const [135] = NameAndType [247] [248] 
.const [136] = Class [249] 
.const [137] = NameAndType [250] [251] 
.const [138] = Class [252] 
.const [139] = NameAndType [253] [254] 
.const [140] = Class [255] 
.const [141] = NameAndType [256] [257] 
.const [142] = Class [258] 
.const [143] = NameAndType [259] [260] 
.const [144] = Class [261] 
.const [145] = NameAndType [262] [263] 
.const [146] = Class [264] 
.const [147] = NameAndType [265] [266] 
.const [148] = Class [267] 
.const [149] = NameAndType [268] [269] 
.const [150] = Class [270] 
.const [151] = NameAndType [271] [272] 
.const [152] = Class [273] 
.const [153] = NameAndType [274] [275] 
.const [154] = Class [276] 
.const [155] = NameAndType [277] [278] 
.const [156] = Class [279] 
.const [157] = NameAndType [280] [281] 
.const [158] = Class [282] 
.const [159] = NameAndType [283] [284] 
.const [160] = Class [285] 
.const [161] = NameAndType [286] [287] 
.const [162] = Class [288] 
.const [163] = NameAndType [289] [290] 
.const [164] = Class [291] 
.const [165] = NameAndType [292] [293] 
.const [166] = Class [294] 
.const [167] = NameAndType [295] [296] 
.const [168] = Class [297] 
.const [169] = NameAndType [298] [299] 
.const [170] = Class [300] 
.const [171] = NameAndType [301] [302] 
.const [172] = Class [303] 
.const [173] = NameAndType [304] [305] 
.const [174] = Class [306] 
.const [175] = NameAndType [307] [308] 
.const [176] = Class [309] 
.const [177] = NameAndType [310] [311] 
.const [178] = Class [312] 
.const [179] = NameAndType [313] [314] 
.const [180] = Class [315] 
.const [181] = NameAndType [316] [317] 
.const [182] = Class [318] 
.const [183] = NameAndType [319] [320] 
.const [184] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [185] = Class [321] 
.const [186] = NameAndType [322] [323] 
.const [187] = Class [324] 
.const [188] = NameAndType [325] [326] 
.const [189] = Class [327] 
.const [190] = NameAndType [328] [329] 
.const [191] = Class [330] 
.const [192] = NameAndType [331] [332] 
.const [193] = Class [333] 
.const [194] = NameAndType [334] [335] 
.const [195] = Class [336] 
.const [196] = NameAndType [337] [338] 
.const [197] = Class [339] 
.const [198] = NameAndType [340] [341] 
.const [199] = Utf8 de/audi/app/terminalmode/statemachine/commands/RequestAudioConnection$1 
.const [200] = Class [342] 
.const [201] = NameAndType [343] [344] 
.const [202] = Class [345] 
.const [203] = NameAndType [346] [347] 
.const [204] = Utf8 de/audi/app/terminalmode/statemachine/commands/RequestAudioConnection 
.const [205] = Utf8 formatTag 
.const [206] = Utf8 (Lde/audi/app/terminalmode/audio/TMAudioConnection;ILde/audi/app/terminalmode/audio/IAudioManager;)Ljava/lang/String; 
.const [207] = Utf8 de/audi/app/terminalmode/audio/AudioState 
.const [208] = Utf8 PAUSED 
.const [209] = Utf8 Lde/audi/app/terminalmode/audio/AudioState; 
.const [210] = Utf8 java/lang/String 
.const [211] = Utf8 valueOf 
.const [212] = Utf8 (Ljava/lang/Object;)Ljava/lang/String; 
.const [213] = Utf8 de/audi/app/terminalmode/audio/AudioState 
.const [214] = Utf8 ERROR 
.const [215] = Utf8 Lde/audi/app/terminalmode/audio/AudioState; 
.const [216] = Utf8 de/audi/app/terminalmode/statemachine/commands/RequestAudioConnection 
.const [217] = Utf8 audioManager 
.const [218] = Utf8 Lde/audi/app/terminalmode/audio/IAudioManager; 
.const [219] = Utf8 de/audi/app/terminalmode/statemachine/commands/RequestAudioConnection 
.const [220] = Utf8 audioConnection 
.const [221] = Utf8 Lde/audi/app/terminalmode/audio/TMAudioConnection; 
.const [222] = Utf8 de/audi/app/terminalmode/statemachine/commands/RequestAudioConnection 
.const [223] = Utf8 checkAudioFocus 
.const [224] = Utf8 Z 
.const [225] = Utf8 de/audi/app/terminalmode/statemachine/commands/RequestAudioConnection 
.const [226] = Utf8 timeout 
.const [227] = Utf8 I 
.const [228] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [229] = Utf8 append 
.const [230] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [231] = Utf8 de/audi/app/terminalmode/audio/TMAudioConnection 
.const [232] = Utf8 toString 
.const [233] = Utf8 ()Ljava/lang/String; 
.const [234] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [235] = Utf8 append 
.const [236] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [237] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [238] = Utf8 toString 
.const [239] = Utf8 ()Ljava/lang/String; 
.const [240] = Utf8 de/audi/app/terminalmode/statemachine/commands/RequestAudioConnection 
.const [241] = Utf8 logger 
.const [242] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [243] = Utf8 de/audi/app/terminalmode/statemachine/commands/RequestAudioConnection 
.const [244] = Utf8 getName 
.const [245] = Utf8 ()Ljava/lang/String; 
.const [246] = Utf8 de/audi/atip/log/LogChannel 
.const [247] = Utf8 log 
.const [248] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [249] = Utf8 de/audi/app/terminalmode/statemachine/commands/RequestAudioConnection 
.const [250] = Utf8 mediaRoutesReady 
.const [251] = Utf8 Z 
.const [252] = Utf8 de/audi/app/terminalmode/statemachine/commands/RequestAudioConnection 
.const [253] = Utf8 getCommandList 
.const [254] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [255] = Utf8 de/audi/app/terminalmode/audio/AudioConnectionState 
.const [256] = Utf8 getTMConnection 
.const [257] = Utf8 ()Lde/audi/app/terminalmode/audio/TMAudioConnection; 
.const [258] = Utf8 de/audi/app/terminalmode/audio/TMAudioConnection 
.const [259] = Utf8 isNot 
.const [260] = Utf8 (Ljava/lang/Object;)Z 
.const [261] = Utf8 de/audi/app/terminalmode/audio/AudioConnectionState 
.const [262] = Utf8 isAudible 
.const [263] = Utf8 ()Z 
.const [264] = Utf8 de/audi/app/terminalmode/audio/AudioConnectionState 
.const [265] = Utf8 getState 
.const [266] = Utf8 ()Lde/audi/app/terminalmode/audio/AudioState; 
.const [267] = Utf8 de/audi/app/terminalmode/audio/AudioState 
.const [268] = Utf8 is 
.const [269] = Utf8 (Ljava/lang/Object;)Z 
.const [270] = Utf8 de/audi/app/terminalmode/statemachine/commands/RequestAudioConnection 
.const [271] = Utf8 audioConnectionReady 
.const [272] = Utf8 Z 
.const [273] = Utf8 de/audi/atip/log/LogChannel 
.const [274] = Utf8 log 
.const [275] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [276] = Utf8 de/audi/atip/log/LogChannel 
.const [277] = Utf8 log 
.const [278] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [279] = Utf8 de/audi/app/terminalmode/statemachine/commands/RequestAudioConnection 
.const [280] = Utf8 commandList 
.const [281] = Utf8 Lde/audi/tghu/command/ICommandList; 
.const [282] = Utf8 de/audi/atip/log/LogChannel 
.const [283] = Utf8 log 
.const [284] = Utf8 (ILjava/lang/String;)Z 
.const [285] = Utf8 de/audi/app/terminalmode/statemachine/commands/AbstractCommand 
.const [286] = Utf8 <init> 
.const [287] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/terminalmode/IContext;)V 
.const [288] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [289] = Utf8 <init> 
.const [290] = Utf8 ()V 
.const [291] = Utf8 de/audi/app/terminalmode/statemachine/commands/RequestAudioConnection 
.const [292] = Utf8 finishCommand 
.const [293] = Utf8 ()V 
.const [294] = Utf8 de/audi/app/terminalmode/statemachine/commands/RequestAudioConnection 
.const [295] = Utf8 deRegisterListeners 
.const [296] = Utf8 ()V 
.const [297] = Utf8 de/audi/app/terminalmode/statemachine/commands/RequestAudioConnection$1 
.const [298] = Utf8 <init> 
.const [299] = Utf8 (Lde/audi/app/terminalmode/statemachine/commands/RequestAudioConnection;Lde/audi/atip/log/LogChannel;)V 
.const [300] = Utf8 de/audi/app/terminalmode/IContext 
.const [301] = Utf8 getLogger 
.const [302] = Utf8 ()Lde/audi/app/terminalmode/ITerminalLogger; 
.const [303] = Utf8 de/audi/app/terminalmode/ITerminalLogger 
.const [304] = Utf8 main 
.const [305] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [306] = Utf8 de/audi/app/terminalmode/IContext 
.const [307] = Utf8 getAudioManager 
.const [308] = Utf8 ()Lde/audi/app/terminalmode/audio/IAudioManager; 
.const [309] = Utf8 de/audi/app/terminalmode/statemachine/commands/RequestAudioConnection 
.const [310] = Utf8 audioManager 
.const [311] = Utf8 Lde/audi/app/terminalmode/audio/IAudioManager; 
.const [312] = Utf8 de/audi/app/terminalmode/statemachine/commands/RequestAudioConnection 
.const [313] = Utf8 audioConnection 
.const [314] = Utf8 Lde/audi/app/terminalmode/audio/TMAudioConnection; 
.const [315] = Utf8 de/audi/app/terminalmode/statemachine/commands/RequestAudioConnection 
.const [316] = Utf8 checkAudioFocus 
.const [317] = Utf8 Z 
.const [318] = Utf8 de/audi/app/terminalmode/statemachine/commands/RequestAudioConnection 
.const [319] = Utf8 timeout 
.const [320] = Utf8 I 
.const [321] = Utf8 de/audi/app/terminalmode/audio/IAudioManager 
.const [322] = Utf8 isAudioServiceAvailable 
.const [323] = Utf8 ()Z 
.const [324] = Utf8 de/audi/app/terminalmode/audio/IAudioManager 
.const [325] = Utf8 addAudioContextListener 
.const [326] = Utf8 (Lde/audi/app/terminalmode/audio/IAudioStateListener;)V 
.const [327] = Utf8 de/audi/app/terminalmode/statemachine/commands/RequestAudioConnection 
.const [328] = Utf8 mediaRoutesReady 
.const [329] = Utf8 Z 
.const [330] = Utf8 de/audi/app/terminalmode/audio/IAudioManager 
.const [331] = Utf8 addMediaRouteChangeListener 
.const [332] = Utf8 (Lde/audi/app/terminalmode/audio/IMediaRoutesChangeListener;)V 
.const [333] = Utf8 de/audi/app/terminalmode/audio/IAudioManager 
.const [334] = Utf8 requestAudio 
.const [335] = Utf8 (Lde/audi/app/terminalmode/audio/TMAudioConnection;Z)V 
.const [336] = Utf8 de/audi/tghu/command/ICommandList 
.const [337] = Utf8 commandFinished 
.const [338] = Utf8 ()V 
.const [339] = Utf8 de/audi/app/terminalmode/statemachine/commands/RequestAudioConnection 
.const [340] = Utf8 audioConnectionReady 
.const [341] = Utf8 Z 
.const [342] = Utf8 de/audi/app/terminalmode/audio/IAudioManager 
.const [343] = Utf8 removeAudioContextListener 
.const [344] = Utf8 (Lde/audi/app/terminalmode/audio/IAudioStateListener;)V 
.const [345] = Utf8 de/audi/app/terminalmode/audio/IAudioManager 
.const [346] = Utf8 removeMediaRouteChangeListener 
.const [347] = Utf8 (Lde/audi/app/terminalmode/audio/IMediaRoutesChangeListener;)V 
.const [348] = Utf8 de/audi/app/terminalmode/statemachine/commands/RequestAudioConnection 
.const [349] = Class [348] 
.const [350] = Utf8 de/audi/app/terminalmode/statemachine/commands/AbstractCommand 
.const [351] = Class [350] 
.const [352] = Utf8 de/audi/app/terminalmode/audio/IAudioStateListener 
.const [353] = Class [352] 
.const [354] = Utf8 de/audi/app/terminalmode/audio/IMediaRoutesChangeListener 
.const [355] = Class [354] 
.const [356] = Utf8 ANDROID_AUTO_TIMEOUT 
.const [357] = Utf8 I 
.const [358] = Utf8 CARPLAY_TIMEOUT 
.const [359] = Utf8 I 
.const [360] = Utf8 audioManager 
.const [361] = Utf8 Lde/audi/app/terminalmode/audio/IAudioManager; 
.const [362] = Utf8 audioConnection 
.const [363] = Utf8 Lde/audi/app/terminalmode/audio/TMAudioConnection; 
.const [364] = Utf8 checkAudioFocus 
.const [365] = Utf8 Z 
.const [366] = Utf8 timeout 
.const [367] = Utf8 I 
.const [368] = Utf8 mediaRoutesReady 
.const [369] = Utf8 Z 
.const [370] = Utf8 audioConnectionReady 
.const [371] = Utf8 Z 
.const [372] = Utf8 Code 
.const [373] = Utf8 <init> 
.const [374] = Utf8 (Lde/audi/app/terminalmode/audio/TMAudioConnection;Lde/audi/app/terminalmode/IContext;ZI)V 
.const [375] = Utf8 formatTag 
.const [376] = Utf8 (Lde/audi/app/terminalmode/audio/TMAudioConnection;ILde/audi/app/terminalmode/audio/IAudioManager;)Ljava/lang/String; 
.const [377] = Utf8 execute 
.const [378] = Utf8 ()V 
.const [379] = Utf8 audioStateChanged 
.const [380] = Utf8 (Lde/audi/app/terminalmode/audio/AudioConnectionState;)V 
.const [381] = Utf8 mediaRoutesChanging 
.const [382] = Utf8 ()V 
.const [383] = Utf8 mediaRoutesChanged 
.const [384] = Utf8 ()V 
.const [385] = Utf8 finishCommand 
.const [386] = Utf8 ()V 
.const [387] = Utf8 audioFocusChanged 
.const [388] = Utf8 (Z)V 
.const [389] = Utf8 getTimeout 
.const [390] = Utf8 ()J 
.const [391] = Utf8 canceled 
.const [392] = Utf8 ()Lde/audi/tghu/command/Command; 
.const [393] = Utf8 deRegisterListeners 
.const [394] = Utf8 ()V 
.end class 
