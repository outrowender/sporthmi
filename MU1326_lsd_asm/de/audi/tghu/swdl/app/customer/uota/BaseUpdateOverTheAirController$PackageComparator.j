.version 50 0 
.class super [53] 
.super [55] 
.implements [57] 
.field private final synthetic [58] [59] 

.method [61] : [62] 
    .attribute [60] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [12] 
L5:     aload_0 
L6:     invokespecial [11] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [63] : [64] 
    .attribute [60] .code stack 2 locals 0 
L0:     iload_1 
L1:     sipush 1000 
L4:     if_icmplt L18 
L7:     iload_1 
L8:     sipush 2000 
L11:    if_icmpgt L18 
L14:    iconst_1 
L15:    goto L19 
L18:    iconst_0 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public [65] : [66] 
    .attribute [60] .code stack 2 locals 4 
L0:     aload_1 
L1:     instanceof [2] 
L4:     ifeq L143 
L7:     aload_2 
L8:     instanceof [2] 
L11:    ifeq L143 
L14:    aload_1 
L15:    checkcast [2] 
L18:    astore_3 
L19:    aload_2 
L20:    checkcast [2] 
L23:    astore 4 
L25:    aload_0 
L26:    aload_3 
L27:    invokevirtual [6] 
L30:    invokevirtual [7] 
L33:    istore 5 
L35:    aload_0 
L36:    aload 4 
L38:    invokevirtual [6] 
L41:    invokevirtual [7] 
L44:    istore 6 
L46:    aload_3 
L47:    invokevirtual [6] 
L50:    aload 4 
L52:    invokevirtual [6] 
L55:    if_icmpne L96 
L58:    aload_3 
L59:    invokevirtual [8] 
L62:    aload 4 
L64:    invokevirtual [8] 
L67:    if_acmpne L83 
L70:    aload_3 
L71:    invokevirtual [9] 
L74:    aload 4 
L76:    invokevirtual [9] 
L79:    invokevirtual [10] 
L82:    areturn 
L83:    aload 4 
L85:    invokevirtual [8] 
L88:    aload_3 
L89:    invokevirtual [8] 
L92:    invokevirtual [10] 
L95:    areturn 
L96:    iload 5 
L98:    ifeq L108 
L101:   iload 6 
L103:   ifne L108 
L106:   iconst_m1 
L107:   areturn 
L108:   iload 5 
L110:   ifne L120 
L113:   iload 6 
L115:   ifeq L120 
L118:   iconst_1 
L119:   areturn 
L120:   aload_3 
L121:   invokevirtual [6] 
L124:   aload 4 
L126:   invokevirtual [6] 
L129:   if_icmpge L141 
L132:   aload_3 
L133:   invokevirtual [6] 
L136:   ifle L141 
L139:   iconst_m1 
L140:   areturn 
L141:   iconst_1 
L142:   areturn 
L143:   aload_1 
L144:   instanceof [2] 
L147:   ifeq L154 
L150:   iconst_1 
L151:   goto L155 
L154:   iconst_0 
L155:   areturn 
L156:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [13] 
.const [3] = Class [14] 
.const [4] = Class [15] 
.const [5] = Class [16] 
.const [6] = Method [17] [18] 
.const [7] = Method [19] [20] 
.const [8] = Method [21] [22] 
.const [9] = Method [23] [24] 
.const [10] = Method [25] [26] 
.const [11] = Method [27] [28] 
.const [12] = Field [29] [30] 
.const [13] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper 
.const [14] = Utf8 de/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController$PackageComparator 
.const [15] = Utf8 java/lang/Object 
.const [16] = Utf8 java/lang/String 
.const [17] = Class [31] 
.const [18] = NameAndType [32] [33] 
.const [19] = Class [34] 
.const [20] = NameAndType [35] [36] 
.const [21] = Class [37] 
.const [22] = NameAndType [38] [39] 
.const [23] = Class [40] 
.const [24] = NameAndType [41] [42] 
.const [25] = Class [43] 
.const [26] = NameAndType [44] [45] 
.const [27] = Class [46] 
.const [28] = NameAndType [47] [48] 
.const [29] = Class [49] 
.const [30] = NameAndType [50] [51] 
.const [31] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper 
.const [32] = Utf8 getPriority 
.const [33] = Utf8 ()I 
.const [34] = Utf8 de/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController$PackageComparator 
.const [35] = Utf8 isSysProposalPriority 
.const [36] = Utf8 (I)Z 
.const [37] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper 
.const [38] = Utf8 getReleaseVersion 
.const [39] = Utf8 ()Ljava/lang/String; 
.const [40] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper 
.const [41] = Utf8 getLastName 
.const [42] = Utf8 ()Ljava/lang/String; 
.const [43] = Utf8 java/lang/String 
.const [44] = Utf8 compareTo 
.const [45] = Utf8 (Ljava/lang/String;)I 
.const [46] = Utf8 java/lang/Object 
.const [47] = Utf8 <init> 
.const [48] = Utf8 ()V 
.const [49] = Utf8 de/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController$PackageComparator 
.const [50] = Utf8 this$0 
.const [51] = Utf8 Lde/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController; 
.const [52] = Utf8 de/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController$PackageComparator 
.const [53] = Class [52] 
.const [54] = Utf8 java/lang/Object 
.const [55] = Class [54] 
.const [56] = Utf8 java/util/Comparator 
.const [57] = Class [56] 
.const [58] = Utf8 this$0 
.const [59] = Utf8 Lde/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController; 
.const [60] = Utf8 Code 
.const [61] = Utf8 <init> 
.const [62] = Utf8 (Lde/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController;)V 
.const [63] = Utf8 isSysProposalPriority 
.const [64] = Utf8 (I)Z 
.const [65] = Utf8 compare 
.const [66] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)I 
.end class 
