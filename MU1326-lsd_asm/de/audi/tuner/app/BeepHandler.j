.version 50 0 
.class public super [166] 
.super [168] 
.field final [169] [170] 
.field private [171] [172] 
.field private [173] [174] 
.field private final [175] [176] 
.field private final [177] [178] 

.method [180] : [181] 
    .attribute [179] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [27] 
L4:     aload_0 
L5:     new [33] 
L8:     dup 
L9:     aload_0 
L10:    aconst_null 
L11:    invokespecial [28] 
L14:    putfield [34] 
L17:    aload_0 
L18:    iconst_0 
L19:    putfield [32] 
L22:    aload_0 
L23:    aload_1 
L24:    putfield [31] 
L27:    aload_0 
L28:    aload_2 
L29:    putfield [35] 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method [182] : [183] 
    .attribute [179] .code stack 5 locals 0 
L0:     aload_1 
L1:     ifnull L37 
L4:     aload_0 
L5:     getfield [16] 
L8:     getfield [19] 
L11:    ldc [3] 
L13:    ldc [4] 
L15:    invokevirtual [20] 
L18:    pop 
L19:    aload_1 
L20:    new [36] 
L23:    dup 
L24:    aload_0 
L25:    aconst_null 
L26:    invokespecial [29] 
L29:    invokeinterface [37] 0 
L34:    goto L52 
L37:    aload_0 
L38:    getfield [16] 
L41:    getfield [19] 
L44:    ldc [3] 
L46:    ldc [6] 
L48:    invokevirtual [20] 
L51:    pop 
L52:    aload_0 
L53:    aload_1 
L54:    putfield [38] 
L57:    return 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [184] : [185] 
    .attribute [179] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [30] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [186] : [187] 
    .attribute [179] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [21] 
L4:     ifnull L47 
        .catch [7] from L7 to L19 using L22 
L7:     aload_0 
L8:     getfield [21] 
L11:    iconst_0 
L12:    bipush 14 
L14:    invokeinterface [39] 0 
L19:    goto L67 
L22:    astore_1 
L23:    aload_0 
L24:    getfield [16] 
L27:    getfield [19] 
L30:    sipush 10000 
L33:    ldc [8] 
L35:    aload_1 
L36:    invokevirtual [22] 
L39:    pop 
L40:    aload_0 
L41:    invokespecial [25] 
L44:    goto L67 
L47:    aload_0 
L48:    getfield [16] 
L51:    getfield [19] 
L54:    sipush 10000 
L57:    ldc [9] 
L59:    invokevirtual [20] 
L62:    pop 
L63:    aload_0 
L64:    invokespecial [25] 
L67:    return 
L68:    
    .end code 
.end method 

.method private [188] : [189] 
    .attribute [179] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     bipush 120 
L6:     invokevirtual [23] 
L9:     aload_0 
L10:    iconst_1 
L11:    putfield [32] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method private [190] : [191] 
    .attribute [179] .code stack 3 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [32] 
L5:     aload_0 
L6:     getfield [18] 
L9:     bipush 120 
L11:    iconst_0 
L12:    invokevirtual [24] 
L15:    return 
L16:    
    .end code 
.end method 

.method static synthetic [192] : [193] 
    .attribute [179] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [194] : [195] 
    .attribute [179] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [196] : [197] 
    .attribute [179] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [198] : [199] 
    .attribute [179] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [40] 
.const [3] = Int -2137614336 
.const [4] = String [41] 
.const [5] = Class [42] 
.const [6] = String [43] 
.const [7] = Class [44] 
.const [8] = String [45] 
.const [9] = String [46] 
.const [10] = Class [47] 
.const [11] = Class [48] 
.const [12] = Class [49] 
.const [13] = Class [50] 
.const [14] = Class [51] 
.const [15] = Class [52] 
.const [16] = Field [53] [54] 
.const [17] = Field [55] [56] 
.const [18] = Field [57] [58] 
.const [19] = Field [59] [60] 
.const [20] = Method [61] [62] 
.const [21] = Field [63] [64] 
.const [22] = Method [65] [66] 
.const [23] = Method [67] [68] 
.const [24] = Method [69] [70] 
.const [25] = Method [71] [72] 
.const [26] = Method [73] [74] 
.const [27] = Method [75] [76] 
.const [28] = Method [77] [78] 
.const [29] = Method [79] [80] 
.const [30] = Method [81] [82] 
.const [31] = Field [83] [84] 
.const [32] = Field [85] [86] 
.const [33] = Class [87] 
.const [34] = Field [88] [89] 
.const [35] = Field [90] [91] 
.const [36] = Class [92] 
.const [37] = InterfaceMethod [93] [94] 
.const [38] = Field [95] [96] 
.const [39] = InterfaceMethod [97] [98] 
.const [40] = Utf8 de/audi/tuner/app/BeepHandler$AudioListener 
.const [41] = Utf8 'register System Tone Player' 
.const [42] = Utf8 de/audi/tuner/app/BeepHandler$MyWavePlayerListener 
.const [43] = Utf8 'unregister System Tone Player' 
.const [44] = Utf8 java/lang/Exception 
.const [45] = Utf8 '[BeepHandler.playBeep]' 
.const [46] = Utf8 'SystemTonePlayer is null!' 
.const [47] = Utf8 de/audi/tuner/app/BeepHandler 
.const [48] = Utf8 java/lang/Object 
.const [49] = Utf8 de/audi/tuner/app/Logger 
.const [50] = Utf8 de/audi/atip/log/LogChannel 
.const [51] = Utf8 de/audi/tghu/waveplayer/SystemTonePlayer 
.const [52] = Utf8 de/audi/tuner/app/TunerAudioMgmt 
.const [53] = Class [99] 
.const [54] = NameAndType [100] [101] 
.const [55] = Class [102] 
.const [56] = NameAndType [103] [104] 
.const [57] = Class [105] 
.const [58] = NameAndType [106] [107] 
.const [59] = Class [108] 
.const [60] = NameAndType [109] [110] 
.const [61] = Class [111] 
.const [62] = NameAndType [112] [113] 
.const [63] = Class [114] 
.const [64] = NameAndType [115] [116] 
.const [65] = Class [117] 
.const [66] = NameAndType [118] [119] 
.const [67] = Class [120] 
.const [68] = NameAndType [121] [122] 
.const [69] = Class [123] 
.const [70] = NameAndType [124] [125] 
.const [71] = Class [126] 
.const [72] = NameAndType [127] [128] 
.const [73] = Class [129] 
.const [74] = NameAndType [130] [131] 
.const [75] = Class [132] 
.const [76] = NameAndType [133] [134] 
.const [77] = Class [135] 
.const [78] = NameAndType [136] [137] 
.const [79] = Class [138] 
.const [80] = NameAndType [139] [140] 
.const [81] = Class [141] 
.const [82] = NameAndType [142] [143] 
.const [83] = Class [144] 
.const [84] = NameAndType [145] [146] 
.const [85] = Class [147] 
.const [86] = NameAndType [148] [149] 
.const [87] = Utf8 de/audi/tuner/app/BeepHandler$AudioListener 
.const [88] = Class [150] 
.const [89] = NameAndType [151] [152] 
.const [90] = Class [153] 
.const [91] = NameAndType [154] [155] 
.const [92] = Utf8 de/audi/tuner/app/BeepHandler$MyWavePlayerListener 
.const [93] = Class [156] 
.const [94] = NameAndType [157] [158] 
.const [95] = Class [159] 
.const [96] = NameAndType [160] [161] 
.const [97] = Class [162] 
.const [98] = NameAndType [163] [164] 
.const [99] = Utf8 de/audi/tuner/app/BeepHandler 
.const [100] = Utf8 logger 
.const [101] = Utf8 Lde/audi/tuner/app/Logger; 
.const [102] = Utf8 de/audi/tuner/app/BeepHandler 
.const [103] = Utf8 systemToneRequested 
.const [104] = Utf8 Z 
.const [105] = Utf8 de/audi/tuner/app/BeepHandler 
.const [106] = Utf8 audio 
.const [107] = Utf8 Lde/audi/tuner/app/TunerAudioMgmt; 
.const [108] = Utf8 de/audi/tuner/app/Logger 
.const [109] = Utf8 hmi 
.const [110] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [111] = Utf8 de/audi/atip/log/LogChannel 
.const [112] = Utf8 log 
.const [113] = Utf8 (ILjava/lang/String;)Z 
.const [114] = Utf8 de/audi/tuner/app/BeepHandler 
.const [115] = Utf8 systemTone 
.const [116] = Utf8 Lde/audi/tghu/waveplayer/SystemTonePlayer; 
.const [117] = Utf8 de/audi/atip/log/LogChannel 
.const [118] = Utf8 log 
.const [119] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [120] = Utf8 de/audi/tuner/app/TunerAudioMgmt 
.const [121] = Utf8 requestAndFadeIn 
.const [122] = Utf8 (I)V 
.const [123] = Utf8 de/audi/tuner/app/TunerAudioMgmt 
.const [124] = Utf8 releaseAudioChannel 
.const [125] = Utf8 (II)V 
.const [126] = Utf8 de/audi/tuner/app/BeepHandler 
.const [127] = Utf8 releaseAudio 
.const [128] = Utf8 ()V 
.const [129] = Utf8 de/audi/tuner/app/BeepHandler 
.const [130] = Utf8 playBeep 
.const [131] = Utf8 ()V 
.const [132] = Utf8 java/lang/Object 
.const [133] = Utf8 <init> 
.const [134] = Utf8 ()V 
.const [135] = Utf8 de/audi/tuner/app/BeepHandler$AudioListener 
.const [136] = Utf8 <init> 
.const [137] = Utf8 (Lde/audi/tuner/app/BeepHandler;Lde/audi/tuner/app/BeepHandler$1;)V 
.const [138] = Utf8 de/audi/tuner/app/BeepHandler$MyWavePlayerListener 
.const [139] = Utf8 <init> 
.const [140] = Utf8 (Lde/audi/tuner/app/BeepHandler;Lde/audi/tuner/app/BeepHandler$1;)V 
.const [141] = Utf8 de/audi/tuner/app/BeepHandler 
.const [142] = Utf8 requestAudio 
.const [143] = Utf8 ()V 
.const [144] = Utf8 de/audi/tuner/app/BeepHandler 
.const [145] = Utf8 logger 
.const [146] = Utf8 Lde/audi/tuner/app/Logger; 
.const [147] = Utf8 de/audi/tuner/app/BeepHandler 
.const [148] = Utf8 systemToneRequested 
.const [149] = Utf8 Z 
.const [150] = Utf8 de/audi/tuner/app/BeepHandler 
.const [151] = Utf8 audioInfoListener 
.const [152] = Utf8 Lde/audi/tuner/app/AudioInfo; 
.const [153] = Utf8 de/audi/tuner/app/BeepHandler 
.const [154] = Utf8 audio 
.const [155] = Utf8 Lde/audi/tuner/app/TunerAudioMgmt; 
.const [156] = Utf8 de/audi/tghu/waveplayer/SystemTonePlayer 
.const [157] = Utf8 setListener 
.const [158] = Utf8 (Lde/audi/tghu/waveplayer/WavePlayerListener;)V 
.const [159] = Utf8 de/audi/tuner/app/BeepHandler 
.const [160] = Utf8 systemTone 
.const [161] = Utf8 Lde/audi/tghu/waveplayer/SystemTonePlayer; 
.const [162] = Utf8 de/audi/tghu/waveplayer/SystemTonePlayer 
.const [163] = Utf8 playTone 
.const [164] = Utf8 (II)V 
.const [165] = Utf8 de/audi/tuner/app/BeepHandler 
.const [166] = Class [165] 
.const [167] = Utf8 java/lang/Object 
.const [168] = Class [167] 
.const [169] = Utf8 audioInfoListener 
.const [170] = Utf8 Lde/audi/tuner/app/AudioInfo; 
.const [171] = Utf8 systemToneRequested 
.const [172] = Utf8 Z 
.const [173] = Utf8 systemTone 
.const [174] = Utf8 Lde/audi/tghu/waveplayer/SystemTonePlayer; 
.const [175] = Utf8 logger 
.const [176] = Utf8 Lde/audi/tuner/app/Logger; 
.const [177] = Utf8 audio 
.const [178] = Utf8 Lde/audi/tuner/app/TunerAudioMgmt; 
.const [179] = Utf8 Code 
.const [180] = Utf8 <init> 
.const [181] = Utf8 (Lde/audi/tuner/app/Logger;Lde/audi/tuner/app/TunerAudioMgmt;)V 
.const [182] = Utf8 registerSystemTonePlayer 
.const [183] = Utf8 (Lde/audi/tghu/waveplayer/SystemTonePlayer;)V 
.const [184] = Utf8 requestAndFadeInBeep 
.const [185] = Utf8 ()V 
.const [186] = Utf8 playBeep 
.const [187] = Utf8 ()V 
.const [188] = Utf8 requestAudio 
.const [189] = Utf8 ()V 
.const [190] = Utf8 releaseAudio 
.const [191] = Utf8 ()V 
.const [192] = Utf8 access$200 
.const [193] = Utf8 (Lde/audi/tuner/app/BeepHandler;)Z 
.const [194] = Utf8 access$300 
.const [195] = Utf8 (Lde/audi/tuner/app/BeepHandler;)Lde/audi/tuner/app/Logger; 
.const [196] = Utf8 access$400 
.const [197] = Utf8 (Lde/audi/tuner/app/BeepHandler;)V 
.const [198] = Utf8 access$500 
.const [199] = Utf8 (Lde/audi/tuner/app/BeepHandler;)V 
.end class 
