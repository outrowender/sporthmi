.version 50 0 
.class public super [125] 
.super [127] 
.field public [128] [129] 
.field public [130] [131] 
.field public [132] [133] 
.field public [134] [135] 
.field public [136] [137] 

.method public static [139] : [140] 
    .attribute [138] .code stack 3 locals 1 
L0:     aconst_null 
L1:     astore 4 
L3:     iload_0 
L4:     iconst_m1 
L5:     if_icmple L104 
L8:     iload_1 
L9:     iconst_m1 
L10:    if_icmple L104 
L13:    iload_2 
L14:    iconst_m1 
L15:    if_icmple L104 
L18:    aload_3 
L19:    ifnull L104 
L22:    new [21] 
L25:    dup 
L26:    invokespecial [19] 
L29:    astore 4 
L31:    aload 4 
L33:    iload_0 
L34:    putfield [22] 
L37:    aload 4 
L39:    iconst_0 
L40:    putfield [23] 
L43:    aload 4 
L45:    aload_3 
L46:    putfield [24] 
L49:    aload 4 
L51:    aload 4 
L53:    iload_2 
L54:    invokestatic [3] 
L57:    putfield [25] 
L60:    aload 4 
L62:    getfield [12] 
L65:    ifnull L104 
L68:    aload_3 
L69:    aload 4 
L71:    getfield [12] 
L74:    invokevirtual [13] 
L77:    aload 4 
L79:    aload 4 
L81:    iload_1 
L82:    invokestatic [4] 
L85:    putfield [26] 
L88:    aload 4 
L90:    getfield [14] 
L93:    ifnull L101 
L96:    aload 4 
L98:    goto L102 
L101:   aconst_null 
L102:   astore 4 
L104:   aload 4 
L106:   areturn 
L107:   nop 
L108:   
    .end code 
.end method 

.method private annotation [141] : [142] 
    .attribute [138] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [20] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [143] : [144] 
    .attribute [138] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     getfield [15] 
L7:     aload_1 
L8:     invokevirtual [16] 
L11:    ifne L45 
L14:    aload_0 
L15:    dup 
L16:    getfield [10] 
L19:    iconst_1 
L20:    iadd 
L21:    putfield [23] 
L24:    aload_0 
L25:    getfield [12] 
L28:    getfield [15] 
L31:    aload_1 
L32:    aload_0 
L33:    invokevirtual [17] 
L36:    pop 
L37:    aload_0 
L38:    getfield [11] 
L41:    aload_2 
L42:    invokevirtual [18] 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [27] 
.const [3] = Method [28] [29] 
.const [4] = Method [30] [31] 
.const [5] = Class [32] 
.const [6] = Class [33] 
.const [7] = Class [34] 
.const [8] = Class [35] 
.const [9] = Class [36] 
.const [10] = Field [37] [38] 
.const [11] = Field [39] [40] 
.const [12] = Field [41] [42] 
.const [13] = Method [43] [44] 
.const [14] = Field [45] [46] 
.const [15] = Field [47] [48] 
.const [16] = Method [49] [50] 
.const [17] = Method [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = Method [57] [58] 
.const [21] = Class [59] 
.const [22] = Field [60] [61] 
.const [23] = Field [62] [63] 
.const [24] = Field [64] [65] 
.const [25] = Field [66] [67] 
.const [26] = Field [68] [69] 
.const [27] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
.const [28] = Class [70] 
.const [29] = NameAndType [71] [72] 
.const [30] = Class [73] 
.const [31] = NameAndType [74] [75] 
.const [32] = Utf8 java/lang/Object 
.const [33] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [34] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation 
.const [35] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRefCtrlObj 
.const [36] = Utf8 java/util/HashMap 
.const [37] = Class [76] 
.const [38] = NameAndType [77] [78] 
.const [39] = Class [79] 
.const [40] = NameAndType [80] [81] 
.const [41] = Class [82] 
.const [42] = NameAndType [83] [84] 
.const [43] = Class [85] 
.const [44] = NameAndType [86] [87] 
.const [45] = Class [88] 
.const [46] = NameAndType [89] [90] 
.const [47] = Class [91] 
.const [48] = NameAndType [92] [93] 
.const [49] = Class [94] 
.const [50] = NameAndType [95] [96] 
.const [51] = Class [97] 
.const [52] = NameAndType [98] [99] 
.const [53] = Class [100] 
.const [54] = NameAndType [101] [102] 
.const [55] = Class [103] 
.const [56] = NameAndType [104] [105] 
.const [57] = Class [106] 
.const [58] = NameAndType [107] [108] 
.const [59] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
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
.const [70] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [71] = Utf8 newInstance 
.const [72] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef;I)Lde/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener; 
.const [73] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRefCtrlObj 
.const [74] = Utf8 newInstance 
.const [75] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef;I)Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRefCtrlObj; 
.const [76] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
.const [77] = Utf8 refCount 
.const [78] = Utf8 I 
.const [79] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
.const [80] = Utf8 animation 
.const [81] = Utf8 Lde/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation; 
.const [82] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
.const [83] = Utf8 animationListener 
.const [84] = Utf8 Lde/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener; 
.const [85] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation 
.const [86] = Utf8 addListener 
.const [87] = Utf8 (Lde/audi/atip/hmi/view/AnimationListener;)V 
.const [88] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
.const [89] = Utf8 animationControl 
.const [90] = Utf8 Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRefCtrlObj; 
.const [91] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [92] = Utf8 m_refMap 
.const [93] = Utf8 Ljava/util/HashMap; 
.const [94] = Utf8 java/util/HashMap 
.const [95] = Utf8 containsKey 
.const [96] = Utf8 (Ljava/lang/Object;)Z 
.const [97] = Utf8 java/util/HashMap 
.const [98] = Utf8 put 
.const [99] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [100] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation 
.const [101] = Utf8 setRepaintTarget 
.const [102] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/AbstractWidget;)V 
.const [103] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
.const [104] = Utf8 <init> 
.const [105] = Utf8 ()V 
.const [106] = Utf8 java/lang/Object 
.const [107] = Utf8 <init> 
.const [108] = Utf8 ()V 
.const [109] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
.const [110] = Utf8 index 
.const [111] = Utf8 I 
.const [112] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
.const [113] = Utf8 refCount 
.const [114] = Utf8 I 
.const [115] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
.const [116] = Utf8 animation 
.const [117] = Utf8 Lde/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation; 
.const [118] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
.const [119] = Utf8 animationListener 
.const [120] = Utf8 Lde/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener; 
.const [121] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
.const [122] = Utf8 animationControl 
.const [123] = Utf8 Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRefCtrlObj; 
.const [124] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
.const [125] = Class [124] 
.const [126] = Utf8 java/lang/Object 
.const [127] = Class [126] 
.const [128] = Utf8 index 
.const [129] = Utf8 I 
.const [130] = Utf8 refCount 
.const [131] = Utf8 I 
.const [132] = Utf8 animation 
.const [133] = Utf8 Lde/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation; 
.const [134] = Utf8 animationListener 
.const [135] = Utf8 Lde/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener; 
.const [136] = Utf8 animationControl 
.const [137] = Utf8 Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRefCtrlObj; 
.const [138] = Utf8 Code 
.const [139] = Utf8 newInstance 
.const [140] = Utf8 (IIILde/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation;)Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef; 
.const [141] = Utf8 <init> 
.const [142] = Utf8 ()V 
.const [143] = Utf8 putIfNotContained 
.const [144] = Utf8 (Lde/audi/atip/hmi/view/AnimationListener;Lde/esolutions/hmi/widgets/audi/base/AbstractWidget;)V 
.end class 
