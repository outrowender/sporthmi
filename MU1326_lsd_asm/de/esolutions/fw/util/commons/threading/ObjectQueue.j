.version 50 0 
.class public super [167] 
.super [169] 
.field private [170] [171] 
.field private [172] [173] 
.field private [174] [175] 
.field private [176] [177] 
.field private [178] [179] 
.field private final [180] [181] 

.method public [183] : [184] 
    .attribute [182] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_0 
L5:     iload_1 
L6:     ifle L13 
L9:     iload_1 
L10:    goto L14 
L13:    iconst_1 
L14:    putfield [25] 
L17:    aload_0 
L18:    iload_1 
L19:    anewarray [2] 
L22:    putfield [26] 
L25:    aload_0 
L26:    iconst_0 
L27:    putfield [27] 
L30:    aload_0 
L31:    iconst_0 
L32:    putfield [28] 
L35:    aload_0 
L36:    iconst_0 
L37:    putfield [29] 
L40:    aload_0 
L41:    invokestatic [3] 
L44:    putfield [30] 
L47:    return 
L48:    
    .end code 
.end method 

.method public synchronized [185] : [186] 
    .attribute [182] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [187] : [188] 
    .attribute [182] .code stack 1 locals 0 
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
    .attribute [182] .code stack 1 locals 0 
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

.method public synchronized [191] : [192] 
    .attribute [182] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     aload_0 
L5:     getfield [7] 
L8:     if_icmpne L15 
L11:    iconst_1 
L12:    goto L16 
L15:    iconst_0 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public synchronized [193] : [194] 
    .attribute [182] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokevirtual [13] 
L4:     aload_0 
L5:     getfield [8] 
L8:     aload_0 
L9:     getfield [9] 
L12:    aload_1 
L13:    aastore 
L14:    aload_0 
L15:    aload_0 
L16:    getfield [9] 
L19:    iconst_1 
L20:    iadd 
L21:    aload_0 
L22:    getfield [7] 
L25:    irem 
L26:    putfield [27] 
L29:    aload_0 
L30:    dup 
L31:    getfield [11] 
L34:    iconst_1 
L35:    iadd 
L36:    putfield [29] 
L39:    aload_0 
L40:    invokespecial [22] 
L43:    return 
L44:    
    .end code 
.end method 

.method public synchronized [195] : [196] 
    .attribute [182] .code stack 3 locals 1 
L0:     iconst_0 
L1:     istore_2 
L2:     iload_2 
L3:     aload_1 
L4:     arraylength 
L5:     if_icmpge L21 
L8:     aload_0 
L9:     aload_1 
L10:    iload_2 
L11:    aaload 
L12:    invokevirtual [14] 
L15:    iinc 2 1 
L18:    goto L2 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public synchronized [197] : [198] 
    .attribute [182] .code stack 3 locals 1 
L0:     aload_0 
L1:     invokevirtual [15] 
L4:     aload_0 
L5:     getfield [8] 
L8:     aload_0 
L9:     getfield [10] 
L12:    aaload 
L13:    astore_1 
L14:    aload_0 
L15:    getfield [8] 
L18:    aload_0 
L19:    getfield [10] 
L22:    aconst_null 
L23:    aastore 
L24:    aload_0 
L25:    aload_0 
L26:    getfield [10] 
L29:    iconst_1 
L30:    iadd 
L31:    aload_0 
L32:    getfield [7] 
L35:    irem 
L36:    putfield [28] 
L39:    aload_0 
L40:    dup 
L41:    getfield [11] 
L44:    iconst_1 
L45:    isub 
L46:    putfield [29] 
L49:    aload_0 
L50:    invokespecial [22] 
L53:    aload_1 
L54:    areturn 
L55:    nop 
L56:    
    .end code 
.end method 

.method public synchronized [199] : [200] 
    .attribute [182] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [11] 
L4:     anewarray [2] 
L7:     astore_1 
L8:     iconst_0 
L9:     istore_2 
L10:    iload_2 
L11:    aload_1 
L12:    arraylength 
L13:    if_icmpge L29 
L16:    aload_1 
L17:    iload_2 
L18:    aload_0 
L19:    invokevirtual [16] 
L22:    aastore 
L23:    iinc 2 1 
L26:    goto L10 
L29:    aload_1 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 

.method public synchronized [201] : [202] 
    .attribute [182] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [15] 
L4:     aload_0 
L5:     invokevirtual [17] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public synchronized [203] : [204] 
    .attribute [182] .code stack 4 locals 4 
L0:     lload_1 
L1:     lconst_0 
L2:     lcmp 
L3:     ifne L12 
L6:     aload_0 
L7:     invokevirtual [18] 
L10:    iconst_1 
L11:    areturn 
L12:    aload_0 
L13:    getfield [12] 
L16:    invokeinterface [31] 0 
L21:    lload_1 
L22:    ladd 
L23:    lstore_3 
L24:    lload_1 
L25:    lstore 5 
L27:    aload_0 
L28:    invokevirtual [19] 
L31:    ifne L63 
L34:    lload 5 
L36:    lconst_0 
L37:    lcmp 
L38:    ifle L63 
L41:    aload_0 
L42:    lload 5 
L44:    invokespecial [23] 
L47:    lload_3 
L48:    aload_0 
L49:    getfield [12] 
L52:    invokeinterface [31] 0 
L57:    lsub 
L58:    lstore 5 
L60:    goto L27 
L63:    aload_0 
L64:    invokevirtual [19] 
L67:    areturn 
L68:    
    .end code 
.end method 

.method public synchronized [205] : [206] 
    .attribute [182] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [19] 
L4:     ifne L14 
L7:     aload_0 
L8:     invokespecial [24] 
L11:    goto L0 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public synchronized [207] : [208] 
    .attribute [182] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [19] 
L4:     ifeq L14 
L7:     aload_0 
L8:     invokespecial [24] 
L11:    goto L0 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public synchronized [209] : [210] 
    .attribute [182] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [20] 
L4:     ifne L14 
L7:     aload_0 
L8:     invokespecial [24] 
L11:    goto L0 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public synchronized [211] : [212] 
    .attribute [182] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [20] 
L4:     ifeq L14 
L7:     aload_0 
L8:     invokespecial [24] 
L11:    goto L0 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [32] 
.const [3] = Method [33] [34] 
.const [4] = Class [35] 
.const [5] = Class [36] 
.const [6] = Class [37] 
.const [7] = Field [38] [39] 
.const [8] = Field [40] [41] 
.const [9] = Field [42] [43] 
.const [10] = Field [44] [45] 
.const [11] = Field [46] [47] 
.const [12] = Field [48] [49] 
.const [13] = Method [50] [51] 
.const [14] = Method [52] [53] 
.const [15] = Method [54] [55] 
.const [16] = Method [56] [57] 
.const [17] = Method [58] [59] 
.const [18] = Method [60] [61] 
.const [19] = Method [62] [63] 
.const [20] = Method [64] [65] 
.const [21] = Method [66] [67] 
.const [22] = Method [68] [69] 
.const [23] = Method [70] [71] 
.const [24] = Method [72] [73] 
.const [25] = Field [74] [75] 
.const [26] = Field [76] [77] 
.const [27] = Field [78] [79] 
.const [28] = Field [80] [81] 
.const [29] = Field [82] [83] 
.const [30] = Field [84] [85] 
.const [31] = InterfaceMethod [86] [87] 
.const [32] = Utf8 java/lang/Object 
.const [33] = Class [88] 
.const [34] = NameAndType [89] [90] 
.const [35] = Utf8 de/esolutions/fw/util/commons/threading/ObjectQueue 
.const [36] = Utf8 de/esolutions/fw/util/commons/timeout/TimeSourceProvider 
.const [37] = Utf8 de/esolutions/fw/util/commons/timeout/ITimeSource 
.const [38] = Class [91] 
.const [39] = NameAndType [92] [93] 
.const [40] = Class [94] 
.const [41] = NameAndType [95] [96] 
.const [42] = Class [97] 
.const [43] = NameAndType [98] [99] 
.const [44] = Class [100] 
.const [45] = NameAndType [101] [102] 
.const [46] = Class [103] 
.const [47] = NameAndType [104] [105] 
.const [48] = Class [106] 
.const [49] = NameAndType [107] [108] 
.const [50] = Class [109] 
.const [51] = NameAndType [110] [111] 
.const [52] = Class [112] 
.const [53] = NameAndType [113] [114] 
.const [54] = Class [115] 
.const [55] = NameAndType [116] [117] 
.const [56] = Class [118] 
.const [57] = NameAndType [119] [120] 
.const [58] = Class [121] 
.const [59] = NameAndType [122] [123] 
.const [60] = Class [124] 
.const [61] = NameAndType [125] [126] 
.const [62] = Class [127] 
.const [63] = NameAndType [128] [129] 
.const [64] = Class [130] 
.const [65] = NameAndType [131] [132] 
.const [66] = Class [133] 
.const [67] = NameAndType [134] [135] 
.const [68] = Class [136] 
.const [69] = NameAndType [137] [138] 
.const [70] = Class [139] 
.const [71] = NameAndType [140] [141] 
.const [72] = Class [142] 
.const [73] = NameAndType [143] [144] 
.const [74] = Class [145] 
.const [75] = NameAndType [146] [147] 
.const [76] = Class [148] 
.const [77] = NameAndType [149] [150] 
.const [78] = Class [151] 
.const [79] = NameAndType [152] [153] 
.const [80] = Class [154] 
.const [81] = NameAndType [155] [156] 
.const [82] = Class [157] 
.const [83] = NameAndType [158] [159] 
.const [84] = Class [160] 
.const [85] = NameAndType [161] [162] 
.const [86] = Class [163] 
.const [87] = NameAndType [164] [165] 
.const [88] = Utf8 de/esolutions/fw/util/commons/timeout/TimeSourceProvider 
.const [89] = Utf8 getMonotonicTimeSource 
.const [90] = Utf8 ()Lde/esolutions/fw/util/commons/timeout/ITimeSource; 
.const [91] = Utf8 de/esolutions/fw/util/commons/threading/ObjectQueue 
.const [92] = Utf8 capacity 
.const [93] = Utf8 I 
.const [94] = Utf8 de/esolutions/fw/util/commons/threading/ObjectQueue 
.const [95] = Utf8 queue 
.const [96] = Utf8 [Ljava/lang/Object; 
.const [97] = Utf8 de/esolutions/fw/util/commons/threading/ObjectQueue 
.const [98] = Utf8 head 
.const [99] = Utf8 I 
.const [100] = Utf8 de/esolutions/fw/util/commons/threading/ObjectQueue 
.const [101] = Utf8 tail 
.const [102] = Utf8 I 
.const [103] = Utf8 de/esolutions/fw/util/commons/threading/ObjectQueue 
.const [104] = Utf8 size 
.const [105] = Utf8 I 
.const [106] = Utf8 de/esolutions/fw/util/commons/threading/ObjectQueue 
.const [107] = Utf8 monoTime 
.const [108] = Utf8 Lde/esolutions/fw/util/commons/timeout/ITimeSource; 
.const [109] = Utf8 de/esolutions/fw/util/commons/threading/ObjectQueue 
.const [110] = Utf8 waitWhileFull 
.const [111] = Utf8 ()V 
.const [112] = Utf8 de/esolutions/fw/util/commons/threading/ObjectQueue 
.const [113] = Utf8 add 
.const [114] = Utf8 (Ljava/lang/Object;)V 
.const [115] = Utf8 de/esolutions/fw/util/commons/threading/ObjectQueue 
.const [116] = Utf8 waitWhileEmpty 
.const [117] = Utf8 ()V 
.const [118] = Utf8 de/esolutions/fw/util/commons/threading/ObjectQueue 
.const [119] = Utf8 remove 
.const [120] = Utf8 ()Ljava/lang/Object; 
.const [121] = Utf8 de/esolutions/fw/util/commons/threading/ObjectQueue 
.const [122] = Utf8 removeAll 
.const [123] = Utf8 ()[Ljava/lang/Object; 
.const [124] = Utf8 de/esolutions/fw/util/commons/threading/ObjectQueue 
.const [125] = Utf8 waitUntilEmpty 
.const [126] = Utf8 ()V 
.const [127] = Utf8 de/esolutions/fw/util/commons/threading/ObjectQueue 
.const [128] = Utf8 isEmpty 
.const [129] = Utf8 ()Z 
.const [130] = Utf8 de/esolutions/fw/util/commons/threading/ObjectQueue 
.const [131] = Utf8 isFull 
.const [132] = Utf8 ()Z 
.const [133] = Utf8 java/lang/Object 
.const [134] = Utf8 <init> 
.const [135] = Utf8 ()V 
.const [136] = Utf8 java/lang/Object 
.const [137] = Utf8 notifyAll 
.const [138] = Utf8 ()V 
.const [139] = Utf8 java/lang/Object 
.const [140] = Utf8 wait 
.const [141] = Utf8 (J)V 
.const [142] = Utf8 java/lang/Object 
.const [143] = Utf8 wait 
.const [144] = Utf8 ()V 
.const [145] = Utf8 de/esolutions/fw/util/commons/threading/ObjectQueue 
.const [146] = Utf8 capacity 
.const [147] = Utf8 I 
.const [148] = Utf8 de/esolutions/fw/util/commons/threading/ObjectQueue 
.const [149] = Utf8 queue 
.const [150] = Utf8 [Ljava/lang/Object; 
.const [151] = Utf8 de/esolutions/fw/util/commons/threading/ObjectQueue 
.const [152] = Utf8 head 
.const [153] = Utf8 I 
.const [154] = Utf8 de/esolutions/fw/util/commons/threading/ObjectQueue 
.const [155] = Utf8 tail 
.const [156] = Utf8 I 
.const [157] = Utf8 de/esolutions/fw/util/commons/threading/ObjectQueue 
.const [158] = Utf8 size 
.const [159] = Utf8 I 
.const [160] = Utf8 de/esolutions/fw/util/commons/threading/ObjectQueue 
.const [161] = Utf8 monoTime 
.const [162] = Utf8 Lde/esolutions/fw/util/commons/timeout/ITimeSource; 
.const [163] = Utf8 de/esolutions/fw/util/commons/timeout/ITimeSource 
.const [164] = Utf8 getCurrentTime 
.const [165] = Utf8 ()J 
.const [166] = Utf8 de/esolutions/fw/util/commons/threading/ObjectQueue 
.const [167] = Class [166] 
.const [168] = Utf8 java/lang/Object 
.const [169] = Class [168] 
.const [170] = Utf8 queue 
.const [171] = Utf8 [Ljava/lang/Object; 
.const [172] = Utf8 capacity 
.const [173] = Utf8 I 
.const [174] = Utf8 size 
.const [175] = Utf8 I 
.const [176] = Utf8 head 
.const [177] = Utf8 I 
.const [178] = Utf8 tail 
.const [179] = Utf8 I 
.const [180] = Utf8 monoTime 
.const [181] = Utf8 Lde/esolutions/fw/util/commons/timeout/ITimeSource; 
.const [182] = Utf8 Code 
.const [183] = Utf8 <init> 
.const [184] = Utf8 (I)V 
.const [185] = Utf8 getCapacity 
.const [186] = Utf8 ()I 
.const [187] = Utf8 getSize 
.const [188] = Utf8 ()I 
.const [189] = Utf8 isEmpty 
.const [190] = Utf8 ()Z 
.const [191] = Utf8 isFull 
.const [192] = Utf8 ()Z 
.const [193] = Utf8 add 
.const [194] = Utf8 (Ljava/lang/Object;)V 
.const [195] = Utf8 addEach 
.const [196] = Utf8 ([Ljava/lang/Object;)V 
.const [197] = Utf8 remove 
.const [198] = Utf8 ()Ljava/lang/Object; 
.const [199] = Utf8 removeAll 
.const [200] = Utf8 ()[Ljava/lang/Object; 
.const [201] = Utf8 removeAtLeastOne 
.const [202] = Utf8 ()[Ljava/lang/Object; 
.const [203] = Utf8 waitUntilEmpty 
.const [204] = Utf8 (J)Z 
.const [205] = Utf8 waitUntilEmpty 
.const [206] = Utf8 ()V 
.const [207] = Utf8 waitWhileEmpty 
.const [208] = Utf8 ()V 
.const [209] = Utf8 waitUntilFull 
.const [210] = Utf8 ()V 
.const [211] = Utf8 waitWhileFull 
.const [212] = Utf8 ()V 
.end class 
