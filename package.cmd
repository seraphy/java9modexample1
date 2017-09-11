call setenv.cmd
if exist lib rmdir /s /q lib
mkdir lib
jar --create --file=lib/jp.seraphyware.java9example1lib@1.0.jar --module-version=1.0 -C bin/jp.seraphyware.java9example1lib .
jar --create --file=lib/jp.seraphyware.java9example1app@1.0.jar --module-version=1.0 -C bin/jp.seraphyware.java9example1app .
if "%1" == "" pause
