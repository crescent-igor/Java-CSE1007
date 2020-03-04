Run FX using
export PATH_TO_FX=path/to/javafx-sdk-11/lib
javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml HelloFX.java
java --module-path $PATH_TO_FX --add-modules javafx.controls HelloFX