.version 50 0 
.class public super [156] 
.super [158] 
.implements [160] 
.field private volatile [161] [162] 
.field private final [163] [164] 
.field private final [165] [166] 

.method public [168] : [169] 
    .attribute [167] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [28] 
L4:     aload_0 
L5:     bipush -2 
L7:     putfield [31] 
L10:    aload_0 
L11:    new [32] 
L14:    dup 
L15:    invokespecial [29] 
L18:    putfield [33] 
L21:    aload_0 
L22:    aload_1 
L23:    putfield [34] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [170] : [171] 
    .attribute [167] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [31] 
L5:     aload_0 
L6:     invokespecial [30] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public interface [172] : [173] 
    .attribute [167] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [174] : [175] 
    .attribute [167] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     invokestatic [3] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public static [176] : [177] 
    .attribute [167] .code stack 1 locals 0 
L0:     iload_0 
L1:     tableswitch -2 
            L52 
            L55 
            L40 
            L43 
            L46 
            L49 
            default : L55 

L40:    ldc [4] 
L42:    areturn 
L43:    ldc [5] 
L45:    areturn 
L46:    ldc [6] 
L48:    areturn 
L49:    ldc [7] 
L51:    areturn 
L52:    ldc [8] 
L54:    areturn 
L55:    ldc [9] 
L57:    areturn 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [178] : [179] 
    .attribute [167] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     ifne L11 
L7:     iconst_1 
L8:     goto L12 
L11:    iconst_0 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [180] : [181] 
    .attribute [167] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     iconst_1 
L5:     if_icmpne L12 
L8:     iconst_1 
L9:     goto L13 
L12:    iconst_0 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [182] : [183] 
    .attribute [167] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     iconst_2 
L5:     if_icmpne L12 
L8:     iconst_1 
L9:     goto L13 
L12:    iconst_0 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [184] : [185] 
    .attribute [167] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     iconst_3 
L5:     if_icmpne L12 
L8:     iconst_1 
L9:     goto L13 
L12:    iconst_0 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method private [186] : [187] 
    .attribute [167] .code stack 2 locals 3 
L0:     aload_0 
L1:     getfield [23] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L23 using L26 
L7:     aload_0 
L8:     getfield [23] 
L11:    checkcast [2] 
L14:    invokevirtual [25] 
L17:    checkcast [2] 
L20:    astore_1 
L21:    aload_2 
L22:    monitorexit 
L23:    goto L31 
        .catch [0] from L26 to L29 using L26 
L26:    astore_3 
L27:    aload_2 
L28:    monitorexit 
L29:    aload_3 
L30:    athrow 
L31:    aload_1 
L32:    invokeinterface [35] 0 
L37:    astore_2 
L38:    aload_2 
L39:    invokeinterface [36] 0 
L44:    ifeq L70 
L47:    aload_2 
L48:    invokeinterface [37] 0 
L53:    checkcast [10] 
L56:    astore_3 
L57:    aload_3 
L58:    aload_0 
L59:    getfield [22] 
L62:    invokeinterface [38] 0 
L67:    goto L38 
L70:    return 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [188] : [189] 
    .attribute [167] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [23] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L20 using L23 
L7:     aload_0 
L8:     getfield [23] 
L11:    aload_1 
L12:    invokeinterface [39] 0 
L17:    pop 
L18:    aload_2 
L19:    monitorexit 
L20:    goto L28 
        .catch [0] from L23 to L26 using L23 
L23:    astore_3 
L24:    aload_2 
L25:    monitorexit 
L26:    aload_3 
L27:    athrow 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [190] : [191] 
    .attribute [167] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [23] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L20 using L23 
L7:     aload_0 
L8:     getfield [23] 
L11:    aload_1 
L12:    invokeinterface [40] 0 
L17:    pop 
L18:    aload_2 
L19:    monitorexit 
L20:    goto L28 
        .catch [0] from L23 to L26 using L23 
L23:    astore_3 
L24:    aload_2 
L25:    monitorexit 
L26:    aload_3 
L27:    athrow 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [192] : [193] 
    .attribute [167] .code stack 5 locals 1 
L0:     iload_1 
L1:     ifne L127 
L4:     iload_2 
L5:     iconst_2 
L6:     if_icmpne L26 
L9:     aload_0 
L10:    getfield [24] 
L13:    ldc [11] 
L15:    ldc [12] 
L17:    invokevirtual [26] 
L20:    pop 
L21:    iconst_1 
L22:    istore_3 
L23:    goto L110 
L26:    iload_2 
L27:    iconst_1 
L28:    if_icmpne L48 
L31:    aload_0 
L32:    getfield [24] 
L35:    ldc [11] 
L37:    ldc [13] 
L39:    invokevirtual [26] 
L42:    pop 
L43:    iconst_0 
L44:    istore_3 
L45:    goto L110 
L48:    iload_2 
L49:    bipush 38 
L51:    if_icmpne L71 
L54:    aload_0 
L55:    getfield [24] 
L58:    ldc [11] 
L60:    ldc [14] 
L62:    invokevirtual [26] 
L65:    pop 
L66:    iconst_2 
L67:    istore_3 
L68:    goto L110 
L71:    iload_2 
L72:    bipush 48 
L74:    if_icmpne L94 
L77:    aload_0 
L78:    getfield [24] 
L81:    ldc [11] 
L83:    ldc [15] 
L85:    invokevirtual [26] 
L88:    pop 
L89:    iconst_3 
L90:    istore_3 
L91:    goto L110 
L94:    aload_0 
L95:    getfield [24] 
L98:    ldc [11] 
L100:   ldc [16] 
L102:   iload_2 
L103:   i2l 
L104:   invokevirtual [27] 
L107:   pop 
L108:   iconst_m1 
L109:   istore_3 
L110:   aload_0 
L111:   getfield [22] 
L114:   iload_3 
L115:   if_icmpeq L127 
L118:   aload_0 
L119:   iload_3 
L120:   putfield [31] 
L123:   aload_0 
L124:   invokespecial [30] 
L127:   return 
L128:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [41] 
.const [3] = Method [42] [43] 
.const [4] = String [44] 
.const [5] = String [45] 
.const [6] = String [46] 
.const [7] = String [47] 
.const [8] = String [48] 
.const [9] = String [49] 
.const [10] = Class [50] 
.const [11] = Int 1078071040 
.const [12] = String [51] 
.const [13] = String [52] 
.const [14] = String [53] 
.const [15] = String [54] 
.const [16] = String [55] 
.const [17] = Class [56] 
.const [18] = Class [57] 
.const [19] = Class [58] 
.const [20] = Class [59] 
.const [21] = Class [60] 
.const [22] = Field [61] [62] 
.const [23] = Field [63] [64] 
.const [24] = Field [65] [66] 
.const [25] = Method [67] [68] 
.const [26] = Method [69] [70] 
.const [27] = Method [71] [72] 
.const [28] = Method [73] [74] 
.const [29] = Method [75] [76] 
.const [30] = Method [77] [78] 
.const [31] = Field [79] [80] 
.const [32] = Class [81] 
.const [33] = Field [82] [83] 
.const [34] = Field [84] [85] 
.const [35] = InterfaceMethod [86] [87] 
.const [36] = InterfaceMethod [88] [89] 
.const [37] = InterfaceMethod [90] [91] 
.const [38] = InterfaceMethod [92] [93] 
.const [39] = InterfaceMethod [94] [95] 
.const [40] = InterfaceMethod [96] [97] 
.const [41] = Utf8 java/util/LinkedList 
.const [42] = Class [98] 
.const [43] = NameAndType [99] [100] 
.const [44] = Utf8 Tuner 
.const [45] = Utf8 Media 
.const [46] = Utf8 TV 
.const [47] = Utf8 TerminalMode 
.const [48] = Utf8 '[Not set]' 
.const [49] = Utf8 '[Unknown]' 
.const [50] = Utf8 de/audi/app/combi/bap/app/audio/IAudioApplicationInFocusObserver 
.const [51] = Utf8 '[AudioApplicationInFocusHandler#updateAudioFocus] MEDIA has audio focus now' 
.const [52] = Utf8 '[AudioApplicationInFocusHandler#updateAudioFocus] TUNER has audio focus now' 
.const [53] = Utf8 '[AudioApplicationInFocusHandler#updateAudioFocus] TV has audio focus now' 
.const [54] = Utf8 '[AudioApplicationInFocusHandler#updateAudioFocus] TerminalMode has audio focus now' 
.const [55] = Utf8 '[AudioApplicationInFocusHandler#updateAudioFocus] UNKNOWN audio focus set: %1' 
.const [56] = Utf8 de/audi/app/combi/bap/app/audio/AudioApplicationInFocusHandler 
.const [57] = Utf8 java/lang/Object 
.const [58] = Utf8 java/util/List 
.const [59] = Utf8 java/util/Iterator 
.const [60] = Utf8 de/audi/atip/log/LogChannel 
.const [61] = Class [101] 
.const [62] = NameAndType [102] [103] 
.const [63] = Class [104] 
.const [64] = NameAndType [105] [106] 
.const [65] = Class [107] 
.const [66] = NameAndType [108] [109] 
.const [67] = Class [110] 
.const [68] = NameAndType [111] [112] 
.const [69] = Class [113] 
.const [70] = NameAndType [114] [115] 
.const [71] = Class [116] 
.const [72] = NameAndType [117] [118] 
.const [73] = Class [119] 
.const [74] = NameAndType [120] [121] 
.const [75] = Class [122] 
.const [76] = NameAndType [123] [124] 
.const [77] = Class [125] 
.const [78] = NameAndType [126] [127] 
.const [79] = Class [128] 
.const [80] = NameAndType [129] [130] 
.const [81] = Utf8 java/util/LinkedList 
.const [82] = Class [131] 
.const [83] = NameAndType [132] [133] 
.const [84] = Class [134] 
.const [85] = NameAndType [135] [136] 
.const [86] = Class [137] 
.const [87] = NameAndType [138] [139] 
.const [88] = Class [140] 
.const [89] = NameAndType [141] [142] 
.const [90] = Class [143] 
.const [91] = NameAndType [144] [145] 
.const [92] = Class [146] 
.const [93] = NameAndType [147] [148] 
.const [94] = Class [149] 
.const [95] = NameAndType [150] [151] 
.const [96] = Class [152] 
.const [97] = NameAndType [153] [154] 
.const [98] = Utf8 de/audi/app/combi/bap/app/audio/AudioApplicationInFocusHandler 
.const [99] = Utf8 getAudioApplicationName 
.const [100] = Utf8 (I)Ljava/lang/String; 
.const [101] = Utf8 de/audi/app/combi/bap/app/audio/AudioApplicationInFocusHandler 
.const [102] = Utf8 audioApplicationInFocus 
.const [103] = Utf8 I 
.const [104] = Utf8 de/audi/app/combi/bap/app/audio/AudioApplicationInFocusHandler 
.const [105] = Utf8 observers 
.const [106] = Utf8 Ljava/util/List; 
.const [107] = Utf8 de/audi/app/combi/bap/app/audio/AudioApplicationInFocusHandler 
.const [108] = Utf8 logChannel 
.const [109] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [110] = Utf8 java/util/LinkedList 
.const [111] = Utf8 clone 
.const [112] = Utf8 ()Ljava/lang/Object; 
.const [113] = Utf8 de/audi/atip/log/LogChannel 
.const [114] = Utf8 log 
.const [115] = Utf8 (ILjava/lang/String;)Z 
.const [116] = Utf8 de/audi/atip/log/LogChannel 
.const [117] = Utf8 log 
.const [118] = Utf8 (ILjava/lang/String;J)Z 
.const [119] = Utf8 java/lang/Object 
.const [120] = Utf8 <init> 
.const [121] = Utf8 ()V 
.const [122] = Utf8 java/util/LinkedList 
.const [123] = Utf8 <init> 
.const [124] = Utf8 ()V 
.const [125] = Utf8 de/audi/app/combi/bap/app/audio/AudioApplicationInFocusHandler 
.const [126] = Utf8 notifyObservers 
.const [127] = Utf8 ()V 
.const [128] = Utf8 de/audi/app/combi/bap/app/audio/AudioApplicationInFocusHandler 
.const [129] = Utf8 audioApplicationInFocus 
.const [130] = Utf8 I 
.const [131] = Utf8 de/audi/app/combi/bap/app/audio/AudioApplicationInFocusHandler 
.const [132] = Utf8 observers 
.const [133] = Utf8 Ljava/util/List; 
.const [134] = Utf8 de/audi/app/combi/bap/app/audio/AudioApplicationInFocusHandler 
.const [135] = Utf8 logChannel 
.const [136] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [137] = Utf8 java/util/List 
.const [138] = Utf8 iterator 
.const [139] = Utf8 ()Ljava/util/Iterator; 
.const [140] = Utf8 java/util/Iterator 
.const [141] = Utf8 hasNext 
.const [142] = Utf8 ()Z 
.const [143] = Utf8 java/util/Iterator 
.const [144] = Utf8 next 
.const [145] = Utf8 ()Ljava/lang/Object; 
.const [146] = Utf8 de/audi/app/combi/bap/app/audio/IAudioApplicationInFocusObserver 
.const [147] = Utf8 notifyAudioApplicationInFocusChanged 
.const [148] = Utf8 (I)V 
.const [149] = Utf8 java/util/List 
.const [150] = Utf8 add 
.const [151] = Utf8 (Ljava/lang/Object;)Z 
.const [152] = Utf8 java/util/List 
.const [153] = Utf8 remove 
.const [154] = Utf8 (Ljava/lang/Object;)Z 
.const [155] = Utf8 de/audi/app/combi/bap/app/audio/AudioApplicationInFocusHandler 
.const [156] = Class [155] 
.const [157] = Utf8 java/lang/Object 
.const [158] = Class [157] 
.const [159] = Utf8 de/audi/atip/audio/IAudioFocusClient 
.const [160] = Class [159] 
.const [161] = Utf8 audioApplicationInFocus 
.const [162] = Utf8 I 
.const [163] = Utf8 observers 
.const [164] = Utf8 Ljava/util/List; 
.const [165] = Utf8 logChannel 
.const [166] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [167] = Utf8 Code 
.const [168] = Utf8 <init> 
.const [169] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [170] = Utf8 setActiveAudioApplication 
.const [171] = Utf8 (I)V 
.const [172] = Utf8 getAudioApplicationInFocus 
.const [173] = Utf8 ()I 
.const [174] = Utf8 getAudioApplicationInFocusName 
.const [175] = Utf8 ()Ljava/lang/String; 
.const [176] = Utf8 getAudioApplicationName 
.const [177] = Utf8 (I)Ljava/lang/String; 
.const [178] = Utf8 isTunerInFocus 
.const [179] = Utf8 ()Z 
.const [180] = Utf8 isMediaInFocus 
.const [181] = Utf8 ()Z 
.const [182] = Utf8 isTVInFocus 
.const [183] = Utf8 ()Z 
.const [184] = Utf8 isTerminalModeInFocus 
.const [185] = Utf8 ()Z 
.const [186] = Utf8 notifyObservers 
.const [187] = Utf8 ()V 
.const [188] = Utf8 addObserver 
.const [189] = Utf8 (Lde/audi/app/combi/bap/app/audio/IAudioApplicationInFocusObserver;)V 
.const [190] = Utf8 removeObserver 
.const [191] = Utf8 (Lde/audi/app/combi/bap/app/audio/IAudioApplicationInFocusObserver;)V 
.const [192] = Utf8 updateAudioFocus 
.const [193] = Utf8 (II)V 
.end class 
