.version 50 0 
.class public super [13] 
.super [15] 
.implements [17] 

.method public annotation [19] : [20] 
    .attribute [18] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [4] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [21] : [22] 
    .attribute [18] .code stack 3 locals 4 
L0:     aload_1 
L1:     ifnonnull L10 
L4:     aload_2 
L5:     ifnonnull L10 
L8:     iconst_0 
L9:     areturn 
L10:    aload_1 
L11:    ifnonnull L16 
L14:    iconst_m1 
L15:    areturn 
L16:    aload_2 
L17:    ifnonnull L22 
L20:    iconst_1 
L21:    areturn 
L22:    aload_1 
L23:    checkcast [2] 
L26:    checkcast [2] 
L29:    astore_3 
L30:    aload_2 
L31:    checkcast [2] 
L34:    checkcast [2] 
L37:    astore 4 
L39:    aload_3 
L40:    arraylength 
L41:    aload 4 
L43:    arraylength 
L44:    if_icmpge L52 
L47:    aload_3 
L48:    arraylength 
L49:    goto L55 
L52:    aload 4 
L54:    arraylength 
L55:    istore 5 
L57:    iconst_0 
L58:    istore 6 
L60:    iload 6 
L62:    iload 5 
L64:    if_icmpge L101 
L67:    aload_3 
L68:    iload 6 
L70:    iaload 
L71:    aload 4 
L73:    iload 6 
L75:    iaload 
L76:    if_icmpge L81 
L79:    iconst_m1 
L80:    areturn 
L81:    aload_3 
L82:    iload 6 
L84:    iaload 
L85:    aload 4 
L87:    iload 6 
L89:    iaload 
L90:    if_icmple L95 
L93:    iconst_1 
L94:    areturn 
L95:    iinc 6 1 
L98:    goto L60 
L101:   aload_3 
L102:   arraylength 
L103:   aload 4 
L105:   arraylength 
L106:   if_icmpge L111 
L109:   iconst_m1 
L110:   areturn 
L111:   aload_3 
L112:   arraylength 
L113:   aload 4 
L115:   arraylength 
L116:   if_icmple L121 
L119:   iconst_1 
L120:   areturn 
L121:   iconst_0 
L122:   areturn 
L123:   nop 
L124:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [5] 
.const [3] = Class [6] 
.const [4] = Method [7] [8] 
.const [5] = Utf8 [I 
.const [6] = Utf8 java/lang/Object 
.const [7] = Class [9] 
.const [8] = NameAndType [10] [11] 
.const [9] = Utf8 java/lang/Object 
.const [10] = Utf8 <init> 
.const [11] = Utf8 ()V 
.const [12] = Utf8 de/esolutions/hmi/widgets/audi/base/WidgetPersistenceComparator 
.const [13] = Class [12] 
.const [14] = Utf8 java/lang/Object 
.const [15] = Class [14] 
.const [16] = Utf8 java/util/Comparator 
.const [17] = Class [16] 
.const [18] = Utf8 Code 
.const [19] = Utf8 <init> 
.const [20] = Utf8 ()V 
.const [21] = Utf8 compare 
.const [22] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)I 
.end class 
