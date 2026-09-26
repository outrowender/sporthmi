.version 50 0 
.class public super [35] 
.super [37] 
.implements [39] 
.field protected final [40] [41] 
.field protected [42] [43] 

.method public [45] : [46] 
    .attribute [44] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [6] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [8] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [47] : [48] 
    .attribute [44] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [5] 
L4:     arraylength 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [49] : [50] 
    .attribute [44] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore_2 
L2:     iload_2 
L3:     aload_0 
L4:     getfield [5] 
L7:     arraylength 
L8:     if_icmpge L29 
L11:    aload_0 
L12:    getfield [5] 
L15:    iload_2 
L16:    baload 
L17:    iload_1 
L18:    if_icmpne L23 
L21:    iconst_1 
L22:    areturn 
L23:    iinc 2 1 
L26:    goto L2 
L29:    iconst_0 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [51] : [52] 
    .attribute [44] .code stack 4 locals 0 
L0:     iload_1 
L1:     iflt L15 
L4:     iload_1 
L5:     aload_0 
L6:     getfield [5] 
L9:     arraylength 
L10:    iconst_1 
L11:    isub 
L12:    if_icmple L25 
L15:    new [9] 
L18:    dup 
L19:    iconst_2 
L20:    aconst_null 
L21:    invokespecial [7] 
L24:    athrow 
L25:    aload_0 
L26:    getfield [5] 
L29:    iload_1 
L30:    baload 
L31:    areturn 
L32:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [10] 
.const [3] = Class [11] 
.const [4] = Class [12] 
.const [5] = Field [13] [14] 
.const [6] = Method [15] [16] 
.const [7] = Method [17] [18] 
.const [8] = Field [19] [20] 
.const [9] = Class [21] 
.const [10] = Utf8 org/apache/xerces/xs/XSException 
.const [11] = Utf8 org/apache/xerces/impl/dv/util/ByteListImpl 
.const [12] = Utf8 java/lang/Object 
.const [13] = Class [22] 
.const [14] = NameAndType [23] [24] 
.const [15] = Class [25] 
.const [16] = NameAndType [26] [27] 
.const [17] = Class [28] 
.const [18] = NameAndType [29] [30] 
.const [19] = Class [31] 
.const [20] = NameAndType [32] [33] 
.const [21] = Utf8 org/apache/xerces/xs/XSException 
.const [22] = Utf8 org/apache/xerces/impl/dv/util/ByteListImpl 
.const [23] = Utf8 data 
.const [24] = Utf8 [B 
.const [25] = Utf8 java/lang/Object 
.const [26] = Utf8 <init> 
.const [27] = Utf8 ()V 
.const [28] = Utf8 org/apache/xerces/xs/XSException 
.const [29] = Utf8 <init> 
.const [30] = Utf8 (SLjava/lang/String;)V 
.const [31] = Utf8 org/apache/xerces/impl/dv/util/ByteListImpl 
.const [32] = Utf8 data 
.const [33] = Utf8 [B 
.const [34] = Utf8 org/apache/xerces/impl/dv/util/ByteListImpl 
.const [35] = Class [34] 
.const [36] = Utf8 java/lang/Object 
.const [37] = Class [36] 
.const [38] = Utf8 org/apache/xerces/xs/datatypes/ByteList 
.const [39] = Class [38] 
.const [40] = Utf8 data 
.const [41] = Utf8 [B 
.const [42] = Utf8 canonical 
.const [43] = Utf8 Ljava/lang/String; 
.const [44] = Utf8 Code 
.const [45] = Utf8 <init> 
.const [46] = Utf8 ([B)V 
.const [47] = Utf8 getLength 
.const [48] = Utf8 ()I 
.const [49] = Utf8 contains 
.const [50] = Utf8 (B)Z 
.const [51] = Utf8 item 
.const [52] = Utf8 (I)B 
.end class 
