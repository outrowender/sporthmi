.version 50 0 
.class super [134] 
.super [136] 
.field final [137] [138] 
.field private [139] [140] 
.field private [141] [142] 
.field private final [143] [144] 
.field private final [145] [146] 
.field private final [147] [148] 

.method [150] : [151] 
    .attribute [149] .code stack 8 locals 0 
L0:     aload_0 
L1:     invokespecial [18] 
L4:     aload_0 
L5:     new [22] 
L8:     dup 
L9:     aload_0 
L10:    aconst_null 
L11:    invokespecial [19] 
L14:    putfield [23] 
L17:    aload_0 
L18:    new [24] 
L21:    dup 
L22:    invokespecial [20] 
L25:    putfield [25] 
L28:    aload_0 
L29:    new [26] 
L32:    dup 
L33:    ldc [5] 
L35:    ldc_w [1] 
L38:    iconst_0 
L39:    aload_0 
L40:    invokespecial [21] 
L43:    putfield [27] 
L46:    aload_0 
L47:    aload_1 
L48:    putfield [28] 
L51:    return 
L52:    
    .end code 
.end method 

.method [152] : [153] 
    .attribute [149] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     invokevirtual [14] 
L7:     aload_0 
L8:     getfield [12] 
L11:    invokevirtual [15] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method [154] : [155] 
    .attribute [149] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [11] 
L4:     dup 
L5:     astore_3 
L6:     monitorenter 
        .catch [0] from L7 to L21 using L24 
L7:     aload_0 
L8:     lload_1 
L9:     putfield [29] 
L12:    aload_0 
L13:    invokestatic [6] 
L16:    putfield [30] 
L19:    aload_3 
L20:    monitorexit 
L21:    goto L31 
        .catch [0] from L24 to L28 using L24 
L24:    astore 4 
L26:    aload_3 
L27:    monitorexit 
L28:    aload 4 
L30:    athrow 
L31:    return 
L32:    
    .end code 
.end method 

.method public [156] : [157] 
    .attribute [149] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [11] 
L4:     dup 
L5:     astore_1 
L6:     monitorenter 
        .catch [0] from L7 to L22 using L23 
L7:     aload_0 
L8:     getfield [16] 
L11:    invokestatic [6] 
L14:    ladd 
L15:    aload_0 
L16:    getfield [17] 
L19:    lsub 
L20:    aload_1 
L21:    monitorexit 
L22:    freturn 
        .catch [0] from L23 to L26 using L23 
L23:    astore_2 
L24:    aload_1 
L25:    monitorexit 
L26:    aload_2 
L27:    athrow 
L28:    
    .end code 
.end method 

.method public [158] : [159] 
    .attribute [149] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     invokevirtual [14] 
L7:     return 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [32] 
.const [3] = Class [33] 
.const [4] = Class [34] 
.const [5] = String [35] 
.const [6] = Method [36] [37] 
.const [7] = Class [38] 
.const [8] = Class [39] 
.const [9] = Class [40] 
.const [10] = Class [41] 
.const [11] = Field [42] [43] 
.const [12] = Field [44] [45] 
.const [13] = Field [46] [47] 
.const [14] = Method [48] [49] 
.const [15] = Method [50] [51] 
.const [16] = Field [52] [53] 
.const [17] = Field [54] [55] 
.const [18] = Method [56] [57] 
.const [19] = Method [58] [59] 
.const [20] = Method [60] [61] 
.const [21] = Method [62] [63] 
.const [22] = Class [64] 
.const [23] = Field [65] [66] 
.const [24] = Class [67] 
.const [25] = Field [68] [69] 
.const [26] = Class [70] 
.const [27] = Field [71] [72] 
.const [28] = Field [73] [74] 
.const [29] = Field [75] [76] 
.const [30] = Field [77] [78] 
.const [31] = Int 1625948160 
.const [32] = Utf8 de/audi/tuner/app/sdars/SDARSWatch$DsiUpListener 
.const [33] = Utf8 java/lang/Object 
.const [34] = Utf8 de/audi/atip/timer/Timer 
.const [35] = Utf8 watch 
.const [36] = Class [79] 
.const [37] = NameAndType [80] [81] 
.const [38] = Utf8 de/audi/tuner/app/sdars/SDARSWatch 
.const [39] = Utf8 de/audi/atip/timer/DefaultTimerListener 
.const [40] = Utf8 de/audi/tuner/app/sdars/SDARSTuner 
.const [41] = Utf8 java/lang/System 
.const [42] = Class [82] 
.const [43] = NameAndType [83] [84] 
.const [44] = Class [85] 
.const [45] = NameAndType [86] [87] 
.const [46] = Class [88] 
.const [47] = NameAndType [89] [90] 
.const [48] = Class [91] 
.const [49] = NameAndType [92] [93] 
.const [50] = Class [94] 
.const [51] = NameAndType [95] [96] 
.const [52] = Class [97] 
.const [53] = NameAndType [98] [99] 
.const [54] = Class [100] 
.const [55] = NameAndType [101] [102] 
.const [56] = Class [103] 
.const [57] = NameAndType [104] [105] 
.const [58] = Class [106] 
.const [59] = NameAndType [107] [108] 
.const [60] = Class [109] 
.const [61] = NameAndType [110] [111] 
.const [62] = Class [112] 
.const [63] = NameAndType [113] [114] 
.const [64] = Utf8 de/audi/tuner/app/sdars/SDARSWatch$DsiUpListener 
.const [65] = Class [115] 
.const [66] = NameAndType [116] [117] 
.const [67] = Utf8 java/lang/Object 
.const [68] = Class [118] 
.const [69] = NameAndType [119] [120] 
.const [70] = Utf8 de/audi/atip/timer/Timer 
.const [71] = Class [121] 
.const [72] = NameAndType [122] [123] 
.const [73] = Class [124] 
.const [74] = NameAndType [125] [126] 
.const [75] = Class [127] 
.const [76] = NameAndType [128] [129] 
.const [77] = Class [130] 
.const [78] = NameAndType [131] [132] 
.const [79] = Utf8 java/lang/System 
.const [80] = Utf8 currentTimeMillis 
.const [81] = Utf8 ()J 
.const [82] = Utf8 de/audi/tuner/app/sdars/SDARSWatch 
.const [83] = Utf8 mutex 
.const [84] = Utf8 Ljava/lang/Object; 
.const [85] = Utf8 de/audi/tuner/app/sdars/SDARSWatch 
.const [86] = Utf8 timer 
.const [87] = Utf8 Lde/audi/atip/timer/Timer; 
.const [88] = Utf8 de/audi/tuner/app/sdars/SDARSWatch 
.const [89] = Utf8 tuner 
.const [90] = Utf8 Lde/audi/tuner/app/sdars/SDARSTuner; 
.const [91] = Utf8 de/audi/tuner/app/sdars/SDARSTuner 
.const [92] = Utf8 askModuleTime 
.const [93] = Utf8 ()V 
.const [94] = Utf8 de/audi/atip/timer/Timer 
.const [95] = Utf8 start 
.const [96] = Utf8 ()V 
.const [97] = Utf8 de/audi/tuner/app/sdars/SDARSWatch 
.const [98] = Utf8 moduleTime 
.const [99] = Utf8 J 
.const [100] = Utf8 de/audi/tuner/app/sdars/SDARSWatch 
.const [101] = Utf8 systemTime 
.const [102] = Utf8 J 
.const [103] = Utf8 de/audi/atip/timer/DefaultTimerListener 
.const [104] = Utf8 <init> 
.const [105] = Utf8 ()V 
.const [106] = Utf8 de/audi/tuner/app/sdars/SDARSWatch$DsiUpListener 
.const [107] = Utf8 <init> 
.const [108] = Utf8 (Lde/audi/tuner/app/sdars/SDARSWatch;Lde/audi/tuner/app/sdars/SDARSWatch$1;)V 
.const [109] = Utf8 java/lang/Object 
.const [110] = Utf8 <init> 
.const [111] = Utf8 ()V 
.const [112] = Utf8 de/audi/atip/timer/Timer 
.const [113] = Utf8 <init> 
.const [114] = Utf8 (Ljava/lang/String;JZLde/audi/atip/timer/TimerListener;)V 
.const [115] = Utf8 de/audi/tuner/app/sdars/SDARSWatch 
.const [116] = Utf8 dsiUpListener 
.const [117] = Utf8 Lde/audi/tuner/app/sdars/dsi/SDARSDsiUpInfo; 
.const [118] = Utf8 de/audi/tuner/app/sdars/SDARSWatch 
.const [119] = Utf8 mutex 
.const [120] = Utf8 Ljava/lang/Object; 
.const [121] = Utf8 de/audi/tuner/app/sdars/SDARSWatch 
.const [122] = Utf8 timer 
.const [123] = Utf8 Lde/audi/atip/timer/Timer; 
.const [124] = Utf8 de/audi/tuner/app/sdars/SDARSWatch 
.const [125] = Utf8 tuner 
.const [126] = Utf8 Lde/audi/tuner/app/sdars/SDARSTuner; 
.const [127] = Utf8 de/audi/tuner/app/sdars/SDARSWatch 
.const [128] = Utf8 moduleTime 
.const [129] = Utf8 J 
.const [130] = Utf8 de/audi/tuner/app/sdars/SDARSWatch 
.const [131] = Utf8 systemTime 
.const [132] = Utf8 J 
.const [133] = Utf8 de/audi/tuner/app/sdars/SDARSWatch 
.const [134] = Class [133] 
.const [135] = Utf8 de/audi/atip/timer/DefaultTimerListener 
.const [136] = Class [135] 
.const [137] = Utf8 dsiUpListener 
.const [138] = Utf8 Lde/audi/tuner/app/sdars/dsi/SDARSDsiUpInfo; 
.const [139] = Utf8 moduleTime 
.const [140] = Utf8 J 
.const [141] = Utf8 systemTime 
.const [142] = Utf8 J 
.const [143] = Utf8 mutex 
.const [144] = Utf8 Ljava/lang/Object; 
.const [145] = Utf8 tuner 
.const [146] = Utf8 Lde/audi/tuner/app/sdars/SDARSTuner; 
.const [147] = Utf8 timer 
.const [148] = Utf8 Lde/audi/atip/timer/Timer; 
.const [149] = Utf8 Code 
.const [150] = Utf8 <init> 
.const [151] = Utf8 (Lde/audi/tuner/app/sdars/SDARSTuner;)V 
.const [152] = Utf8 init 
.const [153] = Utf8 ()V 
.const [154] = Utf8 updateModuleTime 
.const [155] = Utf8 (J)V 
.const [156] = Utf8 getCurentTime 
.const [157] = Utf8 ()J 
.const [158] = Utf8 fireTimer 
.const [159] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.end class 
