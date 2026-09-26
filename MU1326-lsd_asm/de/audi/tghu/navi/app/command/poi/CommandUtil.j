.version 50 0 
.class public super [27] 
.super [29] 

.method public annotation [31] : [32] 
    .attribute [30] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [7] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [33] : [34] 
    .attribute [30] .code stack 2 locals 3 
L0:     iconst_m1 
L1:     istore_2 
L2:     aload_1 
L3:     ifnull L51 
L6:     aload_1 
L7:     invokevirtual [5] 
L10:    ifnull L51 
L13:    aload_1 
L14:    invokevirtual [5] 
L17:    astore_3 
L18:    iconst_0 
L19:    istore 4 
L21:    iload 4 
L23:    aload_3 
L24:    arraylength 
L25:    if_icmpge L51 
L28:    aload_3 
L29:    iload 4 
L31:    aaload 
L32:    getfield [6] 
L35:    iload_0 
L36:    if_icmpne L45 
L39:    iload 4 
L41:    istore_2 
L42:    goto L51 
L45:    iinc 4 1 
L48:    goto L21 
L51:    iload_2 
L52:    areturn 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [8] 
.const [3] = Class [9] 
.const [4] = Class [10] 
.const [5] = Method [11] [12] 
.const [6] = Field [13] [14] 
.const [7] = Method [15] [16] 
.const [8] = Utf8 java/lang/Object 
.const [9] = Utf8 org/dsi/ifc/navigation/LIValueList 
.const [10] = Utf8 org/dsi/ifc/navigation/LIValueListElement 
.const [11] = Class [17] 
.const [12] = NameAndType [18] [19] 
.const [13] = Class [20] 
.const [14] = NameAndType [21] [22] 
.const [15] = Class [23] 
.const [16] = NameAndType [24] [25] 
.const [17] = Utf8 org/dsi/ifc/navigation/LIValueList 
.const [18] = Utf8 getList 
.const [19] = Utf8 ()[Lorg/dsi/ifc/navigation/LIValueListElement; 
.const [20] = Utf8 org/dsi/ifc/navigation/LIValueListElement 
.const [21] = Utf8 criteriaNumber 
.const [22] = Utf8 I 
.const [23] = Utf8 java/lang/Object 
.const [24] = Utf8 <init> 
.const [25] = Utf8 ()V 
.const [26] = Utf8 de/audi/tghu/navi/app/command/poi/CommandUtil 
.const [27] = Class [26] 
.const [28] = Utf8 java/lang/Object 
.const [29] = Class [28] 
.const [30] = Utf8 Code 
.const [31] = Utf8 <init> 
.const [32] = Utf8 ()V 
.const [33] = Utf8 getIndexForCriteria 
.const [34] = Utf8 (ILorg/dsi/ifc/navigation/LIValueList;)I 
.end class 
