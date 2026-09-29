.version 50 0 
.class public super [63] 
.super [65] 
.field public final [66] [67] 
.field public final [68] [69] 
.field public final [70] [71] 

.method public [73] : [74] 
    .attribute [72] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [9] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [11] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [12] 
L14:    aload_0 
L15:    iload_3 
L16:    putfield [13] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [75] : [76] 
    .attribute [72] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     iconst_0 
L4:     invokespecial [10] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [77] : [78] 
    .attribute [72] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_1 
L3:     ifnull L11 
L6:     aload_1 
L7:     arraylength 
L8:     goto L12 
L11:    iconst_0 
L12:    iconst_0 
L13:    invokespecial [10] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public static [79] : [80] 
    .attribute [72] .code stack 5 locals 3 
L0:     iconst_0 
L1:     istore_2 
L2:     iconst_0 
L3:     istore_3 
L4:     aload_0 
L5:     ifnull L20 
L8:     iload_2 
L9:     aload_0 
L10:    getfield [7] 
L13:    iadd 
L14:    istore_2 
L15:    aload_0 
L16:    getfield [7] 
L19:    istore_3 
L20:    aload_1 
L21:    ifnull L31 
L24:    iload_2 
L25:    aload_1 
L26:    getfield [7] 
L29:    iadd 
L30:    istore_2 
L31:    iload_2 
L32:    newarray byte 
L34:    astore 4 
L36:    aload_0 
L37:    ifnull L72 
L40:    aload_0 
L41:    getfield [6] 
L44:    ifnull L72 
L47:    aload_0 
L48:    getfield [7] 
L51:    ifle L72 
L54:    aload_0 
L55:    getfield [6] 
L58:    aload_0 
L59:    getfield [8] 
L62:    aload 4 
L64:    iconst_0 
L65:    aload_0 
L66:    getfield [7] 
L69:    invokestatic [2] 
L72:    aload_1 
L73:    ifnull L108 
L76:    aload_1 
L77:    getfield [6] 
L80:    ifnull L108 
L83:    aload_1 
L84:    getfield [7] 
L87:    ifle L108 
L90:    aload_1 
L91:    getfield [6] 
L94:    aload_1 
L95:    getfield [8] 
L98:    aload 4 
L100:   iload_3 
L101:   aload_1 
L102:   getfield [7] 
L105:   invokestatic [2] 
L108:   aload 4 
L110:   areturn 
L111:   nop 
L112:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [14] [15] 
.const [3] = Class [16] 
.const [4] = Class [17] 
.const [5] = Class [18] 
.const [6] = Field [19] [20] 
.const [7] = Field [21] [22] 
.const [8] = Field [23] [24] 
.const [9] = Method [25] [26] 
.const [10] = Method [27] [28] 
.const [11] = Field [29] [30] 
.const [12] = Field [31] [32] 
.const [13] = Field [33] [34] 
.const [14] = Class [35] 
.const [15] = NameAndType [36] [37] 
.const [16] = Utf8 de/esolutions/fw/comm/core/tracing/SubBuffer 
.const [17] = Utf8 java/lang/Object 
.const [18] = Utf8 java/lang/System 
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
.const [35] = Utf8 java/lang/System 
.const [36] = Utf8 arraycopy 
.const [37] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [38] = Utf8 de/esolutions/fw/comm/core/tracing/SubBuffer 
.const [39] = Utf8 data 
.const [40] = Utf8 [B 
.const [41] = Utf8 de/esolutions/fw/comm/core/tracing/SubBuffer 
.const [42] = Utf8 size 
.const [43] = Utf8 I 
.const [44] = Utf8 de/esolutions/fw/comm/core/tracing/SubBuffer 
.const [45] = Utf8 offset 
.const [46] = Utf8 I 
.const [47] = Utf8 java/lang/Object 
.const [48] = Utf8 <init> 
.const [49] = Utf8 ()V 
.const [50] = Utf8 de/esolutions/fw/comm/core/tracing/SubBuffer 
.const [51] = Utf8 <init> 
.const [52] = Utf8 ([BII)V 
.const [53] = Utf8 de/esolutions/fw/comm/core/tracing/SubBuffer 
.const [54] = Utf8 data 
.const [55] = Utf8 [B 
.const [56] = Utf8 de/esolutions/fw/comm/core/tracing/SubBuffer 
.const [57] = Utf8 size 
.const [58] = Utf8 I 
.const [59] = Utf8 de/esolutions/fw/comm/core/tracing/SubBuffer 
.const [60] = Utf8 offset 
.const [61] = Utf8 I 
.const [62] = Utf8 de/esolutions/fw/comm/core/tracing/SubBuffer 
.const [63] = Class [62] 
.const [64] = Utf8 java/lang/Object 
.const [65] = Class [64] 
.const [66] = Utf8 data 
.const [67] = Utf8 [B 
.const [68] = Utf8 size 
.const [69] = Utf8 I 
.const [70] = Utf8 offset 
.const [71] = Utf8 I 
.const [72] = Utf8 Code 
.const [73] = Utf8 <init> 
.const [74] = Utf8 ([BII)V 
.const [75] = Utf8 <init> 
.const [76] = Utf8 ([BI)V 
.const [77] = Utf8 <init> 
.const [78] = Utf8 ([B)V 
.const [79] = Utf8 concat 
.const [80] = Utf8 (Lde/esolutions/fw/comm/core/tracing/SubBuffer;Lde/esolutions/fw/comm/core/tracing/SubBuffer;)[B 
.end class 
