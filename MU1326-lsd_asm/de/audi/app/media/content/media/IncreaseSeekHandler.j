.version 50 0 
.class public super [175] 
.super [177] 
.implements [179] 
.field private static final [180] [181] 
.field public static final [182] [183] 
.field public static final [184] [185] 
.field private final [186] [187] 
.field private volatile [188] [189] 
.field private final [190] [191] 
.field private final [192] [193] 
.field private volatile [194] [195] 

.method public [197] : [198] 
    .attribute [196] .code stack 10 locals 0 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     aload_0 
L5:     bipush 8 
L7:     putfield [33] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [34] 
L15:    aload_0 
L16:    aload_1 
L17:    putfield [35] 
L20:    aload_0 
L21:    aload_2 
L22:    putfield [36] 
L25:    aload_0 
L26:    new [37] 
L29:    dup 
L30:    ldc [3] 
L32:    iconst_5 
L33:    aconst_null 
L34:    aload_0 
L35:    ldc_w [1] 
L38:    iconst_0 
L39:    invokespecial [32] 
L42:    putfield [38] 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method [199] : [200] 
    .attribute [196] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     aload_0 
L5:     bipush 8 
L7:     putfield [33] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [34] 
L15:    aload_0 
L16:    aload_1 
L17:    putfield [35] 
L20:    aload_0 
L21:    aload_2 
L22:    putfield [36] 
L25:    aload_0 
L26:    aload_3 
L27:    putfield [38] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method public enum [201] : [202] 
    .attribute [196] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [203] : [204] 
    .attribute [196] .code stack 10 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [4] 
L6:     ldc [5] 
L8:     ldc [6] 
L10:    aload_0 
L11:    getfield [18] 
L14:    i2l 
L15:    aload_0 
L16:    getfield [18] 
L19:    i2l 
L20:    ldc_w [1] 
L23:    lmul 
L24:    invokevirtual [23] 
L27:    pop 
L28:    aload_0 
L29:    dup 
L30:    getfield [18] 
L33:    iconst_1 
L34:    ishl 
L35:    putfield [33] 
L38:    aload_0 
L39:    getfield [18] 
L42:    aload_0 
L43:    getfield [20] 
L46:    invokeinterface [39] 0 
L51:    if_icmplt L86 
L54:    aload_0 
L55:    getfield [21] 
L58:    ldc [4] 
L60:    ldc [7] 
L62:    ldc [6] 
L64:    aload_0 
L65:    getfield [20] 
L68:    invokeinterface [39] 0 
L73:    i2l 
L74:    invokevirtual [24] 
L77:    pop 
L78:    aload_0 
L79:    getfield [22] 
L82:    invokevirtual [25] 
L85:    pop 
L86:    aload_0 
L87:    getfield [20] 
L90:    aload_0 
L91:    getfield [19] 
L94:    aload_0 
L95:    getfield [18] 
L98:    invokeinterface [40] 0 
L103:   pop 
L104:   return 
L105:   nop 
L106:   nop 
L107:   nop 
L108:   
    .end code 
.end method 

.method public [205] : [206] 
    .attribute [196] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [8] 
L6:     ldc [9] 
L8:     ldc [6] 
L10:    iload_1 
L11:    ifeq L19 
L14:    ldc [10] 
L16:    goto L21 
L19:    ldc [11] 
L21:    lload_2 
L22:    invokevirtual [26] 
L25:    aload_0 
L26:    bipush 8 
L28:    putfield [33] 
L31:    aload_0 
L32:    getfield [20] 
L35:    iload_1 
L36:    aload_0 
L37:    getfield [18] 
L40:    invokeinterface [40] 0 
L45:    ifne L50 
L48:    iconst_0 
L49:    areturn 
L50:    aload_0 
L51:    iload_1 
L52:    putfield [34] 
L55:    aload_0 
L56:    getfield [20] 
L59:    invokeinterface [41] 0 
L64:    ifeq L94 
L67:    aload_0 
L68:    getfield [21] 
L71:    ldc [8] 
L73:    ldc [12] 
L75:    ldc [6] 
L77:    iload_1 
L78:    ifeq L86 
L81:    ldc [10] 
L83:    goto L88 
L86:    ldc [11] 
L88:    invokevirtual [27] 
L91:    goto L109 
L94:    aload_0 
L95:    getfield [22] 
L98:    lload_2 
L99:    invokevirtual [28] 
L102:   aload_0 
L103:   getfield [22] 
L106:   invokevirtual [29] 
L109:   iconst_1 
L110:   areturn 
L111:   nop 
L112:   
    .end code 
.end method 

.method public [207] : [208] 
    .attribute [196] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [8] 
L6:     ldc [13] 
L8:     ldc [6] 
L10:    invokevirtual [30] 
L13:    pop 
L14:    aload_0 
L15:    getfield [22] 
L18:    invokevirtual [25] 
L21:    pop 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [44] 
.const [3] = String [45] 
.const [4] = Int -2137614336 
.const [5] = String [46] 
.const [6] = String [47] 
.const [7] = String [48] 
.const [8] = Int 1078071040 
.const [9] = String [49] 
.const [10] = String [50] 
.const [11] = String [51] 
.const [12] = String [52] 
.const [13] = String [53] 
.const [14] = Class [54] 
.const [15] = Class [55] 
.const [16] = Class [56] 
.const [17] = Class [57] 
.const [18] = Field [58] [59] 
.const [19] = Field [60] [61] 
.const [20] = Field [62] [63] 
.const [21] = Field [64] [65] 
.const [22] = Field [66] [67] 
.const [23] = Method [68] [69] 
.const [24] = Method [70] [71] 
.const [25] = Method [72] [73] 
.const [26] = Method [74] [75] 
.const [27] = Method [76] [77] 
.const [28] = Method [78] [79] 
.const [29] = Method [80] [81] 
.const [30] = Method [82] [83] 
.const [31] = Method [84] [85] 
.const [32] = Method [86] [87] 
.const [33] = Field [88] [89] 
.const [34] = Field [90] [91] 
.const [35] = Field [92] [93] 
.const [36] = Field [94] [95] 
.const [37] = Class [96] 
.const [38] = Field [97] [98] 
.const [39] = InterfaceMethod [99] [100] 
.const [40] = InterfaceMethod [101] [102] 
.const [41] = InterfaceMethod [103] [104] 
.const [42] = Int -2012020736 
.const [43] = Int 33554432 
.const [44] = Utf8 de/audi/atip/timer/Timer 
.const [45] = Utf8 IncreaseSeekTimer 
.const [46] = Utf8 "[%1.fireTimer] Increase speed from '%2x' to '%3x'." 
.const [47] = Utf8 IncreaseSeekHandler 
.const [48] = Utf8 "[%1.fireTimer] Maximum speed reached. (Max='%2x')" 
.const [49] = Utf8 "[%1.start] '%2' (timeout='%3')" 
.const [50] = Utf8 FORWARD 
.const [51] = Utf8 BACKWARD 
.const [52] = Utf8 "[%1.start] '%2' Increment deactivated!" 
.const [53] = Utf8 '[%1.stop]' 
.const [54] = Utf8 de/audi/app/media/content/media/IncreaseSeekHandler 
.const [55] = Utf8 java/lang/Object 
.const [56] = Utf8 de/audi/atip/log/LogChannel 
.const [57] = Utf8 de/audi/app/media/content/media/ISeeker 
.const [58] = Class [105] 
.const [59] = NameAndType [106] [107] 
.const [60] = Class [108] 
.const [61] = NameAndType [109] [110] 
.const [62] = Class [111] 
.const [63] = NameAndType [112] [113] 
.const [64] = Class [114] 
.const [65] = NameAndType [115] [116] 
.const [66] = Class [117] 
.const [67] = NameAndType [118] [119] 
.const [68] = Class [120] 
.const [69] = NameAndType [121] [122] 
.const [70] = Class [123] 
.const [71] = NameAndType [124] [125] 
.const [72] = Class [126] 
.const [73] = NameAndType [127] [128] 
.const [74] = Class [129] 
.const [75] = NameAndType [130] [131] 
.const [76] = Class [132] 
.const [77] = NameAndType [133] [134] 
.const [78] = Class [135] 
.const [79] = NameAndType [136] [137] 
.const [80] = Class [138] 
.const [81] = NameAndType [139] [140] 
.const [82] = Class [141] 
.const [83] = NameAndType [142] [143] 
.const [84] = Class [144] 
.const [85] = NameAndType [145] [146] 
.const [86] = Class [147] 
.const [87] = NameAndType [148] [149] 
.const [88] = Class [150] 
.const [89] = NameAndType [151] [152] 
.const [90] = Class [153] 
.const [91] = NameAndType [154] [155] 
.const [92] = Class [156] 
.const [93] = NameAndType [157] [158] 
.const [94] = Class [159] 
.const [95] = NameAndType [160] [161] 
.const [96] = Utf8 de/audi/atip/timer/Timer 
.const [97] = Class [162] 
.const [98] = NameAndType [163] [164] 
.const [99] = Class [165] 
.const [100] = NameAndType [166] [167] 
.const [101] = Class [168] 
.const [102] = NameAndType [169] [170] 
.const [103] = Class [171] 
.const [104] = NameAndType [172] [173] 
.const [105] = Utf8 de/audi/app/media/content/media/IncreaseSeekHandler 
.const [106] = Utf8 currentSeekSpeed 
.const [107] = Utf8 I 
.const [108] = Utf8 de/audi/app/media/content/media/IncreaseSeekHandler 
.const [109] = Utf8 startedWithSeekForward 
.const [110] = Utf8 Z 
.const [111] = Utf8 de/audi/app/media/content/media/IncreaseSeekHandler 
.const [112] = Utf8 seeker 
.const [113] = Utf8 Lde/audi/app/media/content/media/ISeeker; 
.const [114] = Utf8 de/audi/app/media/content/media/IncreaseSeekHandler 
.const [115] = Utf8 logger 
.const [116] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [117] = Utf8 de/audi/app/media/content/media/IncreaseSeekHandler 
.const [118] = Utf8 seekingTimer 
.const [119] = Utf8 Lde/audi/atip/timer/Timer; 
.const [120] = Utf8 de/audi/atip/log/LogChannel 
.const [121] = Utf8 log 
.const [122] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [123] = Utf8 de/audi/atip/log/LogChannel 
.const [124] = Utf8 log 
.const [125] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [126] = Utf8 de/audi/atip/timer/Timer 
.const [127] = Utf8 cancel 
.const [128] = Utf8 ()Z 
.const [129] = Utf8 de/audi/atip/log/LogChannel 
.const [130] = Utf8 log 
.const [131] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;J)V 
.const [132] = Utf8 de/audi/atip/log/LogChannel 
.const [133] = Utf8 log 
.const [134] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [135] = Utf8 de/audi/atip/timer/Timer 
.const [136] = Utf8 setDelay 
.const [137] = Utf8 (J)V 
.const [138] = Utf8 de/audi/atip/timer/Timer 
.const [139] = Utf8 restart 
.const [140] = Utf8 ()V 
.const [141] = Utf8 de/audi/atip/log/LogChannel 
.const [142] = Utf8 log 
.const [143] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [144] = Utf8 java/lang/Object 
.const [145] = Utf8 <init> 
.const [146] = Utf8 ()V 
.const [147] = Utf8 de/audi/atip/timer/Timer 
.const [148] = Utf8 <init> 
.const [149] = Utf8 (Ljava/lang/String;ILde/audi/atip/log/LogChannel;Lde/audi/atip/timer/TimerListener;JZ)V 
.const [150] = Utf8 de/audi/app/media/content/media/IncreaseSeekHandler 
.const [151] = Utf8 currentSeekSpeed 
.const [152] = Utf8 I 
.const [153] = Utf8 de/audi/app/media/content/media/IncreaseSeekHandler 
.const [154] = Utf8 startedWithSeekForward 
.const [155] = Utf8 Z 
.const [156] = Utf8 de/audi/app/media/content/media/IncreaseSeekHandler 
.const [157] = Utf8 seeker 
.const [158] = Utf8 Lde/audi/app/media/content/media/ISeeker; 
.const [159] = Utf8 de/audi/app/media/content/media/IncreaseSeekHandler 
.const [160] = Utf8 logger 
.const [161] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [162] = Utf8 de/audi/app/media/content/media/IncreaseSeekHandler 
.const [163] = Utf8 seekingTimer 
.const [164] = Utf8 Lde/audi/atip/timer/Timer; 
.const [165] = Utf8 de/audi/app/media/content/media/ISeeker 
.const [166] = Utf8 getMaxSeekSpeed 
.const [167] = Utf8 ()I 
.const [168] = Utf8 de/audi/app/media/content/media/ISeeker 
.const [169] = Utf8 seek 
.const [170] = Utf8 (ZI)Z 
.const [171] = Utf8 de/audi/app/media/content/media/ISeeker 
.const [172] = Utf8 isFixedSpeedSeeker 
.const [173] = Utf8 ()Z 
.const [174] = Utf8 de/audi/app/media/content/media/IncreaseSeekHandler 
.const [175] = Class [174] 
.const [176] = Utf8 java/lang/Object 
.const [177] = Class [176] 
.const [178] = Utf8 de/audi/atip/timer/TimerListener 
.const [179] = Class [178] 
.const [180] = Utf8 LOGCLASS 
.const [181] = Utf8 Ljava/lang/String; 
.const [182] = Utf8 DEFAULT_SEEK_SPEED 
.const [183] = Utf8 I 
.const [184] = Utf8 DEFAULT_SPEED_CHANGE_TIMEOUT_MS 
.const [185] = Utf8 I 
.const [186] = Utf8 seekingTimer 
.const [187] = Utf8 Lde/audi/atip/timer/Timer; 
.const [188] = Utf8 currentSeekSpeed 
.const [189] = Utf8 I 
.const [190] = Utf8 seeker 
.const [191] = Utf8 Lde/audi/app/media/content/media/ISeeker; 
.const [192] = Utf8 logger 
.const [193] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [194] = Utf8 startedWithSeekForward 
.const [195] = Utf8 Z 
.const [196] = Utf8 Code 
.const [197] = Utf8 <init> 
.const [198] = Utf8 (Lde/audi/app/media/content/media/ISeeker;Lde/audi/atip/log/LogChannel;)V 
.const [199] = Utf8 <init> 
.const [200] = Utf8 (Lde/audi/app/media/content/media/ISeeker;Lde/audi/atip/log/LogChannel;Lde/audi/atip/timer/Timer;)V 
.const [201] = Utf8 cancelTimer 
.const [202] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.const [203] = Utf8 fireTimer 
.const [204] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.const [205] = Utf8 start 
.const [206] = Utf8 (ZJ)Z 
.const [207] = Utf8 stop 
.const [208] = Utf8 ()V 
.end class 
