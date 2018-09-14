cd /d %~dp0
call setenv.cmd
call mvn clean package
rem java --module-path app\target\mods -m jp.seraphyware.java9example1app/jp.seraphyware.java9example1app.Main
java --module-path app\target\mods -m jp.seraphyware.java9example1app
if "%1" == "" pause
