.version 50 0 
.class public super [177] 
.super [179] 
.implements [181] 
.implements [183] 
.field private static final [184] [185] 
.field private final [186] [187] 
.field private volatile [188] [189] 
.field private volatile [190] [191] 

.method public [193] : [194] 
    .attribute [192] .code stack 8 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     aload 4 
L6:     invokespecial [34] 
L9:     aload_0 
L10:    new [37] 
L13:    dup 
L14:    ldc [3] 
L16:    ldc_w [1] 
L19:    iconst_1 
L20:    aload_0 
L21:    invokespecial [35] 
L24:    putfield [38] 
L27:    return 
L28:    
    .end code 
.end method 

.method public [195] : [196] 
    .attribute [192] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     ldc [4] 
L6:     ldc [5] 
L8:     ldc [6] 
L10:    new [39] 
L13:    dup 
L14:    iload_1 
L15:    invokespecial [36] 
L18:    invokevirtual [25] 
L21:    aload_0 
L22:    getfield [26] 
L25:    iload_1 
L26:    if_icmpne L30 
L29:    return 
L30:    iload_1 
L31:    ifeq L55 
L34:    aload_0 
L35:    getfield [27] 
L38:    iconst_1 
L39:    iconst_1 
L40:    invokeinterface [41] 0 
L45:    aload_0 
L46:    getfield [23] 
L49:    invokevirtual [28] 
L52:    goto L74 
L55:    aload_0 
L56:    getfield [27] 
L59:    iconst_2 
L60:    iconst_1 
L61:    invokeinterface [41] 0 
L66:    aload_0 
L67:    getfield [23] 
L70:    invokevirtual [29] 
L73:    pop 
L74:    aload_0 
L75:    iload_1 
L76:    putfield [40] 
L79:    return 
L80:    
    .end code 
.end method 

.method public [197] : [198] 
    .attribute [192] .code stack 4 locals 0 
L0:     aload_0 
L1:     iload_2 
L2:     invokevirtual [30] 
L5:     ifeq L62 
L8:     iconst_1 
L9:     iload_1 
L10:    if_icmpne L41 
L13:    aload_0 
L14:    getfield [24] 
L17:    ldc [4] 
L19:    ldc [8] 
L21:    ldc [6] 
L23:    invokevirtual [31] 
L26:    pop 
L27:    aload_0 
L28:    getfield [32] 
L31:    ifne L41 
L34:    aload_0 
L35:    getfield [23] 
L38:    invokevirtual [28] 
L41:    aload_0 
L42:    getstatic [9] 
L45:    iconst_1 
L46:    iload_1 
L47:    if_icmpne L56 
L50:    getstatic [10] 
L53:    goto L59 
L56:    getstatic [11] 
L59:    invokevirtual [33] 
L62:    return 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [199] : [200] 
    .attribute [192] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     ldc [4] 
L6:     ldc [12] 
L8:     ldc [6] 
L10:    invokevirtual [31] 
L13:    pop 
L14:    aload_0 
L15:    getstatic [13] 
L18:    getstatic [11] 
L21:    invokevirtual [33] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public enum [201] : [202] 
    .attribute [192] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [203] : [204] 
    .attribute [192] .code stack 5 locals 0 
L0:     aload_0 
L1:     iload_2 
L2:     invokevirtual [30] 
L5:     ifne L23 
L8:     aload_0 
L9:     getfield [24] 
L12:    ldc [4] 
L14:    ldc [14] 
L16:    ldc [6] 
L18:    invokevirtual [31] 
L21:    pop 
L22:    return 
L23:    aload_0 
L24:    getfield [24] 
L27:    ldc [4] 
L29:    ldc [15] 
L31:    ldc [6] 
L33:    iload_1 
L34:    invokestatic [16] 
L37:    invokevirtual [25] 
L40:    aload_0 
L41:    iload_1 
L42:    putfield [42] 
L45:    iload_1 
L46:    ifeq L70 
L49:    aload_0 
L50:    getfield [23] 
L53:    invokevirtual [29] 
L56:    pop 
L57:    aload_0 
L58:    getstatic [13] 
L61:    getstatic [10] 
L64:    invokevirtual [33] 
L67:    goto L87 
L70:    aload_0 
L71:    getfield [26] 
L74:    ifeq L87 
L77:    aload_0 
L78:    getstatic [13] 
L81:    getstatic [11] 
L84:    invokevirtual [33] 
L87:    return 
L88:    
    .end code 
.end method 

.method protected [205] : [206] 
    .attribute [192] .code stack 1 locals 0 
L0:     ldc [6] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [44] 
.const [3] = String [45] 
.const [4] = Int 1078071040 
.const [5] = String [46] 
.const [6] = String [47] 
.const [7] = Class [48] 
.const [8] = String [49] 
.const [9] = Field [50] [51] 
.const [10] = Field [52] [53] 
.const [11] = Field [54] [55] 
.const [12] = String [56] 
.const [13] = Field [57] [58] 
.const [14] = String [59] 
.const [15] = String [60] 
.const [16] = Method [61] [62] 
.const [17] = Class [63] 
.const [18] = Class [64] 
.const [19] = Class [65] 
.const [20] = Class [66] 
.const [21] = Class [67] 
.const [22] = Class [68] 
.const [23] = Field [69] [70] 
.const [24] = Field [71] [72] 
.const [25] = Method [73] [74] 
.const [26] = Field [75] [76] 
.const [27] = Field [77] [78] 
.const [28] = Method [79] [80] 
.const [29] = Method [81] [82] 
.const [30] = Method [83] [84] 
.const [31] = Method [85] [86] 
.const [32] = Field [87] [88] 
.const [33] = Method [89] [90] 
.const [34] = Method [91] [92] 
.const [35] = Method [93] [94] 
.const [36] = Method [95] [96] 
.const [37] = Class [97] 
.const [38] = Field [98] [99] 
.const [39] = Class [100] 
.const [40] = Field [101] [102] 
.const [41] = InterfaceMethod [103] [104] 
.const [42] = Field [105] [106] 
.const [43] = Int -1207238656 
.const [44] = Utf8 de/audi/atip/timer/Timer 
.const [45] = Utf8 VideoAvailableTimer 
.const [46] = Utf8 '[%1.updateVideoState] %2' 
.const [47] = Utf8 AndroidAuto2VideoHandler 
.const [48] = Utf8 java/lang/Boolean 
.const [49] = Utf8 '<- [%1.videoFocusRequestNotification]' 
.const [50] = Class [107] 
.const [51] = NameAndType [108] [109] 
.const [52] = Class [110] 
.const [53] = NameAndType [111] [112] 
.const [54] = Class [113] 
.const [55] = NameAndType [114] [115] 
.const [56] = Utf8 '[%1.fireTimer] Change notification resource.' 
.const [57] = Class [116] 
.const [58] = NameAndType [117] [118] 
.const [59] = Utf8 '<- [%1.videoAvailable] Invalid.' 
.const [60] = Utf8 '<- [%1.videoAvailable] %2' 
.const [61] = Class [119] 
.const [62] = NameAndType [120] [121] 
.const [63] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/video/AndroidAuto2VideoHandler 
.const [64] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/AbstractAndroidAuto2Handler 
.const [65] = Utf8 de/audi/atip/log/LogChannel 
.const [66] = Utf8 org/dsi/ifc/androidauto2/DSIAndroidAuto2 
.const [67] = Utf8 de/audi/app/terminalmode/statemachine/Resource 
.const [68] = Utf8 de/audi/app/terminalmode/statemachine/ResourceOwner 
.const [69] = Class [122] 
.const [70] = NameAndType [123] [124] 
.const [71] = Class [125] 
.const [72] = NameAndType [126] [127] 
.const [73] = Class [128] 
.const [74] = NameAndType [129] [130] 
.const [75] = Class [131] 
.const [76] = NameAndType [132] [133] 
.const [77] = Class [134] 
.const [78] = NameAndType [135] [136] 
.const [79] = Class [137] 
.const [80] = NameAndType [138] [139] 
.const [81] = Class [140] 
.const [82] = NameAndType [141] [142] 
.const [83] = Class [143] 
.const [84] = NameAndType [144] [145] 
.const [85] = Class [146] 
.const [86] = NameAndType [147] [148] 
.const [87] = Class [149] 
.const [88] = NameAndType [150] [151] 
.const [89] = Class [152] 
.const [90] = NameAndType [153] [154] 
.const [91] = Class [155] 
.const [92] = NameAndType [156] [157] 
.const [93] = Class [158] 
.const [94] = NameAndType [159] [160] 
.const [95] = Class [161] 
.const [96] = NameAndType [162] [163] 
.const [97] = Utf8 de/audi/atip/timer/Timer 
.const [98] = Class [164] 
.const [99] = NameAndType [165] [166] 
.const [100] = Utf8 java/lang/Boolean 
.const [101] = Class [167] 
.const [102] = NameAndType [168] [169] 
.const [103] = Class [170] 
.const [104] = NameAndType [171] [172] 
.const [105] = Class [173] 
.const [106] = NameAndType [174] [175] 
.const [107] = Utf8 de/audi/app/terminalmode/statemachine/Resource 
.const [108] = Utf8 SCREEN 
.const [109] = Utf8 Lde/audi/app/terminalmode/statemachine/Resource; 
.const [110] = Utf8 de/audi/app/terminalmode/statemachine/ResourceOwner 
.const [111] = Utf8 DEVICE 
.const [112] = Utf8 Lde/audi/app/terminalmode/statemachine/ResourceOwner; 
.const [113] = Utf8 de/audi/app/terminalmode/statemachine/ResourceOwner 
.const [114] = Utf8 MAINUNIT 
.const [115] = Utf8 Lde/audi/app/terminalmode/statemachine/ResourceOwner; 
.const [116] = Utf8 de/audi/app/terminalmode/statemachine/Resource 
.const [117] = Utf8 NOTIFICATION 
.const [118] = Utf8 Lde/audi/app/terminalmode/statemachine/Resource; 
.const [119] = Utf8 java/lang/Boolean 
.const [120] = Utf8 toString 
.const [121] = Utf8 (Z)Ljava/lang/String; 
.const [122] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/video/AndroidAuto2VideoHandler 
.const [123] = Utf8 videoAvailableTimer 
.const [124] = Utf8 Lde/audi/atip/timer/Timer; 
.const [125] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/video/AndroidAuto2VideoHandler 
.const [126] = Utf8 logger 
.const [127] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [128] = Utf8 de/audi/atip/log/LogChannel 
.const [129] = Utf8 log 
.const [130] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [131] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/video/AndroidAuto2VideoHandler 
.const [132] = Utf8 videoState 
.const [133] = Utf8 Z 
.const [134] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/video/AndroidAuto2VideoHandler 
.const [135] = Utf8 dsi 
.const [136] = Utf8 Lorg/dsi/ifc/androidauto2/DSIAndroidAuto2; 
.const [137] = Utf8 de/audi/atip/timer/Timer 
.const [138] = Utf8 start 
.const [139] = Utf8 ()V 
.const [140] = Utf8 de/audi/atip/timer/Timer 
.const [141] = Utf8 cancel 
.const [142] = Utf8 ()Z 
.const [143] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/video/AndroidAuto2VideoHandler 
.const [144] = Utf8 isValid 
.const [145] = Utf8 (I)Z 
.const [146] = Utf8 de/audi/atip/log/LogChannel 
.const [147] = Utf8 log 
.const [148] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [149] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/video/AndroidAuto2VideoHandler 
.const [150] = Utf8 videoAvailable 
.const [151] = Utf8 Z 
.const [152] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/video/AndroidAuto2VideoHandler 
.const [153] = Utf8 requestDSIUpdate 
.const [154] = Utf8 (Lde/audi/app/terminalmode/statemachine/Resource;Lde/audi/app/terminalmode/statemachine/ResourceOwner;)V 
.const [155] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/AbstractAndroidAuto2Handler 
.const [156] = Utf8 <init> 
.const [157] = Utf8 (Lde/audi/atip/log/LogChannel;Lorg/dsi/ifc/androidauto2/DSIAndroidAuto2;Lde/audi/app/terminalmode/statemachine/IStateHandler;Lde/audi/app/terminalmode/IContext;)V 
.const [158] = Utf8 de/audi/atip/timer/Timer 
.const [159] = Utf8 <init> 
.const [160] = Utf8 (Ljava/lang/String;JZLde/audi/atip/timer/TimerListener;)V 
.const [161] = Utf8 java/lang/Boolean 
.const [162] = Utf8 <init> 
.const [163] = Utf8 (Z)V 
.const [164] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/video/AndroidAuto2VideoHandler 
.const [165] = Utf8 videoAvailableTimer 
.const [166] = Utf8 Lde/audi/atip/timer/Timer; 
.const [167] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/video/AndroidAuto2VideoHandler 
.const [168] = Utf8 videoState 
.const [169] = Utf8 Z 
.const [170] = Utf8 org/dsi/ifc/androidauto2/DSIAndroidAuto2 
.const [171] = Utf8 videoFocusNotification 
.const [172] = Utf8 (IZ)V 
.const [173] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/video/AndroidAuto2VideoHandler 
.const [174] = Utf8 videoAvailable 
.const [175] = Utf8 Z 
.const [176] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/video/AndroidAuto2VideoHandler 
.const [177] = Class [176] 
.const [178] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/AbstractAndroidAuto2Handler 
.const [179] = Class [178] 
.const [180] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/video/IAndroidAuto2VideoHandler 
.const [181] = Class [180] 
.const [182] = Utf8 de/audi/atip/timer/TimerListener 
.const [183] = Class [182] 
.const [184] = Utf8 LOGCLASS 
.const [185] = Utf8 Ljava/lang/String; 
.const [186] = Utf8 videoAvailableTimer 
.const [187] = Utf8 Lde/audi/atip/timer/Timer; 
.const [188] = Utf8 videoAvailable 
.const [189] = Utf8 Z 
.const [190] = Utf8 videoState 
.const [191] = Utf8 Z 
.const [192] = Utf8 Code 
.const [193] = Utf8 <init> 
.const [194] = Utf8 (Lde/audi/atip/log/LogChannel;Lorg/dsi/ifc/androidauto2/DSIAndroidAuto2;Lde/audi/app/terminalmode/statemachine/IStateHandler;Lde/audi/app/terminalmode/IContext;)V 
.const [195] = Utf8 updateVideoState 
.const [196] = Utf8 (Z)V 
.const [197] = Utf8 videoFocusRequestNotification 
.const [198] = Utf8 (II)V 
.const [199] = Utf8 fireTimer 
.const [200] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.const [201] = Utf8 cancelTimer 
.const [202] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.const [203] = Utf8 videoAvailable 
.const [204] = Utf8 (ZI)V 
.const [205] = Utf8 getLogClass 
.const [206] = Utf8 ()Ljava/lang/String; 
.end class 
