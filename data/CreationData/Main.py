import CreateData 
# EJECCUTAR PROCESOS    
# para saber como funciona ProcessFileAndCreateFileJson mirar el metodo pasando el mouse sobre el 
rows_FakeDataUsers = int(input("Cuantas filas para primer archivo de usuarios json: "))
nameFile_FakeDataUsers  = "jsonFakeDataUsers_"+ str(rows_FakeDataUsers)
rows_FakeDataFood = int(input("Cuantas filas para segundo archivo de prductos_comida json: "))
nameFile_FakeDataFood = "jsonFakeDataFood_"+ str(rows_FakeDataFood)

CreateData.ProcessFileAndCreateFileJson(rows_FakeDataUsers,nameFile_FakeDataUsers, 0)
print("primer json termiando satisfactoriamente")
# PASAR AL SEGUNDO JSON
CreateData.CreateJson.emptyDic()
CreateData.ProcessFileAndCreateFileJson(rows_FakeDataFood, nameFile_FakeDataFood, 1)
print("segundo json termiando satisfactoriamente")