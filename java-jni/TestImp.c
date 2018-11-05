#include <jni.h>
#include "Test.h"
#include <stdio.h>

JNIEXPORT void JNICALL Java_Test_displayMessage(JNIEnv *env, jobject obj)
{
  printf("Testing 1 2 3...\n");

  return;
}
