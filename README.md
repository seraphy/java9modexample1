# java9のモジュールの実験例

## 概要

java9で
- jp.seraphyware.java9example1app
- jp.seraphyware.java9example1lib
の2つのモジュールを作成する.

java9example1libはLibインターフェイスのみexportsしており、
LibImpl.java実装クラスはエクスポートしていない.

また、LibImpl.javaは非推奨となったJAXBへの参照をもっているので、
java.xml.bindをrequiresしている.


これをjava9example1appモジュール側から参照する.


## 実行方法

```cmd
mvn clean package
```
で、 ```app\targets\mods``` 下に ビルドしたjarモジュールと依存jarを出力する。

これを
java9, 10 で以下のように実行する。

```cmd
java --module-path app\target\mods -m jp.seraphyware.java9example1app/jp.seraphyware.java9example1app.Main
```

## build.cmdとsetenv.cmdについて

```setenv.cmd``` で ```JAVA_HOME``` と ```MAVEN_HOME``` を設定して、
```build.cmd``` を実行することにより、上記の ```mvn``` と ```java``` の実行を行う。


## 既知の問題

現時点(2018/09/10)では、
Java11(rc版 build 11-ea+20)ではモジュールのレゾリューション(java.activationまわり)に失敗して動作しない。
