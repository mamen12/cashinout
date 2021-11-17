
# Cashinout
is a study case of developing REST API using Springboot

## Prerequisites


* [Java SpringBoot](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)
* [Maven](https://maven.apache.org/download.cgi)
* [Postgres Sql](https://www.postgresql.org/download/)

## Installation
Use the package manager [maven](https://maven.apache.org/) to install and build cashinout app.

``` 
mvn clean install
```
Running apps
```
java -jar target/cashinout-0.0.1-SNAPSHOT.jar
```

# API

## ACCOUNT 

### CREATE ACCOUNT
```localhost:8082/api/register```
- Method Post with the contents of the body as below :
``` 
{
    
    "name":"Hugo",
    "email":"hugobara@example.com",
    "numberPhone":"08110001111",
    "address":"jl Matraman",
    "password":"12345678",
    "username":"hugo123"
}   
```
#### Response
```
{
    "id": "a16dc7b16704494d8f34b7627904701f",
    "name": "Hugo",
    "email": "hugobara@example.com",
    "numberPhone": "08110001111",
    "address": "jl Matraman",
    "username": "hugo123",
    "password": "$2a$10$yzE.Vb5MnePE6MkmYILuqu54vP5fBOBQs5vSQ.Y621651RNFIr7V6",
    "ballance": 0.0,
    "cashes": null
}
```
### SIGN IN ACCOUNT
```localhost:8081/api/signin```
- Method Post with the contents of the body as below :
```
{
    "username":"hugo123",
    "password":"12345678"
}
```
#### Response 
```
{
    "token": "eyJhbGciOiJIUzUxMiJ9.
    eyJ1c2VybmFtZSI6Imh1Z28xMjMiLCJzdWIiOiJodWdvMTIzIiwiaWF0IjoxNjM3MTI1MjU5LCJleHAiOjE2MzcxMjY0NTl9.
    wyJExZ6645RuozEqryZUb3x3VwOgcS4Fp8yvGP13cNxUyeUppE0xPIAvIoEl5_4jWHI9q9eEHPovSc78GDRBtA"
}
```


## Cash

### Create cash
``` localhost:8082/api/cash```
- Method Post with the contents of the body as below :

### Debit Cash
```
{
    "name":"Gaji November",
    "description": "Gaji bulan November",
    "amount": 4500000,
    "accountIdTransient" : "e92410326e9949f69308ebf2984bf67e"
}
```
### Credit Cash
```
{
    "name":"Sembako",
    "description": "pembelian sembako bulanan",
    "amount": -500000,
    "accountIdTransient" : "e92410326e9949f69308ebf2984bf67e"
}
```
### Delete Cash
```
localhost:8082/api/chases/61044d842fad4c0b82835ccffbc0421d
```

### Get All Cashes by type DEBIT
```
localhost:8082/api/cashes/debit
```
#### Ouput
```
[
    {
        "id": "81e5bb9a915c4e3bb50cd6468ab3e59a",
        "name": "Gaji Oktober",
        "slug": "Gaji-Oktober",
        "description": "Gaji bulan Oktober",
        "amount": 4500000.0,
        "type": "DEBIT",
        "whenTransaction": "2021-10-16",
        "accountIdTransient": null
    },
    {
        "id": "9482e03d042b4295ba6751ff03680567",
        "name": "Gaji November",
        "slug": "Gaji-November",
        "description": "Gaji bulan November",
        "amount": 4500000.0,
        "type": "DEBIT",
        "whenTransaction": "2021-11-16",
        "accountIdTransient": null
    }
]
```

### Get All Cashes by type CREDIT
```
localhost:8082/api/cashes/credit
```
#### Output
```
[
    {
        "id": "bbb4bf75c02149ebb44d165f45c37731",
        "name": "Pengeluaran bulanan",
        "slug": "Pengeluaran-bulanan",
        "description": "Beli Sembako, service motor",
        "amount": -1500000.0,
        "type": "CREDIT",
        "whenTransaction": "2021-11-16",
        "accountIdTransient": null
    }
]
```

## Get cashes By Id Account
```
localhost:8082/api/cashes/e92410326e9949f69308ebf2984bf67e
```
#### get cashes filter one month, first day of month  between last day of month
