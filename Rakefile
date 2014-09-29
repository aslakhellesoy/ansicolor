task :gem do
  sh 'mvn clean compile'
  sh 'javah -o src/main/c/WindowsConsole.h -jni ansicolor.windows.WindowsConsole'
  sh 'gcc -m64 -Wall -D_JNI_IMPLEMENTATION_ -I%JAVA_HOME%\include -I%JAVA_HOME%\include\win32 -Wl,--kill-at -shared src/main/c/WindowsConsole.c -o target/classes/ansicolor/windows/WindowsConsole64.dll'
  sh 'gcc -m32 -Wall -D_JNI_IMPLEMENTATION_ -I%JAVA_HOME%\include -I%JAVA_HOME%\include\win32 -Wl,--kill-at -shared src/main/c/WindowsConsole.c -o target/classes/ansicolor/windows/WindowsConsole.dll'
  sh 'mvn jar:jar'
  mv 'target/ansicolor-1.1.jar', 'lib'
  sh 'gem build ansicolor.gemspec'
end