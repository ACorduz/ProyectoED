import json
      
#primero se crea un diccionario
data = {} 

def emptyDic():
    global data
    data2 = {}
    data = data2


# Metodo para luego crer una lista dentro del dic
def createListInsideDic(name:str):
    data[name] = []

# metodo para normalizar stings 
def normalize(s):
    replacements = (
        ("á", "a"),
        ("é", "e"),
        ("í", "i"),
        ("ó", "o"),
        ("ú", "u"),
    )
    for a, b in replacements:
        s = s.replace(a, b).replace(a.upper(), b.upper())
    return s

# metodo para ingresar dato Usuario a Json 
def InputDataJsonUser(nameList:str, index:int, first_name:str,last_name:str, email:str, document:str, numberDocument:int, password:str, adress:str, locality:str):
    data[nameList].append({"index":index, 
                       "firs_name": normalize(first_name),
                       "last_name": normalize(last_name),
                       "email": normalize(email),
                       "document": document,
                       "numberDocument": numberDocument,
                       "password": normalize(password),
                       "adress": normalize(adress),
                       "locality": normalize(locality)
    })

# metodo para ingresar dato Producto
def InputDataJsonProduct_food(nameList:str,index:int,typeProduct:str,nameProduct:str, quantity:int ,emailDonor:str, expirationDateYear:int, expirationDateMonth:int, expirationDateDay:int):
    data[nameList].append({
        "index":index,
        "typeProduct": typeProduct, # este valor probablemente null
        "nameProduct": normalize(nameProduct),
        "quantity": quantity,
        "emailDonor": normalize(emailDonor), # este tambien 
        "expirationDateYear": expirationDateYear,
        "expirationDateMonth": expirationDateMonth,
        "expirationDateDay": expirationDateDay

    })

# meotodo para crear archivo 
def CreateFile(nameFile, indexFinal):
    with open(nameFile+".json","w") as file:
        json.dump(data,file,indent= 4)
    print(f"fueron creada correctamente {indexFinal} columnas")

# InputDataJsonUser(data["Users"],"jk","jk","jk","jk","jk","jk","jk")
# print(data.get("Users"))
#[{"id":1,"first_name":"Sidoney","last_name":"Trengrove","email":"strengrove0@paginegialle.it","document":"4 281 005 615","password":"mL4398a","address":"Transversal 89# 12-10","locality":"Bogotá"}