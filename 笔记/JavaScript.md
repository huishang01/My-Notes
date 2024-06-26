# JavaScript 基础

### 介绍

#### 引入方式

**内联式：**通过 `<script>` 标签包裹 JavaScript 代码

```html
<body>
  <script>
    alert('Hello,world')
  </script>
</body>
```

**外联式：**独立的 .js 文件，通过 `<script> `标签的 `src` 属性导入

```html
<body>
  <script src="demo.js"></script>
</body>
```

>   如果 `<script>` 标签使用 `src` 属性引入了 .js 文件，那么 `<script>` 标签内的代码会被忽略

#### 注释 和 结束符

**单行注释：**`//` ，快捷键：`Ctrl + /`

**多行注释：**`/* */` ，快捷键：`Ctrl + Shift + /`

**结束符：**`;` ，可使用回车替代，可省略不写

#### 输入 和 输出

**弹窗输出：**`alert()`

**网页内输出：**`document.wirte()`

**控制台输出：**`console.log()`

**弹窗输入：**`prompt()`

#### 声明变量并赋值

`声明关键字 变量名 = 值`

**声明关键字：**`let` 和 `var`

|                      let                      |            var             |
| :-------------------------------------------: | :------------------------: |
|            允许声明和赋值同时进行             |   允许声明和赋值同时进行   |
|                不允许重复声明                 |        允许重复声明        |
|          允许同时声明多个变量并赋值           | 允许同时声明多个变量并赋值 |
| JavaScript 中内置的一些关键字不能被当做变量名 |             --             |

#### 变量名命名规则

-   只能是字母、数字、`_` 、`$` ，且不能能数字开头
-   字母区分大小写
-   不能与关键字相同
-   见字知义

#### 常量

使用 `const` 声明的变量称为“常量”

**注意：**常量不允许重新赋值，声明的时候必须赋值（初始化）

#### 数据类型

**数值：**整数、小数、正数、负数

>   通过 `typeof` 关键字检测数据类型

**字符串( String )：**通过单引号 `''` 、双引号 `""` 或反引号包裹的数据都叫字符串

>   必要时可以使用转义符 `\` ，输出单引号或双引号

**布尔：**表示肯定的数据用 `true`，表示否定的数据用 `false`

**未定义 ( undefined )：** 是比较特殊的类型，只有一个值 `undefined` ，只声明变量，不赋值的情况下，变量的默认值为 `undefined`，一般很少 *直接* 为某个变量赋值为 `undefined`

**显式类型转换：**通过 `Number` 显示转换成数值类型，当转换失败时结果为 `NaN`（Not a Number）即不是一个数字

```javascript
let str = '114514'
let num = 1919810
let str2 = 'helloworld'

str = Number(str)	// 显式转换 字符串'12'转换为数值 12
console.log(typeof str)	// 检测数据类型结果为 number
console.log(Number(str2))	// 显式转换 字符串'helloworld' 转换为数值，结果为 NaN
```

### 运算符

#### 算术运算符：

#### 	`+ , - , * , / , %`

在计算失败时，显示的结果是 `NaN`

#### 赋值运算符

`+= , -= , *= , /= , %=`

#### 自增自减运算符

| 符号 | 作用 | 说明            |
| :--: | :--: | :-------------- |
| `++` | 自增 | 变量自身的值加1 |
| `--` | 自减 | 变量自身的值减1 |

#### 比较运算符

`, < , >= , <= , === (是否类型和值都相等) , ==, != , !==`

比较两个数据大小、是否相等，根据比较结果返回一个布尔值

#### 逻辑运算符

| 符号 | 名称   | 日常读法 | 特点                       | 口诀     |
| ---- | ------ | -------- | -------------------------- | -------- |
| &&   | 逻辑与 | 并且     | 符号两边有一个假的结果为假 | 一假则假 |
| \|\| | 逻辑或 | 或者     | 符号两边有一个真的结果为真 | 一真则真 |
| !    | 逻辑非 | 取反     | true变false  false变true   |          |

| A     | B     | A && B | A \|\| B | !A    |
| ----- | ----- | ------ | -------- | ----- |
| false | false | false  | false    | true  |
| false | true  | false  | true     | true  |
| true  | false | false  | true     | false |
| true  | true  | true   | true     | false |

#### 运算符优先级

| 优先级 | 运算符                                                  |  结合性  |
| :----: | :------------------------------------------------------ | :------: |
|   1    | `()  []  .`                                             | 从左到右 |
|   2    | `!  ~  ++  --`                                          | 从右向左 |
|   3    | `*  /  %`                                               | 从左到右 |
|   4    | `+  -`                                                  | 从左到右 |
|   5    | `<<  >>  >>>`                                           | 从左到右 |
|   6    | `<  <=  >  >=  instanceof`                              | 从左到右 |
|   7    | `===  ==  !=`                                           | 从左到右 |
|   8    | `&`                                                     | 从左到右 |
|   9    | `^`                                                     | 从左到右 |
|   10   | `|`                                                     | 从左到右 |
|   11   | `&&`                                                    | 从左到右 |
|   12   | `||`                                                    | 从左到右 |
|   13   | `?  :`                                                  | 从左到右 |
|   14   | `=  +=  -=  *=  /=  %=  &=  |=  ^=  ~=  <<=  >>=  >>>=` | 从右向左 |
|   15   | `,`                                                     | 从右向左 |

**逻辑运算符优先级：** `!` > `&&` >  `||`  

### 流程控制语句

#### if 分支语句

```javascript
if (条件表达式) {
	执行语句1;
} else if (条件表达式) {
    执行语句2;
} else {
    执行语句3;
}
```

#### 三元运算符

```javascript
条件表达式 ? 表达式1 : 表达式2;
```

#### switch 语句

```javascript
switch ( 表达式 ) {		// 表达式 : 将要匹配的值
	case 值 1,			// case : 被匹配的值，不重复且必须为常量
		语句体 1;
		break;			// break : 结束 switch 语句
	case 值 2,			// default: 若 case 都不匹配，则执行
		语句体 2;
 		break;
	...
	default:
		语句体 n + 1;
		break;
}
```

#### 断点调试

**断点：**在某句代码上加的标记就叫断点，当程序执行到这句有标记的代码时会暂停下来

浏览器打开调试界面

1. 按F12打开开发者工具
2. 点到源代码一栏 （ sources ）
3. 选择代码文件

#### 无限循环

`while(true)`

`for( ; ; )`

`break` 中止整个循环

`continue` 中止本次循环

#### while 循环

```javascript
while (条件表达式) {
	执行语句;
	条件控制语句;
}
```

#### for 循环

