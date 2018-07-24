# 广播

应用间具有延时性,应用内速度尽快也比较安全(避免别人乱发给你的广播).两种互不影响.

## 应用间广播

参见android基础

## 应用内广播:LocalBroadCastManager

虽然LocalBroadcastManager也通过BroadcastReceiver来接收消息,但是他们两个之间还是有很多区别的。

* LocalBroadcastManager注册广播只能通过代码注册的方式。传统的广播可以通过代码和xml两种方式注册。
* LocalBroadcastManager注册广播后，一定要记得取消监听。这一步可以有效的解决内存泄漏的问题。
* LocalBroadcastManager注册的广播，您在发送广播的时候务必使用LocalBroadcastManager.sendBroadcast(intent); 否则您接收不到广播。传统的发送广播的方法：context.sendBroadcast( intent );