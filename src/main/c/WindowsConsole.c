#include <stdio.h>
#include <windows.h>
#include <jni.h>
#include "WindowsConsole.h"

JNIEXPORT void JNICALL Java_ansicolor_windows_WindowsConsole_setConsoleColor
(JNIEnv * env, jobject obj, jint color)
{
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), color);
}

JNIEXPORT jint JNICALL Java_ansicolor_windows_WindowsConsole_getConsoleColor
(JNIEnv * env, jobject obj)
{
	CONSOLE_SCREEN_BUFFER_INFO consoleInfo;
	GetConsoleScreenBufferInfo(GetStdHandle(STD_OUTPUT_HANDLE), &consoleInfo);
	return consoleInfo.wAttributes;
}
