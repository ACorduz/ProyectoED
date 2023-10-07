import CreateData 
# EJECCUTAR PROCESOS    
# para saber como funciona ProcessFileAndCreateFileJson mirar el metodo pasando el mouse sobre el 
rows_pruebaUser = int(input("Cuantas filas para pruebaUser json"))
rows_pruebaFood = int(input("Cuantas filas para pruebaFood json"))
CreateData.ProcessFileAndCreateFileJson(rows_pruebaUser,"pruebaUsers", 0)
CreateData.ProcessFileAndCreateFileJson(rows_pruebaFood, "pruebaFood", 1)