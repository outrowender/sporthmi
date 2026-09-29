.version 50 0 
.class public super [224] 
.super [226] 
.implements [228] 
.field private [229] [230] 
.field private final [231] [232] 
.field private [233] [234] 
.field private volatile [235] [236] 
.field private volatile [237] [238] 
.field private volatile [239] [240] 
.field private [241] [242] 

.method public [244] : [245] 
    .attribute [243] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [36] 
L4:     aload_0 
L5:     bipush 120 
L7:     putfield [38] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [39] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [40] 
L20:    aload_0 
L21:    aload_1 
L22:    invokevirtual [25] 
L25:    putfield [41] 
L28:    aload_0 
L29:    new [42] 
L32:    dup 
L33:    aload_0 
L34:    getfield [26] 
L37:    invokespecial [37] 
L40:    putfield [43] 
L43:    return 
L44:    
    .end code 
.end method 

.method public [246] : [247] 
    .attribute [243] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [44] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [248] : [249] 
    .attribute [243] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [26] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     aload_1 
L9:     invokevirtual [29] 
L12:    pop 
L13:    aload_1 
L14:    ifnull L58 
L17:    aload_0 
L18:    aload_1 
L19:    invokeinterface [45] 0 
L24:    putfield [43] 
        .catch [5] from L27 to L37 using L40 
L27:    aload_0 
L28:    getfield [27] 
L31:    aload_0 
L32:    invokeinterface [46] 0 
L37:    goto L93 
L40:    astore_2 
L41:    aload_0 
L42:    getfield [26] 
L45:    sipush 10000 
L48:    ldc [6] 
L50:    aload_2 
L51:    invokevirtual [30] 
L54:    pop 
L55:    goto L93 
L58:    aload_0 
L59:    getfield [27] 
L62:    aload_0 
L63:    invokeinterface [47] 0 
L68:    aload_0 
L69:    new [42] 
L72:    dup 
L73:    aload_0 
L74:    getfield [26] 
L77:    invokespecial [37] 
L80:    putfield [43] 
L83:    aload_0 
L84:    iconst_0 
L85:    putfield [39] 
L88:    aload_0 
L89:    iconst_0 
L90:    putfield [40] 
L93:    return 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 

.method public [250] : [251] 
    .attribute [243] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [26] 
L4:     ldc [3] 
L6:     ldc [7] 
L8:     aload_0 
L9:     getfield [23] 
L12:    aload_0 
L13:    getfield [24] 
L16:    invokevirtual [31] 
L19:    aload_0 
L20:    getfield [23] 
L23:    ifeq L80 
L26:    aload_0 
L27:    getfield [24] 
L30:    ifne L80 
L33:    aload_0 
L34:    iconst_0 
L35:    putfield [39] 
L38:    aload_0 
L39:    iconst_1 
L40:    putfield [40] 
        .catch [5] from L43 to L57 using L60 
L43:    aload_0 
L44:    getfield [27] 
L47:    iconst_0 
L48:    aload_0 
L49:    getfield [32] 
L52:    invokeinterface [49] 0 
L57:    goto L80 
L60:    astore_1 
L61:    aload_0 
L62:    getfield [26] 
L65:    sipush 10000 
L68:    ldc [8] 
L70:    aload_1 
L71:    invokevirtual [30] 
L74:    pop 
L75:    aload_0 
L76:    iconst_0 
L77:    putfield [40] 
L80:    return 
L81:    nop 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method public [252] : [253] 
    .attribute [243] .code stack 5 locals 1 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [38] 
L5:     aload_0 
L6:     iload_2 
L7:     putfield [48] 
L10:    aload_0 
L11:    getfield [26] 
L14:    ldc [3] 
L16:    ldc [9] 
L18:    aload_0 
L19:    getfield [23] 
L22:    aload_0 
L23:    getfield [24] 
L26:    invokevirtual [31] 
L29:    aload_0 
L30:    getfield [24] 
L33:    ifne L77 
L36:    aload_0 
L37:    iconst_1 
L38:    putfield [39] 
        .catch [5] from L41 to L54 using L57 
L41:    aload_0 
L42:    getfield [28] 
L45:    invokevirtual [33] 
L48:    iload_1 
L49:    invokeinterface [50] 0 
L54:    goto L77 
L57:    astore_3 
L58:    aload_0 
L59:    getfield [26] 
L62:    sipush 10000 
L65:    ldc [10] 
L67:    aload_3 
L68:    invokevirtual [30] 
L71:    pop 
L72:    aload_0 
L73:    iconst_0 
L74:    putfield [39] 
L77:    return 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method public [254] : [255] 
    .attribute [243] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [26] 
L4:     ldc [3] 
L6:     ldc [11] 
L8:     aload_0 
L9:     getfield [24] 
L12:    iload_1 
L13:    i2l 
L14:    invokevirtual [34] 
L17:    pop 
        .catch [5] from L18 to L77 using L80 
L18:    aload_0 
L19:    getfield [28] 
L22:    invokevirtual [33] 
L25:    aload_0 
L26:    getfield [22] 
L29:    invokeinterface [51] 0 
L34:    istore_2 
L35:    aload_0 
L36:    getfield [26] 
L39:    ldc [3] 
L41:    ldc [12] 
L43:    iload_2 
L44:    invokevirtual [35] 
L47:    pop 
L48:    iload_1 
L49:    ifeq L77 
L52:    iload_2 
L53:    ifeq L72 
L56:    aload_0 
L57:    getfield [28] 
L60:    invokevirtual [33] 
L63:    aload_0 
L64:    getfield [22] 
L67:    invokeinterface [52] 0 
L72:    aload_0 
L73:    iconst_0 
L74:    putfield [40] 
L77:    goto L100 
L80:    astore_2 
L81:    aload_0 
L82:    getfield [26] 
L85:    sipush 10000 
L88:    ldc [13] 
L90:    aload_2 
L91:    invokevirtual [30] 
L94:    pop 
L95:    aload_0 
L96:    iconst_0 
L97:    putfield [40] 
L100:   return 
L101:   nop 
L102:   nop 
L103:   nop 
L104:   
    .end code 
.end method 

.method public enum [256] : [257] 
    .attribute [243] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public interface [258] : [259] 
    .attribute [243] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [53] 
.const [3] = Int -2137614336 
.const [4] = String [54] 
.const [5] = Class [55] 
.const [6] = String [56] 
.const [7] = String [57] 
.const [8] = String [58] 
.const [9] = String [59] 
.const [10] = String [60] 
.const [11] = String [61] 
.const [12] = String [62] 
.const [13] = String [63] 
.const [14] = Class [64] 
.const [15] = Class [65] 
.const [16] = Class [66] 
.const [17] = Class [67] 
.const [18] = Class [68] 
.const [19] = Class [69] 
.const [20] = Class [70] 
.const [21] = Class [71] 
.const [22] = Field [72] [73] 
.const [23] = Field [74] [75] 
.const [24] = Field [76] [77] 
.const [25] = Method [78] [79] 
.const [26] = Field [80] [81] 
.const [27] = Field [82] [83] 
.const [28] = Field [84] [85] 
.const [29] = Method [86] [87] 
.const [30] = Method [88] [89] 
.const [31] = Method [90] [91] 
.const [32] = Field [92] [93] 
.const [33] = Method [94] [95] 
.const [34] = Method [96] [97] 
.const [35] = Method [98] [99] 
.const [36] = Method [100] [101] 
.const [37] = Method [102] [103] 
.const [38] = Field [104] [105] 
.const [39] = Field [106] [107] 
.const [40] = Field [108] [109] 
.const [41] = Field [110] [111] 
.const [42] = Class [112] 
.const [43] = Field [113] [114] 
.const [44] = Field [115] [116] 
.const [45] = InterfaceMethod [117] [118] 
.const [46] = InterfaceMethod [119] [120] 
.const [47] = InterfaceMethod [121] [122] 
.const [48] = Field [123] [124] 
.const [49] = InterfaceMethod [125] [126] 
.const [50] = InterfaceMethod [127] [128] 
.const [51] = InterfaceMethod [129] [130] 
.const [52] = InterfaceMethod [131] [132] 
.const [53] = Utf8 de/audi/atip/interapp/def/NullSystemTonePlayer 
.const [54] = Utf8 'NaviAudioHandler#setWavePlayer( %1 )' 
.const [55] = Utf8 java/lang/Exception 
.const [56] = Utf8 'NaviAudioHandler#setWavePlayer() - ERROR = %1' 
.const [57] = Utf8 'NaviAudioHandler#audioConnectionFadedIn() - isBeepToneRequested: %1, isBeepTonePlaying: %2' 
.const [58] = Utf8 'NaviAudioHandler#audioConnectionFadedIn() - ERROR = %1' 
.const [59] = Utf8 'NaviAudioHandler#requestBeepTone() - isBeepToneRequested: %1, isBeepTonePlaying: %2' 
.const [60] = Utf8 'NaviAudioHandler#requestBeepTone() - ERROR = %1' 
.const [61] = Utf8 'NaviAudioHandler#state( status: %2 ) - isBeepTonePlaying: %1' 
.const [62] = Utf8 'NaviAudioHandler#state() - isStreetViewAudioConnectionActive: %1' 
.const [63] = Utf8 'NaviAudioHandler#state() - ERROR = %1' 
.const [64] = Utf8 de/audi/tghu/navi/app/audio/NaviAudioHandler 
.const [65] = Utf8 java/lang/Object 
.const [66] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [67] = Utf8 de/audi/atip/log/LogChannel 
.const [68] = Utf8 de/audi/tghu/waveplayer/WavePlayer 
.const [69] = Utf8 de/audi/tghu/waveplayer/SystemTonePlayer 
.const [70] = Utf8 de/audi/tghu/navi/app/audio/AudioStateMachine 
.const [71] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [72] = Class [133] 
.const [73] = NameAndType [134] [135] 
.const [74] = Class [136] 
.const [75] = NameAndType [137] [138] 
.const [76] = Class [139] 
.const [77] = NameAndType [140] [141] 
.const [78] = Class [142] 
.const [79] = NameAndType [143] [144] 
.const [80] = Class [145] 
.const [81] = NameAndType [146] [147] 
.const [82] = Class [148] 
.const [83] = NameAndType [149] [150] 
.const [84] = Class [151] 
.const [85] = NameAndType [152] [153] 
.const [86] = Class [154] 
.const [87] = NameAndType [155] [156] 
.const [88] = Class [157] 
.const [89] = NameAndType [158] [159] 
.const [90] = Class [160] 
.const [91] = NameAndType [161] [162] 
.const [92] = Class [163] 
.const [93] = NameAndType [164] [165] 
.const [94] = Class [166] 
.const [95] = NameAndType [167] [168] 
.const [96] = Class [169] 
.const [97] = NameAndType [170] [171] 
.const [98] = Class [172] 
.const [99] = NameAndType [173] [174] 
.const [100] = Class [175] 
.const [101] = NameAndType [176] [177] 
.const [102] = Class [178] 
.const [103] = NameAndType [179] [180] 
.const [104] = Class [181] 
.const [105] = NameAndType [182] [183] 
.const [106] = Class [184] 
.const [107] = NameAndType [185] [186] 
.const [108] = Class [187] 
.const [109] = NameAndType [188] [189] 
.const [110] = Class [190] 
.const [111] = NameAndType [191] [192] 
.const [112] = Utf8 de/audi/atip/interapp/def/NullSystemTonePlayer 
.const [113] = Class [193] 
.const [114] = NameAndType [194] [195] 
.const [115] = Class [196] 
.const [116] = NameAndType [197] [198] 
.const [117] = Class [199] 
.const [118] = NameAndType [200] [201] 
.const [119] = Class [202] 
.const [120] = NameAndType [203] [204] 
.const [121] = Class [205] 
.const [122] = NameAndType [206] [207] 
.const [123] = Class [208] 
.const [124] = NameAndType [209] [210] 
.const [125] = Class [211] 
.const [126] = NameAndType [212] [213] 
.const [127] = Class [214] 
.const [128] = NameAndType [215] [216] 
.const [129] = Class [217] 
.const [130] = NameAndType [218] [219] 
.const [131] = Class [220] 
.const [132] = NameAndType [221] [222] 
.const [133] = Utf8 de/audi/tghu/navi/app/audio/NaviAudioHandler 
.const [134] = Utf8 audioConnectionType 
.const [135] = Utf8 I 
.const [136] = Utf8 de/audi/tghu/navi/app/audio/NaviAudioHandler 
.const [137] = Utf8 isBeepToneRequested 
.const [138] = Utf8 Z 
.const [139] = Utf8 de/audi/tghu/navi/app/audio/NaviAudioHandler 
.const [140] = Utf8 isBeepTonePlaying 
.const [141] = Utf8 Z 
.const [142] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [143] = Utf8 getNaviAudioLogChannel 
.const [144] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [145] = Utf8 de/audi/tghu/navi/app/audio/NaviAudioHandler 
.const [146] = Utf8 logChannel 
.const [147] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [148] = Utf8 de/audi/tghu/navi/app/audio/NaviAudioHandler 
.const [149] = Utf8 wavePlayer 
.const [150] = Utf8 Lde/audi/tghu/waveplayer/SystemTonePlayer; 
.const [151] = Utf8 de/audi/tghu/navi/app/audio/NaviAudioHandler 
.const [152] = Utf8 audioStateMachine 
.const [153] = Utf8 Lde/audi/tghu/navi/app/audio/AudioStateMachine; 
.const [154] = Utf8 de/audi/atip/log/LogChannel 
.const [155] = Utf8 log 
.const [156] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [157] = Utf8 de/audi/atip/log/LogChannel 
.const [158] = Utf8 log 
.const [159] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [160] = Utf8 de/audi/atip/log/LogChannel 
.const [161] = Utf8 log 
.const [162] = Utf8 (ILjava/lang/String;ZZ)V 
.const [163] = Utf8 de/audi/tghu/navi/app/audio/NaviAudioHandler 
.const [164] = Utf8 toneID 
.const [165] = Utf8 I 
.const [166] = Utf8 de/audi/tghu/navi/app/audio/AudioStateMachine 
.const [167] = Utf8 getAudioManagement 
.const [168] = Utf8 ()Lde/audi/atip/audio/HMIAudioService; 
.const [169] = Utf8 de/audi/atip/log/LogChannel 
.const [170] = Utf8 log 
.const [171] = Utf8 (ILjava/lang/String;ZJ)Z 
.const [172] = Utf8 de/audi/atip/log/LogChannel 
.const [173] = Utf8 log 
.const [174] = Utf8 (ILjava/lang/String;Z)Z 
.const [175] = Utf8 java/lang/Object 
.const [176] = Utf8 <init> 
.const [177] = Utf8 ()V 
.const [178] = Utf8 de/audi/atip/interapp/def/NullSystemTonePlayer 
.const [179] = Utf8 <init> 
.const [180] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [181] = Utf8 de/audi/tghu/navi/app/audio/NaviAudioHandler 
.const [182] = Utf8 audioConnectionType 
.const [183] = Utf8 I 
.const [184] = Utf8 de/audi/tghu/navi/app/audio/NaviAudioHandler 
.const [185] = Utf8 isBeepToneRequested 
.const [186] = Utf8 Z 
.const [187] = Utf8 de/audi/tghu/navi/app/audio/NaviAudioHandler 
.const [188] = Utf8 isBeepTonePlaying 
.const [189] = Utf8 Z 
.const [190] = Utf8 de/audi/tghu/navi/app/audio/NaviAudioHandler 
.const [191] = Utf8 logChannel 
.const [192] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [193] = Utf8 de/audi/tghu/navi/app/audio/NaviAudioHandler 
.const [194] = Utf8 wavePlayer 
.const [195] = Utf8 Lde/audi/tghu/waveplayer/SystemTonePlayer; 
.const [196] = Utf8 de/audi/tghu/navi/app/audio/NaviAudioHandler 
.const [197] = Utf8 audioStateMachine 
.const [198] = Utf8 Lde/audi/tghu/navi/app/audio/AudioStateMachine; 
.const [199] = Utf8 de/audi/tghu/waveplayer/WavePlayer 
.const [200] = Utf8 getSystemTonePlayer 
.const [201] = Utf8 ()Lde/audi/tghu/waveplayer/SystemTonePlayer; 
.const [202] = Utf8 de/audi/tghu/waveplayer/SystemTonePlayer 
.const [203] = Utf8 setListener 
.const [204] = Utf8 (Lde/audi/tghu/waveplayer/WavePlayerListener;)V 
.const [205] = Utf8 de/audi/tghu/waveplayer/SystemTonePlayer 
.const [206] = Utf8 removeListener 
.const [207] = Utf8 (Lde/audi/tghu/waveplayer/WavePlayerListener;)V 
.const [208] = Utf8 de/audi/tghu/navi/app/audio/NaviAudioHandler 
.const [209] = Utf8 toneID 
.const [210] = Utf8 I 
.const [211] = Utf8 de/audi/tghu/waveplayer/SystemTonePlayer 
.const [212] = Utf8 playTone 
.const [213] = Utf8 (II)V 
.const [214] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [215] = Utf8 requestAndFadeToConnection 
.const [216] = Utf8 (I)V 
.const [217] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [218] = Utf8 isActive 
.const [219] = Utf8 (I)Z 
.const [220] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [221] = Utf8 releaseConnection 
.const [222] = Utf8 (I)V 
.const [223] = Utf8 de/audi/tghu/navi/app/audio/NaviAudioHandler 
.const [224] = Class [223] 
.const [225] = Utf8 java/lang/Object 
.const [226] = Class [225] 
.const [227] = Utf8 de/audi/tghu/navi/app/audio/INaviAudioHandler 
.const [228] = Class [227] 
.const [229] = Utf8 audioConnectionType 
.const [230] = Utf8 I 
.const [231] = Utf8 logChannel 
.const [232] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [233] = Utf8 wavePlayer 
.const [234] = Utf8 Lde/audi/tghu/waveplayer/SystemTonePlayer; 
.const [235] = Utf8 isBeepToneRequested 
.const [236] = Utf8 Z 
.const [237] = Utf8 isBeepTonePlaying 
.const [238] = Utf8 Z 
.const [239] = Utf8 toneID 
.const [240] = Utf8 I 
.const [241] = Utf8 audioStateMachine 
.const [242] = Utf8 Lde/audi/tghu/navi/app/audio/AudioStateMachine; 
.const [243] = Utf8 Code 
.const [244] = Utf8 <init> 
.const [245] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;)V 
.const [246] = Utf8 setAudioStateMachine 
.const [247] = Utf8 (Lde/audi/tghu/navi/app/audio/AudioStateMachine;)V 
.const [248] = Utf8 setWavePlayer 
.const [249] = Utf8 (Lde/audi/tghu/waveplayer/WavePlayer;)V 
.const [250] = Utf8 audioConnectionFadedIn 
.const [251] = Utf8 ()V 
.const [252] = Utf8 requestBeepTone 
.const [253] = Utf8 (II)V 
.const [254] = Utf8 state 
.const [255] = Utf8 (I)V 
.const [256] = Utf8 playToneInfo 
.const [257] = Utf8 (I)V 
.const [258] = Utf8 isBeepTonePlaying 
.const [259] = Utf8 ()Z 
.end class 
