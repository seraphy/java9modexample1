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

- build.cmd でモジュールごとにビルドを行う.
- run.cmd でビルドされたモジュールを実行する.

- pacage.cmd でビルドされたモジュールを、モジュールごとにjarファイルにまとめる.
- runPackage.cmd でjarに格納されたモジュールを参照してモジュールを実行する.
