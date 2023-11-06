from faker import Faker
import random 
import CreateJson
import string

fake = Faker("es_CO") # idioma en español y cosas colombianas

# TipoDeDocumentoFalso
def tipo_documento_falso():
    tipos_documento = ["CC", "TI", "CE", "PA", "RC"]
    tipo_documento = random.choice(tipos_documento)
 # Genera un número de 8 dígitos
    return (f"{tipo_documento}")

# numeroDeDocumentoFalso
def numero_documento_falso():
    numero = "".join(random.choices(string.digits, k=8)) 
    return (numero)


# Función para generar una contraseña falsa
def contrasena_falsa():
    longitud = random.randint(8, 12)  # Longitud de contraseña entre 8 y 12 caracteres
    caracteres = string.ascii_letters + string.digits + string.punctuation
    return "".join(random.choice(caracteres) for _ in range(longitud))

def nombre_producto_comida():
    productos_supermercado = [
    "Arroz","Fideos", "Pan","Leche","Huevos","Aceite de cocina","Sal",
    "Azúcar","Harina","Pasta de tomate","Sopa enlatada","Cereales",
    "Yogur","Queso","Pollo","Carne de res","Pescado","Verduras frescas",
    "Frutas frescas","Papas","Cebollas","Ajo","Pimienta","Cerveza","Vino",
    "Refrescos","Agua embotellada","Galletas","Chocolate","Café",
    "Té","Mermelada","Mantequilla","Yogur","Helado","Salsa de tomate",
    "Mayonesa","Mostaza","Ketchup","Aceitunas","Salsa de soja",
    "Cereal para el desayuno","Pan integral","Sopa enlatada","Salsa de spaghetti","Galletas saladas",
    "Frijoles enlatados","Salsa de manzana","Frutas enlatadas","Frutos secos",
    "Ajo","Cebollas","Manzana", "Plátano", "Fresas", "Pasta", "Arroz", "Leche", "Pan", "Queso", "Tomates", "Cereal"
    ]
    return random.choice(productos_supermercado)


def enterDataUser(numberData:int, nameFile:str, nameListInsideDic:str):
    indexFinal = 0
    for i in range(numberData):
        first_name = fake.first_name()
        #print(first_name)
        last_name = fake.last_name()
        #print(last_name)
        email = fake.email()
        #print(email)
        document = tipo_documento_falso()
        #print(document)
        numberDocument =  numero_documento_falso()
        locality = fake.municipality()
        #print(locality)
        adress = fake.street_address()
        #print(direccion)
        password = contrasena_falsa()
        #AHORA poner en el json
        CreateJson.InputDataJsonUser(nameListInsideDic, i+1,first_name,last_name, email, document, numberDocument, password, adress, locality)
        indexFinal+=1
    # luego de terminado el bucle
    CreateJson.CreateFile(nameFile, indexFinal)


def enterDataProduct_Food(numberData:int, nameFile:str, nameListInsideDic:str):
    indexFinal = 0
    for i in range(numberData):
        typeProduct = "Food"  # este valor cuando sean varios productos definirlo mejor
        nameProduct = nombre_producto_comida()
        quantity = random.randint(0, 100)
        emailDonor = fake.email()# no sabemos quien es
        expirationDateYear = random.randint(2023, 2025)
        expirationDateMonth = random.randint(1, 12)
        expirationDateDay = random.randint(1, 28) # hasta 28 invalidar fechas no validas
        #AHORA poner en el json
        CreateJson.InputDataJsonProduct_food(nameListInsideDic, i+1,typeProduct,nameProduct, quantity, emailDonor, expirationDateYear, expirationDateMonth, expirationDateDay)
        indexFinal+=1
    # luego de terminado el bucle
    CreateJson.CreateFile(nameFile,indexFinal)


# este metodo es para crear archivos json 
def ProcessFileAndCreateFileJson(numberRows:int, nameFile:str, typeOfData:int):
    """Este metodo crea los archivos json 

    Args:
        numberRows (int): numero de filas
        nameFile (str): nombre del archivo
        typeOfData (int): si es 0 usuarios, 1 para Productos de comida
    """
    if(typeOfData == 0):
        nameListInsideDic = "users"
        CreateJson.createListInsideDic(nameListInsideDic)
        enterDataUser(numberRows,nameFile,nameListInsideDic) 
    elif(typeOfData == 1):
        nameListInsideDic = "productFood"
        CreateJson.createListInsideDic(nameListInsideDic)
        enterDataProduct_Food(numberRows,nameFile,nameListInsideDic) 
    else:
        print("error in type of data, No soported yet")


