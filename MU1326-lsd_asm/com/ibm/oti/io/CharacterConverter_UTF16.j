.version 50 0 
.class public super [31] 
.super [33] 

.method public annotation [35] : [36] 
    .attribute [34] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [6] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [37] : [38] 
    .attribute [34] .code stack 4 locals 5 
L0:     iload_3 
L1:     iconst_1 
L2:     ishl 
L3:     aload_0 
L4:     getfield [4] 
L7:     ifeq L14 
L10:    iconst_2 
L11:    goto L15 
L14:    iconst_0 
L15:    iadd 
L16:    istore 4 
L18:    iload 4 
L20:    newarray byte 
L22:    astore 5 
L24:    iconst_0 
L25:    istore 6 
L27:    aload_0 
L28:    getfield [4] 
L31:    ifeq L65 
L34:    aload 5 
L36:    iload 6 
L38:    iinc 6 1 
L41:    bipush -2 
L43:    bastore 
L44:    aload 5 
L46:    iload 6 
L48:    iinc 6 1 
L51:    iconst_m1 
L52:    bastore 
L53:    aload_0 
L54:    getfield [5] 
L57:    ifeq L65 
L60:    aload_0 
L61:    iconst_0 
L62:    putfield [7] 
L65:    iload_2 
L66:    iload_3 
L67:    iadd 
L68:    istore 7 
L70:    iload_2 
L71:    istore 8 
L73:    goto L108 
L76:    aload 5 
L78:    iload 6 
L80:    iinc 6 1 
L83:    aload_1 
L84:    iload 8 
L86:    caload 
L87:    bipush 8 
L89:    ishr 
L90:    i2b 
L91:    bastore 
L92:    aload 5 
L94:    iload 6 
L96:    iinc 6 1 
L99:    aload_1 
L100:   iload 8 
L102:   caload 
L103:   i2b 
L104:   bastore 
L105:   iinc 8 1 
L108:   iload 8 
L110:   iload 7 
L112:   if_icmplt L76 
L115:   aload 5 
L117:   areturn 
L118:   nop 
L119:   nop 
L120:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [8] 
.const [3] = Class [9] 
.const [4] = Field [10] [11] 
.const [5] = Field [12] [13] 
.const [6] = Method [14] [15] 
.const [7] = Field [16] [17] 
.const [8] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODE 
.const [9] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODELITTLE 
.const [10] = Class [18] 
.const [11] = NameAndType [19] [20] 
.const [12] = Class [21] 
.const [13] = NameAndType [22] [23] 
.const [14] = Class [24] 
.const [15] = NameAndType [25] [26] 
.const [16] = Class [27] 
.const [17] = NameAndType [28] [29] 
.const [18] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODELITTLE 
.const [19] = Utf8 writeTag 
.const [20] = Utf8 Z 
.const [21] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODELITTLE 
.const [22] = Utf8 isModal 
.const [23] = Utf8 Z 
.const [24] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODE 
.const [25] = Utf8 <init> 
.const [26] = Utf8 ()V 
.const [27] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODELITTLE 
.const [28] = Utf8 writeTag 
.const [29] = Utf8 Z 
.const [30] = Utf8 com/ibm/oti/io/CharacterConverter_UTF16 
.const [31] = Class [30] 
.const [32] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODE 
.const [33] = Class [32] 
.const [34] = Utf8 Code 
.const [35] = Utf8 <init> 
.const [36] = Utf8 ()V 
.const [37] = Utf8 convert 
.const [38] = Utf8 ([CII)[B 
.end class 
