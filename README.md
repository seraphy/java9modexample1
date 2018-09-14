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


## 注意点

Java11(rc版 build 11-ea+20)ではモジュールのレゾリューションが、より厳格となっているようである。

JAXBを動作させるためには、以下のモジュールをインポートすれば良い。

- javax.xml.bind:jaxb-api:2.3.0
- com.sun.xml.bind:jaxb-core:2.3.0
- com.sun.activation:javax.activation:1.2.0

以下は上記モジュール内に含まれるパッケージを重複してエクスポートするものとしてresolutionに失敗するため、**含めてはならない**。

- com.sun.xml.bind:jaxb-impl:2.3.0
- javax.xml.bind:activation:1.0.2


これらを含めると、java11では実行時に以下のようなエラーになる。

```
java.lang.module.ResolutionException: Modules java.activation and activation export package com.sun.activation.registries to module java.xml.bind
```

※ 2つのモジュール（java.activationとactivation-b）に同じパッケージ（com.sun.activation.registries）が含まれていることを示す。
(どちらか一方を削除する必要がある。)


## モジュールのメインクラスとバージョン属性の指定

現時点(maven-jar-plugin:3.1.0)では、module-info.javaに対する、module-main-class, module-version属性を付与することができないので、
java9以降のjarコマンドを直接使用して属性を更新させている。

pom.xml では ```maven-antrun-plugin``` を使って ```jar```　コマンドを呼び出している。

これにより

```shell
java -p app\target\mods -m jp.seraphyware.java9example1app
```

のように、モジュール名を指定するだけでメインクラスを実行できるようになる。

また、これらの属性情報は、

```shell
jar --describe-module --file=app\target\mods\java9moduleexampleapp-1.0-SNAPSHOT.jar
```

で確認することができる。

