.version 50 0 
.class public super [185] 
.super [187] 
.implements [189] 
.field public [190] [191] 
.field public [192] [193] 
.field public [194] [195] 
.field public [196] [197] 
.field public [198] [199] 
.field public [200] [201] 

.method public static [203] : [204] 
    .attribute [202] .code stack 5 locals 0 
L0:     aload_0 
L1:     ifnull L23 
L4:     new [25] 
L7:     dup 
L8:     aload_0 
L9:     iconst_1 
L10:    iload_1 
L11:    invokestatic [3] 
L14:    invokestatic [4] 
L17:    invokespecial [22] 
L20:    goto L24 
L23:    aconst_null 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private [205] : [206] 
    .attribute [202] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     aload_0 
L5:     new [26] 
L8:     dup 
L9:     invokespecial [24] 
L12:    putfield [27] 
L15:    aload_0 
L16:    aload_0 
L17:    getfield [15] 
L20:    invokevirtual [16] 
L23:    putfield [28] 
L26:    aload_0 
L27:    aconst_null 
L28:    putfield [29] 
L31:    aload_0 
L32:    aload_1 
L33:    putfield [29] 
L36:    aload_0 
L37:    iload_2 
L38:    putfield [30] 
L41:    aload_0 
L42:    fconst_0 
L43:    putfield [31] 
L46:    aload_0 
L47:    iconst_0 
L48:    putfield [32] 
L51:    return 
L52:    
    .end code 
.end method 

.method public [207] : [208] 
    .attribute [202] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [17] 
L4:     invokeinterface [33] 0 
L9:     astore 4 
L11:    aload_0 
L12:    aload_0 
L13:    getfield [20] 
L16:    iconst_1 
L17:    iadd 
L18:    aload_0 
L19:    getfield [19] 
L22:    irem 
L23:    putfield [32] 
L26:    aload_0 
L27:    fconst_0 
L28:    aload_0 
L29:    getfield [19] 
L32:    i2f 
L33:    aload_0 
L34:    getfield [20] 
L37:    i2f 
L38:    invokestatic [6] 
L41:    putfield [31] 
L44:    aload 4 
L46:    invokeinterface [34] 0 
L51:    ifeq L89 
L54:    aload 4 
L56:    invokeinterface [35] 0 
L61:    checkcast [7] 
L64:    astore 5 
L66:    aload 5 
L68:    iload_1 
L69:    aload_0 
L70:    getfield [20] 
L73:    i2f 
L74:    aload_0 
L75:    getfield [18] 
L78:    getfield [21] 
L81:    invokeinterface [36] 0 
L86:    goto L44 
L89:    return 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method public [209] : [210] 
    .attribute [202] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [17] 
L4:     invokeinterface [33] 0 
L9:     astore_3 
L10:    aload_3 
L11:    invokeinterface [34] 0 
L16:    ifeq L48 
L19:    aload_3 
L20:    invokeinterface [35] 0 
L25:    checkcast [7] 
L28:    astore 4 
L30:    aload 4 
L32:    iload_1 
L33:    aload_0 
L34:    getfield [18] 
L37:    getfield [21] 
L40:    invokeinterface [37] 0 
L45:    goto L10 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [211] : [212] 
    .attribute [202] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [17] 
L4:     invokeinterface [33] 0 
L9:     astore_3 
L10:    aload_3 
L11:    invokeinterface [34] 0 
L16:    ifeq L48 
L19:    aload_3 
L20:    invokeinterface [35] 0 
L25:    checkcast [7] 
L28:    astore 4 
L30:    aload 4 
L32:    iload_1 
L33:    aload_0 
L34:    getfield [18] 
L37:    getfield [21] 
L40:    invokeinterface [38] 0 
L45:    goto L10 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [213] : [214] 
    .attribute [202] .code stack 3 locals 3 
L0:     fconst_1 
L1:     fstore_3 
L2:     fload_0 
L3:     fload_1 
L4:     fcmpl 
L5:     ifeq L33 
L8:     fload_0 
L9:     fload_1 
L10:    invokestatic [8] 
L13:    fstore 4 
L15:    fload_0 
L16:    fload_1 
L17:    invokestatic [9] 
L20:    fstore 5 
L22:    fload_2 
L23:    fload 4 
L25:    fsub 
L26:    fload 5 
L28:    fload 4 
L30:    fsub 
L31:    fdiv 
L32:    fstore_3 
L33:    fload_3 
L34:    areturn 
L35:    nop 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [39] 
.const [3] = Method [40] [41] 
.const [4] = Method [42] [43] 
.const [5] = Class [44] 
.const [6] = Method [45] [46] 
.const [7] = Class [47] 
.const [8] = Method [48] [49] 
.const [9] = Method [50] [51] 
.const [10] = Class [52] 
.const [11] = Class [53] 
.const [12] = Class [54] 
.const [13] = Class [55] 
.const [14] = Class [56] 
.const [15] = Field [57] [58] 
.const [16] = Method [59] [60] 
.const [17] = Field [61] [62] 
.const [18] = Field [63] [64] 
.const [19] = Field [65] [66] 
.const [20] = Field [67] [68] 
.const [21] = Field [69] [70] 
.const [22] = Method [71] [72] 
.const [23] = Method [73] [74] 
.const [24] = Method [75] [76] 
.const [25] = Class [77] 
.const [26] = Class [78] 
.const [27] = Field [79] [80] 
.const [28] = Field [81] [82] 
.const [29] = Field [83] [84] 
.const [30] = Field [85] [86] 
.const [31] = Field [87] [88] 
.const [32] = Field [89] [90] 
.const [33] = InterfaceMethod [91] [92] 
.const [34] = InterfaceMethod [93] [94] 
.const [35] = InterfaceMethod [95] [96] 
.const [36] = InterfaceMethod [97] [98] 
.const [37] = InterfaceMethod [99] [100] 
.const [38] = InterfaceMethod [101] [102] 
.const [39] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [40] = Class [103] 
.const [41] = NameAndType [104] [105] 
.const [42] = Class [106] 
.const [43] = NameAndType [107] [108] 
.const [44] = Utf8 java/util/HashMap 
.const [45] = Class [109] 
.const [46] = NameAndType [110] [111] 
.const [47] = Utf8 de/audi/atip/hmi/view/AnimationListener 
.const [48] = Class [112] 
.const [49] = NameAndType [113] [114] 
.const [50] = Class [115] 
.const [51] = NameAndType [116] [117] 
.const [52] = Utf8 java/lang/Object 
.const [53] = Utf8 java/lang/Math 
.const [54] = Utf8 java/util/Set 
.const [55] = Utf8 java/util/Iterator 
.const [56] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
.const [57] = Class [118] 
.const [58] = NameAndType [119] [120] 
.const [59] = Class [121] 
.const [60] = NameAndType [122] [123] 
.const [61] = Class [124] 
.const [62] = NameAndType [125] [126] 
.const [63] = Class [127] 
.const [64] = NameAndType [128] [129] 
.const [65] = Class [130] 
.const [66] = NameAndType [131] [132] 
.const [67] = Class [133] 
.const [68] = NameAndType [134] [135] 
.const [69] = Class [136] 
.const [70] = NameAndType [137] [138] 
.const [71] = Class [139] 
.const [72] = NameAndType [140] [141] 
.const [73] = Class [142] 
.const [74] = NameAndType [143] [144] 
.const [75] = Class [145] 
.const [76] = NameAndType [146] [147] 
.const [77] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [78] = Utf8 java/util/HashMap 
.const [79] = Class [148] 
.const [80] = NameAndType [149] [150] 
.const [81] = Class [151] 
.const [82] = NameAndType [152] [153] 
.const [83] = Class [154] 
.const [84] = NameAndType [155] [156] 
.const [85] = Class [157] 
.const [86] = NameAndType [158] [159] 
.const [87] = Class [160] 
.const [88] = NameAndType [161] [162] 
.const [89] = Class [163] 
.const [90] = NameAndType [164] [165] 
.const [91] = Class [166] 
.const [92] = NameAndType [167] [168] 
.const [93] = Class [169] 
.const [94] = NameAndType [170] [171] 
.const [95] = Class [172] 
.const [96] = NameAndType [173] [174] 
.const [97] = Class [175] 
.const [98] = NameAndType [176] [177] 
.const [99] = Class [178] 
.const [100] = NameAndType [179] [180] 
.const [101] = Class [181] 
.const [102] = NameAndType [182] [183] 
.const [103] = Utf8 java/lang/Math 
.const [104] = Utf8 abs 
.const [105] = Utf8 (I)I 
.const [106] = Utf8 java/lang/Math 
.const [107] = Utf8 max 
.const [108] = Utf8 (II)I 
.const [109] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [110] = Utf8 norm1 
.const [111] = Utf8 (FFF)F 
.const [112] = Utf8 java/lang/Math 
.const [113] = Utf8 min 
.const [114] = Utf8 (FF)F 
.const [115] = Utf8 java/lang/Math 
.const [116] = Utf8 max 
.const [117] = Utf8 (FF)F 
.const [118] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [119] = Utf8 m_refMap 
.const [120] = Utf8 Ljava/util/HashMap; 
.const [121] = Utf8 java/util/HashMap 
.const [122] = Utf8 keySet 
.const [123] = Utf8 ()Ljava/util/Set; 
.const [124] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [125] = Utf8 m_refKeySet 
.const [126] = Utf8 Ljava/util/Set; 
.const [127] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [128] = Utf8 m_animationRef 
.const [129] = Utf8 Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef; 
.const [130] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [131] = Utf8 noSteps 
.const [132] = Utf8 I 
.const [133] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [134] = Utf8 m_value 
.const [135] = Utf8 I 
.const [136] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef 
.const [137] = Utf8 index 
.const [138] = Utf8 I 
.const [139] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [140] = Utf8 <init> 
.const [141] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef;I)V 
.const [142] = Utf8 java/lang/Object 
.const [143] = Utf8 <init> 
.const [144] = Utf8 ()V 
.const [145] = Utf8 java/util/HashMap 
.const [146] = Utf8 <init> 
.const [147] = Utf8 ()V 
.const [148] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [149] = Utf8 m_refMap 
.const [150] = Utf8 Ljava/util/HashMap; 
.const [151] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [152] = Utf8 m_refKeySet 
.const [153] = Utf8 Ljava/util/Set; 
.const [154] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [155] = Utf8 m_animationRef 
.const [156] = Utf8 Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef; 
.const [157] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [158] = Utf8 noSteps 
.const [159] = Utf8 I 
.const [160] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [161] = Utf8 m_progress 
.const [162] = Utf8 F 
.const [163] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [164] = Utf8 m_value 
.const [165] = Utf8 I 
.const [166] = Utf8 java/util/Set 
.const [167] = Utf8 iterator 
.const [168] = Utf8 ()Ljava/util/Iterator; 
.const [169] = Utf8 java/util/Iterator 
.const [170] = Utf8 hasNext 
.const [171] = Utf8 ()Z 
.const [172] = Utf8 java/util/Iterator 
.const [173] = Utf8 next 
.const [174] = Utf8 ()Ljava/lang/Object; 
.const [175] = Utf8 de/audi/atip/hmi/view/AnimationListener 
.const [176] = Utf8 animate 
.const [177] = Utf8 (IFI)V 
.const [178] = Utf8 de/audi/atip/hmi/view/AnimationListener 
.const [179] = Utf8 animationStarted 
.const [180] = Utf8 (II)V 
.const [181] = Utf8 de/audi/atip/hmi/view/AnimationListener 
.const [182] = Utf8 animationFinished 
.const [183] = Utf8 (II)V 
.const [184] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener 
.const [185] = Class [184] 
.const [186] = Utf8 java/lang/Object 
.const [187] = Class [186] 
.const [188] = Utf8 de/audi/atip/hmi/view/AnimationListener 
.const [189] = Class [188] 
.const [190] = Utf8 m_refMap 
.const [191] = Utf8 Ljava/util/HashMap; 
.const [192] = Utf8 m_refKeySet 
.const [193] = Utf8 Ljava/util/Set; 
.const [194] = Utf8 m_animationRef 
.const [195] = Utf8 Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef; 
.const [196] = Utf8 noSteps 
.const [197] = Utf8 I 
.const [198] = Utf8 m_value 
.const [199] = Utf8 I 
.const [200] = Utf8 m_progress 
.const [201] = Utf8 F 
.const [202] = Utf8 Code 
.const [203] = Utf8 newInstance 
.const [204] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef;I)Lde/esolutions/hmi/widgets/audi/base/animation/multicast/MultiCastAnimationListener; 
.const [205] = Utf8 <init> 
.const [206] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/animation/multicast/AnimationRef;I)V 
.const [207] = Utf8 animate 
.const [208] = Utf8 (IFI)V 
.const [209] = Utf8 animationStarted 
.const [210] = Utf8 (II)V 
.const [211] = Utf8 animationFinished 
.const [212] = Utf8 (II)V 
.const [213] = Utf8 norm1 
.const [214] = Utf8 (FFF)F 
.end class 
