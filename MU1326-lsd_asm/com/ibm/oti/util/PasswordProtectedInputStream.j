.version 50 0 
.class public super [63] 
.super [65] 
.field private [66] [67] 
.field private [68] [69] 

.method public [71] : [72] 
    .attribute [70] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [10] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [12] 
L10:    aload_0 
L11:    aload_2 
L12:    putfield [13] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [73] : [74] 
    .attribute [70] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [7] 
L4:     invokevirtual [8] 
L7:     istore_1 
L8:     iload_1 
L9:     iflt L40 
L12:    iload_1 
L13:    aload_0 
L14:    getfield [6] 
L17:    aload_0 
L18:    getfield [5] 
L21:    baload 
L22:    ixor 
L23:    istore_1 
L24:    aload_0 
L25:    aload_0 
L26:    getfield [5] 
L29:    iconst_1 
L30:    iadd 
L31:    aload_0 
L32:    getfield [6] 
L35:    arraylength 
L36:    irem 
L37:    putfield [12] 
L40:    iload_1 
L41:    areturn 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [75] : [76] 
    .attribute [70] .code stack 5 locals 3 
L0:     aload_0 
L1:     getfield [7] 
L4:     aload_1 
L5:     iload_2 
L6:     iload_3 
L7:     invokevirtual [9] 
L10:    istore 4 
L12:    iload 4 
L14:    ifle L72 
L17:    iload_2 
L18:    iload 4 
L20:    iadd 
L21:    istore 5 
L23:    iload_2 
L24:    istore 6 
L26:    goto L65 
L29:    aload_1 
L30:    iload 6 
L32:    dup2 
L33:    baload 
L34:    aload_0 
L35:    getfield [6] 
L38:    aload_0 
L39:    getfield [5] 
L42:    baload 
L43:    ixor 
L44:    i2b 
L45:    bastore 
L46:    aload_0 
L47:    aload_0 
L48:    getfield [5] 
L51:    iconst_1 
L52:    iadd 
L53:    aload_0 
L54:    getfield [6] 
L57:    arraylength 
L58:    irem 
L59:    putfield [12] 
L62:    iinc 6 1 
L65:    iload 6 
L67:    iload 5 
L69:    if_icmplt L29 
L72:    iload 4 
L74:    areturn 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [77] : [78] 
    .attribute [70] .code stack 5 locals 2 
L0:     aload_0 
L1:     lload_1 
L2:     invokespecial [11] 
L5:     lstore_3 
L6:     aload_0 
L7:     dup 
L8:     getfield [5] 
L11:    i2l 
L12:    lload_3 
L13:    ladd 
L14:    l2i 
L15:    putfield [12] 
L18:    lload_3 
L19:    freturn 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [14] 
.const [3] = Class [15] 
.const [4] = Class [16] 
.const [5] = Field [17] [18] 
.const [6] = Field [19] [20] 
.const [7] = Field [21] [22] 
.const [8] = Method [23] [24] 
.const [9] = Method [25] [26] 
.const [10] = Method [27] [28] 
.const [11] = Method [29] [30] 
.const [12] = Field [31] [32] 
.const [13] = Field [33] [34] 
.const [14] = Utf8 com/ibm/oti/util/PasswordProtectedInputStream 
.const [15] = Utf8 java/io/FilterInputStream 
.const [16] = Utf8 java/io/InputStream 
.const [17] = Class [35] 
.const [18] = NameAndType [36] [37] 
.const [19] = Class [38] 
.const [20] = NameAndType [39] [40] 
.const [21] = Class [41] 
.const [22] = NameAndType [42] [43] 
.const [23] = Class [44] 
.const [24] = NameAndType [45] [46] 
.const [25] = Class [47] 
.const [26] = NameAndType [48] [49] 
.const [27] = Class [50] 
.const [28] = NameAndType [51] [52] 
.const [29] = Class [53] 
.const [30] = NameAndType [54] [55] 
.const [31] = Class [56] 
.const [32] = NameAndType [57] [58] 
.const [33] = Class [59] 
.const [34] = NameAndType [60] [61] 
.const [35] = Utf8 com/ibm/oti/util/PasswordProtectedInputStream 
.const [36] = Utf8 pwdIndex 
.const [37] = Utf8 I 
.const [38] = Utf8 com/ibm/oti/util/PasswordProtectedInputStream 
.const [39] = Utf8 password 
.const [40] = Utf8 [B 
.const [41] = Utf8 com/ibm/oti/util/PasswordProtectedInputStream 
.const [42] = Utf8 in 
.const [43] = Utf8 Ljava/io/InputStream; 
.const [44] = Utf8 java/io/InputStream 
.const [45] = Utf8 read 
.const [46] = Utf8 ()I 
.const [47] = Utf8 java/io/InputStream 
.const [48] = Utf8 read 
.const [49] = Utf8 ([BII)I 
.const [50] = Utf8 java/io/FilterInputStream 
.const [51] = Utf8 <init> 
.const [52] = Utf8 (Ljava/io/InputStream;)V 
.const [53] = Utf8 java/io/FilterInputStream 
.const [54] = Utf8 skip 
.const [55] = Utf8 (J)J 
.const [56] = Utf8 com/ibm/oti/util/PasswordProtectedInputStream 
.const [57] = Utf8 pwdIndex 
.const [58] = Utf8 I 
.const [59] = Utf8 com/ibm/oti/util/PasswordProtectedInputStream 
.const [60] = Utf8 password 
.const [61] = Utf8 [B 
.const [62] = Utf8 com/ibm/oti/util/PasswordProtectedInputStream 
.const [63] = Class [62] 
.const [64] = Utf8 java/io/FilterInputStream 
.const [65] = Class [64] 
.const [66] = Utf8 password 
.const [67] = Utf8 [B 
.const [68] = Utf8 pwdIndex 
.const [69] = Utf8 I 
.const [70] = Utf8 Code 
.const [71] = Utf8 <init> 
.const [72] = Utf8 (Ljava/io/InputStream;[B)V 
.const [73] = Utf8 read 
.const [74] = Utf8 ()I 
.const [75] = Utf8 read 
.const [76] = Utf8 ([BII)I 
.const [77] = Utf8 skip 
.const [78] = Utf8 (J)J 
.end class 
