# verzel-back

Funcionalidades do backend

- API Rest para veículos completa ( CRUD ) ✔️
- Validação de adm ✔️
- ROLE de ADMIN ✔️
- Geração do tokenJWT no formato HMAC256 ✔️
- Subir API para o ec2 da AWS ✔️
  

# Tecnologias

- Linguagem escolhida: Java
- Banco de dados escolhido: mongoDB
- Serviço da AWS usado: EC2

# Conexões

### Banco de dados
 Para ter acesso as Collections do MongoDB precisará seguir os passos:

  1. Acesse o site -> https://account.mongodb.com/account/login?nds=true&_ga=2.165071350.894600225.1698759725-1619709536.1698759625 ( mongoDB Atlas )
  2. Clique no botao de conectar com Google
  3. Use as seguintes credenciais -> email: provaverzel@gmail.com ; senha: verzel123
  4. Após conectar ao dashboard, no menu lateral à esquerda na aba "Deployment" clique no item "Database"
  5. No centro da tela, irá aparecer algumas informações sobre o Cluster criado. no Header desse Cluster possui alguns botões ( "connect", "View Monitoring", "Browse Collections"), clique em "Browse Collections"


### AWS
  A API está sendo executada em uma instância no serviço da AWS chamado EC2. a URL padrão da api é: http://ec2-15-228-78-229.sa-east-1.compute.amazonaws.com:8080 . A partir dessa url, possui as rotas que estão demarcadas no package de controllers do projeto 


# Observações

Não foi utilizado lombok por questões de instalação

