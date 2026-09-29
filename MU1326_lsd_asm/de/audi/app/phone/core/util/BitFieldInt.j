.version 50 0 
.class public super [25] 
.super [27] 
.field private [28] [29] 

.method public annotation [31] : [32] 
    .attribute [30] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [5] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [33] : [34] 
    .attribute [30] .code stack 4 locals 0 
L0:     aload_0 
L1:     dup 
L2:     getfield [4] 
L5:     iconst_1 
L6:     iload_1 
L7:     ishl 
L8:     ior 
L9:     putfield [6] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [35] : [36] 
    .attribute [30] .code stack 4 locals 0 
L0:     aload_0 
L1:     dup 
L2:     getfield [4] 
L5:     iconst_1 
L6:     iload_1 
L7:     ishl 
L8:     iconst_m1 
L9:     ixor 
L10:    iand 
L11:    putfield [6] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [37] : [38] 
    .attribute [30] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [4] 
L4:     iconst_1 
L5:     iload_1 
L6:     ishl 
L7:     iand 
L8:     ifeq L15 
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

.method public [39] : [40] 
    .attribute [30] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [6] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [41] : [42] 
    .attribute [30] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [4] 
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

.method public interface [43] : [44] 
    .attribute [30] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [4] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [7] 
.const [3] = Class [8] 
.const [4] = Field [9] [10] 
.const [5] = Method [11] [12] 
.const [6] = Field [13] [14] 
.const [7] = Utf8 de/audi/app/phone/core/util/BitFieldInt 
.const [8] = Utf8 java/lang/Object 
.const [9] = Class [15] 
.const [10] = NameAndType [16] [17] 
.const [11] = Class [18] 
.const [12] = NameAndType [19] [20] 
.const [13] = Class [21] 
.const [14] = NameAndType [22] [23] 
.const [15] = Utf8 de/audi/app/phone/core/util/BitFieldInt 
.const [16] = Utf8 bitfield 
.const [17] = Utf8 I 
.const [18] = Utf8 java/lang/Object 
.const [19] = Utf8 <init> 
.const [20] = Utf8 ()V 
.const [21] = Utf8 de/audi/app/phone/core/util/BitFieldInt 
.const [22] = Utf8 bitfield 
.const [23] = Utf8 I 
.const [24] = Utf8 de/audi/app/phone/core/util/BitFieldInt 
.const [25] = Class [24] 
.const [26] = Utf8 java/lang/Object 
.const [27] = Class [26] 
.const [28] = Utf8 bitfield 
.const [29] = Utf8 I 
.const [30] = Utf8 Code 
.const [31] = Utf8 <init> 
.const [32] = Utf8 ()V 
.const [33] = Utf8 setBit 
.const [34] = Utf8 (I)V 
.const [35] = Utf8 clearBit 
.const [36] = Utf8 (I)V 
.const [37] = Utf8 isBitSet 
.const [38] = Utf8 (I)Z 
.const [39] = Utf8 clearAllBits 
.const [40] = Utf8 ()V 
.const [41] = Utf8 areAllBitsCleared 
.const [42] = Utf8 ()Z 
.const [43] = Utf8 getAllBits 
.const [44] = Utf8 ()I 
.end class 
