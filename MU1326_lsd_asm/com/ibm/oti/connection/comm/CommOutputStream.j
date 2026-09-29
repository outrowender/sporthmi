.version 50 0 
.class final super [103] 
.super [105] 
.field private [106] [107] 
.field private [108] [109] 
.field private [110] [111] 

.method [113] : [114] 
    .attribute [112] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     aload_0 
L5:     iconst_1 
L6:     newarray byte 
L8:     putfield [20] 
L11:    aload_0 
L12:    aload_1 
L13:    putfield [21] 
L16:    aload_0 
L17:    iconst_1 
L18:    putfield [22] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [115] : [116] 
    .attribute [112] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifeq L15 
L7:     aload_0 
L8:     getfield [12] 
L11:    iconst_0 
L12:    invokevirtual [14] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [22] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [117] : [118] 
    .attribute [112] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifeq L69 
L7:     aload_1 
L8:     ifnull L58 
L11:    iload_2 
L12:    iflt L47 
L15:    iload_3 
L16:    iflt L47 
L19:    iload_2 
L20:    aload_1 
L21:    arraylength 
L22:    if_icmpgt L47 
L25:    aload_1 
L26:    arraylength 
L27:    iload_2 
L28:    isub 
L29:    iload_3 
L30:    if_icmplt L47 
L33:    aload_0 
L34:    getfield [12] 
L37:    aload_1 
L38:    iload_2 
L39:    iload_3 
L40:    invokevirtual [15] 
L43:    pop 
L44:    goto L82 
L47:    new [24] 
L50:    dup 
L51:    invokespecial [17] 
L54:    athrow 
L55:    goto L82 
L58:    new [25] 
L61:    dup 
L62:    invokespecial [18] 
L65:    athrow 
L66:    goto L82 
L69:    new [23] 
L72:    dup 
L73:    ldc [8] 
L75:    invokestatic [10] 
L78:    invokespecial [19] 
L81:    athrow 
L82:    return 
L83:    nop 
L84:    
    .end code 
.end method 

.method public [119] : [120] 
    .attribute [112] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifeq L44 
L7:     aload_0 
L8:     dup 
L9:     astore_2 
L10:    monitorenter 
        .catch [0] from L11 to L35 using L38 
L11:    aload_0 
L12:    getfield [11] 
L15:    iconst_0 
L16:    iload_1 
L17:    i2b 
L18:    bastore 
L19:    aload_0 
L20:    getfield [12] 
L23:    aload_0 
L24:    getfield [11] 
L27:    iconst_0 
L28:    iconst_1 
L29:    invokevirtual [15] 
L32:    pop 
L33:    aload_2 
L34:    monitorexit 
L35:    goto L57 
        .catch [0] from L38 to L40 using L38 
L38:    aload_2 
L39:    monitorexit 
L40:    athrow 
L41:    goto L57 
L44:    new [23] 
L47:    dup 
L48:    ldc [8] 
L50:    invokestatic [10] 
L53:    invokespecial [19] 
L56:    athrow 
L57:    return 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [26] 
.const [3] = Class [27] 
.const [4] = Class [28] 
.const [5] = Class [29] 
.const [6] = Class [30] 
.const [7] = Class [31] 
.const [8] = String [32] 
.const [9] = Class [33] 
.const [10] = Method [34] [35] 
.const [11] = Field [36] [37] 
.const [12] = Field [38] [39] 
.const [13] = Field [40] [41] 
.const [14] = Method [42] [43] 
.const [15] = Method [44] [45] 
.const [16] = Method [46] [47] 
.const [17] = Method [48] [49] 
.const [18] = Method [50] [51] 
.const [19] = Method [52] [53] 
.const [20] = Field [54] [55] 
.const [21] = Field [56] [57] 
.const [22] = Field [58] [59] 
.const [23] = Class [60] 
.const [24] = Class [61] 
.const [25] = Class [62] 
.const [26] = Utf8 com/ibm/oti/connection/comm/CommOutputStream 
.const [27] = Utf8 java/io/OutputStream 
.const [28] = Utf8 java/io/IOException 
.const [29] = Utf8 com/ibm/oti/connection/comm/Connection 
.const [30] = Utf8 java/lang/IndexOutOfBoundsException 
.const [31] = Utf8 java/lang/NullPointerException 
.const [32] = Utf8 K0059 
.const [33] = Utf8 com/ibm/oti/util/Msg 
.const [34] = Class [63] 
.const [35] = NameAndType [64] [65] 
.const [36] = Class [66] 
.const [37] = NameAndType [67] [68] 
.const [38] = Class [69] 
.const [39] = NameAndType [70] [71] 
.const [40] = Class [72] 
.const [41] = NameAndType [73] [74] 
.const [42] = Class [75] 
.const [43] = NameAndType [76] [77] 
.const [44] = Class [78] 
.const [45] = NameAndType [79] [80] 
.const [46] = Class [81] 
.const [47] = NameAndType [82] [83] 
.const [48] = Class [84] 
.const [49] = NameAndType [85] [86] 
.const [50] = Class [87] 
.const [51] = NameAndType [88] [89] 
.const [52] = Class [90] 
.const [53] = NameAndType [91] [92] 
.const [54] = Class [93] 
.const [55] = NameAndType [94] [95] 
.const [56] = Class [96] 
.const [57] = NameAndType [97] [98] 
.const [58] = Class [99] 
.const [59] = NameAndType [100] [101] 
.const [60] = Utf8 java/io/IOException 
.const [61] = Utf8 java/lang/IndexOutOfBoundsException 
.const [62] = Utf8 java/lang/NullPointerException 
.const [63] = Utf8 com/ibm/oti/util/Msg 
.const [64] = Utf8 getString 
.const [65] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [66] = Utf8 com/ibm/oti/connection/comm/CommOutputStream 
.const [67] = Utf8 aByte 
.const [68] = Utf8 [B 
.const [69] = Utf8 com/ibm/oti/connection/comm/CommOutputStream 
.const [70] = Utf8 connection 
.const [71] = Utf8 Lcom/ibm/oti/connection/comm/Connection; 
.const [72] = Utf8 com/ibm/oti/connection/comm/CommOutputStream 
.const [73] = Utf8 'open' 
.const [74] = Utf8 Z 
.const [75] = Utf8 com/ibm/oti/connection/comm/Connection 
.const [76] = Utf8 closeStream 
.const [77] = Utf8 (Z)V 
.const [78] = Utf8 com/ibm/oti/connection/comm/Connection 
.const [79] = Utf8 write 
.const [80] = Utf8 ([BII)I 
.const [81] = Utf8 java/io/OutputStream 
.const [82] = Utf8 <init> 
.const [83] = Utf8 ()V 
.const [84] = Utf8 java/lang/IndexOutOfBoundsException 
.const [85] = Utf8 <init> 
.const [86] = Utf8 ()V 
.const [87] = Utf8 java/lang/NullPointerException 
.const [88] = Utf8 <init> 
.const [89] = Utf8 ()V 
.const [90] = Utf8 java/io/IOException 
.const [91] = Utf8 <init> 
.const [92] = Utf8 (Ljava/lang/String;)V 
.const [93] = Utf8 com/ibm/oti/connection/comm/CommOutputStream 
.const [94] = Utf8 aByte 
.const [95] = Utf8 [B 
.const [96] = Utf8 com/ibm/oti/connection/comm/CommOutputStream 
.const [97] = Utf8 connection 
.const [98] = Utf8 Lcom/ibm/oti/connection/comm/Connection; 
.const [99] = Utf8 com/ibm/oti/connection/comm/CommOutputStream 
.const [100] = Utf8 'open' 
.const [101] = Utf8 Z 
.const [102] = Utf8 com/ibm/oti/connection/comm/CommOutputStream 
.const [103] = Class [102] 
.const [104] = Utf8 java/io/OutputStream 
.const [105] = Class [104] 
.const [106] = Utf8 connection 
.const [107] = Utf8 Lcom/ibm/oti/connection/comm/Connection; 
.const [108] = Utf8 'open' 
.const [109] = Utf8 Z 
.const [110] = Utf8 aByte 
.const [111] = Utf8 [B 
.const [112] = Utf8 Code 
.const [113] = Utf8 <init> 
.const [114] = Utf8 (Lcom/ibm/oti/connection/comm/Connection;)V 
.const [115] = Utf8 close 
.const [116] = Utf8 ()V 
.const [117] = Utf8 write 
.const [118] = Utf8 ([BII)V 
.const [119] = Utf8 write 
.const [120] = Utf8 (I)V 
.end class 
