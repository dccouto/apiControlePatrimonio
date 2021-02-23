<a id="inicio"></a>
# Desafio Java - REST API - Patrimônio

O [**patrimônio**] disponibiliza uma API REST que disponibliza os recursos para realizar o controle de inventário de uma empresa ou afins.


Recursos disponíveis para acesso via API:
* [**Marca**](#marca)
* [**Patrimônio**](#patrimônio)
* [**Usuários**](#usuarios)

## Informações importantes
### Banco de dados
+ A API utiliza banco de dados em memória, não sendo necessário a instalação do mesmo.
+ Ao iniciar a aplicação a API irá popular a base de dados com algumas entradas para teste. O arquivo está no diretório `src/main/resources/data.sql`
+ Usuario padrão pré cadastrado: username `diego@email.com` senha:`123456`
+ Para acessar o Banco de dados utilize o link: http://localhost:8080/h2-console/login.jsp
+ Dados para acesso `JDBC URL: jdbc:h2:mem:navita-patrimonio` `User Name: sa`



## Métodos
Requisições para a API devem seguir os padrões:
| Método | Descrição |
|---|---|
| `GET` | Retorna informações de um ou mais registros. |
| `POST` | Utilizado para criar um novo registro. |
| `PUT` | Atualiza dados de um registro ou altera sua situação. |
| `DELETE` | Remove um registro do sistema. |

+ Request (application/json)

    + Headers

            Authorization: Bearer [access_token]





# Autenticação

Nossa API utiliza [JSON Web Token] como forma de autenticação/autorização.

Para utilizar a API, você precisará utilizar uma das seguintes opções:

1. Utilizar um dos usuários pré-cadastrado na base de dados:

2. Cadastrar um `email`, `senha` e definir um `nome` de usuário, utilizados na solicitação de acesso;

+ Request (application/json) (`POST`)

    + Body

            {
                "email": "diego@email.com",
                "senha": "123456" 
            }



+ Response 200 (application/json)
	
	+ Body
	
			{
				"token": "eyJhbGciOiJIUzI1NiJ9.eyJpc3MMTM5MzI1NzIsImV4cCI6MTYxMzk0MjU3Mn0.R2TOATe_6GrZhLFoHes6xI2YX_jj8jJKt7EzRqPfwhU",
				"tipo": "Bearer"					
			}

*Para realizar o `login` deve-se informa o `e-mail` e a `senha`.*

---

# Group Recursos

<a id="usuario"></a>
# Usuario [/api/usuario]

Cadastra um novo usuário no sistema

### Criar usuário (Create) [POST /cadastrar]
`http://localhost:8080/api/usuario/cadastrar`

+ Attributes (object)

    + nome: nome do usuário (string, required)
    + email: email do usuario que será utilizado para realizar o login (string, required)
	+ senha: senha do usuário (string, required)

+ Request (application/json)

    + Body

```json
{
    "nome": "user_1",
    "email": "user_1@email.com",
    "senha": "123456"
}
```

+ Response 201 (application/json)

<a id="marca"></a>
# Marca [/api/marca]

As marcas que podem ser consultadas e adicionadas referentes ao itens do inventário.

### Cadastrar marca (Create) [POST /cadastrar]
`http://localhost:8080/api/marca/cadastrar`

+ Request (application/json)

    + Headers

            Authorization: Bearer [access_token]

    + Body

```json
{
    "nome": "Dell"
}
```

+ Response 201 (application/json)
	
	+ Body
	
```json
{
    "idMarca": 1,
    "nome": "Dell"
}
```

+ Response 204 (application/json)

### Listar todas as Marcas cadastradas (Read) [GET]
`http://localhost:8080/api/marca`
	
+ Request (application/json)

    + Headers

            Authorization: Bearer [access_token]

+ Response 200 (application/json)

    + Body
	
```json
[
    {
        "idMarca": 1,
        "nome": "Dell"
    },
    {
        "idMarca": 2,
        "nome": "CCE"
    }
]
```

### Buscar marca por id (Read) [GET /{id}]
`http://localhost:8080/api/marca/1`

+ Parameters
	+ id (required, id, `1`) ... ID da Marca

+ Request (application/json)

    + Headers

            Authorization: Bearer [access_token]

+ Response 200 (application/json)

    + Body
	
```json
{
    "idMarca": 1,
    "nome": "Dell"
}
```

### Atualizar marca (Update) [PUT /atualizar/{id}]
`http://localhost:8080/api/marca/atualizar/1`

+ Parameters
    + id (required, number, `1`) ... ID da Marca

+ Request (application/json)

    + Headers

            Authorization: Bearer [access_token]

    + Body

```json
{
    "nome": "Lenovo"
}
```

+ Response 200 (application/json)
	
	+ Body
	
```json
{
    "idMarca": 1,
    "nome": "Lenovo"
}
```

<a id="patrimonio"></a>
# Patrimônio [/api/patrimonio]

Cria e consulta as informações do patrimônio

### Cadastrar informações do objeto a ser inventariado (Create) [POST /cadastrar]
`http://localhost:8080/api/patrimonio/cadastrar`

+ Request (application/json)

    + Headers

            Authorization: Bearer [access_token]

    + Body

```json
{
    "nome": "Monitor",
    "descricao": "sala de TI3",
    "marca": {
        "idMarca": 1
    }
}
```

+ Response 201 (application/json)
	
	+ Body
	
```json
{
    "idPatrimonio": 3,
    "nome": "Monitor",
    "descricao": "sala de TI3",
    "numeroTombo": 3,
    "marca": {
        "idMarca": 1,
        "nome": null
    }
}
```			

### Listar todas os Patrimônios cadastrados (Read) [GET /buscar]
`http://localhost:8080/api/patrimonio/buscar`
	
+ Request (application/json)

    + Headers

            Authorization: Bearer [access_token]

+ Response 200 (application/json)

    + Body
	
```json
[
    {
        "idMarca": 1,
        "nome": "Monitor",
        "descricao": "sala de TI3",
        "numeroTombo": 1,
        "marca": {
            "idMarca": 1,
            "nome": "Dell"
        }
    },
    {
        "idMarca": 2,
        "nome": "Teclado",
        "descricao": "sala de Conferência",
        "numeroTombo": 2,
        "marca": {
            "idMarca": 1,
            "nome": "Dell"
        }
    }
]
```

### Listar o Patrimônio cadastrado por ID (Read) [GET /buscar/{id}]
`http://localhost:8080/api/patrimonio/buscar/1`

+ Parameters
    + id (required, number, `1`) ... ID do Patrimônio

+ Request (application/json)

    + Headers

            Authorization: Bearer [access_token]

+ Response 200 (application/json)
	
	+ Body
	
```json
{
    "idPatrimonio": 1,
    "nome": "Monitor",
    "descricao": "sala de TI3",
    "numeroTombo": 1,
    "marca": {
        "idMarca": 1,
        "nome": "Lenovo"
    }
}
```

### Buscar o Patrimônio cadastrado por número do inventário (Read) [GET /buscar/numero-tombo/{id}]
`http://localhost:8080/api/patrimonio/buscar/numero-tombo/1`

+ Parameters
    + id (required, number, `1`) ... Numero do inventário

+ Request (application/json)

    + Headers

            Authorization: Bearer [access_token]

+ Response 200 (application/json)
	
	+ Body
	
```json
{
    "idPatrimonio": 1,
    "nome": "Monitor",
    "descricao": "sala de TI3",
    "numeroTombo": 1,
    "marca": {
        "idMarca": 1,
        "nome": "Lenovo"
    }
}
```

[Início](#inicio)
