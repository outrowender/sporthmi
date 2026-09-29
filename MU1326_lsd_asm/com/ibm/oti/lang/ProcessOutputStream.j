.version 50 0 
.class super [79] 
.super [81] 
.field private [82] [83] 
.field private [84] [85] 

.method static [87] : [88] 
    .attribute [86] .code stack 0 locals 0 
L0:     invokestatic [4] 
L3:     return 
L4:     
    .end code 
.end method 

.method private static native [89] : [90] 
    .attribute [86] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected [91] : [92] 
    .attribute [86] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [9] 
L4:     aload_0 
L5:     new [14] 
L8:     dup 
L9:     invokespecial [10] 
L12:    putfield [15] 
L15:    aload_0 
L16:    aload_0 
L17:    getfield [6] 
L20:    lload_1 
L21:    invokespecial [11] 
L24:    aload_0 
L25:    lload_1 
L26:    putfield [16] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method protected [93] : [94] 
    .attribute [86] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [8] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [95] : [96] 
    .attribute [86] .code stack 4 locals 1 
L0:     aload_0 
L1:     dup 
L2:     astore_1 
L3:     monitorenter 
        .catch [0] from L4 to L17 using L34 
L4:     aload_0 
L5:     getfield [7] 
L8:     ldc2_w [17] 
L11:    lcmp 
L12:    ifne L18 
L15:    aload_1 
L16:    monitorexit 
L17:    return 
        .catch [0] from L18 to L31 using L34 
L18:    aload_0 
L19:    invokespecial [12] 
L22:    aload_0 
L23:    ldc2_w [17] 
L26:    putfield [16] 
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

.method private native [97] : [98] 
    .attribute [86] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private native [99] : [100] 
    .attribute [86] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [101] : [102] 
    .attribute [86] .code stack 6 locals 1 
L0:     aload_0 
L1:     dup 
L2:     astore_2 
L3:     monitorenter 
        .catch [0] from L4 to L18 using L21 
L4:     aload_0 
L5:     aload_1 
L6:     iconst_0 
L7:     aload_1 
L8:     arraylength 
L9:     aload_0 
L10:    getfield [7] 
L13:    invokespecial [13] 
L16:    aload_2 
L17:    monitorexit 
L18:    goto L24 
        .catch [0] from L21 to L23 using L21 
L21:    aload_2 
L22:    monitorexit 
L23:    athrow 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [86] .code stack 6 locals 1 
L0:     aload_0 
L1:     dup 
L2:     astore 4 
L4:     monitorenter 
        .catch [0] from L5 to L19 using L37 
L5:     aload_0 
L6:     getfield [7] 
L9:     ldc2_w [17] 
L12:    lcmp 
L13:    ifne L20 
L16:    aload 4 
L18:    monitorexit 
L19:    return 
        .catch [0] from L20 to L34 using L37 
L20:    aload_0 
L21:    aload_1 
L22:    iload_2 
L23:    iload_3 
L24:    aload_0 
L25:    getfield [7] 
L28:    invokespecial [13] 
L31:    aload 4 
L33:    monitorexit 
L34:    goto L41 
        .catch [0] from L37 to L40 using L37 
L37:    aload 4 
L39:    monitorexit 
L40:    athrow 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [86] .code stack 6 locals 2 
L0:     iconst_1 
L1:     newarray byte 
L3:     astore_2 
L4:     aload_2 
L5:     iconst_0 
L6:     iload_1 
L7:     i2b 
L8:     bastore 
L9:     aload_0 
L10:    dup 
L11:    astore_3 
L12:    monitorenter 
        .catch [0] from L13 to L26 using L29 
L13:    aload_0 
L14:    aload_2 
L15:    iconst_0 
L16:    iconst_1 
L17:    aload_0 
L18:    getfield [7] 
L21:    invokespecial [13] 
L24:    aload_3 
L25:    monitorexit 
L26:    goto L32 
        .catch [0] from L29 to L31 using L29 
L29:    aload_3 
L30:    monitorexit 
L31:    athrow 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method private native [107] : [108] 
    .attribute [86] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [19] 
.const [3] = Class [20] 
.const [4] = Method [21] [22] 
.const [5] = Class [23] 
.const [6] = Field [24] [25] 
.const [7] = Field [26] [27] 
.const [8] = Method [28] [29] 
.const [9] = Method [30] [31] 
.const [10] = Method [32] [33] 
.const [11] = Method [34] [35] 
.const [12] = Method [36] [37] 
.const [13] = Method [38] [39] 
.const [14] = Class [40] 
.const [15] = Field [41] [42] 
.const [16] = Field [43] [44] 
.const [17] = Long -1L 
.const [19] = Utf8 com/ibm/oti/lang/ProcessOutputStream 
.const [20] = Utf8 java/io/OutputStream 
.const [21] = Class [45] 
.const [22] = NameAndType [46] [47] 
.const [23] = Utf8 java/io/FileDescriptor 
.const [24] = Class [48] 
.const [25] = NameAndType [49] [50] 
.const [26] = Class [51] 
.const [27] = NameAndType [52] [53] 
.const [28] = Class [54] 
.const [29] = NameAndType [55] [56] 
.const [30] = Class [57] 
.const [31] = NameAndType [58] [59] 
.const [32] = Class [60] 
.const [33] = NameAndType [61] [62] 
.const [34] = Class [63] 
.const [35] = NameAndType [64] [65] 
.const [36] = Class [66] 
.const [37] = NameAndType [67] [68] 
.const [38] = Class [69] 
.const [39] = NameAndType [70] [71] 
.const [40] = Utf8 java/io/FileDescriptor 
.const [41] = Class [72] 
.const [42] = NameAndType [73] [74] 
.const [43] = Class [75] 
.const [44] = NameAndType [76] [77] 
.const [45] = Utf8 com/ibm/oti/lang/ProcessOutputStream 
.const [46] = Utf8 oneTimeInitialization 
.const [47] = Utf8 ()V 
.const [48] = Utf8 com/ibm/oti/lang/ProcessOutputStream 
.const [49] = Utf8 fd 
.const [50] = Utf8 Ljava/io/FileDescriptor; 
.const [51] = Utf8 com/ibm/oti/lang/ProcessOutputStream 
.const [52] = Utf8 handle 
.const [53] = Utf8 J 
.const [54] = Utf8 com/ibm/oti/lang/ProcessOutputStream 
.const [55] = Utf8 close 
.const [56] = Utf8 ()V 
.const [57] = Utf8 java/io/OutputStream 
.const [58] = Utf8 <init> 
.const [59] = Utf8 ()V 
.const [60] = Utf8 java/io/FileDescriptor 
.const [61] = Utf8 <init> 
.const [62] = Utf8 ()V 
.const [63] = Utf8 com/ibm/oti/lang/ProcessOutputStream 
.const [64] = Utf8 setFDImpl 
.const [65] = Utf8 (Ljava/io/FileDescriptor;J)V 
.const [66] = Utf8 com/ibm/oti/lang/ProcessOutputStream 
.const [67] = Utf8 closeImpl 
.const [68] = Utf8 ()V 
.const [69] = Utf8 com/ibm/oti/lang/ProcessOutputStream 
.const [70] = Utf8 writeImpl 
.const [71] = Utf8 ([BIIJ)V 
.const [72] = Utf8 com/ibm/oti/lang/ProcessOutputStream 
.const [73] = Utf8 fd 
.const [74] = Utf8 Ljava/io/FileDescriptor; 
.const [75] = Utf8 com/ibm/oti/lang/ProcessOutputStream 
.const [76] = Utf8 handle 
.const [77] = Utf8 J 
.const [78] = Utf8 com/ibm/oti/lang/ProcessOutputStream 
.const [79] = Class [78] 
.const [80] = Utf8 java/io/OutputStream 
.const [81] = Class [80] 
.const [82] = Utf8 handle 
.const [83] = Utf8 J 
.const [84] = Utf8 fd 
.const [85] = Utf8 Ljava/io/FileDescriptor; 
.const [86] = Utf8 Code 
.const [87] = Utf8 <clinit> 
.const [88] = Utf8 ()V 
.const [89] = Utf8 oneTimeInitialization 
.const [90] = Utf8 ()V 
.const [91] = Utf8 <init> 
.const [92] = Utf8 (J)V 
.const [93] = Utf8 finalize 
.const [94] = Utf8 ()V 
.const [95] = Utf8 close 
.const [96] = Utf8 ()V 
.const [97] = Utf8 closeImpl 
.const [98] = Utf8 ()V 
.const [99] = Utf8 setFDImpl 
.const [100] = Utf8 (Ljava/io/FileDescriptor;J)V 
.const [101] = Utf8 write 
.const [102] = Utf8 ([B)V 
.const [103] = Utf8 write 
.const [104] = Utf8 ([BII)V 
.const [105] = Utf8 write 
.const [106] = Utf8 (I)V 
.const [107] = Utf8 writeImpl 
.const [108] = Utf8 ([BIIJ)V 
.end class 
