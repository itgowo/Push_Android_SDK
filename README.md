# 一：简述

推送系统包含系统推送和用户推送两种，由底层socket框架区分，类型又包括数据推送和指令推送，目前暂合并制作，即做用户推送，既包含数据类也推送指令，指令推送多用于PC端，执行远程代码控制等操作，使用内存动态加载指令技术。


技术交流 QQ:1264957104

![image](https://github.com/hnsugar/Push_Android_SDK/blob/master/111.png)
![image](https://github.com/hnsugar/Push_Android_SDK/blob/master/222.png)
![image](https://github.com/hnsugar/Push_Android_SDK/blob/master/1111.gif)
![image](https://github.com/hnsugar/Push_Android_SDK/blob/master/222.gif)



# 二:Json格式定义
  
  
  
    {
    	"Type":	1,
    	"PushID":	"adfsdfsd",
    	"Time":	"推送时间 yy-mm-dd hh:tt.ss",
    	"Data":	
    	{
    		"icon":	"a",
    		"title":	"标题",
    		"content":	"文本信息",
    		"ticker":	"滚动文字",
    		"timemode":	"1",
    		"timelimit":	"120000",
    		"timestart":	"2016-6-5 23:55:50",
    		"timeend":	"2016-6-5 23:55:50",
    		"picUrl":	"图片地址",
    		"htmlUrl1":	"网页链接1",
    		"htmlUrl2":	"网页链接2",
    		"intent":	"Intent跳转Action",
    		"intentExtraString":	"id,123456;name,张三;pwd,433444",
    		"intentExtraInteger":	"index,552;length,552",
    		"intentExtraBoolean":	"isme,		true;check,		false;isgroup,		true",
    		"extraString":	"自定义数据"
    	}
    }
    
# 三:属性说明
默认所有类型属性都大于5，建议大于10，1在整个体系架构中代表成功，2代表失败，3代表其他

### 1：Type定义

Type值  | 定义说明
---|---
1 | 推送成功，向服务器发送push成功消息，必须包含Type和PushID属性         
2 | 推送失败，向服务器发送push失败消息，必须包含Type和PushID属性，用不到。。。。。
3 | 其他异常
4-10 | 保留
11 | 标准通知，声音震动以系统设置为准，有呼吸灯
12 | 静默推送，声音震动都不提醒，无呼吸灯
13 | 强制提醒，系统设置无效，声音震动都有
21 | 富文本通知_标准通知
22 | 富文本通知_静默推送
23 | 富文本通知_强制提醒
31 | 图片展示_标准通知
32 | 图片展示_静默推送
33 | 图片展示_强制提醒
41 | 跳转通知_标准通知
42 | 跳转通知_静默推送
43 | 跳转通知_强制提醒
51 | 系统指令_关闭


### 2：PushID
推送消息ID，可以告诉服务器推送成功

### 3：Time
推送发起时间，yy-mm-dd hh:tt.ss

### 4：Data
推送具体内容

### 4.1：icon
通知显示图标，默认为app图标

### 4.2：title
通知显示标题

### 4.3：content
通知显示文本

### 4.4：ticker
滚动字幕

### 4.5：timemode
展示模式，时间模式，1：不对时间处理，收到即通知；2：timelimit起作用，以当前时间计算显示时间段；3：timestart起多用；4：timeend起作用;5:timestart和timeend起作用

### 4.6：timelimit
单位毫秒，只在推送时间基础上加固定时间内会提醒

### 4.7：timestart
开始时间，通知只在开始时间后会提示 2016-6-5 23:55:50

### 4.8：timeend
截止时间 ，通知只在截止日期前会提示 2016-6-5 23:55:50

### 4.9：picUrl
图片地址，展示图片uri

### 4.10：htmlUrl1
网页链接1   uri等

### 4.11：htmlUrl2
网页链接2   uri等

### 4.12：intent
Intent跳转Action

### 4.13：intentExtraString
Intent携带String数据

### 4.14：intentExtraInteger
Intent携带integer数据

### 4.15：intentExtraBoolean
Intent携带boolean数据

### 4.16：extraString
自定义数据

# 3.常量
 
    .常量 Push_推送成功, "1", 公开, 推送成功，向服务器发送push成功消息，必须包含Type和PushID属性
    .常量 Push_推送失败, "2", 公开, 推送失败，向服务器发送push失败消息，必须包含Type和PushID属性，用不到。。。。。
    .常量 Push_其他异常, "3", 公开, 其他异常
    .常量 Push_保留, "4", 公开, 4-10 | 保留
    .常量 Push_标准通知, "11", 公开, 标准通知，声音震动以系统设置为准，有呼吸灯
    .常量 Push_静默推送, "12", 公开, 静默推送，声音震动都不提醒，无呼吸灯
    .常量 Push_强制提醒, "13", 公开, 强制提醒，系统设置无效，声音震动都有
    .常量 Push_富文本通知_标准通知, "21", 公开
    .常量 Push_富文本通知_静默推送, "22", 公开
    .常量 Push_富文本通知_强制提醒, "23", 公开
    .常量 Push_图片展示_标准通知, "31", 公开
    .常量 Push_图片展示_静默推送, "32", 公开
    .常量 Push_图片展示_强制提醒, "33", 公开
    .常量 Push_跳转通知_标准通知, "41", 公开
    .常量 Push_跳转通知_静默推送, "42", 公开
    .常量 Push_跳转通知_强制提醒, "43", 公开
    .常量 Push_时间模式_正常, "1", 公开, 不对时间处理，收到即通知
    .常量 Push_时间模式_限制, "2", 公开, timelimit起作用，以当前时间计算显示时间段
    .常量 Push_时间模式_开始, "3", 公开, timestart起作用
    .常量 Push_时间模式_截止, "4", 公开, timeend起作用
    .常量 Push_时间模式_区间, "5", 公开, timestart、timeend起作用

# 四：补充说明

#### 1.如果点击通知信息，执行回调，由开发人员决定何去何从

