.version 50 0 
.class super [143] 
.super [145] 
.field private static final [146] [147] 
.field private final [148] [149] 
.field private final [150] [151] 
.field private [152] [153] 
.field private final [154] [155] 
.field private final [156] [157] 

.method public [159] : [160] 
    .attribute [158] .code stack 8 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     aload_0 
L5:     new [22] 
L8:     dup 
L9:     aload_0 
L10:    iconst_1 
L11:    invokespecial [20] 
L14:    putfield [23] 
L17:    aload_0 
L18:    new [22] 
L21:    dup 
L22:    aload_0 
L23:    iconst_0 
L24:    invokespecial [20] 
L27:    putfield [24] 
L30:    aload_0 
L31:    aload_1 
L32:    putfield [25] 
L35:    aload_0 
L36:    new [26] 
L39:    dup 
L40:    ldc [4] 
L42:    ldc_w [1] 
L45:    iconst_1 
L46:    aload_0 
L47:    getfield [10] 
L50:    invokespecial [21] 
L53:    putfield [27] 
L56:    return 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [161] : [162] 
    .attribute [158] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokestatic [5] 
L4:     putfield [28] 
L7:     aload_0 
L8:     getfield [12] 
L11:    bipush 9 
L13:    invokeinterface [29] 0 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [163] : [164] 
    .attribute [158] .code stack 6 locals 3 
L0:     ldc_w [1] 
L3:     invokestatic [5] 
L6:     aload_0 
L7:     getfield [14] 
L10:    lsub 
L11:    lsub 
L12:    lstore_2 
L13:    lload_2 
L14:    lconst_0 
L15:    lcmp 
L16:    ifgt L27 
L19:    aload_0 
L20:    iload_1 
L21:    invokespecial [18] 
L24:    goto L68 
L27:    iload_1 
L28:    ifeq L38 
L31:    aload_0 
L32:    getfield [10] 
L35:    goto L42 
L38:    aload_0 
L39:    getfield [11] 
L42:    astore 4 
L44:    aload_0 
L45:    getfield [13] 
L48:    aload 4 
L50:    invokevirtual [15] 
L53:    aload_0 
L54:    getfield [13] 
L57:    lload_2 
L58:    invokevirtual [16] 
L61:    aload_0 
L62:    getfield [13] 
L65:    invokevirtual [17] 
L68:    return 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method private [165] : [166] 
    .attribute [158] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [12] 
L4:     bipush 9 
L6:     invokeinterface [30] 0 
L11:    iload_1 
L12:    ifeq L20 
L15:    bipush 10 
L17:    goto L22 
L20:    bipush 11 
L22:    istore_2 
L23:    aload_0 
L24:    getfield [12] 
L27:    iload_2 
L28:    invokeinterface [29] 0 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method static synthetic [167] : [168] 
    .attribute [158] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [18] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [33] 
.const [3] = Class [34] 
.const [4] = String [35] 
.const [5] = Method [36] [37] 
.const [6] = Class [38] 
.const [7] = Class [39] 
.const [8] = Class [40] 
.const [9] = Class [41] 
.const [10] = Field [42] [43] 
.const [11] = Field [44] [45] 
.const [12] = Field [46] [47] 
.const [13] = Field [48] [49] 
.const [14] = Field [50] [51] 
.const [15] = Method [52] [53] 
.const [16] = Method [54] [55] 
.const [17] = Method [56] [57] 
.const [18] = Method [58] [59] 
.const [19] = Method [60] [61] 
.const [20] = Method [62] [63] 
.const [21] = Method [64] [65] 
.const [22] = Class [66] 
.const [23] = Field [67] [68] 
.const [24] = Field [69] [70] 
.const [25] = Field [71] [72] 
.const [26] = Class [73] 
.const [27] = Field [74] [75] 
.const [28] = Field [76] [77] 
.const [29] = InterfaceMethod [78] [79] 
.const [30] = InterfaceMethod [80] [81] 
.const [31] = Int -402456576 
.const [32] = Int -1207238656 
.const [33] = Utf8 de/audi/tuner/itunes/ITunesTaggingDSI$TransferPartialPopupManager$DelayedChangeToFinishedPopupTimerListener 
.const [34] = Utf8 de/audi/atip/timer/Timer 
.const [35] = Utf8 TransferPartialPopupManager 
.const [36] = Class [82] 
.const [37] = NameAndType [83] [84] 
.const [38] = Utf8 de/audi/tuner/itunes/ITunesTaggingDSI$TransferPartialPopupManager 
.const [39] = Utf8 java/lang/Object 
.const [40] = Utf8 java/lang/System 
.const [41] = Utf8 de/audi/tuner/ifc/ITunerVariantExt 
.const [42] = Class [85] 
.const [43] = NameAndType [86] [87] 
.const [44] = Class [88] 
.const [45] = NameAndType [89] [90] 
.const [46] = Class [91] 
.const [47] = NameAndType [92] [93] 
.const [48] = Class [94] 
.const [49] = NameAndType [95] [96] 
.const [50] = Class [97] 
.const [51] = NameAndType [98] [99] 
.const [52] = Class [100] 
.const [53] = NameAndType [101] [102] 
.const [54] = Class [103] 
.const [55] = NameAndType [104] [105] 
.const [56] = Class [106] 
.const [57] = NameAndType [107] [108] 
.const [58] = Class [109] 
.const [59] = NameAndType [110] [111] 
.const [60] = Class [112] 
.const [61] = NameAndType [113] [114] 
.const [62] = Class [115] 
.const [63] = NameAndType [116] [117] 
.const [64] = Class [118] 
.const [65] = NameAndType [119] [120] 
.const [66] = Utf8 de/audi/tuner/itunes/ITunesTaggingDSI$TransferPartialPopupManager$DelayedChangeToFinishedPopupTimerListener 
.const [67] = Class [121] 
.const [68] = NameAndType [122] [123] 
.const [69] = Class [124] 
.const [70] = NameAndType [125] [126] 
.const [71] = Class [127] 
.const [72] = NameAndType [128] [129] 
.const [73] = Utf8 de/audi/atip/timer/Timer 
.const [74] = Class [130] 
.const [75] = NameAndType [131] [132] 
.const [76] = Class [133] 
.const [77] = NameAndType [134] [135] 
.const [78] = Class [136] 
.const [79] = NameAndType [137] [138] 
.const [80] = Class [139] 
.const [81] = NameAndType [140] [141] 
.const [82] = Utf8 java/lang/System 
.const [83] = Utf8 currentTimeMillis 
.const [84] = Utf8 ()J 
.const [85] = Utf8 de/audi/tuner/itunes/ITunesTaggingDSI$TransferPartialPopupManager 
.const [86] = Utf8 tlDelayedSuccess 
.const [87] = Utf8 Lde/audi/tuner/itunes/ITunesTaggingDSI$TransferPartialPopupManager$DelayedChangeToFinishedPopupTimerListener; 
.const [88] = Utf8 de/audi/tuner/itunes/ITunesTaggingDSI$TransferPartialPopupManager 
.const [89] = Utf8 tlDelayedFail 
.const [90] = Utf8 Lde/audi/tuner/itunes/ITunesTaggingDSI$TransferPartialPopupManager$DelayedChangeToFinishedPopupTimerListener; 
.const [91] = Utf8 de/audi/tuner/itunes/ITunesTaggingDSI$TransferPartialPopupManager 
.const [92] = Utf8 varExt 
.const [93] = Utf8 Lde/audi/tuner/ifc/ITunerVariantExt; 
.const [94] = Utf8 de/audi/tuner/itunes/ITunesTaggingDSI$TransferPartialPopupManager 
.const [95] = Utf8 delayTimer 
.const [96] = Utf8 Lde/audi/atip/timer/Timer; 
.const [97] = Utf8 de/audi/tuner/itunes/ITunesTaggingDSI$TransferPartialPopupManager 
.const [98] = Utf8 lastTransferStartTime 
.const [99] = Utf8 J 
.const [100] = Utf8 de/audi/atip/timer/Timer 
.const [101] = Utf8 setTimerListener 
.const [102] = Utf8 (Lde/audi/atip/timer/TimerListener;)V 
.const [103] = Utf8 de/audi/atip/timer/Timer 
.const [104] = Utf8 setDelay 
.const [105] = Utf8 (J)V 
.const [106] = Utf8 de/audi/atip/timer/Timer 
.const [107] = Utf8 restart 
.const [108] = Utf8 ()V 
.const [109] = Utf8 de/audi/tuner/itunes/ITunesTaggingDSI$TransferPartialPopupManager 
.const [110] = Utf8 changeToFinishedPopup 
.const [111] = Utf8 (Z)V 
.const [112] = Utf8 java/lang/Object 
.const [113] = Utf8 <init> 
.const [114] = Utf8 ()V 
.const [115] = Utf8 de/audi/tuner/itunes/ITunesTaggingDSI$TransferPartialPopupManager$DelayedChangeToFinishedPopupTimerListener 
.const [116] = Utf8 <init> 
.const [117] = Utf8 (Lde/audi/tuner/itunes/ITunesTaggingDSI$TransferPartialPopupManager;Z)V 
.const [118] = Utf8 de/audi/atip/timer/Timer 
.const [119] = Utf8 <init> 
.const [120] = Utf8 (Ljava/lang/String;JZLde/audi/atip/timer/TimerListener;)V 
.const [121] = Utf8 de/audi/tuner/itunes/ITunesTaggingDSI$TransferPartialPopupManager 
.const [122] = Utf8 tlDelayedSuccess 
.const [123] = Utf8 Lde/audi/tuner/itunes/ITunesTaggingDSI$TransferPartialPopupManager$DelayedChangeToFinishedPopupTimerListener; 
.const [124] = Utf8 de/audi/tuner/itunes/ITunesTaggingDSI$TransferPartialPopupManager 
.const [125] = Utf8 tlDelayedFail 
.const [126] = Utf8 Lde/audi/tuner/itunes/ITunesTaggingDSI$TransferPartialPopupManager$DelayedChangeToFinishedPopupTimerListener; 
.const [127] = Utf8 de/audi/tuner/itunes/ITunesTaggingDSI$TransferPartialPopupManager 
.const [128] = Utf8 varExt 
.const [129] = Utf8 Lde/audi/tuner/ifc/ITunerVariantExt; 
.const [130] = Utf8 de/audi/tuner/itunes/ITunesTaggingDSI$TransferPartialPopupManager 
.const [131] = Utf8 delayTimer 
.const [132] = Utf8 Lde/audi/atip/timer/Timer; 
.const [133] = Utf8 de/audi/tuner/itunes/ITunesTaggingDSI$TransferPartialPopupManager 
.const [134] = Utf8 lastTransferStartTime 
.const [135] = Utf8 J 
.const [136] = Utf8 de/audi/tuner/ifc/ITunerVariantExt 
.const [137] = Utf8 showPartialPopup 
.const [138] = Utf8 (I)V 
.const [139] = Utf8 de/audi/tuner/ifc/ITunerVariantExt 
.const [140] = Utf8 hidePartialPopup 
.const [141] = Utf8 (I)V 
.const [142] = Utf8 de/audi/tuner/itunes/ITunesTaggingDSI$TransferPartialPopupManager 
.const [143] = Class [142] 
.const [144] = Utf8 java/lang/Object 
.const [145] = Class [144] 
.const [146] = Utf8 MIN_POPUP_VISIBLE_TIME_MS 
.const [147] = Utf8 J 
.const [148] = Utf8 tlDelayedSuccess 
.const [149] = Utf8 Lde/audi/tuner/itunes/ITunesTaggingDSI$TransferPartialPopupManager$DelayedChangeToFinishedPopupTimerListener; 
.const [150] = Utf8 tlDelayedFail 
.const [151] = Utf8 Lde/audi/tuner/itunes/ITunesTaggingDSI$TransferPartialPopupManager$DelayedChangeToFinishedPopupTimerListener; 
.const [152] = Utf8 lastTransferStartTime 
.const [153] = Utf8 J 
.const [154] = Utf8 delayTimer 
.const [155] = Utf8 Lde/audi/atip/timer/Timer; 
.const [156] = Utf8 varExt 
.const [157] = Utf8 Lde/audi/tuner/ifc/ITunerVariantExt; 
.const [158] = Utf8 Code 
.const [159] = Utf8 <init> 
.const [160] = Utf8 (Lde/audi/tuner/ifc/ITunerVariantExt;)V 
.const [161] = Utf8 reportTransferStarted 
.const [162] = Utf8 ()V 
.const [163] = Utf8 reportTransferFinished 
.const [164] = Utf8 (Z)V 
.const [165] = Utf8 changeToFinishedPopup 
.const [166] = Utf8 (Z)V 
.const [167] = Utf8 access$200 
.const [168] = Utf8 (Lde/audi/tuner/itunes/ITunesTaggingDSI$TransferPartialPopupManager;Z)V 
.end class 
