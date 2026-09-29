.version 50 0 
.class super [57] 
.super [59] 
.field [60] [61] 
.field [62] [63] 
.field [64] [65] 

.method public [67] : [68] 
    .attribute [66] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [9] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [10] 
L9:     aload_0 
L10:    iload_1 
L11:    iconst_4 
L12:    imul 
L13:    putfield [11] 
L16:    aload_0 
L17:    iload_1 
L18:    newarray byte 
L20:    putfield [12] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [69] : [70] 
    .attribute [66] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [6] 
L4:     aload_0 
L5:     getfield [8] 
L8:     arraylength 
L9:     if_icmpne L57 
L12:    aload_0 
L13:    getfield [8] 
L16:    arraylength 
L17:    iconst_2 
L18:    imul 
L19:    istore_2 
L20:    iload_2 
L21:    aload_0 
L22:    getfield [7] 
L25:    if_icmpge L33 
L28:    aload_0 
L29:    getfield [7] 
L32:    istore_2 
L33:    iload_2 
L34:    newarray byte 
L36:    astore_3 
L37:    aload_0 
L38:    getfield [8] 
L41:    iconst_0 
L42:    aload_3 
L43:    iconst_0 
L44:    aload_0 
L45:    getfield [8] 
L48:    arraylength 
L49:    invokestatic [5] 
L52:    aload_0 
L53:    aload_3 
L54:    putfield [12] 
L57:    aload_0 
L58:    getfield [8] 
L61:    aload_0 
L62:    dup 
L63:    getfield [6] 
L66:    dup_x1 
L67:    iconst_1 
L68:    iadd 
L69:    putfield [10] 
L72:    iload_1 
L73:    i2b 
L74:    bastore 
L75:    return 
L76:    
    .end code 
.end method 

.method public [71] : [72] 
    .attribute [66] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [6] 
L4:     aload_0 
L5:     getfield [8] 
L8:     arraylength 
L9:     if_icmpne L17 
L12:    aload_0 
L13:    getfield [8] 
L16:    areturn 
L17:    aload_0 
L18:    getfield [6] 
L21:    newarray byte 
L23:    astore_1 
L24:    aload_0 
L25:    getfield [8] 
L28:    iconst_0 
L29:    aload_1 
L30:    iconst_0 
L31:    aload_0 
L32:    getfield [6] 
L35:    invokestatic [5] 
L38:    aload_1 
L39:    areturn 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [13] 
.const [3] = Class [14] 
.const [4] = Class [15] 
.const [5] = Method [16] [17] 
.const [6] = Field [18] [19] 
.const [7] = Field [20] [21] 
.const [8] = Field [22] [23] 
.const [9] = Method [24] [25] 
.const [10] = Field [26] [27] 
.const [11] = Field [28] [29] 
.const [12] = Field [30] [31] 
.const [13] = Utf8 com/ibm/oti/io/CharacterConverter_GB18030$Output 
.const [14] = Utf8 java/lang/Object 
.const [15] = Utf8 java/lang/System 
.const [16] = Class [32] 
.const [17] = NameAndType [33] [34] 
.const [18] = Class [35] 
.const [19] = NameAndType [36] [37] 
.const [20] = Class [38] 
.const [21] = NameAndType [39] [40] 
.const [22] = Class [41] 
.const [23] = NameAndType [42] [43] 
.const [24] = Class [44] 
.const [25] = NameAndType [45] [46] 
.const [26] = Class [47] 
.const [27] = NameAndType [48] [49] 
.const [28] = Class [50] 
.const [29] = NameAndType [51] [52] 
.const [30] = Class [53] 
.const [31] = NameAndType [54] [55] 
.const [32] = Utf8 java/lang/System 
.const [33] = Utf8 arraycopy 
.const [34] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [35] = Utf8 com/ibm/oti/io/CharacterConverter_GB18030$Output 
.const [36] = Utf8 pos 
.const [37] = Utf8 I 
.const [38] = Utf8 com/ibm/oti/io/CharacterConverter_GB18030$Output 
.const [39] = Utf8 byteSize 
.const [40] = Utf8 I 
.const [41] = Utf8 com/ibm/oti/io/CharacterConverter_GB18030$Output 
.const [42] = Utf8 buf 
.const [43] = Utf8 [B 
.const [44] = Utf8 java/lang/Object 
.const [45] = Utf8 <init> 
.const [46] = Utf8 ()V 
.const [47] = Utf8 com/ibm/oti/io/CharacterConverter_GB18030$Output 
.const [48] = Utf8 pos 
.const [49] = Utf8 I 
.const [50] = Utf8 com/ibm/oti/io/CharacterConverter_GB18030$Output 
.const [51] = Utf8 byteSize 
.const [52] = Utf8 I 
.const [53] = Utf8 com/ibm/oti/io/CharacterConverter_GB18030$Output 
.const [54] = Utf8 buf 
.const [55] = Utf8 [B 
.const [56] = Utf8 com/ibm/oti/io/CharacterConverter_GB18030$Output 
.const [57] = Class [56] 
.const [58] = Utf8 java/lang/Object 
.const [59] = Class [58] 
.const [60] = Utf8 buf 
.const [61] = Utf8 [B 
.const [62] = Utf8 byteSize 
.const [63] = Utf8 I 
.const [64] = Utf8 pos 
.const [65] = Utf8 I 
.const [66] = Utf8 Code 
.const [67] = Utf8 <init> 
.const [68] = Utf8 (I)V 
.const [69] = Utf8 write 
.const [70] = Utf8 (I)V 
.const [71] = Utf8 toByteArray 
.const [72] = Utf8 ()[B 
.end class 
