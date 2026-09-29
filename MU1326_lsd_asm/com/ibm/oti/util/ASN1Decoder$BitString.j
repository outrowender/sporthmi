.version 50 0 
.class public super [37] 
.super [39] 
.field public [40] [41] 
.field public [42] [43] 

.method public [45] : [46] 
    .attribute [44] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [6] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [7] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [8] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [47] : [48] 
    .attribute [44] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [5] 
L4:     arraylength 
L5:     bipush 8 
L7:     imul 
L8:     aload_0 
L9:     getfield [4] 
L12:    isub 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [49] : [50] 
    .attribute [44] .code stack 3 locals 3 
L0:     iload_1 
L1:     bipush 8 
L3:     idiv 
L4:     istore_2 
L5:     aload_0 
L6:     getfield [5] 
L9:     iload_2 
L10:    baload 
L11:    sipush 255 
L14:    iand 
L15:    istore_3 
L16:    iload_1 
L17:    bipush 8 
L19:    irem 
L20:    istore 4 
L22:    iload_3 
L23:    bipush 7 
L25:    iload 4 
L27:    isub 
L28:    iushr 
L29:    iconst_1 
L30:    iand 
L31:    iconst_1 
L32:    if_icmpne L37 
L35:    iconst_1 
L36:    areturn 
L37:    iconst_0 
L38:    areturn 
L39:    nop 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [9] 
.const [3] = Class [10] 
.const [4] = Field [11] [12] 
.const [5] = Field [13] [14] 
.const [6] = Method [15] [16] 
.const [7] = Field [17] [18] 
.const [8] = Field [19] [20] 
.const [9] = Utf8 com/ibm/oti/util/ASN1Decoder$BitString 
.const [10] = Utf8 java/lang/Object 
.const [11] = Class [21] 
.const [12] = NameAndType [22] [23] 
.const [13] = Class [24] 
.const [14] = NameAndType [25] [26] 
.const [15] = Class [27] 
.const [16] = NameAndType [28] [29] 
.const [17] = Class [30] 
.const [18] = NameAndType [31] [32] 
.const [19] = Class [33] 
.const [20] = NameAndType [34] [35] 
.const [21] = Utf8 com/ibm/oti/util/ASN1Decoder$BitString 
.const [22] = Utf8 unusedBits 
.const [23] = Utf8 I 
.const [24] = Utf8 com/ibm/oti/util/ASN1Decoder$BitString 
.const [25] = Utf8 data 
.const [26] = Utf8 [B 
.const [27] = Utf8 java/lang/Object 
.const [28] = Utf8 <init> 
.const [29] = Utf8 ()V 
.const [30] = Utf8 com/ibm/oti/util/ASN1Decoder$BitString 
.const [31] = Utf8 unusedBits 
.const [32] = Utf8 I 
.const [33] = Utf8 com/ibm/oti/util/ASN1Decoder$BitString 
.const [34] = Utf8 data 
.const [35] = Utf8 [B 
.const [36] = Utf8 com/ibm/oti/util/ASN1Decoder$BitString 
.const [37] = Class [36] 
.const [38] = Utf8 java/lang/Object 
.const [39] = Class [38] 
.const [40] = Utf8 unusedBits 
.const [41] = Utf8 I 
.const [42] = Utf8 data 
.const [43] = Utf8 [B 
.const [44] = Utf8 Code 
.const [45] = Utf8 <init> 
.const [46] = Utf8 (I[B)V 
.const [47] = Utf8 bitLength 
.const [48] = Utf8 ()I 
.const [49] = Utf8 bitAt 
.const [50] = Utf8 (I)Z 
.end class 
