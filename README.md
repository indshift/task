#task1 taskgenerator
#task2 statisticalanalysis

Для сборки проекта зайдите в соответствующую папку и воспользуйтесь maven,
выполнив команду mvn clean package

Для запуска приложений
1. Подготовьте текстовый файл с названиями (номерами) точек продаж:
   одно слово в строке;
2. Откройте консоль, перейдите в папку расположения jar-архива и запустите 
соответствующую команду.

Примеры команд для запуска приложений

#task1: java -jar task1.jar offices.txt 3 ops1.txt ops2.txt ops3.txt, 
где offices.txt - входные данные, 3 - число операций, ops1.txt ops2.txt ops3.txt -
файлы с выходыми данными. Первые три парамерта после task1.jar обязательны.
Число файлов с выходными параметрами может быть равным одному и более. 

#task1: java -jar task2.jar stats-dates.txt stats-offices.txt ops1.txt ops2.txt ops3.txt
где stats-dates.txt stats-offices.txt - файлы с выходыми данными.
ops1.txt ops2.txt ops3.txt - файлы с входными данными.
Первые три парамерта после task2.jar обязательны.
Число файлов с входными параметрами может быть равным одному и более. 

