cd /d %~dp0
call setenv.cmd
call mvn clean package
java --module-path app\target\mods -m jp.seraphyware.java9example1app/jp.seraphyware.java9example1app.Main
if "%1" == "" pause
