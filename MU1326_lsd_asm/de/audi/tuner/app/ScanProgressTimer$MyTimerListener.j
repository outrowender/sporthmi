.version 50 0 
.class super [228] 
.super [230] 
.field private final [231] [232] 
.field private static final [233] [234] 
.field private final [235] [236] 
.field private [237] [238] 
.field private final [239] [240] 
.field private final [241] [242] 
.field private final [243] [244] 
.field private final [245] [246] 
.field private final synthetic [247] [248] 

.method public [250] : [251] 
    .attribute [249] .code stack 8 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [35] 
L5:     aload_0 
L6:     invokespecial [31] 
L9:     aload_0 
L10:    invokestatic [2] 
L13:    ifeq L21 
L16:    bipush 40 
L18:    goto L22 
L21:    iconst_1 
L22:    putfield [36] 
L25:    aload_0 
L26:    new [37] 
L29:    dup 
L30:    ldc [4] 
L32:    sipush 9600 
L35:    aload_0 
L36:    getfield [20] 
L39:    idiv 
L40:    i2l 
L41:    iconst_0 
L42:    aload_0 
L43:    invokespecial [32] 
L46:    putfield [38] 
L49:    aload_0 
L50:    iconst_0 
L51:    putfield [39] 
L54:    aload_0 
L55:    ldc [5] 
L57:    putfield [40] 
L60:    aload_0 
L61:    aload_2 
L62:    putfield [41] 
L65:    aload_0 
L66:    aload_3 
L67:    putfield [42] 
L70:    aload_0 
L71:    aload 4 
L73:    putfield [43] 
L76:    aload_0 
L77:    getfield [25] 
L80:    aload_0 
L81:    ldc2_w [49] 
L84:    invokestatic [6] 
L87:    l2i 
L88:    i2l 
L89:    invokespecial [33] 
L92:    invokeinterface [44] 0 
L97:    aload_2 
L98:    iconst_0 
L99:    aload_0 
L100:   getfield [20] 
L103:   iconst_1 
L104:   invokeinterface [45] 0 
L109:   return 
L110:   nop 
L111:   nop 
L112:   
    .end code 
.end method 

.method public [252] : [253] 
    .attribute [249] .code stack 4 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [39] 
L5:     aload_0 
L6:     getfield [23] 
L9:     iconst_0 
L10:    invokeinterface [46] 0 
L15:    aload_0 
L16:    getfield [24] 
L19:    aload_0 
L20:    lconst_0 
L21:    invokespecial [33] 
L24:    invokeinterface [44] 0 
L29:    aload_0 
L30:    getfield [21] 
L33:    invokevirtual [26] 
L36:    return 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [254] : [255] 
    .attribute [249] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     aload_0 
L5:     lconst_0 
L6:     invokespecial [33] 
L9:     invokeinterface [44] 0 
L14:    aload_0 
L15:    getfield [21] 
L18:    invokevirtual [27] 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [256] : [257] 
    .attribute [249] .code stack 6 locals 3 
L0:     aload_0 
L1:     getfield [23] 
L4:     aload_0 
L5:     dup 
L6:     getfield [22] 
L9:     iconst_1 
L10:    iadd 
L11:    dup_x1 
L12:    putfield [39] 
L15:    invokeinterface [46] 0 
L20:    aload_0 
L21:    getfield [22] 
L24:    i2d 
L25:    ldc2_w [51] 
L28:    aload_0 
L29:    getfield [20] 
L32:    i2d 
L33:    ddiv 
L34:    ldc2_w [53] 
L37:    ddiv 
L38:    dmul 
L39:    d2l 
L40:    lstore_2 
L41:    aload_0 
L42:    lload_2 
L43:    invokespecial [33] 
L46:    astore 4 
L48:    aload_0 
L49:    getfield [24] 
L52:    aload 4 
L54:    invokeinterface [44] 0 
L59:    aload_0 
L60:    getfield [22] 
L63:    aload_0 
L64:    getfield [20] 
L67:    if_icmplt L88 
L70:    aload_1 
L71:    invokevirtual [27] 
L74:    pop 
L75:    aload_0 
L76:    getfield [19] 
L79:    invokestatic [7] 
L82:    aconst_null 
L83:    invokeinterface [47] 0 
L88:    return 
L89:    nop 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method private [258] : [259] 
    .attribute [249] .code stack 4 locals 1 
L0:     lload_1 
L1:     ldc_w [1] 
L4:     lcmp 
L5:     ifge L13 
L8:     ldc [8] 
L10:    goto L15 
L13:    ldc [9] 
L15:    astore_3 
L16:    new [48] 
L19:    dup 
L20:    ldc [5] 
L22:    invokespecial [34] 
L25:    aload_3 
L26:    invokevirtual [28] 
L29:    lload_1 
L30:    invokevirtual [29] 
L33:    invokevirtual [30] 
L36:    areturn 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [56] [57] 
.const [3] = Class [58] 
.const [4] = String [59] 
.const [5] = String [60] 
.const [6] = Method [61] [62] 
.const [7] = Method [63] [64] 
.const [8] = String [65] 
.const [9] = String [66] 
.const [10] = Class [67] 
.const [11] = Class [68] 
.const [12] = Class [69] 
.const [13] = Class [70] 
.const [14] = Class [71] 
.const [15] = Class [72] 
.const [16] = Class [73] 
.const [17] = Class [74] 
.const [18] = Class [75] 
.const [19] = Field [76] [77] 
.const [20] = Field [78] [79] 
.const [21] = Field [80] [81] 
.const [22] = Field [82] [83] 
.const [23] = Field [84] [85] 
.const [24] = Field [86] [87] 
.const [25] = Field [88] [89] 
.const [26] = Method [90] [91] 
.const [27] = Method [92] [93] 
.const [28] = Method [94] [95] 
.const [29] = Method [96] [97] 
.const [30] = Method [98] [99] 
.const [31] = Method [100] [101] 
.const [32] = Method [102] [103] 
.const [33] = Method [104] [105] 
.const [34] = Method [106] [107] 
.const [35] = Field [108] [109] 
.const [36] = Field [110] [111] 
.const [37] = Class [112] 
.const [38] = Field [113] [114] 
.const [39] = Field [115] [116] 
.const [40] = Field [117] [118] 
.const [41] = Field [119] [120] 
.const [42] = Field [121] [122] 
.const [43] = Field [123] [124] 
.const [44] = InterfaceMethod [125] [126] 
.const [45] = InterfaceMethod [127] [128] 
.const [46] = InterfaceMethod [129] [130] 
.const [47] = InterfaceMethod [131] [132] 
.const [48] = Class [133] 
.const [49] = Double +0x13333333333333p-49 
.const [51] = Double +0x12C00000000000p-39 
.const [53] = Double +0x1F400000000000p-43 
.const [55] = Int 167772160 
.const [56] = Class [134] 
.const [57] = NameAndType [135] [136] 
.const [58] = Utf8 de/audi/atip/timer/Timer 
.const [59] = Utf8 tickTimer 
.const [60] = Utf8 '00:' 
.const [61] = Class [137] 
.const [62] = NameAndType [138] [139] 
.const [63] = Class [140] 
.const [64] = NameAndType [141] [142] 
.const [65] = Utf8 '0' 
.const [66] = Utf8 '' 
.const [67] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [68] = Utf8 de/audi/tuner/app/ScanProgressTimer$MyTimerListener 
.const [69] = Utf8 de/audi/atip/timer/DefaultTimerListener 
.const [70] = Utf8 de/audi/tuner/app/Utilities 
.const [71] = Utf8 java/lang/Math 
.const [72] = Utf8 de/audi/atip/hmi/modelaccess/LabelModelApp 
.const [73] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelApp 
.const [74] = Utf8 de/audi/tuner/app/ScanProgressTimer 
.const [75] = Utf8 de/audi/atip/timer/TimerListener 
.const [76] = Class [143] 
.const [77] = NameAndType [144] [145] 
.const [78] = Class [146] 
.const [79] = NameAndType [147] [148] 
.const [80] = Class [149] 
.const [81] = NameAndType [150] [151] 
.const [82] = Class [152] 
.const [83] = NameAndType [153] [154] 
.const [84] = Class [155] 
.const [85] = NameAndType [156] [157] 
.const [86] = Class [158] 
.const [87] = NameAndType [159] [160] 
.const [88] = Class [161] 
.const [89] = NameAndType [162] [163] 
.const [90] = Class [164] 
.const [91] = NameAndType [165] [166] 
.const [92] = Class [167] 
.const [93] = NameAndType [168] [169] 
.const [94] = Class [170] 
.const [95] = NameAndType [171] [172] 
.const [96] = Class [173] 
.const [97] = NameAndType [174] [175] 
.const [98] = Class [176] 
.const [99] = NameAndType [177] [178] 
.const [100] = Class [179] 
.const [101] = NameAndType [180] [181] 
.const [102] = Class [182] 
.const [103] = NameAndType [183] [184] 
.const [104] = Class [185] 
.const [105] = NameAndType [186] [187] 
.const [106] = Class [188] 
.const [107] = NameAndType [189] [190] 
.const [108] = Class [191] 
.const [109] = NameAndType [192] [193] 
.const [110] = Class [194] 
.const [111] = NameAndType [195] [196] 
.const [112] = Utf8 de/audi/atip/timer/Timer 
.const [113] = Class [197] 
.const [114] = NameAndType [198] [199] 
.const [115] = Class [200] 
.const [116] = NameAndType [201] [202] 
.const [117] = Class [203] 
.const [118] = NameAndType [204] [205] 
.const [119] = Class [206] 
.const [120] = NameAndType [207] [208] 
.const [121] = Class [209] 
.const [122] = NameAndType [210] [211] 
.const [123] = Class [212] 
.const [124] = NameAndType [213] [214] 
.const [125] = Class [215] 
.const [126] = NameAndType [216] [217] 
.const [127] = Class [218] 
.const [128] = NameAndType [219] [220] 
.const [129] = Class [221] 
.const [130] = NameAndType [222] [223] 
.const [131] = Class [224] 
.const [132] = NameAndType [225] [226] 
.const [133] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [134] = Utf8 de/audi/tuner/app/Utilities 
.const [135] = Utf8 isPGen1OrBentley 
.const [136] = Utf8 ()Z 
.const [137] = Utf8 java/lang/Math 
.const [138] = Utf8 round 
.const [139] = Utf8 (D)J 
.const [140] = Utf8 de/audi/tuner/app/ScanProgressTimer 
.const [141] = Utf8 access$000 
.const [142] = Utf8 (Lde/audi/tuner/app/ScanProgressTimer;)Lde/audi/atip/timer/TimerListener; 
.const [143] = Utf8 de/audi/tuner/app/ScanProgressTimer$MyTimerListener 
.const [144] = Utf8 this$0 
.const [145] = Utf8 Lde/audi/tuner/app/ScanProgressTimer; 
.const [146] = Utf8 de/audi/tuner/app/ScanProgressTimer$MyTimerListener 
.const [147] = Utf8 periods 
.const [148] = Utf8 I 
.const [149] = Utf8 de/audi/tuner/app/ScanProgressTimer$MyTimerListener 
.const [150] = Utf8 timer 
.const [151] = Utf8 Lde/audi/atip/timer/Timer; 
.const [152] = Utf8 de/audi/tuner/app/ScanProgressTimer$MyTimerListener 
.const [153] = Utf8 count 
.const [154] = Utf8 I 
.const [155] = Utf8 de/audi/tuner/app/ScanProgressTimer$MyTimerListener 
.const [156] = Utf8 progress 
.const [157] = Utf8 Lde/audi/atip/hmi/modelaccess/RangeModelApp; 
.const [158] = Utf8 de/audi/tuner/app/ScanProgressTimer$MyTimerListener 
.const [159] = Utf8 currentScanTime 
.const [160] = Utf8 Lde/audi/atip/hmi/modelaccess/LabelModelApp; 
.const [161] = Utf8 de/audi/tuner/app/ScanProgressTimer$MyTimerListener 
.const [162] = Utf8 endScanTime 
.const [163] = Utf8 Lde/audi/atip/hmi/modelaccess/LabelModelApp; 
.const [164] = Utf8 de/audi/atip/timer/Timer 
.const [165] = Utf8 restart 
.const [166] = Utf8 ()V 
.const [167] = Utf8 de/audi/atip/timer/Timer 
.const [168] = Utf8 cancel 
.const [169] = Utf8 ()Z 
.const [170] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [171] = Utf8 append 
.const [172] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [173] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [174] = Utf8 append 
.const [175] = Utf8 (J)Lde/esolutions/fw/util/commons/Buffer; 
.const [176] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [177] = Utf8 toString 
.const [178] = Utf8 ()Ljava/lang/String; 
.const [179] = Utf8 de/audi/atip/timer/DefaultTimerListener 
.const [180] = Utf8 <init> 
.const [181] = Utf8 ()V 
.const [182] = Utf8 de/audi/atip/timer/Timer 
.const [183] = Utf8 <init> 
.const [184] = Utf8 (Ljava/lang/String;JZLde/audi/atip/timer/TimerListener;)V 
.const [185] = Utf8 de/audi/tuner/app/ScanProgressTimer$MyTimerListener 
.const [186] = Utf8 getTimeTextForSeconds 
.const [187] = Utf8 (J)Ljava/lang/String; 
.const [188] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [189] = Utf8 <init> 
.const [190] = Utf8 (Ljava/lang/String;)V 
.const [191] = Utf8 de/audi/tuner/app/ScanProgressTimer$MyTimerListener 
.const [192] = Utf8 this$0 
.const [193] = Utf8 Lde/audi/tuner/app/ScanProgressTimer; 
.const [194] = Utf8 de/audi/tuner/app/ScanProgressTimer$MyTimerListener 
.const [195] = Utf8 periods 
.const [196] = Utf8 I 
.const [197] = Utf8 de/audi/tuner/app/ScanProgressTimer$MyTimerListener 
.const [198] = Utf8 timer 
.const [199] = Utf8 Lde/audi/atip/timer/Timer; 
.const [200] = Utf8 de/audi/tuner/app/ScanProgressTimer$MyTimerListener 
.const [201] = Utf8 count 
.const [202] = Utf8 I 
.const [203] = Utf8 de/audi/tuner/app/ScanProgressTimer$MyTimerListener 
.const [204] = Utf8 timePrefix 
.const [205] = Utf8 Ljava/lang/String; 
.const [206] = Utf8 de/audi/tuner/app/ScanProgressTimer$MyTimerListener 
.const [207] = Utf8 progress 
.const [208] = Utf8 Lde/audi/atip/hmi/modelaccess/RangeModelApp; 
.const [209] = Utf8 de/audi/tuner/app/ScanProgressTimer$MyTimerListener 
.const [210] = Utf8 currentScanTime 
.const [211] = Utf8 Lde/audi/atip/hmi/modelaccess/LabelModelApp; 
.const [212] = Utf8 de/audi/tuner/app/ScanProgressTimer$MyTimerListener 
.const [213] = Utf8 endScanTime 
.const [214] = Utf8 Lde/audi/atip/hmi/modelaccess/LabelModelApp; 
.const [215] = Utf8 de/audi/atip/hmi/modelaccess/LabelModelApp 
.const [216] = Utf8 setText 
.const [217] = Utf8 (Ljava/lang/String;)V 
.const [218] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelApp 
.const [219] = Utf8 setLimits 
.const [220] = Utf8 (III)V 
.const [221] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelApp 
.const [222] = Utf8 setValue 
.const [223] = Utf8 (I)V 
.const [224] = Utf8 de/audi/atip/timer/TimerListener 
.const [225] = Utf8 fireTimer 
.const [226] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.const [227] = Utf8 de/audi/tuner/app/ScanProgressTimer$MyTimerListener 
.const [228] = Class [227] 
.const [229] = Utf8 de/audi/atip/timer/DefaultTimerListener 
.const [230] = Class [229] 
.const [231] = Utf8 periods 
.const [232] = Utf8 I 
.const [233] = Utf8 PLAY_TIME 
.const [234] = Utf8 I 
.const [235] = Utf8 timer 
.const [236] = Utf8 Lde/audi/atip/timer/Timer; 
.const [237] = Utf8 count 
.const [238] = Utf8 I 
.const [239] = Utf8 progress 
.const [240] = Utf8 Lde/audi/atip/hmi/modelaccess/RangeModelApp; 
.const [241] = Utf8 timePrefix 
.const [242] = Utf8 Ljava/lang/String; 
.const [243] = Utf8 currentScanTime 
.const [244] = Utf8 Lde/audi/atip/hmi/modelaccess/LabelModelApp; 
.const [245] = Utf8 endScanTime 
.const [246] = Utf8 Lde/audi/atip/hmi/modelaccess/LabelModelApp; 
.const [247] = Utf8 this$0 
.const [248] = Utf8 Lde/audi/tuner/app/ScanProgressTimer; 
.const [249] = Utf8 Code 
.const [250] = Utf8 <init> 
.const [251] = Utf8 (Lde/audi/tuner/app/ScanProgressTimer;Lde/audi/atip/hmi/modelaccess/RangeModelApp;Lde/audi/atip/hmi/modelaccess/LabelModelApp;Lde/audi/atip/hmi/modelaccess/LabelModelApp;)V 
.const [252] = Utf8 start 
.const [253] = Utf8 ()V 
.const [254] = Utf8 cancel 
.const [255] = Utf8 ()Z 
.const [256] = Utf8 fireTimer 
.const [257] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.const [258] = Utf8 getTimeTextForSeconds 
.const [259] = Utf8 (J)Ljava/lang/String; 
.end class 
