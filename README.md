# Test-BackEnd Incaas

## Sobre o Projeto
Uma API onde gerencia Processos Juridicos e Audiencias, pode filtrar por local, comarca, verificar lista de audiencia de uma determinada comarca, encontrar processos ou  audiencias .
<br> 
API Construida com java e SpringBoot
### GET PROCESSOS
`GET /processos`
``` json
[
    {
        "id": 1,
        "numeroProcesso": "2345678-12.2023.8.26.0101",
        "vara": "1 Vara Civel",
        "comarca": "Campinas",
        "status": "ATIVO"
    },
    {
        "id": 2,
        "numeroProcesso": "3456789-34.2023.8.26.0102",
        "vara": "3 Vara de Familia",
        "comarca": "Santos",
        "status": "SUSPENSO"
    },
    {
        "id": 3,
        "numeroProcesso": "4567890-56.2023.8.26.0103",
        "vara": "5 Vara Criminal",
        "comarca": "Ribeirao Preto",
        "status": "ARQUIVADO"
    },
    {
        "id": 4,
        "numeroProcesso": "5678901-78.2023.8.26.0104",
        "vara": "2 Vara Civel",
        "comarca": "Osasco",
        "status": "ATIVO"
    },
    {
        "id": 5,
        "numeroProcesso": "6789012-90.2023.8.26.0105",
        "vara": "4 Vara do Trabalho",
        "comarca": "Osasco",
        "status": "ATIVO"
    }
]
```
### Filtrando Status e Comarca
`GET /processos/comarca/status?comarca=osasco&status=ativo`

``` json
[
    {
        "id": 4,
        "numeroProcesso": "5678901-78.2023.8.26.0104",
        "vara": "2 Vara Civel",
        "comarca": "Osasco",
        "status": "ATIVO"
    },
    {
        "id": 5,
        "numeroProcesso": "6789012-90.2023.8.26.0105",
        "vara": "4 Vara do Trabalho",
        "comarca": "Osasco",
        "status": "ATIVO"
    }
]
```
### GET AUDIENCIAS
`GET /audiencias`
``` json
[
    {
        "id": 1,
        "dataAudiencia": "2025-06-20",
        "hora": "14:30",
        "local": "Fórum Central - Sala 2",
        "tipoAudiencia": "INSTRUCAO",
        "processoJudicial": {
            "id": 1,
            "numeroProcesso": "2345678-12.2023.8.26.0101",
            "vara": "1 Vara Civel",
            "comarca": "Campinas",
            "status": "ATIVO"
        }
    },
    {
        "id": 2,
        "dataAudiencia": "2025-06-20",
        "hora": "09:00",
        "local": "Fórum Central - Sala 1",
        "tipoAudiencia": "CONCILIACAO",
        "processoJudicial": {
            "id": 1,
            "numeroProcesso": "2345678-12.2023.8.26.0101",
            "vara": "1 Vara Civel",
            "comarca": "Campinas",
            "status": "ATIVO"
        }
    },
    {
        "id": 3,
        "dataAudiencia": "2025-06-19",
        "hora": "11:30",
        "local": "Fórum Central - Sala 3",
        "tipoAudiencia": "JULGAMENTO",
        "processoJudicial": {
            "id": 3,
            "numeroProcesso": "4567890-56.2023.8.26.0103",
            "vara": "5 Vara Criminal",
            "comarca": "Ribeirao Preto",
            "status": "ARQUIVADO"
        }
    },
    {
        "id": 4,
        "dataAudiencia": "2025-06-25",
        "hora": "14:00",
        "local": "Fórum Central - Sala 2",
        "tipoAudiencia": "INSTRUCAO",
        "processoJudicial": {
            "id": 4,
            "numeroProcesso": "5678901-78.2023.8.26.0104",
            "vara": "2 Vara Civel",
            "comarca": "Osasco",
            "status": "ATIVO"
        }
    },
    {
        "id": 5,
        "dataAudiencia": "2025-06-10",
        "hora": "15:30",
        "local": "Fórum Central - Sala 1",
        "tipoAudiencia": "CONCILIACAO",
        "processoJudicial": {
            "id": 5,
            "numeroProcesso": "6789012-90.2023.8.26.0105",
            "vara": "4 Vara do Trabalho",
            "comarca": "Osasco",
            "status": "ATIVO"
        }
    }
]
```
### retorna a agenda de audiências de uma comarca em um determinado dia
`GET /audiencias/data/comarca?data=2025-06-20&comarca=Campinas`
``` json
[
    {
        "id": 1,
        "dataAudiencia": "2025-06-20",
        "hora": "14:30",
        "local": "Fórum Central - Sala 2",
        "tipoAudiencia": "INSTRUCAO",
        "processoJudicial": {
            "id": 1,
            "numeroProcesso": "2345678-12.2023.8.26.0101",
            "vara": "1 Vara Civel",
            "comarca": "Campinas",
            "status": "ATIVO"
        }
    },
    {
        "id": 2,
        "dataAudiencia": "2025-06-20",
        "hora": "09:00",
        "local": "Fórum Central - Sala 1",
        "tipoAudiencia": "CONCILIACAO",
        "processoJudicial": {
            "id": 1,
            "numeroProcesso": "2345678-12.2023.8.26.0101",
            "vara": "1 Vara Civel",
            "comarca": "Campinas",
            "status": "ATIVO"
        }
    }
]
```
### POST
### Não deve permitir sobreposição de audiências na mesma vara e local
vou mostrar um exemplos excutando duas vezes o post
`POST /audiencias`
``` json
{
        "dataAudiencia": "2025-06-20",
        "hora": "11:30",
        "local": "Fórum Central - Sala 4",
        "tipoAudiencia": "JULGAMENTO",
        "processoJudicialId": 1
        }
```
retorna 201 Created dizendo que foi um sucesso o post
``` json
{
    "id": 6,
    "dataAudiencia": "2025-06-20",
    "hora": "11:30",
    "local": "Fórum Central - Sala 4",
    "tipoAudiencia": "JULGAMENTO",
    "processoJudicial": {
        "id": 1,
        "numeroProcesso": "2345678-12.2023.8.26.0101",
        "vara": "1 Vara Civel",
        "comarca": "Campinas",
        "status": "ATIVO"
    }
}
```
Mas se tentar execulta com o vara,local,data e hora
``` json
{
    "timestamp": "2025-06-10T16:17:20Z",
    "statusDetails": 400,
    "error": "argumentos passados na vara e local",
    "message": "local: Fórum Central - Sala 4 vara: 1 Vara Civel ja estão ocupados neste mesmo horario e dia",
    "path": "/audiencias"
```
### - Caso o processo esteja supenso ou Arquivado
``` json
 "dataAudiencia": "2025-06-20",
        "hora": "17:30",
        "local": "Fórum Central - Sala 4",
        "tipoAudiencia": "JULGAMENTO",
        "processoJudicialId": 2
        }
```
ele não cria a audiencia 
``` json
{
    "timestamp": "2025-06-10T16:28:32Z",
    "statusDetails": 400,
    "error": "o processo não pode esta suspenso ou arquivado",
    "message": "o status do processo não permite a criação de audiencia SUSPENSO",
    "path": "/audiencias"
}
```
### - Caso a audiencia tente ser marcada em fins de semana (Dia 21 Sábado)
``` json
{
        "dataAudiencia": "2025-06-21",
        "hora": "17:30",
        "local": "Fórum Central - Sala 4",
        "tipoAudiencia": "JULGAMENTO",
        "processoJudicialId": 1
        }
```
a audiencia não será marcada
``` json
{
    "timestamp": "2025-06-10T16:35:09Z",
    "statusDetails": 400,
    "error": "não pode marca uma audiencia em fins de semana",
    "message": "dia invalido não poder ser fins de semana: SATURDAY",
    "path": "/audiencias"
}
```
