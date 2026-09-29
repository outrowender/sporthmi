.version 50 0 
.class public super [256] 
.super [258] 
.implements [260] 
.field private [261] [262] 
.field private [263] [264] 
.field private final [265] [266] 
.field private final [267] [268] 
.field private [269] [270] 
.field private [271] [272] 
.field private final [273] [274] 

.method public [276] : [277] 
    .attribute [275] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [35] 
L4:     aload_0 
L5:     bipush 8 
L7:     newarray boolean 
L9:     putfield [40] 
L12:    aload_0 
L13:    iconst_1 
L14:    putfield [41] 
L17:    aload_0 
L18:    aload_2 
L19:    putfield [42] 
L22:    aload_0 
L23:    aload_1 
L24:    getfield [26] 
L27:    getfield [27] 
L30:    putfield [43] 
L33:    aload_0 
L34:    aload_3 
L35:    putfield [44] 
L38:    aload_0 
L39:    new [45] 
L42:    dup 
L43:    aload_2 
L44:    invokespecial [36] 
L47:    putfield [46] 
L50:    aload_0 
L51:    new [47] 
L54:    dup 
L55:    aload_2 
L56:    invokespecial [37] 
L59:    putfield [48] 
L62:    return 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [278] : [279] 
    .attribute [275] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [46] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [280] : [281] 
    .attribute [275] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [48] 
L5:     aload_0 
L6:     iconst_0 
L7:     invokevirtual [32] 
L10:    ifeq L25 
L13:    aload_1 
L14:    getstatic [4] 
L17:    getstatic [5] 
L20:    invokeinterface [49] 0 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private [282] : [283] 
    .attribute [275] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [23] 
L4:     dup 
L5:     astore_3 
L6:     monitorenter 
        .catch [0] from L7 to L34 using L37 
L7:     iload_2 
L8:     ifne L25 
L11:    aload_0 
L12:    getfield [23] 
L15:    iconst_0 
L16:    iload_1 
L17:    bastore 
L18:    aload_0 
L19:    getfield [23] 
L22:    iconst_1 
L23:    iload_1 
L24:    bastore 
L25:    aload_0 
L26:    getfield [23] 
L29:    iload_2 
L30:    iload_1 
L31:    bastore 
L32:    aload_3 
L33:    monitorexit 
L34:    goto L44 
        .catch [0] from L37 to L41 using L37 
L37:    astore 4 
L39:    aload_3 
L40:    monitorexit 
L41:    aload 4 
L43:    athrow 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [284] : [285] 
    .attribute [275] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [23] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L24 using L25 
L7:     iload_1 
L8:     iconst_m1 
L9:     if_icmpne L16 
L12:    iconst_0 
L13:    goto L22 
L16:    aload_0 
L17:    getfield [23] 
L20:    iload_1 
L21:    baload 
L22:    aload_2 
L23:    monitorexit 
L24:    areturn 
        .catch [0] from L25 to L28 using L25 
L25:    astore_3 
L26:    aload_2 
L27:    monitorexit 
L28:    aload_3 
L29:    athrow 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public synchronized [286] : [287] 
    .attribute [275] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [25] 
L4:     ldc [6] 
L6:     ldc [7] 
L8:     iload_1 
L9:     i2l 
L10:    iload_2 
L11:    i2l 
L12:    invokevirtual [33] 
L15:    pop 
L16:    iload_2 
L17:    bipush 38 
L19:    if_icmpne L120 
L22:    aload_0 
L23:    iconst_1 
L24:    iload_1 
L25:    invokespecial [38] 
L28:    iload_1 
L29:    ifne L88 
L32:    aload_0 
L33:    getfield [29] 
L36:    aload_0 
L37:    getfield [24] 
L40:    invokeinterface [50] 0 
L45:    aload_0 
L46:    getfield [28] 
L49:    invokestatic [8] 
L52:    new [51] 
L55:    dup 
L56:    iconst_1 
L57:    invokespecial [39] 
L60:    invokeinterface [52] 0 
L65:    aload_0 
L66:    getfield [31] 
L69:    getstatic [4] 
L72:    getstatic [5] 
L75:    invokeinterface [49] 0 
L80:    aload_0 
L81:    iconst_0 
L82:    putfield [41] 
L85:    goto L211 
L88:    aload_0 
L89:    getfield [29] 
L92:    invokeinterface [53] 0 
L97:    aload_0 
L98:    getfield [28] 
L101:   invokestatic [10] 
L104:   new [51] 
L107:   dup 
L108:   iconst_1 
L109:   invokespecial [39] 
L112:   invokeinterface [52] 0 
L117:   goto L211 
L120:   aload_0 
L121:   iconst_0 
L122:   iload_1 
L123:   invokespecial [38] 
L126:   iload_1 
L127:   ifne L182 
L130:   aload_0 
L131:   getfield [29] 
L134:   invokeinterface [54] 0 
L139:   aload_0 
L140:   getfield [28] 
L143:   invokestatic [8] 
L146:   new [51] 
L149:   dup 
L150:   iconst_0 
L151:   invokespecial [39] 
L154:   invokeinterface [52] 0 
L159:   aload_0 
L160:   getfield [31] 
L163:   getstatic [4] 
L166:   getstatic [11] 
L169:   invokeinterface [49] 0 
L174:   aload_0 
L175:   iconst_0 
L176:   putfield [41] 
L179:   goto L211 
L182:   aload_0 
L183:   getfield [29] 
L186:   invokeinterface [55] 0 
L191:   aload_0 
L192:   getfield [28] 
L195:   invokestatic [10] 
L198:   new [51] 
L201:   dup 
L202:   iconst_0 
L203:   invokespecial [39] 
L206:   invokeinterface [52] 0 
L211:   return 
L212:   
    .end code 
.end method 

.method public [288] : [289] 
    .attribute [275] .code stack 5 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokevirtual [32] 
L5:     ifne L34 
L8:     aload_0 
L9:     getfield [25] 
L12:    ldc [6] 
L14:    ldc [12] 
L16:    iload_1 
L17:    i2l 
L18:    invokevirtual [34] 
L21:    pop 
L22:    aload_0 
L23:    getfield [30] 
L26:    iload_1 
L27:    bipush 38 
L29:    invokeinterface [56] 0 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [57] 
.const [3] = Class [58] 
.const [4] = Field [59] [60] 
.const [5] = Field [61] [62] 
.const [6] = Int -2137614336 
.const [7] = String [63] 
.const [8] = Method [64] [65] 
.const [9] = Class [66] 
.const [10] = Method [67] [68] 
.const [11] = Field [69] [70] 
.const [12] = String [71] 
.const [13] = Class [72] 
.const [14] = Class [73] 
.const [15] = Class [74] 
.const [16] = Class [75] 
.const [17] = Class [76] 
.const [18] = Class [77] 
.const [19] = Class [78] 
.const [20] = Class [79] 
.const [21] = Class [80] 
.const [22] = Class [81] 
.const [23] = Field [82] [83] 
.const [24] = Field [84] [85] 
.const [25] = Field [86] [87] 
.const [26] = Field [88] [89] 
.const [27] = Field [90] [91] 
.const [28] = Field [92] [93] 
.const [29] = Field [94] [95] 
.const [30] = Field [96] [97] 
.const [31] = Field [98] [99] 
.const [32] = Method [100] [101] 
.const [33] = Method [102] [103] 
.const [34] = Method [104] [105] 
.const [35] = Method [106] [107] 
.const [36] = Method [108] [109] 
.const [37] = Method [110] [111] 
.const [38] = Method [112] [113] 
.const [39] = Method [114] [115] 
.const [40] = Field [116] [117] 
.const [41] = Field [118] [119] 
.const [42] = Field [120] [121] 
.const [43] = Field [122] [123] 
.const [44] = Field [124] [125] 
.const [45] = Class [126] 
.const [46] = Field [127] [128] 
.const [47] = Class [129] 
.const [48] = Field [130] [131] 
.const [49] = InterfaceMethod [132] [133] 
.const [50] = InterfaceMethod [134] [135] 
.const [51] = Class [136] 
.const [52] = InterfaceMethod [137] [138] 
.const [53] = InterfaceMethod [139] [140] 
.const [54] = InterfaceMethod [141] [142] 
.const [55] = InterfaceMethod [143] [144] 
.const [56] = InterfaceMethod [145] [146] 
.const [57] = Utf8 de/audi/atip/audio/NullAudioFocusManager 
.const [58] = Utf8 de/audi/atip/interapp/audio/drawer/NullAudioDrawerContext 
.const [59] = Class [147] 
.const [60] = NameAndType [148] [149] 
.const [61] = Class [150] 
.const [62] = NameAndType [151] [152] 
.const [63] = Utf8 '[AudioFocusClient.updateAudioFocus] terminal %1 app %2' 
.const [64] = Class [153] 
.const [65] = NameAndType [154] [155] 
.const [66] = Utf8 java/lang/Boolean 
.const [67] = Class [156] 
.const [68] = NameAndType [157] [158] 
.const [69] = Class [159] 
.const [70] = NameAndType [160] [161] 
.const [71] = Utf8 '[AudioFocusClient.activateTVAudio] request audio focus for terminal %1' 
.const [72] = Utf8 de/audi/tv/app/audio/AudioFocusClient 
.const [73] = Utf8 java/lang/Object 
.const [74] = Utf8 de/audi/tv/app/audio/AudioFocusClient$Properties 
.const [75] = Utf8 de/audi/tv/app/base/TVEnv 
.const [76] = Utf8 de/audi/tv/app/base/PropertyBank 
.const [77] = Utf8 de/audi/atip/interapp/audio/drawer/AudioDrawerContext 
.const [78] = Utf8 de/audi/atip/log/LogChannel 
.const [79] = Utf8 de/audi/tv/app/audio/IAudioListener 
.const [80] = Utf8 de/audi/atip/utils/reactive/properties/Property 
.const [81] = Utf8 de/audi/atip/audio/IAudioFocusManager 
.const [82] = Class [162] 
.const [83] = NameAndType [163] [164] 
.const [84] = Class [165] 
.const [85] = NameAndType [166] [167] 
.const [86] = Class [168] 
.const [87] = NameAndType [169] [170] 
.const [88] = Class [171] 
.const [89] = NameAndType [172] [173] 
.const [90] = Class [174] 
.const [91] = NameAndType [175] [176] 
.const [92] = Class [177] 
.const [93] = NameAndType [178] [179] 
.const [94] = Class [180] 
.const [95] = NameAndType [181] [182] 
.const [96] = Class [183] 
.const [97] = NameAndType [184] [185] 
.const [98] = Class [186] 
.const [99] = NameAndType [187] [188] 
.const [100] = Class [189] 
.const [101] = NameAndType [190] [191] 
.const [102] = Class [192] 
.const [103] = NameAndType [193] [194] 
.const [104] = Class [195] 
.const [105] = NameAndType [196] [197] 
.const [106] = Class [198] 
.const [107] = NameAndType [199] [200] 
.const [108] = Class [201] 
.const [109] = NameAndType [202] [203] 
.const [110] = Class [204] 
.const [111] = NameAndType [205] [206] 
.const [112] = Class [207] 
.const [113] = NameAndType [208] [209] 
.const [114] = Class [210] 
.const [115] = NameAndType [211] [212] 
.const [116] = Class [213] 
.const [117] = NameAndType [214] [215] 
.const [118] = Class [216] 
.const [119] = NameAndType [217] [218] 
.const [120] = Class [219] 
.const [121] = NameAndType [220] [221] 
.const [122] = Class [222] 
.const [123] = NameAndType [223] [224] 
.const [124] = Class [225] 
.const [125] = NameAndType [226] [227] 
.const [126] = Utf8 de/audi/atip/audio/NullAudioFocusManager 
.const [127] = Class [228] 
.const [128] = NameAndType [229] [230] 
.const [129] = Utf8 de/audi/atip/interapp/audio/drawer/NullAudioDrawerContext 
.const [130] = Class [231] 
.const [131] = NameAndType [232] [233] 
.const [132] = Class [234] 
.const [133] = NameAndType [235] [236] 
.const [134] = Class [237] 
.const [135] = NameAndType [238] [239] 
.const [136] = Utf8 java/lang/Boolean 
.const [137] = Class [240] 
.const [138] = NameAndType [241] [242] 
.const [139] = Class [243] 
.const [140] = NameAndType [244] [245] 
.const [141] = Class [246] 
.const [142] = NameAndType [247] [248] 
.const [143] = Class [249] 
.const [144] = NameAndType [250] [251] 
.const [145] = Class [252] 
.const [146] = NameAndType [253] [254] 
.const [147] = Utf8 de/audi/atip/interapp/audio/drawer/AudioDrawerContext 
.const [148] = Utf8 SOURCE_TV 
.const [149] = Utf8 Lde/audi/atip/interapp/audio/drawer/AudioDrawerContext$Source; 
.const [150] = Utf8 de/audi/atip/interapp/audio/drawer/AudioDrawerContext 
.const [151] = Utf8 SOURCE_AUDIO_STATE_ACTIVE 
.const [152] = Utf8 Lde/audi/atip/interapp/audio/drawer/AudioDrawerContext$SourceAudioState; 
.const [153] = Utf8 de/audi/tv/app/audio/AudioFocusClient$Properties 
.const [154] = Utf8 access$000 
.const [155] = Utf8 (Lde/audi/tv/app/audio/AudioFocusClient$Properties;)Lde/audi/atip/utils/reactive/properties/Property; 
.const [156] = Utf8 de/audi/tv/app/audio/AudioFocusClient$Properties 
.const [157] = Utf8 access$100 
.const [158] = Utf8 (Lde/audi/tv/app/audio/AudioFocusClient$Properties;)Lde/audi/atip/utils/reactive/properties/Property; 
.const [159] = Utf8 de/audi/atip/interapp/audio/drawer/AudioDrawerContext 
.const [160] = Utf8 SOURCE_AUDIO_STATE_INACTIVE 
.const [161] = Utf8 Lde/audi/atip/interapp/audio/drawer/AudioDrawerContext$SourceAudioState; 
.const [162] = Utf8 de/audi/tv/app/audio/AudioFocusClient 
.const [163] = Utf8 audioFocus 
.const [164] = Utf8 [Z 
.const [165] = Utf8 de/audi/tv/app/audio/AudioFocusClient 
.const [166] = Utf8 isFirstAudioFocusUpdate 
.const [167] = Utf8 Z 
.const [168] = Utf8 de/audi/tv/app/audio/AudioFocusClient 
.const [169] = Utf8 log 
.const [170] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [171] = Utf8 de/audi/tv/app/base/TVEnv 
.const [172] = Utf8 properties 
.const [173] = Utf8 Lde/audi/tv/app/base/PropertyBank; 
.const [174] = Utf8 de/audi/tv/app/base/PropertyBank 
.const [175] = Utf8 audioFocus 
.const [176] = Utf8 Lde/audi/tv/app/audio/AudioFocusClient$Properties; 
.const [177] = Utf8 de/audi/tv/app/audio/AudioFocusClient 
.const [178] = Utf8 myProperties 
.const [179] = Utf8 Lde/audi/tv/app/audio/AudioFocusClient$Properties; 
.const [180] = Utf8 de/audi/tv/app/audio/AudioFocusClient 
.const [181] = Utf8 audioFocusListener 
.const [182] = Utf8 Lde/audi/tv/app/audio/IAudioListener; 
.const [183] = Utf8 de/audi/tv/app/audio/AudioFocusClient 
.const [184] = Utf8 manager 
.const [185] = Utf8 Lde/audi/atip/audio/IAudioFocusManager; 
.const [186] = Utf8 de/audi/tv/app/audio/AudioFocusClient 
.const [187] = Utf8 audioDrawerContext 
.const [188] = Utf8 Lde/audi/atip/interapp/audio/drawer/AudioDrawerContext; 
.const [189] = Utf8 de/audi/tv/app/audio/AudioFocusClient 
.const [190] = Utf8 hasAudioFocus 
.const [191] = Utf8 (I)Z 
.const [192] = Utf8 de/audi/atip/log/LogChannel 
.const [193] = Utf8 log 
.const [194] = Utf8 (ILjava/lang/String;JJ)Z 
.const [195] = Utf8 de/audi/atip/log/LogChannel 
.const [196] = Utf8 log 
.const [197] = Utf8 (ILjava/lang/String;J)Z 
.const [198] = Utf8 java/lang/Object 
.const [199] = Utf8 <init> 
.const [200] = Utf8 ()V 
.const [201] = Utf8 de/audi/atip/audio/NullAudioFocusManager 
.const [202] = Utf8 <init> 
.const [203] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [204] = Utf8 de/audi/atip/interapp/audio/drawer/NullAudioDrawerContext 
.const [205] = Utf8 <init> 
.const [206] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [207] = Utf8 de/audi/tv/app/audio/AudioFocusClient 
.const [208] = Utf8 setAudioFocus 
.const [209] = Utf8 (ZI)V 
.const [210] = Utf8 java/lang/Boolean 
.const [211] = Utf8 <init> 
.const [212] = Utf8 (Z)V 
.const [213] = Utf8 de/audi/tv/app/audio/AudioFocusClient 
.const [214] = Utf8 audioFocus 
.const [215] = Utf8 [Z 
.const [216] = Utf8 de/audi/tv/app/audio/AudioFocusClient 
.const [217] = Utf8 isFirstAudioFocusUpdate 
.const [218] = Utf8 Z 
.const [219] = Utf8 de/audi/tv/app/audio/AudioFocusClient 
.const [220] = Utf8 log 
.const [221] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [222] = Utf8 de/audi/tv/app/audio/AudioFocusClient 
.const [223] = Utf8 myProperties 
.const [224] = Utf8 Lde/audi/tv/app/audio/AudioFocusClient$Properties; 
.const [225] = Utf8 de/audi/tv/app/audio/AudioFocusClient 
.const [226] = Utf8 audioFocusListener 
.const [227] = Utf8 Lde/audi/tv/app/audio/IAudioListener; 
.const [228] = Utf8 de/audi/tv/app/audio/AudioFocusClient 
.const [229] = Utf8 manager 
.const [230] = Utf8 Lde/audi/atip/audio/IAudioFocusManager; 
.const [231] = Utf8 de/audi/tv/app/audio/AudioFocusClient 
.const [232] = Utf8 audioDrawerContext 
.const [233] = Utf8 Lde/audi/atip/interapp/audio/drawer/AudioDrawerContext; 
.const [234] = Utf8 de/audi/atip/interapp/audio/drawer/AudioDrawerContext 
.const [235] = Utf8 setContext 
.const [236] = Utf8 (Lde/audi/atip/interapp/audio/drawer/AudioDrawerContext$Source;Lde/audi/atip/interapp/audio/drawer/AudioDrawerContext$SourceAudioState;)V 
.const [237] = Utf8 de/audi/tv/app/audio/IAudioListener 
.const [238] = Utf8 onMuGotTvAudioFocus 
.const [239] = Utf8 (Z)V 
.const [240] = Utf8 de/audi/atip/utils/reactive/properties/Property 
.const [241] = Utf8 accept 
.const [242] = Utf8 (Ljava/lang/Object;)V 
.const [243] = Utf8 de/audi/tv/app/audio/IAudioListener 
.const [244] = Utf8 onSdisGotTvAudioFocus 
.const [245] = Utf8 ()V 
.const [246] = Utf8 de/audi/tv/app/audio/IAudioListener 
.const [247] = Utf8 onMuLostTvAudioFocus 
.const [248] = Utf8 ()V 
.const [249] = Utf8 de/audi/tv/app/audio/IAudioListener 
.const [250] = Utf8 onSdisLostTvAudioFocus 
.const [251] = Utf8 ()V 
.const [252] = Utf8 de/audi/atip/audio/IAudioFocusManager 
.const [253] = Utf8 setActiveAudioApp 
.const [254] = Utf8 (II)V 
.const [255] = Utf8 de/audi/tv/app/audio/AudioFocusClient 
.const [256] = Class [255] 
.const [257] = Utf8 java/lang/Object 
.const [258] = Class [257] 
.const [259] = Utf8 de/audi/atip/audio/IAudioFocusClient 
.const [260] = Class [259] 
.const [261] = Utf8 manager 
.const [262] = Utf8 Lde/audi/atip/audio/IAudioFocusManager; 
.const [263] = Utf8 audioDrawerContext 
.const [264] = Utf8 Lde/audi/atip/interapp/audio/drawer/AudioDrawerContext; 
.const [265] = Utf8 log 
.const [266] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [267] = Utf8 audioFocusListener 
.const [268] = Utf8 Lde/audi/tv/app/audio/IAudioListener; 
.const [269] = Utf8 audioFocus 
.const [270] = Utf8 [Z 
.const [271] = Utf8 isFirstAudioFocusUpdate 
.const [272] = Utf8 Z 
.const [273] = Utf8 myProperties 
.const [274] = Utf8 Lde/audi/tv/app/audio/AudioFocusClient$Properties; 
.const [275] = Utf8 Code 
.const [276] = Utf8 <init> 
.const [277] = Utf8 (Lde/audi/tv/app/base/TVEnv;Lde/audi/atip/log/LogChannel;Lde/audi/tv/app/audio/IAudioListener;)V 
.const [278] = Utf8 register 
.const [279] = Utf8 (Lde/audi/atip/audio/IAudioFocusManager;)V 
.const [280] = Utf8 register 
.const [281] = Utf8 (Lde/audi/atip/interapp/audio/drawer/AudioDrawerContext;)V 
.const [282] = Utf8 setAudioFocus 
.const [283] = Utf8 (ZI)V 
.const [284] = Utf8 hasAudioFocus 
.const [285] = Utf8 (I)Z 
.const [286] = Utf8 updateAudioFocus 
.const [287] = Utf8 (II)V 
.const [288] = Utf8 activateTVAudio 
.const [289] = Utf8 (I)V 
.end class 
