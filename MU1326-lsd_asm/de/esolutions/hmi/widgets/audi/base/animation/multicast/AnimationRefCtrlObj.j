.version 50 0 
.class public super [133] 
.super [135] 
.field private [136] [137] 
.field private [138] [139] 

.method public static [141] : [142] 
    .attribute [140] .code stack 2 locals 1 
L0:     aconst_null 
L1:     astore_2 
L2:     aload_0 
L3:     ifnull L28 
L6:     iload_1 
L7:     ifle L28 
L10:    new [23] 
L13:    dup 
L14:    invokespecial [21] 
L17:    astore_2 
L18:    aload_2 
L19:    aload_0 
L20:    putfield [24] 
L23:    aload_2 
L24:    iload_1 
L25:    putfield [25] 
L28:    aload_2 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method private annotation [143] : [144] 
    .attribute [140] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [145] : [146] 
    .attribute [140] .code stack 4 locals 1 
L0:     aload_0 
L1:     invokevirtual [11] 
L4:     ifne L83 
L7:     aload_0 
L8:     getfield [9] 
L11:    getfield [12] 
L14:    fconst_0 
L15:    putfield [26] 
L18:    aload_0 
L19:    getfield [9] 
L22:    getfield [12] 
L25:    iconst_0 
L26:    putfield [27] 
L29:    aload_0 
L30:    getfield [9] 
L33:    getfield [12] 
L36:    getfield [15] 
L39:    invokeinterface [28] 0 
L44:    astore_1 
L45:    aload_1 
L46:    ifnull L83 
L49:    aload_1 
L50:    arraylength 
L51:    ifle L83 
L54:    aload_1 
L55:    iconst_0 
L56:    aaload 
L57:    instanceof [3] 
L60:    ifeq L83 
L63:    aload_0 
L64:    getfield [9] 
L67:    getfield [16] 
L70:    aload_0 
L71:    getfield [10] 
L74:    aload_1 
L75:    iconst_0 
L76:    aaload 
L77:    checkcast [3] 
L80:    invokevirtual [17] 
L83:    return 
L84:    
    .end code 
.end method 

.method public [147] : [148] 
    .attribute [140] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     getfield [18] 
L7:     iconst_1 
L8:     if_icmpgt L43 
L11:    aload_0 
L12:    getfield [9] 
L15:    getfield [16] 
L18:    invokevirtual [19] 
L21:    aload_0 
L22:    getfield [9] 
L25:    getfield [12] 
L28:    fconst_0 
L29:    putfield [26] 
L32:    aload_0 
L33:    getfield [9] 
L36:    getfield [12] 
L39:    iconst_0 
L40:    putfield [27] 
L43:    return 
L44:    
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [140] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     getfield [16] 
L7:     invokevirtual [20] 
L10:    areturn 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [151] : [152] 
    .attribute [140] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     getfield [12] 
L7:     getfield [13] 
L10:    areturn 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [140] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     getfield [12] 
L7:     getfield [14] 
L10:    i2f 
L11:    areturn 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [29] 
.const [3] = Class [30] 
.const [4] = Class [31] 
.const [5] = Class [32] 
.const [6] = Class [33] 
.const [7] = Class [34] 
.const [8] = Class [35] 
.const [9] = Field [36] [37] 
.const [10] = Field [38] [39] 
.const [11] = Method [40] [41] 
.const [12] = Field [42] [43] 
.const [13] = Field [44] [45] 
.const [14] = Field [46] [47] 
.const [15] = Field [48] [49] 
.const [16] = Field [50] [51] 
.const [17] = Method [52] [53] 
.const [18] = Field [54] [55] 
.const [19] = Method [56] [57] 
.const [20] = Method [58] [59] 
.const [21] = Method [60] [61] 
.const [22] = Method [62] [63] 
.const [23] = Class [64] 
.const [24] = Field [65] [66] 
.const [25] = Field [67] [68] 
.const [26] = Field [69] [70] 
.const [27] = Field [71] [72] 
.const [28] = InterfaceMethod [73] [74] 
.const [29] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRefCtrlObj 
.const [30] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [31] = Utf8 java/lang/Object 
.const [32] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
.const [33] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [34] = Utf8 java/util/Set 
.const [35] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation 
.const [36] = Class [75] 
.const [37] = NameAndType [76] [77] 
.const [38] = Class [78] 
.const [39] = NameAndType [79] [80] 
.const [40] = Class [81] 
.const [41] = NameAndType [82] [83] 
.const [42] = Class [84] 
.const [43] = NameAndType [85] [86] 
.const [44] = Class [87] 
.const [45] = NameAndType [88] [89] 
.const [46] = Class [90] 
.const [47] = NameAndType [91] [92] 
.const [48] = Class [93] 
.const [49] = NameAndType [94] [95] 
.const [50] = Class [96] 
.const [51] = NameAndType [97] [98] 
.const [52] = Class [99] 
.const [53] = NameAndType [100] [101] 
.const [54] = Class [102] 
.const [55] = NameAndType [103] [104] 
.const [56] = Class [105] 
.const [57] = NameAndType [106] [107] 
.const [58] = Class [108] 
.const [59] = NameAndType [109] [110] 
.const [60] = Class [111] 
.const [61] = NameAndType [112] [113] 
.const [62] = Class [114] 
.const [63] = NameAndType [115] [116] 
.const [64] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRefCtrlObj 
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
.const [75] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRefCtrlObj 
.const [76] = Utf8 m_animRef 
.const [77] = Utf8 Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef; 
.const [78] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRefCtrlObj 
.const [79] = Utf8 m_timerInterval 
.const [80] = Utf8 I 
.const [81] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRefCtrlObj 
.const [82] = Utf8 isAnimationRunning 
.const [83] = Utf8 ()Z 
.const [84] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
.const [85] = Utf8 animationListener 
.const [86] = Utf8 Lde/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener; 
.const [87] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [88] = Utf8 m_progress 
.const [89] = Utf8 F 
.const [90] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [91] = Utf8 m_value 
.const [92] = Utf8 I 
.const [93] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [94] = Utf8 m_refKeySet 
.const [95] = Utf8 Ljava/util/Set; 
.const [96] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
.const [97] = Utf8 animation 
.const [98] = Utf8 Lde/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation; 
.const [99] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation 
.const [100] = Utf8 startEndlessAnimation 
.const [101] = Utf8 (ILde/esolutions/hmi/widgets/audi/base/AbstractWidget;)V 
.const [102] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
.const [103] = Utf8 refCount 
.const [104] = Utf8 I 
.const [105] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation 
.const [106] = Utf8 stopAnimation 
.const [107] = Utf8 ()V 
.const [108] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation 
.const [109] = Utf8 isAnimating 
.const [110] = Utf8 ()Z 
.const [111] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRefCtrlObj 
.const [112] = Utf8 <init> 
.const [113] = Utf8 ()V 
.const [114] = Utf8 java/lang/Object 
.const [115] = Utf8 <init> 
.const [116] = Utf8 ()V 
.const [117] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRefCtrlObj 
.const [118] = Utf8 m_animRef 
.const [119] = Utf8 Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef; 
.const [120] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRefCtrlObj 
.const [121] = Utf8 m_timerInterval 
.const [122] = Utf8 I 
.const [123] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [124] = Utf8 m_progress 
.const [125] = Utf8 F 
.const [126] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [127] = Utf8 m_value 
.const [128] = Utf8 I 
.const [129] = Utf8 java/util/Set 
.const [130] = Utf8 toArray 
.const [131] = Utf8 ()[Ljava/lang/Object; 
.const [132] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRefCtrlObj 
.const [133] = Class [132] 
.const [134] = Utf8 java/lang/Object 
.const [135] = Class [134] 
.const [136] = Utf8 m_animRef 
.const [137] = Utf8 Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef; 
.const [138] = Utf8 m_timerInterval 
.const [139] = Utf8 I 
.const [140] = Utf8 Code 
.const [141] = Utf8 newInstance 
.const [142] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef;I)Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRefCtrlObj; 
.const [143] = Utf8 <init> 
.const [144] = Utf8 ()V 
.const [145] = Utf8 start 
.const [146] = Utf8 ()V 
.const [147] = Utf8 stop 
.const [148] = Utf8 ()V 
.const [149] = Utf8 isAnimationRunning 
.const [150] = Utf8 ()Z 
.const [151] = Utf8 getProgress 
.const [152] = Utf8 ()F 
.const [153] = Utf8 getValue 
.const [154] = Utf8 ()F 
.end class 
