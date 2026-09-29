.version 50 0 
.class public final super [127] 
.super [129] 
.field public static final [130] [131] 
.field public static final [132] [133] 
.field public static final [134] [135] 
.field public static final [136] [137] 
.field public static final [138] [139] 
.field private [140] [141] 
.field private [142] [143] 
.field private final [144] [145] 
.field private [146] [147] 

.method public [149] : [150] 
    .attribute [148] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [23] 
L9:     aload_0 
L10:    aload_1 
L11:    putfield [24] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public interface [151] : [152] 
    .attribute [148] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [153] : [154] 
    .attribute [148] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [25] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [155] : [156] 
    .attribute [148] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     invokespecial [16] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [157] : [158] 
    .attribute [148] .code stack 3 locals 3 
L0:     iconst_0 
L1:     istore_2 
L2:     aload_0 
L3:     dup 
L4:     astore_3 
L5:     monitorenter 
        .catch [0] from L6 to L27 using L30 
L6:     aload_0 
L7:     getfield [11] 
L10:    iconst_1 
L11:    if_icmpeq L25 
L14:    aload_0 
L15:    iconst_1 
L16:    putfield [23] 
L19:    iconst_1 
L20:    istore_2 
L21:    aload_0 
L22:    invokespecial [17] 
L25:    aload_3 
L26:    monitorexit 
L27:    goto L37 
        .catch [0] from L30 to L34 using L30 
L30:    astore 4 
L32:    aload_3 
L33:    monitorexit 
L34:    aload 4 
L36:    athrow 
L37:    iload_1 
L38:    ifeq L66 
L41:    aload_0 
L42:    getfield [13] 
L45:    ifnull L66 
L48:    iload_2 
L49:    ifeq L66 
L52:    aload_0 
L53:    getfield [13] 
L56:    aload_0 
L57:    aload_0 
L58:    getfield [12] 
L61:    invokeinterface [26] 0 
L66:    return 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [159] : [160] 
    .attribute [148] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     invokespecial [18] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [161] : [162] 
    .attribute [148] .code stack 3 locals 3 
L0:     iconst_0 
L1:     istore_2 
L2:     aload_0 
L3:     dup 
L4:     astore_3 
L5:     monitorenter 
        .catch [0] from L6 to L27 using L30 
L6:     aload_0 
L7:     getfield [11] 
L10:    iconst_2 
L11:    if_icmpeq L25 
L14:    aload_0 
L15:    iconst_2 
L16:    putfield [23] 
L19:    iconst_1 
L20:    istore_2 
L21:    aload_0 
L22:    invokespecial [17] 
L25:    aload_3 
L26:    monitorexit 
L27:    goto L37 
        .catch [0] from L30 to L34 using L30 
L30:    astore 4 
L32:    aload_3 
L33:    monitorexit 
L34:    aload 4 
L36:    athrow 
L37:    iload_1 
L38:    ifeq L66 
L41:    aload_0 
L42:    getfield [13] 
L45:    ifnull L66 
L48:    iload_2 
L49:    ifeq L66 
L52:    aload_0 
L53:    getfield [13] 
L56:    aload_0 
L57:    aload_0 
L58:    getfield [12] 
L61:    invokeinterface [26] 0 
L66:    return 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [163] : [164] 
    .attribute [148] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iconst_1 
L3:     invokespecial [19] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [165] : [166] 
    .attribute [148] .code stack 3 locals 3 
L0:     iconst_0 
L1:     istore_3 
L2:     aload_0 
L3:     dup 
L4:     astore 4 
L6:     monitorenter 
        .catch [0] from L7 to L34 using L37 
L7:     aload_0 
L8:     getfield [11] 
L11:    iconst_3 
L12:    if_icmpeq L31 
L15:    aload_0 
L16:    iconst_3 
L17:    putfield [23] 
L20:    iconst_1 
L21:    istore_3 
L22:    aload_0 
L23:    iload_1 
L24:    putfield [27] 
L27:    aload_0 
L28:    invokespecial [17] 
L31:    aload 4 
L33:    monitorexit 
L34:    goto L45 
        .catch [0] from L37 to L42 using L37 
L37:    astore 5 
L39:    aload 4 
L41:    monitorexit 
L42:    aload 5 
L44:    athrow 
L45:    iload_2 
L46:    ifeq L74 
L49:    aload_0 
L50:    getfield [13] 
L53:    ifnull L74 
L56:    iload_3 
L57:    ifeq L74 
L60:    aload_0 
L61:    getfield [13] 
L64:    aload_0 
L65:    aload_0 
L66:    getfield [12] 
L69:    invokeinterface [26] 0 
L74:    return 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [167] : [168] 
    .attribute [148] .code stack 3 locals 3 
L0:     iconst_0 
L1:     istore_1 
L2:     aload_0 
L3:     dup 
L4:     astore_2 
L5:     monitorenter 
        .catch [0] from L6 to L26 using L29 
L6:     aload_0 
L7:     getfield [11] 
L10:    ifeq L24 
L13:    aload_0 
L14:    iconst_0 
L15:    putfield [23] 
L18:    iconst_1 
L19:    istore_1 
L20:    aload_0 
L21:    invokespecial [17] 
L24:    aload_2 
L25:    monitorexit 
L26:    goto L34 
        .catch [0] from L29 to L32 using L29 
L29:    astore_3 
L30:    aload_2 
L31:    monitorexit 
L32:    aload_3 
L33:    athrow 
L34:    aload_0 
L35:    getfield [13] 
L38:    ifnull L59 
L41:    iload_1 
L42:    ifeq L59 
L45:    aload_0 
L46:    getfield [13] 
L49:    aload_0 
L50:    aload_0 
L51:    getfield [12] 
L54:    invokeinterface [26] 0 
L59:    return 
L60:    
    .end code 
.end method 

.method public synchronized [169] : [170] 
    .attribute [148] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
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

.method public synchronized [171] : [172] 
    .attribute [148] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [11] 
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

.method public synchronized [173] : [174] 
    .attribute [148] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [11] 
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

.method public synchronized [175] : [176] 
    .attribute [148] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [11] 
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

.method public synchronized [177] : [178] 
    .attribute [148] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [179] : [180] 
    .attribute [148] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     iconst_1 
L5:     if_icmpne L10 
L8:     iconst_1 
L9:     areturn 
L10:    aload_0 
L11:    getfield [11] 
L14:    ifeq L19 
L17:    iconst_0 
L18:    areturn 
L19:    aload_0 
L20:    getfield [11] 
L23:    iconst_1 
L24:    if_icmpeq L44 
L27:    aload_0 
L28:    getfield [11] 
L31:    iconst_3 
L32:    if_icmpne L37 
L35:    iconst_0 
L36:    areturn 
L37:    aload_0 
L38:    invokespecial [20] 
L41:    goto L19 
L44:    iconst_1 
L45:    areturn 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public synchronized [181] : [182] 
    .attribute [148] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     iconst_2 
L5:     if_icmpne L10 
L8:     iconst_1 
L9:     areturn 
L10:    aload_0 
L11:    getfield [11] 
L14:    iconst_1 
L15:    if_icmpeq L20 
L18:    iconst_0 
L19:    areturn 
L20:    aload_0 
L21:    getfield [11] 
L24:    iconst_2 
L25:    if_icmpeq L45 
L28:    aload_0 
L29:    getfield [11] 
L32:    iconst_3 
L33:    if_icmpne L38 
L36:    iconst_0 
L37:    areturn 
L38:    aload_0 
L39:    invokespecial [20] 
L42:    goto L20 
L45:    iconst_1 
L46:    areturn 
L47:    nop 
L48:    
    .end code 
.end method 

.method public synchronized [183] : [184] 
    .attribute [148] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     iconst_1 
L5:     if_icmpne L10 
L8:     iconst_1 
L9:     areturn 
L10:    aload_0 
L11:    getfield [11] 
L14:    ifeq L19 
L17:    iconst_0 
L18:    areturn 
L19:    aload_0 
L20:    lload_1 
L21:    invokespecial [21] 
L24:    aload_0 
L25:    getfield [11] 
L28:    iconst_1 
L29:    if_icmpne L36 
L32:    iconst_1 
L33:    goto L37 
L36:    iconst_0 
L37:    areturn 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public synchronized [185] : [186] 
    .attribute [148] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     iconst_2 
L5:     if_icmpne L10 
L8:     iconst_1 
L9:     areturn 
L10:    aload_0 
L11:    getfield [11] 
L14:    iconst_1 
L15:    if_icmpeq L20 
L18:    iconst_0 
L19:    areturn 
L20:    aload_0 
L21:    lload_1 
L22:    invokespecial [21] 
L25:    aload_0 
L26:    getfield [11] 
L29:    iconst_2 
L30:    if_icmpne L37 
L33:    iconst_1 
L34:    goto L38 
L37:    iconst_0 
L38:    areturn 
L39:    nop 
L40:    
    .end code 
.end method 

.method public synchronized [187] : [188] 
    .attribute [148] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [189] : [190] 
    .attribute [148] .code stack 2 locals 0 
L0:     getstatic [2] 
L3:     aload_0 
L4:     getfield [11] 
L7:     aaload 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method static [191] : [192] 
    .attribute [148] .code stack 4 locals 0 
L0:     iconst_4 
L1:     anewarray [3] 
L4:     dup 
L5:     iconst_0 
L6:     ldc [4] 
L8:     aastore 
L9:     dup 
L10:    iconst_1 
L11:    ldc [5] 
L13:    aastore 
L14:    dup 
L15:    iconst_2 
L16:    ldc [6] 
L18:    aastore 
L19:    dup 
L20:    iconst_3 
L21:    ldc [7] 
L23:    aastore 
L24:    putstatic [22] 
L27:    return 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [28] [29] 
.const [3] = Class [30] 
.const [4] = String [31] 
.const [5] = String [32] 
.const [6] = String [33] 
.const [7] = String [34] 
.const [8] = Class [35] 
.const [9] = Class [36] 
.const [10] = Class [37] 
.const [11] = Field [38] [39] 
.const [12] = Field [40] [41] 
.const [13] = Field [42] [43] 
.const [14] = Field [44] [45] 
.const [15] = Method [46] [47] 
.const [16] = Method [48] [49] 
.const [17] = Method [50] [51] 
.const [18] = Method [52] [53] 
.const [19] = Method [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Method [58] [59] 
.const [22] = Field [60] [61] 
.const [23] = Field [62] [63] 
.const [24] = Field [64] [65] 
.const [25] = Field [66] [67] 
.const [26] = InterfaceMethod [68] [69] 
.const [27] = Field [70] [71] 
.const [28] = Class [72] 
.const [29] = NameAndType [73] [74] 
.const [30] = Utf8 java/lang/String 
.const [31] = Utf8 unborn 
.const [32] = Utf8 alive 
.const [33] = Utf8 dead 
.const [34] = Utf8 ERROR 
.const [35] = Utf8 de/esolutions/fw/comm/core/Lifecycle 
.const [36] = Utf8 java/lang/Object 
.const [37] = Utf8 de/esolutions/fw/comm/core/ILifecycleListener 
.const [38] = Class [75] 
.const [39] = NameAndType [76] [77] 
.const [40] = Class [78] 
.const [41] = NameAndType [79] [80] 
.const [42] = Class [81] 
.const [43] = NameAndType [82] [83] 
.const [44] = Class [84] 
.const [45] = NameAndType [85] [86] 
.const [46] = Class [87] 
.const [47] = NameAndType [88] [89] 
.const [48] = Class [90] 
.const [49] = NameAndType [91] [92] 
.const [50] = Class [93] 
.const [51] = NameAndType [94] [95] 
.const [52] = Class [96] 
.const [53] = NameAndType [97] [98] 
.const [54] = Class [99] 
.const [55] = NameAndType [100] [101] 
.const [56] = Class [102] 
.const [57] = NameAndType [103] [104] 
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
.const [72] = Utf8 de/esolutions/fw/comm/core/Lifecycle 
.const [73] = Utf8 lifecycleNames 
.const [74] = Utf8 [Ljava/lang/String; 
.const [75] = Utf8 de/esolutions/fw/comm/core/Lifecycle 
.const [76] = Utf8 state 
.const [77] = Utf8 I 
.const [78] = Utf8 de/esolutions/fw/comm/core/Lifecycle 
.const [79] = Utf8 owner 
.const [80] = Utf8 Ljava/lang/Object; 
.const [81] = Utf8 de/esolutions/fw/comm/core/Lifecycle 
.const [82] = Utf8 listener 
.const [83] = Utf8 Lde/esolutions/fw/comm/core/ILifecycleListener; 
.const [84] = Utf8 de/esolutions/fw/comm/core/Lifecycle 
.const [85] = Utf8 errorCode 
.const [86] = Utf8 I 
.const [87] = Utf8 java/lang/Object 
.const [88] = Utf8 <init> 
.const [89] = Utf8 ()V 
.const [90] = Utf8 de/esolutions/fw/comm/core/Lifecycle 
.const [91] = Utf8 setAlive 
.const [92] = Utf8 (Z)V 
.const [93] = Utf8 java/lang/Object 
.const [94] = Utf8 notifyAll 
.const [95] = Utf8 ()V 
.const [96] = Utf8 de/esolutions/fw/comm/core/Lifecycle 
.const [97] = Utf8 setDead 
.const [98] = Utf8 (Z)V 
.const [99] = Utf8 de/esolutions/fw/comm/core/Lifecycle 
.const [100] = Utf8 setError 
.const [101] = Utf8 (IZ)V 
.const [102] = Utf8 java/lang/Object 
.const [103] = Utf8 wait 
.const [104] = Utf8 ()V 
.const [105] = Utf8 java/lang/Object 
.const [106] = Utf8 wait 
.const [107] = Utf8 (J)V 
.const [108] = Utf8 de/esolutions/fw/comm/core/Lifecycle 
.const [109] = Utf8 lifecycleNames 
.const [110] = Utf8 [Ljava/lang/String; 
.const [111] = Utf8 de/esolutions/fw/comm/core/Lifecycle 
.const [112] = Utf8 state 
.const [113] = Utf8 I 
.const [114] = Utf8 de/esolutions/fw/comm/core/Lifecycle 
.const [115] = Utf8 owner 
.const [116] = Utf8 Ljava/lang/Object; 
.const [117] = Utf8 de/esolutions/fw/comm/core/Lifecycle 
.const [118] = Utf8 listener 
.const [119] = Utf8 Lde/esolutions/fw/comm/core/ILifecycleListener; 
.const [120] = Utf8 de/esolutions/fw/comm/core/ILifecycleListener 
.const [121] = Utf8 lifecycleChanged 
.const [122] = Utf8 (Lde/esolutions/fw/comm/core/Lifecycle;Ljava/lang/Object;)V 
.const [123] = Utf8 de/esolutions/fw/comm/core/Lifecycle 
.const [124] = Utf8 errorCode 
.const [125] = Utf8 I 
.const [126] = Utf8 de/esolutions/fw/comm/core/Lifecycle 
.const [127] = Class [126] 
.const [128] = Utf8 java/lang/Object 
.const [129] = Class [128] 
.const [130] = Utf8 STATE_UNBORN 
.const [131] = Utf8 I 
.const [132] = Utf8 STATE_ALIVE 
.const [133] = Utf8 I 
.const [134] = Utf8 STATE_DEAD 
.const [135] = Utf8 I 
.const [136] = Utf8 STATE_ERROR 
.const [137] = Utf8 I 
.const [138] = Utf8 lifecycleNames 
.const [139] = Utf8 [Ljava/lang/String; 
.const [140] = Utf8 state 
.const [141] = Utf8 I 
.const [142] = Utf8 listener 
.const [143] = Utf8 Lde/esolutions/fw/comm/core/ILifecycleListener; 
.const [144] = Utf8 owner 
.const [145] = Utf8 Ljava/lang/Object; 
.const [146] = Utf8 errorCode 
.const [147] = Utf8 I 
.const [148] = Utf8 Code 
.const [149] = Utf8 <init> 
.const [150] = Utf8 (Ljava/lang/Object;)V 
.const [151] = Utf8 getOwner 
.const [152] = Utf8 ()Ljava/lang/Object; 
.const [153] = Utf8 setListener 
.const [154] = Utf8 (Lde/esolutions/fw/comm/core/ILifecycleListener;)V 
.const [155] = Utf8 setAlive 
.const [156] = Utf8 ()V 
.const [157] = Utf8 setAlive 
.const [158] = Utf8 (Z)V 
.const [159] = Utf8 setDead 
.const [160] = Utf8 ()V 
.const [161] = Utf8 setDead 
.const [162] = Utf8 (Z)V 
.const [163] = Utf8 setError 
.const [164] = Utf8 (I)V 
.const [165] = Utf8 setError 
.const [166] = Utf8 (IZ)V 
.const [167] = Utf8 reincarnate 
.const [168] = Utf8 ()V 
.const [169] = Utf8 isUnborn 
.const [170] = Utf8 ()Z 
.const [171] = Utf8 isAlive 
.const [172] = Utf8 ()Z 
.const [173] = Utf8 isDead 
.const [174] = Utf8 ()Z 
.const [175] = Utf8 isError 
.const [176] = Utf8 ()Z 
.const [177] = Utf8 getErrorCode 
.const [178] = Utf8 ()I 
.const [179] = Utf8 waitUntilAlive 
.const [180] = Utf8 ()Z 
.const [181] = Utf8 waitUntilDead 
.const [182] = Utf8 ()Z 
.const [183] = Utf8 waitUntilAlive 
.const [184] = Utf8 (J)Z 
.const [185] = Utf8 waitUntilDead 
.const [186] = Utf8 (J)Z 
.const [187] = Utf8 getState 
.const [188] = Utf8 ()I 
.const [189] = Utf8 getStateString 
.const [190] = Utf8 ()Ljava/lang/String; 
.const [191] = Utf8 <clinit> 
.const [192] = Utf8 ()V 
.end class 
