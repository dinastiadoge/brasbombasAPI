# brasbombasAPI
Protótipo de interface para o gerenciamento do banco de dados.

## Instruções para execução da aplicação:
- É necessário um compilador java para executar a aplicação localmente ou carregar o .jar da aplicação num servidor como os da AWS.
- Para o envio de requisições é necessário o uso de um aplicativo de teste como o PostMan ou testar num navegador.
- Para realizar corretamente a conexão ao banco de dados é necessário configurar a String de conexão no arquivo application.properties.
  
Obs: Atenção para enviar requisições com POST e PUT é preciso enviar os dados formatados no BODY da requisição.

GET:
<br>seuendereço/bombas
<br>seuendereço/compras
<br>seuendereço/clientes
<br>seuendereço/produtos

DELETE:
<br>seuendereço/bombas/id
<br>seuendereço/compras/id
<br>seuendereço/clientes/id
<br>seuendereço/compras/id

PUT:
<br>seuendereço/bombas/id
<br>seuendereço/compras/id
<br>seuendereço/clientes/id
<br>seuendereço/compras/id

POST:
body do produto:
{
    "nome":"produto",
    "marca": "marca",
    "quantidade": "100"
}

body da compra:
{
    "cliente": 1,
    "produto_nome": "produto",
    "quantidade": 99
}

body do cliente:
{
    "cpf": 1,
    "nome": "teste",
    "cep": "111111",
    "numero": 111,
    "telefone": "1111111"
}

body da bomba:
{
    "os":5001,
    "marca":"Schneider",
    "modelo":"Alta pressaaum",
    "potencia":"20cv",
    "voltagem":"480v",
    "descricao":"A bomba não está mandando água, rotor foi trocado recentemente.",
    "cliente_cpf" : 1,
    "status" : "ORCAMENTO",
    "valor" : 200.00
}

## Diagrama conceitual e lógico:
<br><img src = "Diagramas/Brasbombasconceitual.png" width="100%"> 
<br><img src = "Diagramas/Brasbombaslogico.png" width="100%">
## Mapeamento das requisições:
<br><img src = "Diagramas/brasbombasrequest.drawio.png" width="100%">
