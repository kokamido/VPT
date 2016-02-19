cd libs
javac Message.java
javadoc -d html Message.java
cd ..
cd core
javac -cp /home/andrey/Desktop/kek MicroCore.java
javadoc -d html MicroCore.java
cd ..
cd inventory
javac -cp /home/andrey/Desktop/kek Inventory.java
javadoc -d html Inventory.java
cd ..
javac -cp /home/andrey/Desktop/kek Init.java
cd ..
