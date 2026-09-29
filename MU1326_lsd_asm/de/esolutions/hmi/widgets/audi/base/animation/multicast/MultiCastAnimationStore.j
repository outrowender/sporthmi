.version 50 0 
.class public super [129] 
.super [131] 
.field protected [132] [133] 

.method public static synchronized [135] : [136] 
    .attribute [134] .code stack 6 locals 5 
L0:     aconst_null 
L1:     astore_3 
L2:     aload_0 
L3:     ifnull L117 
L6:     aload_1 
L7:     ifnull L117 
L10:    aload_2 
L11:    ifnull L117 
L14:    aload_1 
L15:    arraylength 
L16:    ifle L117 
L19:    aload_1 
L20:    arraylength 
L21:    aload_2 
L22:    arraylength 
L23:    if_icmpne L117 
L26:    iconst_0 
L27:    istore 4 
L29:    aload_1 
L30:    arraylength 
L31:    anewarray [2] 
L34:    astore 5 
L36:    iconst_0 
L37:    istore 6 
L39:    iload 6 
L41:    aload 5 
L43:    arraylength 
L44:    if_icmpge L102 
L47:    aload_0 
L48:    invokevirtual [11] 
L51:    iconst_1 
L52:    invokeinterface [25] 0 
L57:    checkcast [3] 
L60:    astore 7 
L62:    aload 5 
L64:    iload 6 
L66:    iload 6 
L68:    aload_1 
L69:    iload 6 
L71:    iaload 
L72:    aload_2 
L73:    iload 6 
L75:    iaload 
L76:    aload 7 
L78:    invokestatic [4] 
L81:    aastore 
L82:    aload 5 
L84:    iload 6 
L86:    aaload 
L87:    ifnonnull L96 
L90:    iconst_1 
L91:    istore 4 
L93:    goto L102 
L96:    iinc 6 1 
L99:    goto L39 
L102:   iload 4 
L104:   ifne L117 
L107:   new [26] 
L110:   dup 
L111:   aload 5 
L113:   invokespecial [23] 
L116:   astore_3 
L117:   aload_3 
L118:   areturn 
L119:   nop 
L120:   
    .end code 
.end method 

.method private [137] : [138] 
    .attribute [134] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [27] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [139] : [140] 
    .attribute [134] .code stack 3 locals 2 
L0:     aconst_null 
L1:     astore_3 
L2:     aload_1 
L3:     ifnull L75 
L6:     iload_2 
L7:     iconst_m1 
L8:     if_icmple L75 
L11:    iload_2 
L12:    aload_0 
L13:    getfield [12] 
L16:    arraylength 
L17:    if_icmpge L75 
L20:    aload_0 
L21:    getfield [12] 
L24:    iload_2 
L25:    aaload 
L26:    astore 4 
L28:    aload 4 
L30:    getfield [13] 
L33:    astore_3 
L34:    aload 4 
L36:    getfield [14] 
L39:    getfield [15] 
L42:    aload_1 
L43:    invokevirtual [16] 
L46:    ifne L75 
L49:    aload 4 
L51:    dup 
L52:    getfield [17] 
L55:    iconst_1 
L56:    iadd 
L57:    putfield [28] 
L60:    aload 4 
L62:    getfield [14] 
L65:    getfield [15] 
L68:    aload_1 
L69:    aload 4 
L71:    invokevirtual [18] 
L74:    pop 
L75:    aload_3 
L76:    areturn 
L77:    nop 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [134] .code stack 3 locals 2 
L0:     aconst_null 
L1:     astore 4 
L3:     aload_1 
L4:     ifnull L43 
L7:     iload_3 
L8:     iconst_m1 
L9:     if_icmple L43 
L12:    iload_3 
L13:    aload_0 
L14:    getfield [12] 
L17:    arraylength 
L18:    if_icmpge L43 
L21:    aload_0 
L22:    getfield [12] 
L25:    iload_3 
L26:    aaload 
L27:    astore 5 
L29:    aload 5 
L31:    getfield [13] 
L34:    astore 4 
L36:    aload 5 
L38:    aload_1 
L39:    aload_2 
L40:    invokevirtual [19] 
L43:    aload 4 
L45:    areturn 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [143] : [144] 
    .attribute [134] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnull L70 
L4:     iload_2 
L5:     iconst_m1 
L6:     if_icmple L70 
L9:     iload_2 
L10:    aload_0 
L11:    getfield [12] 
L14:    arraylength 
L15:    if_icmpge L70 
L18:    aload_0 
L19:    getfield [12] 
L22:    iload_2 
L23:    aaload 
L24:    astore_3 
L25:    aload_3 
L26:    getfield [14] 
L29:    getfield [15] 
L32:    aload_1 
L33:    invokevirtual [20] 
L36:    checkcast [2] 
L39:    astore 4 
L41:    aload 4 
L43:    ifnull L70 
L46:    aload_3 
L47:    dup 
L48:    getfield [17] 
L51:    iconst_1 
L52:    isub 
L53:    putfield [28] 
L56:    aload_3 
L57:    getfield [17] 
L60:    ifne L70 
L63:    aload_3 
L64:    getfield [21] 
L67:    invokevirtual [22] 
L70:    return 
L71:    nop 
L72:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [29] 
.const [3] = Class [30] 
.const [4] = Method [31] [32] 
.const [5] = Class [33] 
.const [6] = Class [34] 
.const [7] = Class [35] 
.const [8] = Class [36] 
.const [9] = Class [37] 
.const [10] = Class [38] 
.const [11] = Method [39] [40] 
.const [12] = Field [41] [42] 
.const [13] = Field [43] [44] 
.const [14] = Field [45] [46] 
.const [15] = Field [47] [48] 
.const [16] = Method [49] [50] 
.const [17] = Field [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = Method [57] [58] 
.const [21] = Field [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = InterfaceMethod [67] [68] 
.const [26] = Class [69] 
.const [27] = Field [70] [71] 
.const [28] = Field [72] [73] 
.const [29] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
.const [30] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation 
.const [31] = Class [74] 
.const [32] = NameAndType [75] [76] 
.const [33] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationStore 
.const [34] = Utf8 java/lang/Object 
.const [35] = Utf8 de/esolutions/hmi/widgets/audi/base/HMITerminalImpl 
.const [36] = Utf8 de/audi/atip/hmi/view/IAnimationController 
.const [37] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [38] = Utf8 java/util/HashMap 
.const [39] = Class [77] 
.const [40] = NameAndType [78] [79] 
.const [41] = Class [80] 
.const [42] = NameAndType [81] [82] 
.const [43] = Class [83] 
.const [44] = NameAndType [84] [85] 
.const [45] = Class [86] 
.const [46] = NameAndType [87] [88] 
.const [47] = Class [89] 
.const [48] = NameAndType [90] [91] 
.const [49] = Class [92] 
.const [50] = NameAndType [93] [94] 
.const [51] = Class [95] 
.const [52] = NameAndType [96] [97] 
.const [53] = Class [98] 
.const [54] = NameAndType [99] [100] 
.const [55] = Class [101] 
.const [56] = NameAndType [102] [103] 
.const [57] = Class [104] 
.const [58] = NameAndType [105] [106] 
.const [59] = Class [107] 
.const [60] = NameAndType [108] [109] 
.const [61] = Class [110] 
.const [62] = NameAndType [111] [112] 
.const [63] = Class [113] 
.const [64] = NameAndType [114] [115] 
.const [65] = Class [116] 
.const [66] = NameAndType [117] [118] 
.const [67] = Class [119] 
.const [68] = NameAndType [120] [121] 
.const [69] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationStore 
.const [70] = Class [122] 
.const [71] = NameAndType [123] [124] 
.const [72] = Class [125] 
.const [73] = NameAndType [126] [127] 
.const [74] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
.const [75] = Utf8 newInstance 
.const [76] = Utf8 (IIILde/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation;)Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef; 
.const [77] = Utf8 de/esolutions/hmi/widgets/audi/base/HMITerminalImpl 
.const [78] = Utf8 getIAnimationController 
.const [79] = Utf8 ()Lde/audi/atip/hmi/view/IAnimationController; 
.const [80] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationStore 
.const [81] = Utf8 m_uniqueAnimations 
.const [82] = Utf8 [Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef; 
.const [83] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
.const [84] = Utf8 animationControl 
.const [85] = Utf8 Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRefCtrlObj; 
.const [86] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
.const [87] = Utf8 animationListener 
.const [88] = Utf8 Lde/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener; 
.const [89] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [90] = Utf8 m_refMap 
.const [91] = Utf8 Ljava/util/HashMap; 
.const [92] = Utf8 java/util/HashMap 
.const [93] = Utf8 containsKey 
.const [94] = Utf8 (Ljava/lang/Object;)Z 
.const [95] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
.const [96] = Utf8 refCount 
.const [97] = Utf8 I 
.const [98] = Utf8 java/util/HashMap 
.const [99] = Utf8 put 
.const [100] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [101] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
.const [102] = Utf8 putIfNotContained 
.const [103] = Utf8 (Lde/audi/atip/hmi/view/AnimationListener;Lde/esolutions/hmi/widgets/audi/base/AbstractWidget;)V 
.const [104] = Utf8 java/util/HashMap 
.const [105] = Utf8 remove 
.const [106] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [107] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
.const [108] = Utf8 animation 
.const [109] = Utf8 Lde/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation; 
.const [110] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation 
.const [111] = Utf8 stopAnimation 
.const [112] = Utf8 ()V 
.const [113] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationStore 
.const [114] = Utf8 <init> 
.const [115] = Utf8 ([Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef;)V 
.const [116] = Utf8 java/lang/Object 
.const [117] = Utf8 <init> 
.const [118] = Utf8 ()V 
.const [119] = Utf8 de/audi/atip/hmi/view/IAnimationController 
.const [120] = Utf8 getIAnimation 
.const [121] = Utf8 (I)Lde/audi/atip/hmi/view/IAnimation; 
.const [122] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationStore 
.const [123] = Utf8 m_uniqueAnimations 
.const [124] = Utf8 [Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef; 
.const [125] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
.const [126] = Utf8 refCount 
.const [127] = Utf8 I 
.const [128] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationStore 
.const [129] = Class [128] 
.const [130] = Utf8 java/lang/Object 
.const [131] = Class [130] 
.const [132] = Utf8 m_uniqueAnimations 
.const [133] = Utf8 [Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef; 
.const [134] = Utf8 Code 
.const [135] = Utf8 newInstance 
.const [136] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/HMITerminalImpl;[I[I)Lde/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationStore; 
.const [137] = Utf8 <init> 
.const [138] = Utf8 ([Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef;)V 
.const [139] = Utf8 aquireAnimationRef 
.const [140] = Utf8 (Lde/audi/atip/hmi/view/AnimationListener;I)Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRefCtrlObj; 
.const [141] = Utf8 aquireAnimationRef 
.const [142] = Utf8 (Lde/audi/atip/hmi/view/AnimationListener;Lde/esolutions/hmi/widgets/audi/base/AbstractWidget;I)Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRefCtrlObj; 
.const [143] = Utf8 releaseAnimationRef 
.const [144] = Utf8 (Lde/audi/atip/hmi/view/AnimationListener;I)V 
.end class 
