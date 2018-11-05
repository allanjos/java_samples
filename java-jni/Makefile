JAVA_DIR=/c/Program\ Files/Java/jdk1.8.0_172

all:
	@echo
	@echo "Compiling Java source"

	${JAVA_DIR}/bin/javac.exe Test.java

	@echo
	@echo "Generating header file"

	${JAVA_DIR}/bin/javah.exe -jni Test

	@echo
	@echo "Creating DLL file"

	gcc -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -I ${JAVA_DIR}/include -I ${JAVA_DIR}/include/win32 -shared -o test.dll TestImp.c

	@echo
	@echo "Executing..."

	${JAVA_DIR}/bin/java.exe Test

clean:
	rm -f Test.class
	rm -f Test.h
	rm -f test.dll
