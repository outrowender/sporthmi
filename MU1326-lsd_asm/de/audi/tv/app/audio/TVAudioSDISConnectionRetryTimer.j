.version 50 0 
.class public super [135] 
.super [137] 
.implements [139] 
.implements [141] 
.field static final [142] [143] 
.field static final [144] [145] 
.field private static final [146] [147] 
.field static final [148] [149] 
.field private final [150] [151] 
.field private final [152] [153] 
.field private final [154] [155] 
.field private volatile [156] [157] 

.method [159] : [160] 
    .attribute [158] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [29] 
L9:     aload_0 
L10:    aload_3 
L11:    putfield [30] 
L14:    aload_0 
L15:    aload_1 
L16:    putfield [31] 
L19:    aload_0 
L20:    aload_2 
L21:    putfield [32] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [161] : [162] 
    .attribute [158] .code stack 8 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [29] 
L9:     aload_0 
L10:    new [33] 
L13:    dup 
L14:    ldc [3] 
L16:    ldc_w [1] 
L19:    iconst_1 
L20:    aload_0 
L21:    invokespecial [27] 
L24:    putfield [30] 
L27:    aload_0 
L28:    aload_1 
L29:    putfield [31] 
L32:    aload_0 
L33:    aload_2 
L34:    putfield [32] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [163] : [164] 
    .attribute [158] .code stack 7 locals 0 
L0:     aload_0 
L1:     dup 
L2:     getfield [16] 
L5:     iconst_1 
L6:     iadd 
L7:     putfield [29] 
L10:    aload_0 
L11:    getfield [19] 
L14:    ldc [4] 
L16:    ldc [5] 
L18:    aload_0 
L19:    getfield [16] 
L22:    i2l 
L23:    ldc_w [1] 
L26:    invokevirtual [20] 
L29:    pop 
L30:    aload_0 
L31:    getfield [18] 
L34:    sipush 307 
L37:    iconst_2 
L38:    invokevirtual [21] 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [165] : [166] 
    .attribute [158] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [6] 
L6:     ldc [7] 
L8:     invokevirtual [22] 
L11:    pop 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method private [167] : [168] 
    .attribute [158] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [6] 
L6:     ldc [8] 
L8:     invokevirtual [22] 
L11:    pop 
L12:    aload_0 
L13:    iconst_0 
L14:    putfield [29] 
L17:    aload_0 
L18:    getfield [17] 
L21:    invokevirtual [23] 
L24:    pop 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [169] : [170] 
    .attribute [158] .code stack 2 locals 0 
L0:     iload_1 
L1:     sipush 307 
L4:     if_icmpne L16 
L7:     iload_2 
L8:     iconst_2 
L9:     if_icmpne L16 
L12:    aload_0 
L13:    invokespecial [28] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [171] : [172] 
    .attribute [158] .code stack 2 locals 0 
L0:     iload_1 
L1:     sipush 307 
L4:     if_icmpne L16 
L7:     iload_2 
L8:     iconst_2 
L9:     if_icmpne L16 
L12:    aload_0 
L13:    invokespecial [28] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [173] : [174] 
    .attribute [158] .code stack 9 locals 0 
L0:     iload_1 
L1:     sipush 307 
L4:     if_icmpne L98 
L7:     iload_2 
L8:     iconst_2 
L9:     if_icmpne L98 
L12:    iload_3 
L13:    iconst_3 
L14:    if_icmpne L98 
L17:    aload_0 
L18:    getfield [19] 
L21:    ldc [4] 
L23:    ldc [9] 
L25:    iload_1 
L26:    i2l 
L27:    iload_2 
L28:    i2l 
L29:    iload_3 
L30:    i2l 
L31:    invokevirtual [24] 
L34:    pop 
L35:    aload_0 
L36:    getfield [16] 
L39:    iconst_3 
L40:    if_icmplt L73 
L43:    aload_0 
L44:    getfield [19] 
L47:    sipush 10000 
L50:    ldc [10] 
L52:    iload_1 
L53:    i2l 
L54:    iload_2 
L55:    i2l 
L56:    iload_3 
L57:    i2l 
L58:    invokevirtual [24] 
L61:    pop 
L62:    aload_0 
L63:    getfield [17] 
L66:    invokevirtual [23] 
L69:    pop 
L70:    goto L98 
L73:    aload_0 
L74:    getfield [19] 
L77:    ldc [6] 
L79:    ldc [11] 
L81:    iload_1 
L82:    i2l 
L83:    iload_2 
L84:    i2l 
L85:    iload_3 
L86:    i2l 
L87:    invokevirtual [24] 
L90:    pop 
L91:    aload_0 
L92:    getfield [17] 
L95:    invokevirtual [25] 
L98:    return 
L99:    nop 
L100:   
    .end code 
.end method 

.method public enum [175] : [176] 
    .attribute [158] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [177] : [178] 
    .attribute [158] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [179] : [180] 
    .attribute [158] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [181] : [182] 
    .attribute [158] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [36] 
.const [3] = String [37] 
.const [4] = Int -1601830656 
.const [5] = String [38] 
.const [6] = Int 1078071040 
.const [7] = String [39] 
.const [8] = String [40] 
.const [9] = String [41] 
.const [10] = String [42] 
.const [11] = String [43] 
.const [12] = Class [44] 
.const [13] = Class [45] 
.const [14] = Class [46] 
.const [15] = Class [47] 
.const [16] = Field [48] [49] 
.const [17] = Field [50] [51] 
.const [18] = Field [52] [53] 
.const [19] = Field [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Method [58] [59] 
.const [22] = Method [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Method [64] [65] 
.const [25] = Method [66] [67] 
.const [26] = Method [68] [69] 
.const [27] = Method [70] [71] 
.const [28] = Method [72] [73] 
.const [29] = Field [74] [75] 
.const [30] = Field [76] [77] 
.const [31] = Field [78] [79] 
.const [32] = Field [80] [81] 
.const [33] = Class [82] 
.const [34] = Int 738263040 
.const [35] = Int 50331648 
.const [36] = Utf8 de/audi/atip/timer/Timer 
.const [37] = Utf8 SDISAudioConnectionRetryTimer 
.const [38] = Utf8 '[SDISAudioConnectionRetryTimer.fireTimer] Retry to request connection (%1/%2).' 
.const [39] = Utf8 '[SDISAudioConnectionRetryTimer.cancelTimer] Timer cancelled.' 
.const [40] = Utf8 '[SDISAudioConnectionRetryTimer.resetTimer]' 
.const [41] = Utf8 "[SDISAudioConnectionRetryTimer.errorConnection] connection:'%1', terminal:'2', errorCode:'%3'." 
.const [42] = Utf8 '[SDISAudioConnectionRetryTimer.errorConnection] Connection could not be started. No more retries.' 
.const [43] = Utf8 '[SDISAudioConnectionRetryTimer.errorConnection] Trigger next retry. Start the timer.' 
.const [44] = Utf8 de/audi/tv/app/audio/TVAudioSDISConnectionRetryTimer 
.const [45] = Utf8 java/lang/Object 
.const [46] = Utf8 de/audi/atip/log/LogChannel 
.const [47] = Utf8 de/audi/tv/app/audio/TVAudioService 
.const [48] = Class [83] 
.const [49] = NameAndType [84] [85] 
.const [50] = Class [86] 
.const [51] = NameAndType [87] [88] 
.const [52] = Class [89] 
.const [53] = NameAndType [90] [91] 
.const [54] = Class [92] 
.const [55] = NameAndType [93] [94] 
.const [56] = Class [95] 
.const [57] = NameAndType [96] [97] 
.const [58] = Class [98] 
.const [59] = NameAndType [99] [100] 
.const [60] = Class [101] 
.const [61] = NameAndType [102] [103] 
.const [62] = Class [104] 
.const [63] = NameAndType [105] [106] 
.const [64] = Class [107] 
.const [65] = NameAndType [108] [109] 
.const [66] = Class [110] 
.const [67] = NameAndType [111] [112] 
.const [68] = Class [113] 
.const [69] = NameAndType [114] [115] 
.const [70] = Class [116] 
.const [71] = NameAndType [117] [118] 
.const [72] = Class [119] 
.const [73] = NameAndType [120] [121] 
.const [74] = Class [122] 
.const [75] = NameAndType [123] [124] 
.const [76] = Class [125] 
.const [77] = NameAndType [126] [127] 
.const [78] = Class [128] 
.const [79] = NameAndType [129] [130] 
.const [80] = Class [131] 
.const [81] = NameAndType [132] [133] 
.const [82] = Utf8 de/audi/atip/timer/Timer 
.const [83] = Utf8 de/audi/tv/app/audio/TVAudioSDISConnectionRetryTimer 
.const [84] = Utf8 retryCount 
.const [85] = Utf8 I 
.const [86] = Utf8 de/audi/tv/app/audio/TVAudioSDISConnectionRetryTimer 
.const [87] = Utf8 retryTimer 
.const [88] = Utf8 Lde/audi/atip/timer/Timer; 
.const [89] = Utf8 de/audi/tv/app/audio/TVAudioSDISConnectionRetryTimer 
.const [90] = Utf8 tvAudioService 
.const [91] = Utf8 Lde/audi/tv/app/audio/TVAudioService; 
.const [92] = Utf8 de/audi/tv/app/audio/TVAudioSDISConnectionRetryTimer 
.const [93] = Utf8 logger 
.const [94] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [95] = Utf8 de/audi/atip/log/LogChannel 
.const [96] = Utf8 log 
.const [97] = Utf8 (ILjava/lang/String;JJ)Z 
.const [98] = Utf8 de/audi/tv/app/audio/TVAudioService 
.const [99] = Utf8 requestConnection 
.const [100] = Utf8 (II)V 
.const [101] = Utf8 de/audi/atip/log/LogChannel 
.const [102] = Utf8 log 
.const [103] = Utf8 (ILjava/lang/String;)Z 
.const [104] = Utf8 de/audi/atip/timer/Timer 
.const [105] = Utf8 cancel 
.const [106] = Utf8 ()Z 
.const [107] = Utf8 de/audi/atip/log/LogChannel 
.const [108] = Utf8 log 
.const [109] = Utf8 (ILjava/lang/String;JJJ)Z 
.const [110] = Utf8 de/audi/atip/timer/Timer 
.const [111] = Utf8 start 
.const [112] = Utf8 ()V 
.const [113] = Utf8 java/lang/Object 
.const [114] = Utf8 <init> 
.const [115] = Utf8 ()V 
.const [116] = Utf8 de/audi/atip/timer/Timer 
.const [117] = Utf8 <init> 
.const [118] = Utf8 (Ljava/lang/String;JZLde/audi/atip/timer/TimerListener;)V 
.const [119] = Utf8 de/audi/tv/app/audio/TVAudioSDISConnectionRetryTimer 
.const [120] = Utf8 resetTimer 
.const [121] = Utf8 ()V 
.const [122] = Utf8 de/audi/tv/app/audio/TVAudioSDISConnectionRetryTimer 
.const [123] = Utf8 retryCount 
.const [124] = Utf8 I 
.const [125] = Utf8 de/audi/tv/app/audio/TVAudioSDISConnectionRetryTimer 
.const [126] = Utf8 retryTimer 
.const [127] = Utf8 Lde/audi/atip/timer/Timer; 
.const [128] = Utf8 de/audi/tv/app/audio/TVAudioSDISConnectionRetryTimer 
.const [129] = Utf8 tvAudioService 
.const [130] = Utf8 Lde/audi/tv/app/audio/TVAudioService; 
.const [131] = Utf8 de/audi/tv/app/audio/TVAudioSDISConnectionRetryTimer 
.const [132] = Utf8 logger 
.const [133] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [134] = Utf8 de/audi/tv/app/audio/TVAudioSDISConnectionRetryTimer 
.const [135] = Class [134] 
.const [136] = Utf8 java/lang/Object 
.const [137] = Class [136] 
.const [138] = Utf8 de/audi/atip/audio/HMIAudioServiceListener 
.const [139] = Class [138] 
.const [140] = Utf8 de/audi/atip/timer/TimerListener 
.const [141] = Class [140] 
.const [142] = Utf8 AUDIO_TERMINAL_ID 
.const [143] = Utf8 I 
.const [144] = Utf8 CONNECTION_ID 
.const [145] = Utf8 I 
.const [146] = Utf8 RETRY_TIMEOUT 
.const [147] = Utf8 I 
.const [148] = Utf8 MAX_RETRY_COUNT 
.const [149] = Utf8 I 
.const [150] = Utf8 retryTimer 
.const [151] = Utf8 Lde/audi/atip/timer/Timer; 
.const [152] = Utf8 tvAudioService 
.const [153] = Utf8 Lde/audi/tv/app/audio/TVAudioService; 
.const [154] = Utf8 logger 
.const [155] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [156] = Utf8 retryCount 
.const [157] = Utf8 I 
.const [158] = Utf8 Code 
.const [159] = Utf8 <init> 
.const [160] = Utf8 (Lde/audi/tv/app/audio/TVAudioService;Lde/audi/atip/log/LogChannel;Lde/audi/atip/timer/Timer;)V 
.const [161] = Utf8 <init> 
.const [162] = Utf8 (Lde/audi/tv/app/audio/TVAudioService;Lde/audi/atip/log/LogChannel;)V 
.const [163] = Utf8 fireTimer 
.const [164] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.const [165] = Utf8 cancelTimer 
.const [166] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.const [167] = Utf8 resetTimer 
.const [168] = Utf8 ()V 
.const [169] = Utf8 stopConnection 
.const [170] = Utf8 (II)V 
.const [171] = Utf8 startConnection 
.const [172] = Utf8 (II)V 
.const [173] = Utf8 errorConnection 
.const [174] = Utf8 (III)V 
.const [175] = Utf8 pauseConnection 
.const [176] = Utf8 (II)V 
.const [177] = Utf8 updateAMAvailable 
.const [178] = Utf8 (Z)V 
.const [179] = Utf8 fadedIn 
.const [180] = Utf8 (II)V 
.const [181] = Utf8 updateVolumeLock 
.const [182] = Utf8 (IIZ)V 
.end class 
