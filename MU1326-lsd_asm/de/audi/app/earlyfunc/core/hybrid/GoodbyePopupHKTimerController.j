.version 50 0 
.class public super [131] 
.super [133] 
.field private static final [134] [135] 
.field private static final [136] [137] 
.field private [138] [139] 
.field private [140] [141] 
.field private [142] [143] 
.field private [144] [145] 
.field private [146] [147] 
.field private [148] [149] 

.method public [151] : [152] 
    .attribute [150] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [21] 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [22] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [23] 
L19:    aload_0 
L20:    iconst_0 
L21:    putfield [20] 
L24:    aload_0 
L25:    lconst_0 
L26:    putfield [24] 
L29:    aload_0 
L30:    aload_3 
L31:    putfield [22] 
L34:    aload_0 
L35:    aload_1 
L36:    putfield [21] 
L39:    aload_0 
L40:    aload_2 
L41:    putfield [25] 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public synchronized [153] : [154] 
    .attribute [150] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public synchronized [155] : [156] 
    .attribute [150] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     ifnull L20 
L7:     aload_0 
L8:     getfield [11] 
L11:    invokevirtual [14] 
L14:    pop 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [20] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public synchronized [157] : [158] 
    .attribute [150] .code stack 8 locals 4 
L0:     aload_0 
L1:     getfield [9] 
L4:     ifeq L78 
L7:     aload_0 
L8:     getfield [11] 
L11:    ifnull L22 
L14:    aload_0 
L15:    getfield [11] 
L18:    invokevirtual [14] 
L21:    pop 
L22:    aload_0 
L23:    getfield [13] 
L26:    invokeinterface [26] 0 
L31:    aload_0 
L32:    getfield [12] 
L35:    lsub 
L36:    lstore_1 
L37:    ldc_w [1] 
L40:    lload_1 
L41:    lsub 
L42:    lstore_3 
L43:    lload_3 
L44:    lconst_0 
L45:    lcmp 
L46:    ifle L75 
L49:    aload_0 
L50:    new [27] 
L53:    dup 
L54:    ldc [3] 
L56:    lload_3 
L57:    iconst_1 
L58:    aload_0 
L59:    invokespecial [17] 
L62:    invokespecial [18] 
L65:    putfield [23] 
L68:    aload_0 
L69:    getfield [11] 
L72:    invokevirtual [15] 
L75:    goto L139 
L78:    aload_0 
L79:    getfield [11] 
L82:    ifnull L93 
L85:    aload_0 
L86:    getfield [11] 
L89:    invokevirtual [14] 
L92:    pop 
L93:    aload_0 
L94:    new [27] 
L97:    dup 
L98:    ldc [4] 
L100:   ldc_w [1] 
L103:   iconst_1 
L104:   aload_0 
L105:   invokespecial [17] 
L108:   invokespecial [18] 
L111:   putfield [23] 
L114:   aload_0 
L115:   getfield [11] 
L118:   invokevirtual [15] 
L121:   aload_0 
L122:   aload_0 
L123:   getfield [13] 
L126:   invokeinterface [26] 0 
L131:   putfield [24] 
L134:   aload_0 
L135:   iconst_1 
L136:   putfield [20] 
L139:   return 
L140:   
    .end code 
.end method 

.method private [159] : [160] 
    .attribute [150] .code stack 3 locals 1 
L0:     new [28] 
L3:     dup 
L4:     aload_0 
L5:     invokespecial [19] 
L8:     astore_1 
L9:     aload_1 
L10:    areturn 
L11:    nop 
L12:    
    .end code 
.end method 

.method static synthetic [161] : [162] 
    .attribute [150] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [163] : [164] 
    .attribute [150] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     dup_x1 
L3:     putfield [20] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [31] 
.const [3] = String [32] 
.const [4] = String [33] 
.const [5] = Class [34] 
.const [6] = Class [35] 
.const [7] = Class [36] 
.const [8] = Class [37] 
.const [9] = Field [38] [39] 
.const [10] = Field [40] [41] 
.const [11] = Field [42] [43] 
.const [12] = Field [44] [45] 
.const [13] = Field [46] [47] 
.const [14] = Method [48] [49] 
.const [15] = Method [50] [51] 
.const [16] = Method [52] [53] 
.const [17] = Method [54] [55] 
.const [18] = Method [56] [57] 
.const [19] = Method [58] [59] 
.const [20] = Field [60] [61] 
.const [21] = Field [62] [63] 
.const [22] = Field [64] [65] 
.const [23] = Field [66] [67] 
.const [24] = Field [68] [69] 
.const [25] = Field [70] [71] 
.const [26] = InterfaceMethod [72] [73] 
.const [27] = Class [74] 
.const [28] = Class [75] 
.const [29] = Int -2136407296 
.const [30] = Int -1059847936 
.const [31] = Utf8 de/audi/atip/timer/Timer 
.const [32] = Utf8 GOODBYE_POPUP_EXTENDED_TIMER 
.const [33] = Utf8 GOODBYE_POPUP_TIMER 
.const [34] = Utf8 de/audi/app/earlyfunc/core/hybrid/GoodbyePopupHKTimerController$1 
.const [35] = Utf8 de/audi/app/earlyfunc/core/hybrid/GoodbyePopupHKTimerController 
.const [36] = Utf8 java/lang/Object 
.const [37] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [38] = Class [76] 
.const [39] = NameAndType [77] [78] 
.const [40] = Class [79] 
.const [41] = NameAndType [80] [81] 
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
.const [64] = Class [115] 
.const [65] = NameAndType [116] [117] 
.const [66] = Class [118] 
.const [67] = NameAndType [119] [120] 
.const [68] = Class [121] 
.const [69] = NameAndType [122] [123] 
.const [70] = Class [124] 
.const [71] = NameAndType [125] [126] 
.const [72] = Class [127] 
.const [73] = NameAndType [128] [129] 
.const [74] = Utf8 de/audi/atip/timer/Timer 
.const [75] = Utf8 de/audi/app/earlyfunc/core/hybrid/GoodbyePopupHKTimerController$1 
.const [76] = Utf8 de/audi/app/earlyfunc/core/hybrid/GoodbyePopupHKTimerController 
.const [77] = Utf8 timerCanceledPrematurely 
.const [78] = Utf8 Z 
.const [79] = Utf8 de/audi/app/earlyfunc/core/hybrid/GoodbyePopupHKTimerController 
.const [80] = Utf8 popupHandler 
.const [81] = Utf8 Lde/audi/app/earlyfunc/core/hybrid/ChargePopupHandler; 
.const [82] = Utf8 de/audi/app/earlyfunc/core/hybrid/GoodbyePopupHKTimerController 
.const [83] = Utf8 timer 
.const [84] = Utf8 Lde/audi/atip/timer/Timer; 
.const [85] = Utf8 de/audi/app/earlyfunc/core/hybrid/GoodbyePopupHKTimerController 
.const [86] = Utf8 start 
.const [87] = Utf8 J 
.const [88] = Utf8 de/audi/app/earlyfunc/core/hybrid/GoodbyePopupHKTimerController 
.const [89] = Utf8 framework 
.const [90] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [91] = Utf8 de/audi/atip/timer/Timer 
.const [92] = Utf8 cancel 
.const [93] = Utf8 ()Z 
.const [94] = Utf8 de/audi/atip/timer/Timer 
.const [95] = Utf8 start 
.const [96] = Utf8 ()V 
.const [97] = Utf8 java/lang/Object 
.const [98] = Utf8 <init> 
.const [99] = Utf8 ()V 
.const [100] = Utf8 de/audi/app/earlyfunc/core/hybrid/GoodbyePopupHKTimerController 
.const [101] = Utf8 createTimerListener 
.const [102] = Utf8 ()Lde/audi/atip/timer/TimerListener; 
.const [103] = Utf8 de/audi/atip/timer/Timer 
.const [104] = Utf8 <init> 
.const [105] = Utf8 (Ljava/lang/String;JZLde/audi/atip/timer/TimerListener;)V 
.const [106] = Utf8 de/audi/app/earlyfunc/core/hybrid/GoodbyePopupHKTimerController$1 
.const [107] = Utf8 <init> 
.const [108] = Utf8 (Lde/audi/app/earlyfunc/core/hybrid/GoodbyePopupHKTimerController;)V 
.const [109] = Utf8 de/audi/app/earlyfunc/core/hybrid/GoodbyePopupHKTimerController 
.const [110] = Utf8 timerCanceledPrematurely 
.const [111] = Utf8 Z 
.const [112] = Utf8 de/audi/app/earlyfunc/core/hybrid/GoodbyePopupHKTimerController 
.const [113] = Utf8 popupHandler 
.const [114] = Utf8 Lde/audi/app/earlyfunc/core/hybrid/ChargePopupHandler; 
.const [115] = Utf8 de/audi/app/earlyfunc/core/hybrid/GoodbyePopupHKTimerController 
.const [116] = Utf8 logChannel 
.const [117] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [118] = Utf8 de/audi/app/earlyfunc/core/hybrid/GoodbyePopupHKTimerController 
.const [119] = Utf8 timer 
.const [120] = Utf8 Lde/audi/atip/timer/Timer; 
.const [121] = Utf8 de/audi/app/earlyfunc/core/hybrid/GoodbyePopupHKTimerController 
.const [122] = Utf8 start 
.const [123] = Utf8 J 
.const [124] = Utf8 de/audi/app/earlyfunc/core/hybrid/GoodbyePopupHKTimerController 
.const [125] = Utf8 framework 
.const [126] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [127] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [128] = Utf8 getMonotonicTime 
.const [129] = Utf8 ()J 
.const [130] = Utf8 de/audi/app/earlyfunc/core/hybrid/GoodbyePopupHKTimerController 
.const [131] = Class [130] 
.const [132] = Utf8 java/lang/Object 
.const [133] = Class [132] 
.const [134] = Utf8 GOODBYE_POPUP_TIMEOUT 
.const [135] = Utf8 J 
.const [136] = Utf8 GOODBYE_POPUP_EXTENDED_TIMEOUT 
.const [137] = Utf8 J 
.const [138] = Utf8 popupHandler 
.const [139] = Utf8 Lde/audi/app/earlyfunc/core/hybrid/ChargePopupHandler; 
.const [140] = Utf8 framework 
.const [141] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [142] = Utf8 logChannel 
.const [143] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [144] = Utf8 timer 
.const [145] = Utf8 Lde/audi/atip/timer/Timer; 
.const [146] = Utf8 timerCanceledPrematurely 
.const [147] = Utf8 Z 
.const [148] = Utf8 start 
.const [149] = Utf8 J 
.const [150] = Utf8 Code 
.const [151] = Utf8 <init> 
.const [152] = Utf8 (Lde/audi/app/earlyfunc/core/hybrid/ChargePopupHandler;Lde/audi/atip/base/IFrameworkAccess;Lde/audi/atip/log/LogChannel;)V 
.const [153] = Utf8 activate 
.const [154] = Utf8 ()V 
.const [155] = Utf8 deactivate 
.const [156] = Utf8 ()V 
.const [157] = Utf8 resetActivated 
.const [158] = Utf8 ()V 
.const [159] = Utf8 createTimerListener 
.const [160] = Utf8 ()Lde/audi/atip/timer/TimerListener; 
.const [161] = Utf8 access$000 
.const [162] = Utf8 (Lde/audi/app/earlyfunc/core/hybrid/GoodbyePopupHKTimerController;)Lde/audi/app/earlyfunc/core/hybrid/ChargePopupHandler; 
.const [163] = Utf8 access$102 
.const [164] = Utf8 (Lde/audi/app/earlyfunc/core/hybrid/GoodbyePopupHKTimerController;Z)Z 
.end class 
