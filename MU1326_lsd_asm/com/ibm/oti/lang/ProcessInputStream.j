.version 50 0 
.class super [95] 
.super [97] 
.field private [98] [99] 
.field private [100] [101] 

.method static [103] : [104] 
    .attribute [102] .code stack 0 locals 0 
L0:     invokestatic [4] 
L3:     return 
L4:     
    .end code 
.end method 

.method private static native [105] : [106] 
    .attribute [102] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected [107] : [108] 
    .attribute [102] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [10] 
L4:     aload_0 
L5:     new [17] 
L8:     dup 
L9:     invokespecial [11] 
L12:    putfield [18] 
L15:    aload_0 
L16:    aload_0 
L17:    getfield [7] 
L20:    lload_1 
L21:    invokespecial [12] 
L24:    aload_0 
L25:    lload_1 
L26:    putfield [19] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [109] : [110] 
    .attribute [102] .code stack 4 locals 1 
L0:     aload_0 
L1:     dup 
L2:     astore_1 
L3:     monitorenter 
        .catch [0] from L4 to L17 using L26 
L4:     aload_0 
L5:     getfield [8] 
L8:     ldc2_w [21] 
L11:    lcmp 
L12:    ifne L19 
L15:    aload_1 
L16:    monitorexit 
L17:    iconst_m1 
L18:    areturn 
        .catch [0] from L19 to L25 using L26 
L19:    aload_0 
L20:    invokespecial [13] 
L23:    aload_1 
L24:    monitorexit 
L25:    areturn 
        .catch [0] from L26 to L28 using L26 
L26:    aload_1 
L27:    monitorexit 
L28:    athrow 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method private native [111] : [112] 
    .attribute [102] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected [113] : [114] 
    .attribute [102] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [9] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [115] : [116] 
    .attribute [102] .code stack 4 locals 1 
L0:     aload_0 
L1:     dup 
L2:     astore_1 
L3:     monitorenter 
        .catch [0] from L4 to L17 using L34 
L4:     aload_0 
L5:     getfield [8] 
L8:     ldc2_w [21] 
L11:    lcmp 
L12:    ifne L18 
L15:    aload_1 
L16:    monitorexit 
L17:    return 
        .catch [0] from L18 to L31 using L34 
L18:    aload_0 
L19:    invokespecial [14] 
L22:    aload_0 
L23:    ldc2_w [21] 
L26:    putfield [19] 
L29:    aload_1 
L30:    monitorexit 
L31:    goto L37 
        .catch [0] from L34 to L36 using L34 
L34:    aload_1 
L35:    monitorexit 
L36:    athrow 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method private native [117] : [118] 
    .attribute [102] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [119] : [120] 
    .attribute [102] .code stack 6 locals 2 
L0:     iconst_1 
L1:     newarray byte 
L3:     astore_1 
L4:     aload_0 
L5:     dup 
L6:     astore_2 
L7:     monitorenter 
        .catch [0] from L8 to L25 using L32 
L8:     aload_0 
L9:     aload_1 
L10:    iconst_0 
L11:    iconst_1 
L12:    aload_0 
L13:    getfield [8] 
L16:    invokespecial [15] 
L19:    iconst_m1 
L20:    if_icmpne L27 
L23:    aload_2 
L24:    monitorexit 
L25:    iconst_m1 
L26:    areturn 
        .catch [0] from L27 to L29 using L32 
L27:    aload_2 
L28:    monitorexit 
L29:    goto L35 
        .catch [0] from L32 to L34 using L32 
L32:    aload_2 
L33:    monitorexit 
L34:    athrow 
L35:    aload_1 
L36:    iconst_0 
L37:    baload 
L38:    areturn 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [121] : [122] 
    .attribute [102] .code stack 6 locals 1 
L0:     aload_0 
L1:     dup 
L2:     astore_2 
L3:     monitorenter 
        .catch [0] from L4 to L18 using L19 
L4:     aload_0 
L5:     aload_1 
L6:     iconst_0 
L7:     aload_1 
L8:     arraylength 
L9:     aload_0 
L10:    getfield [8] 
L13:    invokespecial [15] 
L16:    aload_2 
L17:    monitorexit 
L18:    areturn 
        .catch [0] from L19 to L21 using L19 
L19:    aload_2 
L20:    monitorexit 
L21:    athrow 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [123] : [124] 
    .attribute [102] .code stack 6 locals 1 
L0:     aload_0 
L1:     dup 
L2:     astore 4 
L4:     monitorenter 
        .catch [0] from L5 to L19 using L72 
L5:     aload_0 
L6:     getfield [8] 
L9:     ldc2_w [21] 
L12:    lcmp 
L13:    ifne L21 
L16:    aload 4 
L18:    monitorexit 
L19:    iconst_m1 
L20:    areturn 
        .catch [0] from L21 to L71 using L72 
L21:    iload_3 
L22:    iflt L49 
L25:    iload_3 
L26:    aload_1 
L27:    arraylength 
L28:    if_icmpgt L49 
L31:    iload_2 
L32:    iflt L49 
L35:    iload_2 
L36:    aload_1 
L37:    arraylength 
L38:    if_icmpgt L49 
L41:    iload_3 
L42:    iload_2 
L43:    iadd 
L44:    aload_1 
L45:    arraylength 
L46:    if_icmple L57 
L49:    new [20] 
L52:    dup 
L53:    invokespecial [16] 
L56:    athrow 
L57:    aload_0 
L58:    aload_1 
L59:    iload_2 
L60:    iload_3 
L61:    aload_0 
L62:    getfield [8] 
L65:    invokespecial [15] 
L68:    aload 4 
L70:    monitorexit 
L71:    areturn 
        .catch [0] from L72 to L75 using L72 
L72:    aload 4 
L74:    monitorexit 
L75:    athrow 
L76:    
    .end code 
.end method 

.method private native [125] : [126] 
    .attribute [102] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private native [127] : [128] 
    .attribute [102] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [23] 
.const [3] = Class [24] 
.const [4] = Method [25] [26] 
.const [5] = Class [27] 
.const [6] = Class [28] 
.const [7] = Field [29] [30] 
.const [8] = Field [31] [32] 
.const [9] = Method [33] [34] 
.const [10] = Method [35] [36] 
.const [11] = Method [37] [38] 
.const [12] = Method [39] [40] 
.const [13] = Method [41] [42] 
.const [14] = Method [43] [44] 
.const [15] = Method [45] [46] 
.const [16] = Method [47] [48] 
.const [17] = Class [49] 
.const [18] = Field [50] [51] 
.const [19] = Field [52] [53] 
.const [20] = Class [54] 
.const [21] = Long -1L 
.const [23] = Utf8 com/ibm/oti/lang/ProcessInputStream 
.const [24] = Utf8 java/io/InputStream 
.const [25] = Class [55] 
.const [26] = NameAndType [56] [57] 
.const [27] = Utf8 java/io/FileDescriptor 
.const [28] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [29] = Class [58] 
.const [30] = NameAndType [59] [60] 
.const [31] = Class [61] 
.const [32] = NameAndType [62] [63] 
.const [33] = Class [64] 
.const [34] = NameAndType [65] [66] 
.const [35] = Class [67] 
.const [36] = NameAndType [68] [69] 
.const [37] = Class [70] 
.const [38] = NameAndType [71] [72] 
.const [39] = Class [73] 
.const [40] = NameAndType [74] [75] 
.const [41] = Class [76] 
.const [42] = NameAndType [77] [78] 
.const [43] = Class [79] 
.const [44] = NameAndType [80] [81] 
.const [45] = Class [82] 
.const [46] = NameAndType [83] [84] 
.const [47] = Class [85] 
.const [48] = NameAndType [86] [87] 
.const [49] = Utf8 java/io/FileDescriptor 
.const [50] = Class [88] 
.const [51] = NameAndType [89] [90] 
.const [52] = Class [91] 
.const [53] = NameAndType [92] [93] 
.const [54] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [55] = Utf8 com/ibm/oti/lang/ProcessInputStream 
.const [56] = Utf8 oneTimeInitialization 
.const [57] = Utf8 ()V 
.const [58] = Utf8 com/ibm/oti/lang/ProcessInputStream 
.const [59] = Utf8 fd 
.const [60] = Utf8 Ljava/io/FileDescriptor; 
.const [61] = Utf8 com/ibm/oti/lang/ProcessInputStream 
.const [62] = Utf8 handle 
.const [63] = Utf8 J 
.const [64] = Utf8 com/ibm/oti/lang/ProcessInputStream 
.const [65] = Utf8 close 
.const [66] = Utf8 ()V 
.const [67] = Utf8 java/io/InputStream 
.const [68] = Utf8 <init> 
.const [69] = Utf8 ()V 
.const [70] = Utf8 java/io/FileDescriptor 
.const [71] = Utf8 <init> 
.const [72] = Utf8 ()V 
.const [73] = Utf8 com/ibm/oti/lang/ProcessInputStream 
.const [74] = Utf8 setFDImpl 
.const [75] = Utf8 (Ljava/io/FileDescriptor;J)V 
.const [76] = Utf8 com/ibm/oti/lang/ProcessInputStream 
.const [77] = Utf8 availableImpl 
.const [78] = Utf8 ()I 
.const [79] = Utf8 com/ibm/oti/lang/ProcessInputStream 
.const [80] = Utf8 closeImpl 
.const [81] = Utf8 ()V 
.const [82] = Utf8 com/ibm/oti/lang/ProcessInputStream 
.const [83] = Utf8 readImpl 
.const [84] = Utf8 ([BIIJ)I 
.const [85] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [86] = Utf8 <init> 
.const [87] = Utf8 ()V 
.const [88] = Utf8 com/ibm/oti/lang/ProcessInputStream 
.const [89] = Utf8 fd 
.const [90] = Utf8 Ljava/io/FileDescriptor; 
.const [91] = Utf8 com/ibm/oti/lang/ProcessInputStream 
.const [92] = Utf8 handle 
.const [93] = Utf8 J 
.const [94] = Utf8 com/ibm/oti/lang/ProcessInputStream 
.const [95] = Class [94] 
.const [96] = Utf8 java/io/InputStream 
.const [97] = Class [96] 
.const [98] = Utf8 handle 
.const [99] = Utf8 J 
.const [100] = Utf8 fd 
.const [101] = Utf8 Ljava/io/FileDescriptor; 
.const [102] = Utf8 Code 
.const [103] = Utf8 <clinit> 
.const [104] = Utf8 ()V 
.const [105] = Utf8 oneTimeInitialization 
.const [106] = Utf8 ()V 
.const [107] = Utf8 <init> 
.const [108] = Utf8 (J)V 
.const [109] = Utf8 available 
.const [110] = Utf8 ()I 
.const [111] = Utf8 availableImpl 
.const [112] = Utf8 ()I 
.const [113] = Utf8 finalize 
.const [114] = Utf8 ()V 
.const [115] = Utf8 close 
.const [116] = Utf8 ()V 
.const [117] = Utf8 closeImpl 
.const [118] = Utf8 ()V 
.const [119] = Utf8 read 
.const [120] = Utf8 ()I 
.const [121] = Utf8 read 
.const [122] = Utf8 ([B)I 
.const [123] = Utf8 read 
.const [124] = Utf8 ([BII)I 
.const [125] = Utf8 readImpl 
.const [126] = Utf8 ([BIIJ)I 
.const [127] = Utf8 setFDImpl 
.const [128] = Utf8 (Ljava/io/FileDescriptor;J)V 
.end class 
