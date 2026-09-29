.version 50 0 
.class public super [51] 
.super [53] 
.field [54] [55] 

.method public [57] : [58] 
    .attribute [56] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [10] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [11] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public interface [59] : [60] 
    .attribute [56] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [5] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [61] : [62] 
    .attribute [56] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [6] 
L4:     invokevirtual [7] 
L7:     istore_1 
L8:     iload_1 
L9:     iflt L22 
L12:    aload_0 
L13:    dup 
L14:    getfield [5] 
L17:    iconst_1 
L18:    iadd 
L19:    putfield [11] 
L22:    iload_1 
L23:    areturn 
L24:    
    .end code 
.end method 

.method public [63] : [64] 
    .attribute [56] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [6] 
L4:     aload_1 
L5:     iload_2 
L6:     iload_3 
L7:     invokevirtual [8] 
L10:    istore 4 
L12:    iload 4 
L14:    iflt L28 
L17:    aload_0 
L18:    dup 
L19:    getfield [5] 
L22:    iload 4 
L24:    iadd 
L25:    putfield [11] 
L28:    iload 4 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [65] : [66] 
    .attribute [56] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [11] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [67] : [68] 
    .attribute [56] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [6] 
L4:     lload_1 
L5:     invokevirtual [9] 
L8:     lstore_3 
L9:     aload_0 
L10:    dup 
L11:    getfield [5] 
L14:    i2l 
L15:    lload_3 
L16:    ladd 
L17:    l2i 
L18:    putfield [11] 
L21:    lload_3 
L22:    freturn 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [12] 
.const [3] = Class [13] 
.const [4] = Class [14] 
.const [5] = Field [15] [16] 
.const [6] = Field [17] [18] 
.const [7] = Method [19] [20] 
.const [8] = Method [21] [22] 
.const [9] = Method [23] [24] 
.const [10] = Method [25] [26] 
.const [11] = Field [27] [28] 
.const [12] = Utf8 com/ibm/oti/util/PositionedInputStream 
.const [13] = Utf8 java/io/FilterInputStream 
.const [14] = Utf8 java/io/InputStream 
.const [15] = Class [29] 
.const [16] = NameAndType [30] [31] 
.const [17] = Class [32] 
.const [18] = NameAndType [33] [34] 
.const [19] = Class [35] 
.const [20] = NameAndType [36] [37] 
.const [21] = Class [38] 
.const [22] = NameAndType [39] [40] 
.const [23] = Class [41] 
.const [24] = NameAndType [42] [43] 
.const [25] = Class [44] 
.const [26] = NameAndType [45] [46] 
.const [27] = Class [47] 
.const [28] = NameAndType [48] [49] 
.const [29] = Utf8 com/ibm/oti/util/PositionedInputStream 
.const [30] = Utf8 currentPosition 
.const [31] = Utf8 I 
.const [32] = Utf8 com/ibm/oti/util/PositionedInputStream 
.const [33] = Utf8 in 
.const [34] = Utf8 Ljava/io/InputStream; 
.const [35] = Utf8 java/io/InputStream 
.const [36] = Utf8 read 
.const [37] = Utf8 ()I 
.const [38] = Utf8 java/io/InputStream 
.const [39] = Utf8 read 
.const [40] = Utf8 ([BII)I 
.const [41] = Utf8 java/io/InputStream 
.const [42] = Utf8 skip 
.const [43] = Utf8 (J)J 
.const [44] = Utf8 java/io/FilterInputStream 
.const [45] = Utf8 <init> 
.const [46] = Utf8 (Ljava/io/InputStream;)V 
.const [47] = Utf8 com/ibm/oti/util/PositionedInputStream 
.const [48] = Utf8 currentPosition 
.const [49] = Utf8 I 
.const [50] = Utf8 com/ibm/oti/util/PositionedInputStream 
.const [51] = Class [50] 
.const [52] = Utf8 java/io/FilterInputStream 
.const [53] = Class [52] 
.const [54] = Utf8 currentPosition 
.const [55] = Utf8 I 
.const [56] = Utf8 Code 
.const [57] = Utf8 <init> 
.const [58] = Utf8 (Ljava/io/InputStream;)V 
.const [59] = Utf8 currentPosition 
.const [60] = Utf8 ()I 
.const [61] = Utf8 read 
.const [62] = Utf8 ()I 
.const [63] = Utf8 read 
.const [64] = Utf8 ([BII)I 
.const [65] = Utf8 resetCurrentPosition 
.const [66] = Utf8 ()V 
.const [67] = Utf8 skip 
.const [68] = Utf8 (J)J 
.end class 
