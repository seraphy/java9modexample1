call setenv.cmd
if exist bin rmdir /s /q bin
call mvn clean package
java --module-path app\target\mods -m jp.seraphyware.java9example1app/jp.seraphyware.java9example1app.Main
if "%1" == "" pause
