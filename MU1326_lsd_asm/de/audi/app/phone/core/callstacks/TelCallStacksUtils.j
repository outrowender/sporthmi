.version 50 0 
.class public super [89] 
.super [91] 

.method public annotation [93] : [94] 
    .attribute [92] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [95] : [96] 
    .attribute [92] .code stack 4 locals 8 
L0:     aload_1 
L1:     ifnull L8 
L4:     aload_1 
L5:     goto L12 
L8:     iconst_0 
L9:     anewarray [2] 
L12:    astore_3 
L13:    aload_2 
L14:    ifnull L21 
L17:    aload_2 
L18:    goto L25 
L21:    iconst_0 
L22:    anewarray [2] 
L25:    astore 4 
L27:    aload_0 
L28:    ifnull L35 
L31:    aload_0 
L32:    goto L39 
L35:    iconst_0 
L36:    anewarray [2] 
L39:    astore 5 
L41:    aload_3 
L42:    arraylength 
L43:    aload 5 
L45:    arraylength 
L46:    iadd 
L47:    aload 4 
L49:    arraylength 
L50:    iadd 
L51:    anewarray [2] 
L54:    astore 6 
L56:    iconst_0 
L57:    istore 7 
L59:    iconst_0 
L60:    istore 8 
L62:    iconst_0 
L63:    istore 9 
L65:    iconst_0 
L66:    istore 10 
L68:    iload 10 
L70:    aload 6 
L72:    arraylength 
L73:    if_icmpge L149 
L76:    iload 7 
L78:    aload_3 
L79:    arraylength 
L80:    if_icmpge L98 
L83:    aload 6 
L85:    iload 10 
L87:    iinc 10 1 
L90:    aload_3 
L91:    iload 7 
L93:    iinc 7 1 
L96:    aaload 
L97:    aastore 
L98:    iload 8 
L100:   aload 4 
L102:   arraylength 
L103:   if_icmpge L122 
L106:   aload 6 
L108:   iload 10 
L110:   iinc 10 1 
L113:   aload 4 
L115:   iload 8 
L117:   iinc 8 1 
L120:   aaload 
L121:   aastore 
L122:   iload 9 
L124:   aload 5 
L126:   arraylength 
L127:   if_icmpge L68 
L130:   aload 6 
L132:   iload 10 
L134:   iinc 10 1 
L137:   aload 5 
L139:   iload 9 
L141:   iinc 9 1 
L144:   aaload 
L145:   aastore 
L146:   goto L68 
L149:   new [19] 
L152:   dup 
L153:   invokespecial [17] 
L156:   astore 10 
L158:   aload 6 
L160:   aload 10 
L162:   invokestatic [4] 
L165:   aload 6 
L167:   areturn 
L168:   
    .end code 
.end method 

.method public static [97] : [98] 
    .attribute [92] .code stack 1 locals 0 
L0:     aload_0 
L1:     ifnull L46 
L4:     aload_0 
L5:     invokevirtual [8] 
L8:     ifne L48 
L11:    aload_0 
L12:    invokevirtual [9] 
L15:    ifne L48 
L18:    aload_0 
L19:    invokevirtual [10] 
L22:    ifne L48 
L25:    aload_0 
L26:    invokevirtual [11] 
L29:    ifne L48 
L32:    aload_0 
L33:    invokevirtual [12] 
L36:    ifne L48 
L39:    aload_0 
L40:    invokevirtual [13] 
L43:    ifne L48 
L46:    iconst_0 
L47:    areturn 
L48:    iconst_1 
L49:    areturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [99] : [100] 
    .attribute [92] .code stack 8 locals 0 
L0:     new [20] 
L3:     dup 
L4:     aload_0 
L5:     invokevirtual [8] 
L8:     aload_0 
L9:     invokevirtual [9] 
L12:    iconst_1 
L13:    isub 
L14:    aload_0 
L15:    invokevirtual [10] 
L18:    aload_0 
L19:    invokevirtual [11] 
L22:    aload_0 
L23:    invokevirtual [12] 
L26:    aload_0 
L27:    invokevirtual [13] 
L30:    invokespecial [18] 
L33:    invokevirtual [14] 
L36:    areturn 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public static [101] : [102] 
    .attribute [92] .code stack 2 locals 2 
L0:     aload_0 
L1:     ifnull L36 
L4:     iconst_0 
L5:     istore_2 
L6:     iload_2 
L7:     aload_0 
L8:     arraylength 
L9:     if_icmpge L36 
L12:    aload_0 
L13:    iload_2 
L14:    aaload 
L15:    astore_3 
L16:    aload_3 
L17:    ifnull L30 
L20:    aload_3 
L21:    invokevirtual [15] 
L24:    iload_1 
L25:    if_icmpne L30 
L28:    aload_3 
L29:    areturn 
L30:    iinc 2 1 
L33:    goto L6 
L36:    aconst_null 
L37:    areturn 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [21] 
.const [3] = Class [22] 
.const [4] = Method [23] [24] 
.const [5] = Class [25] 
.const [6] = Class [26] 
.const [7] = Class [27] 
.const [8] = Method [28] [29] 
.const [9] = Method [30] [31] 
.const [10] = Method [32] [33] 
.const [11] = Method [34] [35] 
.const [12] = Method [36] [37] 
.const [13] = Method [38] [39] 
.const [14] = Method [40] [41] 
.const [15] = Method [42] [43] 
.const [16] = Method [44] [45] 
.const [17] = Method [46] [47] 
.const [18] = Method [48] [49] 
.const [19] = Class [50] 
.const [20] = Class [51] 
.const [21] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [22] = Utf8 de/audi/app/phone/core/callstacks/TelCallStacksUtils$1 
.const [23] = Class [52] 
.const [24] = NameAndType [53] [54] 
.const [25] = Utf8 java/util/GregorianCalendar 
.const [26] = Utf8 java/lang/Object 
.const [27] = Utf8 java/util/Arrays 
.const [28] = Class [55] 
.const [29] = NameAndType [56] [57] 
.const [30] = Class [58] 
.const [31] = NameAndType [59] [60] 
.const [32] = Class [61] 
.const [33] = NameAndType [62] [63] 
.const [34] = Class [64] 
.const [35] = NameAndType [65] [66] 
.const [36] = Class [67] 
.const [37] = NameAndType [68] [69] 
.const [38] = Class [70] 
.const [39] = NameAndType [71] [72] 
.const [40] = Class [73] 
.const [41] = NameAndType [74] [75] 
.const [42] = Class [76] 
.const [43] = NameAndType [77] [78] 
.const [44] = Class [79] 
.const [45] = NameAndType [80] [81] 
.const [46] = Class [82] 
.const [47] = NameAndType [83] [84] 
.const [48] = Class [85] 
.const [49] = NameAndType [86] [87] 
.const [50] = Utf8 de/audi/app/phone/core/callstacks/TelCallStacksUtils$1 
.const [51] = Utf8 java/util/GregorianCalendar 
.const [52] = Utf8 java/util/Arrays 
.const [53] = Utf8 sort 
.const [54] = Utf8 ([Ljava/lang/Object;Ljava/util/Comparator;)V 
.const [55] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [56] = Utf8 getClYear 
.const [57] = Utf8 ()S 
.const [58] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [59] = Utf8 getClMonth 
.const [60] = Utf8 ()S 
.const [61] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [62] = Utf8 getClDay 
.const [63] = Utf8 ()S 
.const [64] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [65] = Utf8 getClHour 
.const [66] = Utf8 ()S 
.const [67] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [68] = Utf8 getClMinute 
.const [69] = Utf8 ()S 
.const [70] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [71] = Utf8 getClSecond 
.const [72] = Utf8 ()S 
.const [73] = Utf8 java/util/GregorianCalendar 
.const [74] = Utf8 getTime 
.const [75] = Utf8 ()Ljava/util/Date; 
.const [76] = Utf8 org/dsi/ifc/telephoneng/CallStackEntry 
.const [77] = Utf8 getClEntryID 
.const [78] = Utf8 ()I 
.const [79] = Utf8 java/lang/Object 
.const [80] = Utf8 <init> 
.const [81] = Utf8 ()V 
.const [82] = Utf8 de/audi/app/phone/core/callstacks/TelCallStacksUtils$1 
.const [83] = Utf8 <init> 
.const [84] = Utf8 ()V 
.const [85] = Utf8 java/util/GregorianCalendar 
.const [86] = Utf8 <init> 
.const [87] = Utf8 (IIIIII)V 
.const [88] = Utf8 de/audi/app/phone/core/callstacks/TelCallStacksUtils 
.const [89] = Class [88] 
.const [90] = Utf8 java/lang/Object 
.const [91] = Class [90] 
.const [92] = Utf8 Code 
.const [93] = Utf8 <init> 
.const [94] = Utf8 ()V 
.const [95] = Utf8 createCombinedCallStack 
.const [96] = Utf8 ([Lorg/dsi/ifc/telephoneng/CallStackEntry;[Lorg/dsi/ifc/telephoneng/CallStackEntry;[Lorg/dsi/ifc/telephoneng/CallStackEntry;)[Lorg/dsi/ifc/telephoneng/CallStackEntry; 
.const [97] = Utf8 hasValidTimestamp 
.const [98] = Utf8 (Lorg/dsi/ifc/telephoneng/CallStackEntry;)Z 
.const [99] = Utf8 getDate 
.const [100] = Utf8 (Lorg/dsi/ifc/telephoneng/CallStackEntry;)Ljava/util/Date; 
.const [101] = Utf8 getCallStackEntry 
.const [102] = Utf8 ([Lorg/dsi/ifc/telephoneng/CallStackEntry;I)Lorg/dsi/ifc/telephoneng/CallStackEntry; 
.end class 
