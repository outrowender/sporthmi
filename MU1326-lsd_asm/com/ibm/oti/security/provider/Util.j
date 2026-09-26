.version 50 0 
.class public final super [11] 
.super [13] 

.method public annotation [15] : [16] 
    .attribute [14] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [3] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [17] : [18] 
    .attribute [14] .code stack 3 locals 1 
L0:     aload_0 
L1:     ifnull L15 
L4:     aload_1 
L5:     ifnull L15 
L8:     aload_0 
L9:     arraylength 
L10:    aload_1 
L11:    arraylength 
L12:    if_icmpeq L17 
L15:    iconst_0 
L16:    areturn 
L17:    iconst_0 
L18:    istore_2 
L19:    goto L36 
L22:    aload_0 
L23:    iload_2 
L24:    baload 
L25:    aload_1 
L26:    iload_2 
L27:    baload 
L28:    if_icmpeq L33 
L31:    iconst_0 
L32:    areturn 
L33:    iinc 2 1 
L36:    iload_2 
L37:    aload_0 
L38:    arraylength 
L39:    if_icmplt L22 
L42:    iconst_1 
L43:    areturn 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [4] 
.const [3] = Method [5] [6] 
.const [4] = Utf8 java/lang/Object 
.const [5] = Class [7] 
.const [6] = NameAndType [8] [9] 
.const [7] = Utf8 java/lang/Object 
.const [8] = Utf8 <init> 
.const [9] = Utf8 ()V 
.const [10] = Utf8 com/ibm/oti/security/provider/Util 
.const [11] = Class [10] 
.const [12] = Utf8 java/lang/Object 
.const [13] = Class [12] 
.const [14] = Utf8 Code 
.const [15] = Utf8 <init> 
.const [16] = Utf8 ()V 
.const [17] = Utf8 equals 
.const [18] = Utf8 ([B[B)Z 
.end class 
