.version 50 0 
.class final super [109] 
.super [111] 
.field private [112] [113] 
.field private [114] [115] 
.field private [116] [117] 

.method [119] : [120] 
    .attribute [118] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     iconst_1 
L6:     newarray byte 
L8:     putfield [21] 
L11:    aload_0 
L12:    aload_1 
L13:    putfield [22] 
L16:    aload_0 
L17:    iconst_1 
L18:    putfield [23] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [121] : [122] 
    .attribute [118] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifeq L15 
L7:     aload_0 
L8:     getfield [12] 
L11:    invokevirtual [14] 
L14:    areturn 
L15:    new [24] 
L18:    dup 
L19:    ldc [6] 
L21:    invokestatic [8] 
L24:    invokespecial [18] 
L27:    athrow 
L28:    
    .end code 
.end method 

.method public [123] : [124] 
    .attribute [118] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifeq L15 
L7:     aload_0 
L8:     getfield [12] 
L11:    iconst_1 
L12:    invokevirtual [15] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [23] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [125] : [126] 
    .attribute [118] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifeq L60 
L7:     aload_1 
L8:     ifnull L52 
L11:    iload_2 
L12:    iflt L44 
L15:    iload_3 
L16:    iflt L44 
L19:    iload_2 
L20:    aload_1 
L21:    arraylength 
L22:    if_icmpgt L44 
L25:    aload_1 
L26:    arraylength 
L27:    iload_2 
L28:    isub 
L29:    iload_3 
L30:    if_icmplt L44 
L33:    aload_0 
L34:    getfield [12] 
L37:    aload_1 
L38:    iload_2 
L39:    iload_3 
L40:    invokevirtual [16] 
L43:    areturn 
L44:    new [25] 
L47:    dup 
L48:    invokespecial [19] 
L51:    athrow 
L52:    new [26] 
L55:    dup 
L56:    invokespecial [20] 
L59:    athrow 
L60:    new [24] 
L63:    dup 
L64:    ldc [6] 
L66:    invokestatic [8] 
L69:    invokespecial [18] 
L72:    athrow 
L73:    nop 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [127] : [128] 
    .attribute [118] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifeq L50 
L7:     aload_0 
L8:     dup 
L9:     astore_1 
L10:    monitorenter 
        .catch [0] from L11 to L39 using L45 
L11:    aload_0 
L12:    getfield [12] 
L15:    aload_0 
L16:    getfield [11] 
L19:    iconst_0 
L20:    iconst_1 
L21:    invokevirtual [16] 
L24:    ifle L40 
L27:    aload_0 
L28:    getfield [11] 
L31:    iconst_0 
L32:    baload 
L33:    sipush 255 
L36:    iand 
L37:    aload_1 
L38:    monitorexit 
L39:    areturn 
        .catch [0] from L40 to L42 using L45 
L40:    aload_1 
L41:    monitorexit 
L42:    goto L48 
        .catch [0] from L45 to L47 using L45 
L45:    aload_1 
L46:    monitorexit 
L47:    athrow 
L48:    iconst_m1 
L49:    areturn 
L50:    new [24] 
L53:    dup 
L54:    ldc [6] 
L56:    invokestatic [8] 
L59:    invokespecial [18] 
L62:    athrow 
L63:    nop 
L64:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [27] 
.const [3] = Class [28] 
.const [4] = Class [29] 
.const [5] = Class [30] 
.const [6] = String [31] 
.const [7] = Class [32] 
.const [8] = Method [33] [34] 
.const [9] = Class [35] 
.const [10] = Class [36] 
.const [11] = Field [37] [38] 
.const [12] = Field [39] [40] 
.const [13] = Field [41] [42] 
.const [14] = Method [43] [44] 
.const [15] = Method [45] [46] 
.const [16] = Method [47] [48] 
.const [17] = Method [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Field [57] [58] 
.const [22] = Field [59] [60] 
.const [23] = Field [61] [62] 
.const [24] = Class [63] 
.const [25] = Class [64] 
.const [26] = Class [65] 
.const [27] = Utf8 com/ibm/oti/connection/comm/CommInputStream 
.const [28] = Utf8 java/io/InputStream 
.const [29] = Utf8 java/io/IOException 
.const [30] = Utf8 com/ibm/oti/connection/comm/Connection 
.const [31] = Utf8 K0059 
.const [32] = Utf8 com/ibm/oti/util/Msg 
.const [33] = Class [66] 
.const [34] = NameAndType [67] [68] 
.const [35] = Utf8 java/lang/IndexOutOfBoundsException 
.const [36] = Utf8 java/lang/NullPointerException 
.const [37] = Class [69] 
.const [38] = NameAndType [70] [71] 
.const [39] = Class [72] 
.const [40] = NameAndType [73] [74] 
.const [41] = Class [75] 
.const [42] = NameAndType [76] [77] 
.const [43] = Class [78] 
.const [44] = NameAndType [79] [80] 
.const [45] = Class [81] 
.const [46] = NameAndType [82] [83] 
.const [47] = Class [84] 
.const [48] = NameAndType [85] [86] 
.const [49] = Class [87] 
.const [50] = NameAndType [88] [89] 
.const [51] = Class [90] 
.const [52] = NameAndType [91] [92] 
.const [53] = Class [93] 
.const [54] = NameAndType [94] [95] 
.const [55] = Class [96] 
.const [56] = NameAndType [97] [98] 
.const [57] = Class [99] 
.const [58] = NameAndType [100] [101] 
.const [59] = Class [102] 
.const [60] = NameAndType [103] [104] 
.const [61] = Class [105] 
.const [62] = NameAndType [106] [107] 
.const [63] = Utf8 java/io/IOException 
.const [64] = Utf8 java/lang/IndexOutOfBoundsException 
.const [65] = Utf8 java/lang/NullPointerException 
.const [66] = Utf8 com/ibm/oti/util/Msg 
.const [67] = Utf8 getString 
.const [68] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [69] = Utf8 com/ibm/oti/connection/comm/CommInputStream 
.const [70] = Utf8 aByte 
.const [71] = Utf8 [B 
.const [72] = Utf8 com/ibm/oti/connection/comm/CommInputStream 
.const [73] = Utf8 connection 
.const [74] = Utf8 Lcom/ibm/oti/connection/comm/Connection; 
.const [75] = Utf8 com/ibm/oti/connection/comm/CommInputStream 
.const [76] = Utf8 'open' 
.const [77] = Utf8 Z 
.const [78] = Utf8 com/ibm/oti/connection/comm/Connection 
.const [79] = Utf8 available 
.const [80] = Utf8 ()I 
.const [81] = Utf8 com/ibm/oti/connection/comm/Connection 
.const [82] = Utf8 closeStream 
.const [83] = Utf8 (Z)V 
.const [84] = Utf8 com/ibm/oti/connection/comm/Connection 
.const [85] = Utf8 read 
.const [86] = Utf8 ([BII)I 
.const [87] = Utf8 java/io/InputStream 
.const [88] = Utf8 <init> 
.const [89] = Utf8 ()V 
.const [90] = Utf8 java/io/IOException 
.const [91] = Utf8 <init> 
.const [92] = Utf8 (Ljava/lang/String;)V 
.const [93] = Utf8 java/lang/IndexOutOfBoundsException 
.const [94] = Utf8 <init> 
.const [95] = Utf8 ()V 
.const [96] = Utf8 java/lang/NullPointerException 
.const [97] = Utf8 <init> 
.const [98] = Utf8 ()V 
.const [99] = Utf8 com/ibm/oti/connection/comm/CommInputStream 
.const [100] = Utf8 aByte 
.const [101] = Utf8 [B 
.const [102] = Utf8 com/ibm/oti/connection/comm/CommInputStream 
.const [103] = Utf8 connection 
.const [104] = Utf8 Lcom/ibm/oti/connection/comm/Connection; 
.const [105] = Utf8 com/ibm/oti/connection/comm/CommInputStream 
.const [106] = Utf8 'open' 
.const [107] = Utf8 Z 
.const [108] = Utf8 com/ibm/oti/connection/comm/CommInputStream 
.const [109] = Class [108] 
.const [110] = Utf8 java/io/InputStream 
.const [111] = Class [110] 
.const [112] = Utf8 connection 
.const [113] = Utf8 Lcom/ibm/oti/connection/comm/Connection; 
.const [114] = Utf8 'open' 
.const [115] = Utf8 Z 
.const [116] = Utf8 aByte 
.const [117] = Utf8 [B 
.const [118] = Utf8 Code 
.const [119] = Utf8 <init> 
.const [120] = Utf8 (Lcom/ibm/oti/connection/comm/Connection;)V 
.const [121] = Utf8 available 
.const [122] = Utf8 ()I 
.const [123] = Utf8 close 
.const [124] = Utf8 ()V 
.const [125] = Utf8 read 
.const [126] = Utf8 ([BII)I 
.const [127] = Utf8 read 
.const [128] = Utf8 ()I 
.end class 
