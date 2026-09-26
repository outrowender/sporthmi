.version 50 0 
.class public final super [31] 
.super [33] 

.method public annotation [35] : [36] 
    .attribute [34] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [7] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [37] : [38] 
    .attribute [34] .code stack 3 locals 0 
L0:     iload_0 
L1:     iconst_1 
L2:     iload_1 
L3:     ishl 
L4:     ior 
L5:     i2b 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [39] : [40] 
    .attribute [34] .code stack 3 locals 0 
L0:     iload_0 
L1:     iconst_1 
L2:     iload_1 
L3:     ishl 
L4:     iconst_m1 
L5:     ixor 
L6:     iand 
L7:     i2b 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public static [41] : [42] 
    .attribute [34] .code stack 3 locals 0 
L0:     iload_0 
L1:     iconst_1 
L2:     iload_1 
L3:     ishl 
L4:     iand 
L5:     ifeq L12 
L8:     iconst_1 
L9:     goto L13 
L12:    iconst_0 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public static [43] : [44] 
    .attribute [34] .code stack 3 locals 2 
L0:     iconst_0 
L1:     istore_3 
L2:     iload_1 
L3:     istore 4 
L5:     iload 4 
L7:     iload_2 
L8:     if_icmpgt L36 
L11:    iload_0 
L12:    iload 4 
L14:    invokestatic [2] 
L17:    ifeq L30 
L20:    iload_3 
L21:    iload 4 
L23:    iload_1 
L24:    isub 
L25:    i2b 
L26:    invokestatic [3] 
L29:    istore_3 
L30:    iinc 4 1 
L33:    goto L5 
L36:    iload_3 
L37:    areturn 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public static [45] : [46] 
    .attribute [34] .code stack 3 locals 1 
L0:     iload_2 
L1:     iflt L55 
L4:     iload_3 
L5:     bipush 7 
L7:     if_icmpgt L55 
L10:    iload_2 
L11:    istore 4 
L13:    iload 4 
L15:    iload_3 
L16:    if_icmpgt L55 
L19:    iload_1 
L20:    iload 4 
L22:    iload_2 
L23:    isub 
L24:    invokestatic [2] 
L27:    ifeq L41 
L30:    iload_0 
L31:    iload 4 
L33:    i2b 
L34:    invokestatic [3] 
L37:    istore_0 
L38:    goto L49 
L41:    iload_0 
L42:    iload 4 
L44:    i2b 
L45:    invokestatic [4] 
L48:    istore_0 
L49:    iinc 4 1 
L52:    goto L13 
L55:    iload_0 
L56:    areturn 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public static [47] : [48] 
    .attribute [34] .code stack 2 locals 0 
L0:     iload_0 
L1:     sipush 255 
L4:     iand 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [8] [9] 
.const [3] = Method [10] [11] 
.const [4] = Method [12] [13] 
.const [5] = Class [14] 
.const [6] = Class [15] 
.const [7] = Method [16] [17] 
.const [8] = Class [18] 
.const [9] = NameAndType [19] [20] 
.const [10] = Class [21] 
.const [11] = NameAndType [22] [23] 
.const [12] = Class [24] 
.const [13] = NameAndType [25] [26] 
.const [14] = Utf8 de/audi/atip/config/carcoding/BitHelper 
.const [15] = Utf8 java/lang/Object 
.const [16] = Class [27] 
.const [17] = NameAndType [28] [29] 
.const [18] = Utf8 de/audi/atip/config/carcoding/BitHelper 
.const [19] = Utf8 testBit 
.const [20] = Utf8 (BI)Z 
.const [21] = Utf8 de/audi/atip/config/carcoding/BitHelper 
.const [22] = Utf8 setBit 
.const [23] = Utf8 (BB)B 
.const [24] = Utf8 de/audi/atip/config/carcoding/BitHelper 
.const [25] = Utf8 clearBit 
.const [26] = Utf8 (BB)B 
.const [27] = Utf8 java/lang/Object 
.const [28] = Utf8 <init> 
.const [29] = Utf8 ()V 
.const [30] = Utf8 de/audi/atip/config/carcoding/BitHelper 
.const [31] = Class [30] 
.const [32] = Utf8 java/lang/Object 
.const [33] = Class [32] 
.const [34] = Utf8 Code 
.const [35] = Utf8 <init> 
.const [36] = Utf8 ()V 
.const [37] = Utf8 setBit 
.const [38] = Utf8 (BB)B 
.const [39] = Utf8 clearBit 
.const [40] = Utf8 (BB)B 
.const [41] = Utf8 testBit 
.const [42] = Utf8 (BI)Z 
.const [43] = Utf8 getBitsFromByte 
.const [44] = Utf8 (BII)B 
.const [45] = Utf8 setBitsInByte 
.const [46] = Utf8 (BBII)B 
.const [47] = Utf8 unsignedByteToInt 
.const [48] = Utf8 (B)I 
.end class 
